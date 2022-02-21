/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing the token details for a card
 */
public class TokenData {

	private Card card = null;

	/**
	 * Object containing card details
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * Object containing card details
	 */
	public void setCard(Card value) {
		this.card = value;
	}

	/**
	 * Object containing card details
	 */
	public TokenData withCard(Card value) {
		this.card = value;
		return this;
	}
}
