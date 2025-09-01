/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class MobilePaymentProduct320SpecificInput {

    private Boolean isRecurring;

    private Product320Recurring recurring;

    private GPayThreeDSecure threeDSecure;

    private Boolean tokenize;

    /**
     * <ul>
     *   <li>true - Indicates that the transaction is part of a scheduled recurring sequence. In addition, recurringPaymentSequenceIndicator indicates if the transaction is the first or subsequent in a recurring sequence.</li>
     *   <li>false - Indicates that the transaction is not part of a scheduled recurring sequence.
     * The default value for this property is false.
     * For HostedCheckout use the hostedCheckoutSpecificInput.isRecurring property instead.</li>
     * </ul>
     */
    public Boolean getIsRecurring() {
        return isRecurring;
    }

    /**
     * <ul>
     *   <li>true - Indicates that the transaction is part of a scheduled recurring sequence. In addition, recurringPaymentSequenceIndicator indicates if the transaction is the first or subsequent in a recurring sequence.</li>
     *   <li>false - Indicates that the transaction is not part of a scheduled recurring sequence.
     * The default value for this property is false.
     * For HostedCheckout use the hostedCheckoutSpecificInput.isRecurring property instead.</li>
     * </ul>
     */
    public void setIsRecurring(Boolean value) {
        this.isRecurring = value;
    }

    /**
     * <ul>
     *   <li>true - Indicates that the transaction is part of a scheduled recurring sequence. In addition, recurringPaymentSequenceIndicator indicates if the transaction is the first or subsequent in a recurring sequence.</li>
     *   <li>false - Indicates that the transaction is not part of a scheduled recurring sequence.
     * The default value for this property is false.
     * For HostedCheckout use the hostedCheckoutSpecificInput.isRecurring property instead.</li>
     * </ul>
     */
    public MobilePaymentProduct320SpecificInput withIsRecurring(Boolean value) {
        this.isRecurring = value;
        return this;
    }

    /**
     * Object containing information specific to Google Pay and recurring.
     */
    public Product320Recurring getRecurring() {
        return recurring;
    }

    /**
     * Object containing information specific to Google Pay and recurring.
     */
    public void setRecurring(Product320Recurring value) {
        this.recurring = value;
    }

    /**
     * Object containing information specific to Google Pay and recurring.
     */
    public MobilePaymentProduct320SpecificInput withRecurring(Product320Recurring value) {
        this.recurring = value;
        return this;
    }

    /**
     * Object containing specific data regarding 3-D Secure
     */
    public GPayThreeDSecure getThreeDSecure() {
        return threeDSecure;
    }

    /**
     * Object containing specific data regarding 3-D Secure
     */
    public void setThreeDSecure(GPayThreeDSecure value) {
        this.threeDSecure = value;
    }

    /**
     * Object containing specific data regarding 3-D Secure
     */
    public MobilePaymentProduct320SpecificInput withThreeDSecure(GPayThreeDSecure value) {
        this.threeDSecure = value;
        return this;
    }

    /**
     * Indicates if this transaction should be tokenized
     * <ul>
     *   <li>true - Tokenize the transaction. Note that a payment on the payment platform that results in a status REDIRECTED cannot be tokenized in this way.</li>
     *   <li>false - Do not tokenize the transaction, unless it would be tokenized by other means such as auto-tokenization of recurring payments.</li>
     * </ul>
     */
    public Boolean getTokenize() {
        return tokenize;
    }

    /**
     * Indicates if this transaction should be tokenized
     * <ul>
     *   <li>true - Tokenize the transaction. Note that a payment on the payment platform that results in a status REDIRECTED cannot be tokenized in this way.</li>
     *   <li>false - Do not tokenize the transaction, unless it would be tokenized by other means such as auto-tokenization of recurring payments.</li>
     * </ul>
     */
    public void setTokenize(Boolean value) {
        this.tokenize = value;
    }

    /**
     * Indicates if this transaction should be tokenized
     * <ul>
     *   <li>true - Tokenize the transaction. Note that a payment on the payment platform that results in a status REDIRECTED cannot be tokenized in this way.</li>
     *   <li>false - Do not tokenize the transaction, unless it would be tokenized by other means such as auto-tokenization of recurring payments.</li>
     * </ul>
     */
    public MobilePaymentProduct320SpecificInput withTokenize(Boolean value) {
        this.tokenize = value;
        return this;
    }
}
