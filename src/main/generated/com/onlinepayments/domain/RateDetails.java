/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.math.BigDecimal;

public class RateDetails {

    private BigDecimal exchangeRate;

    private BigDecimal invertedExchangeRate;

    private BigDecimal markUpRate;

    private String quotationDateTime;

    private String source;

    /**
     * Expressed as a percentage, applied to convert the original amount into the resulting amount without charge
     */
    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Expressed as a percentage, applied to convert the original amount into the resulting amount without charge
     */
    public void setExchangeRate(BigDecimal value) {
        this.exchangeRate = value;
    }

    /**
     * Expressed as a percentage, applied to convert the original amount into the resulting amount without charge
     */
    public RateDetails withExchangeRate(BigDecimal value) {
        this.exchangeRate = value;
        return this;
    }

    /**
     * Exchange rate, expressed as a percentage, applied to convert the resulting amount into the original amount
     */
    public BigDecimal getInvertedExchangeRate() {
        return invertedExchangeRate;
    }

    /**
     * Exchange rate, expressed as a percentage, applied to convert the resulting amount into the original amount
     */
    public void setInvertedExchangeRate(BigDecimal value) {
        this.invertedExchangeRate = value;
    }

    /**
     * Exchange rate, expressed as a percentage, applied to convert the resulting amount into the original amount
     */
    public RateDetails withInvertedExchangeRate(BigDecimal value) {
        this.invertedExchangeRate = value;
        return this;
    }

    /**
     * The markup is the percentage added to the exchange rate by a provider when they sell you currency.
     */
    public BigDecimal getMarkUpRate() {
        return markUpRate;
    }

    /**
     * The markup is the percentage added to the exchange rate by a provider when they sell you currency.
     */
    public void setMarkUpRate(BigDecimal value) {
        this.markUpRate = value;
    }

    /**
     * The markup is the percentage added to the exchange rate by a provider when they sell you currency.
     */
    public RateDetails withMarkUpRate(BigDecimal value) {
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
