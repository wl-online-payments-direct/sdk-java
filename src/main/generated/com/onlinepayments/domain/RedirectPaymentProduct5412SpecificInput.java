/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RedirectPaymentProduct5412SpecificInput {

    private Boolean adjustableAmount;

    private String beneficiaryId;

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

    /**
     * The customer's 11-digit CV Connect ID, or their e-mail address on file with ANCV. The customer will be able to confirm their ID before proceeding with payment.
     */
    public String getBeneficiaryId() {
        return beneficiaryId;
    }

    /**
     * The customer's 11-digit CV Connect ID, or their e-mail address on file with ANCV. The customer will be able to confirm their ID before proceeding with payment.
     */
    public void setBeneficiaryId(String value) {
        this.beneficiaryId = value;
    }

    /**
     * The customer's 11-digit CV Connect ID, or their e-mail address on file with ANCV. The customer will be able to confirm their ID before proceeding with payment.
     */
    public RedirectPaymentProduct5412SpecificInput withBeneficiaryId(String value) {
        this.beneficiaryId = value;
        return this;
    }
}
