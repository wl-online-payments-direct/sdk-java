/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SplitPaymentProductFiltersHostedCheckout {

    private SplitPaymentProductFilter exclude;

    private SplitPaymentProductFilter restrictTo;

    /**
     * The payment product IDs to be excluded or restricted for the payment products available for the following payments in a split payment. Note that you can add exclusions on top of the 'restrictTo' filter.
     */
    public SplitPaymentProductFilter getExclude() {
        return exclude;
    }

    /**
     * The payment product IDs to be excluded or restricted for the payment products available for the following payments in a split payment. Note that you can add exclusions on top of the 'restrictTo' filter.
     */
    public void setExclude(SplitPaymentProductFilter value) {
        this.exclude = value;
    }

    /**
     * The payment product IDs to be excluded or restricted for the payment products available for the following payments in a split payment. Note that you can add exclusions on top of the 'restrictTo' filter.
     */
    public SplitPaymentProductFiltersHostedCheckout withExclude(SplitPaymentProductFilter value) {
        this.exclude = value;
        return this;
    }

    /**
     * The payment product IDs to be excluded or restricted for the payment products available for the following payments in a split payment. Note that you can add exclusions on top of the 'restrictTo' filter.
     */
    public SplitPaymentProductFilter getRestrictTo() {
        return restrictTo;
    }

    /**
     * The payment product IDs to be excluded or restricted for the payment products available for the following payments in a split payment. Note that you can add exclusions on top of the 'restrictTo' filter.
     */
    public void setRestrictTo(SplitPaymentProductFilter value) {
        this.restrictTo = value;
    }

    /**
     * The payment product IDs to be excluded or restricted for the payment products available for the following payments in a split payment. Note that you can add exclusions on top of the 'restrictTo' filter.
     */
    public SplitPaymentProductFiltersHostedCheckout withRestrictTo(SplitPaymentProductFilter value) {
        this.restrictTo = value;
        return this;
    }
}
