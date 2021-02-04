/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

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
}
