/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class GetMandateResponse {

    private MandateResponse mandate;

    /**
     * Object containing the created mandate.
     */
    public MandateResponse getMandate() {
        return mandate;
    }

    /**
     * Object containing the created mandate.
     */
    public void setMandate(MandateResponse value) {
        this.mandate = value;
    }

    /**
     * Object containing the created mandate.
     */
    public GetMandateResponse withMandate(MandateResponse value) {
        this.mandate = value;
        return this;
    }
}
