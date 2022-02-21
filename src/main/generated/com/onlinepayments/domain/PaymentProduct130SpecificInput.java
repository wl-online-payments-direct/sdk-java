/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing specific input required for CB payments
 */
public class PaymentProduct130SpecificInput {

	private PaymentProduct130SpecificThreeDSecure threeDSecure = null;

	/**
	 * Object containing specific data regarding 3-D Secure
	 */
	public PaymentProduct130SpecificThreeDSecure getThreeDSecure() {
		return threeDSecure;
	}

	/**
	 * Object containing specific data regarding 3-D Secure
	 */
	public void setThreeDSecure(PaymentProduct130SpecificThreeDSecure value) {
		this.threeDSecure = value;
	}

	/**
	 * Object containing specific data regarding 3-D Secure
	 */
	public PaymentProduct130SpecificInput withThreeDSecure(PaymentProduct130SpecificThreeDSecure value) {
		this.threeDSecure = value;
		return this;
	}
}
