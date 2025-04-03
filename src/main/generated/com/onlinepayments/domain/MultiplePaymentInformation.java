/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class MultiplePaymentInformation {

    private String paymentPattern;

    private Integer totalNumberOfPayments;

    /**
     * Typology of multiple payment. Allowed values:
     * <ul>
     *   <li>PartialShipment</li>
     * </ul>
     */
    public String getPaymentPattern() {
        return paymentPattern;
    }

    /**
     * Typology of multiple payment. Allowed values:
     * <ul>
     *   <li>PartialShipment</li>
     * </ul>
     */
    public void setPaymentPattern(String value) {
        this.paymentPattern = value;
    }

    /**
     * Typology of multiple payment. Allowed values:
     * <ul>
     *   <li>PartialShipment</li>
     * </ul>
     */
    public MultiplePaymentInformation withPaymentPattern(String value) {
        this.paymentPattern = value;
        return this;
    }

    /**
     * Total number of payments. If a payment is implied by this call, it implicitly has ordinal number 1.
     */
    public Integer getTotalNumberOfPayments() {
        return totalNumberOfPayments;
    }

    /**
     * Total number of payments. If a payment is implied by this call, it implicitly has ordinal number 1.
     */
    public void setTotalNumberOfPayments(Integer value) {
        this.totalNumberOfPayments = value;
    }

    /**
     * Total number of payments. If a payment is implied by this call, it implicitly has ordinal number 1.
     */
    public MultiplePaymentInformation withTotalNumberOfPayments(Integer value) {
        this.totalNumberOfPayments = value;
        return this;
    }
}
