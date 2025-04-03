/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.products;

import java.util.ArrayList;
import java.util.List;

import com.onlinepayments.communication.ParamRequest;
import com.onlinepayments.communication.RequestParam;

/**
 * Query parameters for
 * Get payment product networks (/v2/{merchantId}/products/{paymentProductId}/networks)
 */
public class GetPaymentProductNetworksParams implements ParamRequest {

    private String countryCode;

    private String currencyCode;

    private Long amount;

    private Boolean isRecurring;

    /**
     * ISO 3166-1 alpha-2 country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * ISO 3166-1 alpha-2 country code
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * ISO 3166-1 alpha-2 country code
     */
    public GetPaymentProductNetworksParams withCountryCode(String value) {
        this.countryCode = value;
        return this;
    }

    /**
     * Three-letter ISO currency code representing the currency for the amount
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Three-letter ISO currency code representing the currency for the amount
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Three-letter ISO currency code representing the currency for the amount
     */
    public GetPaymentProductNetworksParams withCurrencyCode(String value) {
        this.currencyCode = value;
        return this;
    }

    /**
     * Amount in cents and always having 2 decimals
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * Amount in cents and always having 2 decimals
     */
    public void setAmount(Long value) {
        this.amount = value;
    }

    /**
     * Amount in cents and always having 2 decimals
     */
    public GetPaymentProductNetworksParams withAmount(Long value) {
        this.amount = value;
        return this;
    }

    /**
     * This allows you to filter networks based on their support for recurring or not
     * <ul>
     *   <li>true</li>
     *   <li>false</li>
     * </ul>
     */
    public Boolean getIsRecurring() {
        return isRecurring;
    }

    /**
     * This allows you to filter networks based on their support for recurring or not
     * <ul>
     *   <li>true</li>
     *   <li>false</li>
     * </ul>
     */
    public void setIsRecurring(Boolean value) {
        this.isRecurring = value;
    }

    /**
     * This allows you to filter networks based on their support for recurring or not
     * <ul>
     *   <li>true</li>
     *   <li>false</li>
     * </ul>
     */
    public GetPaymentProductNetworksParams withIsRecurring(Boolean value) {
        this.isRecurring = value;
        return this;
    }

    @Override
    public List<RequestParam> toRequestParameters() {
        List<RequestParam> result = new ArrayList<>();
        if (countryCode != null) {
            result.add(new RequestParam("countryCode", countryCode));
        }
        if (currencyCode != null) {
            result.add(new RequestParam("currencyCode", currencyCode));
        }
        if (amount != null) {
            result.add(new RequestParam("amount", amount.toString()));
        }
        if (isRecurring != null) {
            result.add(new RequestParam("isRecurring", isRecurring.toString()));
        }
        return result;
    }
}
