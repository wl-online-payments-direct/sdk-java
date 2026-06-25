package com.onlinepayments.it.util.payments;

import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.RefundRequest;

public class RefundRequestBuilder {

    private long amount = 1000L;
    private String currency = "EUR";
    private Boolean isFinal;

    public RefundRequestBuilder withAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public RefundRequestBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public RefundRequestBuilder withIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
        return this;
    }

    public RefundRequest build() {
        AmountOfMoney amountOfMoney = new AmountOfMoney()
                .withAmount(amount)
                .withCurrencyCode(currency);

        RefundRequest request = new RefundRequest()
                .withAmountOfMoney(amountOfMoney);

        if (isFinal != null) {
            request.withIsFinal(isFinal);
        }

        return request;
    }
}
