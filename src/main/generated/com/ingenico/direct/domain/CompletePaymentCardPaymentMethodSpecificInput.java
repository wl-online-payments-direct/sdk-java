/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class CompletePaymentCardPaymentMethodSpecificInput {

	private CardWithoutCvv card = null;

	public CardWithoutCvv getCard() {
		return card;
	}

	public void setCard(CardWithoutCvv value) {
		this.card = value;
	}

	public CompletePaymentCardPaymentMethodSpecificInput withCard(CardWithoutCvv value) {
		this.card = value;
		return this;
	}
}
