/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProduct3203SpecificOutput {

    private AddressPersonal billingAddress;

    private AddressPersonal shippingAddress;

    /**
     * Object containing address information
     */
    public AddressPersonal getBillingAddress() {
        return billingAddress;
    }

    /**
     * Object containing address information
     */
    public void setBillingAddress(AddressPersonal value) {
        this.billingAddress = value;
    }

    /**
     * Object containing address information
     */
    public PaymentProduct3203SpecificOutput withBillingAddress(AddressPersonal value) {
        this.billingAddress = value;
        return this;
    }

    /**
     * Object containing address information
     */
    public AddressPersonal getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Object containing address information
     */
    public void setShippingAddress(AddressPersonal value) {
        this.shippingAddress = value;
    }

    /**
     * Object containing address information
     */
    public PaymentProduct3203SpecificOutput withShippingAddress(AddressPersonal value) {
        this.shippingAddress = value;
        return this;
    }
}
