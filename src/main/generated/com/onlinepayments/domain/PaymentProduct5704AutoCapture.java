/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProduct5704AutoCapture {

    private Integer delayInMinutes;

    /**
     * Delay in minutes between authorization and automatic capture for this request. Minimum value is 0 minutes, maximum value is 10,080 minutes (7 days).
     */
    public Integer getDelayInMinutes() {
        return delayInMinutes;
    }

    /**
     * Delay in minutes between authorization and automatic capture for this request. Minimum value is 0 minutes, maximum value is 10,080 minutes (7 days).
     */
    public void setDelayInMinutes(Integer value) {
        this.delayInMinutes = value;
    }

    /**
     * Delay in minutes between authorization and automatic capture for this request. Minimum value is 0 minutes, maximum value is 10,080 minutes (7 days).
     */
    public PaymentProduct5704AutoCapture withDelayInMinutes(Integer value) {
        this.delayInMinutes = value;
        return this;
    }
}
