/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Result of a requested currency conversion
 */
public class CurrencyConversionResult {

	private String result = null;

	private String resultReason = null;

	/**
	 * Functional response to the request:
	 *  * Allowed: Dynamic currency conversion may be offered to the cardholder
	 *  * InvalidCard: The card is not valid for dynamic currency conversion
	 *  * InvalidMerchant: The card acceptor has not been recognised
	 *  * NoRate: Exchange rates are not available
	 *  * NotAvailable: Dynamic currency conversion is not available for other reason
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Functional response to the request:
	 *  * Allowed: Dynamic currency conversion may be offered to the cardholder
	 *  * InvalidCard: The card is not valid for dynamic currency conversion
	 *  * InvalidMerchant: The card acceptor has not been recognised
	 *  * NoRate: Exchange rates are not available
	 *  * NotAvailable: Dynamic currency conversion is not available for other reason
	 */
	public void setResult(String value) {
		this.result = value;
	}

	/**
	 * Functional response to the request:
	 *  * Allowed: Dynamic currency conversion may be offered to the cardholder
	 *  * InvalidCard: The card is not valid for dynamic currency conversion
	 *  * InvalidMerchant: The card acceptor has not been recognised
	 *  * NoRate: Exchange rates are not available
	 *  * NotAvailable: Dynamic currency conversion is not available for other reason
	 */
	public CurrencyConversionResult withResult(String value) {
		this.result = value;
		return this;
	}

	/**
	 * Plain text explaining the result of the currency conversion request
	 */
	public String getResultReason() {
		return resultReason;
	}

	/**
	 * Plain text explaining the result of the currency conversion request
	 */
	public void setResultReason(String value) {
		this.resultReason = value;
	}

	/**
	 * Plain text explaining the result of the currency conversion request
	 */
	public CurrencyConversionResult withResultReason(String value) {
		this.resultReason = value;
		return this;
	}
}
