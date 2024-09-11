/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing consumer address details.
 * Required for Create mandate and Create payment calls.
 * Required for Create hostedCheckout calls where the IBAN is also provided.
 */
public class MandateAddress {

	private String city = null;

	private String countryCode = null;

	private String houseNumber = null;

	private String street = null;

	private String zip = null;

	/**
	 * City
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * City
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public void setCity(String value) {
		this.city = value;
	}

	/**
	 * City
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public MandateAddress withCity(String value) {
		this.city = value;
		return this;
	}

	/**
	 * ISO 3166-1 alpha-2 country code.
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * ISO 3166-1 alpha-2 country code.
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public void setCountryCode(String value) {
		this.countryCode = value;
	}

	/**
	 * ISO 3166-1 alpha-2 country code.
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public MandateAddress withCountryCode(String value) {
		this.countryCode = value;
		return this;
	}

	/**
	 * House number
	 */
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * House number
	 */
	public void setHouseNumber(String value) {
		this.houseNumber = value;
	}

	/**
	 * House number
	 */
	public MandateAddress withHouseNumber(String value) {
		this.houseNumber = value;
		return this;
	}

	/**
	 * Streetname.
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Streetname.
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public void setStreet(String value) {
		this.street = value;
	}

	/**
	 * Streetname.
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public MandateAddress withStreet(String value) {
		this.street = value;
		return this;
	}

	/**
	 * Zip code.
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Zip code.
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public void setZip(String value) {
		this.zip = value;
	}

	/**
	 * Zip code.
	 * Required for Create mandate and Create payment calls.
	 * Required for Create hostedCheckout calls where the IBAN is also provided.
	 */
	public MandateAddress withZip(String value) {
		this.zip = value;
		return this;
	}
}
