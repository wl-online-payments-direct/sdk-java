/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Customer object containing customer specific outputs.
 */
public class MandateCustomerResponse {

	private BankAccountIban bankAccountIban = null;

	private String companyName = null;

	private MandateContactDetails contactDetails = null;

	private MandateAddressResponse mandateAddress = null;

	private MandatePersonalInformationResponse personalInformation = null;

	/**
	 * Object containing IBAN information
	 */
	public BankAccountIban getBankAccountIban() {
		return bankAccountIban;
	}

	/**
	 * Object containing IBAN information
	 */
	public void setBankAccountIban(BankAccountIban value) {
		this.bankAccountIban = value;
	}

	/**
	 * Object containing IBAN information
	 */
	public MandateCustomerResponse withBankAccountIban(BankAccountIban value) {
		this.bankAccountIban = value;
		return this;
	}

	/**
	 * Name of company, as a customer
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Name of company, as a customer
	 */
	public void setCompanyName(String value) {
		this.companyName = value;
	}

	/**
	 * Name of company, as a customer
	 */
	public MandateCustomerResponse withCompanyName(String value) {
		this.companyName = value;
		return this;
	}

	/**
	 * Object containing email address
	 */
	public MandateContactDetails getContactDetails() {
		return contactDetails;
	}

	/**
	 * Object containing email address
	 */
	public void setContactDetails(MandateContactDetails value) {
		this.contactDetails = value;
	}

	/**
	 * Object containing email address
	 */
	public MandateCustomerResponse withContactDetails(MandateContactDetails value) {
		this.contactDetails = value;
		return this;
	}

	/**
	 * Object containing consumer address details
	 */
	public MandateAddressResponse getMandateAddress() {
		return mandateAddress;
	}

	/**
	 * Object containing consumer address details
	 */
	public void setMandateAddress(MandateAddressResponse value) {
		this.mandateAddress = value;
	}

	/**
	 * Object containing consumer address details
	 */
	public MandateCustomerResponse withMandateAddress(MandateAddressResponse value) {
		this.mandateAddress = value;
		return this;
	}

	/**
	 * Object containing personal information of the customer
	 */
	public MandatePersonalInformationResponse getPersonalInformation() {
		return personalInformation;
	}

	/**
	 * Object containing personal information of the customer
	 */
	public void setPersonalInformation(MandatePersonalInformationResponse value) {
		this.personalInformation = value;
	}

	/**
	 * Object containing personal information of the customer
	 */
	public MandateCustomerResponse withPersonalInformation(MandatePersonalInformationResponse value) {
		this.personalInformation = value;
		return this;
	}
}
