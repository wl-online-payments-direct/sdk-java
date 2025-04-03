/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class TokenEWallet {

    private String alias;

    private CustomerToken customer;

    /**
     * Deprecated: This field is not used by any payment product
     * An alias for the token. This can be used to visually represent the token.
     *
     * @deprecated This field is not used by any payment product An alias for the token. This can be used to visually represent the token.
     */
    @Deprecated
    public String getAlias() {
        return alias;
    }

    /**
     * Deprecated: This field is not used by any payment product
     * An alias for the token. This can be used to visually represent the token.
     *
     * @deprecated This field is not used by any payment product An alias for the token. This can be used to visually represent the token.
     */
    @Deprecated
    public void setAlias(String value) {
        this.alias = value;
    }

    /**
     * Deprecated: This field is not used by any payment product
     * An alias for the token. This can be used to visually represent the token.
     *
     * @deprecated This field is not used by any payment product An alias for the token. This can be used to visually represent the token.
     */
    @Deprecated
    public TokenEWallet withAlias(String value) {
        this.alias = value;
        return this;
    }

    public CustomerToken getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerToken value) {
        this.customer = value;
    }

    public TokenEWallet withCustomer(CustomerToken value) {
        this.customer = value;
        return this;
    }
}
