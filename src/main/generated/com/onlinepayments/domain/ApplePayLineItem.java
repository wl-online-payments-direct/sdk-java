/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ApplePayLineItem {

    private String amount;

    private String label;

    private String paymentTiming;

    private String recurringPaymentEndDate;

    private Long recurringPaymentIntervalCount;

    private String recurringPaymentIntervalUnit;

    private String recurringPaymentStartDate;

    /**
     * A required value thatâ€™s the monetary amount of the line item.
     */
    public String getAmount() {
        return amount;
    }

    /**
     * A required value thatâ€™s the monetary amount of the line item.
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * A required value thatâ€™s the monetary amount of the line item.
     */
    public ApplePayLineItem withAmount(String value) {
        this.amount = value;
        return this;
    }

    /**
     * A required value thatâ€™s a short, localized description of the line item.
     */
    public String getLabel() {
        return label;
    }

    /**
     * A required value thatâ€™s a short, localized description of the line item.
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * A required value thatâ€™s a short, localized description of the line item.
     */
    public ApplePayLineItem withLabel(String value) {
        this.label = value;
        return this;
    }

    /**
     * The time that the payment occurs as part of a successful transaction.
     */
    public String getPaymentTiming() {
        return paymentTiming;
    }

    /**
     * The time that the payment occurs as part of a successful transaction.
     */
    public void setPaymentTiming(String value) {
        this.paymentTiming = value;
    }

    /**
     * The time that the payment occurs as part of a successful transaction.
     */
    public ApplePayLineItem withPaymentTiming(String value) {
        this.paymentTiming = value;
        return this;
    }

    /**
     * The date of the final payment. Example 2022-01-01T00:00:00
     */
    public String getRecurringPaymentEndDate() {
        return recurringPaymentEndDate;
    }

    /**
     * The date of the final payment. Example 2022-01-01T00:00:00
     */
    public void setRecurringPaymentEndDate(String value) {
        this.recurringPaymentEndDate = value;
    }

    /**
     * The date of the final payment. Example 2022-01-01T00:00:00
     */
    public ApplePayLineItem withRecurringPaymentEndDate(String value) {
        this.recurringPaymentEndDate = value;
        return this;
    }

    /**
     * The number of interval units that make up the total payment interval.
     */
    public Long getRecurringPaymentIntervalCount() {
        return recurringPaymentIntervalCount;
    }

    /**
     * The number of interval units that make up the total payment interval.
     */
    public void setRecurringPaymentIntervalCount(Long value) {
        this.recurringPaymentIntervalCount = value;
    }

    /**
     * The number of interval units that make up the total payment interval.
     */
    public ApplePayLineItem withRecurringPaymentIntervalCount(Long value) {
        this.recurringPaymentIntervalCount = value;
        return this;
    }

    /**
     * The amount of time â€” in calendar units, such as day, month, or year â€” that represents a fraction of the total payment interval.
     */
    public String getRecurringPaymentIntervalUnit() {
        return recurringPaymentIntervalUnit;
    }

    /**
     * The amount of time â€” in calendar units, such as day, month, or year â€” that represents a fraction of the total payment interval.
     */
    public void setRecurringPaymentIntervalUnit(String value) {
        this.recurringPaymentIntervalUnit = value;
    }

    /**
     * The amount of time â€” in calendar units, such as day, month, or year â€” that represents a fraction of the total payment interval.
     */
    public ApplePayLineItem withRecurringPaymentIntervalUnit(String value) {
        this.recurringPaymentIntervalUnit = value;
        return this;
    }

    /**
     * The date of the first payment. Example 2022-01-01T00:00:00
     */
    public String getRecurringPaymentStartDate() {
        return recurringPaymentStartDate;
    }

    /**
     * The date of the first payment. Example 2022-01-01T00:00:00
     */
    public void setRecurringPaymentStartDate(String value) {
        this.recurringPaymentStartDate = value;
    }

    /**
     * The date of the first payment. Example 2022-01-01T00:00:00
     */
    public ApplePayLineItem withRecurringPaymentStartDate(String value) {
        this.recurringPaymentStartDate = value;
        return this;
    }
}
