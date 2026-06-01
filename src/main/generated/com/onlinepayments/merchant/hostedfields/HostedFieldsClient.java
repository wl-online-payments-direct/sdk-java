/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.hostedfields;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.CreateHostedFieldsSessionRequest;
import com.onlinepayments.domain.CreateHostedFieldsSessionResponse;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.GetHostedFieldsSessionResponse;
import com.onlinepayments.domain.ProblemDetailsResponse;

/**
 * HostedFields client. Thread-safe.
 */
public class HostedFieldsClient extends ApiResource implements HostedFieldsClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public HostedFieldsClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public CreateHostedFieldsSessionResponse createHostedFieldsSession(CreateHostedFieldsSessionRequest body) {
        return createHostedFieldsSession(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public CreateHostedFieldsSessionResponse createHostedFieldsSession(CreateHostedFieldsSessionRequest body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/hostedfields/sessions", null);
        try {

            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    CreateHostedFieldsSessionResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public GetHostedFieldsSessionResponse getHostedFieldsSession(String sessionId) {
        return getHostedFieldsSession(sessionId, null);
    }

    /** {@inheritDoc} */
    @Override
    public GetHostedFieldsSessionResponse getHostedFieldsSession(String sessionId, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("sessionId", sessionId);
        String uri = instantiateUri("/v2/{merchantId}/hostedfields/sessions/{sessionId}", pathContext);
        try {

            return communicator.get(
                    uri,
                    getClientHeaders(),
                    null,
                    GetHostedFieldsSessionResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ProblemDetailsResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
