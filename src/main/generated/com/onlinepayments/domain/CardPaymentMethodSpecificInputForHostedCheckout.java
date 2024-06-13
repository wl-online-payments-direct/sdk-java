/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

/**
 * Object containing card payment specific data for hosted checkout
 */
public class CardPaymentMethodSpecificInputForHostedCheckout {

	private Boolean clickToPay = null;

	private Boolean groupCards = null;

	private List<Integer> paymentProductPreferredOrder = null;

	/**
	 * * true - Hosted Checkout will show Click to Pay, with cards grouped as one payment method
	 * * false - Default - Hosted Checkout will show cards as separate payment methods without Click to Pay
	 */
	public Boolean getClickToPay() {
		return clickToPay;
	}

	/**
	 * * true - Hosted Checkout will show Click to Pay, with cards grouped as one payment method
	 * * false - Default - Hosted Checkout will show cards as separate payment methods without Click to Pay
	 */
	public void setClickToPay(Boolean value) {
		this.clickToPay = value;
	}

	/**
	 * * true - Hosted Checkout will show Click to Pay, with cards grouped as one payment method
	 * * false - Default - Hosted Checkout will show cards as separate payment methods without Click to Pay
	 */
	public CardPaymentMethodSpecificInputForHostedCheckout withClickToPay(Boolean value) {
		this.clickToPay = value;
		return this;
	}

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

	/**
	 * This array contains the payment product identifiers representing the brands. For co-badged cards, this displays their available brands in the order defined by this array, when groupCards is activated.
	 */
	public List<Integer> getPaymentProductPreferredOrder() {
		return paymentProductPreferredOrder;
	}

	/**
	 * This array contains the payment product identifiers representing the brands. For co-badged cards, this displays their available brands in the order defined by this array, when groupCards is activated.
	 */
	public void setPaymentProductPreferredOrder(List<Integer> value) {
		this.paymentProductPreferredOrder = value;
	}

	/**
	 * This array contains the payment product identifiers representing the brands. For co-badged cards, this displays their available brands in the order defined by this array, when groupCards is activated.
	 */
	public CardPaymentMethodSpecificInputForHostedCheckout withPaymentProductPreferredOrder(List<Integer> value) {
		this.paymentProductPreferredOrder = value;
		return this;
	}
}
