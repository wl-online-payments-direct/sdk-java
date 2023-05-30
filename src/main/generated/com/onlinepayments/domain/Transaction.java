/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class Transaction {

	private AmountOfMoney amount = null;

	private String localDateTime = null;

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getAmount() {
		return amount;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setAmount(AmountOfMoney value) {
		this.amount = value;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public Transaction withAmount(AmountOfMoney value) {
		this.amount = value;
		return this;
	}

	/**
	 * This must be the DateTime of the buyer's browser
	 * Entered in the following format: YYYY-MM-DDTHH:MM:SS. If the timestamp is more than a day (86400 seconds) away from the current time, the request will be rejected
	 */
	public String getLocalDateTime() {
		return localDateTime;
	}

	/**
	 * This must be the DateTime of the buyer's browser
	 * Entered in the following format: YYYY-MM-DDTHH:MM:SS. If the timestamp is more than a day (86400 seconds) away from the current time, the request will be rejected
	 */
	public void setLocalDateTime(String value) {
		this.localDateTime = value;
	}

	/**
	 * This must be the DateTime of the buyer's browser
	 * Entered in the following format: YYYY-MM-DDTHH:MM:SS. If the timestamp is more than a day (86400 seconds) away from the current time, the request will be rejected
	 */
	public Transaction withLocalDateTime(String value) {
		this.localDateTime = value;
		return this;
	}
}
