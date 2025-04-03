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
     * This object has the numeric representation of the current refund status, timestamp of last status change and performable action on the current refund resource. In case of a rejected refund, detailed error information is listed.
     */
    public RefundResponse getRefundResult() {
        return refundResult;
    }

    /**
     * This object has the numeric representation of the current refund status, timestamp of last status change and performable action on the current refund resource. In case of a rejected refund, detailed error information is listed.
     */
    public void setRefundResult(RefundResponse value) {
        this.refundResult = value;
    }

    /**
     * This object has the numeric representation of the current refund status, timestamp of last status change and performable action on the current refund resource. In case of a rejected refund, detailed error information is listed.
     */
    public RefundErrorResponse withRefundResult(RefundResponse value) {
        this.refundResult = value;
        return this;
    }
}
