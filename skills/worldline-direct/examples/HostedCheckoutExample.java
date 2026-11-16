package examples;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.onlinepayments.ApiException;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.communication.CommunicationException;
import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.CreateHostedCheckoutRequest;
import com.onlinepayments.domain.CreateHostedCheckoutResponse;
import com.onlinepayments.domain.GetHostedCheckoutResponse;
import com.onlinepayments.domain.HostedCheckoutSpecificInput;
import com.onlinepayments.domain.Order;
import com.onlinepayments.domain.OrderReferences;
import com.onlinepayments.domain.PaymentResponse;
import com.onlinepayments.merchant.MerchantClientInterface;

public class HostedCheckoutExample {

    private static final Logger LOGGER = Logger.getLogger(HostedCheckoutExample.class.getName());

    private final MerchantClientInterface merchantClient;
    private final OrderStore orders;
    private final PaymentStatusExample paymentStatus;
    private final String publicBaseUrl;

    // publicBaseUrl: the absolute public base URL of your shop from your configuration, e.g. https://shop.example
    public HostedCheckoutExample(MerchantClientInterface merchantClient, OrderStore orders, String publicBaseUrl) {
        this.merchantClient = merchantClient;
        this.orders = orders;
        this.paymentStatus = new PaymentStatusExample(merchantClient, orders);
        this.publicBaseUrl = publicBaseUrl;
    }

    // [START hosted-checkout-create]
    // Returns the URL to redirect the customer to.
    public String startCheckout(String orderId, long amountInCents, String currencyCode) throws InterruptedException {
        CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequest()
                .withOrder(new Order()
                        .withAmountOfMoney(new AmountOfMoney().withAmount(amountInCents).withCurrencyCode(currencyCode))
                        .withReferences(new OrderReferences().withMerchantReference(orderId)))
                .withHostedCheckoutSpecificInput(new HostedCheckoutSpecificInput()
                        .withReturnUrl(buildReturnUrl(orderId))
                        .withLocale("en-GB"));

        CreateHostedCheckoutResponse response = createHostedCheckoutWithRetry(request);

        // Store both values with the order before the customer leaves your site.
        orders.saveHostedCheckout(orderId, response.getHostedCheckoutId(), response.getRETURNMAC());

        // Redirect to this URL exactly as returned. Do not build it from getPartialRedirectUrl().
        return response.getRedirectUrl();
    }

    // The base URL comes from your configuration, never from the Host header of the request, which the sender
    // controls. "/return" is the path of your return handler. Escape the order reference for the query string.
    String buildReturnUrl(String orderId) {
        String base = publicBaseUrl.endsWith("/") ? publicBaseUrl.substring(0, publicBaseUrl.length() - 1) : publicBaseUrl;
        try {
            return base + "/return?orderId=" + URLEncoder.encode(orderId, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e); // UTF-8 is always supported
        }
    }
    // [END hosted-checkout-create]

    // [START hosted-checkout-retry]
    // CreateHostedCheckout does not support idempotent requests: the platform ignores an idempotence key, so every
    // resend creates a new session. That is harmless until the customer pays in it; the unused session expires.
    // Send it again after no answer or after an error marked retriable. The waiting happens inside the customer's
    // request, so the browser waits too: keep the attempts few and the delays short, or move the call to a
    // background job.
    CreateHostedCheckoutResponse createHostedCheckoutWithRetry(CreateHostedCheckoutRequest request)
            throws InterruptedException {
        for (int attempt = 1; ; attempt++) {
            try {
                return merchantClient.hostedCheckout().createHostedCheckout(request);
            } catch (CommunicationException e) {
                // No answer (timeout, connection error).
                if (attempt >= 3) {
                    throw e;
                }
                Thread.sleep(1000L * attempt);
            } catch (ApiException e) {
                // The error of a Hosted Checkout call is a plain error response (error ID and errors), so logging
                // it is fine here; log at least the error ID, status and error codes.
                LOGGER.warning("createHostedCheckout failed, errorId " + e.getErrorId() + ", status " + e.getStatusCode()
                        + ": " + e.getErrors().stream()
                        .map(error -> error.getErrorCode() + " " + error.getPropertyName())
                        .collect(Collectors.joining("; ")));
                boolean retriable = e.getErrors().stream().anyMatch(error -> Boolean.TRUE.equals(error.getRetriable()));
                if (attempt >= 3 || !retriable) {
                    throw e; // other errors reach the caller
                }
                // Marked retriable: the request was not processed. Send it again.
                Thread.sleep(1000L * attempt);
            }
        }
    }
    // [END hosted-checkout-retry]

    // [START hosted-checkout-return]
    // Called when the customer comes back on your return URL.
    public OrderPaymentState handleReturn(String orderId, String returnMacFromQuery) {
        OrderStore.StoredHostedCheckout stored = orders.getHostedCheckout(orderId);

        // The platform appends RETURNMAC to the return URL. It identifies the returning customer:
        // a missing or different value means the request does not belong to this checkout.
        if (!returnMacMatches(returnMacFromQuery, stored.getReturnMac())) {
            throw new IllegalStateException("RETURNMAC does not match the stored value for order " + orderId);
        }

        // Never trust the redirect alone: read the result from the platform.
        GetHostedCheckoutResponse hostedCheckout;
        try {
            hostedCheckout = merchantClient.hostedCheckout().getHostedCheckout(stored.getHostedCheckoutId());
        } catch (ReferenceException e) {
            // The API reference documents a 404 for this call. If it fails with not found, read the payment
            // instead, with the payment ID that your webhook handler stored. Other errors reach the caller,
            // including the 409 and 410 that the SDK also raises as ReferenceException.
            if (e.getStatusCode() != 404) {
                throw e;
            }
            LOGGER.warning("getHostedCheckout failed, errorId " + e.getErrorId() + ", status " + e.getStatusCode());
            if (orders.getPaymentId(orderId) == null) {
                // No payment ID yet: do not mark the order failed. The webhook or your reconciliation job settles it.
                return OrderPaymentState.PENDING;
            }
            return paymentStatus.refreshPaymentState(orderId);
        }

        if ("PAYMENT_CREATED".equals(hostedCheckout.getStatus())) {
            PaymentResponse payment = hostedCheckout.getCreatedPaymentOutput().getPayment();
            orders.savePaymentId(orderId, payment.getId());
            OrderPaymentState state = PaymentStatusExample.toOrderState(payment.getStatus(), payment.getStatusOutput());
            orders.saveState(orderId, state);
            return state;
        }
        if ("CANCELLED_BY_CONSUMER".equals(hostedCheckout.getStatus())) {
            // The customer cancelled, or the session expired (the created payment is then cancelled with the
            // error id CANCELLED_BY_EXPIRATION).
            orders.saveState(orderId, OrderPaymentState.CANCELLED);
            return OrderPaymentState.CANCELLED;
        }
        // IN_PROGRESS: the customer has not finished. A webhook will report the result.
        return OrderPaymentState.PENDING;
    }

    // Constant-time comparison (MessageDigest.isEqual), so the time taken does not reveal how much matched.
    private static boolean returnMacMatches(String fromQuery, String stored) {
        if (fromQuery == null || fromQuery.isEmpty() || stored == null || stored.isEmpty()) {
            return false;
        }
        return MessageDigest.isEqual(fromQuery.getBytes(StandardCharsets.UTF_8), stored.getBytes(StandardCharsets.UTF_8));
    }
    // [END hosted-checkout-return]
}
