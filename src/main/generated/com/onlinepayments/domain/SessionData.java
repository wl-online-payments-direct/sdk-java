/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class SessionData {

    private String hostedFieldsSessionId;

    private String locale;

    private String platformUrl;

    private String sessionToken;

    private List<String> tokens;

    /**
     * Id of the created session
     */
    public String getHostedFieldsSessionId() {
        return hostedFieldsSessionId;
    }

    /**
     * Id of the created session
     */
    public void setHostedFieldsSessionId(String value) {
        this.hostedFieldsSessionId = value;
    }

    /**
     * Id of the created session
     */
    public SessionData withHostedFieldsSessionId(String value) {
        this.hostedFieldsSessionId = value;
        return this;
    }

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
    public SessionData withLocale(String value) {
        this.locale = value;
        return this;
    }

    /**
     * This is the URL to Worldline's payment platform.
     */
    public String getPlatformUrl() {
        return platformUrl;
    }

    /**
     * This is the URL to Worldline's payment platform.
     */
    public void setPlatformUrl(String value) {
        this.platformUrl = value;
    }

    /**
     * This is the URL to Worldline's payment platform.
     */
    public SessionData withPlatformUrl(String value) {
        this.platformUrl = value;
        return this;
    }

    /**
     * The JWT token used to authorize calls between iframes and server
     */
    public String getSessionToken() {
        return sessionToken;
    }

    /**
     * The JWT token used to authorize calls between iframes and server
     */
    public void setSessionToken(String value) {
        this.sessionToken = value;
    }

    /**
     * The JWT token used to authorize calls between iframes and server
     */
    public SessionData withSessionToken(String value) {
        this.sessionToken = value;
        return this;
    }

    /**
     * This is a list of validated, previously stored card tokens available for use in this checkout session.
     */
    public List<String> getTokens() {
        return tokens;
    }

    /**
     * This is a list of validated, previously stored card tokens available for use in this checkout session.
     */
    public void setTokens(List<String> value) {
        this.tokens = value;
    }

    /**
     * This is a list of validated, previously stored card tokens available for use in this checkout session.
     */
    public SessionData withTokens(List<String> value) {
        this.tokens = value;
        return this;
    }
}
