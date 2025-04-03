/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RangeValidator {

    private Integer maxValue;

    private Integer minValue;

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer value) {
        this.maxValue = value;
    }

    public RangeValidator withMaxValue(Integer value) {
        this.maxValue = value;
        return this;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer value) {
        this.minValue = value;
    }

    public RangeValidator withMinValue(Integer value) {
        this.minValue = value;
        return this;
    }
}
