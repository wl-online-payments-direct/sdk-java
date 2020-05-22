/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing the details of the customer
 */
public class Customer {

	private CustomerAccount account = null;

	private String accountType = null;

	private Address billingAddress = null;

	private CompanyInformation companyInformation = null;

	private ContactDetails contactDetails = null;

	private CustomerDevice device = null;

	private String fiscalNumber = null;

	private String locale = null;

	private String merchantCustomerId = null;

	private PersonalInformation personalInformation = null;

	/**
	 * Object containing data related to the account the customer has with you
	 */
	public CustomerAccount getAccount() {
		return account;
	}

	/**
	 * Object containing data related to the account the customer has with you
	 */
	public void setAccount(CustomerAccount value) {
		this.account = value;
	}

	/**
	 * Type of the customer account that is used to place this order. Can have one of the following values:
	 *  * none - The account that was used to place the order with is a guest account or no account was used at all
	 *  * created - The customer account was created during this transaction
	 *  * existing - The customer account was an already existing account prior to this transaction
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * Type of the customer account that is used to place this order. Can have one of the following values:
	 *  * none - The account that was used to place the order with is a guest account or no account was used at all
	 *  * created - The customer account was created during this transaction
	 *  * existing - The customer account was an already existing account prior to this transaction
	 */
	public void setAccountType(String value) {
		this.accountType = value;
	}

	/**
	 * Object containing billing address details
	 */
	public Address getBillingAddress() {
		return billingAddress;
	}

	/**
	 * Object containing billing address details
	 */
	public void setBillingAddress(Address value) {
		this.billingAddress = value;
	}

	/**
	 * Object containing company information
	 */
	public CompanyInformation getCompanyInformation() {
		return companyInformation;
	}

	/**
	 * Object containing company information
	 */
	public void setCompanyInformation(CompanyInformation value) {
		this.companyInformation = value;
	}

	/**
	 * Object containing contact details like email address and phone number
	 */
	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	/**
	 * Object containing contact details like email address and phone number
	 */
	public void setContactDetails(ContactDetails value) {
		this.contactDetails = value;
	}

	/**
	 * Object containing information on the device and browser of the customer
	 */
	public CustomerDevice getDevice() {
		return device;
	}

	/**
	 * Object containing information on the device and browser of the customer
	 */
	public void setDevice(CustomerDevice value) {
		this.device = value;
	}

	/**
	 * Fiscal registration number of the customer or the tax registration number of the company for a business customer. Please find below specifics per country:
	 *  * Brazil - Consumer (CPF) with a length of 11 digits
	 *  * Brazil - Company (CNPJ) with a length of 14 digits
	 *  * Denmark - Consumer (CPR-nummer or personnummer) with a length of 10 digits
	 *  * Finland - Consumer (Finnish: henkilötunnus (abbreviated as HETU), Swedish: personbeteckning) with a length of 11 characters
	 *  * Norway - Consumer (fødselsnummer) with a length of 11 digits
	 *  * Sweden - Consumer (personnummer) with a length of 10 or 12 digits
	 */
	public String getFiscalNumber() {
		return fiscalNumber;
	}

	/**
	 * Fiscal registration number of the customer or the tax registration number of the company for a business customer. Please find below specifics per country:
	 *  * Brazil - Consumer (CPF) with a length of 11 digits
	 *  * Brazil - Company (CNPJ) with a length of 14 digits
	 *  * Denmark - Consumer (CPR-nummer or personnummer) with a length of 10 digits
	 *  * Finland - Consumer (Finnish: henkilötunnus (abbreviated as HETU), Swedish: personbeteckning) with a length of 11 characters
	 *  * Norway - Consumer (fødselsnummer) with a length of 11 digits
	 *  * Sweden - Consumer (personnummer) with a length of 10 or 12 digits
	 */
	public void setFiscalNumber(String value) {
		this.fiscalNumber = value;
	}

	/**
	 * The locale that the customer should be addressed in (for 3rd parties). Note that some 3rd party providers only support the languageCode part of the locale, in those cases we will only use part of the locale provided.
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * The locale that the customer should be addressed in (for 3rd parties). Note that some 3rd party providers only support the languageCode part of the locale, in those cases we will only use part of the locale provided.
	 */
	public void setLocale(String value) {
		this.locale = value;
	}

	/**
	 * Your identifier for the customer. It is used in the fraud-screening process for payments on the Ogone Payment Platform.
	 */
	public String getMerchantCustomerId() {
		return merchantCustomerId;
	}

	/**
	 * Your identifier for the customer. It is used in the fraud-screening process for payments on the Ogone Payment Platform.
	 */
	public void setMerchantCustomerId(String value) {
		this.merchantCustomerId = value;
	}

	/**
	 * Object containing personal information like name, date of birth and gender.
	 */
	public PersonalInformation getPersonalInformation() {
		return personalInformation;
	}

	/**
	 * Object containing personal information like name, date of birth and gender.
	 */
	public void setPersonalInformation(PersonalInformation value) {
		this.personalInformation = value;
	}
}
