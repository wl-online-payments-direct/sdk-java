/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class TokenResponse {

    private TokenCard card;

    private CrmToken crmToken;

    private TokenEWallet eWallet;

    private ExternalTokenLinked externalTokenLinked;

    private String id;

    private Boolean isTemporary;

    private NetworkTokenLinked networkTokenLinked;

    private Integer paymentProductId;

    /**
     * Object containing card details
     */
    public TokenCard getCard() {
        return card;
    }

    /**
     * Object containing card details
     */
    public void setCard(TokenCard value) {
        this.card = value;
    }

    /**
     * Object containing card details
     */
    public TokenResponse withCard(TokenCard value) {
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
    public TokenResponse withCrmToken(CrmToken value) {
        this.crmToken = value;
        return this;
    }

    /**
     * Object containing eWallet details
     */
    public TokenEWallet getEWallet() {
        return eWallet;
    }

    /**
     * Object containing eWallet details
     */
    public void setEWallet(TokenEWallet value) {
        this.eWallet = value;
    }

    /**
     * Object containing eWallet details
     */
    public TokenResponse withEWallet(TokenEWallet value) {
        this.eWallet = value;
        return this;
    }

    public ExternalTokenLinked getExternalTokenLinked() {
        return externalTokenLinked;
    }

    public void setExternalTokenLinked(ExternalTokenLinked value) {
        this.externalTokenLinked = value;
    }

    public TokenResponse withExternalTokenLinked(ExternalTokenLinked value) {
        this.externalTokenLinked = value;
        return this;
    }

    /**
     * ID of the token
     */
    public String getId() {
        return id;
    }

    /**
     * ID of the token
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * ID of the token
     */
    public TokenResponse withId(String value) {
        this.id = value;
        return this;
    }

    /**
     * Temporary tokens have a lifespan of two hours and can only be used once.
     */
    public Boolean getIsTemporary() {
        return isTemporary;
    }

    /**
     * Temporary tokens have a lifespan of two hours and can only be used once.
     */
    public void setIsTemporary(Boolean value) {
        this.isTemporary = value;
    }

    /**
     * Temporary tokens have a lifespan of two hours and can only be used once.
     */
    public TokenResponse withIsTemporary(Boolean value) {
        this.isTemporary = value;
        return this;
    }

    /**
     * Object containing Network Token details, when the Network Token was created on behalf of the merchant and is activated.
     */
    public NetworkTokenLinked getNetworkTokenLinked() {
        return networkTokenLinked;
    }

    /**
     * Object containing Network Token details, when the Network Token was created on behalf of the merchant and is activated.
     */
    public void setNetworkTokenLinked(NetworkTokenLinked value) {
        this.networkTokenLinked = value;
    }

    /**
     * Object containing Network Token details, when the Network Token was created on behalf of the merchant and is activated.
     */
    public TokenResponse withNetworkTokenLinked(NetworkTokenLinked value) {
        this.networkTokenLinked = value;
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
    public TokenResponse withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }
}
