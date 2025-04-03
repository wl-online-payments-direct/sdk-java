/*
 * This file was automatically generated.
 */

package com.onlinepayments;

import java.util.List;

import com.onlinepayments.domain.APIError;

/**
 * Represents an error response from the payment platform when authorization failed.
 */
@SuppressWarnings("serial")
public class AuthorizationException extends ApiException {

    public AuthorizationException(int statusCode, String responseBody, String errorId, List<APIError> errors) {
        super("the payment platform returned an authorization error response", statusCode, responseBody, errorId, errors);
    }

    public AuthorizationException(String message, int statusCode, String responseBody, String errorId, List<APIError> errors) {
        super(message, statusCode, responseBody, errorId, errors);
    }
}
