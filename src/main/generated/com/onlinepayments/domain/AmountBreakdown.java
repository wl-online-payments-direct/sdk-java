/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class AmountBreakdown {

    private Long amount;

    private String type;

    /**
     * Amount in cents and always having 2 decimals
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * Amount in cents and always having 2 decimals
     */
    public void setAmount(Long value) {
        this.amount = value;
    }

    /**
     * Amount in cents and always having 2 decimals
     */
    public AmountBreakdown withAmount(Long value) {
        this.amount = value;
        return this;
    }

    /**
     * Type of the amount. Each type is only allowed to be provided once. Allowed values:
     * <ul>
     *   <li>AIRPORT_TAX - The amount of tax paid for the airport, with the last 2 digits implied as decimal places.</li>
     *   <li>CONSUMPTION_TAX - The amount of consumption tax paid by the customer, with the last 2 digits implied as decimal places.</li>
     *   <li>DISCOUNT - Discount on the entire transaction, with the last 2 digits implied as decimal places.</li>
     *   <li>DUTY - Duty on the entire transaction, with the last 2 digits implied as decimal places.</li>
     *   <li>SHIPPING - Shipping cost on the entire transaction, with the last 2 digits implied as decimal places.</li>
     *   <li>VAT - Total amount of VAT paid on the transaction, with the last 2 digits implied as decimal places.</li>
     *   <li>BASE_AMOUNT - Order amount excluding all taxes, discount &amp; shipping costs, with the last 2 digits implied as decimal places. Note: BASE_AMOUNT is only supported by the payment platform.</li>
     * </ul>
     */
    public String getType() {
        return type;
    }

    /**
     * Type of the amount. Each type is only allowed to be provided once. Allowed values:
     * <ul>
     *   <li>AIRPORT_TAX - The amount of tax paid for the airport, with the last 2 digits implied as decimal places.</li>
     *   <li>CONSUMPTION_TAX - The amount of consumption tax paid by the customer, with the last 2 digits implied as decimal places.</li>
     *   <li>DISCOUNT - Discount on the entire transaction, with the last 2 digits implied as decimal places.</li>
     *   <li>DUTY - Duty on the entire transaction, with the last 2 digits implied as decimal places.</li>
     *   <li>SHIPPING - Shipping cost on the entire transaction, with the last 2 digits implied as decimal places.</li>
     *   <li>VAT - Total amount of VAT paid on the transaction, with the last 2 digits implied as decimal places.</li>
     *   <li>BASE_AMOUNT - Order amount excluding all taxes, discount &amp; shipping costs, with the last 2 digits implied as decimal places. Note: BASE_AMOUNT is only supported by the payment platform.</li>
     * </ul>
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Type of the amount. Each type is only allowed to be provided once. Allowed values:
     * <ul>
     *   <li>AIRPORT_TAX - The amount of tax paid for the airport, with the last 2 digits implied as decimal places.</li>
     *   <li>CONSUMPTION_TAX - The amount of consumption tax paid by the customer, with the last 2 digits implied as decimal places.</li>
     *   <li>DISCOUNT - Discount on the entire transaction, with the last 2 digits implied as decimal places.</li>
     *   <li>DUTY - Duty on the entire transaction, with the last 2 digits implied as decimal places.</li>
     *   <li>SHIPPING - Shipping cost on the entire transaction, with the last 2 digits implied as decimal places.</li>
     *   <li>VAT - Total amount of VAT paid on the transaction, with the last 2 digits implied as decimal places.</li>
     *   <li>BASE_AMOUNT - Order amount excluding all taxes, discount &amp; shipping costs, with the last 2 digits implied as decimal places. Note: BASE_AMOUNT is only supported by the payment platform.</li>
     * </ul>
     */
    public AmountBreakdown withType(String value) {
        this.type = value;
        return this;
    }
}
