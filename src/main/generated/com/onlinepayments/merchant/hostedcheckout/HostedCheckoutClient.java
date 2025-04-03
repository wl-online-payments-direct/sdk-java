/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.hostedcheckout;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.CreateHostedCheckoutRequest;
import com.onlinepayments.domain.CreateHostedCheckoutResponse;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.GetHostedCheckoutResponse;

/**
 * HostedCheckout client. Thread-safe.
 */
public class HostedCheckoutClient extends ApiResource implements HostedCheckoutClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public HostedCheckoutClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public CreateHostedCheckoutResponse createHostedCheckout(CreateHostedCheckoutRequest body) {
        return createHostedCheckout(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public CreateHostedCheckoutResponse createHostedCheckout(CreateHostedCheckoutRequest body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/hostedcheckouts", null);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    CreateHostedCheckoutResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public GetHostedCheckoutResponse getHostedCheckout(String hostedCheckoutId) {
        return getHostedCheckout(hostedCheckoutId, null);
    }

    /** {@inheritDoc} */
    @Override
    public GetHostedCheckoutResponse getHostedCheckout(String hostedCheckoutId, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("hostedCheckoutId", hostedCheckoutId);
        String uri = instantiateUri("/v2/{merchantId}/hostedcheckouts/{hostedCheckoutId}", pathContext);
        try {
            return communicator.get(
                    uri,
                    getClientHeaders(),
                    null,
                    GetHostedCheckoutResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
