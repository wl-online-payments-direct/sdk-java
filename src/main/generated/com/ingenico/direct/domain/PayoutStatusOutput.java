/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class PayoutStatusOutput {

	private Boolean isCancellable = null;

	private String statusCategory = null;

	private Integer statusCode = null;

	/**
	 * Flag indicating if the payout can be cancelled 
	 *  * true 
	 *  * false
	 */
	public Boolean getIsCancellable() {
		return isCancellable;
	}

	/**
	 * Flag indicating if the payout can be cancelled 
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
}
