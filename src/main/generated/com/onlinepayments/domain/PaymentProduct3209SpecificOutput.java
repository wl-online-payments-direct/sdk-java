/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * OneyDuplo Alcampo specific details
 */
public class PaymentProduct3209SpecificOutput {

	private String buyerCompliantBankMessage = null;

	/**
	 * This field indicates the text that must be returned and shown to the buyer to be compliant with the law regulating this payment product.
	 */
	public String getBuyerCompliantBankMessage() {
		return buyerCompliantBankMessage;
	}

	/**
	 * This field indicates the text that must be returned and shown to the buyer to be compliant with the law regulating this payment product.
	 */
	public void setBuyerCompliantBankMessage(String value) {
		this.buyerCompliantBankMessage = value;
	}

	/**
	 * This field indicates the text that must be returned and shown to the buyer to be compliant with the law regulating this payment product.
	 */
	public PaymentProduct3209SpecificOutput withBuyerCompliantBankMessage(String value) {
		this.buyerCompliantBankMessage = value;
		return this;
	}
}
