/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

public class ThreeDSWhitelist {

	private String source = null;

	private String status = null;

	/**
	 * Whitelist Status Source. This data element will be populated by the system setting Whitelist Status
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Whitelist Status Source. This data element will be populated by the system setting Whitelist Status
	 */
	public void setSource(String value) {
		this.source = value;
	}

	/**
	 * Whitelist Status. Enables the communication of trusted beneficiary/whitelist status between the ACS, the DS and the 3DS Requestor.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Whitelist Status. Enables the communication of trusted beneficiary/whitelist status between the ACS, the DS and the 3DS Requestor.
	 */
	public void setStatus(String value) {
		this.status = value;
	}
}
