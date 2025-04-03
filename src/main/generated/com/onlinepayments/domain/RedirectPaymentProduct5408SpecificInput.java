/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RedirectPaymentProduct5408SpecificInput {

    private CustomerBankAccount customerBankAccount;

    private Boolean instantPaymentOnly;

    /**
     * Data of customer bank account
     */
    public CustomerBankAccount getCustomerBankAccount() {
        return customerBankAccount;
    }

    /**
     * Data of customer bank account
     */
    public void setCustomerBankAccount(CustomerBankAccount value) {
        this.customerBankAccount = value;
    }

    /**
     * Data of customer bank account
     */
    public RedirectPaymentProduct5408SpecificInput withCustomerBankAccount(CustomerBankAccount value) {
        this.customerBankAccount = value;
        return this;
    }

    /**
     * <ul>
     *   <li>true - consumer can only use instant payment for Account to Account Bank transfer payments</li>
     *   <li>false - consumer can only use standard payment for Account to Account Bank transfer payments</li>
     * </ul>
     */
    public Boolean getInstantPaymentOnly() {
        return instantPaymentOnly;
    }

    /**
     * <ul>
     *   <li>true - consumer can only use instant payment for Account to Account Bank transfer payments</li>
     *   <li>false - consumer can only use standard payment for Account to Account Bank transfer payments</li>
     * </ul>
     */
    public void setInstantPaymentOnly(Boolean value) {
        this.instantPaymentOnly = value;
    }

    /**
     * <ul>
     *   <li>true - consumer can only use instant payment for Account to Account Bank transfer payments</li>
     *   <li>false - consumer can only use standard payment for Account to Account Bank transfer payments</li>
     * </ul>
     */
    public RedirectPaymentProduct5408SpecificInput withInstantPaymentOnly(Boolean value) {
        this.instantPaymentOnly = value;
        return this;
    }
}
