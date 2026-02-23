/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.merchantbatch;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.GetBatchStatusResponse;
import com.onlinepayments.domain.SubmitBatchRequestBody;
import com.onlinepayments.domain.SubmitBatchResponse;

/**
 * MerchantBatch client. Thread-safe.
 */
public class MerchantBatchClient extends ApiResource implements MerchantBatchClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public MerchantBatchClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public SubmitBatchResponse submitBatch(SubmitBatchRequestBody body) {
        return submitBatch(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public SubmitBatchResponse submitBatch(SubmitBatchRequestBody body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/merchant-batches", null);
        try {
            context = (context == null) ? new CallContext() : context;
            context.setGzip(true);

            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    SubmitBatchResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void processBatch(String merchantBatchReference) {
        processBatch(merchantBatchReference, null);
    }

    /** {@inheritDoc} */
    @Override
    public void processBatch(String merchantBatchReference, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("merchantBatchReference", merchantBatchReference);
        String uri = instantiateUri("/v2/{merchantId}/merchant-batches/{merchantBatchReference}/process", pathContext);
        try {

            communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    null,
                    void.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public GetBatchStatusResponse getBatchStatus(String merchantBatchReference) {
        return getBatchStatus(merchantBatchReference, null);
    }

    /** {@inheritDoc} */
    @Override
    public GetBatchStatusResponse getBatchStatus(String merchantBatchReference, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("merchantBatchReference", merchantBatchReference);
        String uri = instantiateUri("/v2/{merchantId}/merchant-batches/{merchantBatchReference}", pathContext);
        try {

            return communicator.get(
                    uri,
                    getClientHeaders(),
                    null,
                    GetBatchStatusResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
