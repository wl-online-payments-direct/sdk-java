/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RefundRequest {

    private AmountOfMoney amountOfMoney;

    private String captureId;

    private OmnichannelRefundSpecificInput omnichannelRefundSpecificInput;

    private OperationPaymentReferences operationReferences;

    private String reason;

    private PaymentReferences references;

    private RefundRedirectPaymentMethodSpecificInput refundRedirectPaymentMethodSpecificInput;

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
     * Object containing the additional refund details for an Omnichannel merchant
     */
    public OmnichannelRefundSpecificInput getOmnichannelRefundSpecificInput() {
        return omnichannelRefundSpecificInput;
    }

    /**
     * Object containing the additional refund details for an Omnichannel merchant
     */
    public void setOmnichannelRefundSpecificInput(OmnichannelRefundSpecificInput value) {
        this.omnichannelRefundSpecificInput = value;
    }

    /**
     * Object containing the additional refund details for an Omnichannel merchant
     */
    public RefundRequest withOmnichannelRefundSpecificInput(OmnichannelRefundSpecificInput value) {
        this.omnichannelRefundSpecificInput = value;
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
     * The reason for the refund. This will be available in our portal and reports for your information only. It will NOT appear in the consumer bank statement or yours.§
     */
    public String getReason() {
        return reason;
    }

    /**
     * The reason for the refund. This will be available in our portal and reports for your information only. It will NOT appear in the consumer bank statement or yours.§
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * The reason for the refund. This will be available in our portal and reports for your information only. It will NOT appear in the consumer bank statement or yours.§
     */
    public RefundRequest withReason(String value) {
        this.reason = value;
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

    /**
     * Object containing the specific input details for refunds for redirection payment methods.
     */
    public RefundRedirectPaymentMethodSpecificInput getRefundRedirectPaymentMethodSpecificInput() {
        return refundRedirectPaymentMethodSpecificInput;
    }

    /**
     * Object containing the specific input details for refunds for redirection payment methods.
     */
    public void setRefundRedirectPaymentMethodSpecificInput(RefundRedirectPaymentMethodSpecificInput value) {
        this.refundRedirectPaymentMethodSpecificInput = value;
    }

    /**
     * Object containing the specific input details for refunds for redirection payment methods.
     */
    public RefundRequest withRefundRedirectPaymentMethodSpecificInput(RefundRedirectPaymentMethodSpecificInput value) {
        this.refundRedirectPaymentMethodSpecificInput = value;
        return this;
    }
}
