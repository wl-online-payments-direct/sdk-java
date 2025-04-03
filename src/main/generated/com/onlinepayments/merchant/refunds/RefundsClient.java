/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.refunds;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.RefundsResponse;

/**
 * Refunds client. Thread-safe.
 */
public class RefundsClient extends ApiResource implements RefundsClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public RefundsClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public RefundsResponse getRefunds(String paymentId) {
        return getRefunds(paymentId, null);
    }

    /** {@inheritDoc} */
    @Override
    public RefundsResponse getRefunds(String paymentId, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("paymentId", paymentId);
        String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}/refunds", pathContext);
        try {
            return communicator.get(
                    uri,
                    getClientHeaders(),
                    null,
                    RefundsResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
