/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

/**
 * @deprecated An object containing the details of the related payment input.  All properties in paymentLinkOrder are deprecated. Use corresponding values as noted below: | Property | Replacement | | - | - | | merchantReference | references/merchantReference | | amount | order/amountOfMoney | | surchargeSpecificInput | order/surchargeSpecificInput |
 */
@Deprecated
public class PaymentLinkOrderInput {

    private AmountOfMoney amount;

    private String merchantReference;

    private SurchargeForPaymentLink surchargeSpecificInput;

    /**
     * Object containing amount and ISO currency code attributes
     */
    public AmountOfMoney getAmount() {
        return amount;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public void setAmount(AmountOfMoney value) {
        this.amount = value;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public PaymentLinkOrderInput withAmount(AmountOfMoney value) {
        this.amount = value;
        return this;
    }

    /**
     * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
     * It is highly recommended to provide a single MerchantReference per unique order on your side
     */
    public String getMerchantReference() {
        return merchantReference;
    }

    /**
     * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
     * It is highly recommended to provide a single MerchantReference per unique order on your side
     */
    public void setMerchantReference(String value) {
        this.merchantReference = value;
    }

    /**
     * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
     * It is highly recommended to provide a single MerchantReference per unique order on your side
     */
    public PaymentLinkOrderInput withMerchantReference(String value) {
        this.merchantReference = value;
        return this;
    }

    /**
     * Object containing details how surcharge will be applied to a payment link.
     */
    public SurchargeForPaymentLink getSurchargeSpecificInput() {
        return surchargeSpecificInput;
    }

    /**
     * Object containing details how surcharge will be applied to a payment link.
     */
    public void setSurchargeSpecificInput(SurchargeForPaymentLink value) {
        this.surchargeSpecificInput = value;
    }

    /**
     * Object containing details how surcharge will be applied to a payment link.
     */
    public PaymentLinkOrderInput withSurchargeSpecificInput(SurchargeForPaymentLink value) {
        this.surchargeSpecificInput = value;
        return this;
    }
}
