/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

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
}
