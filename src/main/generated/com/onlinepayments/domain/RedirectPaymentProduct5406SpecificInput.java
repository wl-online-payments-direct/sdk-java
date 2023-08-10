/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing specific input for EPS payments (Payment product ID 5406)
 */
public class RedirectPaymentProduct5406SpecificInput {

	private CustomerBankAccount customerBankAccount = null;

	/**
	 * Data of customer bank account
	 */
	public CustomerBankAccount getCustomerBankAccount() {
		return customerBankAccount;
	}

	/**
	 * Data of customer bank account
	 */
	public void setCustomerBankAccount(CustomerBankAccount value) {
		this.customerBankAccount = value;
	}

	/**
	 * Data of customer bank account
	 */
	public RedirectPaymentProduct5406SpecificInput withCustomerBankAccount(CustomerBankAccount value) {
		this.customerBankAccount = value;
		return this;
	}
}
