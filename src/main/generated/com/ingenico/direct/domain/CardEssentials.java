/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Object containing card details
 */
public class CardEssentials {

	private String bin = null;

	private String cardNumber = null;

	private String expiryDate = null;

	/**
	 * The first digits of the credit card number from left to right with a minimum of 6 digits.
	 */
	public String getBin() {
		return bin;
	}

	/**
	 * The first digits of the credit card number from left to right with a minimum of 6 digits.
	 */
	public void setBin(String value) {
		this.bin = value;
	}

	/**
	 * The complete credit/debit card number
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * The complete credit/debit card number
	 */
	public void setCardNumber(String value) {
		this.cardNumber = value;
	}

	/**
	 * Expiry date of the card 
	 *  Format: MMYY
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Expiry date of the card 
	 *  Format: MMYY
	 */
	public void setExpiryDate(String value) {
		this.expiryDate = value;
	}
}
