/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RefundCardMethodSpecificOutput {

    private Acceptance acceptance;

    private String authorisationCode;

    private CurrencyConversion currencyConversion;

    private ReattemptInstructions reattemptInstructions;

    private Long totalAmountPaid;

    private Long totalAmountRefunded;

    /**
     * This object contains the acceptance information for the card payment authorization.
     */
    public Acceptance getAcceptance() {
        return acceptance;
    }

    /**
     * This object contains the acceptance information for the card payment authorization.
     */
    public void setAcceptance(Acceptance value) {
        this.acceptance = value;
    }

    /**
     * This object contains the acceptance information for the card payment authorization.
     */
    public RefundCardMethodSpecificOutput withAcceptance(Acceptance value) {
        this.acceptance = value;
        return this;
    }

    /**
     * Card Authorization code as returned by the acquirer
     */
    public String getAuthorisationCode() {
        return authorisationCode;
    }

    /**
     * Card Authorization code as returned by the acquirer
     */
    public void setAuthorisationCode(String value) {
        this.authorisationCode = value;
    }

    /**
     * Card Authorization code as returned by the acquirer
     */
    public RefundCardMethodSpecificOutput withAuthorisationCode(String value) {
        this.authorisationCode = value;
        return this;
    }

    public CurrencyConversion getCurrencyConversion() {
        return currencyConversion;
    }

    public void setCurrencyConversion(CurrencyConversion value) {
        this.currencyConversion = value;
    }

    public RefundCardMethodSpecificOutput withCurrencyConversion(CurrencyConversion value) {
        this.currencyConversion = value;
        return this;
    }

    /**
     * Instructions for reattempting a declined authorization. Provided only in case of declined authorization, for those acquirers that may respond with explicit instructions regarding potential reattempt processing.
     */
    public ReattemptInstructions getReattemptInstructions() {
        return reattemptInstructions;
    }

    /**
     * Instructions for reattempting a declined authorization. Provided only in case of declined authorization, for those acquirers that may respond with explicit instructions regarding potential reattempt processing.
     */
    public void setReattemptInstructions(ReattemptInstructions value) {
        this.reattemptInstructions = value;
    }

    /**
     * Instructions for reattempting a declined authorization. Provided only in case of declined authorization, for those acquirers that may respond with explicit instructions regarding potential reattempt processing.
     */
    public RefundCardMethodSpecificOutput withReattemptInstructions(ReattemptInstructions value) {
        this.reattemptInstructions = value;
        return this;
    }

    public Long getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(Long value) {
        this.totalAmountPaid = value;
    }

    public RefundCardMethodSpecificOutput withTotalAmountPaid(Long value) {
        this.totalAmountPaid = value;
        return this;
    }

    public Long getTotalAmountRefunded() {
        return totalAmountRefunded;
    }

    public void setTotalAmountRefunded(Long value) {
        this.totalAmountRefunded = value;
    }

    public RefundCardMethodSpecificOutput withTotalAmountRefunded(Long value) {
        this.totalAmountRefunded = value;
        return this;
    }
}
