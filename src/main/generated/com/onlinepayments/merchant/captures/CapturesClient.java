/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.captures;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.CapturesResponse;
import com.onlinepayments.domain.ErrorResponse;

/**
 * Captures client. Thread-safe.
 */
public class CapturesClient extends ApiResource implements CapturesClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public CapturesClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public CapturesResponse getCaptures(String paymentId) {
        return getCaptures(paymentId, null);
    }

    /** {@inheritDoc} */
    @Override
    public CapturesResponse getCaptures(String paymentId, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("paymentId", paymentId);
        String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}/captures", pathContext);
        try {
            return communicator.get(
                    uri,
                    getClientHeaders(),
                    null,
                    CapturesResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
