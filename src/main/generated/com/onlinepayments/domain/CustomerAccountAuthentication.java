/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing data on the authentication used by the customer to access their account
 */
public class CustomerAccountAuthentication {

	private String method = null;

	private String utcTimestamp = null;

	/**
	 * Authentication used by the customer on your website
	 * Possible values are
	 *  * guest = no login occurred, customer is logged in as guest
	 *  * merchant-credentials = the customer logged in using credentials that are specific to you
	 *  * federated-id = the customer logged in using a federated ID
	 *  * issuer-credentials = the customer logged in using credentials from the card issuer (of the card used in this transaction)
	 *  * third-party-authentication = the customer logged in using third-party authentication
	 *  * fido-authentication = the customer logged in using a FIDO authenticator
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * Authentication used by the customer on your website
	 * Possible values are
	 *  * guest = no login occurred, customer is logged in as guest
	 *  * merchant-credentials = the customer logged in using credentials that are specific to you
	 *  * federated-id = the customer logged in using a federated ID
	 *  * issuer-credentials = the customer logged in using credentials from the card issuer (of the card used in this transaction)
	 *  * third-party-authentication = the customer logged in using third-party authentication
	 *  * fido-authentication = the customer logged in using a FIDO authenticator
	 */
	public void setMethod(String value) {
		this.method = value;
	}

	/**
	 * Authentication used by the customer on your website
	 * Possible values are
	 *  * guest = no login occurred, customer is logged in as guest
	 *  * merchant-credentials = the customer logged in using credentials that are specific to you
	 *  * federated-id = the customer logged in using a federated ID
	 *  * issuer-credentials = the customer logged in using credentials from the card issuer (of the card used in this transaction)
	 *  * third-party-authentication = the customer logged in using third-party authentication
	 *  * fido-authentication = the customer logged in using a FIDO authenticator
	 */
	public CustomerAccountAuthentication withMethod(String value) {
		this.method = value;
		return this;
	}

	/**
	 * Timestamp (YYYYMMDDHHmm) of the authentication of the customer to their account with you
	 */
	public String getUtcTimestamp() {
		return utcTimestamp;
	}

	/**
	 * Timestamp (YYYYMMDDHHmm) of the authentication of the customer to their account with you
	 */
	public void setUtcTimestamp(String value) {
		this.utcTimestamp = value;
	}

	/**
	 * Timestamp (YYYYMMDDHHmm) of the authentication of the customer to their account with you
	 */
	public CustomerAccountAuthentication withUtcTimestamp(String value) {
		this.utcTimestamp = value;
		return this;
	}
}
