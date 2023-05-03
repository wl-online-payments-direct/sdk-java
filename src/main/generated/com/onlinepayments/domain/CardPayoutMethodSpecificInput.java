/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing the payout details for a card
 */
public class CardPayoutMethodSpecificInput {

	private Card card = null;

	private Integer paymentProductId = null;

	private String payoutReason = null;

	private String token = null;

	/**
	 * Object containing card details
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * Object containing card details
	 */
	public void setCard(Card value) {
		this.card = value;
	}

	/**
	 * Object containing card details
	 */
	public CardPayoutMethodSpecificInput withCard(Card value) {
		this.card = value;
		return this;
	}

	/**
	 * Payment product identifier - Please see Products documentation for a full overview of possible values.
	 */
	public Integer getPaymentProductId() {
		return paymentProductId;
	}

	/**
	 * Payment product identifier - Please see Products documentation for a full overview of possible values.
	 */
	public void setPaymentProductId(Integer value) {
		this.paymentProductId = value;
	}

	/**
	 * Payment product identifier - Please see Products documentation for a full overview of possible values.
	 */
	public CardPayoutMethodSpecificInput withPaymentProductId(Integer value) {
		this.paymentProductId = value;
		return this;
	}

	/**
	 * Allows you to additionally specify the reason for initiating the payout for authorization purposes. If this field is not specified, authorisation of the payment will be made according to your merchant profile. Possible values are:
	 *   * Gambling
	 *   * Refund
	 *   * Loyalty
	 */
	public String getPayoutReason() {
		return payoutReason;
	}

	/**
	 * Allows you to additionally specify the reason for initiating the payout for authorization purposes. If this field is not specified, authorisation of the payment will be made according to your merchant profile. Possible values are:
	 *   * Gambling
	 *   * Refund
	 *   * Loyalty
	 */
	public void setPayoutReason(String value) {
		this.payoutReason = value;
	}

	/**
	 * Allows you to additionally specify the reason for initiating the payout for authorization purposes. If this field is not specified, authorisation of the payment will be made according to your merchant profile. Possible values are:
	 *   * Gambling
	 *   * Refund
	 *   * Loyalty
	 */
	public CardPayoutMethodSpecificInput withPayoutReason(String value) {
		this.payoutReason = value;
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
	public CardPayoutMethodSpecificInput withToken(String value) {
		this.token = value;
		return this;
	}
}
