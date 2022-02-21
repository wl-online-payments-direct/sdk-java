/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * 3D Secure results object
 */
public class ThreeDSecureResults {

	private String eci = null;

	private String xid = null;

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
