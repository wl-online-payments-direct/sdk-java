/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.sessions;

import java.util.Map;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.SessionRequest;
import com.onlinepayments.domain.SessionResponse;

/**
 * Sessions client. Thread-safe.
 */
public class SessionsClient extends ApiResource implements SessionsClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public SessionsClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public SessionResponse createSession(SessionRequest body) {
        return createSession(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public SessionResponse createSession(SessionRequest body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/sessions", null);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    SessionResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
