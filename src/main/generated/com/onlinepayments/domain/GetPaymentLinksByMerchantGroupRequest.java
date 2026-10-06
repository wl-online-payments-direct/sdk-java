/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class GetPaymentLinksByMerchantGroupRequest {

    private PaymentLinkOverviewFiltering filtering;

    private Pagination pagination;

    private PaymentLinkOverviewSorting sorting;

    /**
     * Object containing the filter criteria for retrieving payment links.
     */
    public PaymentLinkOverviewFiltering getFiltering() {
        return filtering;
    }

    /**
     * Object containing the filter criteria for retrieving payment links.
     */
    public void setFiltering(PaymentLinkOverviewFiltering value) {
        this.filtering = value;
    }

    /**
     * Object containing the filter criteria for retrieving payment links.
     */
    public GetPaymentLinksByMerchantGroupRequest withFiltering(PaymentLinkOverviewFiltering value) {
        this.filtering = value;
        return this;
    }

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
    public GetPaymentLinksByMerchantGroupRequest withPagination(Pagination value) {
        this.pagination = value;
        return this;
    }

    /**
     * Object containing sorting parameters.
     */
    public PaymentLinkOverviewSorting getSorting() {
        return sorting;
    }

    /**
     * Object containing sorting parameters.
     */
    public void setSorting(PaymentLinkOverviewSorting value) {
        this.sorting = value;
    }

    /**
     * Object containing sorting parameters.
     */
    public GetPaymentLinksByMerchantGroupRequest withSorting(PaymentLinkOverviewSorting value) {
        this.sorting = value;
        return this;
    }
}
