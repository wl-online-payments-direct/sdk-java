/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CardWithoutCvv {

    private String cardNumber;

    private String cardholderName;

    private String expiryDate;

    /**
     * The obfuscated card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * The obfuscated card number
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * The obfuscated card number
     */
    public CardWithoutCvv withCardNumber(String value) {
        this.cardNumber = value;
        return this;
    }

    /**
     * The card holder's name on the card.
     */
    public String getCardholderName() {
        return cardholderName;
    }

    /**
     * The card holder's name on the card.
     */
    public void setCardholderName(String value) {
        this.cardholderName = value;
    }

    /**
     * The card holder's name on the card.
     */
    public CardWithoutCvv withCardholderName(String value) {
        this.cardholderName = value;
        return this;
    }

    /**
     * Expiry date of the card
     * Format: MMYY
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Expiry date of the card
     * Format: MMYY
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

    /**
     * Expiry date of the card
     * Format: MMYY
     */
    public CardWithoutCvv withExpiryDate(String value) {
        this.expiryDate = value;
        return this;
    }
}
