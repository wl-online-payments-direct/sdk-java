/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SurchargeSpecificInput {

    private String mode;

    private AmountOfMoney surchargeAmount;

    /**
     * The surcharge mode which defines how a merchant will apply surcharging.
     * <ul>
     *   <li>pass-through - Merchant to define and apply surcharge amount for a transaction for processing. This mode is not supported on Create Hosted Checkout Session.</li>
     *   <li>on-behalf-of - Merchant to instruct the payment platform to calculate and apply a surcharge amount to a transaction, based on the merchantâ€™s surcharge configuration, net amount, and payment product type.</li>
     * </ul>
     */
    public String getMode() {
        return mode;
    }

    /**
     * The surcharge mode which defines how a merchant will apply surcharging.
     * <ul>
     *   <li>pass-through - Merchant to define and apply surcharge amount for a transaction for processing. This mode is not supported on Create Hosted Checkout Session.</li>
     *   <li>on-behalf-of - Merchant to instruct the payment platform to calculate and apply a surcharge amount to a transaction, based on the merchantâ€™s surcharge configuration, net amount, and payment product type.</li>
     * </ul>
     */
    public void setMode(String value) {
        this.mode = value;
    }

    /**
     * The surcharge mode which defines how a merchant will apply surcharging.
     * <ul>
     *   <li>pass-through - Merchant to define and apply surcharge amount for a transaction for processing. This mode is not supported on Create Hosted Checkout Session.</li>
     *   <li>on-behalf-of - Merchant to instruct the payment platform to calculate and apply a surcharge amount to a transaction, based on the merchantâ€™s surcharge configuration, net amount, and payment product type.</li>
     * </ul>
     */
    public SurchargeSpecificInput withMode(String value) {
        this.mode = value;
        return this;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public AmountOfMoney getSurchargeAmount() {
        return surchargeAmount;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public void setSurchargeAmount(AmountOfMoney value) {
        this.surchargeAmount = value;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public SurchargeSpecificInput withSurchargeAmount(AmountOfMoney value) {
        this.surchargeAmount = value;
        return this;
    }
}
