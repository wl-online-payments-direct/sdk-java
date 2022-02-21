/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class PaymentContext {

	private AmountOfMoney amountOfMoney = null;

	private String countryCode = null;

	private Boolean isRecurring = null;

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getAmountOfMoney() {
		return amountOfMoney;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public PaymentContext withAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
		return this;
	}

	/**
	 * The country the payment takes place in
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * The country the payment takes place in
	 */
	public void setCountryCode(String value) {
		this.countryCode = value;
	}

	/**
	 * The country the payment takes place in
	 */
	public PaymentContext withCountryCode(String value) {
		this.countryCode = value;
		return this;
	}

	/**
	 * True if the payment is recurring
	 */
	public Boolean getIsRecurring() {
		return isRecurring;
	}

	/**
	 * True if the payment is recurring
	 */
	public void setIsRecurring(Boolean value) {
		this.isRecurring = value;
	}

	/**
	 * True if the payment is recurring
	 */
	public PaymentContext withIsRecurring(Boolean value) {
		this.isRecurring = value;
		return this;
	}
}
