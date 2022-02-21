/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object that contains an optional tooltip to assist the customer
 */
public class PaymentProductFieldTooltip {

	private String image = null;

	private String label = null;

	/**
	 * Deprecated: This field is not used by any payment product
	 * Relative URL that can be used to retrieve an image for the tooltip image.
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Relative URL that can be used to retrieve an image for the tooltip image.
	 */
	public void setImage(String value) {
		this.image = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 * Relative URL that can be used to retrieve an image for the tooltip image.
	 */
	public PaymentProductFieldTooltip withImage(String value) {
		this.image = value;
		return this;
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

	/**
	 * A text explaining the field in more detail. This is meant to be used for displaying to the customer.
	 */
	public PaymentProductFieldTooltip withLabel(String value) {
		this.label = value;
		return this;
	}
}
