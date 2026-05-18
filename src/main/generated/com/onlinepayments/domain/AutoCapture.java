/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class AutoCapture {

    private Integer delayInMinutes;

    /**
     * Delay in minutes between authorization and automatic capture for this request. Minimum value is 0 minutes, maximum value is 43200 minutes (30 days).
     */
    public Integer getDelayInMinutes() {
        return delayInMinutes;
    }

    /**
     * Delay in minutes between authorization and automatic capture for this request. Minimum value is 0 minutes, maximum value is 43200 minutes (30 days).
     */
    public void setDelayInMinutes(Integer value) {
        this.delayInMinutes = value;
    }

    /**
     * Delay in minutes between authorization and automatic capture for this request. Minimum value is 0 minutes, maximum value is 43200 minutes (30 days).
     */
    public AutoCapture withDelayInMinutes(Integer value) {
        this.delayInMinutes = value;
        return this;
    }
}
