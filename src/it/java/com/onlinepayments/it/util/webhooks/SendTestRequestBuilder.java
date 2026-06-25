package com.onlinepayments.it.util.webhooks;

import com.onlinepayments.domain.SendTestRequest;

public class SendTestRequestBuilder {
    private String url = null;

    public SendTestRequestBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public SendTestRequest build() {
        SendTestRequest request = new SendTestRequest();

        if (this.url != null) {
            request.setUrl(this.url);
        }

        return request;
    }
}
