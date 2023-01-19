/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

public class CalculateSurchargeResponse {

	private List<Surcharge> surcharges = null;

	/**
	 * List of surcharge calculations matching the bin and paymentProductId if supplied
	 */
	public List<Surcharge> getSurcharges() {
		return surcharges;
	}

	/**
	 * List of surcharge calculations matching the bin and paymentProductId if supplied
	 */
	public void setSurcharges(List<Surcharge> value) {
		this.surcharges = value;
	}

	/**
	 * List of surcharge calculations matching the bin and paymentProductId if supplied
	 */
	public CalculateSurchargeResponse withSurcharges(List<Surcharge> value) {
		this.surcharges = value;
		return this;
	}
}
