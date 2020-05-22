package com.ingenico.direct;

import java.util.List;

import com.ingenico.direct.domain.APIError;

/**
 * Represents an error response from the Ingenico ePayments platform when authorization failed.
 */
@SuppressWarnings("serial")
public class AuthorizationException extends ApiException {

	public AuthorizationException(int statusCode, String responseBody, String errorId, List<APIError> errors) {
		super("the Ingenico ePayments platform returned an authorization error response", statusCode, responseBody, errorId, errors);
	}

	public AuthorizationException(String message, int statusCode, String responseBody, String errorId, List<APIError> errors) {
		super(message, statusCode, responseBody, errorId, errors);
	}
}
