/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

import java.util.List;

public class RefundErrorResponse {

	private String errorId = null;

	private List<APIError> errors = null;

	private RefundResponse refundResult = null;

	public String getErrorId() {
		return errorId;
	}

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
	 * This object has the numeric representation of the current refund status, timestamp of last status change and performable action on the current refund resource. In case of a rejected refund, detailed error information is listed.
	 */
	public RefundResponse getRefundResult() {
		return refundResult;
	}

	/**
	 * This object has the numeric representation of the current refund status, timestamp of last status change and performable action on the current refund resource. In case of a rejected refund, detailed error information is listed.
	 */
	public void setRefundResult(RefundResponse value) {
		this.refundResult = value;
	}
}
