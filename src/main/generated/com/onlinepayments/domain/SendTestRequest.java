/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SendTestRequest {

    private String url;

    /**
     * Url to which the dummy webhook would be sent. If the parameter is not sent, It will be sent as default to the webhook url configured in the backoffice.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Url to which the dummy webhook would be sent. If the parameter is not sent, It will be sent as default to the webhook url configured in the backoffice.
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Url to which the dummy webhook would be sent. If the parameter is not sent, It will be sent as default to the webhook url configured in the backoffice.
     */
    public SendTestRequest withUrl(String value) {
        this.url = value;
        return this;
    }
}
