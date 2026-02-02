/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class MarketPlace {

    private String retailerCountry;

    private String retailerName;

    /**
     * ISO 3166-1 alpha-2 country code of the retailer.
     */
    public String getRetailerCountry() {
        return retailerCountry;
    }

    /**
     * ISO 3166-1 alpha-2 country code of the retailer.
     */
    public void setRetailerCountry(String value) {
        this.retailerCountry = value;
    }

    /**
     * ISO 3166-1 alpha-2 country code of the retailer.
     */
    public MarketPlace withRetailerCountry(String value) {
        this.retailerCountry = value;
        return this;
    }

    /**
     * This field is required if the transaction is performed by a merchant using the marketplace. This field must contain the name of the end merchant.
     */
    public String getRetailerName() {
        return retailerName;
    }

    /**
     * This field is required if the transaction is performed by a merchant using the marketplace. This field must contain the name of the end merchant.
     */
    public void setRetailerName(String value) {
        this.retailerName = value;
    }

    /**
     * This field is required if the transaction is performed by a merchant using the marketplace. This field must contain the name of the end merchant.
     */
    public MarketPlace withRetailerName(String value) {
        this.retailerName = value;
        return this;
    }
}
