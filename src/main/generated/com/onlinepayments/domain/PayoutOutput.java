/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.time.ZonedDateTime;

public class PayoutOutput {

    private AmountOfMoney amountOfMoney;

    private PayoutCardPaymentMethodSpecificOutput payoutCardPaymentMethodSpecificOutput;

    private String payoutReason;

    private PaymentReferences references;

    private ZonedDateTime transactionDate;

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
    public PayoutOutput withAmountOfMoney(AmountOfMoney value) {
        this.amountOfMoney = value;
        return this;
    }

    /**
     * Object containing the card payment method details in a Payout context
     */
    public PayoutCardPaymentMethodSpecificOutput getPayoutCardPaymentMethodSpecificOutput() {
        return payoutCardPaymentMethodSpecificOutput;
    }

    /**
     * Object containing the card payment method details in a Payout context
     */
    public void setPayoutCardPaymentMethodSpecificOutput(PayoutCardPaymentMethodSpecificOutput value) {
        this.payoutCardPaymentMethodSpecificOutput = value;
    }

    /**
     * Object containing the card payment method details in a Payout context
     */
    public PayoutOutput withPayoutCardPaymentMethodSpecificOutput(PayoutCardPaymentMethodSpecificOutput value) {
        this.payoutCardPaymentMethodSpecificOutput = value;
        return this;
    }

    /**
     * Allows you to additionally specify the reason for initiating the payout for authorization purposes. If this field is not specified, authorization of the payment will be made according to your merchant profile. Possible values are:
     * <ul>
     *   <li>Gambling</li>
     *   <li>Refund</li>
     *   <li>Loyalty</li>
     * </ul>
     */
    public String getPayoutReason() {
        return payoutReason;
    }

    /**
     * Allows you to additionally specify the reason for initiating the payout for authorization purposes. If this field is not specified, authorization of the payment will be made according to your merchant profile. Possible values are:
     * <ul>
     *   <li>Gambling</li>
     *   <li>Refund</li>
     *   <li>Loyalty</li>
     * </ul>
     */
    public void setPayoutReason(String value) {
        this.payoutReason = value;
    }

    /**
     * Allows you to additionally specify the reason for initiating the payout for authorization purposes. If this field is not specified, authorization of the payment will be made according to your merchant profile. Possible values are:
     * <ul>
     *   <li>Gambling</li>
     *   <li>Refund</li>
     *   <li>Loyalty</li>
     * </ul>
     */
    public PayoutOutput withPayoutReason(String value) {
        this.payoutReason = value;
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
    public PayoutOutput withReferences(PaymentReferences value) {
        this.references = value;
        return this;
    }

    /**
     * It is the server-side processing date and time of the transaction.
     */
    public ZonedDateTime getTransactionDate() {
        return transactionDate;
    }

    /**
     * It is the server-side processing date and time of the transaction.
     */
    public void setTransactionDate(ZonedDateTime value) {
        this.transactionDate = value;
    }

    /**
     * It is the server-side processing date and time of the transaction.
     */
    public PayoutOutput withTransactionDate(ZonedDateTime value) {
        this.transactionDate = value;
        return this;
    }
}
