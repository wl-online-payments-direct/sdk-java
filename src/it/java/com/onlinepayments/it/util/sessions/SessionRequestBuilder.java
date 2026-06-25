package com.onlinepayments.it.util.sessions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.onlinepayments.domain.SessionRequest;

public class SessionRequestBuilder {

    private List<String> tokens = new ArrayList<>();

    public SessionRequestBuilder() {
    }

    public SessionRequestBuilder withToken(String token) {
        this.tokens.add(token);
        return this;
    }

    public SessionRequestBuilder withTokens(String... tokens) {
        this.tokens = Arrays.asList(tokens);
        return this;
    }

    public SessionRequest build() {
        return new SessionRequest()
                .withTokens(tokens.isEmpty() ? null : tokens);
    }
}
