package com.onlinepayments.it.util.payments;

import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.CancelPaymentRequest;

public class CancelPaymentRequestBuilder {

    private Long amount;
    private String currency;
    private Boolean isFinal;

    public CancelPaymentRequestBuilder withAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public CancelPaymentRequestBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public CancelPaymentRequestBuilder withIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
        return this;
    }

    public CancelPaymentRequest build() {
        CancelPaymentRequest request = new CancelPaymentRequest();

        if (amount != null && currency != null) {
            AmountOfMoney amountOfMoney = new AmountOfMoney()
                    .withAmount(amount)
                    .withCurrencyCode(currency);
            request.withAmountOfMoney(amountOfMoney);
        }

        if (isFinal != null) {
            request.withIsFinal(isFinal);
        }

        return request;
    }
}
