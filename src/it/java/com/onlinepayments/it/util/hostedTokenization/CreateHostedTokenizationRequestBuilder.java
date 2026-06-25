package com.onlinepayments.it.util.hostedTokenization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.onlinepayments.domain.CreateHostedTokenizationRequest;

public class CreateHostedTokenizationRequestBuilder {

    private Boolean askConsumerConsent = true;
    private String locale = "en_US";
    private List<String> tokens = new ArrayList<>();

    public CreateHostedTokenizationRequestBuilder withAskConsumerConsent(Boolean askConsumerConsent) {
        this.askConsumerConsent = askConsumerConsent;
        return this;
    }

    public CreateHostedTokenizationRequestBuilder withLocale(String locale) {
        this.locale = locale;
        return this;
    }

    public CreateHostedTokenizationRequestBuilder withToken(String token) {
        this.tokens.add(token);
        return this;
    }

    public CreateHostedTokenizationRequestBuilder withTokens(String... tokens) {
        this.tokens = Arrays.asList(tokens);
        return this;
    }

    public CreateHostedTokenizationRequest build() {
        return new CreateHostedTokenizationRequest()
                .withAskConsumerConsent(askConsumerConsent)
                .withLocale(locale)
                .withTokens(tokens.isEmpty() ? null : String.join(",", tokens));
    }
}
