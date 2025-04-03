/*
 * This file was automatically generated.
 */

package com.onlinepayments;

import java.util.Optional;

import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.PaymentErrorResponse;

/**
 * Represents an error response from a create payment call.
 */
@SuppressWarnings("serial")
public class DeclinedPaymentException extends DeclinedTransactionException {

    private final PaymentErrorResponse response;

    public DeclinedPaymentException(int statusCode, String responseBody, PaymentErrorResponse response) {
        super(buildMessage(response), statusCode, responseBody,
                response != null ? response.getErrorId() : null,
                response != null ? response.getErrors() : null);
        this.response = response;
    }

    private static String buildMessage(PaymentErrorResponse response) {
        return Optional.ofNullable(response)
                .map(PaymentErrorResponse::getPaymentResult)
                .map(CreatePaymentResponse::getPayment)
                .map(payment -> String.format("declined payment '%s' with status '%s'", payment.getId(), payment.getStatus()))
                .orElse("the payment platform returned a declined payment response");
    }

    /**
     * @return The result of creating a payment if available, or {@code null} otherwise.
     */
    public CreatePaymentResponse getCreatePaymentResponse() {
        return response == null ? null : response.getPaymentResult();
    }
}
