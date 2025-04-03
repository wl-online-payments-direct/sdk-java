/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CurrencyConversionResponse {

    private String dccSessionId;

    private DccProposal proposal;

    private CurrencyConversionResult result;

    /**
     * The identifier of the Dynamic Currency Conversion(DCC) session that has been created. 'dccSessionId' will be populated exclusively when the result is &quot;Allowed&quot; for other outcomes such as &quot;InvalidCard&quot;, &quot;InvalidMerchant&quot;, &quot;NoRate&quot; or &quot;NotAvailable&quot; this field value will be an empty string.
     */
    public String getDccSessionId() {
        return dccSessionId;
    }

    /**
     * The identifier of the Dynamic Currency Conversion(DCC) session that has been created. 'dccSessionId' will be populated exclusively when the result is &quot;Allowed&quot; for other outcomes such as &quot;InvalidCard&quot;, &quot;InvalidMerchant&quot;, &quot;NoRate&quot; or &quot;NotAvailable&quot; this field value will be an empty string.
     */
    public void setDccSessionId(String value) {
        this.dccSessionId = value;
    }

    /**
     * The identifier of the Dynamic Currency Conversion(DCC) session that has been created. 'dccSessionId' will be populated exclusively when the result is &quot;Allowed&quot; for other outcomes such as &quot;InvalidCard&quot;, &quot;InvalidMerchant&quot;, &quot;NoRate&quot; or &quot;NotAvailable&quot; this field value will be an empty string.
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
