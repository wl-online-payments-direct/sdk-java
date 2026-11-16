package examples;

/**
 * What the web layer must do after a create payment call.
 */
public final class PaymentStep {

    private final String redirectUrl;
    private final OrderPaymentState state;

    private PaymentStep(String redirectUrl, OrderPaymentState state) {
        this.redirectUrl = redirectUrl;
        this.state = state;
    }

    public static PaymentStep redirect(String url) {
        return new PaymentStep(url, OrderPaymentState.PENDING);
    }

    public static PaymentStep done(OrderPaymentState state) {
        return new PaymentStep(null, state);
    }

    public boolean isRedirect() {
        return redirectUrl != null;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public OrderPaymentState getState() {
        return state;
    }
}
