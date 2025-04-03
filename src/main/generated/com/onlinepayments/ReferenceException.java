/*
 * This file was automatically generated.
 */

package com.onlinepayments;

import java.util.List;

import com.onlinepayments.domain.APIError;

/**
 * Represents an error response from the payment platform when a non-existing or removed object is trying to be accessed.
 */
@SuppressWarnings("serial")
public class ReferenceException extends ApiException {

    public ReferenceException(int statusCode, String responseBody, String errorId, List<APIError> errors) {
        super("the payment platform returned a reference error response", statusCode, responseBody, errorId, errors);
    }

    public ReferenceException(String message, int statusCode, String responseBody, String errorId, List<APIError> errors) {
        super(message, statusCode, responseBody, errorId, errors);
    }
}
