/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object returned for the SHOW_FORM actionType.
 */
public class ShowFormData {

	private PaymentProduct3012 paymentProduct3012 = null;

	private PaymentProduct5404 paymentProduct5404 = null;

	private PaymentProduct5407 paymentProduct5407 = null;

	private PaymentProduct840 paymentProduct840 = null;

	/**
	 * Contains the third party data for payment product 3012 (Bancontact)
	 */
	public PaymentProduct3012 getPaymentProduct3012() {
		return paymentProduct3012;
	}

	/**
	 * Contains the third party data for payment product 3012 (Bancontact)
	 */
	public void setPaymentProduct3012(PaymentProduct3012 value) {
		this.paymentProduct3012 = value;
	}

	/**
	 * Contains the third party data for payment product 3012 (Bancontact)
	 */
	public ShowFormData withPaymentProduct3012(PaymentProduct3012 value) {
		this.paymentProduct3012 = value;
		return this;
	}

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

	/**
	 * Contains the third party data for payment product 840 (PayPal)
	 */
	public PaymentProduct840 getPaymentProduct840() {
		return paymentProduct840;
	}

	/**
	 * Contains the third party data for payment product 840 (PayPal)
	 */
	public void setPaymentProduct840(PaymentProduct840 value) {
		this.paymentProduct840 = value;
	}

	/**
	 * Contains the third party data for payment product 840 (PayPal)
	 */
	public ShowFormData withPaymentProduct840(PaymentProduct840 value) {
		this.paymentProduct840 = value;
		return this;
	}
}
