/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class DccCardSource {

    private CardInfo card;

    private String encryptedCustomerInput;

    private String hostedTokenizationId;

    private String token;

    public CardInfo getCard() {
        return card;
    }

    public void setCard(CardInfo value) {
        this.card = value;
    }

    public DccCardSource withCard(CardInfo value) {
        this.card = value;
        return this;
    }

    /**
     * Data that was encrypted client-side that contains all customer-entered data elements, such as card data.
     */
    public String getEncryptedCustomerInput() {
        return encryptedCustomerInput;
    }

    /**
     * Data that was encrypted client-side that contains all customer-entered data elements, such as card data.
     */
    public void setEncryptedCustomerInput(String value) {
        this.encryptedCustomerInput = value;
    }

    /**
     * Data that was encrypted client-side that contains all customer-entered data elements, such as card data.
     */
    public DccCardSource withEncryptedCustomerInput(String value) {
        this.encryptedCustomerInput = value;
        return this;
    }

    /**
     * An Id of a hosted tokenization session
     */
    public String getHostedTokenizationId() {
        return hostedTokenizationId;
    }

    /**
     * An Id of a hosted tokenization session
     */
    public void setHostedTokenizationId(String value) {
        this.hostedTokenizationId = value;
    }

    /**
     * An Id of a hosted tokenization session
     */
    public DccCardSource withHostedTokenizationId(String value) {
        this.hostedTokenizationId = value;
        return this;
    }

    /**
     * An identifier that represents card details that have previously been stored
     */
    public String getToken() {
        return token;
    }

    /**
     * An identifier that represents card details that have previously been stored
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * An identifier that represents card details that have previously been stored
     */
    public DccCardSource withToken(String value) {
        this.token = value;
        return this;
    }
}
