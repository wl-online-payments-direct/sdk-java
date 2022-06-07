/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing specific input required for bancontact.
 */
public class PaymentProduct3012SpecificInput {

	private Boolean forceAuthentication = null;

	private Boolean isWipTransaction = null;

	/**
	 * Indicate whether authentication should be forced.
	 */
	public Boolean getForceAuthentication() {
		return forceAuthentication;
	}

	/**
	 * Indicate whether authentication should be forced.
	 */
	public void setForceAuthentication(Boolean value) {
		this.forceAuthentication = value;
	}

	/**
	 * Indicate whether authentication should be forced.
	 */
	public PaymentProduct3012SpecificInput withForceAuthentication(Boolean value) {
		this.forceAuthentication = value;
		return this;
	}

	/**
	 * Indicate whether its wallet initiated payment.
	 */
	public Boolean getIsWipTransaction() {
		return isWipTransaction;
	}

	/**
	 * Indicate whether its wallet initiated payment.
	 */
	public void setIsWipTransaction(Boolean value) {
		this.isWipTransaction = value;
	}

	/**
	 * Indicate whether its wallet initiated payment.
	 */
	public PaymentProduct3012SpecificInput withIsWipTransaction(Boolean value) {
		this.isWipTransaction = value;
		return this;
	}
}
