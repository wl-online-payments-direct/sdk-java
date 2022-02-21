/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing information on purchased gift card(s)
 */
public class GiftCardPurchase {

	private AmountOfMoney amountOfMoney = null;

	private Integer numberOfGiftCards = null;

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
	public GiftCardPurchase withAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
		return this;
	}

	/**
	 * Number of gift cards that are purchased through this transaction
	 */
	public Integer getNumberOfGiftCards() {
		return numberOfGiftCards;
	}

	/**
	 * Number of gift cards that are purchased through this transaction
	 */
	public void setNumberOfGiftCards(Integer value) {
		this.numberOfGiftCards = value;
	}

	/**
	 * Number of gift cards that are purchased through this transaction
	 */
	public GiftCardPurchase withNumberOfGiftCards(Integer value) {
		this.numberOfGiftCards = value;
		return this;
	}
}
