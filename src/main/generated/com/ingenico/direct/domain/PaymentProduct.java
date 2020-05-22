/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Payment product
 */
public class PaymentProduct {

	private Boolean allowsRecurring = null;

	private Boolean allowsTokenization = null;

	private PaymentProductDisplayHints displayHints = null;

	private String id = null;

	private Long maxAmount = null;

	private Long minAmount = null;

	private String paymentMethod = null;

	private String paymentProductGroup = null;

	private Boolean usesRedirectionTo3rdParty = null;

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
	 * The ID of the payment product in our system
	 */
	public String getId() {
		return id;
	}

	/**
	 * The ID of the payment product in our system
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Maximum amount in EUR cents (using 2 decimals, so 1 EUR becomes 100 cents) for transactions done with this payment product
	 */
	public Long getMaxAmount() {
		return maxAmount;
	}

	/**
	 * Maximum amount in EUR cents (using 2 decimals, so 1 EUR becomes 100 cents) for transactions done with this payment product
	 */
	public void setMaxAmount(Long value) {
		this.maxAmount = value;
	}

	/**
	 * Minimum amount in EUR cents (using 2 decimals, so 1 EUR becomes 100 cents) for transactions done with this payment product
	 */
	public Long getMinAmount() {
		return minAmount;
	}

	/**
	 * Minimum amount in EUR cents (using 2 decimals, so 1 EUR becomes 100 cents) for transactions done with this payment product
	 */
	public void setMinAmount(Long value) {
		this.minAmount = value;
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
