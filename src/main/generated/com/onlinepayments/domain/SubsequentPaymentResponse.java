/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SubsequentPaymentResponse {

    private PaymentResponse payment;

    /**
     * Object that holds the payment related properties
     */
    public PaymentResponse getPayment() {
        return payment;
    }

    /**
     * Object that holds the payment related properties
     */
    public void setPayment(PaymentResponse value) {
        this.payment = value;
    }

    /**
     * Object that holds the payment related properties
     */
    public SubsequentPaymentResponse withPayment(PaymentResponse value) {
        this.payment = value;
        return this;
    }
}
