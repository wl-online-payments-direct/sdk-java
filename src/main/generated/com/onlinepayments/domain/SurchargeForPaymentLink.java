/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SurchargeForPaymentLink {

    private String surchargeMode;

    /**
     * The surcharge mode which defines how a merchant will apply surcharging.
     * <ul>
     *   <li>pass-through - Merchant to define and apply surcharge amount for a transaction for processing. This mode is not supported on Create Hosted Checkout Session.</li>
     *   <li>on-behalf-of - Merchant to instruct the payment platform to calculate and apply a surcharge amount to a transaction, based on the merchantâ€™s surcharge configuration, net amount, and payment product type.</li>
     * </ul>
     */
    public String getSurchargeMode() {
        return surchargeMode;
    }

    /**
     * The surcharge mode which defines how a merchant will apply surcharging.
     * <ul>
     *   <li>pass-through - Merchant to define and apply surcharge amount for a transaction for processing. This mode is not supported on Create Hosted Checkout Session.</li>
     *   <li>on-behalf-of - Merchant to instruct the payment platform to calculate and apply a surcharge amount to a transaction, based on the merchantâ€™s surcharge configuration, net amount, and payment product type.</li>
     * </ul>
     */
    public void setSurchargeMode(String value) {
        this.surchargeMode = value;
    }

    /**
     * The surcharge mode which defines how a merchant will apply surcharging.
     * <ul>
     *   <li>pass-through - Merchant to define and apply surcharge amount for a transaction for processing. This mode is not supported on Create Hosted Checkout Session.</li>
     *   <li>on-behalf-of - Merchant to instruct the payment platform to calculate and apply a surcharge amount to a transaction, based on the merchantâ€™s surcharge configuration, net amount, and payment product type.</li>
     * </ul>
     */
    public SurchargeForPaymentLink withSurchargeMode(String value) {
        this.surchargeMode = value;
        return this;
    }
}
