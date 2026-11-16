package examples;

import com.onlinepayments.domain.PaymentDetailsResponse;
import com.onlinepayments.domain.PaymentStatusOutput;
import com.onlinepayments.merchant.MerchantClientInterface;

public class PaymentStatusExample {

    private final MerchantClientInterface merchantClient;
    private final OrderStore orders;

    public PaymentStatusExample(MerchantClientInterface merchantClient, OrderStore orders) {
        this.merchantClient = merchantClient;
        this.orders = orders;
    }

    // [START payment-status]
    public OrderPaymentState refreshPaymentState(String orderId) {
        String paymentId = orders.getPaymentId(orderId);
        PaymentDetailsResponse details = merchantClient.payments().getPaymentDetails(paymentId);

        OrderPaymentState state = toOrderState(details.getStatus(), details.getStatusOutput());
        orders.saveState(orderId, state);
        return state;
    }

    // Decide on statusOutput.getStatusCategory(). getStatus() and statusOutput.getStatusCode() give more detail.
    public static OrderPaymentState toOrderState(String status, PaymentStatusOutput statusOutput) {
        // A response can lack statusOutput or its statusCategory. Unknown is not paid: treat it as not final.
        String category = statusOutput != null ? statusOutput.getStatusCategory() : null;
        if (category == null) {
            return OrderPaymentState.PENDING;
        }
        if ("COMPLETED".equals(category)) {
            return OrderPaymentState.PAID;
        }
        if ("PENDING_MERCHANT".equals(category)) {
            // PENDING_CAPTURE: authorized but not captured yet, capture or cancel it.
            // Any other status (CANCELLED, waiting for its final result) is not final.
            return "PENDING_CAPTURE".equals(status) ? OrderPaymentState.AUTHORIZED : OrderPaymentState.PENDING;
        }
        if ("REFUNDED".equals(category)) {
            return OrderPaymentState.REFUNDED;
        }
        if ("REVERSED".equals(category)) {
            // Not paid: do not treat the order as paid.
            return OrderPaymentState.REVERSED;
        }
        if ("UNSUCCESSFUL".equals(category)) {
            return "CANCELLED".equals(status) ? OrderPaymentState.CANCELLED : OrderPaymentState.FAILED;
        }
        // CREATED, PENDING_PAYMENT, PENDING_CONNECT_OR_3RD_PARTY: not final.
        // Wait for a webhook or check again later.
        return OrderPaymentState.PENDING;
    }
    // [END payment-status]
}
