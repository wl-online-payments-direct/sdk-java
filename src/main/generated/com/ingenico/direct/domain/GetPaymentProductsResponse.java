/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

import java.util.List;

/**
 * The response contains an array of payment products that match the filters supplied in the request.
 */
public class GetPaymentProductsResponse {

	private List<PaymentProduct> paymentProducts = null;

	/**
	 * Array containing payment products and their characteristics
	 */
	public List<PaymentProduct> getPaymentProducts() {
		return paymentProducts;
	}

	/**
	 * Array containing payment products and their characteristics
	 */
	public void setPaymentProducts(List<PaymentProduct> value) {
		this.paymentProducts = value;
	}
}
