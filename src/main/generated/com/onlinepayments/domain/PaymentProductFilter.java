/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

/**
 * Contains the payment product ids and payment product groups that should be excluded from the payment products available for the payment. Note that excluding a payment product will ensure exclusion, even if the payment product is also present in the restrictTo filter, and that excluding a payment product group will exclude all payment products that are a part of that group, even if one or more of them are present in the restrictTo filters.
 */
public class PaymentProductFilter {

	private List<String> groups = null;

	private List<Integer> products = null;

	/**
	 * List containing all payment product groups that should either be restricted to in or excluded from the payment context. Currently, there is only one group, called 'cards'.
	 */
	public List<String> getGroups() {
		return groups;
	}

	/**
	 * List containing all payment product groups that should either be restricted to in or excluded from the payment context. Currently, there is only one group, called 'cards'.
	 */
	public void setGroups(List<String> value) {
		this.groups = value;
	}

	/**
	 * List containing all payment product groups that should either be restricted to in or excluded from the payment context. Currently, there is only one group, called 'cards'.
	 */
	public PaymentProductFilter withGroups(List<String> value) {
		this.groups = value;
		return this;
	}

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
	public PaymentProductFilter withProducts(List<Integer> value) {
		this.products = value;
		return this;
	}
}
