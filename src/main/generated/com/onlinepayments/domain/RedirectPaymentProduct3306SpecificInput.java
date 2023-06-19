/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing specific input required for Klarna payments (Payment product ID 3306)
 */
public class RedirectPaymentProduct3306SpecificInput {

	private String extraMerchantData = null;

	/**
	 * In some cases, Klarna require additional information regarding the customer and the purchase in order to make 
	 * a correct risk assessment. This information, called extra merchant data (EMD), may consist of data 
	 * about the customer performing the transaction, the product/services associated with the transaction, 
	 * or the seller and their affiliates.
	 */
	public String getExtraMerchantData() {
		return extraMerchantData;
	}

	/**
	 * In some cases, Klarna require additional information regarding the customer and the purchase in order to make 
	 * a correct risk assessment. This information, called extra merchant data (EMD), may consist of data 
	 * about the customer performing the transaction, the product/services associated with the transaction, 
	 * or the seller and their affiliates.
	 */
	public void setExtraMerchantData(String value) {
		this.extraMerchantData = value;
	}

	/**
	 * In some cases, Klarna require additional information regarding the customer and the purchase in order to make 
	 * a correct risk assessment. This information, called extra merchant data (EMD), may consist of data 
	 * about the customer performing the transaction, the product/services associated with the transaction, 
	 * or the seller and their affiliates.
	 */
	public RedirectPaymentProduct3306SpecificInput withExtraMerchantData(String value) {
		this.extraMerchantData = value;
		return this;
	}
}
