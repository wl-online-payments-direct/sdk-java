package com.onlinepayments.it.util.services;

import com.onlinepayments.domain.GetIINDetailsRequest;

public class GetIINDetailsRequestBuilder {

    private String bin = "401200";

    public GetIINDetailsRequestBuilder withBin(String bin) {
        this.bin = bin;
        return this;
    }

    public GetIINDetailsRequest build() {
        return new GetIINDetailsRequest()
                .withBin(bin);
    }
}
