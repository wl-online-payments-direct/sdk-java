/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

/**
 * Object containing company information
 */
public class CompanyInformation {

	private String name = null;

	/**
	 * Name of company, as a customer
	 */
	public String getName() {
		return name;
	}

	/**
	 * Name of company, as a customer
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Name of company, as a customer
	 */
	public CompanyInformation withName(String value) {
		this.name = value;
		return this;
	}
}
