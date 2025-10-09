/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.paymentlinks;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.CreatePaymentLinkRequest;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.PaymentLinkResponse;
import com.onlinepayments.domain.PaymentLinksResponse;

/**
 * PaymentLinks client. Thread-safe.
 */
public class PaymentLinksClient extends ApiResource implements PaymentLinksClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public PaymentLinksClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public PaymentLinksResponse getPaymentLinksInBulk(GetPaymentLinksInBulkParams query) {
        return getPaymentLinksInBulk(query, null);
    }

    /** {@inheritDoc} */
    @Override
    public PaymentLinksResponse getPaymentLinksInBulk(GetPaymentLinksInBulkParams query, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/paymentlinks", null);
        try {
            return communicator.get(
                    uri,
                    getClientHeaders(),
                    query,
                    PaymentLinksResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public PaymentLinkResponse createPaymentLink(CreatePaymentLinkRequest body) {
        return createPaymentLink(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public PaymentLinkResponse createPaymentLink(CreatePaymentLinkRequest body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/paymentlinks", null);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    PaymentLinkResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public PaymentLinkResponse getPaymentLinkById(String paymentLinkId) {
        return getPaymentLinkById(paymentLinkId, null);
    }

    /** {@inheritDoc} */
    @Override
    public PaymentLinkResponse getPaymentLinkById(String paymentLinkId, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("paymentLinkId", paymentLinkId);
        String uri = instantiateUri("/v2/{merchantId}/paymentlinks/{paymentLinkId}", pathContext);
        try {
            return communicator.get(
                    uri,
                    getClientHeaders(),
                    null,
                    PaymentLinkResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void cancelPaymentLinkById(String paymentLinkId) {
        cancelPaymentLinkById(paymentLinkId, null);
    }

    /** {@inheritDoc} */
    @Override
    public void cancelPaymentLinkById(String paymentLinkId, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("paymentLinkId", paymentLinkId);
        String uri = instantiateUri("/v2/{merchantId}/paymentlinks/{paymentLinkId}/cancel", pathContext);
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
}
