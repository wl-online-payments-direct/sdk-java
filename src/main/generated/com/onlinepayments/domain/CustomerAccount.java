/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CustomerAccount {

    private CustomerAccountAuthentication authentication;

    private String changeDate;

    private Boolean changedDuringCheckout;

    private String createDate;

    private Boolean hadSuspiciousActivity;

    private String passwordChangeDate;

    private Boolean passwordChangedDuringCheckout;

    private PaymentAccountOnFile paymentAccountOnFile;

    private CustomerPaymentActivity paymentActivity;

    /**
     * Object containing data on the authentication used by the customer to access their account
     */
    public CustomerAccountAuthentication getAuthentication() {
        return authentication;
    }

    /**
     * Object containing data on the authentication used by the customer to access their account
     */
    public void setAuthentication(CustomerAccountAuthentication value) {
        this.authentication = value;
    }

    /**
     * Object containing data on the authentication used by the customer to access their account
     */
    public CustomerAccount withAuthentication(CustomerAccountAuthentication value) {
        this.authentication = value;
        return this;
    }

    /**
     * The last date (YYYYMMDD) on which the customer made changes to their account with you. These are changes to billing &amp; shipping address details, new payment account (tokens), or new users(s) added.
     */
    public String getChangeDate() {
        return changeDate;
    }

    /**
     * The last date (YYYYMMDD) on which the customer made changes to their account with you. These are changes to billing &amp; shipping address details, new payment account (tokens), or new users(s) added.
     */
    public void setChangeDate(String value) {
        this.changeDate = value;
    }

    /**
     * The last date (YYYYMMDD) on which the customer made changes to their account with you. These are changes to billing &amp; shipping address details, new payment account (tokens), or new users(s) added.
     */
    public CustomerAccount withChangeDate(String value) {
        this.changeDate = value;
        return this;
    }

    /**
     * <ul>
     *   <li>true = the customer made changes to their account during this checkout</li>
     *   <li>false = the customer did nnot change anything to their account during this checkout/n</li>
     * </ul>
     * <p>
     * The changes ment here are changes to billing &amp; shipping address details, new payment account (tokens), or new users(s) added.
     */
    public Boolean getChangedDuringCheckout() {
        return changedDuringCheckout;
    }

    /**
     * <ul>
     *   <li>true = the customer made changes to their account during this checkout</li>
     *   <li>false = the customer did nnot change anything to their account during this checkout/n</li>
     * </ul>
     * <p>
     * The changes ment here are changes to billing &amp; shipping address details, new payment account (tokens), or new users(s) added.
     */
    public void setChangedDuringCheckout(Boolean value) {
        this.changedDuringCheckout = value;
    }

    /**
     * <ul>
     *   <li>true = the customer made changes to their account during this checkout</li>
     *   <li>false = the customer did nnot change anything to their account during this checkout/n</li>
     * </ul>
     * <p>
     * The changes ment here are changes to billing &amp; shipping address details, new payment account (tokens), or new users(s) added.
     */
    public CustomerAccount withChangedDuringCheckout(Boolean value) {
        this.changedDuringCheckout = value;
        return this;
    }

    /**
     * The date (YYYYMMDD) on which the customer created their account with you
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * The date (YYYYMMDD) on which the customer created their account with you
     */
    public void setCreateDate(String value) {
        this.createDate = value;
    }

    /**
     * The date (YYYYMMDD) on which the customer created their account with you
     */
    public CustomerAccount withCreateDate(String value) {
        this.createDate = value;
        return this;
    }

    /**
     * Specifies if you have experienced suspicious activity on the account of the customer
     * <p>
     * true = you have experienced suspicious activity (including previous fraud) on the customer account used for this transaction
     * <p>
     * false = you have experienced no suspicious activity (including previous fraud) on the customer account used for this transaction
     */
    public Boolean getHadSuspiciousActivity() {
        return hadSuspiciousActivity;
    }

    /**
     * Specifies if you have experienced suspicious activity on the account of the customer
     * <p>
     * true = you have experienced suspicious activity (including previous fraud) on the customer account used for this transaction
     * <p>
     * false = you have experienced no suspicious activity (including previous fraud) on the customer account used for this transaction
     */
    public void setHadSuspiciousActivity(Boolean value) {
        this.hadSuspiciousActivity = value;
    }

    /**
     * Specifies if you have experienced suspicious activity on the account of the customer
     * <p>
     * true = you have experienced suspicious activity (including previous fraud) on the customer account used for this transaction
     * <p>
     * false = you have experienced no suspicious activity (including previous fraud) on the customer account used for this transaction
     */
    public CustomerAccount withHadSuspiciousActivity(Boolean value) {
        this.hadSuspiciousActivity = value;
        return this;
    }

    /**
     * The last date (YYYYMMDD) on which the customer changed their password for the account used in this transaction
     */
    public String getPasswordChangeDate() {
        return passwordChangeDate;
    }

    /**
     * The last date (YYYYMMDD) on which the customer changed their password for the account used in this transaction
     */
    public void setPasswordChangeDate(String value) {
        this.passwordChangeDate = value;
    }

    /**
     * The last date (YYYYMMDD) on which the customer changed their password for the account used in this transaction
     */
    public CustomerAccount withPasswordChangeDate(String value) {
        this.passwordChangeDate = value;
        return this;
    }

    /**
     * Indicates if the password of an account is changed during this checkout
     * <p>
     * true = the customer made changes to their password of the account used during this checkout
     * <p>
     * false = the customer did not change anything to their password of the account used during this checkout
     */
    public Boolean getPasswordChangedDuringCheckout() {
        return passwordChangedDuringCheckout;
    }

    /**
     * Indicates if the password of an account is changed during this checkout
     * <p>
     * true = the customer made changes to their password of the account used during this checkout
     * <p>
     * false = the customer did not change anything to their password of the account used during this checkout
     */
    public void setPasswordChangedDuringCheckout(Boolean value) {
        this.passwordChangedDuringCheckout = value;
    }

    /**
     * Indicates if the password of an account is changed during this checkout
     * <p>
     * true = the customer made changes to their password of the account used during this checkout
     * <p>
     * false = the customer did not change anything to their password of the account used during this checkout
     */
    public CustomerAccount withPasswordChangedDuringCheckout(Boolean value) {
        this.passwordChangedDuringCheckout = value;
        return this;
    }

    /**
     * Object containing information on the payment account data on file (tokens)
     */
    public PaymentAccountOnFile getPaymentAccountOnFile() {
        return paymentAccountOnFile;
    }

    /**
     * Object containing information on the payment account data on file (tokens)
     */
    public void setPaymentAccountOnFile(PaymentAccountOnFile value) {
        this.paymentAccountOnFile = value;
    }

    /**
     * Object containing information on the payment account data on file (tokens)
     */
    public CustomerAccount withPaymentAccountOnFile(PaymentAccountOnFile value) {
        this.paymentAccountOnFile = value;
        return this;
    }

    /**
     * Object containing data on the purchase history of the customer with you
     */
    public CustomerPaymentActivity getPaymentActivity() {
        return paymentActivity;
    }

    /**
     * Object containing data on the purchase history of the customer with you
     */
    public void setPaymentActivity(CustomerPaymentActivity value) {
        this.paymentActivity = value;
    }

    /**
     * Object containing data on the purchase history of the customer with you
     */
    public CustomerAccount withPaymentActivity(CustomerPaymentActivity value) {
        this.paymentActivity = value;
        return this;
    }
}
