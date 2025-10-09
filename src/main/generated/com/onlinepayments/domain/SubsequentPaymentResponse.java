/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SubsequentPaymentResponse {

    private PaymentResponse payment;

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
    public SubsequentPaymentResponse withPayment(PaymentResponse value) {
        this.payment = value;
        return this;
    }
}
