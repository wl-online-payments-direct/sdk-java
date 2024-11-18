/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Multibanco (payment product 5500) specific details
 */
public class PaymentProduct5500SpecificOutput {

	private String paymentEndDate = null;

	private String paymentReference = null;

	private String paymentStartDate = null;

	private String entityId = null;

	/**
	 * The end date of the payment validity
	 */
	public String getPaymentEndDate() {
		return paymentEndDate;
	}

	/**
	 * The end date of the payment validity
	 */
	public void setPaymentEndDate(String value) {
		this.paymentEndDate = value;
	}

	/**
	 * The end date of the payment validity
	 */
	public PaymentProduct5500SpecificOutput withPaymentEndDate(String value) {
		this.paymentEndDate = value;
		return this;
	}

	/**
	 * The reference to be used within the Multibanco network to confirm the payment
	 */
	public String getPaymentReference() {
		return paymentReference;
	}

	/**
	 * The reference to be used within the Multibanco network to confirm the payment
	 */
	public void setPaymentReference(String value) {
		this.paymentReference = value;
	}

	/**
	 * The reference to be used within the Multibanco network to confirm the payment
	 */
	public PaymentProduct5500SpecificOutput withPaymentReference(String value) {
		this.paymentReference = value;
		return this;
	}

	/**
	 * The start date of the payment validity
	 */
	public String getPaymentStartDate() {
		return paymentStartDate;
	}

	/**
	 * The start date of the payment validity
	 */
	public void setPaymentStartDate(String value) {
		this.paymentStartDate = value;
	}

	/**
	 * The start date of the payment validity
	 */
	public PaymentProduct5500SpecificOutput withPaymentStartDate(String value) {
		this.paymentStartDate = value;
		return this;
	}

	/**
	 * Gets the entity ID.
	 */
	public String getEntityId() {
		return entityId;
	}

	/**
	 * Sets the entity ID.
	 */
	public void setEntityId(String value) {
		this.entityId = value;
	}

	/**
	 * Sets the entity ID. Method to enable chaining.
	 */
	public PaymentProduct5500SpecificOutput withEntityId(String value) {
		this.entityId = value;

		return this;
	}
}
