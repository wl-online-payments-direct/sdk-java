package com.onlinepayments.webhooks;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.onlinepayments.communication.RequestHeader;
import com.onlinepayments.domain.WebhooksEvent;
import com.onlinepayments.json.Marshaller;

/**
 * Online Payments platform v1 webhooks helper. Thread-safe.
 */
public class WebhooksHelper {

    private final Marshaller marshaller;

    private final SignatureValidator signatureValidator;

    public WebhooksHelper(Marshaller marshaller, SecretKeyStore secretKeyStore) {
        if (marshaller == null) {
            throw new IllegalArgumentException("marshaller is required");
        }
        this.marshaller = marshaller;
        this.signatureValidator = new SignatureValidator(secretKeyStore);
    }

    /**
     * Unmarshals the given input stream that contains the body,
     * while also validating its contents using the given request headers.
     *
     * @return The input stream unmarshalled as a {@link WebhooksEvent}
     * @throws IOException If the input stream could not be read.
     * @throws SignatureValidationException If the input stream could not be validated successfully.
     * @throws ApiVersionMismatchException If the resulting event has an API version that this version of the SDK does not support.
     */
    public WebhooksEvent unmarshal(InputStream bodyStream, List<RequestHeader> requestHeaders) throws IOException {
        byte[] bodyBytes = getContent(bodyStream);
        return unmarshal(bodyBytes, requestHeaders);
    }

    private static byte[] getContent(InputStream bodyStream) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream(4096);

        byte[] buffer = new byte[4096];
        int len;
        while ((len = bodyStream.read(buffer)) != -1) {
            output.write(buffer, 0, len);
        }
        return output.toByteArray();
    }

    /**
     * Unmarshals the given body, while also validating it using the given request headers.
     *
     * @return The body unmarshalled as a {@link WebhooksEvent}
     * @throws SignatureValidationException If the body could not be validated successfully.
     * @throws ApiVersionMismatchException If the resulting event has an API version that this version of the SDK does not support.
     */
    public WebhooksEvent unmarshal(byte[] body, List<RequestHeader> requestHeaders) {
        signatureValidator.validate(body, requestHeaders);

        WebhooksEvent event = marshaller.unmarshal(new ByteArrayInputStream(body), WebhooksEvent.class);
        validateApiVersion(event);
        return event;
    }

    /**
     * Unmarshals the given body, while also validating it using the given request headers.
     *
     * @return The body unmarshalled as a {@link WebhooksEvent}
     * @throws SignatureValidationException If the body could not be validated successfully.
     * @throws ApiVersionMismatchException If the resulting event has an API version that this version of the SDK does not support.
     */
    public WebhooksEvent unmarshal(String body, List<RequestHeader> requestHeaders) {
        signatureValidator.validate(body, requestHeaders);

        WebhooksEvent event = marshaller.unmarshal(body, WebhooksEvent.class);
        validateApiVersion(event);
        return event;
    }

    private static void validateApiVersion(WebhooksEvent event) {
        if (!"v1".equals(event.getApiVersion())) {
            throw new ApiVersionMismatchException(event.getApiVersion(), "v1");
        }
    }
}
