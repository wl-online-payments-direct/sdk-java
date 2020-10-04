/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

public class GetHostedTokenizationResponse {

	private TokenResponse token = null;

	private String tokenStatus = null;

	public TokenResponse getToken() {
		return token;
	}

	public void setToken(TokenResponse value) {
		this.token = value;
	}

	/**
	 * This is the status of the token in the hosted tokenization session. Possible values are:
	 * * UNCHANGED - The token has not changed
	 * * CREATED - The token has been created
	 * * UPDATED - The token has been updated
	 */
	public String getTokenStatus() {
		return tokenStatus;
	}

	/**
	 * This is the status of the token in the hosted tokenization session. Possible values are:
	 * * UNCHANGED - The token has not changed
	 * * CREATED - The token has been created
	 * * UPDATED - The token has been updated
	 */
	public void setTokenStatus(String value) {
		this.tokenStatus = value;
	}
}
