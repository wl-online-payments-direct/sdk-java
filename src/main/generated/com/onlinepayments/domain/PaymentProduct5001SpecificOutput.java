/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Bizum (payment product 5001) specific details
 */
public class PaymentProduct5001SpecificOutput {

	private String authorisationCode = null;

	/**
	 * The reference returned by redsys to identify the transaction
	 */
	public String getAuthorisationCode() {
		return authorisationCode;
	}

	/**
	 * The reference returned by redsys to identify the transaction
	 */
	public void setAuthorisationCode(String value) {
		this.authorisationCode = value;
	}

	/**
	 * The reference returned by redsys to identify the transaction
	 */
	public PaymentProduct5001SpecificOutput withAuthorisationCode(String value) {
		this.authorisationCode = value;
		return this;
	}
}
