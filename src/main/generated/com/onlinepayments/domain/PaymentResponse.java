/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentResponse {

    private HostedCheckoutSpecificOutput hostedCheckoutSpecificOutput;

    private String id;

    private PaymentOutput paymentOutput;

    private String status;

    private PaymentStatusOutput statusOutput;

    /**
     * Hosted Checkout specific information. Populated if the payment was created on the platform through a Hosted Checkout.
     */
    public HostedCheckoutSpecificOutput getHostedCheckoutSpecificOutput() {
        return hostedCheckoutSpecificOutput;
    }

    /**
     * Hosted Checkout specific information. Populated if the payment was created on the platform through a Hosted Checkout.
     */
    public void setHostedCheckoutSpecificOutput(HostedCheckoutSpecificOutput value) {
        this.hostedCheckoutSpecificOutput = value;
    }

    /**
     * Hosted Checkout specific information. Populated if the payment was created on the platform through a Hosted Checkout.
     */
    public PaymentResponse withHostedCheckoutSpecificOutput(HostedCheckoutSpecificOutput value) {
        this.hostedCheckoutSpecificOutput = value;
        return this;
    }

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
    public PaymentResponse withId(String value) {
        this.id = value;
        return this;
    }

    /**
     * Object containing payment details
     */
    public PaymentOutput getPaymentOutput() {
        return paymentOutput;
    }

    /**
     * Object containing payment details
     */
    public void setPaymentOutput(PaymentOutput value) {
        this.paymentOutput = value;
    }

    /**
     * Object containing payment details
     */
    public PaymentResponse withPaymentOutput(PaymentOutput value) {
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
    public PaymentResponse withStatus(String value) {
        this.status = value;
        return this;
    }

    /**
     * This object has the numeric representation of the current payment status, the timestamp of the last status change, and the performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
     */
    public PaymentStatusOutput getStatusOutput() {
        return statusOutput;
    }

    /**
     * This object has the numeric representation of the current payment status, the timestamp of the last status change, and the performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
     */
    public void setStatusOutput(PaymentStatusOutput value) {
        this.statusOutput = value;
    }

    /**
     * This object has the numeric representation of the current payment status, the timestamp of the last status change, and the performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
     */
    public PaymentResponse withStatusOutput(PaymentStatusOutput value) {
        this.statusOutput = value;
        return this;
    }
}
