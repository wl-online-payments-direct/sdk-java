/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.payouts;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.CreatePayoutRequest;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.PayoutErrorResponse;
import com.onlinepayments.domain.PayoutResponse;

/**
 * Payouts client. Thread-safe.
 */
public class PayoutsClient extends ApiResource implements PayoutsClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public PayoutsClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public PayoutResponse createPayout(CreatePayoutRequest body) {
        return createPayout(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public PayoutResponse createPayout(CreatePayoutRequest body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/payouts", null);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    PayoutResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = PayoutErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public PayoutResponse getPayout(String payoutId) {
        return getPayout(payoutId, null);
    }

    /** {@inheritDoc} */
    @Override
    public PayoutResponse getPayout(String payoutId, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("payoutId", payoutId);
        String uri = instantiateUri("/v2/{merchantId}/payouts/{payoutId}", pathContext);
        try {
            return communicator.get(
                    uri,
                    getClientHeaders(),
                    null,
                    PayoutResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
