/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

public class PaymentProduct302SpecificData {

	private List<String> networks = null;

	/**
	 * The networks that can be used in the current payment context. The strings that represent the networks in the array are identical to the strings that Apple uses in their documentation. For instance "Visa".
	 */
	public List<String> getNetworks() {
		return networks;
	}

	/**
	 * The networks that can be used in the current payment context. The strings that represent the networks in the array are identical to the strings that Apple uses in their documentation. For instance "Visa".
	 */
	public void setNetworks(List<String> value) {
		this.networks = value;
	}

	/**
	 * The networks that can be used in the current payment context. The strings that represent the networks in the array are identical to the strings that Apple uses in their documentation. For instance "Visa".
	 */
	public PaymentProduct302SpecificData withNetworks(List<String> value) {
		this.networks = value;
		return this;
	}
}
