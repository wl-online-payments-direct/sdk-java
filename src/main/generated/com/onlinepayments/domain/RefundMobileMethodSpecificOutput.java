/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RefundMobileMethodSpecificOutput {

    private String network;

    private Long totalAmountPaid;

    private Long totalAmountRefunded;

    /**
     * The card network that was used for a mobile payment method operation
     */
    public String getNetwork() {
        return network;
    }

    /**
     * The card network that was used for a mobile payment method operation
     */
    public void setNetwork(String value) {
        this.network = value;
    }

    /**
     * The card network that was used for a mobile payment method operation
     */
    public RefundMobileMethodSpecificOutput withNetwork(String value) {
        this.network = value;
        return this;
    }

    public Long getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(Long value) {
        this.totalAmountPaid = value;
    }

    public RefundMobileMethodSpecificOutput withTotalAmountPaid(Long value) {
        this.totalAmountPaid = value;
        return this;
    }

    public Long getTotalAmountRefunded() {
        return totalAmountRefunded;
    }

    public void setTotalAmountRefunded(Long value) {
        this.totalAmountRefunded = value;
    }

    public RefundMobileMethodSpecificOutput withTotalAmountRefunded(Long value) {
        this.totalAmountRefunded = value;
        return this;
    }
}
