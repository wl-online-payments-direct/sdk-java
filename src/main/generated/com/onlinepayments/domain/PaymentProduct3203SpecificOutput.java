/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * PostFinancePay (payment product 3203) specific details
 */
public class PaymentProduct3203SpecificOutput {

	private AddressPersonal billingAddress = null;

	private AddressPersonal shippingAddress = null;

	/**
	 * Object containing address information
	 */
	public AddressPersonal getBillingAddress() {
		return billingAddress;
	}

	/**
	 * Object containing address information
	 */
	public void setBillingAddress(AddressPersonal value) {
		this.billingAddress = value;
	}

	/**
	 * Object containing address information
	 */
	public PaymentProduct3203SpecificOutput withBillingAddress(AddressPersonal value) {
		this.billingAddress = value;
		return this;
	}

	/**
	 * Object containing address information
	 */
	public AddressPersonal getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * Object containing address information
	 */
	public void setShippingAddress(AddressPersonal value) {
		this.shippingAddress = value;
	}

	/**
	 * Object containing address information
	 */
	public PaymentProduct3203SpecificOutput withShippingAddress(AddressPersonal value) {
		this.shippingAddress = value;
		return this;
	}
}
