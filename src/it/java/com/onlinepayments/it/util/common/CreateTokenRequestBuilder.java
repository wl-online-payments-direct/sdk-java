package com.onlinepayments.it.util.common;

import com.onlinepayments.domain.Card;
import com.onlinepayments.domain.CreateTokenRequest;
import com.onlinepayments.domain.TokenCardSpecificInput;
import com.onlinepayments.domain.TokenData;

public class CreateTokenRequestBuilder {

    private String cardNumber = "4567350000427977";
    private String cvv = "123";
    private String expiryDate = "1230";
    private String cardholderName = "John Doe";
    private Integer paymentProductId = 1;
    private String encryptedCustomerInput;
    private String cobrandSelectionIndicator;

    public CreateTokenRequestBuilder withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public CreateTokenRequestBuilder withCvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public CreateTokenRequestBuilder withExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public CreateTokenRequestBuilder withCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
        return this;
    }

    public CreateTokenRequestBuilder withPaymentProductId(Integer paymentProductId) {
        this.paymentProductId = paymentProductId;
        return this;
    }

    public CreateTokenRequestBuilder withEncryptedCustomerInput(String encryptedCustomerInput) {
        this.encryptedCustomerInput = encryptedCustomerInput;
        return this;
    }

    public CreateTokenRequestBuilder withCobrandSelectionIndicator(String cobrandSelectionIndicator) {
        this.cobrandSelectionIndicator = cobrandSelectionIndicator;
        return this;
    }

    public CreateTokenRequest build() {
        CreateTokenRequest request = new CreateTokenRequest()
                .withPaymentProductId(paymentProductId);

        if (encryptedCustomerInput != null) {
            request.withEncryptedCustomerInput(encryptedCustomerInput);
        } else {
            request.withCard(buildCardToken());
        }

        return request;
    }

    private TokenCardSpecificInput buildCardToken() {
        return new TokenCardSpecificInput()
            .withData(buildTokenData());
    }

    private TokenData buildTokenData() {
        TokenData tokenData = new TokenData()
                .withCard(buildCard());

        if (cobrandSelectionIndicator != null) {
            tokenData.withCobrandSelectionIndicator(cobrandSelectionIndicator);
        }

        return tokenData;
    }

    private Card buildCard() {
        return new Card()
            .withCardholderName(cardholderName)
            .withCvv(cvv)
            .withCardNumber(cardNumber)
            .withExpiryDate(expiryDate);
    }
}
