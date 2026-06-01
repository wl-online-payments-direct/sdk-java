/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProductSession302SpecificOutput {

    private String session;

    /**
     * The payment session object that must be passed to the Apple Pay API on the client side to initialize the Apple Pay payment sheet.
     */
    public String getSession() {
        return session;
    }

    /**
     * The payment session object that must be passed to the Apple Pay API on the client side to initialize the Apple Pay payment sheet.
     */
    public void setSession(String value) {
        this.session = value;
    }

    /**
     * The payment session object that must be passed to the Apple Pay API on the client side to initialize the Apple Pay payment sheet.
     */
    public PaymentProductSession302SpecificOutput withSession(String value) {
        this.session = value;
        return this;
    }
}
