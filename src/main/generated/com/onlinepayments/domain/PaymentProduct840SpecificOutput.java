/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProduct840SpecificOutput {

    private Address billingAddress;

    private AddressPersonal billingPersonalAddress;

    private PaymentProduct840CustomerAccount customerAccount;

    private Address customerAddress;

    private String payPalTransactionId;

    private ProtectionEligibility protectionEligibility;

    private AddressPersonal shippingAddress;

    /**
     * Object containing billing address details.
     */
    public Address getBillingAddress() {
        return billingAddress;
    }

    /**
     * Object containing billing address details.
     */
    public void setBillingAddress(Address value) {
        this.billingAddress = value;
    }

    /**
     * Object containing billing address details.
     */
    public PaymentProduct840SpecificOutput withBillingAddress(Address value) {
        this.billingAddress = value;
        return this;
    }

    /**
     * Object containing address information
     */
    public AddressPersonal getBillingPersonalAddress() {
        return billingPersonalAddress;
    }

    /**
     * Object containing address information
     */
    public void setBillingPersonalAddress(AddressPersonal value) {
        this.billingPersonalAddress = value;
    }

    /**
     * Object containing address information
     */
    public PaymentProduct840SpecificOutput withBillingPersonalAddress(AddressPersonal value) {
        this.billingPersonalAddress = value;
        return this;
    }

    /**
     * Object containing the details of the PayPal account
     */
    public PaymentProduct840CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    /**
     * Object containing the details of the PayPal account
     */
    public void setCustomerAccount(PaymentProduct840CustomerAccount value) {
        this.customerAccount = value;
    }

    /**
     * Object containing the details of the PayPal account
     */
    public PaymentProduct840SpecificOutput withCustomerAccount(PaymentProduct840CustomerAccount value) {
        this.customerAccount = value;
        return this;
    }

    /**
     * Object containing billing address details.
     */
    public Address getCustomerAddress() {
        return customerAddress;
    }

    /**
     * Object containing billing address details.
     */
    public void setCustomerAddress(Address value) {
        this.customerAddress = value;
    }

    /**
     * Object containing billing address details.
     */
    public PaymentProduct840SpecificOutput withCustomerAddress(Address value) {
        this.customerAddress = value;
        return this;
    }

    /**
     * Id of a transaction given by PayPal
     */
    public String getPayPalTransactionId() {
        return payPalTransactionId;
    }

    /**
     * Id of a transaction given by PayPal
     */
    public void setPayPalTransactionId(String value) {
        this.payPalTransactionId = value;
    }

    /**
     * Id of a transaction given by PayPal
     */
    public PaymentProduct840SpecificOutput withPayPalTransactionId(String value) {
        this.payPalTransactionId = value;
        return this;
    }

    /**
     * Kind of seller protection in force for the PayPal transaction
     */
    public ProtectionEligibility getProtectionEligibility() {
        return protectionEligibility;
    }

    /**
     * Kind of seller protection in force for the PayPal transaction
     */
    public void setProtectionEligibility(ProtectionEligibility value) {
        this.protectionEligibility = value;
    }

    /**
     * Kind of seller protection in force for the PayPal transaction
     */
    public PaymentProduct840SpecificOutput withProtectionEligibility(ProtectionEligibility value) {
        this.protectionEligibility = value;
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
    public PaymentProduct840SpecificOutput withShippingAddress(AddressPersonal value) {
        this.shippingAddress = value;
        return this;
    }
}
