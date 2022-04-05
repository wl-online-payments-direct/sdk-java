/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing card details
 */
public class CardEssentials {

	private String bin = null;

	private String cardNumber = null;

	private String countryCode = null;

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
	 * The first digits of the credit card number from left to right with a minimum of 6 digits.
	 */
	public CardEssentials withBin(String value) {
		this.bin = value;
		return this;
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
	 * The complete credit/debit card number
	 */
	public CardEssentials withCardNumber(String value) {
		this.cardNumber = value;
		return this;
	}

	/**
	 * ISO 3166-1 alpha-2 country code
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * ISO 3166-1 alpha-2 country code
	 */
	public void setCountryCode(String value) {
		this.countryCode = value;
	}

	/**
	 * ISO 3166-1 alpha-2 country code
	 */
	public CardEssentials withCountryCode(String value) {
		this.countryCode = value;
		return this;
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

	/**
	 * Expiry date of the card 
	 *  Format: MMYY
	 */
	public CardEssentials withExpiryDate(String value) {
		this.expiryDate = value;
		return this;
	}
}
