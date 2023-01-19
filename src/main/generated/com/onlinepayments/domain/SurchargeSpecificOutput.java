/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing specific surcharging attributes applied to an order.
 */
public class SurchargeSpecificOutput {

	private String mode = null;

	private AmountOfMoney surchargeAmount = null;

	/**
	 * The surcharge mode which defines how a merchant will apply surcharging.
	 * * pass-through - Merchant to define and apply surcharge amount for a transaction for processing. This mode is not supported on Create Hosted Checkout Session.
	 * * on-behalf-of - Merchant to instruct the payment platform to calculate and apply a surcharge amount to a transaction, based on the merchant’s surcharge configuration, net amount, and payment product type.
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * The surcharge mode which defines how a merchant will apply surcharging.
	 * * pass-through - Merchant to define and apply surcharge amount for a transaction for processing. This mode is not supported on Create Hosted Checkout Session.
	 * * on-behalf-of - Merchant to instruct the payment platform to calculate and apply a surcharge amount to a transaction, based on the merchant’s surcharge configuration, net amount, and payment product type.
	 */
	public void setMode(String value) {
		this.mode = value;
	}

	/**
	 * The surcharge mode which defines how a merchant will apply surcharging.
	 * * pass-through - Merchant to define and apply surcharge amount for a transaction for processing. This mode is not supported on Create Hosted Checkout Session.
	 * * on-behalf-of - Merchant to instruct the payment platform to calculate and apply a surcharge amount to a transaction, based on the merchant’s surcharge configuration, net amount, and payment product type.
	 */
	public SurchargeSpecificOutput withMode(String value) {
		this.mode = value;
		return this;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getSurchargeAmount() {
		return surchargeAmount;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setSurchargeAmount(AmountOfMoney value) {
		this.surchargeAmount = value;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public SurchargeSpecificOutput withSurchargeAmount(AmountOfMoney value) {
		this.surchargeAmount = value;
		return this;
	}
}
