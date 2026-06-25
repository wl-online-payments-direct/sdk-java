package com.onlinepayments.it.util.webhooks;

import com.onlinepayments.domain.ValidateCredentialsRequest;

public class ValidateCredentialsRequestBuilder {
    private String key = null;
    private String secret = null;

    public ValidateCredentialsRequestBuilder withKey(String key) {
        this.key = key;
        return this;
    }

    public ValidateCredentialsRequestBuilder withSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public ValidateCredentialsRequest build() {
        ValidateCredentialsRequest request = new ValidateCredentialsRequest();

        if (this.key != null) {
            request.setKey(this.key);
        }

        if (this.secret != null) {
            request.setSecret(this.secret);
        }

        return request;
    }
}
