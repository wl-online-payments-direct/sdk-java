/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class GetPaymentProductGroupsResponse {

    private List<PaymentProductGroup> paymentProductGroups;

    /**
     * Array containing payment product groups and their characteristics
     */
    public List<PaymentProductGroup> getPaymentProductGroups() {
        return paymentProductGroups;
    }

    /**
     * Array containing payment product groups and their characteristics
     */
    public void setPaymentProductGroups(List<PaymentProductGroup> value) {
        this.paymentProductGroups = value;
    }

    /**
     * Array containing payment product groups and their characteristics
     */
    public GetPaymentProductGroupsResponse withPaymentProductGroups(List<PaymentProductGroup> value) {
        this.paymentProductGroups = value;
        return this;
    }
}
