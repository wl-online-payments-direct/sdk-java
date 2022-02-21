/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

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

	/**
	 * Unique reference, for debugging purposes, of this error response
	 */
	public PaymentErrorResponse withErrorId(String value) {
		this.errorId = value;
		return this;
	}

	public List<APIError> getErrors() {
		return errors;
	}

	public void setErrors(List<APIError> value) {
		this.errors = value;
	}

	public PaymentErrorResponse withErrors(List<APIError> value) {
		this.errors = value;
		return this;
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

	/**
	 * Object that contains details on the created payment in case one has been created.
	 */
	public PaymentErrorResponse withPaymentResult(CreatePaymentResponse value) {
		this.paymentResult = value;
		return this;
	}
}
