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
	 * Amount in the smallest currency unit, i.e.:
	 * * EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34
	 * * KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234
	 * * JPY is a zero-decimal currency, the value 1234 will result in JPY 1234
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * Amount in the smallest currency unit, i.e.:
	 * * EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34
	 * * KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234
	 * * JPY is a zero-decimal currency, the value 1234 will result in JPY 1234
	 */
	public void setAmount(Long value) {
		this.amount = value;
	}

	/**
	 * Amount in the smallest currency unit, i.e.:
	 * * EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34
	 * * KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234
	 * * JPY is a zero-decimal currency, the value 1234 will result in JPY 1234
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
