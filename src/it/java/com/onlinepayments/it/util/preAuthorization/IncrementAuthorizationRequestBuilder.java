package com.onlinepayments.it.util.preAuthorization;

import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.IncrementAuthorizationRequest;

public class IncrementAuthorizationRequestBuilder {

    private long amount = 1500L;
    private String currency = "EUR";

    public IncrementAuthorizationRequestBuilder withAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public IncrementAuthorizationRequestBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public IncrementAuthorizationRequest build() {
        return new IncrementAuthorizationRequest()
            .withAmountOfMoney(new AmountOfMoney()
                .withAmount(amount)
                .withCurrencyCode(currency));
    }
}
