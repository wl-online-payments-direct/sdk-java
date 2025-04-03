/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class CalculateSurchargeResponse {

    private List<Surcharge> surcharges;

    public List<Surcharge> getSurcharges() {
        return surcharges;
    }

    public void setSurcharges(List<Surcharge> value) {
        this.surcharges = value;
    }

    public CalculateSurchargeResponse withSurcharges(List<Surcharge> value) {
        this.surcharges = value;
        return this;
    }
}
