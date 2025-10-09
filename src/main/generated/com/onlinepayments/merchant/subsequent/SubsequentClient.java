/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.subsequent;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.PaymentErrorResponse;
import com.onlinepayments.domain.SubsequentPaymentRequest;
import com.onlinepayments.domain.SubsequentPaymentResponse;

/**
 * Subsequent client. Thread-safe.
 */
public class SubsequentClient extends ApiResource implements SubsequentClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public SubsequentClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public SubsequentPaymentResponse subsequentPayment(String paymentId, SubsequentPaymentRequest body) {
        return subsequentPayment(paymentId, body, null);
    }

    /** {@inheritDoc} */
    @Override
    public SubsequentPaymentResponse subsequentPayment(String paymentId, SubsequentPaymentRequest body, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("paymentId", paymentId);
        String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}/subsequent", pathContext);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    SubsequentPaymentResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = PaymentErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
