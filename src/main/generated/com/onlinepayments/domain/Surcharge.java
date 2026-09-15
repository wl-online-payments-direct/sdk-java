/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class Surcharge {

    private AmountOfMoney netAmount;

    private Integer paymentProductId;

    private String result;

    private AmountOfMoney surchargeAmount;

    private SurchargeRate surchargeRate;

    private AmountOfMoney totalAmount;

    /**
     * The amount of money to be charged to a payer not including any surcharge amount.
     */
    public AmountOfMoney getNetAmount() {
        return netAmount;
    }

    /**
     * The amount of money to be charged to a payer not including any surcharge amount.
     */
    public void setNetAmount(AmountOfMoney value) {
        this.netAmount = value;
    }

    /**
     * The amount of money to be charged to a payer not including any surcharge amount.
     */
    public Surcharge withNetAmount(AmountOfMoney value) {
        this.netAmount = value;
        return this;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public Integer getPaymentProductId() {
        return paymentProductId;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public void setPaymentProductId(Integer value) {
        this.paymentProductId = value;
    }

    /**
     * Payment product identifier - Please see Products documentation for a full overview of possible values.
     */
    public Surcharge withPaymentProductId(Integer value) {
        this.paymentProductId = value;
        return this;
    }

    /**
     * Token describing result. OK - A Surcharge Amount was successfully calculated, NO_SURCHARGE - A configured surcharge rate could not be found for the payment product
     */
    public String getResult() {
        return result;
    }

    /**
     * Token describing result. OK - A Surcharge Amount was successfully calculated, NO_SURCHARGE - A configured surcharge rate could not be found for the payment product
     */
    public void setResult(String value) {
        this.result = value;
    }

    /**
     * Token describing result. OK - A Surcharge Amount was successfully calculated, NO_SURCHARGE - A configured surcharge rate could not be found for the payment product
     */
    public Surcharge withResult(String value) {
        this.result = value;
        return this;
    }

    /**
     * The amount of money to be charged to a payer, in addition to the net amount to cover the cost of processing that payment.  This value is calculated on the payment amount provided in the request, and the applicable ad valorem and/or specific surcharge rate configured for the merchant, for that payment.
     */
    public AmountOfMoney getSurchargeAmount() {
        return surchargeAmount;
    }

    /**
     * The amount of money to be charged to a payer, in addition to the net amount to cover the cost of processing that payment.  This value is calculated on the payment amount provided in the request, and the applicable ad valorem and/or specific surcharge rate configured for the merchant, for that payment.
     */
    public void setSurchargeAmount(AmountOfMoney value) {
        this.surchargeAmount = value;
    }

    /**
     * The amount of money to be charged to a payer, in addition to the net amount to cover the cost of processing that payment.  This value is calculated on the payment amount provided in the request, and the applicable ad valorem and/or specific surcharge rate configured for the merchant, for that payment.
     */
    public Surcharge withSurchargeAmount(AmountOfMoney value) {
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
    public Surcharge withSurchargeRate(SurchargeRate value) {
        this.surchargeRate = value;
        return this;
    }

    /**
     * The amount of money to be charged to a payer including any applicable surcharge. If you intend to apply additional services to the transaction before processing payment (such as DCC- Dynamic Currency Conversion), it is important to use this amount containing the surcharge instead of the net amount.
     */
    public AmountOfMoney getTotalAmount() {
        return totalAmount;
    }

    /**
     * The amount of money to be charged to a payer including any applicable surcharge. If you intend to apply additional services to the transaction before processing payment (such as DCC- Dynamic Currency Conversion), it is important to use this amount containing the surcharge instead of the net amount.
     */
    public void setTotalAmount(AmountOfMoney value) {
        this.totalAmount = value;
    }

    /**
     * The amount of money to be charged to a payer including any applicable surcharge. If you intend to apply additional services to the transaction before processing payment (such as DCC- Dynamic Currency Conversion), it is important to use this amount containing the surcharge instead of the net amount.
     */
    public Surcharge withTotalAmount(AmountOfMoney value) {
        this.totalAmount = value;
        return this;
    }
}
