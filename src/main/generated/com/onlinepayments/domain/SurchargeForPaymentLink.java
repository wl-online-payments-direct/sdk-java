/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing details how surcharge will be applied to a payment link.
 */
public class SurchargeForPaymentLink {

	private String surchargeMode = null;

	/**
	 * The surcharge mode which defines how a merchant will apply surcharging.
	 * * pass-through - Merchant to define and apply surcharge amount for a transaction for processing. This mode is not supported on Create Hosted Checkout Session.
	 * * on-behalf-of - Merchant to instruct the payment platform to calculate and apply a surcharge amount to a transaction, based on the merchant’s surcharge configuration, net amount, and payment product type.
	 */
	public String getSurchargeMode() {
		return surchargeMode;
	}

	/**
	 * The surcharge mode which defines how a merchant will apply surcharging.
	 * * pass-through - Merchant to define and apply surcharge amount for a transaction for processing. This mode is not supported on Create Hosted Checkout Session.
	 * * on-behalf-of - Merchant to instruct the payment platform to calculate and apply a surcharge amount to a transaction, based on the merchant’s surcharge configuration, net amount, and payment product type.
	 */
	public void setSurchargeMode(String value) {
		this.surchargeMode = value;
	}

	/**
	 * The surcharge mode which defines how a merchant will apply surcharging.
	 * * pass-through - Merchant to define and apply surcharge amount for a transaction for processing. This mode is not supported on Create Hosted Checkout Session.
	 * * on-behalf-of - Merchant to instruct the payment platform to calculate and apply a surcharge amount to a transaction, based on the merchant’s surcharge configuration, net amount, and payment product type.
	 */
	public SurchargeForPaymentLink withSurchargeMode(String value) {
		this.surchargeMode = value;
		return this;
	}
}
