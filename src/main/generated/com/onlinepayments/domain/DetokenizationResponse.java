/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class DetokenizationResponse {

    private List<DetokenizedTokenResponse> tokens;

    /**
     * The response contains an array of detokenized data for the provided token IDs, which includes card details and expiration dates.
     */
    public List<DetokenizedTokenResponse> getTokens() {
        return tokens;
    }

    /**
     * The response contains an array of detokenized data for the provided token IDs, which includes card details and expiration dates.
     */
    public void setTokens(List<DetokenizedTokenResponse> value) {
        this.tokens = value;
    }

    /**
     * The response contains an array of detokenized data for the provided token IDs, which includes card details and expiration dates.
     */
    public DetokenizationResponse withTokens(List<DetokenizedTokenResponse> value) {
        this.tokens = value;
        return this;
    }
}
