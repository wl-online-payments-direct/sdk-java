/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing specific input required for iDeal payments (Payment product ID 809)
 */
public class RedirectPaymentProduct809SpecificInput {

	private String issuerId = null;

	/**
	 * Unique ID of the issuing bank of the customer
	 */
	public String getIssuerId() {
		return issuerId;
	}

	/**
	 * Unique ID of the issuing bank of the customer
	 */
	public void setIssuerId(String value) {
		this.issuerId = value;
	}

	/**
	 * Unique ID of the issuing bank of the customer
	 */
	public RedirectPaymentProduct809SpecificInput withIssuerId(String value) {
		this.issuerId = value;
		return this;
	}
}
