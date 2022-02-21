/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class PayoutResult {

	private String id = null;

	private PayoutOutput payoutOutput = null;

	private String status = null;

	private PayoutStatusOutput statusOutput = null;

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public PayoutResult withId(String value) {
		this.id = value;
		return this;
	}

	public PayoutOutput getPayoutOutput() {
		return payoutOutput;
	}

	public void setPayoutOutput(PayoutOutput value) {
		this.payoutOutput = value;
	}

	public PayoutResult withPayoutOutput(PayoutOutput value) {
		this.payoutOutput = value;
		return this;
	}

	/**
	 * Current high-level status of the payout in a human-readable form.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Current high-level status of the payout in a human-readable form.
	 */
	public void setStatus(String value) {
		this.status = value;
	}

	/**
	 * Current high-level status of the payout in a human-readable form.
	 */
	public PayoutResult withStatus(String value) {
		this.status = value;
		return this;
	}

	public PayoutStatusOutput getStatusOutput() {
		return statusOutput;
	}

	public void setStatusOutput(PayoutStatusOutput value) {
		this.statusOutput = value;
	}

	public PayoutResult withStatusOutput(PayoutStatusOutput value) {
		this.statusOutput = value;
		return this;
	}
}
