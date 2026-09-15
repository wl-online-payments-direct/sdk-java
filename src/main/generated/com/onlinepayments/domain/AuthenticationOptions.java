/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class AuthenticationOptions {

    private String acquirerBIN;

    private String acquirerMerchantId;

    private String merchantCategoryCode;

    private String merchantCountryCode;

    /**
     * Acquiring institution identification code as assigned by the 3DS Directory Server receiving the AReq message.
     */
    public String getAcquirerBIN() {
        return acquirerBIN;
    }

    /**
     * Acquiring institution identification code as assigned by the 3DS Directory Server receiving the AReq message.
     */
    public void setAcquirerBIN(String value) {
        this.acquirerBIN = value;
    }

    /**
     * Acquiring institution identification code as assigned by the 3DS Directory Server receiving the AReq message.
     */
    public AuthenticationOptions withAcquirerBIN(String value) {
        this.acquirerBIN = value;
        return this;
    }

    /**
     * Acquiring institution identification code.
     */
    public String getAcquirerMerchantId() {
        return acquirerMerchantId;
    }

    /**
     * Acquiring institution identification code.
     */
    public void setAcquirerMerchantId(String value) {
        this.acquirerMerchantId = value;
    }

    /**
     * Acquiring institution identification code.
     */
    public AuthenticationOptions withAcquirerMerchantId(String value) {
        this.acquirerMerchantId = value;
        return this;
    }

    /**
     * Code representing merchant’s type of business, product or service.
     */
    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    /**
     * Code representing merchant’s type of business, product or service.
     */
    public void setMerchantCategoryCode(String value) {
        this.merchantCategoryCode = value;
    }

    /**
     * Code representing merchant’s type of business, product or service.
     */
    public AuthenticationOptions withMerchantCategoryCode(String value) {
        this.merchantCategoryCode = value;
        return this;
    }

    /**
     * ISO-3166 country code of the merchant.
     */
    public String getMerchantCountryCode() {
        return merchantCountryCode;
    }

    /**
     * ISO-3166 country code of the merchant.
     */
    public void setMerchantCountryCode(String value) {
        this.merchantCountryCode = value;
    }

    /**
     * ISO-3166 country code of the merchant.
     */
    public AuthenticationOptions withMerchantCountryCode(String value) {
        this.merchantCountryCode = value;
        return this;
    }
}
