/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

public class PayoutErrorResponse {

	private String errorId = null;

	private List<APIError> errors = null;

	private PayoutResult payoutResult = null;

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String value) {
		this.errorId = value;
	}

	public PayoutErrorResponse withErrorId(String value) {
		this.errorId = value;
		return this;
	}

	/**
	 * Contains the set of errors
	 */
	public List<APIError> getErrors() {
		return errors;
	}

	/**
	 * Contains the set of errors
	 */
	public void setErrors(List<APIError> value) {
		this.errors = value;
	}

	/**
	 * Contains the set of errors
	 */
	public PayoutErrorResponse withErrors(List<APIError> value) {
		this.errors = value;
		return this;
	}

	public PayoutResult getPayoutResult() {
		return payoutResult;
	}

	public void setPayoutResult(PayoutResult value) {
		this.payoutResult = value;
	}

	public PayoutErrorResponse withPayoutResult(PayoutResult value) {
		this.payoutResult = value;
		return this;
	}
}
