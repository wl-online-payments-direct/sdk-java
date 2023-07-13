/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Contains the payment product ids that will be used for manipulating the payment products available for the payment to the customer.
 */
public class PaymentProductFiltersHostedTokenization {

	private PaymentProductFilterHostedTokenization exclude = null;

	private PaymentProductFilterHostedTokenization restrictTo = null;

	/**
	 * Contains the payment product ids that should be excluded from the payment products available for the payment. Note that excluding a payment product will ensure exclusion, even if the payment product is also present in the restrictTo filter.
	 */
	public PaymentProductFilterHostedTokenization getExclude() {
		return exclude;
	}

	/**
	 * Contains the payment product ids that should be excluded from the payment products available for the payment. Note that excluding a payment product will ensure exclusion, even if the payment product is also present in the restrictTo filter.
	 */
	public void setExclude(PaymentProductFilterHostedTokenization value) {
		this.exclude = value;
	}

	/**
	 * Contains the payment product ids that should be excluded from the payment products available for the payment. Note that excluding a payment product will ensure exclusion, even if the payment product is also present in the restrictTo filter.
	 */
	public PaymentProductFiltersHostedTokenization withExclude(PaymentProductFilterHostedTokenization value) {
		this.exclude = value;
		return this;
	}

	/**
	 * Contains the payment product ids that should be excluded from the payment products available for the payment. Note that excluding a payment product will ensure exclusion, even if the payment product is also present in the restrictTo filter.
	 */
	public PaymentProductFilterHostedTokenization getRestrictTo() {
		return restrictTo;
	}

	/**
	 * Contains the payment product ids that should be excluded from the payment products available for the payment. Note that excluding a payment product will ensure exclusion, even if the payment product is also present in the restrictTo filter.
	 */
	public void setRestrictTo(PaymentProductFilterHostedTokenization value) {
		this.restrictTo = value;
	}

	/**
	 * Contains the payment product ids that should be excluded from the payment products available for the payment. Note that excluding a payment product will ensure exclusion, even if the payment product is also present in the restrictTo filter.
	 */
	public PaymentProductFiltersHostedTokenization withRestrictTo(PaymentProductFilterHostedTokenization value) {
		this.restrictTo = value;
		return this;
	}
}
