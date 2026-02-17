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
 * Get sensitive card details by card payment identifiers (/v2/{merchantId}/detokenize/payments)
 */
public class GetCardDataByPaymentsParams implements ParamRequest {

    private List<String> payments;

    /**
     * This object contains the details for detokenizing a payment token.
     */
    public List<String> getPayments() {
        return payments;
    }

    /**
     * This object contains the details for detokenizing a payment token.
     */
    public void setPayments(List<String> value) {
        this.payments = value;
    }

    /**
     * This object contains the details for detokenizing a payment token.
     */
    public GetCardDataByPaymentsParams withPayments(List<String> value) {
        this.payments = value;
        return this;
    }

    /**
     * This object contains the details for detokenizing a payment token.
     */
    public void addPayments(String value) {
        if (this.payments == null) {
            this.payments = new ArrayList<>();
        }
        this.payments.add(value);
    }

    @Override
    public List<RequestParam> toRequestParameters() {
        List<RequestParam> result = new ArrayList<>();
        if (payments != null) {
            for (String paymentsElement : payments) {
                if (paymentsElement != null) {
                    result.add(new RequestParam("payments", paymentsElement));
                }
            }
        }
        return result;
    }
}
