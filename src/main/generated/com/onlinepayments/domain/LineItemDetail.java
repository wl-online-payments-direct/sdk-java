/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class LineItemDetail {

    private String lineItemId;

    private Long quantity;

    /**
     * The unique ID for each line item.
     */
    public String getLineItemId() {
        return lineItemId;
    }

    /**
     * The unique ID for each line item.
     */
    public void setLineItemId(String value) {
        this.lineItemId = value;
    }

    /**
     * The unique ID for each line item.
     */
    public LineItemDetail withLineItemId(String value) {
        this.lineItemId = value;
        return this;
    }

    /**
     * Quantity of the units being purchased, should be greater than zero Note: Must not be all spaces or all zeros
     */
    public Long getQuantity() {
        return quantity;
    }

    /**
     * Quantity of the units being purchased, should be greater than zero Note: Must not be all spaces or all zeros
     */
    public void setQuantity(Long value) {
        this.quantity = value;
    }

    /**
     * Quantity of the units being purchased, should be greater than zero Note: Must not be all spaces or all zeros
     */
    public LineItemDetail withQuantity(Long value) {
        this.quantity = value;
        return this;
    }
}
