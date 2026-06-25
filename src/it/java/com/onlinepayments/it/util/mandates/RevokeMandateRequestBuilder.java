package com.onlinepayments.it.util.mandates;

import com.onlinepayments.domain.RevokeMandateRequest;

public class RevokeMandateRequestBuilder {

    private String revocationReason = "userAction";

    public RevokeMandateRequestBuilder withRevocationReason(String revocationReason) {
        this.revocationReason = revocationReason;
        return this;
    }

    public RevokeMandateRequest build() {
        return new RevokeMandateRequest()
                .withRevocationReason(revocationReason);
    }
}
