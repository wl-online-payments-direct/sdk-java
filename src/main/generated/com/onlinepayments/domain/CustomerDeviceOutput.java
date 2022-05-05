/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing information on the device and browser of the customer
 */
public class CustomerDeviceOutput {

	private String ipAddressCountryCode = null;

	/**
	 * ISO 3166-1 alpha-2 country code
	 */
	public String getIpAddressCountryCode() {
		return ipAddressCountryCode;
	}

	/**
	 * ISO 3166-1 alpha-2 country code
	 */
	public void setIpAddressCountryCode(String value) {
		this.ipAddressCountryCode = value;
	}

	/**
	 * ISO 3166-1 alpha-2 country code
	 */
	public CustomerDeviceOutput withIpAddressCountryCode(String value) {
		this.ipAddressCountryCode = value;
		return this;
	}
}
