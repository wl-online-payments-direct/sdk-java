/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class CustomerToken {

	private Address billingAddress = null;

	private CompanyInformation companyInformation = null;

	private PersonalInformationToken personalInformation = null;

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
	 * Object containing billing address details
	 */
	public CustomerToken withBillingAddress(Address value) {
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
	public CustomerToken withCompanyInformation(CompanyInformation value) {
		this.companyInformation = value;
		return this;
	}

	public PersonalInformationToken getPersonalInformation() {
		return personalInformation;
	}

	public void setPersonalInformation(PersonalInformationToken value) {
		this.personalInformation = value;
	}

	public CustomerToken withPersonalInformation(PersonalInformationToken value) {
		this.personalInformation = value;
		return this;
	}
}
