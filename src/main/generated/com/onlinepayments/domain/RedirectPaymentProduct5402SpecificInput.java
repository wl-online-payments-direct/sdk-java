/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RedirectPaymentProduct5402SpecificInput {

    private Boolean completeRemainingPaymentAmount;

    /**
     * Determines how the remaining payment amount is handled if the initial payment is insufficient.
     * <ul>
     *   <li>{@code true}: The payment process will continue on our side, allowing the customer to pay the outstanding amount using a different payment method.</li>
     *   <li>{@code false}: Merchant must create and process a separate payment for the remaining amount independently.</li>
     * </ul>
     */
    public Boolean getCompleteRemainingPaymentAmount() {
        return completeRemainingPaymentAmount;
    }

    /**
     * Determines how the remaining payment amount is handled if the initial payment is insufficient.
     * <ul>
     *   <li>{@code true}: The payment process will continue on our side, allowing the customer to pay the outstanding amount using a different payment method.</li>
     *   <li>{@code false}: Merchant must create and process a separate payment for the remaining amount independently.</li>
     * </ul>
     */
    public void setCompleteRemainingPaymentAmount(Boolean value) {
        this.completeRemainingPaymentAmount = value;
    }

    /**
     * Determines how the remaining payment amount is handled if the initial payment is insufficient.
     * <ul>
     *   <li>{@code true}: The payment process will continue on our side, allowing the customer to pay the outstanding amount using a different payment method.</li>
     *   <li>{@code false}: Merchant must create and process a separate payment for the remaining amount independently.</li>
     * </ul>
     */
    public RedirectPaymentProduct5402SpecificInput withCompleteRemainingPaymentAmount(Boolean value) {
        this.completeRemainingPaymentAmount = value;
        return this;
    }
}
