/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProduct5500SpecificOutput {

    private String entityId;

    private String paymentEndDate;

    private String paymentReference;

    private String paymentStartDate;

    /**
     * The reference to be used during Multibanco payment for reconciliation matter
     */
    public String getEntityId() {
        return entityId;
    }

    /**
     * The reference to be used during Multibanco payment for reconciliation matter
     */
    public void setEntityId(String value) {
        this.entityId = value;
    }

    /**
     * The reference to be used during Multibanco payment for reconciliation matter
     */
    public PaymentProduct5500SpecificOutput withEntityId(String value) {
        this.entityId = value;
        return this;
    }

    /**
     * The end date of the payment validity
     */
    public String getPaymentEndDate() {
        return paymentEndDate;
    }

    /**
     * The end date of the payment validity
     */
    public void setPaymentEndDate(String value) {
        this.paymentEndDate = value;
    }

    /**
     * The end date of the payment validity
     */
    public PaymentProduct5500SpecificOutput withPaymentEndDate(String value) {
        this.paymentEndDate = value;
        return this;
    }

    /**
     * The reference to be used within the Multibanco network to confirm the payment
     */
    public String getPaymentReference() {
        return paymentReference;
    }

    /**
     * The reference to be used within the Multibanco network to confirm the payment
     */
    public void setPaymentReference(String value) {
        this.paymentReference = value;
    }

    /**
     * The reference to be used within the Multibanco network to confirm the payment
     */
    public PaymentProduct5500SpecificOutput withPaymentReference(String value) {
        this.paymentReference = value;
        return this;
    }

    /**
     * The start date of the payment validity
     */
    public String getPaymentStartDate() {
        return paymentStartDate;
    }

    /**
     * The start date of the payment validity
     */
    public void setPaymentStartDate(String value) {
        this.paymentStartDate = value;
    }

    /**
     * The start date of the payment validity
     */
    public PaymentProduct5500SpecificOutput withPaymentStartDate(String value) {
        this.paymentStartDate = value;
        return this;
    }
}
