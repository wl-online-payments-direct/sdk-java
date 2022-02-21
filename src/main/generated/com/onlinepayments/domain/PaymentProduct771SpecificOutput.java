/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Output that is SEPA Direct Debit specific (i.e. the used mandate)
 */
public class PaymentProduct771SpecificOutput {

	private String mandateReference = null;

	/**
	 * Unique reference to a Mandate
	 */
	public String getMandateReference() {
		return mandateReference;
	}

	/**
	 * Unique reference to a Mandate
	 */
	public void setMandateReference(String value) {
		this.mandateReference = value;
	}

	/**
	 * Unique reference to a Mandate
	 */
	public PaymentProduct771SpecificOutput withMandateReference(String value) {
		this.mandateReference = value;
		return this;
	}
}
