package examples;

import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.onlinepayments.ApiException;
import com.onlinepayments.CallContext;
import com.onlinepayments.DeclinedPaymentException;
import com.onlinepayments.IdempotenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.communication.CommunicationException;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.PaymentDetailsResponse;
import com.onlinepayments.merchant.MerchantClientInterface;

public class ErrorHandlingExample {

    private static final Logger LOGGER = Logger.getLogger(ErrorHandlingExample.class.getName());

    private final MerchantClientInterface merchantClient;
    private final OrderStore orders;

    public ErrorHandlingExample(MerchantClientInterface merchantClient, OrderStore orders) {
        this.merchantClient = merchantClient;
        this.orders = orders;
    }

    // [START error-handling]
    // idempotenceKey is the stored key of the payment attempt (PaymentAttempt.keyFor). Reuse it when a request
    // got no answer; replace it, stored again, only when the platform answered with an error marked retriable.
    public PaymentStep createPayment(String orderId, CreatePaymentRequest request, String idempotenceKey)
            throws InterruptedException {
        CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);
        for (int attempt = 1; ; attempt++) {
            try {
                CreatePaymentResponse response = merchantClient.payments().createPayment(request, context);
                return CreatePaymentResponseHandler.handle(response, orderId, orders);
            } catch (DeclinedPaymentException e) {
                // The payment exists but was declined. Read its status before deciding anything.
                String paymentId = e.getCreatePaymentResponse() != null && e.getCreatePaymentResponse().getPayment() != null
                        ? e.getCreatePaymentResponse().getPayment().getId()
                        : null;
                if (paymentId == null) {
                    orders.saveState(orderId, OrderPaymentState.FAILED);
                    return PaymentStep.done(OrderPaymentState.FAILED);
                }
                orders.savePaymentId(orderId, paymentId);
                PaymentDetailsResponse details = merchantClient.payments().getPaymentDetails(paymentId);
                OrderPaymentState state = PaymentStatusExample.toOrderState(details.getStatus(), details.getStatusOutput());
                orders.saveState(orderId, state);
                return PaymentStep.done(state);
            } catch (IdempotenceException e) {
                // The first request with this key is still running. Wait, then send the same request again.
                if (attempt >= 3) {
                    throw e;
                }
                Thread.sleep(2000L * attempt);
            } catch (CommunicationException e) {
                // Timeout or connection error: the payment may or may not exist. Retry with the same key;
                // the platform returns the original result instead of creating a second payment.
                if (attempt >= 3) {
                    throw e;
                }
                Thread.sleep(2000L * attempt);
            } catch (ValidationException e) {
                // 400: the request is invalid. Fix the request; retrying does not help.
                // Log the error codes and the error ID, never the request (it can hold card data).
                LOGGER.severe("createPayment rejected, errorId " + e.getErrorId() + ": " + e.getErrors().stream()
                        .map(error -> error.getErrorCode() + " " + error.getPropertyName())
                        .collect(Collectors.joining("; ")));
                throw e;
            } catch (ApiException e) {
                // A technical error marked retriable: the request was not processed.
                // Send it again with a new key, stored before the call like the first one.
                // Other errors are not retried: AuthorizationException (403, wrong API key, secret or merchant ID),
                // ReferenceException (404, 409, 410), PlatformException without a retriable error, other ApiException.
                if (attempt >= 3 || !isRetriable(e)) {
                    throw e;
                }
                context = new CallContext().withIdempotenceKey(PaymentAttempt.start(orderId, orders));
                Thread.sleep(2000L * attempt);
            }
        }
    }

    private static boolean isRetriable(ApiException e) {
        return e.getErrors() != null && e.getErrors().stream().anyMatch(error -> Boolean.TRUE.equals(error.getRetriable()));
    }
    // [END error-handling]
}
