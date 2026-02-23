/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CancelPaymentBatchRequest {

    private CancelPaymentRequest cancel;

    private String paymentId;

    public CancelPaymentRequest getCancel() {
        return cancel;
    }

    public void setCancel(CancelPaymentRequest value) {
        this.cancel = value;
    }

    public CancelPaymentBatchRequest withCancel(CancelPaymentRequest value) {
        this.cancel = value;
        return this;
    }

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
    public CancelPaymentBatchRequest withPaymentId(String value) {
        this.paymentId = value;
        return this;
    }
}
