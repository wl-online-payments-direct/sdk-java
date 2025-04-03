/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProduct5001SpecificOutput {

    private String accountNumber;

    private String authorisationCode;

    private String liability;

    private String mobilePhoneNumber;

    private String operationCode;

    /**
     * The account number used for this transaction
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * The account number used for this transaction
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * The account number used for this transaction
     */
    public PaymentProduct5001SpecificOutput withAccountNumber(String value) {
        this.accountNumber = value;
        return this;
    }

    /**
     * The reference returned by redsys to identify the transaction
     */
    public String getAuthorisationCode() {
        return authorisationCode;
    }

    /**
     * The reference returned by redsys to identify the transaction
     */
    public void setAuthorisationCode(String value) {
        this.authorisationCode = value;
    }

    /**
     * The reference returned by redsys to identify the transaction
     */
    public PaymentProduct5001SpecificOutput withAuthorisationCode(String value) {
        this.authorisationCode = value;
        return this;
    }

    /**
     * Determines the Fraud liability. Possible values are:
     * <ul>
     *   <li>issuer - Fraud liability shifts to the issuer (eq. exemption accepted)</li>
     *   <li>merchant - Fraud liability with the merchant
     * Note: When not filled in, Fraud liability is not applicable for the current transaction.</li>
     * </ul>
     */
    public String getLiability() {
        return liability;
    }

    /**
     * Determines the Fraud liability. Possible values are:
     * <ul>
     *   <li>issuer - Fraud liability shifts to the issuer (eq. exemption accepted)</li>
     *   <li>merchant - Fraud liability with the merchant
     * Note: When not filled in, Fraud liability is not applicable for the current transaction.</li>
     * </ul>
     */
    public void setLiability(String value) {
        this.liability = value;
    }

    /**
     * Determines the Fraud liability. Possible values are:
     * <ul>
     *   <li>issuer - Fraud liability shifts to the issuer (eq. exemption accepted)</li>
     *   <li>merchant - Fraud liability with the merchant
     * Note: When not filled in, Fraud liability is not applicable for the current transaction.</li>
     * </ul>
     */
    public PaymentProduct5001SpecificOutput withLiability(String value) {
        this.liability = value;
        return this;
    }

    /**
     * The mobile phone number used for this transaction
     */
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    /**
     * The mobile phone number used for this transaction
     */
    public void setMobilePhoneNumber(String value) {
        this.mobilePhoneNumber = value;
    }

    /**
     * The mobile phone number used for this transaction
     */
    public PaymentProduct5001SpecificOutput withMobilePhoneNumber(String value) {
        this.mobilePhoneNumber = value;
        return this;
    }

    /**
     * The reference returned by redsys to identify the operation
     */
    public String getOperationCode() {
        return operationCode;
    }

    /**
     * The reference returned by redsys to identify the operation
     */
    public void setOperationCode(String value) {
        this.operationCode = value;
    }

    /**
     * The reference returned by redsys to identify the operation
     */
    public PaymentProduct5001SpecificOutput withOperationCode(String value) {
        this.operationCode = value;
        return this;
    }
}
