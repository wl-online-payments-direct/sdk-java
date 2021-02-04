/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Object that contains an optional tooltip to assist the customer
 */
public class PaymentProductFieldTooltip {

	private String image = null;

	private String label = null;

	/**
	 * Relative URL that can be used to retrieve an image for the tooltip image.
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Relative URL that can be used to retrieve an image for the tooltip image.
	 */
	public void setImage(String value) {
		this.image = value;
	}

	/**
	 * A text explaining the field in more detail. This is meant to be used for displaying to the customer.
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * A text explaining the field in more detail. This is meant to be used for displaying to the customer.
	 */
	public void setLabel(String value) {
		this.label = value;
	}
}
