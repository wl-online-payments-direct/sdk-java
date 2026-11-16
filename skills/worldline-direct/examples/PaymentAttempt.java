package examples;

import java.util.UUID;

// [START payment-attempt-key]
// One idempotence key per payment attempt, stored with the order.
public final class PaymentAttempt {

    private PaymentAttempt() {
    }

    // Call start when the customer begins to pay, for example when you show the payment form, and again
    // before a new attempt after a decline or a rejected request. It stores the key before any
    // createPayment call.
    public static String start(String orderId, OrderStore orders) {
        String key = UUID.randomUUID().toString();
        orders.saveIdempotenceKey(orderId, key);
        return key;
    }

    // The request that creates the payment reads the stored key. A double submit, a retry after a timeout
    // and a restart then send the same key, so the platform does not create a second payment.
    public static String keyFor(String orderId, OrderStore orders) {
        String key = orders.getIdempotenceKey(orderId);
        if (key == null) {
            throw new IllegalStateException("No payment attempt was started for order " + orderId);
        }
        return key;
    }
}
// [END payment-attempt-key]
