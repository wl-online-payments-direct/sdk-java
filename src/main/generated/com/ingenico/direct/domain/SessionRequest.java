/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

import java.util.List;

public class SessionRequest {

	private List<String> tokens = null;

	/**
	 * List of previously stored tokens linked to the customer that wants to checkout.
	 */
	public List<String> getTokens() {
		return tokens;
	}

	/**
	 * List of previously stored tokens linked to the customer that wants to checkout.
	 */
	public void setTokens(List<String> value) {
		this.tokens = value;
	}
}
