/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class CardPaymentMethodSpecificInputForHostedCheckout {

    private Boolean clickToPay;

    private Boolean groupCards;

    private List<Integer> paymentProductPreferredOrder;

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
}
