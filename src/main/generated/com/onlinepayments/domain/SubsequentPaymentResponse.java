/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object that contains details on the created payment in case one has been created.
 */
public class SubsequentPaymentResponse {

	private PaymentResponse payment = null;

	/**
	 * Object that holds the payment related properties
	 */
	public PaymentResponse getPayment() {
		return payment;
	}

	/**
	 * Object that holds the payment related properties
	 */
	public void setPayment(PaymentResponse value) {
		this.payment = value;
	}

	/**
	 * Object that holds the payment related properties
	 */
	public SubsequentPaymentResponse withPayment(PaymentResponse value) {
		this.payment = value;
		return this;
	}
}
