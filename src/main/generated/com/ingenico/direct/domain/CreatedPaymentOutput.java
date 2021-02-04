/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * When a payment has been created during the hosted checkout session this object will return the details
 */
public class CreatedPaymentOutput {

	private PaymentResponse payment = null;

	private String paymentStatusCategory = null;

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

	public String getPaymentStatusCategory() {
		return paymentStatusCategory;
	}

	public void setPaymentStatusCategory(String value) {
		this.paymentStatusCategory = value;
	}
}
