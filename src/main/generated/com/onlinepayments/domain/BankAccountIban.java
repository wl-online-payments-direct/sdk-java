/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing IBAN information
 */
public class BankAccountIban {

	private String iban = null;

	/**
	 * The IBAN is the International Bank Account Number. It is an internationally agreed format for the BBAN and includes the ISO country code and two check digits.
	 * Required for the creation of a Payout
	 * Required for Create and Update token.
	 * Required for Create mandate and Create payment with mandate calls.
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * The IBAN is the International Bank Account Number. It is an internationally agreed format for the BBAN and includes the ISO country code and two check digits.
	 * Required for the creation of a Payout
	 * Required for Create and Update token.
	 * Required for Create mandate and Create payment with mandate calls.
	 */
	public void setIban(String value) {
		this.iban = value;
	}

	/**
	 * The IBAN is the International Bank Account Number. It is an internationally agreed format for the BBAN and includes the ISO country code and two check digits.
	 * Required for the creation of a Payout
	 * Required for Create and Update token.
	 * Required for Create mandate and Create payment with mandate calls.
	 */
	public BankAccountIban withIban(String value) {
		this.iban = value;
		return this;
	}
}
