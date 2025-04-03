/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RefundPaymentProduct840CustomerAccount {

    private String customerAccountStatus;

    private String customerAddressStatus;

    private String payerId;

    public String getCustomerAccountStatus() {
        return customerAccountStatus;
    }

    public void setCustomerAccountStatus(String value) {
        this.customerAccountStatus = value;
    }

    public RefundPaymentProduct840CustomerAccount withCustomerAccountStatus(String value) {
        this.customerAccountStatus = value;
        return this;
    }

    public String getCustomerAddressStatus() {
        return customerAddressStatus;
    }

    public void setCustomerAddressStatus(String value) {
        this.customerAddressStatus = value;
    }

    public RefundPaymentProduct840CustomerAccount withCustomerAddressStatus(String value) {
        this.customerAddressStatus = value;
        return this;
    }

    /**
     * The unique identifier of a PayPal account and will never change in the life cycle of a PayPal account
     */
    public String getPayerId() {
        return payerId;
    }

    /**
     * The unique identifier of a PayPal account and will never change in the life cycle of a PayPal account
     */
    public void setPayerId(String value) {
        this.payerId = value;
    }

    /**
     * The unique identifier of a PayPal account and will never change in the life cycle of a PayPal account
     */
    public RefundPaymentProduct840CustomerAccount withPayerId(String value) {
        this.payerId = value;
        return this;
    }
}
