/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * List of extra data of the value.
 */
public class PaymentProductFieldDisplayElement {

	private String id = null;

	private String label = null;

	private String type = null;

	private String value = null;

	/**
	 * The ID of the display element.
	 */
	public String getId() {
		return id;
	}

	/**
	 * The ID of the display element.
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * The label of the display element.
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * The label of the display element.
	 */
	public void setLabel(String value) {
		this.label = value;
	}

	/**
	 * The type of the display element. Indicates how the value should be presented. Possible values are:
	 * * STRING - as plain text
	 * * CURRENCY - as an amount in cents displayed with a decimal separator and the currency of the payment
	 * * PERCENTAGE - as a number with a percentage sign
	 * * INTEGER - as an integer
	 * * URI - as a link
	 */
	public String getType() {
		return type;
	}

	/**
	 * The type of the display element. Indicates how the value should be presented. Possible values are:
	 * * STRING - as plain text
	 * * CURRENCY - as an amount in cents displayed with a decimal separator and the currency of the payment
	 * * PERCENTAGE - as a number with a percentage sign
	 * * INTEGER - as an integer
	 * * URI - as a link
	 */
	public void setType(String value) {
		this.type = value;
	}

	/**
	 * the value of the display element.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * the value of the display element.
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
