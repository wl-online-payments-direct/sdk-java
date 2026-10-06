/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class PaymentLinkOverviewFiltering {

    private List<String> merchantIds;

    private List<String> status;

    /**
     * List of unique merchant IDs to filter the payment links by.
     */
    public List<String> getMerchantIds() {
        return merchantIds;
    }

    /**
     * List of unique merchant IDs to filter the payment links by.
     */
    public void setMerchantIds(List<String> value) {
        this.merchantIds = value;
    }

    /**
     * List of unique merchant IDs to filter the payment links by.
     */
    public PaymentLinkOverviewFiltering withMerchantIds(List<String> value) {
        this.merchantIds = value;
        return this;
    }

    /**
     * Filter payment links by their current status. You can provide one or more status values to retrieve only the links matching those statuses. When multiple statuses are provided, the response will include payment links matching ANY of the specified values (OR logic). If this parameter is omitted, payment links with all statuses will be returned. Possible values are:
     * <ul>
     *   <li>ACTIVE - Payment link is ready to be used</li>
     *   <li>CANCELLED - Payment link has been manually cancelled</li>
     *   <li>PAID - Payment has been successfully completed</li>
     *   <li>EXPIRED - Payment link has passed its expiration date</li>
     * </ul>
     */
    public List<String> getStatus() {
        return status;
    }

    /**
     * Filter payment links by their current status. You can provide one or more status values to retrieve only the links matching those statuses. When multiple statuses are provided, the response will include payment links matching ANY of the specified values (OR logic). If this parameter is omitted, payment links with all statuses will be returned. Possible values are:
     * <ul>
     *   <li>ACTIVE - Payment link is ready to be used</li>
     *   <li>CANCELLED - Payment link has been manually cancelled</li>
     *   <li>PAID - Payment has been successfully completed</li>
     *   <li>EXPIRED - Payment link has passed its expiration date</li>
     * </ul>
     */
    public void setStatus(List<String> value) {
        this.status = value;
    }

    /**
     * Filter payment links by their current status. You can provide one or more status values to retrieve only the links matching those statuses. When multiple statuses are provided, the response will include payment links matching ANY of the specified values (OR logic). If this parameter is omitted, payment links with all statuses will be returned. Possible values are:
     * <ul>
     *   <li>ACTIVE - Payment link is ready to be used</li>
     *   <li>CANCELLED - Payment link has been manually cancelled</li>
     *   <li>PAID - Payment has been successfully completed</li>
     *   <li>EXPIRED - Payment link has passed its expiration date</li>
     * </ul>
     */
    public PaymentLinkOverviewFiltering withStatus(List<String> value) {
        this.status = value;
        return this;
    }
}
