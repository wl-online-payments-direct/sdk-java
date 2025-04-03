/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class SessionRequest {

    private List<String> tokens;

    /**
     * List of previously stored tokens linked to the customer that wants to checkout.
     */
    public List<String> getTokens() {
        return tokens;
    }

    /**
     * List of previously stored tokens linked to the customer that wants to checkout.
     */
    public void setTokens(List<String> value) {
        this.tokens = value;
    }

    /**
     * List of previously stored tokens linked to the customer that wants to checkout.
     */
    public SessionRequest withTokens(List<String> value) {
        this.tokens = value;
        return this;
    }
}
