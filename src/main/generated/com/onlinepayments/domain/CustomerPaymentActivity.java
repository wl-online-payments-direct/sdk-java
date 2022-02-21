/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing data on the purchase history of the customer with you
 */
public class CustomerPaymentActivity {

	private Integer numberOfPaymentAttemptsLast24Hours = null;

	private Integer numberOfPaymentAttemptsLastYear = null;

	private Integer numberOfPurchasesLast6Months = null;

	/**
	 * Number of payment attempts (so including unsuccessful ones) made by this customer with you in the last 24 hours
	 */
	public Integer getNumberOfPaymentAttemptsLast24Hours() {
		return numberOfPaymentAttemptsLast24Hours;
	}

	/**
	 * Number of payment attempts (so including unsuccessful ones) made by this customer with you in the last 24 hours
	 */
	public void setNumberOfPaymentAttemptsLast24Hours(Integer value) {
		this.numberOfPaymentAttemptsLast24Hours = value;
	}

	/**
	 * Number of payment attempts (so including unsuccessful ones) made by this customer with you in the last 24 hours
	 */
	public CustomerPaymentActivity withNumberOfPaymentAttemptsLast24Hours(Integer value) {
		this.numberOfPaymentAttemptsLast24Hours = value;
		return this;
	}

	/**
	 * Number of payment attempts (so including unsuccessful ones) made by this customer with you in the last 12 months
	 */
	public Integer getNumberOfPaymentAttemptsLastYear() {
		return numberOfPaymentAttemptsLastYear;
	}

	/**
	 * Number of payment attempts (so including unsuccessful ones) made by this customer with you in the last 12 months
	 */
	public void setNumberOfPaymentAttemptsLastYear(Integer value) {
		this.numberOfPaymentAttemptsLastYear = value;
	}

	/**
	 * Number of payment attempts (so including unsuccessful ones) made by this customer with you in the last 12 months
	 */
	public CustomerPaymentActivity withNumberOfPaymentAttemptsLastYear(Integer value) {
		this.numberOfPaymentAttemptsLastYear = value;
		return this;
	}

	/**
	 * Number of successful purchases made by this customer with you in the last 6 months
	 */
	public Integer getNumberOfPurchasesLast6Months() {
		return numberOfPurchasesLast6Months;
	}

	/**
	 * Number of successful purchases made by this customer with you in the last 6 months
	 */
	public void setNumberOfPurchasesLast6Months(Integer value) {
		this.numberOfPurchasesLast6Months = value;
	}

	/**
	 * Number of successful purchases made by this customer with you in the last 6 months
	 */
	public CustomerPaymentActivity withNumberOfPurchasesLast6Months(Integer value) {
		this.numberOfPurchasesLast6Months = value;
		return this;
	}
}
