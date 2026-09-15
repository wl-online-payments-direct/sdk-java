/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SurchargeSpecificInput {

    private String mode;

    private AmountOfMoney surchargeAmount;

    /**
     * The surcharge mode to be applied to an order.
     */
    public String getMode() {
        return mode;
    }

    /**
     * The surcharge mode to be applied to an order.
     */
    public void setMode(String value) {
        this.mode = value;
    }

    /**
     * The surcharge mode to be applied to an order.
     */
    public SurchargeSpecificInput withMode(String value) {
        this.mode = value;
        return this;
    }

    /**
     * The surcharge amount of money to be applied to an order given that the merchant is in pass-through mode.
     */
    public AmountOfMoney getSurchargeAmount() {
        return surchargeAmount;
    }

    /**
     * The surcharge amount of money to be applied to an order given that the merchant is in pass-through mode.
     */
    public void setSurchargeAmount(AmountOfMoney value) {
        this.surchargeAmount = value;
    }

    /**
     * The surcharge amount of money to be applied to an order given that the merchant is in pass-through mode.
     */
    public SurchargeSpecificInput withSurchargeAmount(AmountOfMoney value) {
        this.surchargeAmount = value;
        return this;
    }
}
