/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CardToken {

    private String cardholderName;

    private String expiryDate;

    private String logoUrl;

    private String maskedPan;

    private Integer paymentProductId;

    private String productName;

    private String token;

    /**
     * The card holder's name on the card.
     */
    public String getCardholderName() {
        return cardholderName;
    }

    /**
     * The card holder's name on the card.
     */
    public void setCardholderName(String value) {
        this.cardholderName = value;
    }

    /**
     * The card holder's name on the card.
     */
    public CardToken withCardholderName(String value) {
        this.cardholderName = value;
        return this;
    }

    /**
     * Expiry date of the card
     * Format: MMYY
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Expiry date of the card
     * Format: MMYY
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

    /**
     * Expiry date of the card
     * Format: MMYY
     */
    public CardToken withExpiryDate(String value) {
        this.expiryDate = value;
        return this;
    }

    /**
     * URL to the card product logo.
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * URL to the card product logo.
     */
    public void setLogoUrl(String value) {
        this.logoUrl = value;
    }

    /**
     * URL to the card product logo.
     */
    public CardToken withLogoUrl(String value) {
        this.logoUrl = value;
        return this;
    }

    /**
     * The masked Primary Account Number (PAN).
     */
    public String getMaskedPan() {
        return maskedPan;
    }

    /**
     * The masked Primary Account Number (PAN).
     */
    public void setMaskedPan(String value) {
        this.maskedPan = value;
    }

    /**
     * The masked Primary Account Number (PAN).
     */
    public CardToken withMaskedPan(String value) {
        this.maskedPan = value;
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
    public CardToken withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }

    /**
     * Product name of the card
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Product name of the card
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Product name of the card
     */
    public CardToken withProductName(String value) {
        this.productName = value;
        return this;
    }

    /**
     * This is a validated card token available for later use.
     */
    public String getToken() {
        return token;
    }

    /**
     * This is a validated card token available for later use.
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * This is a validated card token available for later use.
     */
    public CardToken withToken(String value) {
        this.token = value;
        return this;
    }
}
