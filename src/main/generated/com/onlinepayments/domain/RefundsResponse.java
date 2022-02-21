/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

public class RefundsResponse {

	private List<RefundResponse> refunds = null;

	/**
	 * The list of all refunds performed on the requested payment.
	 */
	public List<RefundResponse> getRefunds() {
		return refunds;
	}

	/**
	 * The list of all refunds performed on the requested payment.
	 */
	public void setRefunds(List<RefundResponse> value) {
		this.refunds = value;
	}

	/**
	 * The list of all refunds performed on the requested payment.
	 */
	public RefundsResponse withRefunds(List<RefundResponse> value) {
		this.refunds = value;
		return this;
	}
}
