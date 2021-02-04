/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

import java.util.List;

/**
 * The response contains an array of payment product groups that match the filters supplied in the request.
 */
public class GetPaymentProductGroupsResponse {

	private List<PaymentProductGroup> paymentProductGroups = null;

	/**
	 * Array containing payment product groups and their characteristics
	 */
	public List<PaymentProductGroup> getPaymentProductGroups() {
		return paymentProductGroups;
	}

	/**
	 * Array containing payment product groups and their characteristics
	 */
	public void setPaymentProductGroups(List<PaymentProductGroup> value) {
		this.paymentProductGroups = value;
	}
}
