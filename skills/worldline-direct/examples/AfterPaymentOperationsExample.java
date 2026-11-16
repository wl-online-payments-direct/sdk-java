package examples;

import com.onlinepayments.CallContext;
import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.CancelPaymentRequest;
import com.onlinepayments.domain.CancelPaymentResponse;
import com.onlinepayments.domain.CapturePaymentRequest;
import com.onlinepayments.domain.CaptureResponse;
import com.onlinepayments.domain.PaymentDetailsResponse;
import com.onlinepayments.domain.RefundRequest;
import com.onlinepayments.domain.RefundResponse;
import com.onlinepayments.merchant.MerchantClientInterface;

// Each method takes an idempotence key. Create it once per operation (e.g. when someone clicks
// "Refund") and store it. Pass the same key again if the request got no answer; see ErrorHandlingExample.
public class AfterPaymentOperationsExample {

    private final MerchantClientInterface merchantClient;

    public AfterPaymentOperationsExample(MerchantClientInterface merchantClient) {
        this.merchantClient = merchantClient;
    }

    // [START capture-payment]
    // Captures an authorized payment (status PENDING_CAPTURE). Without an amount, the full amount is captured.
    public CaptureResponse capture(String paymentId, long amountInCents, boolean isFinal, String idempotenceKey) {
        PaymentDetailsResponse details = merchantClient.payments().getPaymentDetails(paymentId);
        if (!"PENDING_CAPTURE".equals(details.getStatus())) {
            throw new IllegalStateException("Payment " + paymentId + " cannot be captured in status " + details.getStatus());
        }

        CapturePaymentRequest request = new CapturePaymentRequest()
                .withAmount(amountInCents)
                // true: this capture is final, no further capture is accepted.
                .withIsFinal(isFinal);
        CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);
        return merchantClient.payments().capturePayment(paymentId, request, context);
    }
    // [END capture-payment]

    // [START refund-payment]
    // Refunds a captured payment, fully or partly.
    public RefundResponse refund(String paymentId, long amountInCents, String currencyCode, String idempotenceKey) {
        PaymentDetailsResponse details = merchantClient.payments().getPaymentDetails(paymentId);
        if (details.getStatusOutput() == null || !Boolean.TRUE.equals(details.getStatusOutput().getIsRefundable())) {
            throw new IllegalStateException("Payment " + paymentId + " is not refundable in status " + details.getStatus());
        }

        RefundRequest request = new RefundRequest()
                .withAmountOfMoney(new AmountOfMoney().withAmount(amountInCents).withCurrencyCode(currencyCode));
        CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);
        RefundResponse refund = merchantClient.payments().refundPayment(paymentId, request, context);

        // REFUND_REQUESTED: the platform is processing the refund and waiting for the result. The status then
        // becomes REFUNDED or REJECTED; treat the refund as done only when it is REFUNDED.
        return refund;
    }
    // [END refund-payment]

    // [START cancel-payment]
    // Cancels (voids) an authorization that is not captured yet. No amount cancels the full amount.
    public CancelPaymentResponse cancel(String paymentId, String idempotenceKey) {
        PaymentDetailsResponse details = merchantClient.payments().getPaymentDetails(paymentId);
        if (details.getStatusOutput() == null || !Boolean.TRUE.equals(details.getStatusOutput().getIsCancellable())) {
            throw new IllegalStateException("Payment " + paymentId + " is not cancellable in status " + details.getStatus());
        }

        CallContext context = new CallContext().withIdempotenceKey(idempotenceKey);
        return merchantClient.payments().cancelPayment(paymentId, new CancelPaymentRequest(), context);
    }
    // [END cancel-payment]
}
