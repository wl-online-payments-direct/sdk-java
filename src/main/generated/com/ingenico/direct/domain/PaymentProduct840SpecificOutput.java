/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * PayPal (payment product 840) specific details
 */
public class PaymentProduct840SpecificOutput {

	private Address billingAddress = null;

	private PaymentProduct840CustomerAccount customerAccount = null;

	private Address customerAddress = null;

	private ProtectionEligibility protectionEligibility = null;

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
	 * Object containing the details of the PayPal account
	 */
	public PaymentProduct840CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	/**
	 * Object containing the details of the PayPal account
	 */
	public void setCustomerAccount(PaymentProduct840CustomerAccount value) {
		this.customerAccount = value;
	}

	/**
	 * Object containing billing address details
	 */
	public Address getCustomerAddress() {
		return customerAddress;
	}

	/**
	 * Object containing billing address details
	 */
	public void setCustomerAddress(Address value) {
		this.customerAddress = value;
	}

	/**
	 * Kind of seller protection in force for the PayPal transaction
	 */
	public ProtectionEligibility getProtectionEligibility() {
		return protectionEligibility;
	}

	/**
	 * Kind of seller protection in force for the PayPal transaction
	 */
	public void setProtectionEligibility(ProtectionEligibility value) {
		this.protectionEligibility = value;
	}
}
