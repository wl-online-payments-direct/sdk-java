/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

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
	 * Flag indicating if the payout can be cancelled 
	 *  * true 
	 *  * false
	 */
	public PayoutStatusOutput withIsCancellable(Boolean value) {
		this.isCancellable = value;
		return this;
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
	 * Highlevel status of the payment, payout or refund.
	 */
	public PayoutStatusOutput withStatusCategory(String value) {
		this.statusCategory = value;
		return this;
	}

	/**
	 * Numeric status code of the legacy API. It is returned to ease the migration from the legacy APIs. You should not write new business logic based on this property as it will be deprecated in a future version of the API. The value can also be found in the BackOffice and in report files.
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * Numeric status code of the legacy API. It is returned to ease the migration from the legacy APIs. You should not write new business logic based on this property as it will be deprecated in a future version of the API. The value can also be found in the BackOffice and in report files.
	 */
	public void setStatusCode(Integer value) {
		this.statusCode = value;
	}

	/**
	 * Numeric status code of the legacy API. It is returned to ease the migration from the legacy APIs. You should not write new business logic based on this property as it will be deprecated in a future version of the API. The value can also be found in the BackOffice and in report files.
	 */
	public PayoutStatusOutput withStatusCode(Integer value) {
		this.statusCode = value;
		return this;
	}
}
