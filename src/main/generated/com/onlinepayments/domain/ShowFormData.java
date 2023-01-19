/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object returned for the SHOW_FORM actionType.
 */
public class ShowFormData {

	private PaymentProduct5404 paymentProduct5404 = null;

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
}
