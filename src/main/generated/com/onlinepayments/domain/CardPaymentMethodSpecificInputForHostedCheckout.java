/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing card payment specific data for hosted checkout
 */
public class CardPaymentMethodSpecificInputForHostedCheckout {

	private Boolean groupCards = null;

	/**
	 * * true - Hosted Checkout will allow to show cards grouped as one payment method
	 * * false - Default - Hosted Checkout will show cards as separate payment methods
	 */
	public Boolean getGroupCards() {
		return groupCards;
	}

	/**
	 * * true - Hosted Checkout will allow to show cards grouped as one payment method
	 * * false - Default - Hosted Checkout will show cards as separate payment methods
	 */
	public void setGroupCards(Boolean value) {
		this.groupCards = value;
	}

	/**
	 * * true - Hosted Checkout will allow to show cards grouped as one payment method
	 * * false - Default - Hosted Checkout will show cards as separate payment methods
	 */
	public CardPaymentMethodSpecificInputForHostedCheckout withGroupCards(Boolean value) {
		this.groupCards = value;
		return this;
	}
}
