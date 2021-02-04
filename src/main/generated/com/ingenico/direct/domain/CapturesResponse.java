/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

import java.util.List;

public class CapturesResponse {

	private List<Capture> captures = null;

	/**
	 * The list of all captures performed on the requested payment.
	 */
	public List<Capture> getCaptures() {
		return captures;
	}

	/**
	 * The list of all captures performed on the requested payment.
	 */
	public void setCaptures(List<Capture> value) {
		this.captures = value;
	}
}
