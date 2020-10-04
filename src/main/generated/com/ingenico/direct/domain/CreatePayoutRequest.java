/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing the payout details
 */
public class CreatePayoutRequest {

	private AmountOfMoney amountOfMoney = null;

	private CardPayoutMethodSpecificInput cardPayoutMethodSpecificInput = null;

	private PaymentReferences references = null;

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getAmountOfMoney() {
		return amountOfMoney;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
	}

	/**
	 * Object containing the payout details for a card
	 */
	public CardPayoutMethodSpecificInput getCardPayoutMethodSpecificInput() {
		return cardPayoutMethodSpecificInput;
	}

	/**
	 * Object containing the payout details for a card
	 */
	public void setCardPayoutMethodSpecificInput(CardPayoutMethodSpecificInput value) {
		this.cardPayoutMethodSpecificInput = value;
	}

	/**
	 * Object that holds all reference properties that are linked to this transaction
	 */
	public PaymentReferences getReferences() {
		return references;
	}

	/**
	 * Object that holds all reference properties that are linked to this transaction
	 */
	public void setReferences(PaymentReferences value) {
		this.references = value;
	}
}
