/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing the line items of the invoice or shopping cart
 */
public class LineItemInvoiceData {

	private String description = null;

	/**
	 * Shopping cart item description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Shopping cart item description
	 */
	public void setDescription(String value) {
		this.description = value;
	}
}
