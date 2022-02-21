/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing all data needed to redirect the customer
 */
public class RedirectData {

	private String RETURNMAC = null;

	private String redirectURL = null;

	/**
	 * A Message Authentication Code (MAC) is used to authenticate the redirection back to merchant after the payment
	 */
	public String getRETURNMAC() {
		return RETURNMAC;
	}

	/**
	 * A Message Authentication Code (MAC) is used to authenticate the redirection back to merchant after the payment
	 */
	public void setRETURNMAC(String value) {
		this.RETURNMAC = value;
	}

	/**
	 * A Message Authentication Code (MAC) is used to authenticate the redirection back to merchant after the payment
	 */
	public RedirectData withRETURNMAC(String value) {
		this.RETURNMAC = value;
		return this;
	}

	/**
	 * The URL that the customer should be redirected to. Be sure to redirect using the GET method
	 */
	public String getRedirectURL() {
		return redirectURL;
	}

	/**
	 * The URL that the customer should be redirected to. Be sure to redirect using the GET method
	 */
	public void setRedirectURL(String value) {
		this.redirectURL = value;
	}

	/**
	 * The URL that the customer should be redirected to. Be sure to redirect using the GET method
	 */
	public RedirectData withRedirectURL(String value) {
		this.redirectURL = value;
		return this;
	}
}
