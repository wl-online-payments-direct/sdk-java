/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

/**
 * Object detailing the type of form element that should be used to present the field
 */
public class PaymentProductFieldFormElement {

	private String type = null;

	private List<ValueMappingElement> valueMapping = null;

	/**
	 * Type of form element to be used. The following types can be returned:
	 * * text - A normal text input field
	 * * list - A list of values that the customer needs to choose from, is detailed in the valueMapping array
	 * * currency - Currency fields should be split into two fields, with the second one being specifically for the cents
	 * * boolean - Boolean fields should offer the customer a choice, like accepting the terms and conditions of a product.
	 * * date - let the customer pick a date.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Type of form element to be used. The following types can be returned:
	 * * text - A normal text input field
	 * * list - A list of values that the customer needs to choose from, is detailed in the valueMapping array
	 * * currency - Currency fields should be split into two fields, with the second one being specifically for the cents
	 * * boolean - Boolean fields should offer the customer a choice, like accepting the terms and conditions of a product.
	 * * date - let the customer pick a date.
	 */
	public void setType(String value) {
		this.type = value;
	}

	/**
	 * Type of form element to be used. The following types can be returned:
	 * * text - A normal text input field
	 * * list - A list of values that the customer needs to choose from, is detailed in the valueMapping array
	 * * currency - Currency fields should be split into two fields, with the second one being specifically for the cents
	 * * boolean - Boolean fields should offer the customer a choice, like accepting the terms and conditions of a product.
	 * * date - let the customer pick a date.
	 */
	public PaymentProductFieldFormElement withType(String value) {
		this.type = value;
		return this;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 */
	public List<ValueMappingElement> getValueMapping() {
		return valueMapping;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 */
	public void setValueMapping(List<ValueMappingElement> value) {
		this.valueMapping = value;
	}

	/**
	 * Deprecated: This field is not used by any payment product
	 */
	public PaymentProductFieldFormElement withValueMapping(List<ValueMappingElement> value) {
		this.valueMapping = value;
		return this;
	}
}
