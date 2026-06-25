package com.onlinepayments.it.util.products;

import com.onlinepayments.domain.PaymentProductSession302SpecificInput;
import com.onlinepayments.domain.PaymentProductSessionRequest;

public class PaymentProductSessionRequestBuilder {

    private String displayName = "Test Merchant";
    private String domainName = "example.com";

    public PaymentProductSessionRequestBuilder withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public PaymentProductSessionRequestBuilder withDomainName(String domainName) {
        this.domainName = domainName;
        return this;
    }

    public PaymentProductSessionRequest build() {
        return new PaymentProductSessionRequest()
                .withPaymentProductSession302SpecificInput(
                        new PaymentProductSession302SpecificInput()
                                .withDisplayName(displayName)
                                .withDomainName(domainName));
    }
}
