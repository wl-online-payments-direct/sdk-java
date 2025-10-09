/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class Card {

    private String cardNumber;

    private String cardholderName;

    private String cvv;

    private String expiryDate;

    /**
     * The complete credit/debit card number (also known as the PAN) is always obfuscated in any of our responses.
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * The complete credit/debit card number (also known as the PAN) is always obfuscated in any of our responses.
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * The complete credit/debit card number (also known as the PAN) is always obfuscated in any of our responses.
     */
    public Card withCardNumber(String value) {
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
    public Card withCardholderName(String value) {
        this.cardholderName = value;
        return this;
    }

    /**
     * Card Verification Value, a 3 or 4 digit code used as an additional security feature for card not present transactions.
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * Card Verification Value, a 3 or 4 digit code used as an additional security feature for card not present transactions.
     */
    public void setCvv(String value) {
        this.cvv = value;
    }

    /**
     * Card Verification Value, a 3 or 4 digit code used as an additional security feature for card not present transactions.
     */
    public Card withCvv(String value) {
        this.cvv = value;
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
    public Card withExpiryDate(String value) {
        this.expiryDate = value;
        return this;
    }
}
