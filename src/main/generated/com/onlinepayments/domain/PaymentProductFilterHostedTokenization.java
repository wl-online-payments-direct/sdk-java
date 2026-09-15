/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class PaymentProductFilterHostedTokenization {

    private List<Integer> products;

    /**
     * List containing all payment product ids that should either be restricted to in or excluded from the payment context.
     */
    public List<Integer> getProducts() {
        return products;
    }

    /**
     * List containing all payment product ids that should either be restricted to in or excluded from the payment context.
     */
    public void setProducts(List<Integer> value) {
        this.products = value;
    }

    /**
     * List containing all payment product ids that should either be restricted to in or excluded from the payment context.
     */
    public PaymentProductFilterHostedTokenization withProducts(List<Integer> value) {
        this.products = value;
        return this;
    }
}
