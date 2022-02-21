/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Contains the payment product ids and payment product groups that will be used for manipulating the payment products available for the payment to the customer.
 */
public class PaymentProductFiltersHostedCheckout {

	private PaymentProductFilter exclude = null;

	private PaymentProductFilter restrictTo = null;

	/**
	 * Contains the payment product ids and payment product groups that should be excluded from the payment products available for the payment. Note that excluding a payment product will ensure exclusion, even if the payment product is also present in the restrictTo filter, and that excluding a payment product group will exclude all payment products that are a part of that group, even if one or more of them are present in the restrictTo filters.
	 */
	public PaymentProductFilter getExclude() {
		return exclude;
	}

	/**
	 * Contains the payment product ids and payment product groups that should be excluded from the payment products available for the payment. Note that excluding a payment product will ensure exclusion, even if the payment product is also present in the restrictTo filter, and that excluding a payment product group will exclude all payment products that are a part of that group, even if one or more of them are present in the restrictTo filters.
	 */
	public void setExclude(PaymentProductFilter value) {
		this.exclude = value;
	}

	/**
	 * Contains the payment product ids and payment product groups that should be excluded from the payment products available for the payment. Note that excluding a payment product will ensure exclusion, even if the payment product is also present in the restrictTo filter, and that excluding a payment product group will exclude all payment products that are a part of that group, even if one or more of them are present in the restrictTo filters.
	 */
	public PaymentProductFiltersHostedCheckout withExclude(PaymentProductFilter value) {
		this.exclude = value;
		return this;
	}

	/**
	 * Contains the payment product ids and payment product groups that should be excluded from the payment products available for the payment. Note that excluding a payment product will ensure exclusion, even if the payment product is also present in the restrictTo filter, and that excluding a payment product group will exclude all payment products that are a part of that group, even if one or more of them are present in the restrictTo filters.
	 */
	public PaymentProductFilter getRestrictTo() {
		return restrictTo;
	}

	/**
	 * Contains the payment product ids and payment product groups that should be excluded from the payment products available for the payment. Note that excluding a payment product will ensure exclusion, even if the payment product is also present in the restrictTo filter, and that excluding a payment product group will exclude all payment products that are a part of that group, even if one or more of them are present in the restrictTo filters.
	 */
	public void setRestrictTo(PaymentProductFilter value) {
		this.restrictTo = value;
	}

	/**
	 * Contains the payment product ids and payment product groups that should be excluded from the payment products available for the payment. Note that excluding a payment product will ensure exclusion, even if the payment product is also present in the restrictTo filter, and that excluding a payment product group will exclude all payment products that are a part of that group, even if one or more of them are present in the restrictTo filters.
	 */
	public PaymentProductFiltersHostedCheckout withRestrictTo(PaymentProductFilter value) {
		this.restrictTo = value;
		return this;
	}
}
