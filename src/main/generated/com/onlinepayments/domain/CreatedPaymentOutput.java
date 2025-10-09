/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CreatedPaymentOutput {

    private PaymentResponse payment;

    private String paymentStatusCategory;

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
