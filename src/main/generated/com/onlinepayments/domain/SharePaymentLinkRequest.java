/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SharePaymentLinkRequest {

    private String channel;

    private String locale;

    private String recipient;

    /**
     * Specifies the communication channel for sharing the payment link.
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Specifies the communication channel for sharing the payment link.
     */
    public void setChannel(String value) {
        this.channel = value;
    }

    /**
     * Specifies the communication channel for sharing the payment link.
     */
    public SharePaymentLinkRequest withChannel(String value) {
        this.channel = value;
        return this;
    }

    /**
     * The locale code in language-country format following ISO 639-1 and ISO 3166-1 standards (e.g., fr-BE, en-US, de-DE).
     */
    public String getLocale() {
        return locale;
    }

    /**
     * The locale code in language-country format following ISO 639-1 and ISO 3166-1 standards (e.g., fr-BE, en-US, de-DE).
     */
    public void setLocale(String value) {
        this.locale = value;
    }

    /**
     * The locale code in language-country format following ISO 639-1 and ISO 3166-1 standards (e.g., fr-BE, en-US, de-DE).
     */
    public SharePaymentLinkRequest withLocale(String value) {
        this.locale = value;
        return this;
    }

    /**
     * The email address of the recipient.
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * The email address of the recipient.
     */
    public void setRecipient(String value) {
        this.recipient = value;
    }

    /**
     * The email address of the recipient.
     */
    public SharePaymentLinkRequest withRecipient(String value) {
        this.recipient = value;
        return this;
    }
}
