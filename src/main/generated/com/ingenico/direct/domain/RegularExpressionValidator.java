/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class RegularExpressionValidator {

	private String regularExpression = null;

	public String getRegularExpression() {
		return regularExpression;
	}

	public void setRegularExpression(String value) {
		this.regularExpression = value;
	}

	public RegularExpressionValidator withRegularExpression(String value) {
		this.regularExpression = value;
		return this;
	}
}
