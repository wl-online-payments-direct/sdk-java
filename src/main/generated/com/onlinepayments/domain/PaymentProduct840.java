/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProduct840 {

    private String orderId;

    /**
     * Contains an identifier supplied by PayPal which must be provided to the PayPal JavaScript SDK.
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Contains an identifier supplied by PayPal which must be provided to the PayPal JavaScript SDK.
     */
    public void setOrderId(String value) {
        this.orderId = value;
    }

    /**
     * Contains an identifier supplied by PayPal which must be provided to the PayPal JavaScript SDK.
     */
    public PaymentProduct840 withOrderId(String value) {
        this.orderId = value;
        return this;
    }
}
