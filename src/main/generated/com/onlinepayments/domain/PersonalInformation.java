/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing personal information like name, date of birth and gender.
 */
public class PersonalInformation {

	private String dateOfBirth = null;

	private String gender = null;

	private PersonalName name = null;

	/**
	 * The date of birth of the customer of the recipient of the loan.
	 * Format YYYYMMDD
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * The date of birth of the customer of the recipient of the loan.
	 * Format YYYYMMDD
	 */
	public void setDateOfBirth(String value) {
		this.dateOfBirth = value;
	}

	/**
	 * The date of birth of the customer of the recipient of the loan.
	 * Format YYYYMMDD
	 */
	public PersonalInformation withDateOfBirth(String value) {
		this.dateOfBirth = value;
		return this;
	}

	/**
	 * The gender of the customer, possible values are:
	 *  * male
	 *  * female
	 *  * unknown or empty
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * The gender of the customer, possible values are:
	 *  * male
	 *  * female
	 *  * unknown or empty
	 */
	public void setGender(String value) {
		this.gender = value;
	}

	/**
	 * The gender of the customer, possible values are:
	 *  * male
	 *  * female
	 *  * unknown or empty
	 */
	public PersonalInformation withGender(String value) {
		this.gender = value;
		return this;
	}

	/**
	 * Object containing the name details of the customer
	 */
	public PersonalName getName() {
		return name;
	}

	/**
	 * Object containing the name details of the customer
	 */
	public void setName(PersonalName value) {
		this.name = value;
	}

	/**
	 * Object containing the name details of the customer
	 */
	public PersonalInformation withName(PersonalName value) {
		this.name = value;
		return this;
	}
}
