/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class CreateHostedFieldsSessionRequest {

    private String locale;

    private List<String> tokens;

    /**
     * Locale used in the GUI towards the consumer.
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Locale used in the GUI towards the consumer.
     */
    public void setLocale(String value) {
        this.locale = value;
    }

    /**
     * Locale used in the GUI towards the consumer.
     */
    public CreateHostedFieldsSessionRequest withLocale(String value) {
        this.locale = value;
        return this;
    }

    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> value) {
        this.tokens = value;
    }

    public CreateHostedFieldsSessionRequest withTokens(List<String> value) {
        this.tokens = value;
        return this;
    }
}
