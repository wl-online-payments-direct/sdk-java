/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class PaymentProductFiltersHostedFields {

    private List<Integer> exclude;

    private List<Integer> restrictTo;

    /**
     * List containing all payment product ids that should either be restricted to in or excluded from the payment context.
     */
    public List<Integer> getExclude() {
        return exclude;
    }

    /**
     * List containing all payment product ids that should either be restricted to in or excluded from the payment context.
     */
    public void setExclude(List<Integer> value) {
        this.exclude = value;
    }

    /**
     * List containing all payment product ids that should either be restricted to in or excluded from the payment context.
     */
    public PaymentProductFiltersHostedFields withExclude(List<Integer> value) {
        this.exclude = value;
        return this;
    }

    /**
     * List containing all payment product ids that should either be restricted to in or excluded from the payment context.
     */
    public List<Integer> getRestrictTo() {
        return restrictTo;
    }

    /**
     * List containing all payment product ids that should either be restricted to in or excluded from the payment context.
     */
    public void setRestrictTo(List<Integer> value) {
        this.restrictTo = value;
    }

    /**
     * List containing all payment product ids that should either be restricted to in or excluded from the payment context.
     */
    public PaymentProductFiltersHostedFields withRestrictTo(List<Integer> value) {
        this.restrictTo = value;
        return this;
    }
}
