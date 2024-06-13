/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing specific input required for Click to Pay payments.
 */
public class PaymentProduct5002SpecificInput {

	private String checkoutResponseSignature = null;

	private String creditCardBrand = null;

	private String dpaId = null;

	public String getCheckoutResponseSignature() {
		return checkoutResponseSignature;
	}

	public void setCheckoutResponseSignature(String value) {
		this.checkoutResponseSignature = value;
	}

	public PaymentProduct5002SpecificInput withCheckoutResponseSignature(String value) {
		this.checkoutResponseSignature = value;
		return this;
	}

	public String getCreditCardBrand() {
		return creditCardBrand;
	}

	public void setCreditCardBrand(String value) {
		this.creditCardBrand = value;
	}

	public PaymentProduct5002SpecificInput withCreditCardBrand(String value) {
		this.creditCardBrand = value;
		return this;
	}

	/**
	 * DPA Identifier provided during onboarding. Registered identifier for the DPA accessing the service.
	 */
	public String getDpaId() {
		return dpaId;
	}

	/**
	 * DPA Identifier provided during onboarding. Registered identifier for the DPA accessing the service.
	 */
	public void setDpaId(String value) {
		this.dpaId = value;
	}

	/**
	 * DPA Identifier provided during onboarding. Registered identifier for the DPA accessing the service.
	 */
	public PaymentProduct5002SpecificInput withDpaId(String value) {
		this.dpaId = value;
		return this;
	}
}
