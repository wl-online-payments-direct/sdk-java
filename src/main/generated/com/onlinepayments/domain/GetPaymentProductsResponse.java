/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class GetPaymentProductsResponse {

    private List<PaymentProduct> paymentProducts;

    public List<PaymentProduct> getPaymentProducts() {
        return paymentProducts;
    }

    public void setPaymentProducts(List<PaymentProduct> value) {
        this.paymentProducts = value;
    }

    public GetPaymentProductsResponse withPaymentProducts(List<PaymentProduct> value) {
        this.paymentProducts = value;
        return this;
    }
}
