/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

/**
 * This object has the numeric representation of the current payment status, timestamp of last status change and performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
 */
public class PaymentStatusOutput {

	private List<APIError> errors = null;

	private Boolean isAuthorized = null;

	private Boolean isCancellable = null;

	private Boolean isRefundable = null;

	private String statusCategory = null;

	private Integer statusCode = null;

	private String statusCodeChangeDateTime = null;

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
	public PaymentStatusOutput withErrors(List<APIError> value) {
		this.errors = value;
		return this;
	}

	/**
	 * Indicates if the transaction has been authorized
	 */
	public Boolean getIsAuthorized() {
		return isAuthorized;
	}

	/**
	 * Indicates if the transaction has been authorized
	 */
	public void setIsAuthorized(Boolean value) {
		this.isAuthorized = value;
	}

	/**
	 * Indicates if the transaction has been authorized
	 */
	public PaymentStatusOutput withIsAuthorized(Boolean value) {
		this.isAuthorized = value;
		return this;
	}

	/**
	 * Flag indicating if the payment can be cancelled
	 */
	public Boolean getIsCancellable() {
		return isCancellable;
	}

	/**
	 * Flag indicating if the payment can be cancelled
	 */
	public void setIsCancellable(Boolean value) {
		this.isCancellable = value;
	}

	/**
	 * Flag indicating if the payment can be cancelled
	 */
	public PaymentStatusOutput withIsCancellable(Boolean value) {
		this.isCancellable = value;
		return this;
	}

	/**
	 * Flag indicating if the payment can be refunded
	 */
	public Boolean getIsRefundable() {
		return isRefundable;
	}

	/**
	 * Flag indicating if the payment can be refunded
	 */
	public void setIsRefundable(Boolean value) {
		this.isRefundable = value;
	}

	/**
	 * Flag indicating if the payment can be refunded
	 */
	public PaymentStatusOutput withIsRefundable(Boolean value) {
		this.isRefundable = value;
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
	public PaymentStatusOutput withStatusCategory(String value) {
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
	public PaymentStatusOutput withStatusCode(Integer value) {
		this.statusCode = value;
		return this;
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

	/**
	 * Timestamp of the latest status change
	 */
	public PaymentStatusOutput withStatusCodeChangeDateTime(String value) {
		this.statusCodeChangeDateTime = value;
		return this;
	}
}
