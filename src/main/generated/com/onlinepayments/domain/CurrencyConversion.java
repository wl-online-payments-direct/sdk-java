/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CurrencyConversion {

    private Boolean acceptedByUser;

    private DccProposal proposal;

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
    public CurrencyConversion withAcceptedByUser(Boolean value) {
        this.acceptedByUser = value;
        return this;
    }

    /**
     * Details of currency conversion to be proposed to the cardholder
     */
    public DccProposal getProposal() {
        return proposal;
    }

    /**
     * Details of currency conversion to be proposed to the cardholder
     */
    public void setProposal(DccProposal value) {
        this.proposal = value;
    }

    /**
     * Details of currency conversion to be proposed to the cardholder
     */
    public CurrencyConversion withProposal(DccProposal value) {
        this.proposal = value;
        return this;
    }
}
