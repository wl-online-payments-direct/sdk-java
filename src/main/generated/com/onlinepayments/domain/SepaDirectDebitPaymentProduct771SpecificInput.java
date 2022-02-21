/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing information specific to SEPA Direct Debit
 */
public class SepaDirectDebitPaymentProduct771SpecificInput {

	private String existingUniqueMandateReference = null;

	private CreateMandateWithReturnUrl mandate = null;

	/**
	 * The unique reference of the existing mandate to use in this payment.
	 */
	public String getExistingUniqueMandateReference() {
		return existingUniqueMandateReference;
	}

	/**
	 * The unique reference of the existing mandate to use in this payment.
	 */
	public void setExistingUniqueMandateReference(String value) {
		this.existingUniqueMandateReference = value;
	}

	/**
	 * The unique reference of the existing mandate to use in this payment.
	 */
	public SepaDirectDebitPaymentProduct771SpecificInput withExistingUniqueMandateReference(String value) {
		this.existingUniqueMandateReference = value;
		return this;
	}

	/**
	 * Object containing information to create a SEPA Direct Debit mandate.
	 */
	public CreateMandateWithReturnUrl getMandate() {
		return mandate;
	}

	/**
	 * Object containing information to create a SEPA Direct Debit mandate.
	 */
	public void setMandate(CreateMandateWithReturnUrl value) {
		this.mandate = value;
	}

	/**
	 * Object containing information to create a SEPA Direct Debit mandate.
	 */
	public SepaDirectDebitPaymentProduct771SpecificInput withMandate(CreateMandateWithReturnUrl value) {
		this.mandate = value;
		return this;
	}
}
