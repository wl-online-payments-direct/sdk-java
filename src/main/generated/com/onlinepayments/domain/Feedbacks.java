/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class Feedbacks {

    private String webhookUrl;

    /**
     * The URL where the webhook will be dispatched for all status change events related to this payment.
     */
    public String getWebhookUrl() {
        return webhookUrl;
    }

    /**
     * The URL where the webhook will be dispatched for all status change events related to this payment.
     */
    public void setWebhookUrl(String value) {
        this.webhookUrl = value;
    }

    /**
     * The URL where the webhook will be dispatched for all status change events related to this payment.
     */
    public Feedbacks withWebhookUrl(String value) {
        this.webhookUrl = value;
        return this;
    }
}
