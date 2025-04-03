/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SepaDirectDebitPaymentMethodSpecificOutput {

    private FraudResults fraudResults;

    private PaymentProduct771SpecificOutput paymentProduct771SpecificOutput;

    private Integer paymentProductId;

    /**
     * Object containing the results of the fraud screening
     */
    public FraudResults getFraudResults() {
        return fraudResults;
    }

    /**
     * Object containing the results of the fraud screening
     */
    public void setFraudResults(FraudResults value) {
        this.fraudResults = value;
    }

    /**
     * Object containing the results of the fraud screening
     */
    public SepaDirectDebitPaymentMethodSpecificOutput withFraudResults(FraudResults value) {
        this.fraudResults = value;
        return this;
    }

    /**
     * Output that is SEPA Direct Debit specific (i.e. the used mandate)
     */
    public PaymentProduct771SpecificOutput getPaymentProduct771SpecificOutput() {
        return paymentProduct771SpecificOutput;
    }

    /**
     * Output that is SEPA Direct Debit specific (i.e. the used mandate)
     */
    public void setPaymentProduct771SpecificOutput(PaymentProduct771SpecificOutput value) {
        this.paymentProduct771SpecificOutput = value;
    }

    /**
     * Output that is SEPA Direct Debit specific (i.e. the used mandate)
     */
    public SepaDirectDebitPaymentMethodSpecificOutput withPaymentProduct771SpecificOutput(PaymentProduct771SpecificOutput value) {
        this.paymentProduct771SpecificOutput = value;
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
    public SepaDirectDebitPaymentMethodSpecificOutput withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }
}
