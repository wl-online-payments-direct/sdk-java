/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class TokenCard {

    private String alias;

    private TokenCardData data;

    /**
     * An alias for the token. This can be used to visually represent the token.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * An alias for the token. This can be used to visually represent the token.
     */
    public void setAlias(String value) {
        this.alias = value;
    }

    /**
     * An alias for the token. This can be used to visually represent the token.
     */
    public TokenCard withAlias(String value) {
        this.alias = value;
        return this;
    }

    public TokenCardData getData() {
        return data;
    }

    public void setData(TokenCardData value) {
        this.data = value;
    }

    public TokenCard withData(TokenCardData value) {
        this.data = value;
        return this;
    }
}
