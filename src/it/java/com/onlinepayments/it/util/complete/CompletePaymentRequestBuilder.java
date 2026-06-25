package com.onlinepayments.it.util.complete;

import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.CardWithoutCvv;
import com.onlinepayments.domain.CompletePaymentCardPaymentMethodSpecificInput;
import com.onlinepayments.domain.CompletePaymentRequest;
import com.onlinepayments.domain.Order;

public class CompletePaymentRequestBuilder {

    private long amount = 1000L;
    private String currency = "EUR";
    private String cardNumber;
    private String cardholderName;
    private String expiryDate;
    private Order orderOverride;
    private boolean useOrderOverride;

    public CompletePaymentRequestBuilder withAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public CompletePaymentRequestBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public CompletePaymentRequestBuilder withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public CompletePaymentRequestBuilder withCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
        return this;
    }

    public CompletePaymentRequestBuilder withExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public CompletePaymentRequestBuilder withOrder(Order order) {
        this.orderOverride = order;
        this.useOrderOverride = true;

        return this;
    }

    public CompletePaymentRequest build() {
        CompletePaymentRequest request = new CompletePaymentRequest()
                .withOrder(useOrderOverride ? orderOverride : buildOrder());

        if (cardNumber != null || cardholderName != null || expiryDate != null) {
            request.withCardPaymentMethodSpecificInput(buildCardPaymentMethodSpecificInput());
        }

        return request;
    }

    private Order buildOrder() {
        return new Order()
            .withAmountOfMoney(buildAmountOfMoney());
    }

    private AmountOfMoney buildAmountOfMoney() {
        return new AmountOfMoney()
            .withAmount(amount)
            .withCurrencyCode(currency);
    }

    private CompletePaymentCardPaymentMethodSpecificInput buildCardPaymentMethodSpecificInput() {
        return new CompletePaymentCardPaymentMethodSpecificInput()
            .withCard(buildCard());
    }

    private CardWithoutCvv buildCard() {
        CardWithoutCvv card = new CardWithoutCvv();

        if (cardNumber != null) {
            card.withCardNumber(cardNumber);
        }

        if (cardholderName != null) {
            card.withCardholderName(cardholderName);
        }

        if (expiryDate != null) {
            card.withExpiryDate(expiryDate);
        }

        return card;
    }
}
