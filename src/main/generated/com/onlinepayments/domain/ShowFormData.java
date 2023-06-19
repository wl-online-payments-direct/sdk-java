/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object returned for the SHOW_FORM actionType.
 */
public class ShowFormData {

	private PaymentProduct5404 paymentProduct5404 = null;

	private PaymentProduct5407 paymentProduct5407 = null;

	/**
	 * Contains the third party data for payment product 5404 (WeChat Pay)
	 */
	public PaymentProduct5404 getPaymentProduct5404() {
		return paymentProduct5404;
	}

	/**
	 * Contains the third party data for payment product 5404 (WeChat Pay)
	 */
	public void setPaymentProduct5404(PaymentProduct5404 value) {
		this.paymentProduct5404 = value;
	}

	/**
	 * Contains the third party data for payment product 5404 (WeChat Pay)
	 */
	public ShowFormData withPaymentProduct5404(PaymentProduct5404 value) {
		this.paymentProduct5404 = value;
		return this;
	}

	/**
	 * Contains the third party data for payment product 5407 (Twint)
	 */
	public PaymentProduct5407 getPaymentProduct5407() {
		return paymentProduct5407;
	}

	/**
	 * Contains the third party data for payment product 5407 (Twint)
	 */
	public void setPaymentProduct5407(PaymentProduct5407 value) {
		this.paymentProduct5407 = value;
	}

	/**
	 * Contains the third party data for payment product 5407 (Twint)
	 */
	public ShowFormData withPaymentProduct5407(PaymentProduct5407 value) {
		this.paymentProduct5407 = value;
		return this;
	}
}
