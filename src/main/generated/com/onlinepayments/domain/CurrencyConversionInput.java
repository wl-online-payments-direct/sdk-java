/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CurrencyConversionInput {

    private Boolean acceptedByUser;

    private String dccSessionId;

    /**
     * Dynamic Currency Conversion(DCC) Proposal accepted by user
     */
    public Boolean getAcceptedByUser() {
        return acceptedByUser;
    }

    /**
     * Dynamic Currency Conversion(DCC) Proposal accepted by user
     */
    public void setAcceptedByUser(Boolean value) {
        this.acceptedByUser = value;
    }

    /**
     * Dynamic Currency Conversion(DCC) Proposal accepted by user
     */
    public CurrencyConversionInput withAcceptedByUser(Boolean value) {
        this.acceptedByUser = value;
        return this;
    }

    /**
     * Dynamic Currency Conversion(DCC) Session Id that was previously returned by rate enquiry (/dccrate).
     */
    public String getDccSessionId() {
        return dccSessionId;
    }

    /**
     * Dynamic Currency Conversion(DCC) Session Id that was previously returned by rate enquiry (/dccrate).
     */
    public void setDccSessionId(String value) {
        this.dccSessionId = value;
    }

    /**
     * Dynamic Currency Conversion(DCC) Session Id that was previously returned by rate enquiry (/dccrate).
     */
    public CurrencyConversionInput withDccSessionId(String value) {
        this.dccSessionId = value;
        return this;
    }
}
