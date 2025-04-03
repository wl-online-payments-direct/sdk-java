/*
 * This file was automatically generated.
 */

package com.onlinepayments;

import java.util.Optional;

import com.onlinepayments.domain.RefundErrorResponse;
import com.onlinepayments.domain.RefundResponse;

/**
 * Represents an error response from a refund call.
 */
@SuppressWarnings("serial")
public class DeclinedRefundException extends DeclinedTransactionException {

    private final RefundErrorResponse response;

    public DeclinedRefundException(int statusCode, String responseBody, RefundErrorResponse response) {
        super(buildMessage(response), statusCode, responseBody,
                response != null ? response.getErrorId() : null,
                response != null ? response.getErrors() : null);
        this.response = response;
    }

    private static String buildMessage(RefundErrorResponse response) {
        return Optional.ofNullable(response)
                .map(RefundErrorResponse::getRefundResult)
                .map(refundResult -> String.format("declined refund '%s' with status '%s'", refundResult.getId(), refundResult.getStatus()))
                .orElse("the payment platform returned a declined refund response");
    }

    /**
     * @return The result of creating a refund if available, or {@code null} otherwise.
     */
    public RefundResponse getRefundResponse() {
        return response == null ? null : response.getRefundResult();
    }
}
