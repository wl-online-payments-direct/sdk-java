/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class CreateHostedFieldsSessionResponse {

    private List<String> invalidTokens;

    private String sdkSri;

    private String sdkUrl;

    private SessionData sessionData;

    /**
     * This is a list of tokens that failed validation.
     */
    public List<String> getInvalidTokens() {
        return invalidTokens;
    }

    /**
     * This is a list of tokens that failed validation.
     */
    public void setInvalidTokens(List<String> value) {
        this.invalidTokens = value;
    }

    /**
     * This is a list of tokens that failed validation.
     */
    public CreateHostedFieldsSessionResponse withInvalidTokens(List<String> value) {
        this.invalidTokens = value;
        return this;
    }

    /**
     * This is the cryptographic hash used for Subresource Integrity validation.
     */
    public String getSdkSri() {
        return sdkSri;
    }

    /**
     * This is the cryptographic hash used for Subresource Integrity validation.
     */
    public void setSdkSri(String value) {
        this.sdkSri = value;
    }

    /**
     * This is the cryptographic hash used for Subresource Integrity validation.
     */
    public CreateHostedFieldsSessionResponse withSdkSri(String value) {
        this.sdkSri = value;
        return this;
    }

    /**
     * The URL points to the hosted fields SDK.
     */
    public String getSdkUrl() {
        return sdkUrl;
    }

    /**
     * The URL points to the hosted fields SDK.
     */
    public void setSdkUrl(String value) {
        this.sdkUrl = value;
    }

    /**
     * The URL points to the hosted fields SDK.
     */
    public CreateHostedFieldsSessionResponse withSdkUrl(String value) {
        this.sdkUrl = value;
        return this;
    }

    /**
     * This contains the data required to initialize the Hosted Fields SDK.
     */
    public SessionData getSessionData() {
        return sessionData;
    }

    /**
     * This contains the data required to initialize the Hosted Fields SDK.
     */
    public void setSessionData(SessionData value) {
        this.sessionData = value;
    }

    /**
     * This contains the data required to initialize the Hosted Fields SDK.
     */
    public CreateHostedFieldsSessionResponse withSessionData(SessionData value) {
        this.sessionData = value;
        return this;
    }
}
