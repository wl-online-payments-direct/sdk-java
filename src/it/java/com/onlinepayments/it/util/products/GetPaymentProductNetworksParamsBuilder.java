package com.onlinepayments.it.util.products;

import com.onlinepayments.merchant.products.GetPaymentProductNetworksParams;

public class GetPaymentProductNetworksParamsBuilder {
    private String countryCode = null;
    private String currencyCode = null;
    private Long amount = null;
    private Boolean isRecurring = null;

    public GetPaymentProductNetworksParamsBuilder withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public GetPaymentProductNetworksParamsBuilder withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public GetPaymentProductNetworksParamsBuilder withAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public GetPaymentProductNetworksParamsBuilder withIsRecurring(Boolean isRecurring) {
        this.isRecurring = isRecurring;
        return this;
    }

    public GetPaymentProductNetworksParams builder() {
        GetPaymentProductNetworksParams params = new GetPaymentProductNetworksParams();

        if (countryCode != null) {
            params.withCountryCode(countryCode);
        }

        if (currencyCode != null) {
            params.withCurrencyCode(currencyCode);
        }

        if (amount != null) {
            params.withAmount(amount);
        }

        if (isRecurring != null) {
            params.withIsRecurring(isRecurring);
        }

        return params;
    }
}
