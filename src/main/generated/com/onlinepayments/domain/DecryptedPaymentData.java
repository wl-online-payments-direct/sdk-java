/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * The payment data if you do the decryption of the encrypted payment data yourself.
 */
public class DecryptedPaymentData {

	private String cardholderName = null;

	private String cryptogram = null;

	private String dpan = null;

	private Integer eci = null;

	private String expiryDate = null;

	/**
	 * Card holder's name on the card. 
	 *  * For Apple Pay, maps to the cardholderName property in the encrypted payment data.
	 */
	public String getCardholderName() {
		return cardholderName;
	}

	/**
	 * Card holder's name on the card. 
	 *  * For Apple Pay, maps to the cardholderName property in the encrypted payment data.
	 */
	public void setCardholderName(String value) {
		this.cardholderName = value;
	}

	/**
	 * Card holder's name on the card. 
	 *  * For Apple Pay, maps to the cardholderName property in the encrypted payment data.
	 */
	public DecryptedPaymentData withCardholderName(String value) {
		this.cardholderName = value;
		return this;
	}

	/**
	 * The 3D secure online payment cryptogram.
	 * * For Apple Pay, maps to the paymentData.onlinePaymentCryptogram property in the encrypted payment data.
	 * * For Google Pay, maps to the paymentMethodDetails.3dsCryptogram property in the encrypted payment data.
	 * Not allowed for Google Pay if the paymentMethod is CARD.
	 */
	public String getCryptogram() {
		return cryptogram;
	}

	/**
	 * The 3D secure online payment cryptogram.
	 * * For Apple Pay, maps to the paymentData.onlinePaymentCryptogram property in the encrypted payment data.
	 * * For Google Pay, maps to the paymentMethodDetails.3dsCryptogram property in the encrypted payment data.
	 * Not allowed for Google Pay if the paymentMethod is CARD.
	 */
	public void setCryptogram(String value) {
		this.cryptogram = value;
	}

	/**
	 * The 3D secure online payment cryptogram.
	 * * For Apple Pay, maps to the paymentData.onlinePaymentCryptogram property in the encrypted payment data.
	 * * For Google Pay, maps to the paymentMethodDetails.3dsCryptogram property in the encrypted payment data.
	 * Not allowed for Google Pay if the paymentMethod is CARD.
	 */
	public DecryptedPaymentData withCryptogram(String value) {
		this.cryptogram = value;
		return this;
	}

	/**
	 * The device specific PAN. 
	 *  * For Apple Pay, maps to the applicationPrimaryAccountNumber property in the encrypted payment.
	 */
	public String getDpan() {
		return dpan;
	}

	/**
	 * The device specific PAN. 
	 *  * For Apple Pay, maps to the applicationPrimaryAccountNumber property in the encrypted payment.
	 */
	public void setDpan(String value) {
		this.dpan = value;
	}

	/**
	 * The device specific PAN. 
	 *  * For Apple Pay, maps to the applicationPrimaryAccountNumber property in the encrypted payment.
	 */
	public DecryptedPaymentData withDpan(String value) {
		this.dpan = value;
		return this;
	}

	/**
	 * Electronic Commerce Indicator. 
	 *  * For Apple Pay, maps to the paymentData.eciIndicator property in the encrypted payment data.
	 */
	public Integer getEci() {
		return eci;
	}

	/**
	 * Electronic Commerce Indicator. 
	 *  * For Apple Pay, maps to the paymentData.eciIndicator property in the encrypted payment data.
	 */
	public void setEci(Integer value) {
		this.eci = value;
	}

	/**
	 * Electronic Commerce Indicator. 
	 *  * For Apple Pay, maps to the paymentData.eciIndicator property in the encrypted payment data.
	 */
	public DecryptedPaymentData withEci(Integer value) {
		this.eci = value;
		return this;
	}

	/**
	 * Expiry date of the card Format: MMYY. 
	 *  * For Apple Pay, maps to the applicationExpirationDate property in the encrypted payment data. This property is formatted as YYMMDD, so this needs to be converted to get a correctly formatted expiry date
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Expiry date of the card Format: MMYY. 
	 *  * For Apple Pay, maps to the applicationExpirationDate property in the encrypted payment data. This property is formatted as YYMMDD, so this needs to be converted to get a correctly formatted expiry date
	 */
	public void setExpiryDate(String value) {
		this.expiryDate = value;
	}

	/**
	 * Expiry date of the card Format: MMYY. 
	 *  * For Apple Pay, maps to the applicationExpirationDate property in the encrypted payment data. This property is formatted as YYMMDD, so this needs to be converted to get a correctly formatted expiry date
	 */
	public DecryptedPaymentData withExpiryDate(String value) {
		this.expiryDate = value;
		return this;
	}
}
