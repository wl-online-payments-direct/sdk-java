/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CardPaymentMethodSpecificOutputSummary {

    private CardPaymentMethodSpecificOutputSummaryCard card;

    private String token;

    /**
     * Card details
     */
    public CardPaymentMethodSpecificOutputSummaryCard getCard() {
        return card;
    }

    /**
     * Card details
     */
    public void setCard(CardPaymentMethodSpecificOutputSummaryCard value) {
        this.card = value;
    }

    /**
     * Card details
     */
    public CardPaymentMethodSpecificOutputSummary withCard(CardPaymentMethodSpecificOutputSummaryCard value) {
        this.card = value;
        return this;
    }

    /**
     * ID of the token. This property is populated when the payment was done with a token or when the payment was tokenized.
     */
    public String getToken() {
        return token;
    }

    /**
     * ID of the token. This property is populated when the payment was done with a token or when the payment was tokenized.
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * ID of the token. This property is populated when the payment was done with a token or when the payment was tokenized.
     */
    public CardPaymentMethodSpecificOutputSummary withToken(String value) {
        this.token = value;
        return this;
    }
}
