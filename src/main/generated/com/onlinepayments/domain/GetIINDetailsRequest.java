/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Input for the retrieval of the IIN details request
 */
public class GetIINDetailsRequest {

	private String bin = null;

	private PaymentContext paymentContext = null;

	/**
	 * The first digits of the credit card number from left to right with a minimum of 6 digits. Providing additional digits (up to 19) can result in more co-brands being returned.
	 */
	public String getBin() {
		return bin;
	}

	/**
	 * The first digits of the credit card number from left to right with a minimum of 6 digits. Providing additional digits (up to 19) can result in more co-brands being returned.
	 */
	public void setBin(String value) {
		this.bin = value;
	}

	/**
	 * The first digits of the credit card number from left to right with a minimum of 6 digits. Providing additional digits (up to 19) can result in more co-brands being returned.
	 */
	public GetIINDetailsRequest withBin(String value) {
		this.bin = value;
		return this;
	}

	public PaymentContext getPaymentContext() {
		return paymentContext;
	}

	public void setPaymentContext(PaymentContext value) {
		this.paymentContext = value;
	}

	public GetIINDetailsRequest withPaymentContext(PaymentContext value) {
		this.paymentContext = value;
		return this;
	}
}
