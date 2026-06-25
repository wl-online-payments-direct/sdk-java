package com.onlinepayments.it.util.services;

import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.CalculateSurchargeRequest;
import com.onlinepayments.domain.CardSource;
import com.onlinepayments.domain.SurchargeCalculationCard;

public class CalculateSurchargeRequestBuilder {

    private String cardNumber;
    private long amount = 1000L;
    private String currencyCode = "EUR";

    public CalculateSurchargeRequestBuilder withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public CalculateSurchargeRequestBuilder withAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public CalculateSurchargeRequestBuilder withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public CalculateSurchargeRequest build() {
        return new CalculateSurchargeRequest()
                .withCardSource(new CardSource()
                    .withCard(new SurchargeCalculationCard()
                        .withCardNumber(cardNumber)))
                .withAmountOfMoney(new AmountOfMoney()
                    .withAmount(amount)
                    .withCurrencyCode(currencyCode));
    }
}
