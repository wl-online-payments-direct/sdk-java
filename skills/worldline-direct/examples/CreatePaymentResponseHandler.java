package examples;

import com.onlinepayments.domain.CreatePaymentResponse;

public final class CreatePaymentResponseHandler {

    private CreatePaymentResponseHandler() {
    }

    // [START payment-response-handle]
    // Use for every createPayment response: server-to-server, Hosted Tokenization, Hosted Fields
    // and client integration.
    public static PaymentStep handle(CreatePaymentResponse response, String orderId, OrderStore orders) {
        orders.savePaymentId(orderId, response.getPayment().getId());

        if (response.getMerchantAction() != null && "REDIRECT".equals(response.getMerchantAction().getActionType())) {
            // 3-D Secure challenge or a third-party page. Redirect to the URL exactly as returned.
            // The customer comes back on your return URL; then read the status with getPaymentDetails.
            return PaymentStep.redirect(response.getMerchantAction().getRedirectData().getRedirectURL());
        }

        // No customer action needed: the result is already known.
        OrderPaymentState state = PaymentStatusExample.toOrderState(
                response.getPayment().getStatus(), response.getPayment().getStatusOutput());
        orders.saveState(orderId, state);
        return PaymentStep.done(state);
    }
    // [END payment-response-handle]
}
