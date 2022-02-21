/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

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
	 * The ACS Transaction ID for a prior 3-D Secure authenticated transaction (for example, the first recurring transaction that was authenticated with the customer)
	 */
	public ThreeDSecureData withAcsTransactionId(String value) {
		this.acsTransactionId = value;
		return this;
	}

	/**
	 * Method of authentication used for this transaction. Possible values:
	 *  * frictionless = The authentication went without a challenge
	 *  * challenged = Cardholder was challenged
	 *  * avs-verified = The authentication was verified by AVS
	 *  * other = Another issuer method was used to authenticate this transaction
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * Method of authentication used for this transaction. Possible values:
	 *  * frictionless = The authentication went without a challenge
	 *  * challenged = Cardholder was challenged
	 *  * avs-verified = The authentication was verified by AVS
	 *  * other = Another issuer method was used to authenticate this transaction
	 */
	public void setMethod(String value) {
		this.method = value;
	}

	/**
	 * Method of authentication used for this transaction. Possible values:
	 *  * frictionless = The authentication went without a challenge
	 *  * challenged = Cardholder was challenged
	 *  * avs-verified = The authentication was verified by AVS
	 *  * other = Another issuer method was used to authenticate this transaction
	 */
	public ThreeDSecureData withMethod(String value) {
		this.method = value;
		return this;
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

	/**
	 * Timestamp in UTC (YYYYMMDDHHmm) of the 3-D Secure authentication of this transaction
	 */
	public ThreeDSecureData withUtcTimestamp(String value) {
		this.utcTimestamp = value;
		return this;
	}
}
