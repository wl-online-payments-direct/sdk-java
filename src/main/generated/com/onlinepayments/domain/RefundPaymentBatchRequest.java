/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RefundPaymentBatchRequest {

    private String paymentId;

    private RefundRequest refund;

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
    public RefundPaymentBatchRequest withPaymentId(String value) {
        this.paymentId = value;
        return this;
    }

    public RefundRequest getRefund() {
        return refund;
    }

    public void setRefund(RefundRequest value) {
        this.refund = value;
    }

    public RefundPaymentBatchRequest withRefund(RefundRequest value) {
        this.refund = value;
        return this;
    }
}
