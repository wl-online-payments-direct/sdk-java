/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Input for the retrieval of the IIN details request
 */
public class GetIINDetailsRequest {

	private String bin = null;

	private PaymentContext paymentContext = null;

	/**
	 * The first digits of the credit card number from left to right with a minimum of 6 digits. Providing additional digits can result in more co-brands being returned.
	 */
	public String getBin() {
		return bin;
	}

	/**
	 * The first digits of the credit card number from left to right with a minimum of 6 digits. Providing additional digits can result in more co-brands being returned.
	 */
	public void setBin(String value) {
		this.bin = value;
	}

	public PaymentContext getPaymentContext() {
		return paymentContext;
	}

	public void setPaymentContext(PaymentContext value) {
		this.paymentContext = value;
	}
}
