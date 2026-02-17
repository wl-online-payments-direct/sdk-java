/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class ShoppingCartOutput {

    private List<LineItemDetail> lineItemDetails;

    /**
     * List of lineItemIds and quantities for capture/refund/cancellation.
     */
    public List<LineItemDetail> getLineItemDetails() {
        return lineItemDetails;
    }

    /**
     * List of lineItemIds and quantities for capture/refund/cancellation.
     */
    public void setLineItemDetails(List<LineItemDetail> value) {
        this.lineItemDetails = value;
    }

    /**
     * List of lineItemIds and quantities for capture/refund/cancellation.
     */
    public ShoppingCartOutput withLineItemDetails(List<LineItemDetail> value) {
        this.lineItemDetails = value;
        return this;
    }
}
