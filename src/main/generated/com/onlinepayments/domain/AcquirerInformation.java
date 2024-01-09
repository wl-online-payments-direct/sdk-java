/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Information about the acquirer used to process the transaction
 */
public class AcquirerInformation {

	private AcquirerSelectionInformation acquirerSelectionInformation = null;

	private String name = null;

	/**
	 * Information about the acquirer selection
	 */
	public AcquirerSelectionInformation getAcquirerSelectionInformation() {
		return acquirerSelectionInformation;
	}

	/**
	 * Information about the acquirer selection
	 */
	public void setAcquirerSelectionInformation(AcquirerSelectionInformation value) {
		this.acquirerSelectionInformation = value;
	}

	/**
	 * Information about the acquirer selection
	 */
	public AcquirerInformation withAcquirerSelectionInformation(AcquirerSelectionInformation value) {
		this.acquirerSelectionInformation = value;
		return this;
	}

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
