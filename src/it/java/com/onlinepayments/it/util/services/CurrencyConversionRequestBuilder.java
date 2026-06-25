package com.onlinepayments.it.util.services;

import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.CardInfo;
import com.onlinepayments.domain.CurrencyConversionRequest;
import com.onlinepayments.domain.DccCardSource;
import com.onlinepayments.domain.Transaction;

public class CurrencyConversionRequestBuilder {

    private String cardNumber;
    private long amount = 1000L;
    private String currencyCode = "EUR";

    public CurrencyConversionRequestBuilder withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public CurrencyConversionRequestBuilder withAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public CurrencyConversionRequestBuilder withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public CurrencyConversionRequest build() {
        return new CurrencyConversionRequest()
            .withCardSource(new DccCardSource()
                .withCard(new CardInfo()
                    .withCardNumber(cardNumber)))
            .withTransaction(new Transaction()
                .withAmount(new AmountOfMoney()
                    .withAmount(amount)
                    .withCurrencyCode(currencyCode)));
    }
}
