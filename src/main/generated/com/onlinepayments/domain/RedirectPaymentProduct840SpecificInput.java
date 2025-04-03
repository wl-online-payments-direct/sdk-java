/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RedirectPaymentProduct840SpecificInput {

    private Boolean JavaScriptSdkFlow;

    private Boolean addressSelectionAtPayPal;

    private String custom;

    private Boolean payLater;

    /**
     * To be enabled when Javascript SDK integration is implemented on S2S flow
     * <ul>
     *   <li>false = When this flag is disabled the field RedirectionURL is returned by CreatePayment call and should be used in merchant implementation to redirect buyer to PayPal.</li>
     *   <li>true = When this flag is enabled the field orderID is returned by CreatePayment call and should be utilized in case merchant has integrated JS SDK button on their S2S implementation
     * Default value is false.</li>
     * </ul>
     */
    public Boolean getJavaScriptSdkFlow() {
        return JavaScriptSdkFlow;
    }

    /**
     * To be enabled when Javascript SDK integration is implemented on S2S flow
     * <ul>
     *   <li>false = When this flag is disabled the field RedirectionURL is returned by CreatePayment call and should be used in merchant implementation to redirect buyer to PayPal.</li>
     *   <li>true = When this flag is enabled the field orderID is returned by CreatePayment call and should be utilized in case merchant has integrated JS SDK button on their S2S implementation
     * Default value is false.</li>
     * </ul>
     */
    public void setJavaScriptSdkFlow(Boolean value) {
        this.JavaScriptSdkFlow = value;
    }

    /**
     * To be enabled when Javascript SDK integration is implemented on S2S flow
     * <ul>
     *   <li>false = When this flag is disabled the field RedirectionURL is returned by CreatePayment call and should be used in merchant implementation to redirect buyer to PayPal.</li>
     *   <li>true = When this flag is enabled the field orderID is returned by CreatePayment call and should be utilized in case merchant has integrated JS SDK button on their S2S implementation
     * Default value is false.</li>
     * </ul>
     */
    public RedirectPaymentProduct840SpecificInput withJavaScriptSdkFlow(Boolean value) {
        this.JavaScriptSdkFlow = value;
        return this;
    }

    /**
     * Indicates whether to use PayPal Express Checkout Shortcut.
     * <ul>
     *   <li>true = When shortcut is enabled, the consumer can select a shipping address during PayPal checkout.</li>
     *   <li>false = When shortcut is disabled, the consumer cannot change the shipping address.
     * Default value is false.
     * Please note that this field is ignored when order.additionalInput.typeInformation.purchaseType is set to &quot;digital&quot;</li>
     * </ul>
     */
    public Boolean getAddressSelectionAtPayPal() {
        return addressSelectionAtPayPal;
    }

    /**
     * Indicates whether to use PayPal Express Checkout Shortcut.
     * <ul>
     *   <li>true = When shortcut is enabled, the consumer can select a shipping address during PayPal checkout.</li>
     *   <li>false = When shortcut is disabled, the consumer cannot change the shipping address.
     * Default value is false.
     * Please note that this field is ignored when order.additionalInput.typeInformation.purchaseType is set to &quot;digital&quot;</li>
     * </ul>
     */
    public void setAddressSelectionAtPayPal(Boolean value) {
        this.addressSelectionAtPayPal = value;
    }

    /**
     * Indicates whether to use PayPal Express Checkout Shortcut.
     * <ul>
     *   <li>true = When shortcut is enabled, the consumer can select a shipping address during PayPal checkout.</li>
     *   <li>false = When shortcut is disabled, the consumer cannot change the shipping address.
     * Default value is false.
     * Please note that this field is ignored when order.additionalInput.typeInformation.purchaseType is set to &quot;digital&quot;</li>
     * </ul>
     */
    public RedirectPaymentProduct840SpecificInput withAddressSelectionAtPayPal(Boolean value) {
        this.addressSelectionAtPayPal = value;
        return this;
    }

    /**
     * Free text field that you can use to support reconciliation flow.
     */
    public String getCustom() {
        return custom;
    }

    /**
     * Free text field that you can use to support reconciliation flow.
     */
    public void setCustom(String value) {
        this.custom = value;
    }

    /**
     * Free text field that you can use to support reconciliation flow.
     */
    public RedirectPaymentProduct840SpecificInput withCustom(String value) {
        this.custom = value;
        return this;
    }

    /**
     * Indicates whether to allow PayPal Pay Later option.
     * <ul>
     *   <li>true = When option is enabled, the consumer can select the PayPal PayLater button given that the merchant meets the eligibility criteria from PayPal.</li>
     *   <li>false = When option is disabled, the consumer cannot select the PayPal PayLater button.
     * Default value is true.</li>
     * </ul>
     */
    public Boolean getPayLater() {
        return payLater;
    }

    /**
     * Indicates whether to allow PayPal Pay Later option.
     * <ul>
     *   <li>true = When option is enabled, the consumer can select the PayPal PayLater button given that the merchant meets the eligibility criteria from PayPal.</li>
     *   <li>false = When option is disabled, the consumer cannot select the PayPal PayLater button.
     * Default value is true.</li>
     * </ul>
     */
    public void setPayLater(Boolean value) {
        this.payLater = value;
    }

    /**
     * Indicates whether to allow PayPal Pay Later option.
     * <ul>
     *   <li>true = When option is enabled, the consumer can select the PayPal PayLater button given that the merchant meets the eligibility criteria from PayPal.</li>
     *   <li>false = When option is disabled, the consumer cannot select the PayPal PayLater button.
     * Default value is true.</li>
     * </ul>
     */
    public RedirectPaymentProduct840SpecificInput withPayLater(Boolean value) {
        this.payLater = value;
        return this;
    }
}
