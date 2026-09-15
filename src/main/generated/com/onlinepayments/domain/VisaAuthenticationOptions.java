/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class VisaAuthenticationOptions {

    private String acquirerBIN;

    private String acquirerMerchantId;

    private String merchantName;

    /**
     * Acquirer identification code as assigned by the Directory Server.
     */
    public String getAcquirerBIN() {
        return acquirerBIN;
    }

    /**
     * Acquirer identification code as assigned by the Directory Server.
     */
    public void setAcquirerBIN(String value) {
        this.acquirerBIN = value;
    }

    /**
     * Acquirer identification code as assigned by the Directory Server.
     */
    public VisaAuthenticationOptions withAcquirerBIN(String value) {
        this.acquirerBIN = value;
        return this;
    }

    /**
     * Acquirer-assigned Merchant identifier.
     */
    public String getAcquirerMerchantId() {
        return acquirerMerchantId;
    }

    /**
     * Acquirer-assigned Merchant identifier.
     */
    public void setAcquirerMerchantId(String value) {
        this.acquirerMerchantId = value;
    }

    /**
     * Acquirer-assigned Merchant identifier.
     */
    public VisaAuthenticationOptions withAcquirerMerchantId(String value) {
        this.acquirerMerchantId = value;
        return this;
    }

    /**
     * Merchant name assigned by the Acquirer or Payment System.
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * Merchant name assigned by the Acquirer or Payment System.
     */
    public void setMerchantName(String value) {
        this.merchantName = value;
    }

    /**
     * Merchant name assigned by the Acquirer or Payment System.
     */
    public VisaAuthenticationOptions withMerchantName(String value) {
        this.merchantName = value;
        return this;
    }
}
