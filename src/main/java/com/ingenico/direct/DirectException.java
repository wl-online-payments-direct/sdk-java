package com.ingenico.direct;

import java.util.List;

import com.ingenico.direct.domain.APIError;

/**
 * Represents an error response from the Ingenico ePayments platform when something went wrong at the Ingenico ePayments platform or further downstream.
 */
@SuppressWarnings("serial")
public class DirectException extends ApiException {

	public DirectException(int statusCode, String responseBody, String errorId, List<APIError> errors) {
		super("the Ingenico ePayments platform returned an error response", statusCode, responseBody, errorId, errors);
	}

	public DirectException(String message, int statusCode, String responseBody, String errorId, List<APIError> errors) {
		super(message, statusCode, responseBody, errorId, errors);
	}
}
