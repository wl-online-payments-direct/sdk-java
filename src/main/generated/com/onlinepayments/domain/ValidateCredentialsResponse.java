/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ValidateCredentialsResponse {

    private String result;

    /**
     * The webhooks validation was OK (Valid) or not OK (Invalid).
     */
    public String getResult() {
        return result;
    }

    /**
     * The webhooks validation was OK (Valid) or not OK (Invalid).
     */
    public void setResult(String value) {
        this.result = value;
    }

    /**
     * The webhooks validation was OK (Valid) or not OK (Invalid).
     */
    public ValidateCredentialsResponse withResult(String value) {
        this.result = value;
        return this;
    }
}
