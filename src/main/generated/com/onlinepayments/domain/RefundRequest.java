/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RefundRequest {

    private AmountOfMoney amountOfMoney;

    private String captureId;

    private OperationPaymentReferences operationReferences;

    private PaymentReferences references;

    /**
     * Object containing amount and ISO currency code attributes
     */
    public AmountOfMoney getAmountOfMoney() {
        return amountOfMoney;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public void setAmountOfMoney(AmountOfMoney value) {
        this.amountOfMoney = value;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public RefundRequest withAmountOfMoney(AmountOfMoney value) {
        this.amountOfMoney = value;
        return this;
    }

    /**
     * The identifier of the capture that is used for partial refund. CaptureId is only necessary for Paypal/PostfinancePay multi-capture payments.
     */
    public String getCaptureId() {
        return captureId;
    }

    /**
     * The identifier of the capture that is used for partial refund. CaptureId is only necessary for Paypal/PostfinancePay multi-capture payments.
     */
    public void setCaptureId(String value) {
        this.captureId = value;
    }

    /**
     * The identifier of the capture that is used for partial refund. CaptureId is only necessary for Paypal/PostfinancePay multi-capture payments.
     */
    public RefundRequest withCaptureId(String value) {
        this.captureId = value;
        return this;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction
     */
    public OperationPaymentReferences getOperationReferences() {
        return operationReferences;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction
     */
    public void setOperationReferences(OperationPaymentReferences value) {
        this.operationReferences = value;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction
     */
    public RefundRequest withOperationReferences(OperationPaymentReferences value) {
        this.operationReferences = value;
        return this;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction. <b>Deprecated for capture/refund</b>: Use operationReferences instead.
     */
    public PaymentReferences getReferences() {
        return references;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction. <b>Deprecated for capture/refund</b>: Use operationReferences instead.
     */
    public void setReferences(PaymentReferences value) {
        this.references = value;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction. <b>Deprecated for capture/refund</b>: Use operationReferences instead.
     */
    public RefundRequest withReferences(PaymentReferences value) {
        this.references = value;
        return this;
    }
}
