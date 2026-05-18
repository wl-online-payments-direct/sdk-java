/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PayoutCardPaymentMethodSpecificOutput {

    private Acceptance acceptance;

    private String authorisationCode;

    private CardEssentials card;

    private Integer paymentProductId;

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
    public PayoutCardPaymentMethodSpecificOutput withAcceptance(Acceptance value) {
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
    public PayoutCardPaymentMethodSpecificOutput withAuthorisationCode(String value) {
        this.authorisationCode = value;
        return this;
    }

    /**
     * Object containing card details
     */
    public CardEssentials getCard() {
        return card;
    }

    /**
     * Object containing card details
     */
    public void setCard(CardEssentials value) {
        this.card = value;
    }

    /**
     * Object containing card details
     */
    public PayoutCardPaymentMethodSpecificOutput withCard(CardEssentials value) {
        this.card = value;
        return this;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public Integer getPaymentProductId() {
        return paymentProductId;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public void setPaymentProductId(Integer value) {
        this.paymentProductId = value;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public PayoutCardPaymentMethodSpecificOutput withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }
}
