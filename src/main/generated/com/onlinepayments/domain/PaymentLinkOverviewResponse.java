/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class PaymentLinkOverviewResponse {

    private Pagination pagination;

    private List<PaymentLinkOverviewEntry> paymentLinkOverviewEntries;

    private Long total;

    /**
     * Object containing pagination parameters.
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * Object containing pagination parameters.
     */
    public void setPagination(Pagination value) {
        this.pagination = value;
    }

    /**
     * Object containing pagination parameters.
     */
    public PaymentLinkOverviewResponse withPagination(Pagination value) {
        this.pagination = value;
        return this;
    }

    /**
     * Array of payment link overview entries matching the specified filters.
     */
    public List<PaymentLinkOverviewEntry> getPaymentLinkOverviewEntries() {
        return paymentLinkOverviewEntries;
    }

    /**
     * Array of payment link overview entries matching the specified filters.
     */
    public void setPaymentLinkOverviewEntries(List<PaymentLinkOverviewEntry> value) {
        this.paymentLinkOverviewEntries = value;
    }

    /**
     * Array of payment link overview entries matching the specified filters.
     */
    public PaymentLinkOverviewResponse withPaymentLinkOverviewEntries(List<PaymentLinkOverviewEntry> value) {
        this.paymentLinkOverviewEntries = value;
        return this;
    }

    /**
     * Total number of payment links matching the request filters across all pages.
     */
    public Long getTotal() {
        return total;
    }

    /**
     * Total number of payment links matching the request filters across all pages.
     */
    public void setTotal(Long value) {
        this.total = value;
    }

    /**
     * Total number of payment links matching the request filters across all pages.
     */
    public PaymentLinkOverviewResponse withTotal(Long value) {
        this.total = value;
        return this;
    }
}
