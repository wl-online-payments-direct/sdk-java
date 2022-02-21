/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class CreatedTokenResponse {

	private CardWithoutCvv card = null;

	private ExternalTokenLinked externalTokenLinked = null;

	private Boolean isNewToken = null;

	private String token = null;

	private String tokenStatus = null;

	public CardWithoutCvv getCard() {
		return card;
	}

	public void setCard(CardWithoutCvv value) {
		this.card = value;
	}

	public CreatedTokenResponse withCard(CardWithoutCvv value) {
		this.card = value;
		return this;
	}

	public ExternalTokenLinked getExternalTokenLinked() {
		return externalTokenLinked;
	}

	public void setExternalTokenLinked(ExternalTokenLinked value) {
		this.externalTokenLinked = value;
	}

	public CreatedTokenResponse withExternalTokenLinked(ExternalTokenLinked value) {
		this.externalTokenLinked = value;
		return this;
	}

	/**
	 * Indicates if a new token was created 
	 *  * true - A new token was created 
	 *  * false - A token with the same card number already exists and is returned. Please note that the existing token has not been updated. When you want to update other data then the card number, you need to update data stored in the token explicitly, as data is never updated during the creation of a token.
	 */
	public Boolean getIsNewToken() {
		return isNewToken;
	}

	/**
	 * Indicates if a new token was created 
	 *  * true - A new token was created 
	 *  * false - A token with the same card number already exists and is returned. Please note that the existing token has not been updated. When you want to update other data then the card number, you need to update data stored in the token explicitly, as data is never updated during the creation of a token.
	 */
	public void setIsNewToken(Boolean value) {
		this.isNewToken = value;
	}

	/**
	 * Indicates if a new token was created 
	 *  * true - A new token was created 
	 *  * false - A token with the same card number already exists and is returned. Please note that the existing token has not been updated. When you want to update other data then the card number, you need to update data stored in the token explicitly, as data is never updated during the creation of a token.
	 */
	public CreatedTokenResponse withIsNewToken(Boolean value) {
		this.isNewToken = value;
		return this;
	}

	/**
	 * ID of the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * ID of the token
	 */
	public void setToken(String value) {
		this.token = value;
	}

	/**
	 * ID of the token
	 */
	public CreatedTokenResponse withToken(String value) {
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
	public CreatedTokenResponse withTokenStatus(String value) {
		this.tokenStatus = value;
		return this;
	}
}
