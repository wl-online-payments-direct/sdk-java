/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SurchargeSpecificOutput {

    private String mode;

    private AmountOfMoney surchargeAmount;

    private SurchargeRate surchargeRate;

    /**
     * The surcharge mode applied to an order.
     */
    public String getMode() {
        return mode;
    }

    /**
     * The surcharge mode applied to an order.
     */
    public void setMode(String value) {
        this.mode = value;
    }

    /**
     * The surcharge mode applied to an order.
     */
    public SurchargeSpecificOutput withMode(String value) {
        this.mode = value;
        return this;
    }

    /**
     * The surcharge amount of money applied to an order.
     */
    public AmountOfMoney getSurchargeAmount() {
        return surchargeAmount;
    }

    /**
     * The surcharge amount of money applied to an order.
     */
    public void setSurchargeAmount(AmountOfMoney value) {
        this.surchargeAmount = value;
    }

    /**
     * The surcharge amount of money applied to an order.
     */
    public SurchargeSpecificOutput withSurchargeAmount(AmountOfMoney value) {
        this.surchargeAmount = value;
        return this;
    }

    /**
     * A summary of surcharge details used in the calculation of the surcharge amount.  Null if result = NO_SURCHARGE
     */
    public SurchargeRate getSurchargeRate() {
        return surchargeRate;
    }

    /**
     * A summary of surcharge details used in the calculation of the surcharge amount.  Null if result = NO_SURCHARGE
     */
    public void setSurchargeRate(SurchargeRate value) {
        this.surchargeRate = value;
    }

    /**
     * A summary of surcharge details used in the calculation of the surcharge amount.  Null if result = NO_SURCHARGE
     */
    public SurchargeSpecificOutput withSurchargeRate(SurchargeRate value) {
        this.surchargeRate = value;
        return this;
    }
}
