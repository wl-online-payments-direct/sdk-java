/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RedirectPaymentMethodSpecificOutput {

    private String authorisationCode;

    private CustomerBankAccount customerBankAccount;

    private FraudResults fraudResults;

    private PaymentProduct3204SpecificOutput paymentMethod3204SpecificOutput;

    private String paymentOption;

    private PaymentProduct3203SpecificOutput paymentProduct3203SpecificOutput;

    private PaymentProduct5001SpecificOutput paymentProduct5001SpecificOutput;

    private PaymentProduct5402SpecificOutput paymentProduct5402SpecificOutput;

    private PaymentProduct5500SpecificOutput paymentProduct5500SpecificOutput;

    private PaymentProduct840SpecificOutput paymentProduct840SpecificOutput;

    private Integer paymentProductId;

    private String token;

    /**
     * Card Authorization code as returned by the acquirer
     */
    public String getAuthorisationCode() {
        return authorisationCode;
    }

    /**
     * Card Authorization code as returned by the acquirer
     */
    public void setAuthorisationCode(String value) {
        this.authorisationCode = value;
    }

    /**
     * Card Authorization code as returned by the acquirer
     */
    public RedirectPaymentMethodSpecificOutput withAuthorisationCode(String value) {
        this.authorisationCode = value;
        return this;
    }

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
    public RedirectPaymentMethodSpecificOutput withCustomerBankAccount(CustomerBankAccount value) {
        this.customerBankAccount = value;
        return this;
    }

    /**
     * Object containing the results of the fraud screening
     */
    public FraudResults getFraudResults() {
        return fraudResults;
    }

    /**
     * Object containing the results of the fraud screening
     */
    public void setFraudResults(FraudResults value) {
        this.fraudResults = value;
    }

    /**
     * Object containing the results of the fraud screening
     */
    public RedirectPaymentMethodSpecificOutput withFraudResults(FraudResults value) {
        this.fraudResults = value;
        return this;
    }

    /**
     * BLIK (payment product 3204) specific details
     */
    public PaymentProduct3204SpecificOutput getPaymentMethod3204SpecificOutput() {
        return paymentMethod3204SpecificOutput;
    }

    /**
     * BLIK (payment product 3204) specific details
     */
    public void setPaymentMethod3204SpecificOutput(PaymentProduct3204SpecificOutput value) {
        this.paymentMethod3204SpecificOutput = value;
    }

    /**
     * BLIK (payment product 3204) specific details
     */
    public RedirectPaymentMethodSpecificOutput withPaymentMethod3204SpecificOutput(PaymentProduct3204SpecificOutput value) {
        this.paymentMethod3204SpecificOutput = value;
        return this;
    }

    /**
     * The specific payment option for the payment. To be used as a complement of the more generic paymentProductId (oney, banquecasino, cofidis), which allows to define a variation of the selected paymentProductId (ex: facilypay3x, banquecasino4x, cofidis3x-sansfrais, ...). List of modalities included in the payment product page.
     */
    public String getPaymentOption() {
        return paymentOption;
    }

    /**
     * The specific payment option for the payment. To be used as a complement of the more generic paymentProductId (oney, banquecasino, cofidis), which allows to define a variation of the selected paymentProductId (ex: facilypay3x, banquecasino4x, cofidis3x-sansfrais, ...). List of modalities included in the payment product page.
     */
    public void setPaymentOption(String value) {
        this.paymentOption = value;
    }

    /**
     * The specific payment option for the payment. To be used as a complement of the more generic paymentProductId (oney, banquecasino, cofidis), which allows to define a variation of the selected paymentProductId (ex: facilypay3x, banquecasino4x, cofidis3x-sansfrais, ...). List of modalities included in the payment product page.
     */
    public RedirectPaymentMethodSpecificOutput withPaymentOption(String value) {
        this.paymentOption = value;
        return this;
    }

    /**
     * PostFinancePay (payment product 3203) specific details
     */
    public PaymentProduct3203SpecificOutput getPaymentProduct3203SpecificOutput() {
        return paymentProduct3203SpecificOutput;
    }

    /**
     * PostFinancePay (payment product 3203) specific details
     */
    public void setPaymentProduct3203SpecificOutput(PaymentProduct3203SpecificOutput value) {
        this.paymentProduct3203SpecificOutput = value;
    }

    /**
     * PostFinancePay (payment product 3203) specific details
     */
    public RedirectPaymentMethodSpecificOutput withPaymentProduct3203SpecificOutput(PaymentProduct3203SpecificOutput value) {
        this.paymentProduct3203SpecificOutput = value;
        return this;
    }

    /**
     * Bizum (payment product 5001) specific details
     */
    public PaymentProduct5001SpecificOutput getPaymentProduct5001SpecificOutput() {
        return paymentProduct5001SpecificOutput;
    }

    /**
     * Bizum (payment product 5001) specific details
     */
    public void setPaymentProduct5001SpecificOutput(PaymentProduct5001SpecificOutput value) {
        this.paymentProduct5001SpecificOutput = value;
    }

    /**
     * Bizum (payment product 5001) specific details
     */
    public RedirectPaymentMethodSpecificOutput withPaymentProduct5001SpecificOutput(PaymentProduct5001SpecificOutput value) {
        this.paymentProduct5001SpecificOutput = value;
        return this;
    }

    /**
     * Meal vouchers (payment product 5402) specific details
     */
    public PaymentProduct5402SpecificOutput getPaymentProduct5402SpecificOutput() {
        return paymentProduct5402SpecificOutput;
    }

    /**
     * Meal vouchers (payment product 5402) specific details
     */
    public void setPaymentProduct5402SpecificOutput(PaymentProduct5402SpecificOutput value) {
        this.paymentProduct5402SpecificOutput = value;
    }

    /**
     * Meal vouchers (payment product 5402) specific details
     */
    public RedirectPaymentMethodSpecificOutput withPaymentProduct5402SpecificOutput(PaymentProduct5402SpecificOutput value) {
        this.paymentProduct5402SpecificOutput = value;
        return this;
    }

    /**
     * Multibanco (payment product 5500) specific details
     */
    public PaymentProduct5500SpecificOutput getPaymentProduct5500SpecificOutput() {
        return paymentProduct5500SpecificOutput;
    }

    /**
     * Multibanco (payment product 5500) specific details
     */
    public void setPaymentProduct5500SpecificOutput(PaymentProduct5500SpecificOutput value) {
        this.paymentProduct5500SpecificOutput = value;
    }

    /**
     * Multibanco (payment product 5500) specific details
     */
    public RedirectPaymentMethodSpecificOutput withPaymentProduct5500SpecificOutput(PaymentProduct5500SpecificOutput value) {
        this.paymentProduct5500SpecificOutput = value;
        return this;
    }

    /**
     * PayPal (payment product 840) specific details
     */
    public PaymentProduct840SpecificOutput getPaymentProduct840SpecificOutput() {
        return paymentProduct840SpecificOutput;
    }

    /**
     * PayPal (payment product 840) specific details
     */
    public void setPaymentProduct840SpecificOutput(PaymentProduct840SpecificOutput value) {
        this.paymentProduct840SpecificOutput = value;
    }

    /**
     * PayPal (payment product 840) specific details
     */
    public RedirectPaymentMethodSpecificOutput withPaymentProduct840SpecificOutput(PaymentProduct840SpecificOutput value) {
        this.paymentProduct840SpecificOutput = value;
        return this;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public Integer getPaymentProductId() {
        return paymentProductId;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public void setPaymentProductId(Integer value) {
        this.paymentProductId = value;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public RedirectPaymentMethodSpecificOutput withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }

    /**
     * ID of the token. This property is populated when the payment was done with a token or when the payment was tokenized.
     */
    public String getToken() {
        return token;
    }

    /**
     * ID of the token. This property is populated when the payment was done with a token or when the payment was tokenized.
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * ID of the token. This property is populated when the payment was done with a token or when the payment was tokenized.
     */
    public RedirectPaymentMethodSpecificOutput withToken(String value) {
        this.token = value;
        return this;
    }
}
