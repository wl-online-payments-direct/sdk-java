/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class OmnichannelPayoutSpecificInput {

    private String paymentId;

    /**
     * The Payment Id of the transaction (either in-store or online), from which you request to make a refund.
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * The Payment Id of the transaction (either in-store or online), from which you request to make a refund.
     */
    public void setPaymentId(String value) {
        this.paymentId = value;
    }

    /**
     * The Payment Id of the transaction (either in-store or online), from which you request to make a refund.
     */
    public OmnichannelPayoutSpecificInput withPaymentId(String value) {
        this.paymentId = value;
        return this;
    }
}
