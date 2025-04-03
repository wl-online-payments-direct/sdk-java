/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class DirectoryEntry {

    private String issuerId;

    private String issuerList;

    private String issuerName;

    /**
     * Unique ID of the issuing bank of the customer
     */
    public String getIssuerId() {
        return issuerId;
    }

    /**
     * Unique ID of the issuing bank of the customer
     */
    public void setIssuerId(String value) {
        this.issuerId = value;
    }

    /**
     * Unique ID of the issuing bank of the customer
     */
    public DirectoryEntry withIssuerId(String value) {
        this.issuerId = value;
        return this;
    }

    /**
     * To be used to sort the issuers.
     * short - These issuers should be presented at the top of the list
     * long - These issuers should be presented after the issuers marked as short
     * Note this is only filled if supported by the payment product. Currently only iDeal (809) support this. Sorting within the groups should be done alphabetically
     */
    public String getIssuerList() {
        return issuerList;
    }

    /**
     * To be used to sort the issuers.
     * short - These issuers should be presented at the top of the list
     * long - These issuers should be presented after the issuers marked as short
     * Note this is only filled if supported by the payment product. Currently only iDeal (809) support this. Sorting within the groups should be done alphabetically
     */
    public void setIssuerList(String value) {
        this.issuerList = value;
    }

    /**
     * To be used to sort the issuers.
     * short - These issuers should be presented at the top of the list
     * long - These issuers should be presented after the issuers marked as short
     * Note this is only filled if supported by the payment product. Currently only iDeal (809) support this. Sorting within the groups should be done alphabetically
     */
    public DirectoryEntry withIssuerList(String value) {
        this.issuerList = value;
        return this;
    }

    /**
     * Name of the issuing bank as it should be presented to the customer
     */
    public String getIssuerName() {
        return issuerName;
    }

    /**
     * Name of the issuing bank as it should be presented to the customer
     */
    public void setIssuerName(String value) {
        this.issuerName = value;
    }

    /**
     * Name of the issuing bank as it should be presented to the customer
     */
    public DirectoryEntry withIssuerName(String value) {
        this.issuerName = value;
        return this;
    }
}
