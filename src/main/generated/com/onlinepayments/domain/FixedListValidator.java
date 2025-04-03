/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class FixedListValidator {

    private List<String> allowedValues;

    public List<String> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(List<String> value) {
        this.allowedValues = value;
    }

    public FixedListValidator withAllowedValues(List<String> value) {
        this.allowedValues = value;
        return this;
    }
}
