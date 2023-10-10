/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing specific input for Account to Account payments (Payment product ID 5408)
 */
public class RedirectPaymentProduct5408SpecificInput {

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
	public RedirectPaymentProduct5408SpecificInput withCustomerBankAccount(CustomerBankAccount value) {
		this.customerBankAccount = value;
		return this;
	}
}
