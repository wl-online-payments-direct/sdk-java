/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing 3D secure details.
 */
public class ExternalCardholderAuthenticationData {

	private String acsTransactionId = null;

	private String appliedExemption = null;

	private String cavv = null;

	private String cavvAlgorithm = null;

	private String directoryServerTransactionId = null;

	private Integer eci = null;

	private String flow = null;

	private Integer schemeRiskScore = null;

	private String threeDSecureVersion = null;

	private String xid = null;

	/**
	 * Identifier of the authenticated transaction at the ACS/Issuer.
	 */
	public String getAcsTransactionId() {
		return acsTransactionId;
	}

	/**
	 * Identifier of the authenticated transaction at the ACS/Issuer.
	 */
	public void setAcsTransactionId(String value) {
		this.acsTransactionId = value;
	}

	/**
	 * Identifier of the authenticated transaction at the ACS/Issuer.
	 */
	public ExternalCardholderAuthenticationData withAcsTransactionId(String value) {
		this.acsTransactionId = value;
		return this;
	}

	/**
	 * Exemption code from Carte Bancaire (130) (unknown possible values so far -free format).
	 */
	public String getAppliedExemption() {
		return appliedExemption;
	}

	/**
	 * Exemption code from Carte Bancaire (130) (unknown possible values so far -free format).
	 */
	public void setAppliedExemption(String value) {
		this.appliedExemption = value;
	}

	/**
	 * Exemption code from Carte Bancaire (130) (unknown possible values so far -free format).
	 */
	public ExternalCardholderAuthenticationData withAppliedExemption(String value) {
		this.appliedExemption = value;
		return this;
	}

	/**
	 * The CAVV (cardholder authentication verification value) or AAV (accountholder authentication value) provides an authentication validation value.
	 * Note:
	 *   This is mandatory for ECI 2 and 5.
	 */
	public String getCavv() {
		return cavv;
	}

	/**
	 * The CAVV (cardholder authentication verification value) or AAV (accountholder authentication value) provides an authentication validation value.
	 * Note:
	 *   This is mandatory for ECI 2 and 5.
	 */
	public void setCavv(String value) {
		this.cavv = value;
	}

	/**
	 * The CAVV (cardholder authentication verification value) or AAV (accountholder authentication value) provides an authentication validation value.
	 * Note:
	 *   This is mandatory for ECI 2 and 5.
	 */
	public ExternalCardholderAuthenticationData withCavv(String value) {
		this.cavv = value;
		return this;
	}

	/**
	 * The algorithm, from your 3D Secure provider, used to generate the authentication CAVV.
	 * Note:
	 *   Required when
	 *   * The 3D Secure authentication for the transaction is managed by a third-party 3D Secure authentication provider
	 *   * You process the transaction through Atos
	 */
	public String getCavvAlgorithm() {
		return cavvAlgorithm;
	}

	/**
	 * The algorithm, from your 3D Secure provider, used to generate the authentication CAVV.
	 * Note:
	 *   Required when
	 *   * The 3D Secure authentication for the transaction is managed by a third-party 3D Secure authentication provider
	 *   * You process the transaction through Atos
	 */
	public void setCavvAlgorithm(String value) {
		this.cavvAlgorithm = value;
	}

	/**
	 * The algorithm, from your 3D Secure provider, used to generate the authentication CAVV.
	 * Note:
	 *   Required when
	 *   * The 3D Secure authentication for the transaction is managed by a third-party 3D Secure authentication provider
	 *   * You process the transaction through Atos
	 */
	public ExternalCardholderAuthenticationData withCavvAlgorithm(String value) {
		this.cavvAlgorithm = value;
		return this;
	}

	/**
	 * The 3-D Secure Directory Server transaction ID that is used for the 3D Authentication
	 * Example: d4c849f8-24c6-4673-bf34-d0f822c81b16
	 */
	public String getDirectoryServerTransactionId() {
		return directoryServerTransactionId;
	}

	/**
	 * The 3-D Secure Directory Server transaction ID that is used for the 3D Authentication
	 * Example: d4c849f8-24c6-4673-bf34-d0f822c81b16
	 */
	public void setDirectoryServerTransactionId(String value) {
		this.directoryServerTransactionId = value;
	}

	/**
	 * The 3-D Secure Directory Server transaction ID that is used for the 3D Authentication
	 * Example: d4c849f8-24c6-4673-bf34-d0f822c81b16
	 */
	public ExternalCardholderAuthenticationData withDirectoryServerTransactionId(String value) {
		this.directoryServerTransactionId = value;
		return this;
	}

