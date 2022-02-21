/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing the name details of the customer
 */
public class PersonalName {

	private String firstName = null;

	private String surname = null;

	private String title = null;

	/**
	 * Given name(s) or first name(s) of the customer
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Given name(s) or first name(s) of the customer
	 */
	public void setFirstName(String value) {
		this.firstName = value;
	}

	/**
	 * Given name(s) or first name(s) of the customer
	 */
	public PersonalName withFirstName(String value) {
		this.firstName = value;
		return this;
	}

	/**
	 * Surname(s) or last name(s) of the customer
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Surname(s) or last name(s) of the customer
	 */
	public void setSurname(String value) {
		this.surname = value;
	}

	/**
	 * Surname(s) or last name(s) of the customer
	 */
	public PersonalName withSurname(String value) {
		this.surname = value;
		return this;
	}

	/**
	 * Title of customer
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Title of customer
	 */
	public void setTitle(String value) {
		this.title = value;
	}

	/**
	 * Title of customer
	 */
	public PersonalName withTitle(String value) {
		this.title = value;
		return this;
	}
}
