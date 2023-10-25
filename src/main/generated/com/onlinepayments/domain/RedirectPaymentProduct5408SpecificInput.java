/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing specific input for Account to Account payments (Payment product ID 5408)
 */
public class RedirectPaymentProduct5408SpecificInput {

	private CustomerBankAccount customerBankAccount = null;

	private Boolean instantPaymentOnly = null;

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

	/**
	 * * true - customer is allowed to do only instant payment for Account to Account Bank transfer payments
	 * * false - customer is allowed to choose between instant or standard payment after the bank selection page for Account to Account Bank transfer payments
	 */
	public Boolean getInstantPaymentOnly() {
		return instantPaymentOnly;
	}

	/**
	 * * true - customer is allowed to do only instant payment for Account to Account Bank transfer payments
	 * * false - customer is allowed to choose between instant or standard payment after the bank selection page for Account to Account Bank transfer payments
	 */
	public void setInstantPaymentOnly(Boolean value) {
		this.instantPaymentOnly = value;
	}

	/**
	 * * true - customer is allowed to do only instant payment for Account to Account Bank transfer payments
	 * * false - customer is allowed to choose between instant or standard payment after the bank selection page for Account to Account Bank transfer payments
	 */
	public RedirectPaymentProduct5408SpecificInput withInstantPaymentOnly(Boolean value) {
		this.instantPaymentOnly = value;
		return this;
	}
}
