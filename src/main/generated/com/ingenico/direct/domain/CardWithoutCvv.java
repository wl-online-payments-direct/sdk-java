/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

public class CardWithoutCvv {

	private String cardNumber = null;

	private String cardholderName = null;

	private String expiryDate = null;

	/**
	 * The complete credit/debit card number (also know as the PAN)
	 * The card number is always obfuscated in any of our responses
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * The complete credit/debit card number (also know as the PAN)
	 * The card number is always obfuscated in any of our responses
	 */
	public void setCardNumber(String value) {
		this.cardNumber = value;
	}

	/**
	 * The card holder's name on the card.
	 */
	public String getCardholderName() {
		return cardholderName;
	}

	/**
	 * The card holder's name on the card.
	 */
	public void setCardholderName(String value) {
		this.cardholderName = value;
	}

	/**
	 * Expiry date of the card
	 * Format: MMYY
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Expiry date of the card
	 * Format: MMYY
	 */
	public void setExpiryDate(String value) {
		this.expiryDate = value;
	}
}
