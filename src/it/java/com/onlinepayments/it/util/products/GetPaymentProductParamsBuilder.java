package com.onlinepayments.it.util.products;

import java.util.ArrayList;
import java.util.List;

import com.onlinepayments.merchant.products.GetPaymentProductParams;

public class GetPaymentProductParamsBuilder {
    private String countryCode = null;
    private String currencyCode = null;
    private String locale = null;
    private Long amount = null;
    private Boolean isRecurring = null;
    private List<String> addHideList = new ArrayList<>();
    private List<String> hideList = new ArrayList<>();
    private String operationType = null;

    public GetPaymentProductParamsBuilder withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public GetPaymentProductParamsBuilder withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public GetPaymentProductParamsBuilder withLocale(String locale) {
        this.locale = locale;
        return this;
    }

    public GetPaymentProductParamsBuilder withAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public GetPaymentProductParamsBuilder withIsRecurring(Boolean isRecurring) {
        this.isRecurring = isRecurring;
        return this;
    }

    public GetPaymentProductParamsBuilder withAddHideList(List<String> addHideList) {
        this.addHideList = addHideList;
        return this;
    }

    public GetPaymentProductParamsBuilder withHideList(List<String> hideList) {
        this.hideList = hideList;
        return this;
    }

    public GetPaymentProductParamsBuilder withOperationType(String operationType) {
        this.operationType = operationType;
        return this;
    }

    public GetPaymentProductParams build() {
        GetPaymentProductParams params = new GetPaymentProductParams();

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
