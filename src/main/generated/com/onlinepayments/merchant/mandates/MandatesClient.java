/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.mandates;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.CreateMandateRequest;
import com.onlinepayments.domain.CreateMandateResponse;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.GetMandateResponse;
import com.onlinepayments.domain.RevokeMandateRequest;

/**
 * Mandates client. Thread-safe.
 */
public class MandatesClient extends ApiResource implements MandatesClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public MandatesClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public CreateMandateResponse createMandate(CreateMandateRequest body) {
        return createMandate(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public CreateMandateResponse createMandate(CreateMandateRequest body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/mandates", null);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    CreateMandateResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public GetMandateResponse getMandate(String uniqueMandateReference) {
        return getMandate(uniqueMandateReference, null);
    }

    /** {@inheritDoc} */
    @Override
    public GetMandateResponse getMandate(String uniqueMandateReference, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("uniqueMandateReference", uniqueMandateReference);
        String uri = instantiateUri("/v2/{merchantId}/mandates/{uniqueMandateReference}", pathContext);
        try {
            return communicator.get(
                    uri,
                    getClientHeaders(),
                    null,
                    GetMandateResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public GetMandateResponse blockMandate(String uniqueMandateReference) {
        return blockMandate(uniqueMandateReference, null);
    }

    /** {@inheritDoc} */
    @Override
    public GetMandateResponse blockMandate(String uniqueMandateReference, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("uniqueMandateReference", uniqueMandateReference);
        String uri = instantiateUri("/v2/{merchantId}/mandates/{uniqueMandateReference}/block", pathContext);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    null,
                    GetMandateResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public GetMandateResponse unblockMandate(String uniqueMandateReference) {
        return unblockMandate(uniqueMandateReference, null);
    }

    /** {@inheritDoc} */
    @Override
    public GetMandateResponse unblockMandate(String uniqueMandateReference, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("uniqueMandateReference", uniqueMandateReference);
        String uri = instantiateUri("/v2/{merchantId}/mandates/{uniqueMandateReference}/unblock", pathContext);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    null,
                    GetMandateResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public GetMandateResponse revokeMandate(String uniqueMandateReference, RevokeMandateRequest body) {
        return revokeMandate(uniqueMandateReference, body, null);
    }

    /** {@inheritDoc} */
    @Override
    public GetMandateResponse revokeMandate(String uniqueMandateReference, RevokeMandateRequest body, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("uniqueMandateReference", uniqueMandateReference);
        String uri = instantiateUri("/v2/{merchantId}/mandates/{uniqueMandateReference}/revoke", pathContext);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    GetMandateResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
