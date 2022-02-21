/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class GetHostedTokenizationResponse {

	private TokenResponse token = null;

	private String tokenStatus = null;

	public TokenResponse getToken() {
		return token;
	}

	public void setToken(TokenResponse value) {
		this.token = value;
	}

	public GetHostedTokenizationResponse withToken(TokenResponse value) {
		this.token = value;
		return this;
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

	/**
	 * This is the status of the token in the hosted tokenization session. Possible values are:
	 * * UNCHANGED - The token has not changed
	 * * CREATED - The token has been created
	 * * UPDATED - The token has been updated
	 */
	public GetHostedTokenizationResponse withTokenStatus(String value) {
		this.tokenStatus = value;
		return this;
	}
}
