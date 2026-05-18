/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class LineItemDetail {

    private Long discountAmount;

    private String lineItemId;

    private Long quantity;

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public Long getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public void setDiscountAmount(Long value) {
        this.discountAmount = value;
    }

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public LineItemDetail withDiscountAmount(Long value) {
        this.discountAmount = value;
        return this;
    }

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
