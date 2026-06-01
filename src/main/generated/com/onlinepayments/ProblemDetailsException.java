/*
 * This file was automatically generated.
 */

package com.onlinepayments;

import com.onlinepayments.domain.ProblemDetailsResponse;

/**
 * Represents an error response from the payment platform containing problem details.
 */
@SuppressWarnings("serial")
public class ProblemDetailsException extends ApiException {

    private final ProblemDetailsResponse response;

    public ProblemDetailsException(int statusCode, String responseBody, ProblemDetailsResponse response) {
        super("the payment platform returned a problem details error response", statusCode, responseBody,
                null,
                null);
        this.response = response;
    }

    /**
     * @return The problem details response, or {@code null} if not available.
     */
    public ProblemDetailsResponse getResponse() {
        return response;
    }
}
