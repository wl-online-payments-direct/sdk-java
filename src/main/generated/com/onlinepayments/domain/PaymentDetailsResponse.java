/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class PaymentDetailsResponse {

    private List<OperationOutput> Operations;

    private HostedCheckoutSpecificOutput hostedCheckoutSpecificOutput;

    private String id;

    private PaymentOutput paymentOutput;

    private String status;

    private PaymentStatusOutput statusOutput;

    /**
     * Object that contains the complete list of operations executed on the payment.
     */
    public List<OperationOutput> getOperations() {
        return Operations;
    }

    /**
     * Object that contains the complete list of operations executed on the payment.
     */
    public void setOperations(List<OperationOutput> value) {
        this.Operations = value;
    }

    /**
     * Object that contains the complete list of operations executed on the payment.
     */
    public PaymentDetailsResponse withOperations(List<OperationOutput> value) {
        this.Operations = value;
        return this;
    }

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
    public PaymentDetailsResponse withHostedCheckoutSpecificOutput(HostedCheckoutSpecificOutput value) {
        this.hostedCheckoutSpecificOutput = value;
        return this;
    }

    /**
     * Our unique payment transaction identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Our unique payment transaction identifier
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Our unique payment transaction identifier
     */
    public PaymentDetailsResponse withId(String value) {
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
    public PaymentDetailsResponse withPaymentOutput(PaymentOutput value) {
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
    public PaymentDetailsResponse withStatus(String value) {
        this.status = value;
        return this;
    }

    /**
     * This object has the numeric representation of the current payment status, timestamp of last status change and performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
     */
    public PaymentStatusOutput getStatusOutput() {
        return statusOutput;
    }

    /**
     * This object has the numeric representation of the current payment status, timestamp of last status change and performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
     */
    public void setStatusOutput(PaymentStatusOutput value) {
        this.statusOutput = value;
    }

    /**
     * This object has the numeric representation of the current payment status, timestamp of last status change and performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
     */
    public PaymentDetailsResponse withStatusOutput(PaymentStatusOutput value) {
        this.statusOutput = value;
        return this;
    }
}
