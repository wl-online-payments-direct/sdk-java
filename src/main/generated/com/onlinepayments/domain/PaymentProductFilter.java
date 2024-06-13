/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

/**
 * The payment product ids to be be excluded or restricted to from the payment products available for the payment. Note that you can add exclusions on top of the 'restrictTo' filter.
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
