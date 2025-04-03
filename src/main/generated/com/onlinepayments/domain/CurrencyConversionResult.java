/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CurrencyConversionResult {

    private String result;

    private String resultReason;

    /**
     * Functional response to the request:
     * <ul>
     *   <li>Allowed: Dynamic currency conversion may be offered to the cardholder</li>
     *   <li>InvalidCard: The card is not valid for dynamic currency conversion</li>
     *   <li>InvalidMerchant: The card acceptor has not been recognised</li>
     *   <li>NoRate: Exchange rates are not available</li>
     *   <li>NotAvailable: Dynamic currency conversion is not available for other reason</li>
     * </ul>
     */
    public String getResult() {
        return result;
    }

    /**
     * Functional response to the request:
     * <ul>
     *   <li>Allowed: Dynamic currency conversion may be offered to the cardholder</li>
     *   <li>InvalidCard: The card is not valid for dynamic currency conversion</li>
     *   <li>InvalidMerchant: The card acceptor has not been recognised</li>
     *   <li>NoRate: Exchange rates are not available</li>
     *   <li>NotAvailable: Dynamic currency conversion is not available for other reason</li>
     * </ul>
     */
    public void setResult(String value) {
        this.result = value;
    }

    /**
     * Functional response to the request:
     * <ul>
     *   <li>Allowed: Dynamic currency conversion may be offered to the cardholder</li>
     *   <li>InvalidCard: The card is not valid for dynamic currency conversion</li>
     *   <li>InvalidMerchant: The card acceptor has not been recognised</li>
     *   <li>NoRate: Exchange rates are not available</li>
     *   <li>NotAvailable: Dynamic currency conversion is not available for other reason</li>
     * </ul>
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
