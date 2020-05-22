/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

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
}
