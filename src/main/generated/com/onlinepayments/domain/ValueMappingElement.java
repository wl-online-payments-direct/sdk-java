/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

/**
 * An array of values and displayNames that should be used to populate the list object in the GUI
 */
public class ValueMappingElement {

	private List<PaymentProductFieldDisplayElement> displayElements = null;

	private String value = null;

	public List<PaymentProductFieldDisplayElement> getDisplayElements() {
		return displayElements;
	}

	public void setDisplayElements(List<PaymentProductFieldDisplayElement> value) {
		this.displayElements = value;
	}

	public ValueMappingElement withDisplayElements(List<PaymentProductFieldDisplayElement> value) {
		this.displayElements = value;
		return this;
	}

	/**
	 * Value corresponding to the key
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Value corresponding to the key
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Value corresponding to the key
	 */
	public ValueMappingElement withValue(String value) {
		this.value = value;
		return this;
	}
}
