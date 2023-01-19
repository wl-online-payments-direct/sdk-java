/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class CalculateSurchargeRequest {

	private AmountOfMoney amountOfMoney = null;

	private CardSource cardSource = null;

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
	public CalculateSurchargeRequest withAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
		return this;
	}

	/**
	 * Contains elements from which card number can be obtained.
	 */
	public CardSource getCardSource() {
		return cardSource;
	}

	/**
	 * Contains elements from which card number can be obtained.
	 */
	public void setCardSource(CardSource value) {
		this.cardSource = value;
	}

	/**
	 * Contains elements from which card number can be obtained.
	 */
	public CalculateSurchargeRequest withCardSource(CardSource value) {
		this.cardSource = value;
		return this;
	}
}
