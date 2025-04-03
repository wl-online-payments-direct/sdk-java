/*
 * This file was automatically generated.
 */

package com.onlinepayments;

import java.util.Optional;

import com.onlinepayments.domain.PayoutErrorResponse;
import com.onlinepayments.domain.PayoutResult;

/**
 * Represents an error response from a payout call.
 */
@SuppressWarnings("serial")
public class DeclinedPayoutException extends DeclinedTransactionException {

    private final PayoutErrorResponse response;

    public DeclinedPayoutException(int statusCode, String responseBody, PayoutErrorResponse response) {
        super(buildMessage(response), statusCode, responseBody,
                response != null ? response.getErrorId() : null,
                response != null ? response.getErrors() : null);
        this.response = response;
    }

    private static String buildMessage(PayoutErrorResponse response) {
        return Optional.ofNullable(response)
                .map(PayoutErrorResponse::getPayoutResult)
                .map(payoutResult -> String.format("declined payout '%s' with status '%s'", payoutResult.getId(), payoutResult.getStatus()))
                .orElse("the payment platform returned a declined payout response");
    }

    /**
     * @return The result of creating a payout if available, or {@code null} otherwise.
     */
    public PayoutResult getPayoutResult() {
        return response == null ? null : response.getPayoutResult();
    }
}
