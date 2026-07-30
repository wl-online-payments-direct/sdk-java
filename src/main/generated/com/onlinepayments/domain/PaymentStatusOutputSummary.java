/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class PaymentStatusOutputSummary {

    private List<APIError> errors;

    private String statusCategory;

    private Integer statusCode;

    private String statusCodeChangeDateTime;

    public List<APIError> getErrors() {
        return errors;
    }

    public void setErrors(List<APIError> value) {
        this.errors = value;
    }

    public PaymentStatusOutputSummary withErrors(List<APIError> value) {
        this.errors = value;
        return this;
    }

    /**
     * Highlevel status of the payment, payout or refund.
     */
    public String getStatusCategory() {
        return statusCategory;
    }

    /**
     * Highlevel status of the payment, payout or refund.
     */
    public void setStatusCategory(String value) {
        this.statusCategory = value;
    }

    /**
     * Highlevel status of the payment, payout or refund.
     */
    public PaymentStatusOutputSummary withStatusCategory(String value) {
        this.statusCategory = value;
        return this;
    }

    /**
     * Numeric status code of the legacy API. The value can also be found in the BackOffice and in report files.
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     * Numeric status code of the legacy API. The value can also be found in the BackOffice and in report files.
     */
    public void setStatusCode(Integer value) {
        this.statusCode = value;
    }

    /**
     * Numeric status code of the legacy API. The value can also be found in the BackOffice and in report files.
     */
    public PaymentStatusOutputSummary withStatusCode(Integer value) {
        this.statusCode = value;
        return this;
    }

    /**
     * Timestamp of the latest status change
     */
    public String getStatusCodeChangeDateTime() {
        return statusCodeChangeDateTime;
    }

    /**
     * Timestamp of the latest status change
     */
    public void setStatusCodeChangeDateTime(String value) {
        this.statusCodeChangeDateTime = value;
    }

    /**
     * Timestamp of the latest status change
     */
    public PaymentStatusOutputSummary withStatusCodeChangeDateTime(String value) {
        this.statusCodeChangeDateTime = value;
        return this;
    }
}
