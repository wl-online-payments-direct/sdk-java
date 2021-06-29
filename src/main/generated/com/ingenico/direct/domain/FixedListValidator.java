/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

import java.util.List;

public class FixedListValidator {

	private List<String> allowedValues = null;

	public List<String> getAllowedValues() {
		return allowedValues;
	}

	public void setAllowedValues(List<String> value) {
		this.allowedValues = value;
	}

	public FixedListValidator withAllowedValues(List<String> value) {
		this.allowedValues = value;
		return this;
	}
}
