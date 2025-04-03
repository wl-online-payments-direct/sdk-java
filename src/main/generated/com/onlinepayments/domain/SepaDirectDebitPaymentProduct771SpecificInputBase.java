/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SepaDirectDebitPaymentProduct771SpecificInputBase {

    private String existingUniqueMandateReference;

    private CreateMandateRequest mandate;

    /**
     * The unique reference of the existing mandate to use in this payment.
     */
    public String getExistingUniqueMandateReference() {
        return existingUniqueMandateReference;
    }

    /**
     * The unique reference of the existing mandate to use in this payment.
     */
    public void setExistingUniqueMandateReference(String value) {
        this.existingUniqueMandateReference = value;
    }

    /**
     * The unique reference of the existing mandate to use in this payment.
     */
    public SepaDirectDebitPaymentProduct771SpecificInputBase withExistingUniqueMandateReference(String value) {
        this.existingUniqueMandateReference = value;
        return this;
    }

    /**
     * Object containing information to create a SEPA Direct Debit mandate.
     */
    public CreateMandateRequest getMandate() {
        return mandate;
    }

    /**
     * Object containing information to create a SEPA Direct Debit mandate.
     */
    public void setMandate(CreateMandateRequest value) {
        this.mandate = value;
    }

    /**
     * Object containing information to create a SEPA Direct Debit mandate.
     */
    public SepaDirectDebitPaymentProduct771SpecificInputBase withMandate(CreateMandateRequest value) {
        this.mandate = value;
        return this;
    }
}
