/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class GetHostedCheckoutResponse {

	private CreatedPaymentOutput createdPaymentOutput = null;

	private String status = null;

	/**
	 * When a payment has been created during the hosted checkout session this object will return the details
	 */
	public CreatedPaymentOutput getCreatedPaymentOutput() {
		return createdPaymentOutput;
	}

	/**
	 * When a payment has been created during the hosted checkout session this object will return the details
	 */
	public void setCreatedPaymentOutput(CreatedPaymentOutput value) {
		this.createdPaymentOutput = value;
	}

	/**
	 * This is the status of the hosted checkout. Possible values are:
	 * * IN_PROGRESS - The checkout is still in progress and has not finished yet
	 * * PAYMENT_CREATED - A payment has been created
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * This is the status of the hosted checkout. Possible values are:
	 * * IN_PROGRESS - The checkout is still in progress and has not finished yet
	 * * PAYMENT_CREATED - A payment has been created
	 */
	public void setStatus(String value) {
		this.status = value;
	}
}
