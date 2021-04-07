/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

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
}
