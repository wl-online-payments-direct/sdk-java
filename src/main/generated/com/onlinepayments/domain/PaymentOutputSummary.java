/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.time.ZonedDateTime;

public class PaymentOutputSummary {

    private AmountOfMoney amountOfMoney;

    private CardPaymentMethodSpecificOutputSummary cardPaymentMethodSpecificOutput;

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
    public PaymentOutputSummary withAmountOfMoney(AmountOfMoney value) {
        this.amountOfMoney = value;
        return this;
    }

    /**
     * Summary of card payment method details for reporting
     */
    public CardPaymentMethodSpecificOutputSummary getCardPaymentMethodSpecificOutput() {
        return cardPaymentMethodSpecificOutput;
    }

    /**
     * Summary of card payment method details for reporting
     */
    public void setCardPaymentMethodSpecificOutput(CardPaymentMethodSpecificOutputSummary value) {
        this.cardPaymentMethodSpecificOutput = value;
    }

    /**
     * Summary of card payment method details for reporting
     */
    public PaymentOutputSummary withCardPaymentMethodSpecificOutput(CardPaymentMethodSpecificOutputSummary value) {
        this.cardPaymentMethodSpecificOutput = value;
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
    public PaymentOutputSummary withReferences(PaymentReferences value) {
        this.references = value;
        return this;
    }

    /**
     * Date and time the payment was created in UTC
     */
    public ZonedDateTime getTransactionDate() {
        return transactionDate;
    }

    /**
     * Date and time the payment was created in UTC
     */
    public void setTransactionDate(ZonedDateTime value) {
        this.transactionDate = value;
    }

    /**
     * Date and time the payment was created in UTC
     */
    public PaymentOutputSummary withTransactionDate(ZonedDateTime value) {
        this.transactionDate = value;
        return this;
    }
}
