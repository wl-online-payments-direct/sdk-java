/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class MobilePaymentData {

    private String dpan;

    private String expiryDate;

    /**
     * The obfuscated DPAN. Only the last four digits are visible.
     */
    public String getDpan() {
        return dpan;
    }

    /**
     * The obfuscated DPAN. Only the last four digits are visible.
     */
    public void setDpan(String value) {
        this.dpan = value;
    }

    /**
     * The obfuscated DPAN. Only the last four digits are visible.
     */
    public MobilePaymentData withDpan(String value) {
        this.dpan = value;
        return this;
    }

    /**
     * Expiry date of the tokenized card. Format: MMYY
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Expiry date of the tokenized card. Format: MMYY
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

    /**
     * Expiry date of the tokenized card. Format: MMYY
     */
    public MobilePaymentData withExpiryDate(String value) {
        this.expiryDate = value;
        return this;
    }
}
