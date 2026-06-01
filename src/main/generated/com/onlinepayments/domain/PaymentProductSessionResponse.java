/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProductSessionResponse {

    private PaymentProductSession302SpecificOutput paymentProductSession302SpecificOutput;

    /**
     * The specific output details of the created payment product session for Apple Pay (payment product 302).
     */
    public PaymentProductSession302SpecificOutput getPaymentProductSession302SpecificOutput() {
        return paymentProductSession302SpecificOutput;
    }

    /**
     * The specific output details of the created payment product session for Apple Pay (payment product 302).
     */
    public void setPaymentProductSession302SpecificOutput(PaymentProductSession302SpecificOutput value) {
        this.paymentProductSession302SpecificOutput = value;
    }

    /**
     * The specific output details of the created payment product session for Apple Pay (payment product 302).
     */
    public PaymentProductSessionResponse withPaymentProductSession302SpecificOutput(PaymentProductSession302SpecificOutput value) {
        this.paymentProductSession302SpecificOutput = value;
        return this;
    }
}
