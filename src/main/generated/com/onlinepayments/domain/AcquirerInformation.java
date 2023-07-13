/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Information about the acquirer used to process the transaction
 */
public class AcquirerInformation {

	private String name = null;

	/**
	 * Name of the acquirer used to process the transaction
	 */
	public String getName() {
		return name;
	}

	/**
	 * Name of the acquirer used to process the transaction
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Name of the acquirer used to process the transaction
	 */
	public AcquirerInformation withName(String value) {
		this.name = value;
		return this;
	}
}
