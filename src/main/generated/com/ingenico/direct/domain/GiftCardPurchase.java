/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

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
}
