/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class Surcharge {

	private AmountOfMoney netAmount = null;

	private Integer paymentProductId = null;

	private String result = null;

	private AmountOfMoney surchargeAmount = null;

	private SurchargeRate surchargeRate = null;

	private AmountOfMoney totalAmount = null;

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getNetAmount() {
		return netAmount;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setNetAmount(AmountOfMoney value) {
		this.netAmount = value;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public Surcharge withNetAmount(AmountOfMoney value) {
		this.netAmount = value;
		return this;
	}

	/**
	 * Payment product identifier - Please see Products documentation for a full overview of possible values.
	 */
	public Integer getPaymentProductId() {
		return paymentProductId;
	}

	/**
	 * Payment product identifier - Please see Products documentation for a full overview of possible values.
	 */
	public void setPaymentProductId(Integer value) {
		this.paymentProductId = value;
	}

	/**
	 * Payment product identifier - Please see Products documentation for a full overview of possible values.
	 */
	public Surcharge withPaymentProductId(Integer value) {
		this.paymentProductId = value;
		return this;
	}

	/**
	 * Token describing result. OK - A Surcharge Amount was successfully calculated, NO_SURCHARGE - A configured surcharge rate could not be found for the payment product
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Token describing result. OK - A Surcharge Amount was successfully calculated, NO_SURCHARGE - A configured surcharge rate could not be found for the payment product
	 */
	public void setResult(String value) {
		this.result = value;
	}

	/**
	 * Token describing result. OK - A Surcharge Amount was successfully calculated, NO_SURCHARGE - A configured surcharge rate could not be found for the payment product
	 */
	public Surcharge withResult(String value) {
		this.result = value;
		return this;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getSurchargeAmount() {
		return surchargeAmount;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setSurchargeAmount(AmountOfMoney value) {
		this.surchargeAmount = value;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public Surcharge withSurchargeAmount(AmountOfMoney value) {
		this.surchargeAmount = value;
		return this;
	}

	/**
	 * A summary of surcharge details used in the calculation of the surcharge amount. null if result = NO_SURCHARGE
	 */
	public SurchargeRate getSurchargeRate() {
		return surchargeRate;
	}

	/**
	 * A summary of surcharge details used in the calculation of the surcharge amount. null if result = NO_SURCHARGE
	 */
	public void setSurchargeRate(SurchargeRate value) {
		this.surchargeRate = value;
	}

	/**
	 * A summary of surcharge details used in the calculation of the surcharge amount. null if result = NO_SURCHARGE
	 */
	public Surcharge withSurchargeRate(SurchargeRate value) {
		this.surchargeRate = value;
		return this;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getTotalAmount() {
		return totalAmount;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setTotalAmount(AmountOfMoney value) {
		this.totalAmount = value;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public Surcharge withTotalAmount(AmountOfMoney value) {
		this.totalAmount = value;
		return this;
	}
}
