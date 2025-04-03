/*
 * This file was automatically generated.
 */

package com.onlinepayments;

import java.util.List;

import com.onlinepayments.domain.APIError;

/**
 * Represents an error response from the payment platform when something went wrong at the payment platform or further downstream.
 */
@SuppressWarnings("serial")
public class PlatformException extends ApiException {

    public PlatformException(int statusCode, String responseBody, String errorId, List<APIError> errors) {
        super("the payment platform returned an error response", statusCode, responseBody, errorId, errors);
    }

    public PlatformException(String message, int statusCode, String responseBody, String errorId, List<APIError> errors) {
        super(message, statusCode, responseBody, errorId, errors);
    }
}
