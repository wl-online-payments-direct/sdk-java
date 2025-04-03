/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SurchargeSpecificOutput {

    private String mode;

    private AmountOfMoney surchargeAmount;

    private SurchargeRate surchargeRate;

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
    public SurchargeSpecificOutput withMode(String value) {
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
    public SurchargeSpecificOutput withSurchargeAmount(AmountOfMoney value) {
        this.surchargeAmount = value;
        return this;
    }

    /**
     * A summary of surcharge details used in the calculation of the surcharge amount. null if result = NO_SURCHARGE
     */
    public SurchargeRate getSurchargeRate() {
        return surchargeRate;
    }

    /**
     * A summary of surcharge details used in the calculation of the surcharge amount. null if result = NO_SURCHARGE
     */
    public void setSurchargeRate(SurchargeRate value) {
        this.surchargeRate = value;
    }

    /**
     * A summary of surcharge details used in the calculation of the surcharge amount. null if result = NO_SURCHARGE
     */
    public SurchargeSpecificOutput withSurchargeRate(SurchargeRate value) {
        this.surchargeRate = value;
        return this;
    }
}
