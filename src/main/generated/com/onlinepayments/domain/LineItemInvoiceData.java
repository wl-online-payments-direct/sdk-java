/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

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

	/**
	 * Shopping cart item description
	 */
	public LineItemInvoiceData withDescription(String value) {
		this.description = value;
		return this;
	}
}
