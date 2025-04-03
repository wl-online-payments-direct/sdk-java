/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CreatedPaymentOutput {

    private PaymentResponse payment;

    private String paymentStatusCategory;

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
    public CreatedPaymentOutput withPayment(PaymentResponse value) {
        this.payment = value;
        return this;
    }

    public String getPaymentStatusCategory() {
        return paymentStatusCategory;
    }

    public void setPaymentStatusCategory(String value) {
        this.paymentStatusCategory = value;
    }

    public CreatedPaymentOutput withPaymentStatusCategory(String value) {
        this.paymentStatusCategory = value;
        return this;
    }
}
