/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.tokenization;

import java.util.ArrayList;
import java.util.List;

import com.onlinepayments.communication.ParamRequest;
import com.onlinepayments.communication.RequestParam;

/**
 * Query parameters for
 * Get sensitive card details by card alias tokens (/v2/{merchantId}/detokenize/tokens)
 */
public class GetCardDataByTokensParams implements ParamRequest {

    private List<String> tokens;

    /**
     * This object contains the details for detokenizing a payment token.
     */
    public List<String> getTokens() {
        return tokens;
    }

    /**
     * This object contains the details for detokenizing a payment token.
     */
    public void setTokens(List<String> value) {
        this.tokens = value;
    }

    /**
     * This object contains the details for detokenizing a payment token.
     */
    public GetCardDataByTokensParams withTokens(List<String> value) {
        this.tokens = value;
        return this;
    }

    /**
     * This object contains the details for detokenizing a payment token.
     */
    public void addTokens(String value) {
        if (this.tokens == null) {
            this.tokens = new ArrayList<>();
        }
        this.tokens.add(value);
    }

    @Override
    public List<RequestParam> toRequestParameters() {
        List<RequestParam> result = new ArrayList<>();
        if (tokens != null) {
            for (String tokensElement : tokens) {
                if (tokensElement != null) {
                    result.add(new RequestParam("tokens", tokensElement));
                }
            }
        }
        return result;
    }
}
