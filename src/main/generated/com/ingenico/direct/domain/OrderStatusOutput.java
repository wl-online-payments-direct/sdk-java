/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

import java.util.List;

public class OrderStatusOutput {

	private List<APIError> errors = null;

	private Boolean isCancellable = null;

	private String statusCategory = null;

	private Integer statusCode = null;

	private String statusCodeChangeDateTime = null;

	public List<APIError> getErrors() {
		return errors;
	}

	public void setErrors(List<APIError> value) {
		this.errors = value;
	}

	/**
	 * Flag indicating if the payment can be cancelled 
	 *  * true 
	 *  * false
	 */
	public Boolean getIsCancellable() {
		return isCancellable;
	}

	/**
	 * Flag indicating if the payment can be cancelled 
	 *  * true 
	 *  * false
	 */
	public void setIsCancellable(Boolean value) {
		this.isCancellable = value;
	}

	/**
	 * Highlevel status of the payment, payout or refund.
	 */
	public String getStatusCategory() {
		return statusCategory;
	}

	/**
	 * Highlevel status of the payment, payout or refund.
	 */
	public void setStatusCategory(String value) {
		this.statusCategory = value;
	}

	/**
	 * Numeric status code of the legacy API. It is returned to ease the migration from the legacy APIs to Ingenico Direct. You should not write new business logic based on this property as it will be deprecated in a future version of the API. The value can also be found in the BackOffice and in report files.
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * Numeric status code of the legacy API. It is returned to ease the migration from the legacy APIs to Ingenico Direct. You should not write new business logic based on this property as it will be deprecated in a future version of the API. The value can also be found in the BackOffice and in report files.
	 */
	public void setStatusCode(Integer value) {
		this.statusCode = value;
	}

	/**
	 * Timestamp of the latest status change
	 */
	public String getStatusCodeChangeDateTime() {
		return statusCodeChangeDateTime;
	}

	/**
	 * Timestamp of the latest status change
	 */
	public void setStatusCodeChangeDateTime(String value) {
		this.statusCodeChangeDateTime = value;
	}
}