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
     * The 11 digits CV Connect ID of the customer. If this ID is not provided, the customer's e-mail address will be used, if available. The customer will be able to confirm their ID before proceeding with payment.
     */
    public String getBeneficiaryId() {
        return beneficiaryId;
    }

    /**
     * The 11 digits CV Connect ID of the customer. If this ID is not provided, the customer's e-mail address will be used, if available. The customer will be able to confirm their ID before proceeding with payment.
     */
    public void setBeneficiaryId(String value) {
        this.beneficiaryId = value;
    }

    /**
     * The 11 digits CV Connect ID of the customer. If this ID is not provided, the customer's e-mail address will be used, if available. The customer will be able to confirm their ID before proceeding with payment.
     */
    public RedirectPaymentProduct5412SpecificInput withBeneficiaryId(String value) {
        this.beneficiaryId = value;
        return this;
    }
}
