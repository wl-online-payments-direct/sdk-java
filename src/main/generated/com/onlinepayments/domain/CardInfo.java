/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CardInfo {

    private String cardNumber;

    private Integer paymentProductId;

    /**
     * The complete credit/debit card number (also know as the PAN)
     * The card number is always obfuscated in any of our responses
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * The complete credit/debit card number (also know as the PAN)
     * The card number is always obfuscated in any of our responses
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * The complete credit/debit card number (also know as the PAN)
     * The card number is always obfuscated in any of our responses
     */
    public CardInfo withCardNumber(String value) {
        this.cardNumber = value;
        return this;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public Integer getPaymentProductId() {
        return paymentProductId;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public void setPaymentProductId(Integer value) {
        this.paymentProductId = value;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public CardInfo withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }
}
