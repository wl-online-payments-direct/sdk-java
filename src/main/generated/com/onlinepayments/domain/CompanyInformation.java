/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CompanyInformation {

    private String name;

    /**
     * Name of company, as a customer. For Klarna payment method, company name should be provided to trigger a B2B session. If nothing is provided, a B2C session will be the default.
     */
    public String getName() {
        return name;
    }

    /**
     * Name of company, as a customer. For Klarna payment method, company name should be provided to trigger a B2B session. If nothing is provided, a B2C session will be the default.
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Name of company, as a customer. For Klarna payment method, company name should be provided to trigger a B2B session. If nothing is provided, a B2C session will be the default.
     */
    public CompanyInformation withName(String value) {
        this.name = value;
        return this;
    }
}
