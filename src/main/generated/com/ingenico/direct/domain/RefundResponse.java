/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * This object has the numeric representation of the current refund status, timestamp of last status change and performable action on the current refund resource. In case of a rejected refund, detailed error information is listed.
 */
public class RefundResponse {

	private String id = null;

	private RefundOutput refundOutput = null;

	private String status = null;

	private OrderStatusOutput statusOutput = null;

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Object containing refund details
	 */
	public RefundOutput getRefundOutput() {
		return refundOutput;
	}

	/**
	 * Object containing refund details
	 */
	public void setRefundOutput(RefundOutput value) {
		this.refundOutput = value;
	}

	/**
	 * Current high-level status of the payment in a human-readable form.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Current high-level status of the payment in a human-readable form.
	 */
	public void setStatus(String value) {
		this.status = value;
	}

	public OrderStatusOutput getStatusOutput() {
		return statusOutput;
	}

	public void setStatusOutput(OrderStatusOutput value) {
		this.statusOutput = value;
	}
}
