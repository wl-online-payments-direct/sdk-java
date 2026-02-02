/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CreatedTokenResponse {

    private CardWithoutCvv card;

    private CrmToken crmToken;

    private ExternalTokenLinked externalTokenLinked;

    private Boolean isNewToken;

    private String token;

    private String tokenStatus;

    public CardWithoutCvv getCard() {
        return card;
    }

    public void setCard(CardWithoutCvv value) {
        this.card = value;
    }

    public CreatedTokenResponse withCard(CardWithoutCvv value) {
        this.card = value;
        return this;
    }

    /**
     * The CRM (Customer Relationship Management) token group. CRM tokens are available to enhance knowledge of a merchant's customers by attempting to identify the customer.
     */
    public CrmToken getCrmToken() {
        return crmToken;
    }

    /**
     * The CRM (Customer Relationship Management) token group. CRM tokens are available to enhance knowledge of a merchant's customers by attempting to identify the customer.
     */
    public void setCrmToken(CrmToken value) {
        this.crmToken = value;
    }

    /**
     * The CRM (Customer Relationship Management) token group. CRM tokens are available to enhance knowledge of a merchant's customers by attempting to identify the customer.
     */
    public CreatedTokenResponse withCrmToken(CrmToken value) {
        this.crmToken = value;
        return this;
    }

    public ExternalTokenLinked getExternalTokenLinked() {
        return externalTokenLinked;
    }

    public void setExternalTokenLinked(ExternalTokenLinked value) {
        this.externalTokenLinked = value;
    }

    public CreatedTokenResponse withExternalTokenLinked(ExternalTokenLinked value) {
        this.externalTokenLinked = value;
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
    public CreatedTokenResponse withIsNewToken(Boolean value) {
        this.isNewToken = value;
        return this;
    }

    /**
     * ID of the token
     */
    public String getToken() {
        return token;
    }

    /**
     * ID of the token
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * ID of the token
     */
    public CreatedTokenResponse withToken(String value) {
        this.token = value;
        return this;
    }

    /**
     * This is the status of the token in the hosted tokenization session. Possible values are:
     * <ul>
     *   <li>UNCHANGED - The token has not changed</li>
     *   <li>CREATED - The token has been created</li>
     *   <li>UPDATED - The token has been updated</li>
     * </ul>
     */
    public String getTokenStatus() {
        return tokenStatus;
    }

    /**
     * This is the status of the token in the hosted tokenization session. Possible values are:
     * <ul>
     *   <li>UNCHANGED - The token has not changed</li>
     *   <li>CREATED - The token has been created</li>
     *   <li>UPDATED - The token has been updated</li>
     * </ul>
     */
    public void setTokenStatus(String value) {
        this.tokenStatus = value;
    }

    /**
     * This is the status of the token in the hosted tokenization session. Possible values are:
     * <ul>
     *   <li>UNCHANGED - The token has not changed</li>
     *   <li>CREATED - The token has been created</li>
     *   <li>UPDATED - The token has been updated</li>
     * </ul>
     */
    public CreatedTokenResponse withTokenStatus(String value) {
        this.tokenStatus = value;
        return this;
    }
}