	/**
	 * Electronic Commerce Indicator provides authentication validation results returned after AUTHENTICATIONVALIDATION
	 * * 0 = No authentication, Internet (no liability shift, not a 3D Secure transaction)
	 * * 1 = Authentication attempted (MasterCard)
	 * * 2 = Successful authentication (MasterCard)
	 * * 5 = Successful authentication (Visa, Diners Club, Amex)
	 * * 6 = Authentication attempted (Visa, Diners Club, Amex)
	 * * 7 = No authentication, Internet (no liability shift, not a 3D Secure transaction)
	 * * (empty) = Not checked or not enrolled
	 */
	public Integer getEci() {
		return eci;
	}

	/**
	 * Electronic Commerce Indicator provides authentication validation results returned after AUTHENTICATIONVALIDATION
	 * * 0 = No authentication, Internet (no liability shift, not a 3D Secure transaction)
	 * * 1 = Authentication attempted (MasterCard)
	 * * 2 = Successful authentication (MasterCard)
	 * * 5 = Successful authentication (Visa, Diners Club, Amex)
	 * * 6 = Authentication attempted (Visa, Diners Club, Amex)
	 * * 7 = No authentication, Internet (no liability shift, not a 3D Secure transaction)
	 * * (empty) = Not checked or not enrolled
	 */
	public void setEci(Integer value) {
		this.eci = value;
	}

	/**
	 * Electronic Commerce Indicator provides authentication validation results returned after AUTHENTICATIONVALIDATION
	 * * 0 = No authentication, Internet (no liability shift, not a 3D Secure transaction)
	 * * 1 = Authentication attempted (MasterCard)
	 * * 2 = Successful authentication (MasterCard)
	 * * 5 = Successful authentication (Visa, Diners Club, Amex)
	 * * 6 = Authentication attempted (Visa, Diners Club, Amex)
	 * * 7 = No authentication, Internet (no liability shift, not a 3D Secure transaction)
	 * * (empty) = Not checked or not enrolled
	 */
	public ExternalCardholderAuthenticationData withEci(Integer value) {
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
	public ExternalCardholderAuthenticationData withFlow(String value) {
		this.flow = value;
		return this;
	}

	/**
	 * Global score calculated by the Carte Bancaire (130) Scoring platform. Possible values from 0 to 99.
	 */
	public Integer getSchemeRiskScore() {
		return schemeRiskScore;
	}

	/**
	 * Global score calculated by the Carte Bancaire (130) Scoring platform. Possible values from 0 to 99.
	 */
	public void setSchemeRiskScore(Integer value) {
		this.schemeRiskScore = value;
	}

	/**
	 * Global score calculated by the Carte Bancaire (130) Scoring platform. Possible values from 0 to 99.
	 */
	public ExternalCardholderAuthenticationData withSchemeRiskScore(Integer value) {
		this.schemeRiskScore = value;
		return this;
	}

	/**
	 * The 3-D Secure version used for the authentication. Possible values:
	 * * v1
	 * * v2
	 * * 1.0.2
	 * * 2.1.0
	 * * 2.2.0
	 */
	public String getThreeDSecureVersion() {
		return threeDSecureVersion;
	}

	/**
	 * The 3-D Secure version used for the authentication. Possible values:
	 * * v1
	 * * v2
	 * * 1.0.2
	 * * 2.1.0
	 * * 2.2.0
	 */
	public void setThreeDSecureVersion(String value) {
		this.threeDSecureVersion = value;
	}

	/**
	 * The 3-D Secure version used for the authentication. Possible values:
	 * * v1
	 * * v2
	 * * 1.0.2
	 * * 2.1.0
	 * * 2.2.0
	 */
	public ExternalCardholderAuthenticationData withThreeDSecureVersion(String value) {
		this.threeDSecureVersion = value;
		return this;
	}

	/**
	 * The transaction ID that is used for the 3D Authentication
	 */
	public String getXid() {
		return xid;
	}

	/**
	 * The transaction ID that is used for the 3D Authentication
	 */
	public void setXid(String value) {
		this.xid = value;
	}

	/**
	 * The transaction ID that is used for the 3D Authentication
	 */
	public ExternalCardholderAuthenticationData withXid(String value) {
		this.xid = value;
		return this;
	}
}
