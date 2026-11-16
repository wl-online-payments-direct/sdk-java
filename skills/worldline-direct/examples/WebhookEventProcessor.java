package examples;

import com.onlinepayments.domain.PaymentDetailsResponse;
import com.onlinepayments.domain.WebhooksEvent;
import com.onlinepayments.merchant.MerchantClientInterface;

public class WebhookEventProcessor {

    private final MerchantClientInterface merchantClient;
    private final OrderStore orders;

    public WebhookEventProcessor(MerchantClientInterface merchantClient, OrderStore orders) {
        this.merchantClient = merchantClient;
        this.orders = orders;
    }

    // [START webhooks-process]
    // Runs in a background job over the events saved in the WebhookInbox. Events can arrive twice and out of
    // order, so read the current status instead of trusting the event; repeating this is harmless.
    public void process(WebhooksEvent webhooksEvent) {
        if (webhooksEvent.getPayment() == null) {
            // Refund, payment link, payout and token events carry other objects, e.g. webhooksEvent.getRefund().
            return;
        }

        String orderId = webhooksEvent.getPayment().getPaymentOutput() != null
                && webhooksEvent.getPayment().getPaymentOutput().getReferences() != null
                ? webhooksEvent.getPayment().getPaymentOutput().getReferences().getMerchantReference()
                : null;
        if (orderId == null) {
            return;
        }

        PaymentDetailsResponse details = merchantClient.payments().getPaymentDetails(webhooksEvent.getPayment().getId());
        orders.savePaymentId(orderId, details.getId());
        orders.saveState(orderId, PaymentStatusExample.toOrderState(details.getStatus(), details.getStatusOutput()));
    }
    // [END webhooks-process]
}
