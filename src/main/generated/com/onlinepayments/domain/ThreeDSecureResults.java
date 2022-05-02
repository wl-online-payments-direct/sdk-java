/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * 3D Secure results object
 */
public class ThreeDSecureResults {

	private String acsTransactionId = null;

	private String appliedExemption = null;

	private String authenticationStatus = null;

	private String cavv = null;

	private String challengeIndicator = null;

	private String dsTransactionId = null;

	private String eci = null;

	private String flow = null;

	private String liability = null;

	private String schemeEci = null;

	private String version = null;

	private String xid = null;

	/**
	 * Authenticated Transaction Identifier at the ACS/Issuer.
	 */
	public String getAcsTransactionId() {
		return acsTransactionId;
	}

	/**
	 * Authenticated Transaction Identifier at the ACS/Issuer.
	 */
	public void setAcsTransactionId(String value) {
		this.acsTransactionId = value;
	}

	/**
	 * Authenticated Transaction Identifier at the ACS/Issuer.
	 */
	public ThreeDSecureResults withAcsTransactionId(String value) {
		this.acsTransactionId = value;
		return this;
	}

	/**
	 * Exemption requested and applied in the authorization
	 */
	public String getAppliedExemption() {
		return appliedExemption;
	}

	/**
	 * Exemption requested and applied in the authorization
	 */
	public void setAppliedExemption(String value) {
		this.appliedExemption = value;
	}

	/**
	 * Exemption requested and applied in the authorization
	 */
	public ThreeDSecureResults withAppliedExemption(String value) {
		this.appliedExemption = value;
		return this;
	}

	/**
	 * One-letter authentication status returned by DS. Possible values are:
	 * * Y - Authentication succeeded
	 * * A - Authentication attempted
	 * * I - Information only, liability shifted to the merchant
	 * * N - Authentication failed
	 * * R - Authentication rejected
	 * * U - Authentication unavailable
	 * * C - Authentication required
	 */
	public String getAuthenticationStatus() {
		return authenticationStatus;
	}

	/**
	 * One-letter authentication status returned by DS. Possible values are:
	 * * Y - Authentication succeeded
	 * * A - Authentication attempted
	 * * I - Information only, liability shifted to the merchant
	 * * N - Authentication failed
	 * * R - Authentication rejected
	 * * U - Authentication unavailable
	 * * C - Authentication required
	 */
	public void setAuthenticationStatus(String value) {
		this.authenticationStatus = value;
	}

	/**
	 * One-letter authentication status returned by DS. Possible values are:
	 * * Y - Authentication succeeded
	 * * A - Authentication attempted
	 * * I - Information only, liability shifted to the merchant
	 * * N - Authentication failed
	 * * R - Authentication rejected
	 * * U - Authentication unavailable
	 * * C - Authentication required
	 */
	public ThreeDSecureResults withAuthenticationStatus(String value) {
		this.authenticationStatus = value;
		return this;
	}

	/**
	 * Cardholder Authentication Verification Value. End-2-end reference generated by the Issuer to recognize that the authentication has taken place.
	 */
	public String getCavv() {
		return cavv;
	}

	/**
	 * Cardholder Authentication Verification Value. End-2-end reference generated by the Issuer to recognize that the authentication has taken place.
	 */
	public void setCavv(String value) {
		this.cavv = value;
	}

	/**
	 * Cardholder Authentication Verification Value. End-2-end reference generated by the Issuer to recognize that the authentication has taken place.
	 */
	public ThreeDSecureResults withCavv(String value) {
		this.cavv = value;
		return this;
	}

	/**
	 * Challenge Indicator used for this transaction. This value might differ from the one sent by the merchant if the card is not supporting it (3DS version 2.1 vs 3DS version 2.2).
	 */
	public String getChallengeIndicator() {
		return challengeIndicator;
	}

	/**
	 * Challenge Indicator used for this transaction. This value might differ from the one sent by the merchant if the card is not supporting it (3DS version 2.1 vs 3DS version 2.2).
	 */
	public void setChallengeIndicator(String value) {
		this.challengeIndicator = value;
	}

