/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

public class CreatedTokenResponse {

	private CardWithoutCvv card = null;

	private Boolean isNewToken = null;

	private String token = null;

	public CardWithoutCvv getCard() {
		return card;
	}

	public void setCard(CardWithoutCvv value) {
		this.card = value;
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
}
