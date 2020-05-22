/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Kind of seller protection in force for the PayPal transaction
 */
public class ProtectionEligibility {

	private String eligibility = null;

	private String type = null;

	/**
	 * * Eligible - Merchant is protected by PayPal's Seller Protection Policy for Unauthorized Payment and Item Not Received
	 * * PartiallyEligible - Merchant is protected by PayPal's Seller Protection Policy for Item Not Received
	 * * Ineligible — Merchant is not protected under the Seller Protection Policy
	 */
	public String getEligibility() {
		return eligibility;
	}

	/**
	 * * Eligible - Merchant is protected by PayPal's Seller Protection Policy for Unauthorized Payment and Item Not Received
	 * * PartiallyEligible - Merchant is protected by PayPal's Seller Protection Policy for Item Not Received
	 * * Ineligible — Merchant is not protected under the Seller Protection Policy
	 */
	public void setEligibility(String value) {
		this.eligibility = value;
	}

	/**
	 * - ItemNotReceivedEligible - Merchant is protected by PayPal's Seller Protection Policy for Item Not Received
	 * - UnauthorizedPaymentEligible - Merchant is protected by PayPal's Seller Protection Policy for Unauthorized Payment
	 * - Ineligible - Merchant is not protected under the Seller Protection Policy
	 */
	public String getType() {
		return type;
	}

	/**
	 * - ItemNotReceivedEligible - Merchant is protected by PayPal's Seller Protection Policy for Item Not Received
	 * - UnauthorizedPaymentEligible - Merchant is protected by PayPal's Seller Protection Policy for Unauthorized Payment
	 * - Ineligible - Merchant is not protected under the Seller Protection Policy
	 */
	public void setType(String value) {
		this.type = value;
	}
}
