/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProductSession302SpecificInput {

    private String displayName;

    private String domainName;

    /**
     * A human-readable name for the merchant, as it would be displayed to the user within the Apple Pay interface.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * A human-readable name for the merchant, as it would be displayed to the user within the Apple Pay interface.
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * A human-readable name for the merchant, as it would be displayed to the user within the Apple Pay interface.
     */
    public PaymentProductSession302SpecificInput withDisplayName(String value) {
        this.displayName = value;
        return this;
    }

    /**
     * The fully qualified domain name of the web page that will host the Apple Pay session.
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * The fully qualified domain name of the web page that will host the Apple Pay session.
     */
    public void setDomainName(String value) {
        this.domainName = value;
    }

    /**
     * The fully qualified domain name of the web page that will host the Apple Pay session.
     */
    public PaymentProductSession302SpecificInput withDomainName(String value) {
        this.domainName = value;
        return this;
    }
}
