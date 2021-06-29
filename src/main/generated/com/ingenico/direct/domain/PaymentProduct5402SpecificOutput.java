/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Meal vouchers (payment product 5402) specific details
 */
public class PaymentProduct5402SpecificOutput {

	private String brand = null;

	/**
	 * The specific meal voucher brand used for the transaction
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * The specific meal voucher brand used for the transaction
	 */
	public void setBrand(String value) {
		this.brand = value;
	}

	/**
	 * The specific meal voucher brand used for the transaction
	 */
	public PaymentProduct5402SpecificOutput withBrand(String value) {
		this.brand = value;
		return this;
	}
}
