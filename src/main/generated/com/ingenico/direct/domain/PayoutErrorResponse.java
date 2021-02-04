/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

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

	public PayoutResult getPayoutResult() {
		return payoutResult;
	}

	public void setPayoutResult(PayoutResult value) {
		this.payoutResult = value;
	}
}
