/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class PaymentProduct {

    private List<AccountOnFile> accountsOnFile;

    private Boolean allowsAuthentication;

    private Boolean allowsRecurring;

    private Boolean allowsTokenization;

    private PaymentProductDisplayHints displayHints;

    private List<PaymentProductDisplayHints> displayHintsList;

    private List<PaymentProductField> fields;

    private Integer id;

    private String paymentMethod;

    private PaymentProduct302SpecificData paymentProduct302SpecificData;

    private PaymentProduct320SpecificData paymentProduct320SpecificData;

    private String paymentProductGroup;

    private Boolean usesRedirectionTo3rdParty;

    /**
     * List of tokens for that payment product
     */
    public List<AccountOnFile> getAccountsOnFile() {
        return accountsOnFile;
    }

    /**
     * List of tokens for that payment product
     */
    public void setAccountsOnFile(List<AccountOnFile> value) {
        this.accountsOnFile = value;
    }

    /**
     * List of tokens for that payment product
     */
    public PaymentProduct withAccountsOnFile(List<AccountOnFile> value) {
        this.accountsOnFile = value;
        return this;
    }

    /**
     * True when 3DS authentication is supported or required for the product
     */
    public Boolean getAllowsAuthentication() {
        return allowsAuthentication;
    }

    /**
     * True when 3DS authentication is supported or required for the product
     */
    public void setAllowsAuthentication(Boolean value) {
        this.allowsAuthentication = value;
    }

    /**
     * True when 3DS authentication is supported or required for the product
     */
    public PaymentProduct withAllowsAuthentication(Boolean value) {
        this.allowsAuthentication = value;
        return this;
    }

    /**
     * Indicates if the product supports recurring payments
     * <ul>
     *   <li>true - This payment product supports recurring payments</li>
     *   <li>false - This payment product does not support recurring transactions and can only be used for one-off payments</li>
     * </ul>
     */
    public Boolean getAllowsRecurring() {
        return allowsRecurring;
    }

    /**
     * Indicates if the product supports recurring payments
     * <ul>
     *   <li>true - This payment product supports recurring payments</li>
     *   <li>false - This payment product does not support recurring transactions and can only be used for one-off payments</li>
     * </ul>
     */
    public void setAllowsRecurring(Boolean value) {
        this.allowsRecurring = value;
    }

    /**
     * Indicates if the product supports recurring payments
     * <ul>
     *   <li>true - This payment product supports recurring payments</li>
     *   <li>false - This payment product does not support recurring transactions and can only be used for one-off payments</li>
     * </ul>
     */
    public PaymentProduct withAllowsRecurring(Boolean value) {
        this.allowsRecurring = value;
        return this;
    }

    /**
     * Indicates if the payment details can be tokenized for future re-use
     * <ul>
     *   <li>true - Payment details from payments done with this payment product can be tokenized for future re-use</li>
     *   <li>false - Payment details from payments done with this payment product can not be tokenized</li>
     * </ul>
     */
    public Boolean getAllowsTokenization() {
        return allowsTokenization;
    }

    /**
     * Indicates if the payment details can be tokenized for future re-use
     * <ul>
     *   <li>true - Payment details from payments done with this payment product can be tokenized for future re-use</li>
     *   <li>false - Payment details from payments done with this payment product can not be tokenized</li>
     * </ul>
     */
    public void setAllowsTokenization(Boolean value) {
        this.allowsTokenization = value;
    }

    /**
     * Indicates if the payment details can be tokenized for future re-use
     * <ul>
     *   <li>true - Payment details from payments done with this payment product can be tokenized for future re-use</li>
     *   <li>false - Payment details from payments done with this payment product can not be tokenized</li>
     * </ul>
     */
    public PaymentProduct withAllowsTokenization(Boolean value) {
        this.allowsTokenization = value;
        return this;
    }

    /**
     * Object containing display hints like the order of the product when shown in a list, the name of the product and the logo
     */
    public PaymentProductDisplayHints getDisplayHints() {
        return displayHints;
    }

    /**
     * Object containing display hints like the order of the product when shown in a list, the name of the product and the logo
     */
    public void setDisplayHints(PaymentProductDisplayHints value) {
        this.displayHints = value;
    }

    /**
     * Object containing display hints like the order of the product when shown in a list, the name of the product and the logo
     */
    public PaymentProduct withDisplayHints(PaymentProductDisplayHints value) {
        this.displayHints = value;
        return this;
    }

    public List<PaymentProductDisplayHints> getDisplayHintsList() {
        return displayHintsList;
    }

    public void setDisplayHintsList(List<PaymentProductDisplayHints> value) {
        this.displayHintsList = value;
    }

    public PaymentProduct withDisplayHintsList(List<PaymentProductDisplayHints> value) {
        this.displayHintsList = value;
        return this;
    }

    /**
     * Object containing all the fields and their details that are associated with this payment product. If you are not interested in the data on the fields you should have us filter them our (using filter=fields in the query-string)
     */
    public List<PaymentProductField> getFields() {
        return fields;
    }

    /**
     * Object containing all the fields and their details that are associated with this payment product. If you are not interested in the data on the fields you should have us filter them our (using filter=fields in the query-string)
     */
    public void setFields(List<PaymentProductField> value) {
        this.fields = value;
    }

    /**
     * Object containing all the fields and their details that are associated with this payment product. If you are not interested in the data on the fields you should have us filter them our (using filter=fields in the query-string)
     */
    public PaymentProduct withFields(List<PaymentProductField> value) {
        this.fields = value;
        return this;
    }

    /**
     * The ID of the payment product in our system
     */
    public Integer getId() {
        return id;
    }

    /**
     * The ID of the payment product in our system
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * The ID of the payment product in our system
     */
    public PaymentProduct withId(Integer value) {
        this.id = value;
        return this;
    }

    /**
     * Payment method identifier used by the our payment engine.
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Payment method identifier used by the our payment engine.
     */
    public void setPaymentMethod(String value) {
        this.paymentMethod = value;
    }

    /**
     * Payment method identifier used by the our payment engine.
     */
    public PaymentProduct withPaymentMethod(String value) {
        this.paymentMethod = value;
        return this;
    }

    public PaymentProduct302SpecificData getPaymentProduct302SpecificData() {
        return paymentProduct302SpecificData;
    }

    public void setPaymentProduct302SpecificData(PaymentProduct302SpecificData value) {
        this.paymentProduct302SpecificData = value;
    }

    public PaymentProduct withPaymentProduct302SpecificData(PaymentProduct302SpecificData value) {
        this.paymentProduct302SpecificData = value;
        return this;
    }

    public PaymentProduct320SpecificData getPaymentProduct320SpecificData() {
        return paymentProduct320SpecificData;
    }

    public void setPaymentProduct320SpecificData(PaymentProduct320SpecificData value) {
        this.paymentProduct320SpecificData = value;
    }

    public PaymentProduct withPaymentProduct320SpecificData(PaymentProduct320SpecificData value) {
        this.paymentProduct320SpecificData = value;
        return this;
    }

    /**
     * The payment product group that has this payment product, if there is any. Not populated otherwise. Currently only one payment product group is supported:
     * <ul>
     *   <li>cards</li>
     * </ul>
     */
    public String getPaymentProductGroup() {
        return paymentProductGroup;
    }

    /**
     * The payment product group that has this payment product, if there is any. Not populated otherwise. Currently only one payment product group is supported:
     * <ul>
     *   <li>cards</li>
     * </ul>
     */
    public void setPaymentProductGroup(String value) {
        this.paymentProductGroup = value;
    }

    /**
     * The payment product group that has this payment product, if there is any. Not populated otherwise. Currently only one payment product group is supported:
     * <ul>
     *   <li>cards</li>
     * </ul>
     */
    public PaymentProduct withPaymentProductGroup(String value) {
        this.paymentProductGroup = value;
        return this;
    }

    /**
     * Indicates whether the payment product requires redirection to a third party to complete the payment. You can use this to filter out products that require a redirect if you do not want to support that.
     * <ul>
     *   <li>true - Redirection is required</li>
     *   <li>false - No redirection is required</li>
     * </ul>
     */
    public Boolean getUsesRedirectionTo3rdParty() {
        return usesRedirectionTo3rdParty;
    }

    /**
     * Indicates whether the payment product requires redirection to a third party to complete the payment. You can use this to filter out products that require a redirect if you do not want to support that.
     * <ul>
     *   <li>true - Redirection is required</li>
     *   <li>false - No redirection is required</li>
     * </ul>
     */
    public void setUsesRedirectionTo3rdParty(Boolean value) {
        this.usesRedirectionTo3rdParty = value;
    }

    /**
     * Indicates whether the payment product requires redirection to a third party to complete the payment. You can use this to filter out products that require a redirect if you do not want to support that.
     * <ul>
     *   <li>true - Redirection is required</li>
     *   <li>false - No redirection is required</li>
     * </ul>
     */
    public PaymentProduct withUsesRedirectionTo3rdParty(Boolean value) {
        this.usesRedirectionTo3rdParty = value;
        return this;
    }
}
