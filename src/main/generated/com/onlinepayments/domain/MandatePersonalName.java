/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing the name details of the customer.
 * Required for Create mandate and Create payment calls.
 */
public class MandatePersonalName {

	private String firstName = null;

	private String surname = null;

	/**
	 * Given name(s) or first name(s) of the customer.
	 * Required for Create mandate and Create payment calls.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Given name(s) or first name(s) of the customer.
	 * Required for Create mandate and Create payment calls.
	 */
	public void setFirstName(String value) {
		this.firstName = value;
	}

	/**
	 * Given name(s) or first name(s) of the customer.
	 * Required for Create mandate and Create payment calls.
	 */
	public MandatePersonalName withFirstName(String value) {
		this.firstName = value;
		return this;
	}

	/**
	 * Surname(s) or last name(s) of the customer.
	 * Required for Create mandate and Create payment calls.
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Surname(s) or last name(s) of the customer.
	 * Required for Create mandate and Create payment calls.
	 */
	public void setSurname(String value) {
		this.surname = value;
	}

	/**
	 * Surname(s) or last name(s) of the customer.
	 * Required for Create mandate and Create payment calls.
	 */
	public MandatePersonalName withSurname(String value) {
		this.surname = value;
		return this;
	}
}
