/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class Customer {

    private CustomerAccount account;

    private String accountType;

    private Address billingAddress;

    private CompanyInformation companyInformation;

    private ContactDetails contactDetails;

    private CustomerDevice device;

    private String fiscalNumber;

    private String locale;

    private String merchantCustomerId;

    private PersonalInformation personalInformation;

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
     * Object containing data related to the account the customer has with you
     */
    public Customer withAccount(CustomerAccount value) {
        this.account = value;
        return this;
    }

    /**
     * Type of the customer account that is used to place this order. Can have one of the following values:
     * <ul>
     *   <li>none - The account that was used to place the order with is a guest account or no account was used at all</li>
     *   <li>created - The customer account was created during this transaction</li>
     *   <li>existing - The customer account was an already existing account prior to this transaction</li>
     * </ul>
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Type of the customer account that is used to place this order. Can have one of the following values:
     * <ul>
     *   <li>none - The account that was used to place the order with is a guest account or no account was used at all</li>
     *   <li>created - The customer account was created during this transaction</li>
     *   <li>existing - The customer account was an already existing account prior to this transaction</li>
     * </ul>
     */
    public void setAccountType(String value) {
        this.accountType = value;
    }

    /**
     * Type of the customer account that is used to place this order. Can have one of the following values:
     * <ul>
     *   <li>none - The account that was used to place the order with is a guest account or no account was used at all</li>
     *   <li>created - The customer account was created during this transaction</li>
     *   <li>existing - The customer account was an already existing account prior to this transaction</li>
     * </ul>
     */
    public Customer withAccountType(String value) {
        this.accountType = value;
        return this;
    }

    /**
     * Object containing billing address details.
     */
    public Address getBillingAddress() {
        return billingAddress;
    }

    /**
     * Object containing billing address details.
     */
    public void setBillingAddress(Address value) {
        this.billingAddress = value;
    }

    /**
     * Object containing billing address details.
     */
    public Customer withBillingAddress(Address value) {
        this.billingAddress = value;
        return this;
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
     * Object containing company information
     */
    public Customer withCompanyInformation(CompanyInformation value) {
        this.companyInformation = value;
        return this;
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
     * Object containing contact details like email address and phone number
     */
    public Customer withContactDetails(ContactDetails value) {
        this.contactDetails = value;
        return this;
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
     * Object containing information on the device and browser of the customer
     */
    public Customer withDevice(CustomerDevice value) {
        this.device = value;
        return this;
    }

    /**
     * Fiscal registration number of the customer or the tax registration number of the company for a business customer. Please find below specifics per country:
     * <ul>
     *   <li>Brazil - Consumer (CPF) with a length of 11 digits</li>
     *   <li>Brazil - Company (CNPJ) with a length of 14 digits</li>
     *   <li>Denmark - Consumer (CPR-nummer or personnummer) with a length of 10 digits</li>
     *   <li>Finland - Consumer (Finnish: henkilÃ¶tunnus (abbreviated as HETU), Swedish: personbeteckning) with a length of 11 characters</li>
     *   <li>Norway - Consumer (fÃ¸dselsnummer) with a length of 11 digits</li>
     *   <li>Sweden - Consumer (personnummer) with a length of 10 or 12 digits</li>
     * </ul>
     */
    public String getFiscalNumber() {
        return fiscalNumber;
    }

    /**
     * Fiscal registration number of the customer or the tax registration number of the company for a business customer. Please find below specifics per country:
     * <ul>
     *   <li>Brazil - Consumer (CPF) with a length of 11 digits</li>
     *   <li>Brazil - Company (CNPJ) with a length of 14 digits</li>
     *   <li>Denmark - Consumer (CPR-nummer or personnummer) with a length of 10 digits</li>
     *   <li>Finland - Consumer (Finnish: henkilÃ¶tunnus (abbreviated as HETU), Swedish: personbeteckning) with a length of 11 characters</li>
     *   <li>Norway - Consumer (fÃ¸dselsnummer) with a length of 11 digits</li>
     *   <li>Sweden - Consumer (personnummer) with a length of 10 or 12 digits</li>
     * </ul>
     */
    public void setFiscalNumber(String value) {
        this.fiscalNumber = value;
    }

    /**
     * Fiscal registration number of the customer or the tax registration number of the company for a business customer. Please find below specifics per country:
     * <ul>
     *   <li>Brazil - Consumer (CPF) with a length of 11 digits</li>
     *   <li>Brazil - Company (CNPJ) with a length of 14 digits</li>
     *   <li>Denmark - Consumer (CPR-nummer or personnummer) with a length of 10 digits</li>
     *   <li>Finland - Consumer (Finnish: henkilÃ¶tunnus (abbreviated as HETU), Swedish: personbeteckning) with a length of 11 characters</li>
     *   <li>Norway - Consumer (fÃ¸dselsnummer) with a length of 11 digits</li>
     *   <li>Sweden - Consumer (personnummer) with a length of 10 or 12 digits</li>
     * </ul>
     */
    public Customer withFiscalNumber(String value) {
        this.fiscalNumber = value;
        return this;
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
     * The locale that the customer should be addressed in (for 3rd parties). Note that some 3rd party providers only support the languageCode part of the locale, in those cases we will only use part of the locale provided.
     */
    public Customer withLocale(String value) {
        this.locale = value;
        return this;
    }

    /**
     * Your identifier for the customer. It is used in the fraud-screening process for payments on the payment platform.
     */
    public String getMerchantCustomerId() {
        return merchantCustomerId;
    }

    /**
     * Your identifier for the customer. It is used in the fraud-screening process for payments on the payment platform.
     */
    public void setMerchantCustomerId(String value) {
        this.merchantCustomerId = value;
    }

    /**
     * Your identifier for the customer. It is used in the fraud-screening process for payments on the payment platform.
     */
    public Customer withMerchantCustomerId(String value) {
        this.merchantCustomerId = value;
        return this;
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

    /**
     * Object containing personal information like name, date of birth and gender.
     */
    public Customer withPersonalInformation(PersonalInformation value) {
        this.personalInformation = value;
        return this;
    }
}
