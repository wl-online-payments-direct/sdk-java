/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing information specific to Google Pay. Required for payments with product 320.
 */
public class MobilePaymentProduct320SpecificInput {

	private GPayThreeDSecure threeDSecure = null;

	/**
	 * Object containing specific data regarding 3-D Secure
	 */
	public GPayThreeDSecure getThreeDSecure() {
		return threeDSecure;
	}

	/**
	 * Object containing specific data regarding 3-D Secure
	 */
	public void setThreeDSecure(GPayThreeDSecure value) {
		this.threeDSecure = value;
	}

	/**
	 * Object containing specific data regarding 3-D Secure
	 */
	public MobilePaymentProduct320SpecificInput withThreeDSecure(GPayThreeDSecure value) {
		this.threeDSecure = value;
		return this;
	}
}
