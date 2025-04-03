/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.complete;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.CompletePaymentRequest;
import com.onlinepayments.domain.CompletePaymentResponse;
import com.onlinepayments.domain.PaymentErrorResponse;

/**
 * Complete client. Thread-safe.
 */
public class CompleteClient extends ApiResource implements CompleteClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public CompleteClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public CompletePaymentResponse completePayment(String paymentId, CompletePaymentRequest body) {
        return completePayment(paymentId, body, null);
    }

    /** {@inheritDoc} */
    @Override
    public CompletePaymentResponse completePayment(String paymentId, CompletePaymentRequest body, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("paymentId", paymentId);
        String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}/complete", pathContext);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    CompletePaymentResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = PaymentErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
