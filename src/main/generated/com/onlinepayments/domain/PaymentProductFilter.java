/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class PaymentProductFilter {

    private List<String> groups;

    private List<Integer> products;

    /**
     * List containing all payment product groups that should either be restricted to in or excluded from the payment context. Currently, there is only one group, called 'cards'.
     */
    public List<String> getGroups() {
        return groups;
    }

    /**
     * List containing all payment product groups that should either be restricted to in or excluded from the payment context. Currently, there is only one group, called 'cards'.
     */
    public void setGroups(List<String> value) {
        this.groups = value;
    }

    /**
     * List containing all payment product groups that should either be restricted to in or excluded from the payment context. Currently, there is only one group, called 'cards'.
     */
    public PaymentProductFilter withGroups(List<String> value) {
        this.groups = value;
        return this;
    }

    public List<Integer> getProducts() {
        return products;
    }

    public void setProducts(List<Integer> value) {
        this.products = value;
    }

    public PaymentProductFilter withProducts(List<Integer> value) {
        this.products = value;
        return this;
    }
}
