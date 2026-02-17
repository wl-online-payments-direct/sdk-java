/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ImportCofSeriesRequest {

    private CardDataWithoutCvv card;

    private String currencyCode;

    private Integer paymentProductId;

    private String schemeReferenceData;

    private String tokenId;

    /**
     * Object containing card details, which should be used if a tokenID is not provided.
     */
    public CardDataWithoutCvv getCard() {
        return card;
    }

    /**
     * Object containing card details, which should be used if a tokenID is not provided.
     */
    public void setCard(CardDataWithoutCvv value) {
        this.card = value;
    }

    /**
     * Object containing card details, which should be used if a tokenID is not provided.
     */
    public ImportCofSeriesRequest withCard(CardDataWithoutCvv value) {
        this.card = value;
        return this;
    }

    /**
     * Three-letter ISO currency code representing the currency for the initial payment.
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Three-letter ISO currency code representing the currency for the initial payment.
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Three-letter ISO currency code representing the currency for the initial payment.
     */
    public ImportCofSeriesRequest withCurrencyCode(String value) {
        this.currencyCode = value;
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
    public ImportCofSeriesRequest withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }

    /**
     * Scheme Reference Data (SRD) used for scheme-level routing or identification.
     */
    public String getSchemeReferenceData() {
        return schemeReferenceData;
    }

    /**
     * Scheme Reference Data (SRD) used for scheme-level routing or identification.
     */
    public void setSchemeReferenceData(String value) {
        this.schemeReferenceData = value;
    }

    /**
     * Scheme Reference Data (SRD) used for scheme-level routing or identification.
     */
    public ImportCofSeriesRequest withSchemeReferenceData(String value) {
        this.schemeReferenceData = value;
        return this;
    }

    /**
     * ID of the token to use to create the payment series.
     */
    public String getTokenId() {
        return tokenId;
    }

    /**
     * ID of the token to use to create the payment series.
     */
    public void setTokenId(String value) {
        this.tokenId = value;
    }

    /**
     * ID of the token to use to create the payment series.
     */
    public ImportCofSeriesRequest withTokenId(String value) {
        this.tokenId = value;
        return this;
    }
}
