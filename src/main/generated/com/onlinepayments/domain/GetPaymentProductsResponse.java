/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class GetPaymentProductsResponse {

    private List<PaymentProduct> paymentProducts;

    /**
     * Array containing payment products and their characteristics
     */
    public List<PaymentProduct> getPaymentProducts() {
        return paymentProducts;
    }

    /**
     * Array containing payment products and their characteristics
     */
    public void setPaymentProducts(List<PaymentProduct> value) {
        this.paymentProducts = value;
    }

    /**
     * Array containing payment products and their characteristics
     */
    public GetPaymentProductsResponse withPaymentProducts(List<PaymentProduct> value) {
        this.paymentProducts = value;
        return this;
    }
}
