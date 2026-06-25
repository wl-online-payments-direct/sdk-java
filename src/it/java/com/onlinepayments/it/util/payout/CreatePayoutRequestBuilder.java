package com.onlinepayments.it.util.payout;

import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.Card;
import com.onlinepayments.domain.CardPayoutMethodSpecificInput;
import com.onlinepayments.domain.CreatePayoutRequest;

public class CreatePayoutRequestBuilder {

    private long amount = 1000L;
    private String currencyCode = "EUR";

    private String cardNumber = "4012000033330026";
    private String cardholderName = "Wile E. Coyote";
    private String cvv = "123";
    private String expiryDate = "1230";

    private int paymentProductId = 1;
    private String payoutReason = "Refund";

    public CreatePayoutRequestBuilder withAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public CreatePayoutRequestBuilder withCurrency(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public CreatePayoutRequestBuilder withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public CreatePayoutRequestBuilder withCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
        return this;
    }

    public CreatePayoutRequestBuilder withCvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public CreatePayoutRequestBuilder withExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public CreatePayoutRequestBuilder withPaymentProductId(int paymentProductId) {
        this.paymentProductId = paymentProductId;
        return this;
    }

    public CreatePayoutRequestBuilder withPayoutReason(String payoutReason) {
        this.payoutReason = payoutReason;
        return this;
    }

    public CreatePayoutRequest build() {
        return new CreatePayoutRequest()
            .withAmountOfMoney(buildAmountOfMoney())
            .withCardPayoutMethodSpecificInput(buildCardPayoutMethodSpecificInput());
    }

    private AmountOfMoney buildAmountOfMoney() {
        return new AmountOfMoney()
            .withAmount(amount)
            .withCurrencyCode(currencyCode);
    }

    private CardPayoutMethodSpecificInput buildCardPayoutMethodSpecificInput() {
        return new CardPayoutMethodSpecificInput()
            .withCard(buildCard())
            .withPaymentProductId(paymentProductId)
            .withPayoutReason(payoutReason);
    }

    private Card buildCard() {
        return new Card()
            .withCardNumber(cardNumber)
            .withCardholderName(cardholderName)
            .withCvv(cvv)
            .withExpiryDate(expiryDate);
    }
}
