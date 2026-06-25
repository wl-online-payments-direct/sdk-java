package com.onlinepayments.it.util.products;

import com.onlinepayments.merchant.products.GetProductDirectoryParams;

public class GetProductDirectoryParamsBuilder {
    private String countryCode = null;
    private String currencyCode = null;

    public GetProductDirectoryParamsBuilder withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public GetProductDirectoryParamsBuilder withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public GetProductDirectoryParams build() {
        GetProductDirectoryParams params = new GetProductDirectoryParams();

        if (countryCode != null) {
            params.withCountryCode(countryCode);
        }

        if (currencyCode != null) {
            params.withCurrencyCode(currencyCode);
        }

        return params;
    }
}
