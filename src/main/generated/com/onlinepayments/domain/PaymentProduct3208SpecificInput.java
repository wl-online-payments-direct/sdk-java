/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing specific input required for OneyDuplo Leroy Merlin payments.
 */
public class PaymentProduct3208SpecificInput {

	private String merchantFinanceCode = null;

	/**
	 * This field indicates the finance code provided by the merchant after the buyer has selected the proper financing option.
	 */
	public String getMerchantFinanceCode() {
		return merchantFinanceCode;
	}

	/**
	 * This field indicates the finance code provided by the merchant after the buyer has selected the proper financing option.
	 */
	public void setMerchantFinanceCode(String value) {
		this.merchantFinanceCode = value;
	}

	/**
	 * This field indicates the finance code provided by the merchant after the buyer has selected the proper financing option.
	 */
	public PaymentProduct3208SpecificInput withMerchantFinanceCode(String value) {
		this.merchantFinanceCode = value;
		return this;
	}
}
