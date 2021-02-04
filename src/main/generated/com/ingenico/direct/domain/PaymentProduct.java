/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

import java.util.List;

/**
 * Payment product
 */
public class PaymentProduct {

	private List<AccountOnFile> accountsOnFile = null;

	private Boolean allowsRecurring = null;

	private Boolean allowsTokenization = null;

	private PaymentProductDisplayHints displayHints = null;

	private List<PaymentProductField> fields = null;

	private Integer id = null;

	private String paymentMethod = null;

	private String paymentProductGroup = null;

	private Boolean usesRedirectionTo3rdParty = null;

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
	 * Indicates if the product supports recurring payments
	 * * true - This payment product supports recurring payments
	 * * false - This payment product does not support recurring transactions and can only be used for one-off payments
	 */
	public Boolean getAllowsRecurring() {
		return allowsRecurring;
	}

	/**
	 * Indicates if the product supports recurring payments
	 * * true - This payment product supports recurring payments
	 * * false - This payment product does not support recurring transactions and can only be used for one-off payments
	 */
	public void setAllowsRecurring(Boolean value) {
		this.allowsRecurring = value;
	}

	/**
	 * Indicates if the payment details can be tokenized for future re-use
	 * * true - Payment details from payments done with this payment product can be tokenized for future re-use
	 * * false - Payment details from payments done with this payment product can not be tokenized
	 */
	public Boolean getAllowsTokenization() {
		return allowsTokenization;
	}

	/**
	 * Indicates if the payment details can be tokenized for future re-use
	 * * true - Payment details from payments done with this payment product can be tokenized for future re-use
	 * * false - Payment details from payments done with this payment product can not be tokenized
	 */
	public void setAllowsTokenization(Boolean value) {
		this.allowsTokenization = value;
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
	 * The payment product group that has this payment product, if there is any. Not populated otherwise. Currently only one payment product group is supported:
	 * * cards
	 */
	public String getPaymentProductGroup() {
		return paymentProductGroup;
	}

	/**
	 * The payment product group that has this payment product, if there is any. Not populated otherwise. Currently only one payment product group is supported:
	 * * cards
	 */
	public void setPaymentProductGroup(String value) {
		this.paymentProductGroup = value;
	}

	/**
	 * Indicates whether the payment product requires redirection to a third party to complete the payment. You can use this to filter out products that require a redirect if you don't want to support that.
	 * * true - Redirection is required
	 * * false - No redirection is required
	 */
	public Boolean getUsesRedirectionTo3rdParty() {
		return usesRedirectionTo3rdParty;
	}

	/**
	 * Indicates whether the payment product requires redirection to a third party to complete the payment. You can use this to filter out products that require a redirect if you don't want to support that.
	 * * true - Redirection is required
	 * * false - No redirection is required
	 */
	public void setUsesRedirectionTo3rdParty(Boolean value) {
		this.usesRedirectionTo3rdParty = value;
	}
}
