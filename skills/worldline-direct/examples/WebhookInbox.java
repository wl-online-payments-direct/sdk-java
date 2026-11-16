package examples;

import com.onlinepayments.domain.WebhooksEvent;

/**
 * Stand-in for durable storage of received webhooks: a database table or a persistent queue, not memory.
 * A background job processes the saved events (see WebhookEventProcessor).
 */
public interface WebhookInbox {

    /**
     * Saves a verified event. Ignore a duplicate: the platform can send the same event more than once, and the
     * webhooks guide identifies a duplicate by identical payment.id and type.
     * Throw if saving fails, so that the endpoint answers with an error status and the platform can send the event again.
     */
    void saveVerifiedEvent(WebhooksEvent webhooksEvent);

    /**
     * Saves the raw body of an event that passed verification but that the SDK cannot read. Keep it to replay
     * after you upgrade the SDK.
     */
    void saveUnreadableBody(byte[] body);
}
