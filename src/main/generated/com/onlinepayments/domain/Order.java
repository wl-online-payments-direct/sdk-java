/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Order object containing order related data 
 *  Please note that this object is required to be able to submit the amount.
 */
public class Order {

	private AdditionalOrderInput additionalInput = null;

	private AmountOfMoney amountOfMoney = null;

	private Customer customer = null;

	private OrderReferences references = null;

	private Shipping shipping = null;

	private ShoppingCart shoppingCart = null;

	/**
	 * Object containing additional input on the order
	 */
	public AdditionalOrderInput getAdditionalInput() {
		return additionalInput;
	}

	/**
	 * Object containing additional input on the order
	 */
	public void setAdditionalInput(AdditionalOrderInput value) {
		this.additionalInput = value;
	}

	/**
	 * Object containing additional input on the order
	 */
	public Order withAdditionalInput(AdditionalOrderInput value) {
		this.additionalInput = value;
		return this;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getAmountOfMoney() {
		return amountOfMoney;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public Order withAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
		return this;
	}

	/**
	 * Object containing the details of the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Object containing the details of the customer
	 */
	public void setCustomer(Customer value) {
		this.customer = value;
	}

	/**
	 * Object containing the details of the customer
	 */
	public Order withCustomer(Customer value) {
		this.customer = value;
		return this;
	}

	/**
	 * Object that holds all reference properties that are linked to this transaction
	 */
	public OrderReferences getReferences() {
		return references;
	}

	/**
	 * Object that holds all reference properties that are linked to this transaction
	 */
	public void setReferences(OrderReferences value) {
		this.references = value;
	}

	/**
	 * Object that holds all reference properties that are linked to this transaction
	 */
	public Order withReferences(OrderReferences value) {
		this.references = value;
		return this;
	}

	/**
	 * Object containing information regarding shipping / delivery
	 */
	public Shipping getShipping() {
		return shipping;
	}

	/**
	 * Object containing information regarding shipping / delivery
	 */
	public void setShipping(Shipping value) {
		this.shipping = value;
	}

	/**
	 * Object containing information regarding shipping / delivery
	 */
	public Order withShipping(Shipping value) {
		this.shipping = value;
		return this;
	}

	/**
	 * Shopping cart data, including items and specific amounts.
	 */
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	/**
	 * Shopping cart data, including items and specific amounts.
	 */
	public void setShoppingCart(ShoppingCart value) {
		this.shoppingCart = value;
	}

	/**
	 * Shopping cart data, including items and specific amounts.
	 */
	public Order withShoppingCart(ShoppingCart value) {
		this.shoppingCart = value;
		return this;
	}
}
