/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing specific input required for Cpay payments.
 */
public class PaymentProduct5100SpecificInput {

	private String brand = null;

	/**
	 * Indicate whether to use a specific Cpay brand. Brands are configurable at the payment method level. Allowed values:
	 * * "Cpay"
	 * * "CpayGold"
	 * * Other specific Carte Enseigne (see Cpay documentation)
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Indicate whether to use a specific Cpay brand. Brands are configurable at the payment method level. Allowed values:
	 * * "Cpay"
	 * * "CpayGold"
	 * * Other specific Carte Enseigne (see Cpay documentation)
	 */
	public void setBrand(String value) {
		this.brand = value;
	}
}
