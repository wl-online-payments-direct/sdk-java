/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RefundResponse {

    private String id;

    private RefundOutput refundOutput;

    private String status;

    private OrderStatusOutput statusOutput;

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
    public RefundResponse withId(String value) {
        this.id = value;
        return this;
    }

    /**
     * Object containing refund details
     */
    public RefundOutput getRefundOutput() {
        return refundOutput;
    }

    /**
     * Object containing refund details
     */
    public void setRefundOutput(RefundOutput value) {
        this.refundOutput = value;
    }

    /**
     * Object containing refund details
     */
    public RefundResponse withRefundOutput(RefundOutput value) {
        this.refundOutput = value;
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
    public RefundResponse withStatus(String value) {
        this.status = value;
        return this;
    }

    public OrderStatusOutput getStatusOutput() {
        return statusOutput;
    }

    public void setStatusOutput(OrderStatusOutput value) {
        this.statusOutput = value;
    }

    public RefundResponse withStatusOutput(OrderStatusOutput value) {
        this.statusOutput = value;
        return this;
    }
}
