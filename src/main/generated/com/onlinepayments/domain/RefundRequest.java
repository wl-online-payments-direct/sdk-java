/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class RefundRequest {

	private AmountOfMoney amountOfMoney = null;

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
	public RefundRequest withAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
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
	public RefundRequest withReferences(PaymentReferences value) {
		this.references = value;
		return this;
	}
}
