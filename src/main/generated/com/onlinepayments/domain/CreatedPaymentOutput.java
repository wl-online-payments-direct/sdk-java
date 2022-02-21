/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

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

	/**
	 * Object that holds the payment related properties
	 */
	public CreatedPaymentOutput withPayment(PaymentResponse value) {
		this.payment = value;
		return this;
	}

	public String getPaymentStatusCategory() {
		return paymentStatusCategory;
	}

	public void setPaymentStatusCategory(String value) {
		this.paymentStatusCategory = value;
	}

	public CreatedPaymentOutput withPaymentStatusCategory(String value) {
		this.paymentStatusCategory = value;
		return this;
	}
}
