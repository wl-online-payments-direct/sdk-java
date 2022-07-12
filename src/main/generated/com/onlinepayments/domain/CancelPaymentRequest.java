/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class CancelPaymentRequest {

	private AmountOfMoney amountOfMoney = null;

	private Boolean isFinal = null;

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getAmountOfMoney() {
		return amountOfMoney;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public CancelPaymentRequest withAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
		return this;
	}

	/**
	 * This property indicates whether this will be the final operation. The default value for this property is false.
	 */
	public Boolean getIsFinal() {
		return isFinal;
	}

	/**
	 * This property indicates whether this will be the final operation. The default value for this property is false.
	 */
	public void setIsFinal(Boolean value) {
		this.isFinal = value;
	}

	/**
	 * This property indicates whether this will be the final operation. The default value for this property is false.
	 */
	public CancelPaymentRequest withIsFinal(Boolean value) {
		this.isFinal = value;
		return this;
	}
}
