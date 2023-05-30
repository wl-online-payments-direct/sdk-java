/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Payload of the response to a rate inquiry request
 */
public class CurrencyConversionResponse {

	private String dccSessionId = null;

	private DccProposal proposal = null;

	private CurrencyConversionResult result = null;

	/**
	 * The identifier of the Dynamic Currency Conversion(DCC) session that has been created.
	 */
	public String getDccSessionId() {
		return dccSessionId;
	}

	/**
	 * The identifier of the Dynamic Currency Conversion(DCC) session that has been created.
	 */
	public void setDccSessionId(String value) {
		this.dccSessionId = value;
	}

	/**
	 * The identifier of the Dynamic Currency Conversion(DCC) session that has been created.
	 */
	public CurrencyConversionResponse withDccSessionId(String value) {
		this.dccSessionId = value;
		return this;
	}

	/**
	 * Details of currency conversion to be proposed to the cardholder
	 */
	public DccProposal getProposal() {
		return proposal;
	}

	/**
	 * Details of currency conversion to be proposed to the cardholder
	 */
	public void setProposal(DccProposal value) {
		this.proposal = value;
	}

	/**
	 * Details of currency conversion to be proposed to the cardholder
	 */
	public CurrencyConversionResponse withProposal(DccProposal value) {
		this.proposal = value;
		return this;
	}

	/**
	 * Result of a requested currency conversion
	 */
	public CurrencyConversionResult getResult() {
		return result;
	}

	/**
	 * Result of a requested currency conversion
	 */
	public void setResult(CurrencyConversionResult value) {
		this.result = value;
	}

	/**
	 * Result of a requested currency conversion
	 */
	public CurrencyConversionResponse withResult(CurrencyConversionResult value) {
		this.result = value;
		return this;
	}
}
