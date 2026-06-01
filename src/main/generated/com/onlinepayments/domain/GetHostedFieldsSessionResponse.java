/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class GetHostedFieldsSessionResponse {

    private String sessionId;

    private TokenInfo token;

    /**
     * The ID of the hosted fields session.
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * The ID of the hosted fields session.
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * The ID of the hosted fields session.
     */
    public GetHostedFieldsSessionResponse withSessionId(String value) {
        this.sessionId = value;
        return this;
    }

    /**
     * Object containing token information that is used in the hosted fields session
     */
    public TokenInfo getToken() {
        return token;
    }

    /**
     * Object containing token information that is used in the hosted fields session
     */
    public void setToken(TokenInfo value) {
        this.token = value;
    }

    /**
     * Object containing token information that is used in the hosted fields session
     */
    public GetHostedFieldsSessionResponse withToken(TokenInfo value) {
        this.token = value;
        return this;
    }
}
