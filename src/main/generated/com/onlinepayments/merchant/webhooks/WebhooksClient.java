/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.webhooks;

import java.util.Map;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.SendTestRequest;
import com.onlinepayments.domain.ValidateCredentialsRequest;
import com.onlinepayments.domain.ValidateCredentialsResponse;

/**
 * Webhooks client. Thread-safe.
 */
public class WebhooksClient extends ApiResource implements WebhooksClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public WebhooksClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public ValidateCredentialsResponse validateWebhookCredentials(ValidateCredentialsRequest body) {
        return validateWebhookCredentials(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public ValidateCredentialsResponse validateWebhookCredentials(ValidateCredentialsRequest body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/webhooks/validateCredentials", null);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    ValidateCredentialsResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void sendTestWebhook(SendTestRequest body) {
        sendTestWebhook(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public void sendTestWebhook(SendTestRequest body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/webhooks/sendtest", null);
        try {
            communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    void.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
