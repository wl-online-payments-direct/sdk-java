/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class PaymentLinksResponse {

    private List<PaymentLinkResponse> PaymentLinks;

    public List<PaymentLinkResponse> getPaymentLinks() {
        return PaymentLinks;
    }

    public void setPaymentLinks(List<PaymentLinkResponse> value) {
        this.PaymentLinks = value;
    }

    public PaymentLinksResponse withPaymentLinks(List<PaymentLinkResponse> value) {
        this.PaymentLinks = value;
        return this;
    }
}
