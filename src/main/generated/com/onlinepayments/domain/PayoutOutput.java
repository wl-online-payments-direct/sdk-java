/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class PayoutOutput {

	private AmountOfMoney amountOfMoney = null;

	private String payoutReason = null;

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
	public PayoutOutput withAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
		return this;
	}

	/**
	 * Allows you to additionally specify the reason for initiating the payout for authorization purposes. If this field is not specified, authorisation of the payment will be made according to your merchant profile. Possible values are:
	 *   * Gambling
	 *   * Refund
	 *   * Loyalty
	 */
	public String getPayoutReason() {
		return payoutReason;
	}

	/**
	 * Allows you to additionally specify the reason for initiating the payout for authorization purposes. If this field is not specified, authorisation of the payment will be made according to your merchant profile. Possible values are:
	 *   * Gambling
	 *   * Refund
	 *   * Loyalty
	 */
	public void setPayoutReason(String value) {
		this.payoutReason = value;
	}

	/**
	 * Allows you to additionally specify the reason for initiating the payout for authorization purposes. If this field is not specified, authorisation of the payment will be made according to your merchant profile. Possible values are:
	 *   * Gambling
	 *   * Refund
	 *   * Loyalty
	 */
	public PayoutOutput withPayoutReason(String value) {
		this.payoutReason = value;
		return this;
	}
}
