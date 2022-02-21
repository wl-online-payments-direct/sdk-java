/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing display hints like the order of the product when shown in a list, the name of the product and the logo
 */
public class PaymentProductDisplayHints {

	private Integer displayOrder = null;

	private String label = null;

	private String logo = null;

	/**
	 * Determines the order in which the payment products and groups should be shown (sorted ascending)
	 */
	public Integer getDisplayOrder() {
		return displayOrder;
	}

	/**
	 * Determines the order in which the payment products and groups should be shown (sorted ascending)
	 */
	public void setDisplayOrder(Integer value) {
		this.displayOrder = value;
	}

	/**
	 * Determines the order in which the payment products and groups should be shown (sorted ascending)
	 */
	public PaymentProductDisplayHints withDisplayOrder(Integer value) {
		this.displayOrder = value;
		return this;
	}

	/**
	 * Name of the payment product or group based on the locale that was included in the request
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Name of the payment product or group based on the locale that was included in the request
	 */
	public void setLabel(String value) {
		this.label = value;
	}

	/**
	 * Name of the payment product or group based on the locale that was included in the request
	 */
	public PaymentProductDisplayHints withLabel(String value) {
		this.label = value;
		return this;
	}

	/**
	 * Partial URL that you can reference for the image of this payment product. You can use our server-side resize functionality by appending '?size={{width}}x{{height}}' to the full URL, where width and height are specified in pixels. The resized image will always keep its correct aspect ratio.
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * Partial URL that you can reference for the image of this payment product. You can use our server-side resize functionality by appending '?size={{width}}x{{height}}' to the full URL, where width and height are specified in pixels. The resized image will always keep its correct aspect ratio.
	 */
	public void setLogo(String value) {
		this.logo = value;
	}

	/**
	 * Partial URL that you can reference for the image of this payment product. You can use our server-side resize functionality by appending '?size={{width}}x{{height}}' to the full URL, where width and height are specified in pixels. The resized image will always keep its correct aspect ratio.
	 */
	public PaymentProductDisplayHints withLogo(String value) {
		this.logo = value;
		return this;
	}
}
