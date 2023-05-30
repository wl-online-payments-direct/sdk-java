/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class RateDetails {

	private Float exchangeRate = null;

	private Float invertedExchangeRate = null;

	private Float markUpRate = null;

	private String quotationDateTime = null;

	private String source = null;

	/**
	 * Expressed as a percentage, applied to convert the original amount into the resulting amount without charge
	 */
	public Float getExchangeRate() {
		return exchangeRate;
	}

	/**
	 * Expressed as a percentage, applied to convert the original amount into the resulting amount without charge
	 */
	public void setExchangeRate(Float value) {
		this.exchangeRate = value;
	}

	/**
	 * Expressed as a percentage, applied to convert the original amount into the resulting amount without charge
	 */
	public RateDetails withExchangeRate(Float value) {
		this.exchangeRate = value;
		return this;
	}

	/**
	 * Exchange rate, expressed as a percentage, applied to convert the resulting amount into the original amount
	 */
	public Float getInvertedExchangeRate() {
		return invertedExchangeRate;
	}

	/**
	 * Exchange rate, expressed as a percentage, applied to convert the resulting amount into the original amount
	 */
	public void setInvertedExchangeRate(Float value) {
		this.invertedExchangeRate = value;
	}

	/**
	 * Exchange rate, expressed as a percentage, applied to convert the resulting amount into the original amount
	 */
	public RateDetails withInvertedExchangeRate(Float value) {
		this.invertedExchangeRate = value;
		return this;
	}

	/**
	 * The markup is the percentage added to the exchange rate by a provider when they sell you currency.
	 */
	public Float getMarkUpRate() {
		return markUpRate;
	}

	/**
	 * The markup is the percentage added to the exchange rate by a provider when they sell you currency.
	 */
	public void setMarkUpRate(Float value) {
		this.markUpRate = value;
	}

	/**
	 * The markup is the percentage added to the exchange rate by a provider when they sell you currency.
	 */
	public RateDetails withMarkUpRate(Float value) {
		this.markUpRate = value;
		return this;
	}

	/**
	 * Date and time at which the exchange rate has been quoted
	 */
	public String getQuotationDateTime() {
		return quotationDateTime;
	}

	/**
	 * Date and time at which the exchange rate has been quoted
	 */
	public void setQuotationDateTime(String value) {
		this.quotationDateTime = value;
	}

	/**
	 * Date and time at which the exchange rate has been quoted
	 */
	public RateDetails withQuotationDateTime(String value) {
		this.quotationDateTime = value;
		return this;
	}

	/**
	 * Indicates the exchange rate source name. The rate source is supplied for receipt printing purposes and to meet regulatory requirements where applicable
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Indicates the exchange rate source name. The rate source is supplied for receipt printing purposes and to meet regulatory requirements where applicable
	 */
	public void setSource(String value) {
		this.source = value;
	}

	/**
	 * Indicates the exchange rate source name. The rate source is supplied for receipt printing purposes and to meet regulatory requirements where applicable
	 */
	public RateDetails withSource(String value) {
		this.source = value;
		return this;
	}
}
