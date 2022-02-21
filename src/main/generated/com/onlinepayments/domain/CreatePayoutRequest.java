/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

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
	 * Object containing amount and ISO currency code attributes
	 */
	public CreatePayoutRequest withAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
		return this;
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
	 * Object containing the payout details for a card
	 */
	public CreatePayoutRequest withCardPayoutMethodSpecificInput(CardPayoutMethodSpecificInput value) {
		this.cardPayoutMethodSpecificInput = value;
		return this;
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

	/**
	 * Object that holds all reference properties that are linked to this transaction
	 */
	public CreatePayoutRequest withReferences(PaymentReferences value) {
		this.references = value;
		return this;
	}
}
