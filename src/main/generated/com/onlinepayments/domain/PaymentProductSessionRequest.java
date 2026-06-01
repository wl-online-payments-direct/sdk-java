/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProductSessionRequest {

    private PaymentProductSession302SpecificInput paymentProductSession302SpecificInput;

    /**
     * The specific input details needed to create a payment product session for Apple Pay (payment product 302).
     */
    public PaymentProductSession302SpecificInput getPaymentProductSession302SpecificInput() {
        return paymentProductSession302SpecificInput;
    }

    /**
     * The specific input details needed to create a payment product session for Apple Pay (payment product 302).
     */
    public void setPaymentProductSession302SpecificInput(PaymentProductSession302SpecificInput value) {
        this.paymentProductSession302SpecificInput = value;
    }

    /**
     * The specific input details needed to create a payment product session for Apple Pay (payment product 302).
     */
    public PaymentProductSessionRequest withPaymentProductSession302SpecificInput(PaymentProductSession302SpecificInput value) {
        this.paymentProductSession302SpecificInput = value;
        return this;
    }
}
