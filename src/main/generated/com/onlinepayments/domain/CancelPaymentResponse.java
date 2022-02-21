/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class CancelPaymentResponse {

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
	public CancelPaymentResponse withPayment(PaymentResponse value) {
		this.payment = value;
		return this;
	}
}
