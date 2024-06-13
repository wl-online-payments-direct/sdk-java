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
	 * The payment product ids to be be excluded or restricted to from the payment products available for the payment. Note that you can add exclusions on top of the 'restrictTo' filter.
	 */
	public PaymentProductFilter getExclude() {
		return exclude;
	}

	/**
	 * The payment product ids to be be excluded or restricted to from the payment products available for the payment. Note that you can add exclusions on top of the 'restrictTo' filter.
	 */
	public void setExclude(PaymentProductFilter value) {
		this.exclude = value;
	}

	/**
	 * The payment product ids to be be excluded or restricted to from the payment products available for the payment. Note that you can add exclusions on top of the 'restrictTo' filter.
	 */
	public PaymentProductFiltersHostedCheckout withExclude(PaymentProductFilter value) {
		this.exclude = value;
		return this;
	}

	/**
	 * The payment product ids to be be excluded or restricted to from the payment products available for the payment. Note that you can add exclusions on top of the 'restrictTo' filter.
	 */
	public PaymentProductFilter getRestrictTo() {
		return restrictTo;
	}

	/**
	 * The payment product ids to be be excluded or restricted to from the payment products available for the payment. Note that you can add exclusions on top of the 'restrictTo' filter.
	 */
	public void setRestrictTo(PaymentProductFilter value) {
		this.restrictTo = value;
	}

	/**
	 * The payment product ids to be be excluded or restricted to from the payment products available for the payment. Note that you can add exclusions on top of the 'restrictTo' filter.
	 */
	public PaymentProductFiltersHostedCheckout withRestrictTo(PaymentProductFilter value) {
		this.restrictTo = value;
		return this;
	}
}
