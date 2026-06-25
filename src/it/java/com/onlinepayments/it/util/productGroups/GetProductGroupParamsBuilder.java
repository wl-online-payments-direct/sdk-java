package com.onlinepayments.it.util.productGroups;

import java.util.ArrayList;
import java.util.List;

import com.onlinepayments.merchant.productgroups.GetProductGroupParams;

public class GetProductGroupParamsBuilder {
    private String countryCode = null;
    private String currencyCode = null;
    private Long amount = null;
    private Boolean isRecurring = null;
    private List<String> addHideList = new ArrayList<>();
    private List<String> hideList = new ArrayList<>();

    public GetProductGroupParamsBuilder withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public GetProductGroupParamsBuilder withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public GetProductGroupParamsBuilder withAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public GetProductGroupParamsBuilder withIsRecurring(Boolean isRecurring) {
        this.isRecurring = isRecurring;
        return this;
    }

    public GetProductGroupParamsBuilder withAddHideList(List<String> addHideList) {
        this.addHideList = addHideList;
        return this;
    }

    public GetProductGroupParamsBuilder withHideList(List<String> hideList) {
        this.hideList = hideList;
        return this;
    }

    public GetProductGroupParams build() {
        GetProductGroupParams params = new GetProductGroupParams();

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

        if (!addHideList.isEmpty()) {
            for (String s : addHideList) {
                params.addHide(s);
            }
        }

        if (!hideList.isEmpty()) {
            params.withHide(hideList);
        }

        return params;
    }
}
