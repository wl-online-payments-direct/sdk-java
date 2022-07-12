/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class GetHostedCheckoutResponse {

	private CreatedPaymentOutput createdPaymentOutput = null;

	private String status = null;

	/**
	 * This object will return the details of the payment after the payment is cancelled by the customer, rejected or authorized
	 */
	public CreatedPaymentOutput getCreatedPaymentOutput() {
		return createdPaymentOutput;
	}

	/**
	 * This object will return the details of the payment after the payment is cancelled by the customer, rejected or authorized
	 */
	public void setCreatedPaymentOutput(CreatedPaymentOutput value) {
		this.createdPaymentOutput = value;
	}

	/**
	 * This object will return the details of the payment after the payment is cancelled by the customer, rejected or authorized
	 */
	public GetHostedCheckoutResponse withCreatedPaymentOutput(CreatedPaymentOutput value) {
		this.createdPaymentOutput = value;
		return this;
	}

	/**
	 * This is the status of the hosted checkout. Possible values are:
	 * * IN_PROGRESS - The checkout is still in progress and has not finished yet
	 * * PAYMENT_CREATED - A payment has been created
	 * * CANCELLED_BY_CONSUMER - The HostedCheckout session have been cancelled by the customer
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * This is the status of the hosted checkout. Possible values are:
	 * * IN_PROGRESS - The checkout is still in progress and has not finished yet
	 * * PAYMENT_CREATED - A payment has been created
	 * * CANCELLED_BY_CONSUMER - The HostedCheckout session have been cancelled by the customer
	 */
	public void setStatus(String value) {
		this.status = value;
	}

	/**
	 * This is the status of the hosted checkout. Possible values are:
	 * * IN_PROGRESS - The checkout is still in progress and has not finished yet
	 * * PAYMENT_CREATED - A payment has been created
	 * * CANCELLED_BY_CONSUMER - The HostedCheckout session have been cancelled by the customer
	 */
	public GetHostedCheckoutResponse withStatus(String value) {
		this.status = value;
		return this;
	}
}
