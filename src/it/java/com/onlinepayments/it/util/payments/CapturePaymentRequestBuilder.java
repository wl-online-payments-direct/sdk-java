package com.onlinepayments.it.util.payments;

import com.onlinepayments.domain.CapturePaymentRequest;

public class CapturePaymentRequestBuilder {

    private Long amount;
    private Boolean isFinal;

    public CapturePaymentRequestBuilder withAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public CapturePaymentRequestBuilder withIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
        return this;
    }

    public CapturePaymentRequest build() {
        CapturePaymentRequest request = new CapturePaymentRequest();

        if (amount != null) {
            request.withAmount(amount);
        }

        if (isFinal != null) {
            request.withIsFinal(isFinal);
        }

        return request;
    }
}
