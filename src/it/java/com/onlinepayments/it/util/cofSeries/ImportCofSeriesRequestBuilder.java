package com.onlinepayments.it.util.cofSeries;

import com.onlinepayments.domain.CardDataWithoutCvv;
import com.onlinepayments.domain.ImportCofSeriesRequest;

public class ImportCofSeriesRequestBuilder {

    private String cardNumber = "4567350000427977";
    private String cardholderName = "John Doe";
    private String expiryDate = "1230";
    private String currencyCode = "EUR";
    private Integer paymentProductId = 1;
    private String schemeReferenceData = "test_scheme_reference";
    private String tokenId;
    private String transactionLinkIdentifier = null;

    public ImportCofSeriesRequestBuilder withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public ImportCofSeriesRequestBuilder withCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
        return this;
    }

    public ImportCofSeriesRequestBuilder withExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public ImportCofSeriesRequestBuilder withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public ImportCofSeriesRequestBuilder withPaymentProductId(Integer paymentProductId) {
        this.paymentProductId = paymentProductId;
        return this;
    }

    public ImportCofSeriesRequestBuilder withSchemeReferenceData(String schemeReferenceData) {
        this.schemeReferenceData = schemeReferenceData;
        return this;
    }

    public ImportCofSeriesRequestBuilder withTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public ImportCofSeriesRequestBuilder withTransactionLinkIdentifier(String transactionLinkIdentifier) {
        this.transactionLinkIdentifier = transactionLinkIdentifier;
        return this;
    }

    public ImportCofSeriesRequest build() {
        ImportCofSeriesRequest request = new ImportCofSeriesRequest()
                .withCurrencyCode(currencyCode)
                .withPaymentProductId(paymentProductId)
                .withSchemeReferenceData(schemeReferenceData);

        if (tokenId != null) {
            request.withTokenId(tokenId);
        } else {
            request.withCard(buildCard());
        }

        if (transactionLinkIdentifier != null) {
            request.withTransactionLinkIdentifier(transactionLinkIdentifier);
        }

        return request;
    }

    private CardDataWithoutCvv buildCard() {
        return new CardDataWithoutCvv()
            .withCardNumber(cardNumber)
            .withCardholderName(cardholderName)
            .withExpiryDate(expiryDate);
    }
}
