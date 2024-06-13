/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Contains the third party data for payment product 840 (PayPal)
 */
public class PaymentProduct840 {

	private String orderId = null;

	/**
	 * Contains an identifier supplied by PayPal which must be provided to the PayPal JavaScript SDK.
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * Contains an identifier supplied by PayPal which must be provided to the PayPal JavaScript SDK.
	 */
	public void setOrderId(String value) {
		this.orderId = value;
	}

	/**
	 * Contains an identifier supplied by PayPal which must be provided to the PayPal JavaScript SDK.
	 */
	public PaymentProduct840 withOrderId(String value) {
		this.orderId = value;
		return this;
	}
}
