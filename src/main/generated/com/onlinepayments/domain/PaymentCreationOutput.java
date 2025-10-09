/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentCreationOutput {

    private String externalReference;

    private Boolean isNewToken;

    private String token;

    private Boolean tokenizationSucceeded;

    /**
     * The external reference identifier for this transaction. Data in this property will also be returned in our report files, allowing you to reconcile them
     */
    public String getExternalReference() {
        return externalReference;
    }

    /**
     * The external reference identifier for this transaction. Data in this property will also be returned in our report files, allowing you to reconcile them
     */
    public void setExternalReference(String value) {
        this.externalReference = value;
    }

    /**
     * The external reference identifier for this transaction. Data in this property will also be returned in our report files, allowing you to reconcile them
     */
    public PaymentCreationOutput withExternalReference(String value) {
        this.externalReference = value;
        return this;
    }

    /**
     * Indicates if a new token was created
     * <ul>
     *   <li>true - A new token was created</li>
     *   <li>false - A token with the same card number already exists and is returned. Please note that the existing token has not been updated. When you want to update other data then the card number, you need to update data stored in the token explicitly, as data is never updated during the creation of a token.</li>
     * </ul>
     */
    public Boolean getIsNewToken() {
        return isNewToken;
    }

    /**
     * Indicates if a new token was created
     * <ul>
     *   <li>true - A new token was created</li>
     *   <li>false - A token with the same card number already exists and is returned. Please note that the existing token has not been updated. When you want to update other data then the card number, you need to update data stored in the token explicitly, as data is never updated during the creation of a token.</li>
     * </ul>
     */
    public void setIsNewToken(Boolean value) {
        this.isNewToken = value;
    }

    /**
     * Indicates if a new token was created
     * <ul>
     *   <li>true - A new token was created</li>
     *   <li>false - A token with the same card number already exists and is returned. Please note that the existing token has not been updated. When you want to update other data then the card number, you need to update data stored in the token explicitly, as data is never updated during the creation of a token.</li>
     * </ul>
     */
    public PaymentCreationOutput withIsNewToken(Boolean value) {
        this.isNewToken = value;
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
    public PaymentCreationOutput withToken(String value) {
        this.token = value;
        return this;
    }

    /**
     * Indicates if tokenization was successful or not. If this value is false, then the token and the isNewToken property will not be set.
     */
    public Boolean getTokenizationSucceeded() {
        return tokenizationSucceeded;
    }

    /**
     * Indicates if tokenization was successful or not. If this value is false, then the token and the isNewToken property will not be set.
     */
    public void setTokenizationSucceeded(Boolean value) {
        this.tokenizationSucceeded = value;
    }

    /**
     * Indicates if tokenization was successful or not. If this value is false, then the token and the isNewToken property will not be set.
     */
    public PaymentCreationOutput withTokenizationSucceeded(Boolean value) {
        this.tokenizationSucceeded = value;
        return this;
    }
}
