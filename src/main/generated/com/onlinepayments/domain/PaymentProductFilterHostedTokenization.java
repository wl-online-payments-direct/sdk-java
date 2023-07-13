/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

/**
 * Contains the payment product ids that should be excluded from the payment products available for the payment. Note that excluding a payment product will ensure exclusion, even if the payment product is also present in the restrictTo filter.
 */
public class PaymentProductFilterHostedTokenization {

	private List<Integer> products = null;

	/**
	 * List containing all payment product ids that should either be restricted to in or excluded from the payment context.
	 */
	public List<Integer> getProducts() {
		return products;
	}

	/**
	 * List containing all payment product ids that should either be restricted to in or excluded from the payment context.
	 */
	public void setProducts(List<Integer> value) {
		this.products = value;
	}

	/**
	 * List containing all payment product ids that should either be restricted to in or excluded from the payment context.
	 */
	public PaymentProductFilterHostedTokenization withProducts(List<Integer> value) {
		this.products = value;
		return this;
	}
}
