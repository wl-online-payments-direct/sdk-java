/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RedirectPaymentProduct5412SpecificInput {

    private Boolean adjustableAmount;

    /**
     * If true, the customer can adjust the portion of the total amount paid using this payment method in the ANCV app at authentication time.
     */
    public Boolean getAdjustableAmount() {
        return adjustableAmount;
    }

    /**
     * If true, the customer can adjust the portion of the total amount paid using this payment method in the ANCV app at authentication time.
     */
    public void setAdjustableAmount(Boolean value) {
        this.adjustableAmount = value;
    }

    /**
     * If true, the customer can adjust the portion of the total amount paid using this payment method in the ANCV app at authentication time.
     */
    public RedirectPaymentProduct5412SpecificInput withAdjustableAmount(Boolean value) {
        this.adjustableAmount = value;
        return this;
    }
}
