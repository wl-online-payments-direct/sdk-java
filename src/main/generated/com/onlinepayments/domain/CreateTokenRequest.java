/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CreateTokenRequest {

    private TokenCardSpecificInput card;

    private String encryptedCustomerInput;

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
     * Data that was encrypted client side containing all customer entered data elements like card data.
     * Note: Because this data can only be submitted once to our system and contains encrypted card data you should not store it. As the data was captured within the context of a client session you also need to submit it to us before the session has expired.
     */
    public String getEncryptedCustomerInput() {
        return encryptedCustomerInput;
    }

    /**
     * Data that was encrypted client side containing all customer entered data elements like card data.
     * Note: Because this data can only be submitted once to our system and contains encrypted card data you should not store it. As the data was captured within the context of a client session you also need to submit it to us before the session has expired.
     */
    public void setEncryptedCustomerInput(String value) {
        this.encryptedCustomerInput = value;
    }

    /**
     * Data that was encrypted client side containing all customer entered data elements like card data.
     * Note: Because this data can only be submitted once to our system and contains encrypted card data you should not store it. As the data was captured within the context of a client session you also need to submit it to us before the session has expired.
     */
    public CreateTokenRequest withEncryptedCustomerInput(String value) {
        this.encryptedCustomerInput = value;
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
