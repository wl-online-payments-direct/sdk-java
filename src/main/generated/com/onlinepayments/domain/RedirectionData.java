/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing browser specific redirection related data
 */
public class RedirectionData {

	private String returnUrl = null;

	/**
	 * The URL that the customer is redirected to after the payment flow has finished. You can add any number of key value pairs in the query string that, for instance help you to identify the customer when they return to your site. Please note that we will also append some additional key value pairs that will also help you with this identification process.
	 * Note: The provided URL should be absolute and contain the protocol to use, e.g. http:// or https://. For use on mobile devices a custom protocol can be used in the form of protocol://. This protocol must be registered on the device first.
	 * URLs without a protocol will be rejected.
	 */
	public String getReturnUrl() {
		return returnUrl;
	}

	/**
	 * The URL that the customer is redirected to after the payment flow has finished. You can add any number of key value pairs in the query string that, for instance help you to identify the customer when they return to your site. Please note that we will also append some additional key value pairs that will also help you with this identification process.
	 * Note: The provided URL should be absolute and contain the protocol to use, e.g. http:// or https://. For use on mobile devices a custom protocol can be used in the form of protocol://. This protocol must be registered on the device first.
	 * URLs without a protocol will be rejected.
	 */
	public void setReturnUrl(String value) {
		this.returnUrl = value;
	}

	/**
	 * The URL that the customer is redirected to after the payment flow has finished. You can add any number of key value pairs in the query string that, for instance help you to identify the customer when they return to your site. Please note that we will also append some additional key value pairs that will also help you with this identification process.
	 * Note: The provided URL should be absolute and contain the protocol to use, e.g. http:// or https://. For use on mobile devices a custom protocol can be used in the form of protocol://. This protocol must be registered on the device first.
	 * URLs without a protocol will be rejected.
	 */
	public RedirectionData withReturnUrl(String value) {
		this.returnUrl = value;
		return this;
	}
}
