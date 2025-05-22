/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CardSource {

    private SurchargeCalculationCard card;

    private String encryptedCustomerInput;

    private String hostedTokenizationId;

    private String token;

    /**
     * An object containing card number and payment product id, which is used to determine surcharge product type
     */
    public SurchargeCalculationCard getCard() {
        return card;
    }

    /**
     * An object containing card number and payment product id, which is used to determine surcharge product type
     */
    public void setCard(SurchargeCalculationCard value) {
        this.card = value;
    }

    /**
     * An object containing card number and payment product id, which is used to determine surcharge product type
     */
    public CardSource withCard(SurchargeCalculationCard value) {
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
    public CardSource withEncryptedCustomerInput(String value) {
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
    public CardSource withHostedTokenizationId(String value) {
        this.hostedTokenizationId = value;
        return this;
    }

    /**
     * An identifier that represents card details that have been previously stored
     */
    public String getToken() {
        return token;
    }

    /**
     * An identifier that represents card details that have been previously stored
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * An identifier that represents card details that have been previously stored
     */
    public CardSource withToken(String value) {
        this.token = value;
        return this;
    }
}
