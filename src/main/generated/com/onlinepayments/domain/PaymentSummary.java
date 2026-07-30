/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentSummary {

    private String id;

    private PaymentOutputSummary paymentOutput;

    private String status;

    private PaymentStatusOutputSummary statusOutput;

    /**
     * This is our unique payment transaction identifier.
     */
    public String getId() {
        return id;
    }

    /**
     * This is our unique payment transaction identifier.
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * This is our unique payment transaction identifier.
     */
    public PaymentSummary withId(String value) {
        this.id = value;
        return this;
    }

    /**
     * Summary of payment output details
     */
    public PaymentOutputSummary getPaymentOutput() {
        return paymentOutput;
    }

    /**
     * Summary of payment output details
     */
    public void setPaymentOutput(PaymentOutputSummary value) {
        this.paymentOutput = value;
    }

    /**
     * Summary of payment output details
     */
    public PaymentSummary withPaymentOutput(PaymentOutputSummary value) {
        this.paymentOutput = value;
        return this;
    }

    /**
     * Current high-level status of the payment in a human-readable form.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Current high-level status of the payment in a human-readable form.
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Current high-level status of the payment in a human-readable form.
     */
    public PaymentSummary withStatus(String value) {
        this.status = value;
        return this;
    }

    /**
     * Summary of payment status output with essential information
     */
    public PaymentStatusOutputSummary getStatusOutput() {
        return statusOutput;
    }

    /**
     * Summary of payment status output with essential information
     */
    public void setStatusOutput(PaymentStatusOutputSummary value) {
        this.statusOutput = value;
    }

    /**
     * Summary of payment status output with essential information
     */
    public PaymentSummary withStatusOutput(PaymentStatusOutputSummary value) {
        this.statusOutput = value;
        return this;
    }
}
