/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class Feedbacks {

    private String webhookUrl;

    private List<String> webhooksUrls;

    /**
     * The URL where the webhook will be dispatched for all status change events related to this payment.
     *
     * @deprecated The URL where the webhook will be dispatched for all status change events related to this payment.
     */
    @Deprecated
    public String getWebhookUrl() {
        return webhookUrl;
    }

    /**
     * The URL where the webhook will be dispatched for all status change events related to this payment.
     *
     * @deprecated The URL where the webhook will be dispatched for all status change events related to this payment.
     */
    @Deprecated
    public void setWebhookUrl(String value) {
        this.webhookUrl = value;
    }

    /**
     * The URL where the webhook will be dispatched for all status change events related to this payment.
     *
     * @deprecated The URL where the webhook will be dispatched for all status change events related to this payment.
     */
    @Deprecated
    public Feedbacks withWebhookUrl(String value) {
        this.webhookUrl = value;
        return this;
    }

    /**
     * The list of the URLs where the webhook will be dispatched for all status change events related to this payment.
     */
    public List<String> getWebhooksUrls() {
        return webhooksUrls;
    }

    /**
     * The list of the URLs where the webhook will be dispatched for all status change events related to this payment.
     */
    public void setWebhooksUrls(List<String> value) {
        this.webhooksUrls = value;
    }

    /**
     * The list of the URLs where the webhook will be dispatched for all status change events related to this payment.
     */
    public Feedbacks withWebhooksUrls(List<String> value) {
        this.webhooksUrls = value;
        return this;
    }
}
