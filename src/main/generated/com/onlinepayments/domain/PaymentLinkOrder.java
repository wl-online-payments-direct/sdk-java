/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * An object containing the details of the related payment.
 */
public class PaymentLinkOrder {

	private AmountOfMoney amount = null;

	private String merchantReference = null;

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getAmount() {
		return amount;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setAmount(AmountOfMoney value) {
		this.amount = value;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public PaymentLinkOrder withAmount(AmountOfMoney value) {
		this.amount = value;
		return this;
	}

	/**
	 * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
	 * It is highly recommended to provide a single MerchantReference per unique order on your side
	 */
	public String getMerchantReference() {
		return merchantReference;
	}

	/**
	 * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
	 * It is highly recommended to provide a single MerchantReference per unique order on your side
	 */
	public void setMerchantReference(String value) {
		this.merchantReference = value;
	}

	/**
	 * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
	 * It is highly recommended to provide a single MerchantReference per unique order on your side
	 */
	public PaymentLinkOrder withMerchantReference(String value) {
		this.merchantReference = value;
		return this;
	}
}
