/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Object containing the redirect payment product details
 */
public class RedirectPaymentMethodSpecificOutput {

	private FraudResults fraudResults = null;

	private String paymentOption = null;

	private PaymentProduct5402SpecificOutput paymentProduct5402SpecificOutput = null;

	private PaymentProduct5500SpecificOutput paymentProduct5500SpecificOutput = null;

	private PaymentProduct840SpecificOutput paymentProduct840SpecificOutput = null;

	private Integer paymentProductId = null;

	private String token = null;

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

	/**
	 * The specific payment option for the payment. To be used as a complement of the more generic paymentProductId (oney, banquecasino, cofidis), which allows to define a variation of the selected paymentProductId (ex: facilypay3x, banquecasino4x, cofidis3x-sansfrais, ...). List of modalities included in the payment product page.
	 */
	public String getPaymentOption() {
		return paymentOption;
	}

	/**
	 * The specific payment option for the payment. To be used as a complement of the more generic paymentProductId (oney, banquecasino, cofidis), which allows to define a variation of the selected paymentProductId (ex: facilypay3x, banquecasino4x, cofidis3x-sansfrais, ...). List of modalities included in the payment product page.
	 */
	public void setPaymentOption(String value) {
		this.paymentOption = value;
	}

	/**
	 * Meal vouchers (payment product 5402) specific details
	 */
	public PaymentProduct5402SpecificOutput getPaymentProduct5402SpecificOutput() {
		return paymentProduct5402SpecificOutput;
	}

	/**
	 * Meal vouchers (payment product 5402) specific details
	 */
	public void setPaymentProduct5402SpecificOutput(PaymentProduct5402SpecificOutput value) {
		this.paymentProduct5402SpecificOutput = value;
	}

	/**
	 * Multibanco (payment product 5500) specific details
	 */
	public PaymentProduct5500SpecificOutput getPaymentProduct5500SpecificOutput() {
		return paymentProduct5500SpecificOutput;
	}

	/**
	 * Multibanco (payment product 5500) specific details
	 */
	public void setPaymentProduct5500SpecificOutput(PaymentProduct5500SpecificOutput value) {
		this.paymentProduct5500SpecificOutput = value;
	}

	/**
	 * PayPal (payment product 840) specific details
	 */
	public PaymentProduct840SpecificOutput getPaymentProduct840SpecificOutput() {
		return paymentProduct840SpecificOutput;
	}

	/**
	 * PayPal (payment product 840) specific details
	 */
	public void setPaymentProduct840SpecificOutput(PaymentProduct840SpecificOutput value) {
		this.paymentProduct840SpecificOutput = value;
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

	/**
	 * ID of the token. This property is populated when the payment was done with a token or when the payment was tokenized.
	 */
	public String getToken() {
		return token;
	}

	/**
	 * ID of the token. This property is populated when the payment was done with a token or when the payment was tokenized.
	 */
	public void setToken(String value) {
		this.token = value;
	}
}
