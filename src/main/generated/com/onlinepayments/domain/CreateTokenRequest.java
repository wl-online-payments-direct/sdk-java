/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CreateTokenRequest {

    private TokenCardSpecificInput card;

    private Integer paymentProductId;

    /**
     * Object containing the token details for a card
     */
    public TokenCardSpecificInput getCard() {
        return card;
    }

    /**
     * Object containing the token details for a card
     */
    public void setCard(TokenCardSpecificInput value) {
        this.card = value;
    }

    /**
     * Object containing the token details for a card
     */
    public CreateTokenRequest withCard(TokenCardSpecificInput value) {
        this.card = value;
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
    public CreateTokenRequest withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }
}
