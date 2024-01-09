/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object to apply a discount to the total basket by adding a discount line.
 */
public class Discount {

	private Long amount = null;

	/**
	 * Amount in the smallest currency unit, i.e.:
	 * 
	 * * EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34
	 * 
	 * * KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234
	 * 
	 * * JPY is a zero-decimal currency, the value 1234 will result in JPY 1234
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * Amount in the smallest currency unit, i.e.:
	 * 
	 * * EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34
	 * 
	 * * KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234
	 * 
	 * * JPY is a zero-decimal currency, the value 1234 will result in JPY 1234
	 */
	public void setAmount(Long value) {
		this.amount = value;
	}

	/**
	 * Amount in the smallest currency unit, i.e.:
	 * 
	 * * EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34
	 * 
	 * * KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234
	 * 
	 * * JPY is a zero-decimal currency, the value 1234 will result in JPY 1234
	 */
	public Discount withAmount(Long value) {
		this.amount = value;
		return this;
	}
}
