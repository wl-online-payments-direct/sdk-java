package com.onlinepayments.it.util.paymentLink;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.CreatePaymentLinkRequest;
import com.onlinepayments.domain.Order;
import com.onlinepayments.domain.OrderReferences;
import com.onlinepayments.domain.PaymentLinkSpecificInput;

public class CreatePaymentLinkRequestBuilder {

    private long amount = 1000L;
    private String currencyCode = "EUR";

    private boolean displayQRCode = true;
    private boolean reusableLink = true;

    private ZonedDateTime expirationDate;
    private String description = "Test payment link";
    private String recipientName = "Wile E. Coyote";
    private String merchantReference;

    public CreatePaymentLinkRequestBuilder() {
        this.expirationDate = ZonedDateTime.now(ZoneOffset.UTC).plusDays(7);
        this.merchantReference = generateMerchantReference();
    }

    public CreatePaymentLinkRequestBuilder withAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public CreatePaymentLinkRequestBuilder withCurrency(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public CreatePaymentLinkRequestBuilder withDisplayQRCode(boolean displayQRCode) {
        this.displayQRCode = displayQRCode;
        return this;
    }

    public CreatePaymentLinkRequestBuilder withReusableLink(boolean reusableLink) {
        this.reusableLink = reusableLink;
        return this;
    }

    public CreatePaymentLinkRequestBuilder withExpirationDate(ZonedDateTime expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public CreatePaymentLinkRequestBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CreatePaymentLinkRequestBuilder withRecipientName(String recipientName) {
        this.recipientName = recipientName;
        return this;
    }

    public CreatePaymentLinkRequestBuilder withMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    public CreatePaymentLinkRequest build() {
        return new CreatePaymentLinkRequest()
            .withOrder(buildOrder())
            .withDisplayQRCode(displayQRCode)
            .withIsReusableLink(reusableLink)
            .withPaymentLinkSpecificInput(buildPaymentLinkSpecificInput());
    }

    private Order buildOrder() {
        return new Order()
            .withAmountOfMoney(buildAmountOfMoney())
            .withReferences(buildOrderReferences());
    }

    private AmountOfMoney buildAmountOfMoney() {
        return new AmountOfMoney()
            .withAmount(amount)
            .withCurrencyCode(currencyCode);
    }

    private OrderReferences buildOrderReferences() {
        return new OrderReferences()
            .withMerchantReference(merchantReference);
    }

    private PaymentLinkSpecificInput buildPaymentLinkSpecificInput() {
        return new PaymentLinkSpecificInput()
            .withDescription(description)
            .withExpirationDate(expirationDate)
            .withRecipientName(recipientName);
    }

    private String generateMerchantReference() {
        return "Ref-" + java.util.UUID.randomUUID();
    }
}
