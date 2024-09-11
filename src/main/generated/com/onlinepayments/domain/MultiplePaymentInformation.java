/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Container announcing forecoming subsequent payments. Holds modalities of these subsequent payments.
 */
public class MultiplePaymentInformation {

	private String paymentPattern = null;

	private Integer totalNumberOfPayments = null;

	/**
	 * Typology of multiple payment. Allowed values:
	 *   * PartialShipment
	 */
	public String getPaymentPattern() {
		return paymentPattern;
	}

	/**
	 * Typology of multiple payment. Allowed values:
	 *   * PartialShipment
	 */
	public void setPaymentPattern(String value) {
		this.paymentPattern = value;
	}

	/**
	 * Typology of multiple payment. Allowed values:
	 *   * PartialShipment
	 */
	public MultiplePaymentInformation withPaymentPattern(String value) {
		this.paymentPattern = value;
		return this;
	}

	/**
	 * Total number of payments. If a payment is implied by this call, it implicitly has ordinal number 1.
	 */
	public Integer getTotalNumberOfPayments() {
		return totalNumberOfPayments;
	}

	/**
	 * Total number of payments. If a payment is implied by this call, it implicitly has ordinal number 1.
	 */
	public void setTotalNumberOfPayments(Integer value) {
		this.totalNumberOfPayments = value;
	}

	/**
	 * Total number of payments. If a payment is implied by this call, it implicitly has ordinal number 1.
	 */
	public MultiplePaymentInformation withTotalNumberOfPayments(Integer value) {
		this.totalNumberOfPayments = value;
		return this;
	}
}
