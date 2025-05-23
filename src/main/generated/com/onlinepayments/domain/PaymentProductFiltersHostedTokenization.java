/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProductFiltersHostedTokenization {

    private PaymentProductFilterHostedTokenization exclude;

    private PaymentProductFilterHostedTokenization restrictTo;

    /**
     * The payment product ids to be be excluded or restricted to from the payment products available for the payment. Note that you can add exclusions on top of the 'restrictTo' filter.
     */
    public PaymentProductFilterHostedTokenization getExclude() {
        return exclude;
    }

    /**
     * The payment product ids to be be excluded or restricted to from the payment products available for the payment. Note that you can add exclusions on top of the 'restrictTo' filter.
     */
    public void setExclude(PaymentProductFilterHostedTokenization value) {
        this.exclude = value;
    }

    /**
     * The payment product ids to be be excluded or restricted to from the payment products available for the payment. Note that you can add exclusions on top of the 'restrictTo' filter.
     */
    public PaymentProductFiltersHostedTokenization withExclude(PaymentProductFilterHostedTokenization value) {
        this.exclude = value;
        return this;
    }

    /**
     * The payment product ids to be be excluded or restricted to from the payment products available for the payment. Note that you can add exclusions on top of the 'restrictTo' filter.
     */
    public PaymentProductFilterHostedTokenization getRestrictTo() {
        return restrictTo;
    }

    /**
     * The payment product ids to be be excluded or restricted to from the payment products available for the payment. Note that you can add exclusions on top of the 'restrictTo' filter.
     */
    public void setRestrictTo(PaymentProductFilterHostedTokenization value) {
        this.restrictTo = value;
    }

    /**
     * The payment product ids to be be excluded or restricted to from the payment products available for the payment. Note that you can add exclusions on top of the 'restrictTo' filter.
     */
    public PaymentProductFiltersHostedTokenization withRestrictTo(PaymentProductFilterHostedTokenization value) {
        this.restrictTo = value;
        return this;
    }
}
