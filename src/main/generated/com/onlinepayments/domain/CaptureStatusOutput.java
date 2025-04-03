/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CaptureStatusOutput {

    private Integer statusCode;

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
    public CaptureStatusOutput withStatusCode(Integer value) {
        this.statusCode = value;
        return this;
    }
}
