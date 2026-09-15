/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class RefundErrorResponse {

    private String errorId;

    private List<APIError> errors;

    private RefundResponse refundResult;

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String value) {
        this.errorId = value;
    }

    public RefundErrorResponse withErrorId(String value) {
        this.errorId = value;
        return this;
    }

    public List<APIError> getErrors() {
        return errors;
    }

    public void setErrors(List<APIError> value) {
        this.errors = value;
    }

    public RefundErrorResponse withErrors(List<APIError> value) {
        this.errors = value;
        return this;
    }

    /**
     * Deprecated: This field is not used by any payment product
     */
    public RefundResponse getRefundResult() {
        return refundResult;
    }

    /**
     * Deprecated: This field is not used by any payment product
     */
    public void setRefundResult(RefundResponse value) {
        this.refundResult = value;
    }

    /**
     * Deprecated: This field is not used by any payment product
     */
    public RefundErrorResponse withRefundResult(RefundResponse value) {
        this.refundResult = value;
        return this;
    }
}
