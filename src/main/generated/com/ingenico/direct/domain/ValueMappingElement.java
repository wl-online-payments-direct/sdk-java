/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

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
}
