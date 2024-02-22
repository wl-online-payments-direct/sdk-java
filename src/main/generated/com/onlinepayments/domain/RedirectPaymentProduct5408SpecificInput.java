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
	 * * true - consumer can only use instant payment for Account to Account Bank transfer payments
	 * * false - consumer can only use standard payment for Account to Account Bank transfer payments
	 */
	public Boolean getInstantPaymentOnly() {
		return instantPaymentOnly;
	}

	/**
	 * * true - consumer can only use instant payment for Account to Account Bank transfer payments
	 * * false - consumer can only use standard payment for Account to Account Bank transfer payments
	 */
	public void setInstantPaymentOnly(Boolean value) {
		this.instantPaymentOnly = value;
	}

	/**
	 * * true - consumer can only use instant payment for Account to Account Bank transfer payments
	 * * false - consumer can only use standard payment for Account to Account Bank transfer payments
	 */
	public RedirectPaymentProduct5408SpecificInput withInstantPaymentOnly(Boolean value) {
		this.instantPaymentOnly = value;
		return this;
	}
}
