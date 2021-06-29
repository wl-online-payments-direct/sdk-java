/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Object containing specific input required for Cpay payments.
 */
public class PaymentProduct5100SpecificInput {

	private String brand = null;

	/**
	 * Indicate whether to use a specific Cpay brand. Brands are configurable at the payment method level. See BackOffice Cpay configuration for allowed values.
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Indicate whether to use a specific Cpay brand. Brands are configurable at the payment method level. See BackOffice Cpay configuration for allowed values.
	 */
	public void setBrand(String value) {
		this.brand = value;
	}

	/**
	 * Indicate whether to use a specific Cpay brand. Brands are configurable at the payment method level. See BackOffice Cpay configuration for allowed values.
	 */
	public PaymentProduct5100SpecificInput withBrand(String value) {
		this.brand = value;
		return this;
	}
}
