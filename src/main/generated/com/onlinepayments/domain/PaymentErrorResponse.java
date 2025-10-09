/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class PaymentErrorResponse {

    private String errorId;

    private List<APIError> errors;

    private CreatePaymentResponse paymentResult;

    /**
     * Unique reference, for debugging purposes, of this error response
     */
    public String getErrorId() {
        return errorId;
    }

    /**
     * Unique reference, for debugging purposes, of this error response
     */
    public void setErrorId(String value) {
        this.errorId = value;
    }

    /**
     * Unique reference, for debugging purposes, of this error response
     */
    public PaymentErrorResponse withErrorId(String value) {
        this.errorId = value;
        return this;
    }

    public List<APIError> getErrors() {
        return errors;
    }

    public void setErrors(List<APIError> value) {
        this.errors = value;
    }

    public PaymentErrorResponse withErrors(List<APIError> value) {
        this.errors = value;
        return this;
    }

    /**
     * This object contains details about the created payment if one has been generated.
     */
    public CreatePaymentResponse getPaymentResult() {
        return paymentResult;
    }

    /**
     * This object contains details about the created payment if one has been generated.
     */
    public void setPaymentResult(CreatePaymentResponse value) {
        this.paymentResult = value;
    }

    /**
     * This object contains details about the created payment if one has been generated.
     */
    public PaymentErrorResponse withPaymentResult(CreatePaymentResponse value) {
        this.paymentResult = value;
        return this;
    }
}
