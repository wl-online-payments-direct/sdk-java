/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

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
	 * Email address of the customer
	 */
	public ContactDetails withEmailAddress(String value) {
		this.emailAddress = value;
		return this;
	}

	/**
	 * International version of the fax number of the customer including the leading + (i.e. +16127779311)
	 */
	public String getFaxNumber() {
		return faxNumber;
	}

	/**
	 * International version of the fax number of the customer including the leading + (i.e. +16127779311)
	 */
	public void setFaxNumber(String value) {
		this.faxNumber = value;
	}

	/**
	 * International version of the fax number of the customer including the leading + (i.e. +16127779311)
	 */
	public ContactDetails withFaxNumber(String value) {
		this.faxNumber = value;
		return this;
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
	 * International version of the mobile phone number of the customer including the leading + (i.e. +16127779311)
	 */
	public ContactDetails withMobilePhoneNumber(String value) {
		this.mobilePhoneNumber = value;
		return this;
	}

	/**
	 * International version of the phone number of the customer including the leading + (i.e. +16127779311)
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * International version of the phone number of the customer including the leading + (i.e. +16127779311)
	 */
	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
	}

	/**
	 * International version of the phone number of the customer including the leading + (i.e. +16127779311)
	 */
	public ContactDetails withPhoneNumber(String value) {
		this.phoneNumber = value;
		return this;
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

	/**
	 * International version of the work phone number of the customer including the leading + (i.e. +31235671500)
	 */
	public ContactDetails withWorkPhoneNumber(String value) {
		this.workPhoneNumber = value;
		return this;
	}
}
