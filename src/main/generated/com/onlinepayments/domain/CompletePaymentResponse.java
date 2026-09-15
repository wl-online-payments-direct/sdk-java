/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CompletePaymentResponse {

    private PaymentCreationOutput creationOutput;

    private MerchantAction merchantAction;

    private PaymentResponse payment;

    /**
     * Deprecated: This field is not used by any payment product
     */
    public PaymentCreationOutput getCreationOutput() {
        return creationOutput;
    }

    /**
     * Deprecated: This field is not used by any payment product
     */
    public void setCreationOutput(PaymentCreationOutput value) {
        this.creationOutput = value;
    }

    /**
     * Deprecated: This field is not used by any payment product
     */
    public CompletePaymentResponse withCreationOutput(PaymentCreationOutput value) {
        this.creationOutput = value;
        return this;
    }

    /**
     * Deprecated: This field is not used by any payment product
     */
    public MerchantAction getMerchantAction() {
        return merchantAction;
    }

    /**
     * Deprecated: This field is not used by any payment product
     */
    public void setMerchantAction(MerchantAction value) {
        this.merchantAction = value;
    }

    /**
     * Deprecated: This field is not used by any payment product
     */
    public CompletePaymentResponse withMerchantAction(MerchantAction value) {
        this.merchantAction = value;
        return this;
    }

    /**
     * This object holds the properties related to the payment.
     */
    public PaymentResponse getPayment() {
        return payment;
    }

    /**
     * This object holds the properties related to the payment.
     */
    public void setPayment(PaymentResponse value) {
        this.payment = value;
    }

    /**
     * This object holds the properties related to the payment.
     */
    public CompletePaymentResponse withPayment(PaymentResponse value) {
        this.payment = value;
        return this;
    }
}
