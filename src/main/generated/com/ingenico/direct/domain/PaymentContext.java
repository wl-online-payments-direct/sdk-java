/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

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
}
