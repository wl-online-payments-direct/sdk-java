/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class CapturesResponse {

    private List<Capture> captures;

    /**
     * The list of all captures performed on the requested payment.
     */
    public List<Capture> getCaptures() {
        return captures;
    }

    /**
     * The list of all captures performed on the requested payment.
     */
    public void setCaptures(List<Capture> value) {
        this.captures = value;
    }

    /**
     * The list of all captures performed on the requested payment.
     */
    public CapturesResponse withCaptures(List<Capture> value) {
        this.captures = value;
        return this;
    }
}
