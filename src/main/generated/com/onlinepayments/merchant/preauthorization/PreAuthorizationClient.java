/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.preauthorization;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.AddAuthorizationDetailsResponse;
import com.onlinepayments.domain.IncrementAuthorizationRequest;
import com.onlinepayments.domain.IncrementAuthorizationResponse;
import com.onlinepayments.domain.PaymentErrorResponse;
import com.onlinepayments.domain.UpdateAuthorizationAdditionalDataRequest;

/**
 * PreAuthorization client. Thread-safe.
 */
public class PreAuthorizationClient extends ApiResource implements PreAuthorizationClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public PreAuthorizationClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public IncrementAuthorizationResponse incrementAuthorization(String paymentId, IncrementAuthorizationRequest body) {
        return incrementAuthorization(paymentId, body, null);
    }

    /** {@inheritDoc} */
    @Override
    public IncrementAuthorizationResponse incrementAuthorization(String paymentId, IncrementAuthorizationRequest body, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("paymentId", paymentId);
        String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}/increment-authorization", pathContext);
        try {

            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    IncrementAuthorizationResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = PaymentErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public AddAuthorizationDetailsResponse addAuthorizationDetails(String paymentId, UpdateAuthorizationAdditionalDataRequest body) {
        return addAuthorizationDetails(paymentId, body, null);
    }

    /** {@inheritDoc} */
    @Override
    public AddAuthorizationDetailsResponse addAuthorizationDetails(String paymentId, UpdateAuthorizationAdditionalDataRequest body, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("paymentId", paymentId);
        String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}/authorization-additional-data", pathContext);
        try {

            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    AddAuthorizationDetailsResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = PaymentErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
