/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class GetPaymentProductGroupsResponse {

    private List<PaymentProductGroup> paymentProductGroups;

    public List<PaymentProductGroup> getPaymentProductGroups() {
        return paymentProductGroups;
    }

    public void setPaymentProductGroups(List<PaymentProductGroup> value) {
        this.paymentProductGroups = value;
    }

    public GetPaymentProductGroupsResponse withPaymentProductGroups(List<PaymentProductGroup> value) {
        this.paymentProductGroups = value;
        return this;
    }
}
