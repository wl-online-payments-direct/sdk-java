/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

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
}