	/**
	 * Challenge Indicator used for this transaction. This value might differ from the one sent by the merchant if the card is not supporting it (3DS version 2.1 vs 3DS version 2.2).
	 */
	public ThreeDSecureResults withChallengeIndicator(String value) {
		this.challengeIndicator = value;
		return this;
	}

	/**
	 * 3D Secure Directory Server Transaction Identifier used for this transaction.
	 */
	public String getDsTransactionId() {
		return dsTransactionId;
	}

	/**
	 * 3D Secure Directory Server Transaction Identifier used for this transaction.
	 */
	public void setDsTransactionId(String value) {
		this.dsTransactionId = value;
	}

	/**
	 * 3D Secure Directory Server Transaction Identifier used for this transaction.
	 */
	public ThreeDSecureResults withDsTransactionId(String value) {
		this.dsTransactionId = value;
		return this;
	}

	/**
	 * Indicates Authentication validation results returned after AuthenticationValidation
	 */
	public String getEci() {
		return eci;
	}

	/**
	 * Indicates Authentication validation results returned after AuthenticationValidation
	 */
	public void setEci(String value) {
		this.eci = value;
	}

	/**
	 * Indicates Authentication validation results returned after AuthenticationValidation
	 */
	public ThreeDSecureResults withEci(String value) {
		this.eci = value;
		return this;
	}

	/**
	 * 3D Secure Flow used during this transaction.
	 */
	public String getFlow() {
		return flow;
	}

	/**
	 * 3D Secure Flow used during this transaction.
	 */
	public void setFlow(String value) {
		this.flow = value;
	}

	/**
	 * 3D Secure Flow used during this transaction.
	 */
	public ThreeDSecureResults withFlow(String value) {
		this.flow = value;
		return this;
	}

	/**
	 * Determines the Fraud liability. Possible values are:
	 * * issuer - Fraud liability shifts to the issuer
	 * * merchant - Fraud liability with the merchant 
	 * 
	 * Note: When not filled in Fraud liability is not applicable for the current transaction.
	 */
	public String getLiability() {
		return liability;
	}

	/**
	 * Determines the Fraud liability. Possible values are:
	 * * issuer - Fraud liability shifts to the issuer
	 * * merchant - Fraud liability with the merchant 
	 * 
	 * Note: When not filled in Fraud liability is not applicable for the current transaction.
	 */
	public void setLiability(String value) {
		this.liability = value;
	}

	/**
	 * Determines the Fraud liability. Possible values are:
	 * * issuer - Fraud liability shifts to the issuer
	 * * merchant - Fraud liability with the merchant 
	 * 
	 * Note: When not filled in Fraud liability is not applicable for the current transaction.
	 */
	public ThreeDSecureResults withLiability(String value) {
		this.liability = value;
		return this;
	}

	/**
	 * 3D Secure ECI (Electronic Commerce Indicator) depending on the Scheme. Returned by DS.
	 */
	public String getSchemeEci() {
		return schemeEci;
	}

	/**
	 * 3D Secure ECI (Electronic Commerce Indicator) depending on the Scheme. Returned by DS.
	 */
	public void setSchemeEci(String value) {
		this.schemeEci = value;
	}

	/**
	 * 3D Secure ECI (Electronic Commerce Indicator) depending on the Scheme. Returned by DS.
	 */
	public ThreeDSecureResults withSchemeEci(String value) {
		this.schemeEci = value;
		return this;
	}

	/**
	 * 3D Secure Protocol version used during this transaction.
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * 3D Secure Protocol version used during this transaction.
	 */
	public void setVersion(String value) {
		this.version = value;
	}

	/**
	 * 3D Secure Protocol version used during this transaction.
	 */
	public ThreeDSecureResults withVersion(String value) {
		this.version = value;
		return this;
	}

	/**
	 * Transaction ID for the Authentication
	 */
	public String getXid() {
		return xid;
	}

	/**
	 * Transaction ID for the Authentication
	 */
	public void setXid(String value) {
		this.xid = value;
	}

	/**
	 * Transaction ID for the Authentication
	 */
	public ThreeDSecureResults withXid(String value) {
		this.xid = value;
		return this;
	}
}
