/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProduct840CustomerAccount {

    private String accountId;

    private String companyName;

    private String countryCode;

    private String customerAccountStatus;

    private String customerAddressStatus;

    private String firstName;

    private String payerId;

    private String surname;

    /**
     * Username with which the PayPal account holder has registered at PayPal
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Username with which the PayPal account holder has registered at PayPal
     */
    public void setAccountId(String value) {
        this.accountId = value;
    }

    /**
     * Username with which the PayPal account holder has registered at PayPal
     */
    public PaymentProduct840CustomerAccount withAccountId(String value) {
        this.accountId = value;
        return this;
    }

    /**
     * Name of the company in case the PayPal account is owned by a business
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Name of the company in case the PayPal account is owned by a business
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Name of the company in case the PayPal account is owned by a business
     */
    public PaymentProduct840CustomerAccount withCompanyName(String value) {
        this.companyName = value;
        return this;
    }

    /**
     * ISO 3166-1 alpha-2 country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * ISO 3166-1 alpha-2 country code
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * ISO 3166-1 alpha-2 country code
     */
    public PaymentProduct840CustomerAccount withCountryCode(String value) {
        this.countryCode = value;
        return this;
    }

    /**
     * Status of the PayPal account
     * <ul>
     *   <li>verified - PayPal has verified the funding means for this account</li>
     *   <li>unverified - PayPal has not verified the funding means for this account</li>
     * </ul>
     */
    public String getCustomerAccountStatus() {
        return customerAccountStatus;
    }

    /**
     * Status of the PayPal account
     * <ul>
     *   <li>verified - PayPal has verified the funding means for this account</li>
     *   <li>unverified - PayPal has not verified the funding means for this account</li>
     * </ul>
     */
    public void setCustomerAccountStatus(String value) {
        this.customerAccountStatus = value;
    }

    /**
     * Status of the PayPal account
     * <ul>
     *   <li>verified - PayPal has verified the funding means for this account</li>
     *   <li>unverified - PayPal has not verified the funding means for this account</li>
     * </ul>
     */
    public PaymentProduct840CustomerAccount withCustomerAccountStatus(String value) {
        this.customerAccountStatus = value;
        return this;
    }

    /**
     * Status of the customer's shipping address as registered by PayPal
     * <ul>
     *   <li>none - Status is unknown at PayPal</li>
     *   <li>confirmed - The address has been confirmed</li>
     *   <li>unconfirmed - The address has not been confirmed</li>
     * </ul>
     */
    public String getCustomerAddressStatus() {
        return customerAddressStatus;
    }

    /**
     * Status of the customer's shipping address as registered by PayPal
     * <ul>
     *   <li>none - Status is unknown at PayPal</li>
     *   <li>confirmed - The address has been confirmed</li>
     *   <li>unconfirmed - The address has not been confirmed</li>
     * </ul>
     */
    public void setCustomerAddressStatus(String value) {
        this.customerAddressStatus = value;
    }

    /**
     * Status of the customer's shipping address as registered by PayPal
     * <ul>
     *   <li>none - Status is unknown at PayPal</li>
     *   <li>confirmed - The address has been confirmed</li>
     *   <li>unconfirmed - The address has not been confirmed</li>
     * </ul>
     */
    public PaymentProduct840CustomerAccount withCustomerAddressStatus(String value) {
        this.customerAddressStatus = value;
        return this;
    }

    /**
     * First name of the PayPal account holder
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * First name of the PayPal account holder
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * First name of the PayPal account holder
     */
    public PaymentProduct840CustomerAccount withFirstName(String value) {
        this.firstName = value;
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
    public PaymentProduct840CustomerAccount withPayerId(String value) {
        this.payerId = value;
        return this;
    }

    /**
     * Surname of the PayPal account holder
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Surname of the PayPal account holder
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Surname of the PayPal account holder
     */
    public PaymentProduct840CustomerAccount withSurname(String value) {
        this.surname = value;
        return this;
    }
}
