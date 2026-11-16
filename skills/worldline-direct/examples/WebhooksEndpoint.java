package examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.onlinepayments.communication.RequestHeader;
import com.onlinepayments.domain.WebhooksEvent;
import com.onlinepayments.json.MarshallerSyntaxException;
import com.onlinepayments.webhooks.ApiVersionMismatchException;
import com.onlinepayments.webhooks.SignatureValidationException;
import com.onlinepayments.webhooks.WebhooksHelper;

public class WebhooksEndpoint {

    private final WebhooksHelper webhooksHelper;
    private final WebhookInbox inbox;

    public WebhooksEndpoint(WebhooksHelper webhooksHelper, WebhookInbox inbox) {
        this.webhooksHelper = webhooksHelper;
        this.inbox = inbox;
    }

    // [START webhooks-receive]
    private static final Logger LOGGER = Logger.getLogger(WebhooksEndpoint.class.getName());

    // Call this from your HTTP endpoint, e.g. a Spring @PostMapping method with @RequestBody byte[] body and
    // @RequestHeader HttpHeaders headers, or a servlet's doPost. Returns the HTTP status to answer with.
    public int receive(byte[] body, Map<String, List<String>> headers) {
        // Use the raw body: the signature is calculated over the exact bytes that were sent.
        // One header object per header value, as received. Do not join repeated values with String.join:
        // a joined value would hide a duplicate X-GCS-Signature or X-GCS-KeyId, which the helper rejects.
        List<RequestHeader> requestHeaders = new ArrayList<>();
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {
            for (String value : header.getValue()) {
                requestHeaders.add(new RequestHeader(header.getKey(), value));
            }
        }

        WebhooksEvent webhooksEvent;
        try {
            // Checks the X-GCS-Signature and X-GCS-KeyId headers before parsing the event.
            webhooksEvent = webhooksHelper.unmarshal(body, requestHeaders);
        } catch (SignatureValidationException e) {
            // Not sent by the platform, an unknown key ID, or the wrong secret is configured. Do nothing with it.
            return 401;
        } catch (ApiVersionMismatchException | MarshallerSyntaxException e) {
            // The signature is valid, so the platform sent this, but the SDK cannot read it. These exceptions are
            // not subclasses of SignatureValidationException. An error status would only make the platform send
            // the same body again. Keep the body to replay after you upgrade the SDK, and raise an alert.
            inbox.saveUnreadableBody(body);
            LOGGER.severe("ALERT: verified webhook cannot be read, raw body saved (" + body.length + " bytes): " + e);
            return 200;
        }

        // Save first, then answer. Do not count on the platform sending the event again after a 2xx, so an event
        // that is only in memory when the process dies can be lost. If saving throws, answer with an error status
        // instead: the platform then sends the event again.
        inbox.saveVerifiedEvent(webhooksEvent);
        // The work happens later in a background job over the saved events.
        return 200;
    }
    // [END webhooks-receive]
}
