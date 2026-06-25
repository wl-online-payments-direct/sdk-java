package com.onlinepayments.it.util.hostedFields;

import java.util.List;

import com.onlinepayments.domain.CreateHostedFieldsSessionRequest;

public class CreateHostedFieldsSessionRequestBuilder {

    private String locale = "en_US";
    private List<String> tokens = null;

    public CreateHostedFieldsSessionRequestBuilder withLocale(String locale) {
        this.locale = locale;
        return this;
    }

    public CreateHostedFieldsSessionRequestBuilder withTokens(List<String> tokens) {
        this.tokens = tokens;
        return this;
    }

    public CreateHostedFieldsSessionRequest build() {
        CreateHostedFieldsSessionRequest request = new CreateHostedFieldsSessionRequest()
                .withLocale(locale);

        if (tokens != null) {
            request.withTokens(tokens);
        }

        return request;
    }
}
