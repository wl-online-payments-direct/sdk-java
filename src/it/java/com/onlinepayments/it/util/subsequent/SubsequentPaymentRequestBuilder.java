package com.onlinepayments.it.util.subsequent;

import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.Order;
import com.onlinepayments.domain.SubsequentCardPaymentMethodSpecificInput;
import com.onlinepayments.domain.SubsequentPaymentRequest;

public class SubsequentPaymentRequestBuilder {

    private long amount = 1000L;
    private String currency = "EUR";
    private String subsequentType = "Recurring";
    private String authorizationMode = "FINAL_AUTHORIZATION";

    public SubsequentPaymentRequestBuilder withAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public SubsequentPaymentRequestBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public SubsequentPaymentRequestBuilder withSubsequentType(String subsequentType) {
        this.subsequentType = subsequentType;
        return this;
    }

    public SubsequentPaymentRequestBuilder withAuthorizationMode(String authorizationMode) {
        this.authorizationMode = authorizationMode;
        return this;
    }

    public SubsequentPaymentRequest build() {
        Order order = new Order()
                .withAmountOfMoney(new AmountOfMoney()
                        .withAmount(amount)
                        .withCurrencyCode(currency));

        SubsequentCardPaymentMethodSpecificInput cardInput = new SubsequentCardPaymentMethodSpecificInput()
                .withSubsequentType(subsequentType)
                .withAuthorizationMode(authorizationMode);

        return new SubsequentPaymentRequest()
                .withOrder(order)
                .withSubsequentcardPaymentMethodSpecificInput(cardInput);
    }
}
