/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

public class PaymentProduct320SpecificData {

	private String gateway = null;

	private List<String> networks = null;

	/**
	 * The gateway identifier. You should use this when creating a <a href="https://developers.google.com/pay/api/android/reference/request-objects#Gateway">tokenization specification</a> .
	 */
	public String getGateway() {
		return gateway;
	}

	/**
	 * The gateway identifier. You should use this when creating a <a href="https://developers.google.com/pay/api/android/reference/request-objects#Gateway">tokenization specification</a> .
	 */
	public void setGateway(String value) {
		this.gateway = value;
	}

	/**
	 * The gateway identifier. You should use this when creating a <a href="https://developers.google.com/pay/api/android/reference/request-objects#Gateway">tokenization specification</a> .
	 */
	public PaymentProduct320SpecificData withGateway(String value) {
		this.gateway = value;
		return this;
	}

	/**
	 * The networks that can be used in the current payment context. The strings that represent the networks in the array are identical to the strings that GooglePay uses in their documentation. For instance "Visa".
	 */
	public List<String> getNetworks() {
		return networks;
	}

	/**
	 * The networks that can be used in the current payment context. The strings that represent the networks in the array are identical to the strings that GooglePay uses in their documentation. For instance "Visa".
	 */
	public void setNetworks(List<String> value) {
		this.networks = value;
	}

	/**
	 * The networks that can be used in the current payment context. The strings that represent the networks in the array are identical to the strings that GooglePay uses in their documentation. For instance "Visa".
	 */
	public PaymentProduct320SpecificData withNetworks(List<String> value) {
		this.networks = value;
		return this;
	}
}
