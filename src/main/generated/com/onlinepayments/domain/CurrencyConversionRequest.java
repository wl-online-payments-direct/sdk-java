/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class CurrencyConversionRequest {

	private CardInfo card = null;

	private Transaction transaction = null;

	public CardInfo getCard() {
		return card;
	}

	public void setCard(CardInfo value) {
		this.card = value;
	}

	public CurrencyConversionRequest withCard(CardInfo value) {
		this.card = value;
		return this;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction value) {
		this.transaction = value;
	}

	public CurrencyConversionRequest withTransaction(Transaction value) {
		this.transaction = value;
		return this;
	}
}
