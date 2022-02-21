package com.onlinepayments;

import java.util.List;

import com.onlinepayments.domain.APIError;

/**
 * Represents an error response from the Online Payments platform when something went wrong at the Online Payments platform or further downstream.
 */
@SuppressWarnings("serial")
public class PaymentPlatformException extends ApiException {

	public PaymentPlatformException(int statusCode, String responseBody, String errorId, List<APIError> errors) {
		super("the Online Payments platform returned an error response", statusCode, responseBody, errorId, errors);
	}

	public PaymentPlatformException(String message, int statusCode, String responseBody, String errorId, List<APIError> errors) {
		super(message, statusCode, responseBody, errorId, errors);
	}
}
