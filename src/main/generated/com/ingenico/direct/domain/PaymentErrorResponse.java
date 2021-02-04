/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

import java.util.List;

public class PaymentErrorResponse {

	private String errorId = null;

	private List<APIError> errors = null;

	private CreatePaymentResponse paymentResult = null;

	/**
	 * Unique reference, for debugging purposes, of this error response
	 */
	public String getErrorId() {
		return errorId;
	}

	/**
	 * Unique reference, for debugging purposes, of this error response
	 */
	public void setErrorId(String value) {
		this.errorId = value;
	}

	public List<APIError> getErrors() {
		return errors;
	}

	public void setErrors(List<APIError> value) {
		this.errors = value;
	}

	/**
	 * Object that contains details on the created payment in case one has been created.
	 */
	public CreatePaymentResponse getPaymentResult() {
		return paymentResult;
	}

	/**
	 * Object that contains details on the created payment in case one has been created.
	 */
	public void setPaymentResult(CreatePaymentResponse value) {
		this.paymentResult = value;
	}
}
