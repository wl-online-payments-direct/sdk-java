/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing the SEPA direct debit details
 */
public class SepaDirectDebitPaymentMethodSpecificOutput {

	private FraudResults fraudResults = null;

	private PaymentProduct771SpecificOutput paymentProduct771SpecificOutput = null;

	private Integer paymentProductId = null;

	/**
	 * Object containing the results of the fraud screening
	 */
	public FraudResults getFraudResults() {
		return fraudResults;
	}

	/**
	 * Object containing the results of the fraud screening
	 */
	public void setFraudResults(FraudResults value) {
		this.fraudResults = value;
	}

	public PaymentProduct771SpecificOutput getPaymentProduct771SpecificOutput() {
		return paymentProduct771SpecificOutput;
	}

	public void setPaymentProduct771SpecificOutput(PaymentProduct771SpecificOutput value) {
		this.paymentProduct771SpecificOutput = value;
	}

	/**
	 * Payment product identifier - Please see [payment products](https://support.direct.ingenico.com/documentation/api/reference/index.html#tag/Products) for a full overview of possible values.
	 */
	public Integer getPaymentProductId() {
		return paymentProductId;
	}

	/**
	 * Payment product identifier - Please see [payment products](https://support.direct.ingenico.com/documentation/api/reference/index.html#tag/Products) for a full overview of possible values.
	 */
	public void setPaymentProductId(Integer value) {
		this.paymentProductId = value;
	}
}
