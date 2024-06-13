/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing network token details
 */
public class NetworkTokenEssentials {

	private String bin = null;

	private String countryCode = null;

	private String networkToken = null;

	private String tokenExpiryDate = null;

	/**
	 * The first digits of the network token number from left to right with a minimum of 6 digits.
	 */
	public String getBin() {
		return bin;
	}

	/**
	 * The first digits of the network token number from left to right with a minimum of 6 digits.
	 */
	public void setBin(String value) {
		this.bin = value;
	}

	/**
	 * The first digits of the network token number from left to right with a minimum of 6 digits.
	 */
	public NetworkTokenEssentials withBin(String value) {
		this.bin = value;
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
	public NetworkTokenEssentials withCountryCode(String value) {
		this.countryCode = value;
		return this;
	}

	/**
	 * The masked Payment Token associated with the Card used for the purchase. 
	 * Note: This is called Payment Token in the EMVCo documentation.
	 */
	public String getNetworkToken() {
		return networkToken;
	}

	/**
	 * The masked Payment Token associated with the Card used for the purchase. 
	 * Note: This is called Payment Token in the EMVCo documentation.
	 */
	public void setNetworkToken(String value) {
		this.networkToken = value;
	}

	/**
	 * The masked Payment Token associated with the Card used for the purchase. 
	 * Note: This is called Payment Token in the EMVCo documentation.
	 */
	public NetworkTokenEssentials withNetworkToken(String value) {
		this.networkToken = value;
		return this;
	}

	/**
	 * The expiry date of the network token.
	 * Format: MMYY
	 */
	public String getTokenExpiryDate() {
		return tokenExpiryDate;
	}

	/**
	 * The expiry date of the network token.
	 * Format: MMYY
	 */
	public void setTokenExpiryDate(String value) {
		this.tokenExpiryDate = value;
	}

	/**
	 * The expiry date of the network token.
	 * Format: MMYY
	 */
	public NetworkTokenEssentials withTokenExpiryDate(String value) {
		this.tokenExpiryDate = value;
		return this;
	}
}
