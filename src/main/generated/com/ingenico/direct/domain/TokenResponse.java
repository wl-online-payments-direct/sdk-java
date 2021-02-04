/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class TokenResponse {

	private TokenCard card = null;

	private TokenEWallet eWallet = null;

	private ExternalTokenLinked externalTokenLinked = null;

	private String id = null;

	private Integer paymentProductId = null;

	/**
	 * Object containing card details
	 */
	public TokenCard getCard() {
		return card;
	}

	/**
	 * Object containing card details
	 */
	public void setCard(TokenCard value) {
		this.card = value;
	}

	/**
	 * Object containing eWallet details
	 */
	public TokenEWallet getEWallet() {
		return eWallet;
	}

	/**
	 * Object containing eWallet details
	 */
	public void setEWallet(TokenEWallet value) {
		this.eWallet = value;
	}

	public ExternalTokenLinked getExternalTokenLinked() {
		return externalTokenLinked;
	}

	public void setExternalTokenLinked(ExternalTokenLinked value) {
		this.externalTokenLinked = value;
	}

	/**
	 * ID of the token
	 */
	public String getId() {
		return id;
	}

	/**
	 * ID of the token
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Payment product identifier - Please see [payment products](https://support.direct.ingenico.com/documentation/api/reference/index.html#tag/Products) for a full overview of possible values.
	 */
	public Integer getPaymentProductId() {
		return paymentProductId;
	}

	/**
	 * Payment product identifier - Please see [payment products](https://support.direct.ingenico.com/documentation/api/reference/index.html#tag/Products) for a full overview of possible values.
	 */
	public void setPaymentProductId(Integer value) {
		this.paymentProductId = value;
	}
}
