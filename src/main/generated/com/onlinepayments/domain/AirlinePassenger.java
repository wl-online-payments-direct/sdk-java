/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class AirlinePassenger {

	private String firstName = null;

	private String surname = null;

	private String surnamePrefix = null;

	private String title = null;

	/**
	 * First name of the passenger
	 * This field is used by the following payment products: cards, 840
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * First name of the passenger
	 * This field is used by the following payment products: cards, 840
	 */
	public void setFirstName(String value) {
		this.firstName = value;
	}

	/**
	 * First name of the passenger
	 * This field is used by the following payment products: cards, 840
	 */
	public AirlinePassenger withFirstName(String value) {
		this.firstName = value;
		return this;
	}

	/**
	 * Surname of the passenger
	 * This field is used by the following payment products: cards, 840
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Surname of the passenger
	 * This field is used by the following payment products: cards, 840
	 */
	public void setSurname(String value) {
		this.surname = value;
	}

	/**
	 * Surname of the passenger
	 * This field is used by the following payment products: cards, 840
	 */
	public AirlinePassenger withSurname(String value) {
		this.surname = value;
		return this;
	}

	/**
	 * Surname prefix or middle name of the passenger
	 * This field is used by the following payment products: 840
	 */
	public String getSurnamePrefix() {
		return surnamePrefix;
	}

	/**
	 * Surname prefix or middle name of the passenger
	 * This field is used by the following payment products: 840
	 */
	public void setSurnamePrefix(String value) {
		this.surnamePrefix = value;
	}

	/**
	 * Surname prefix or middle name of the passenger
	 * This field is used by the following payment products: 840
	 */
	public AirlinePassenger withSurnamePrefix(String value) {
		this.surnamePrefix = value;
		return this;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Title of the passenger (this property is used for fraud screening on the payment platform)
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Title of the passenger (this property is used for fraud screening on the payment platform)
	 */
	public void setTitle(String value) {
		this.title = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Title of the passenger (this property is used for fraud screening on the payment platform)
	 */
	public AirlinePassenger withTitle(String value) {
		this.title = value;
		return this;
	}
}
