/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class GiftCardPurchase {

    private AmountOfMoney amountOfMoney;

    private Integer numberOfGiftCards;

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
