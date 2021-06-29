/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

import java.util.List;

public class PaymentProduct320SpecificData {

	private String gateway = null;

	private List<String> networks = null;

	/**
	 * The Ingenico gateway identifier. You should use this when creating a [tokenization specification](https://developers.google.com/pay/api/android/reference/request-objects#Gateway) .
	 */
	public String getGateway() {
		return gateway;
	}

	/**
	 * The Ingenico gateway identifier. You should use this when creating a [tokenization specification](https://developers.google.com/pay/api/android/reference/request-objects#Gateway) .
	 */
	public void setGateway(String value) {
		this.gateway = value;
	}

	/**
	 * The Ingenico gateway identifier. You should use this when creating a [tokenization specification](https://developers.google.com/pay/api/android/reference/request-objects#Gateway) .
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
