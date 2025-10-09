/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CreatePaymentResponse {

    private PaymentCreationOutput creationOutput;

    private MerchantAction merchantAction;

    private PaymentResponse payment;

    /**
     * This object contains the details of the created payment.
     */
    public PaymentCreationOutput getCreationOutput() {
        return creationOutput;
    }

    /**
     * This object contains the details of the created payment.
     */
    public void setCreationOutput(PaymentCreationOutput value) {
        this.creationOutput = value;
    }

    /**
     * This object contains the details of the created payment.
     */
    public CreatePaymentResponse withCreationOutput(PaymentCreationOutput value) {
        this.creationOutput = value;
        return this;
    }

    /**
     * This object contains the action, including the needed data, that you should perform next. This could involve showing instructions, displaying the transaction results, or redirecting to a third party to complete the payment.
     */
    public MerchantAction getMerchantAction() {
        return merchantAction;
    }

    /**
     * This object contains the action, including the needed data, that you should perform next. This could involve showing instructions, displaying the transaction results, or redirecting to a third party to complete the payment.
     */
    public void setMerchantAction(MerchantAction value) {
        this.merchantAction = value;
    }

    /**
     * This object contains the action, including the needed data, that you should perform next. This could involve showing instructions, displaying the transaction results, or redirecting to a third party to complete the payment.
     */
    public CreatePaymentResponse withMerchantAction(MerchantAction value) {
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
    public CreatePaymentResponse withPayment(PaymentResponse value) {
        this.payment = value;
        return this;
    }
}
