/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SubMerchant {

    private Address address;

    private String companyIdentificationNumber;

    private String companyName;

    private String merchantCategoryCode;

    private String merchantId;

    /**
     * Object containing billing address details.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Object containing billing address details.
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Object containing billing address details.
     */
    public SubMerchant withAddress(Address value) {
        this.address = value;
        return this;
    }

    /**
     * Business Establishment Directory Identification System
     */
    public String getCompanyIdentificationNumber() {
        return companyIdentificationNumber;
    }

    /**
     * Business Establishment Directory Identification System
     */
    public void setCompanyIdentificationNumber(String value) {
        this.companyIdentificationNumber = value;
    }

    /**
     * Business Establishment Directory Identification System
     */
    public SubMerchant withCompanyIdentificationNumber(String value) {
        this.companyIdentificationNumber = value;
        return this;
    }

    /**
     * Name of the sales establishment requesting the transaction.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Name of the sales establishment requesting the transaction.
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Name of the sales establishment requesting the transaction.
     */
    public SubMerchant withCompanyName(String value) {
        this.companyName = value;
        return this;
    }

    /**
     * MCC is a four-digit number that classifies the type of goods or services a business offers.
     */
    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    /**
     * MCC is a four-digit number that classifies the type of goods or services a business offers.
     */
    public void setMerchantCategoryCode(String value) {
        this.merchantCategoryCode = value;
    }

    /**
     * MCC is a four-digit number that classifies the type of goods or services a business offers.
     */
    public SubMerchant withMerchantCategoryCode(String value) {
        this.merchantCategoryCode = value;
        return this;
    }

    /**
     * Merchant Identifier is a value defined by the acquirer.
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Merchant Identifier is a value defined by the acquirer.
     */
    public void setMerchantId(String value) {
        this.merchantId = value;
    }

    /**
     * Merchant Identifier is a value defined by the acquirer.
     */
    public SubMerchant withMerchantId(String value) {
        this.merchantId = value;
        return this;
    }
}
