/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CaptureOutput {

    private AmountOfMoney acquiredAmount;

    private AmountOfMoney amountOfMoney;

    private Long amountPaid;

    private CardPaymentMethodSpecificOutput cardPaymentMethodSpecificOutput;

    private String merchantParameters;

    private MobilePaymentMethodSpecificOutput mobilePaymentMethodSpecificOutput;

    private OperationPaymentReferences operationReferences;

    private String paymentMethod;

    private RedirectPaymentMethodSpecificOutput redirectPaymentMethodSpecificOutput;

    private PaymentReferences references;

    private SepaDirectDebitPaymentMethodSpecificOutput sepaDirectDebitPaymentMethodSpecificOutput;

    private SurchargeSpecificOutput surchargeSpecificOutput;

    /**
     * Object containing amount and ISO currency code attributes
     */
    public AmountOfMoney getAcquiredAmount() {
        return acquiredAmount;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public void setAcquiredAmount(AmountOfMoney value) {
        this.acquiredAmount = value;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public CaptureOutput withAcquiredAmount(AmountOfMoney value) {
        this.acquiredAmount = value;
        return this;
    }

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
    public CaptureOutput withAmountOfMoney(AmountOfMoney value) {
        this.amountOfMoney = value;
        return this;
    }

    /**
     * Amount that has been paid. This is deprecated. Use acquiredAmount instead.
     *
     * @deprecated Amount that has been paid. This is deprecated. Use acquiredAmount instead.
     */
    @Deprecated
    public Long getAmountPaid() {
        return amountPaid;
    }

    /**
     * Amount that has been paid. This is deprecated. Use acquiredAmount instead.
     *
     * @deprecated Amount that has been paid. This is deprecated. Use acquiredAmount instead.
     */
    @Deprecated
    public void setAmountPaid(Long value) {
        this.amountPaid = value;
    }

    /**
     * Amount that has been paid. This is deprecated. Use acquiredAmount instead.
     *
     * @deprecated Amount that has been paid. This is deprecated. Use acquiredAmount instead.
     */
    @Deprecated
    public CaptureOutput withAmountPaid(Long value) {
        this.amountPaid = value;
        return this;
    }

    /**
     * Object containing the card payment method details
     */
    public CardPaymentMethodSpecificOutput getCardPaymentMethodSpecificOutput() {
        return cardPaymentMethodSpecificOutput;
    }

    /**
     * Object containing the card payment method details
     */
    public void setCardPaymentMethodSpecificOutput(CardPaymentMethodSpecificOutput value) {
        this.cardPaymentMethodSpecificOutput = value;
    }

    /**
     * Object containing the card payment method details
     */
    public CaptureOutput withCardPaymentMethodSpecificOutput(CardPaymentMethodSpecificOutput value) {
        this.cardPaymentMethodSpecificOutput = value;
        return this;
    }

    /**
     * It allows you to store additional parameters for the transaction in the format you prefer (e.g.-&gt; key-value query string, JSON, etc.) These parameters are then echoed back to you in API GET calls and Webhook notifications. This field must not contain any personal data.
     */
    public String getMerchantParameters() {
        return merchantParameters;
    }

    /**
     * It allows you to store additional parameters for the transaction in the format you prefer (e.g.-&gt; key-value query string, JSON, etc.) These parameters are then echoed back to you in API GET calls and Webhook notifications. This field must not contain any personal data.
     */
    public void setMerchantParameters(String value) {
        this.merchantParameters = value;
    }

    /**
     * It allows you to store additional parameters for the transaction in the format you prefer (e.g.-&gt; key-value query string, JSON, etc.) These parameters are then echoed back to you in API GET calls and Webhook notifications. This field must not contain any personal data.
     */
    public CaptureOutput withMerchantParameters(String value) {
        this.merchantParameters = value;
        return this;
    }

    /**
     * Object containing the mobile payment method details
     */
    public MobilePaymentMethodSpecificOutput getMobilePaymentMethodSpecificOutput() {
        return mobilePaymentMethodSpecificOutput;
    }

    /**
     * Object containing the mobile payment method details
     */
    public void setMobilePaymentMethodSpecificOutput(MobilePaymentMethodSpecificOutput value) {
        this.mobilePaymentMethodSpecificOutput = value;
    }

    /**
     * Object containing the mobile payment method details
     */
    public CaptureOutput withMobilePaymentMethodSpecificOutput(MobilePaymentMethodSpecificOutput value) {
        this.mobilePaymentMethodSpecificOutput = value;
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
    public CaptureOutput withOperationReferences(OperationPaymentReferences value) {
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
    public CaptureOutput withPaymentMethod(String value) {
        this.paymentMethod = value;
        return this;
    }

    /**
     * Object containing the redirect payment product details
     */
    public RedirectPaymentMethodSpecificOutput getRedirectPaymentMethodSpecificOutput() {
        return redirectPaymentMethodSpecificOutput;
    }

    /**
     * Object containing the redirect payment product details
     */
    public void setRedirectPaymentMethodSpecificOutput(RedirectPaymentMethodSpecificOutput value) {
        this.redirectPaymentMethodSpecificOutput = value;
    }

    /**
     * Object containing the redirect payment product details
     */
    public CaptureOutput withRedirectPaymentMethodSpecificOutput(RedirectPaymentMethodSpecificOutput value) {
        this.redirectPaymentMethodSpecificOutput = value;
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
    public CaptureOutput withReferences(PaymentReferences value) {
        this.references = value;
        return this;
    }

    /**
     * Object containing the SEPA direct debit details
     */
    public SepaDirectDebitPaymentMethodSpecificOutput getSepaDirectDebitPaymentMethodSpecificOutput() {
        return sepaDirectDebitPaymentMethodSpecificOutput;
    }

    /**
     * Object containing the SEPA direct debit details
     */
    public void setSepaDirectDebitPaymentMethodSpecificOutput(SepaDirectDebitPaymentMethodSpecificOutput value) {
        this.sepaDirectDebitPaymentMethodSpecificOutput = value;
    }

    /**
     * Object containing the SEPA direct debit details
     */
    public CaptureOutput withSepaDirectDebitPaymentMethodSpecificOutput(SepaDirectDebitPaymentMethodSpecificOutput value) {
        this.sepaDirectDebitPaymentMethodSpecificOutput = value;
        return this;
    }

    /**
     * Object containing specific surcharging attributes applied to an order.
     */
    public SurchargeSpecificOutput getSurchargeSpecificOutput() {
        return surchargeSpecificOutput;
    }

    /**
     * Object containing specific surcharging attributes applied to an order.
     */
    public void setSurchargeSpecificOutput(SurchargeSpecificOutput value) {
        this.surchargeSpecificOutput = value;
    }

    /**
     * Object containing specific surcharging attributes applied to an order.
     */
    public CaptureOutput withSurchargeSpecificOutput(SurchargeSpecificOutput value) {
        this.surchargeSpecificOutput = value;
        return this;
    }
}
