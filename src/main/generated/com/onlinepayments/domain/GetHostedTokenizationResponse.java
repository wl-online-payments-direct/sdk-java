/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class GetHostedTokenizationResponse {

    private TokenResponse token;

    private String tokenStatus;

    public TokenResponse getToken() {
        return token;
    }

    public void setToken(TokenResponse value) {
        this.token = value;
    }

    public GetHostedTokenizationResponse withToken(TokenResponse value) {
        this.token = value;
        return this;
    }

    /**
     * This is the status of the token in the hosted tokenization session. Possible values are:
     * <ul>
     *   <li>UNCHANGED - The token has not changed</li>
     *   <li>CREATED - The token has been created</li>
     *   <li>UPDATED - The token has been updated</li>
     * </ul>
     */
    public String getTokenStatus() {
        return tokenStatus;
    }

    /**
     * This is the status of the token in the hosted tokenization session. Possible values are:
     * <ul>
     *   <li>UNCHANGED - The token has not changed</li>
     *   <li>CREATED - The token has been created</li>
     *   <li>UPDATED - The token has been updated</li>
     * </ul>
     */
    public void setTokenStatus(String value) {
        this.tokenStatus = value;
    }

    /**
     * This is the status of the token in the hosted tokenization session. Possible values are:
     * <ul>
     *   <li>UNCHANGED - The token has not changed</li>
     *   <li>CREATED - The token has been created</li>
     *   <li>UPDATED - The token has been updated</li>
     * </ul>
     */
    public GetHostedTokenizationResponse withTokenStatus(String value) {
        this.tokenStatus = value;
        return this;
    }
}
