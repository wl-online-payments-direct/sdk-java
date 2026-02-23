/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CapturePaymentBatchRequest {

    private CapturePaymentRequest capture;

    private String paymentId;

    public CapturePaymentRequest getCapture() {
        return capture;
    }

    public void setCapture(CapturePaymentRequest value) {
        this.capture = value;
    }

    public CapturePaymentBatchRequest withCapture(CapturePaymentRequest value) {
        this.capture = value;
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
    public CapturePaymentBatchRequest withPaymentId(String value) {
        this.paymentId = value;
        return this;
    }
}
