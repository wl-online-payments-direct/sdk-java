/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class Transaction {

	private AmountOfMoney amount = null;

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
}
