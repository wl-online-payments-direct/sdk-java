/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SubsequentPaymentBatchRequest {

    private String paymentId;

    private SubsequentPaymentRequest subsequent;

    /**
     * This is our unique payment transaction identifier.
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * This is our unique payment transaction identifier.
     */
    public void setPaymentId(String value) {
        this.paymentId = value;
    }

    /**
     * This is our unique payment transaction identifier.
     */
    public SubsequentPaymentBatchRequest withPaymentId(String value) {
        this.paymentId = value;
        return this;
    }

    public SubsequentPaymentRequest getSubsequent() {
        return subsequent;
    }

    public void setSubsequent(SubsequentPaymentRequest value) {
        this.subsequent = value;
    }

    public SubsequentPaymentBatchRequest withSubsequent(SubsequentPaymentRequest value) {
        this.subsequent = value;
        return this;
    }
}
