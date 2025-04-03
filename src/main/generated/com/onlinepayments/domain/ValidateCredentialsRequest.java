/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ValidateCredentialsRequest {

    private String key;

    private String secret;

    /**
     * The webhook key and without any change applied to it.
     */
    public String getKey() {
        return key;
    }

    /**
     * The webhook key and without any change applied to it.
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * The webhook key and without any change applied to it.
     */
    public ValidateCredentialsRequest withKey(String value) {
        this.key = value;
        return this;
    }

    /**
     * Send here the hashed webhooks key secret in the same way as the check is done in your system. The only difference is instead of providing the current body of the message, use an empty string as body while hashing it.
     */
    public String getSecret() {
        return secret;
    }

    /**
     * Send here the hashed webhooks key secret in the same way as the check is done in your system. The only difference is instead of providing the current body of the message, use an empty string as body while hashing it.
     */
    public void setSecret(String value) {
        this.secret = value;
    }

    /**
     * Send here the hashed webhooks key secret in the same way as the check is done in your system. The only difference is instead of providing the current body of the message, use an empty string as body while hashing it.
     */
    public ValidateCredentialsRequest withSecret(String value) {
        this.secret = value;
        return this;
    }
}
