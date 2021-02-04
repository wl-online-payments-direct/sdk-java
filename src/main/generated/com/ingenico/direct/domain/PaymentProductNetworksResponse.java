/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

import java.util.List;

/**
 * Array containing network entries for a payment product. The strings that represent the networks in the array are identical to the strings that the payment product vendors use in their documentation. For instance: "Visa" for Apple Pay, and "VISA" for Google Pay.
 */
public class PaymentProductNetworksResponse {

	private List<String> networks = null;

	/**
	 * Array containing network entries for a payment product. The strings that represent the networks in the array are identical to the strings that the payment product vendors use in their documentation. For instance: "Visa" for Apple Pay, and "VISA" for Google Pay.
	 */
	public List<String> getNetworks() {
		return networks;
	}

	/**
	 * Array containing network entries for a payment product. The strings that represent the networks in the array are identical to the strings that the payment product vendors use in their documentation. For instance: "Visa" for Apple Pay, and "VISA" for Google Pay.
	 */
	public void setNetworks(List<String> value) {
		this.networks = value;
	}
}
