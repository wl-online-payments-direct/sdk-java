/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing amount and ISO currency code attributes
 */
public class AmountOfMoney {

	private Long amount = null;

	private String currencyCode = null;

	/**
	 * Amount in cents and always having 2 decimals
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * Amount in cents and always having 2 decimals
	 */
	public void setAmount(Long value) {
		this.amount = value;
	}

	/**
	 * Amount in cents and always having 2 decimals
	 */
	public AmountOfMoney withAmount(Long value) {
		this.amount = value;
		return this;
	}

	/**
	 * Three-letter ISO currency code representing the currency for the amount
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * Three-letter ISO currency code representing the currency for the amount
	 */
	public void setCurrencyCode(String value) {
		this.currencyCode = value;
	}

	/**
	 * Three-letter ISO currency code representing the currency for the amount
	 */
	public AmountOfMoney withCurrencyCode(String value) {
		this.currencyCode = value;
		return this;
	}
}
