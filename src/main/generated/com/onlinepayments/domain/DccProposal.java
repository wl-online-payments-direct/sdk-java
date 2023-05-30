/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Details of currency conversion to be proposed to the cardholder
 */
public class DccProposal {

	private AmountOfMoney baseAmount = null;

	private String disclaimerDisplay = null;

	private String disclaimerReceipt = null;

	private RateDetails rate = null;

	private AmountOfMoney targetAmount = null;

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getBaseAmount() {
		return baseAmount;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setBaseAmount(AmountOfMoney value) {
		this.baseAmount = value;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public DccProposal withBaseAmount(AmountOfMoney value) {
		this.baseAmount = value;
		return this;
	}

	/**
	 * Card scheme disclaimer to present to the cardholder
	 */
	public String getDisclaimerDisplay() {
		return disclaimerDisplay;
	}

	/**
	 * Card scheme disclaimer to present to the cardholder
	 */
	public void setDisclaimerDisplay(String value) {
		this.disclaimerDisplay = value;
	}

	/**
	 * Card scheme disclaimer to present to the cardholder
	 */
	public DccProposal withDisclaimerDisplay(String value) {
		this.disclaimerDisplay = value;
		return this;
	}

	/**
	 * Card scheme disclaimer to print within cardholder receipt
	 */
	public String getDisclaimerReceipt() {
		return disclaimerReceipt;
	}

	/**
	 * Card scheme disclaimer to print within cardholder receipt
	 */
	public void setDisclaimerReceipt(String value) {
		this.disclaimerReceipt = value;
	}

	/**
	 * Card scheme disclaimer to print within cardholder receipt
	 */
	public DccProposal withDisclaimerReceipt(String value) {
		this.disclaimerReceipt = value;
		return this;
	}

	public RateDetails getRate() {
		return rate;
	}

	public void setRate(RateDetails value) {
		this.rate = value;
	}

	public DccProposal withRate(RateDetails value) {
		this.rate = value;
		return this;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getTargetAmount() {
		return targetAmount;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setTargetAmount(AmountOfMoney value) {
		this.targetAmount = value;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public DccProposal withTargetAmount(AmountOfMoney value) {
		this.targetAmount = value;
		return this;
	}
}
