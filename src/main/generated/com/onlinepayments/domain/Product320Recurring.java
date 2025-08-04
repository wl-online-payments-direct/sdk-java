/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class Product320Recurring {

    private String recurringPaymentSequenceIndicator;

    /**
     * <ul>
     *   <li>first = This transaction is the first of a series of recurring transactions</li>
     * </ul>
     */
    public String getRecurringPaymentSequenceIndicator() {
        return recurringPaymentSequenceIndicator;
    }

    /**
     * <ul>
     *   <li>first = This transaction is the first of a series of recurring transactions</li>
     * </ul>
     */
    public void setRecurringPaymentSequenceIndicator(String value) {
        this.recurringPaymentSequenceIndicator = value;
    }

    /**
     * <ul>
     *   <li>first = This transaction is the first of a series of recurring transactions</li>
     * </ul>
     */
    public Product320Recurring withRecurringPaymentSequenceIndicator(String value) {
        this.recurringPaymentSequenceIndicator = value;
        return this;
    }
}
