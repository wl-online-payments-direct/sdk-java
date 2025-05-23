/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ExternalTokenLinked {

    private String ComputedToken;

    private String GTSComputedToken;

    private String GeneratedToken;

    /**
     * The computed token
     */
    public String getComputedToken() {
        return ComputedToken;
    }

    /**
     * The computed token
     */
    public void setComputedToken(String value) {
        this.ComputedToken = value;
    }

    /**
     * The computed token
     */
    public ExternalTokenLinked withComputedToken(String value) {
        this.ComputedToken = value;
        return this;
    }

    /**
     * Deprecated: Use the field ComputedToken instead.
     *
     * @deprecated Use the field ComputedToken instead.
     */
    @Deprecated
    public String getGTSComputedToken() {
        return GTSComputedToken;
    }

    /**
     * Deprecated: Use the field ComputedToken instead.
     *
     * @deprecated Use the field ComputedToken instead.
     */
    @Deprecated
    public void setGTSComputedToken(String value) {
        this.GTSComputedToken = value;
    }

    /**
     * Deprecated: Use the field ComputedToken instead.
     *
     * @deprecated Use the field ComputedToken instead.
     */
    @Deprecated
    public ExternalTokenLinked withGTSComputedToken(String value) {
        this.GTSComputedToken = value;
        return this;
    }

    /**
     * The generated token
     */
    public String getGeneratedToken() {
        return GeneratedToken;
    }

    /**
     * The generated token
     */
    public void setGeneratedToken(String value) {
        this.GeneratedToken = value;
    }

    /**
     * The generated token
     */
    public ExternalTokenLinked withGeneratedToken(String value) {
        this.GeneratedToken = value;
        return this;
    }
}
