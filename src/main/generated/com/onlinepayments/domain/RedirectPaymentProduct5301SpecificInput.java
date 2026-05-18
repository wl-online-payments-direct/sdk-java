/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RedirectPaymentProduct5301SpecificInput {

    private String paymentMethodType;

    /**
     * <ul>
     *   <li>invoice - The transaction is an invoice payment, transaction amount should be greater than €10 and less than €1500. * direct_debit - The transaction is a direct debit payment, transaction amount should be greater than €10 and less than €1500.</li>
     * </ul>
     */
    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    /**
     * <ul>
     *   <li>invoice - The transaction is an invoice payment, transaction amount should be greater than €10 and less than €1500. * direct_debit - The transaction is a direct debit payment, transaction amount should be greater than €10 and less than €1500.</li>
     * </ul>
     */
    public void setPaymentMethodType(String value) {
        this.paymentMethodType = value;
    }

    /**
     * <ul>
     *   <li>invoice - The transaction is an invoice payment, transaction amount should be greater than €10 and less than €1500. * direct_debit - The transaction is a direct debit payment, transaction amount should be greater than €10 and less than €1500.</li>
     * </ul>
     */
    public RedirectPaymentProduct5301SpecificInput withPaymentMethodType(String value) {
        this.paymentMethodType = value;
        return this;
    }
}
