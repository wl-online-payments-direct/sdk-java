/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class RefundCardMethodSpecificOutput {

	private CurrencyConversion currencyConversion = null;

	private Long totalAmountPaid = null;

	private Long totalAmountRefunded = null;

	public CurrencyConversion getCurrencyConversion() {
		return currencyConversion;
	}

	public void setCurrencyConversion(CurrencyConversion value) {
		this.currencyConversion = value;
	}

	public RefundCardMethodSpecificOutput withCurrencyConversion(CurrencyConversion value) {
		this.currencyConversion = value;
		return this;
	}

	public Long getTotalAmountPaid() {
		return totalAmountPaid;
	}

	public void setTotalAmountPaid(Long value) {
		this.totalAmountPaid = value;
	}

	public RefundCardMethodSpecificOutput withTotalAmountPaid(Long value) {
		this.totalAmountPaid = value;
		return this;
	}

	public Long getTotalAmountRefunded() {
		return totalAmountRefunded;
	}

	public void setTotalAmountRefunded(Long value) {
		this.totalAmountRefunded = value;
	}

	public RefundCardMethodSpecificOutput withTotalAmountRefunded(Long value) {
		this.totalAmountRefunded = value;
		return this;
	}
}
