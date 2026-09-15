/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class CreateHostedFieldsSessionRequest {

    private String locale;

    private String origin;

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

    /**
     * merchant site's origin.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * merchant site's origin.
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    /**
     * merchant site's origin.
     */
    public CreateHostedFieldsSessionRequest withOrigin(String value) {
        this.origin = value;
        return this;
    }

    /**
     * These are your stored tokens that you can reuse during the session.
     */
    public List<String> getTokens() {
        return tokens;
    }

    /**
     * These are your stored tokens that you can reuse during the session.
     */
    public void setTokens(List<String> value) {
        this.tokens = value;
    }

    /**
     * These are your stored tokens that you can reuse during the session.
     */
    public CreateHostedFieldsSessionRequest withTokens(List<String> value) {
        this.tokens = value;
        return this;
    }
}
