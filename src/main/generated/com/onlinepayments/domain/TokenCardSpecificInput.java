/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class TokenCardSpecificInput {

    private TokenData data;

    /**
     * Object containing the token details for a card
     */
    public TokenData getData() {
        return data;
    }

    /**
     * Object containing the token details for a card
     */
    public void setData(TokenData value) {
        this.data = value;
    }

    /**
     * Object containing the token details for a card
     */
    public TokenCardSpecificInput withData(TokenData value) {
        this.data = value;
        return this;
    }
}
