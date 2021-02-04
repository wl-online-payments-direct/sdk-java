/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Multibanco (payment product 5500) specific details
 */
public class PaymentProduct5500SpecificOutput {

	private String paymentEndDate = null;

	private String paymentReference = null;

	private String paymentStartDate = null;

	/**
	 * The end date of the payment validity
	 */
	public String getPaymentEndDate() {
		return paymentEndDate;
	}

	/**
	 * The end date of the payment validity
	 */
	public void setPaymentEndDate(String value) {
		this.paymentEndDate = value;
	}

	/**
	 * The reference to be used within the Multibanco network to confirm the payment
	 */
	public String getPaymentReference() {
		return paymentReference;
	}

	/**
	 * The reference to be used within the Multibanco network to confirm the payment
	 */
	public void setPaymentReference(String value) {
		this.paymentReference = value;
	}

	/**
	 * The start date of the payment validity
	 */
	public String getPaymentStartDate() {
		return paymentStartDate;
	}

	/**
	 * The start date of the payment validity
	 */
	public void setPaymentStartDate(String value) {
		this.paymentStartDate = value;
	}
}
