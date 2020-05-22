/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Determines the type of the amount.
 */
public class AmountBreakdown {

	private Long amount = null;

	private String type = null;

	/**
	 * Amount in cents and always having 2 decimals
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * Amount in cents and always having 2 decimals
	 */
	public void setAmount(Long value) {
		this.amount = value;
	}

	/**
	 * Type of the amount. Each type is only allowed to be provided once. Allowed values:
	 *  * AIRPORT_TAX - The amount of tax paid for the airport, with the last 2 digits implied as decimal places.
	 *  * CONSUMPTION_TAX - The amount of consumption tax paid by the customer, with the last 2 digits implied as decimal places.
	 *  * DISCOUNT - Discount on the entire transaction, with the last 2 digits implied as decimal places.
	 *  * DUTY - Duty on the entire transaction, with the last 2 digits implied as decimal places.
	 *  * SHIPPING - Shipping cost on the entire transaction, with the last 2 digits implied as decimal places.
	 *  * VAT - Total amount of VAT paid on the transaction, with the last 2 digits implied as decimal places.
	 *  * BASE_AMOUNT - Order amount excluding all taxes, discount &amp; shipping costs, with the last 2 digits implied as decimal places. Note: BASE_AMOUNT is only supported by the Ogone Payment Platform.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Type of the amount. Each type is only allowed to be provided once. Allowed values:
	 *  * AIRPORT_TAX - The amount of tax paid for the airport, with the last 2 digits implied as decimal places.
	 *  * CONSUMPTION_TAX - The amount of consumption tax paid by the customer, with the last 2 digits implied as decimal places.
	 *  * DISCOUNT - Discount on the entire transaction, with the last 2 digits implied as decimal places.
	 *  * DUTY - Duty on the entire transaction, with the last 2 digits implied as decimal places.
	 *  * SHIPPING - Shipping cost on the entire transaction, with the last 2 digits implied as decimal places.
	 *  * VAT - Total amount of VAT paid on the transaction, with the last 2 digits implied as decimal places.
	 *  * BASE_AMOUNT - Order amount excluding all taxes, discount &amp; shipping costs, with the last 2 digits implied as decimal places. Note: BASE_AMOUNT is only supported by the Ogone Payment Platform.
	 */
	public void setType(String value) {
		this.type = value;
	}
}
