/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing information on the device and browser of the customer
 */
public class CustomerDevice {

	private String acceptHeader = null;

	private BrowserData browserData = null;

	private String deviceFingerprint = null;

	private String ipAddress = null;

	private String locale = null;

	private String timezoneOffsetUtcMinutes = null;

	private String userAgent = null;

	/**
	 * The accept-header of the customer client from the HTTP Headers.
	 */
	public String getAcceptHeader() {
		return acceptHeader;
	}

	/**
	 * The accept-header of the customer client from the HTTP Headers.
	 */
	public void setAcceptHeader(String value) {
		this.acceptHeader = value;
	}

	/**
	 * The accept-header of the customer client from the HTTP Headers.
	 */
	public CustomerDevice withAcceptHeader(String value) {
		this.acceptHeader = value;
		return this;
	}

	/**
	 * Object containing information regarding the browser of the customer
	 */
	public BrowserData getBrowserData() {
		return browserData;
	}

	/**
	 * Object containing information regarding the browser of the customer
	 */
	public void setBrowserData(BrowserData value) {
		this.browserData = value;
	}

	/**
	 * Object containing information regarding the browser of the customer
	 */
	public CustomerDevice withBrowserData(BrowserData value) {
		this.browserData = value;
		return this;
	}

	/**
	 * The session ID for the device fingerprint must match the one sent in the device fingerprint script.
	 */
	public String getDeviceFingerprint() {
		return deviceFingerprint;
	}

	/**
	 * The session ID for the device fingerprint must match the one sent in the device fingerprint script.
	 */
	public void setDeviceFingerprint(String value) {
		this.deviceFingerprint = value;
	}

	/**
	 * The session ID for the device fingerprint must match the one sent in the device fingerprint script.
	 */
	public CustomerDevice withDeviceFingerprint(String value) {
		this.deviceFingerprint = value;
		return this;
	}

	/**
	 * The IP address of the customer client from the HTTP Headers.
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * The IP address of the customer client from the HTTP Headers.
	 */
	public void setIpAddress(String value) {
		this.ipAddress = value;
	}

	/**
	 * The IP address of the customer client from the HTTP Headers.
	 */
	public CustomerDevice withIpAddress(String value) {
		this.ipAddress = value;
		return this;
	}

	/**
	 * Locale of the client device/browser. Returned in the browser from the navigator.language property.
	 * 
	 * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * Locale of the client device/browser. Returned in the browser from the navigator.language property.
	 * 
	 * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
	 */
	public void setLocale(String value) {
		this.locale = value;
	}

	/**
	 * Locale of the client device/browser. Returned in the browser from the navigator.language property.
	 * 
	 * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
	 */
	public CustomerDevice withLocale(String value) {
		this.locale = value;
		return this;
	}

	/**
	 * Offset in minutes of timezone of the client versus the UTC. Value is returned by the JavaScript getTimezoneOffset() Method.
	 * 
	 * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
	 */
	public String getTimezoneOffsetUtcMinutes() {
		return timezoneOffsetUtcMinutes;
	}

	/**
	 * Offset in minutes of timezone of the client versus the UTC. Value is returned by the JavaScript getTimezoneOffset() Method.
	 * 
	 * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
	 */
	public void setTimezoneOffsetUtcMinutes(String value) {
		this.timezoneOffsetUtcMinutes = value;
	}

	/**
	 * Offset in minutes of timezone of the client versus the UTC. Value is returned by the JavaScript getTimezoneOffset() Method.
	 * 
	 * If you use the latest version of our JavaScript Client SDK, we will collect this data and include it in the encryptedCustomerInput property. We will then automatically populate this data if available.
	 */
	public CustomerDevice withTimezoneOffsetUtcMinutes(String value) {
		this.timezoneOffsetUtcMinutes = value;
		return this;
	}

	/**
	 * User-Agent of the client device/browser from the HTTP Headers.
	 * 
	 * As a fall-back we will use the userAgent that might be included in the encryptedCustomerInput, but this is captured client side using JavaScript and might be different.
	 */
	public String getUserAgent() {
		return userAgent;
	}

	/**
	 * User-Agent of the client device/browser from the HTTP Headers.
	 * 
	 * As a fall-back we will use the userAgent that might be included in the encryptedCustomerInput, but this is captured client side using JavaScript and might be different.
	 */
	public void setUserAgent(String value) {
		this.userAgent = value;
	}

	/**
	 * User-Agent of the client device/browser from the HTTP Headers.
	 * 
	 * As a fall-back we will use the userAgent that might be included in the encryptedCustomerInput, but this is captured client side using JavaScript and might be different.
	 */
	public CustomerDevice withUserAgent(String value) {
		this.userAgent = value;
		return this;
	}
}
