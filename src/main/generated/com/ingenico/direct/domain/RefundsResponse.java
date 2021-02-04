/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

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
}
