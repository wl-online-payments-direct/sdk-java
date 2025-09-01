/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class Product302Recurring {

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
    public Product302Recurring withRecurringPaymentSequenceIndicator(String value) {
        this.recurringPaymentSequenceIndicator = value;
        return this;
    }
}
