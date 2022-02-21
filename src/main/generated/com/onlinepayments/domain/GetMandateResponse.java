/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing the Get Mandate response
 */
public class GetMandateResponse {

	private MandateResponse mandate = null;

	/**
	 * Object containing the created mandate.
	 */
	public MandateResponse getMandate() {
		return mandate;
	}

	/**
	 * Object containing the created mandate.
	 */
	public void setMandate(MandateResponse value) {
		this.mandate = value;
	}

	/**
	 * Object containing the created mandate.
	 */
	public GetMandateResponse withMandate(MandateResponse value) {
		this.mandate = value;
		return this;
	}
}
