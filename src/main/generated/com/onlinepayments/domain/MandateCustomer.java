/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Customer object containing customer specific inputs.
 * Required for Create mandate and Create payment calls.
 */
public class MandateCustomer {

	private BankAccountIban bankAccountIban = null;

	private String companyName = null;

	private MandateContactDetails contactDetails = null;

	private MandateAddress mandateAddress = null;

	private MandatePersonalInformation personalInformation = null;

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
	public MandateCustomer withBankAccountIban(BankAccountIban value) {
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
	public MandateCustomer withCompanyName(String value) {
		this.companyName = value;
		return this;
	}

	/**
	 * Object containing contact details like email address and phone number
	 */
	public MandateContactDetails getContactDetails() {
		return contactDetails;
	}

	/**
	 * Object containing contact details like email address and phone number
	 */
	public void setContactDetails(MandateContactDetails value) {
		this.contactDetails = value;
	}

	/**
	 * Object containing contact details like email address and phone number
	 */
	public MandateCustomer withContactDetails(MandateContactDetails value) {
		this.contactDetails = value;
		return this;
	}

	/**
	 * Object containing billing address details.
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public MandateAddress getMandateAddress() {
		return mandateAddress;
	}

	/**
	 * Object containing billing address details.
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public void setMandateAddress(MandateAddress value) {
		this.mandateAddress = value;
	}

	/**
	 * Object containing billing address details.
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public MandateCustomer withMandateAddress(MandateAddress value) {
		this.mandateAddress = value;
		return this;
	}

	/**
	 * Object containing personal information of the customer.
	 * Required for Create mandate and Create payment calls.
	 */
	public MandatePersonalInformation getPersonalInformation() {
		return personalInformation;
	}

	/**
	 * Object containing personal information of the customer.
	 * Required for Create mandate and Create payment calls.
	 */
	public void setPersonalInformation(MandatePersonalInformation value) {
		this.personalInformation = value;
	}

	/**
	 * Object containing personal information of the customer.
	 * Required for Create mandate and Create payment calls.
	 */
	public MandateCustomer withPersonalInformation(MandatePersonalInformation value) {
		this.personalInformation = value;
		return this;
	}
}
