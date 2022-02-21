/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing specific input required for PayPal payments (Payment product ID 840)
 */
public class RedirectPaymentProduct840SpecificInput {

	private Boolean addressSelectionAtPayPal = null;

	/**
	 * Indicates whether to use PayPal Express Checkout Shortcut.
	 *  * true = When shortcut is enabled, the consumer can select a shipping address during PayPal checkout.
	 *  * false = When shortcut is disabled, the consumer cannot change the shipping address.
	 * Default value is false.
	 * Please note that this field is ignored when order.additionalInput.typeInformation.purchaseType is set to "digital"
	 */
	public Boolean getAddressSelectionAtPayPal() {
		return addressSelectionAtPayPal;
	}

	/**
	 * Indicates whether to use PayPal Express Checkout Shortcut.
	 *  * true = When shortcut is enabled, the consumer can select a shipping address during PayPal checkout.
	 *  * false = When shortcut is disabled, the consumer cannot change the shipping address.
	 * Default value is false.
	 * Please note that this field is ignored when order.additionalInput.typeInformation.purchaseType is set to "digital"
	 */
	public void setAddressSelectionAtPayPal(Boolean value) {
		this.addressSelectionAtPayPal = value;
	}

	/**
	 * Indicates whether to use PayPal Express Checkout Shortcut.
	 *  * true = When shortcut is enabled, the consumer can select a shipping address during PayPal checkout.
	 *  * false = When shortcut is disabled, the consumer cannot change the shipping address.
	 * Default value is false.
	 * Please note that this field is ignored when order.additionalInput.typeInformation.purchaseType is set to "digital"
	 */
	public RedirectPaymentProduct840SpecificInput withAddressSelectionAtPayPal(Boolean value) {
		this.addressSelectionAtPayPal = value;
		return this;
	}
}
