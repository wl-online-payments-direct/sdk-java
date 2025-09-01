/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class MobilePaymentProduct302SpecificInput {

    private ApplePayRecurringPaymentRequest applePayRecurringPaymentRequest;

    private Boolean isRecurring;

    private Product302Recurring recurring;

    private Boolean tokenize;

    /**
     * Object containing information specific to Apple Pay recurring request.
     */
    public ApplePayRecurringPaymentRequest getApplePayRecurringPaymentRequest() {
        return applePayRecurringPaymentRequest;
    }

    /**
     * Object containing information specific to Apple Pay recurring request.
     */
    public void setApplePayRecurringPaymentRequest(ApplePayRecurringPaymentRequest value) {
        this.applePayRecurringPaymentRequest = value;
    }

    /**
     * Object containing information specific to Apple Pay recurring request.
     */
    public MobilePaymentProduct302SpecificInput withApplePayRecurringPaymentRequest(ApplePayRecurringPaymentRequest value) {
        this.applePayRecurringPaymentRequest = value;
        return this;
    }

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
    public MobilePaymentProduct302SpecificInput withIsRecurring(Boolean value) {
        this.isRecurring = value;
        return this;
    }

    /**
     * Object containing information specific to Apple Pay and recurring.
     */
    public Product302Recurring getRecurring() {
        return recurring;
    }

    /**
     * Object containing information specific to Apple Pay and recurring.
     */
    public void setRecurring(Product302Recurring value) {
        this.recurring = value;
    }

    /**
     * Object containing information specific to Apple Pay and recurring.
     */
    public MobilePaymentProduct302SpecificInput withRecurring(Product302Recurring value) {
        this.recurring = value;
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
    public MobilePaymentProduct302SpecificInput withTokenize(Boolean value) {
        this.tokenize = value;
        return this;
    }
}
