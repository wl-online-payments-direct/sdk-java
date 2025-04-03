/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class OperationOutput {

    private AmountOfMoney amountOfMoney;

    private String id;

    private OperationPaymentReferences operationReferences;

    private String paymentMethod;

    private PaymentReferences references;

    private String status;

    private PaymentStatusOutput statusOutput;

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
    public OperationOutput withAmountOfMoney(AmountOfMoney value) {
        this.amountOfMoney = value;
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
    public OperationOutput withId(String value) {
        this.id = value;
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
    public OperationOutput withOperationReferences(OperationPaymentReferences value) {
        this.operationReferences = value;
        return this;
    }

    /**
     * Payment method identifier used by the our payment engine.
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Payment method identifier used by the our payment engine.
     */
    public void setPaymentMethod(String value) {
        this.paymentMethod = value;
    }

    /**
     * Payment method identifier used by the our payment engine.
     */
    public OperationOutput withPaymentMethod(String value) {
        this.paymentMethod = value;
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
    public OperationOutput withReferences(PaymentReferences value) {
        this.references = value;
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
    public OperationOutput withStatus(String value) {
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
    public OperationOutput withStatusOutput(PaymentStatusOutput value) {
        this.statusOutput = value;
        return this;
    }
}
