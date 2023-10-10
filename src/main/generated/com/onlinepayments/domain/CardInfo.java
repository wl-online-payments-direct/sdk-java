/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class CardInfo {

	private String cardNumber = null;

	private Integer paymentProductId = null;

	/**
	 * Provide the complete credit/debit card number (also known as the PAN) for the most accurate results.
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Provide the complete credit/debit card number (also known as the PAN) for the most accurate results.
	 */
	public void setCardNumber(String value) {
		this.cardNumber = value;
	}

	/**
	 * Provide the complete credit/debit card number (also known as the PAN) for the most accurate results.
	 */
	public CardInfo withCardNumber(String value) {
		this.cardNumber = value;
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
	public CardInfo withPaymentProductId(Integer value) {
		this.paymentProductId = value;
		return this;
	}
}
