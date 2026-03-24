/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ShippingDetail {

    private Long shippingCost;

    private Long shippingCostTax;

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public Long getShippingCost() {
        return shippingCost;
    }

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public void setShippingCost(Long value) {
        this.shippingCost = value;
    }

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public ShippingDetail withShippingCost(Long value) {
        this.shippingCost = value;
        return this;
    }

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public Long getShippingCostTax() {
        return shippingCostTax;
    }

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public void setShippingCostTax(Long value) {
        this.shippingCostTax = value;
    }

    /**
     * Amount in the smallest currency unit, i.e.:
     * <ul>
     *   <li>EUR is a 2-decimals currency, the value 1234 will result in EUR 12.34</li>
     *   <li>KWD is a 3-decimals currency, the value 1234 will result in KWD 1.234</li>
     *   <li>JPY is a zero-decimal currency, the value 1234 will result in JPY 1234</li>
     * </ul>
     */
    public ShippingDetail withShippingCostTax(Long value) {
        this.shippingCostTax = value;
        return this;
    }
}
