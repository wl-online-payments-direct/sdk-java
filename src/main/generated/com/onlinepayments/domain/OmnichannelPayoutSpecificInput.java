/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing the additional payout details for a Omnichannel merchants
 */
public class OmnichannelPayoutSpecificInput {

	private String paymentId = null;

	/**
	 * The Payment Id of the transaction (either in-store or online), from which you request to make a refund.
	 */
	public String getPaymentId() {
		return paymentId;
	}

	/**
	 * The Payment Id of the transaction (either in-store or online), from which you request to make a refund.
	 */
	public void setPaymentId(String value) {
		this.paymentId = value;
	}

	/**
	 * The Payment Id of the transaction (either in-store or online), from which you request to make a refund.
	 */
	public OmnichannelPayoutSpecificInput withPaymentId(String value) {
		this.paymentId = value;
		return this;
	}
}
