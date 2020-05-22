/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
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
	 * * CANCELLED_BY_CONSUMER - If a customer cancels the payment on the payment product detail page of the HostedCheckout hosted payment pages, the status will change to IN_PROGRESS. Since we understand you want to be aware of a customer cancelling the payment on the page we host for you, you can choose to receive the status CANCELLED_BY_CONSUMER instead of the status IN_PROGRESS. In order to receive the status CANCELLED_BY_CONSUMER, you need to have the returnCancelState flag enabled in the Create hosted checkout call.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * This is the status of the hosted checkout. Possible values are:
	 * * IN_PROGRESS - The checkout is still in progress and has not finished yet
	 * * PAYMENT_CREATED - A payment has been created
	 * * CANCELLED_BY_CONSUMER - If a customer cancels the payment on the payment product detail page of the HostedCheckout hosted payment pages, the status will change to IN_PROGRESS. Since we understand you want to be aware of a customer cancelling the payment on the page we host for you, you can choose to receive the status CANCELLED_BY_CONSUMER instead of the status IN_PROGRESS. In order to receive the status CANCELLED_BY_CONSUMER, you need to have the returnCancelState flag enabled in the Create hosted checkout call.
	 */
	public void setStatus(String value) {
		this.status = value;
	}
}
