/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing contact details like email address and phone number
 */
public class ContactDetails {

	private String emailAddress = null;

	private String faxNumber = null;

	private String mobilePhoneNumber = null;

	private String phoneNumber = null;

	private String workPhoneNumber = null;

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
	 * Fax number of the customer
	 */
	public String getFaxNumber() {
		return faxNumber;
	}

	/**
	 * Fax number of the customer
	 */
	public void setFaxNumber(String value) {
		this.faxNumber = value;
	}

	/**
	 * International version of the mobile phone number of the customer including the leading + (i.e. +16127779311)
	 */
	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	/**
	 * International version of the mobile phone number of the customer including the leading + (i.e. +16127779311)
	 */
	public void setMobilePhoneNumber(String value) {
		this.mobilePhoneNumber = value;
	}

	/**
	 * Phone number of the customer
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Phone number of the customer
	 */
	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
	}

	/**
	 * International version of the work phone number of the customer including the leading + (i.e. +31235671500)
	 */
	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	/**
	 * International version of the work phone number of the customer including the leading + (i.e. +31235671500)
	 */
	public void setWorkPhoneNumber(String value) {
		this.workPhoneNumber = value;
	}
}
