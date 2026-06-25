package com.onlinepayments.it.util.products;

import java.util.ArrayList;
import java.util.List;

import com.onlinepayments.merchant.products.GetPaymentProductsParams;

public class GetPaymentProductsParamsBuilder {
    private String countryCode = null;
    private String currencyCode = null;
    private String locale = null;
    private Long amount = null;
    private Boolean isRecurring = null;
    private List<String> addHideList = new ArrayList<>();
    private List<String> hideList = new ArrayList<>();
    private String operationType = null;

    public GetPaymentProductsParamsBuilder withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public GetPaymentProductsParamsBuilder withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public GetPaymentProductsParamsBuilder withLocale(String locale) {
        this.locale = locale;
        return this;
    }

    public GetPaymentProductsParamsBuilder withAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public GetPaymentProductsParamsBuilder withIsRecurring(Boolean isRecurring) {
        this.isRecurring = isRecurring;
        return this;
    }

    public GetPaymentProductsParamsBuilder withAddHideList(List<String> addHideList) {
        this.addHideList = addHideList;
        return this;
    }

    public GetPaymentProductsParamsBuilder withHideList(List<String> hideList) {
        this.hideList = hideList;
        return this;
    }

    public GetPaymentProductsParamsBuilder withOperationType(String operationType) {
        this.operationType = operationType;
        return this;
    }

    public GetPaymentProductsParams build() {
        GetPaymentProductsParams params = new GetPaymentProductsParams();

        if (countryCode != null) {
            params.withCountryCode(countryCode);
        }

        if (currencyCode != null) {
            params.withCurrencyCode(currencyCode);
        }

        if (locale != null) {
            params.withLocale(locale);
        }

        if (amount != null) {
            params.withAmount(amount);
        }

        if (isRecurring != null) {
            params.withIsRecurring(isRecurring);
        }

        if (!addHideList.isEmpty()) {
            for (String s : addHideList) {
                params.addHide(s);
            }
        }

        if (!hideList.isEmpty()) {
            params.withHide(hideList);
        }

        if (operationType != null) {
            params.withOperationType(operationType);
        }

        return params;
    }
}
