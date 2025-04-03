/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class FraudFields {

    private String blackListData;

    private String customerIpAddress;

    private List<String> productCategories;

    /**
     * Additional black list input
     */
    public String getBlackListData() {
        return blackListData;
    }

    /**
     * Additional black list input
     */
    public void setBlackListData(String value) {
        this.blackListData = value;
    }

    /**
     * Additional black list input
     */
    public FraudFields withBlackListData(String value) {
        this.blackListData = value;
        return this;
    }

    /**
     * Deprecated: Use order.customer.device.ipAddress instead.
     * <p>
     * The IP Address of the customer that is making the payment
     *
     * @deprecated Use order.customer.device.ipAddress instead.  The IP Address of the customer that is making the payment
     */
    @Deprecated
    public String getCustomerIpAddress() {
        return customerIpAddress;
    }

    /**
     * Deprecated: Use order.customer.device.ipAddress instead.
     * <p>
     * The IP Address of the customer that is making the payment
     *
     * @deprecated Use order.customer.device.ipAddress instead.  The IP Address of the customer that is making the payment
     */
    @Deprecated
    public void setCustomerIpAddress(String value) {
        this.customerIpAddress = value;
    }

    /**
     * Deprecated: Use order.customer.device.ipAddress instead.
     * <p>
     * The IP Address of the customer that is making the payment
     *
     * @deprecated Use order.customer.device.ipAddress instead.  The IP Address of the customer that is making the payment
     */
    @Deprecated
    public FraudFields withCustomerIpAddress(String value) {
        this.customerIpAddress = value;
        return this;
    }

    /**
     * List of product categories that are being purchased.
     */
    public List<String> getProductCategories() {
        return productCategories;
    }

    /**
     * List of product categories that are being purchased.
     */
    public void setProductCategories(List<String> value) {
        this.productCategories = value;
    }

    /**
     * List of product categories that are being purchased.
     */
    public FraudFields withProductCategories(List<String> value) {
        this.productCategories = value;
        return this;
    }
}
