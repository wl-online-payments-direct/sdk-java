/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class CardPaymentMethodSpecificInputForHostedCheckout {

    private Boolean clickToPay;

    private Boolean groupCards;

    private List<Integer> paymentProductPreferredOrder;

    private String tokenizationMode;

    /**
     * <ul>
     *   <li>true - Hosted Checkout will show Click to Pay, with cards grouped as one payment method</li>
     *   <li>false - Default - Hosted Checkout will show cards as separate payment methods without Click to Pay</li>
     * </ul>
     */
    public Boolean getClickToPay() {
        return clickToPay;
    }

    /**
     * <ul>
     *   <li>true - Hosted Checkout will show Click to Pay, with cards grouped as one payment method</li>
     *   <li>false - Default - Hosted Checkout will show cards as separate payment methods without Click to Pay</li>
     * </ul>
     */
    public void setClickToPay(Boolean value) {
        this.clickToPay = value;
    }

    /**
     * <ul>
     *   <li>true - Hosted Checkout will show Click to Pay, with cards grouped as one payment method</li>
     *   <li>false - Default - Hosted Checkout will show cards as separate payment methods without Click to Pay</li>
     * </ul>
     */
    public CardPaymentMethodSpecificInputForHostedCheckout withClickToPay(Boolean value) {
        this.clickToPay = value;
        return this;
    }

    /**
     * <ul>
     *   <li>true - Hosted Checkout will allow to show cards grouped as one payment method</li>
     *   <li>false - Default - Hosted Checkout will show cards as separate payment methods</li>
     * </ul>
     */
    public Boolean getGroupCards() {
        return groupCards;
    }

    /**
     * <ul>
     *   <li>true - Hosted Checkout will allow to show cards grouped as one payment method</li>
     *   <li>false - Default - Hosted Checkout will show cards as separate payment methods</li>
     * </ul>
     */
    public void setGroupCards(Boolean value) {
        this.groupCards = value;
    }

    /**
     * <ul>
     *   <li>true - Hosted Checkout will allow to show cards grouped as one payment method</li>
     *   <li>false - Default - Hosted Checkout will show cards as separate payment methods</li>
     * </ul>
     */
    public CardPaymentMethodSpecificInputForHostedCheckout withGroupCards(Boolean value) {
        this.groupCards = value;
        return this;
    }

    /**
     * This array contains the payment product identifiers representing the brands. For co-badged cards, this displays their available brands in the order defined by this array, when groupCards is activated.
     */
    public List<Integer> getPaymentProductPreferredOrder() {
        return paymentProductPreferredOrder;
    }

    /**
     * This array contains the payment product identifiers representing the brands. For co-badged cards, this displays their available brands in the order defined by this array, when groupCards is activated.
     */
    public void setPaymentProductPreferredOrder(List<Integer> value) {
        this.paymentProductPreferredOrder = value;
    }

    /**
     * This array contains the payment product identifiers representing the brands. For co-badged cards, this displays their available brands in the order defined by this array, when groupCards is activated.
     */
    public CardPaymentMethodSpecificInputForHostedCheckout withPaymentProductPreferredOrder(List<Integer> value) {
        this.paymentProductPreferredOrder = value;
        return this;
    }

    /**
     * Controls the generation and use of a token within a hosted checkout session.
     * <ul>
     *   <li>createWithConsent - Presents the payer with a capture consent checkbox to decide whether they would like to tokenize their payment information for future use.</li>
     *   <li>createAlways - Tokenizes the payment information automatically without presenting the capture consent checkbox to the payer; please ensure consent is captured on your interface.</li>
     *   <li>useExplicitly - The payer can only use the token supplied in cardpaymentmethodspecificinput.token; if the token is invalid or no token is provided, the request will fail.</li>
     *   <li>noTokenization - The payer's payment information will not be tokenized and the payer will not be presented with the ability to tokenize their payment information; use this for one-off payments.
     * Note: This property is not allowed when cardpaymentmethodspecificinput.tokenize is specified.</li>
     * </ul>
     */
    public String getTokenizationMode() {
        return tokenizationMode;
    }

    /**
     * Controls the generation and use of a token within a hosted checkout session.
     * <ul>
     *   <li>createWithConsent - Presents the payer with a capture consent checkbox to decide whether they would like to tokenize their payment information for future use.</li>
     *   <li>createAlways - Tokenizes the payment information automatically without presenting the capture consent checkbox to the payer; please ensure consent is captured on your interface.</li>
     *   <li>useExplicitly - The payer can only use the token supplied in cardpaymentmethodspecificinput.token; if the token is invalid or no token is provided, the request will fail.</li>
     *   <li>noTokenization - The payer's payment information will not be tokenized and the payer will not be presented with the ability to tokenize their payment information; use this for one-off payments.
     * Note: This property is not allowed when cardpaymentmethodspecificinput.tokenize is specified.</li>
     * </ul>
     */
    public void setTokenizationMode(String value) {
        this.tokenizationMode = value;
    }

    /**
     * Controls the generation and use of a token within a hosted checkout session.
     * <ul>
     *   <li>createWithConsent - Presents the payer with a capture consent checkbox to decide whether they would like to tokenize their payment information for future use.</li>
     *   <li>createAlways - Tokenizes the payment information automatically without presenting the capture consent checkbox to the payer; please ensure consent is captured on your interface.</li>
     *   <li>useExplicitly - The payer can only use the token supplied in cardpaymentmethodspecificinput.token; if the token is invalid or no token is provided, the request will fail.</li>
     *   <li>noTokenization - The payer's payment information will not be tokenized and the payer will not be presented with the ability to tokenize their payment information; use this for one-off payments.
     * Note: This property is not allowed when cardpaymentmethodspecificinput.tokenize is specified.</li>
     * </ul>
     */
    public CardPaymentMethodSpecificInputForHostedCheckout withTokenizationMode(String value) {
        this.tokenizationMode = value;
        return this;
    }
}
