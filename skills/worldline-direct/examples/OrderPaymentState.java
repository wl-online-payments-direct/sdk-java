package examples;

/**
 * The payment state of an order in your application.
 */
public enum OrderPaymentState {
    PENDING,
    AUTHORIZED,
    PAID,
    FAILED,
    CANCELLED,
    REFUNDED,
    REVERSED,
}
