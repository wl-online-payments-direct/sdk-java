/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing data regarding the customer authentication that occurred prior to the current transaction
 */
public class ThreeDSecureData {

	private String acsTransactionId = null;

	private String method = null;

	private String utcTimestamp = null;

	/**
	 * The ACS Transaction ID for a prior 3-D Secure authenticated transaction (for example, the first recurring transaction that was authenticated with the customer)
	 */
	public String getAcsTransactionId() {
		return acsTransactionId;
	}

	/**
	 * The ACS Transaction ID for a prior 3-D Secure authenticated transaction (for example, the first recurring transaction that was authenticated with the customer)
	 */
	public void setAcsTransactionId(String value) {
		this.acsTransactionId = value;
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
	 * Timestamp in UTC (YYYYMMDDHHmm) of the 3-D Secure authentication of this transaction
	 */
	public String getUtcTimestamp() {
		return utcTimestamp;
	}

	/**
	 * Timestamp in UTC (YYYYMMDDHHmm) of the 3-D Secure authentication of this transaction
	 */
	public void setUtcTimestamp(String value) {
		this.utcTimestamp = value;
	}
}
