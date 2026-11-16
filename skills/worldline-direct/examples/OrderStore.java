package examples;

/**
 * Stand-in for your application's own persistence. The examples call it where your code must
 * store or read data; replace it with your database code.
 */
public interface OrderStore {

    // The idempotence key of the operation in progress for this order. Save it BEFORE the API call, so a retry
    // after a crash or timeout can send the same key.
    void saveIdempotenceKey(String orderId, String idempotenceKey);

    // Returns null when no idempotence key is stored for the order.
    String getIdempotenceKey(String orderId);

    void saveHostedCheckout(String orderId, String hostedCheckoutId, String returnMac);

    StoredHostedCheckout getHostedCheckout(String orderId);

    void savePaymentId(String orderId, String paymentId);

    // Returns null when no payment ID is stored for the order yet.
    String getPaymentId(String orderId);

    void saveState(String orderId, OrderPaymentState state);

    void saveRecurringPaymentId(String customerId, String initialPaymentId);

    String getRecurringPaymentId(String customerId);

    final class StoredHostedCheckout {

        private final String hostedCheckoutId;
        private final String returnMac;

        public StoredHostedCheckout(String hostedCheckoutId, String returnMac) {
            this.hostedCheckoutId = hostedCheckoutId;
            this.returnMac = returnMac;
        }

        public String getHostedCheckoutId() {
            return hostedCheckoutId;
        }

        public String getReturnMac() {
            return returnMac;
        }
    }
}
