/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing contact details like email address and phone number
 */
public class MandateContactDetails {

	private String emailAddress = null;

	/**
	 * Email address of the customer
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Email address of the customer
	 */
	public void setEmailAddress(String value) {
		this.emailAddress = value;
	}

	/**
	 * Email address of the customer
	 */
	public MandateContactDetails withEmailAddress(String value) {
		this.emailAddress = value;
		return this;
	}
}
