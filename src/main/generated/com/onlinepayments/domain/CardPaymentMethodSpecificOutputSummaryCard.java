/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CardPaymentMethodSpecificOutputSummaryCard {

    private String cardNumber;

    /**
     * The masked credit/debit card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * The masked credit/debit card number
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * The masked credit/debit card number
     */
    public CardPaymentMethodSpecificOutputSummaryCard withCardNumber(String value) {
        this.cardNumber = value;
        return this;
    }
}
