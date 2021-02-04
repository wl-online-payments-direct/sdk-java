/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Object that holds the payment related properties
 */
public class PaymentResponse {

	private HostedCheckoutSpecificOutput hostedCheckoutSpecificOutput = null;

	private String id = null;

	private PaymentOutput paymentOutput = null;

	private String status = null;

	private PaymentStatusOutput statusOutput = null;

	/**
	 * Hosted Checkout specific information. Populated if the payment was created on the platform through a Hosted Checkout.
	 */
	public HostedCheckoutSpecificOutput getHostedCheckoutSpecificOutput() {
		return hostedCheckoutSpecificOutput;
	}

	/**
	 * Hosted Checkout specific information. Populated if the payment was created on the platform through a Hosted Checkout.
	 */
	public void setHostedCheckoutSpecificOutput(HostedCheckoutSpecificOutput value) {
		this.hostedCheckoutSpecificOutput = value;
	}

	/**
	 * Our unique payment transaction identifier
	 */
	public String getId() {
		return id;
	}

	/**
	 * Our unique payment transaction identifier
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Object containing payment details
	 */
	public PaymentOutput getPaymentOutput() {
		return paymentOutput;
	}

	/**
	 * Object containing payment details
	 */
	public void setPaymentOutput(PaymentOutput value) {
		this.paymentOutput = value;
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

	/**
	 * This object has the numeric representation of the current payment status, timestamp of last status change and performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
	 */
	public PaymentStatusOutput getStatusOutput() {
		return statusOutput;
	}

	/**
	 * This object has the numeric representation of the current payment status, timestamp of last status change and performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
	 */
	public void setStatusOutput(PaymentStatusOutput value) {
		this.statusOutput = value;
	}
}
