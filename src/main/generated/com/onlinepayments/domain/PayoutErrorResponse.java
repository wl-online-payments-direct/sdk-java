/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class PayoutErrorResponse {

    private String errorId;

    private List<APIError> errors;

    private PayoutResult payoutResult;

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String value) {
        this.errorId = value;
    }

    public PayoutErrorResponse withErrorId(String value) {
        this.errorId = value;
        return this;
    }

    public List<APIError> getErrors() {
        return errors;
    }

    public void setErrors(List<APIError> value) {
        this.errors = value;
    }

    public PayoutErrorResponse withErrors(List<APIError> value) {
        this.errors = value;
        return this;
    }

    public PayoutResult getPayoutResult() {
        return payoutResult;
    }

    public void setPayoutResult(PayoutResult value) {
        this.payoutResult = value;
    }

    public PayoutErrorResponse withPayoutResult(PayoutResult value) {
        this.payoutResult = value;
        return this;
    }
}
