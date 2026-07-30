/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class PaymentsReportResponse {

    private CursorPaginationInfo pagination;

    private List<PaymentSummary> payments;

    /**
     * Pagination information for cursor-based pagination
     */
    public CursorPaginationInfo getPagination() {
        return pagination;
    }

    /**
     * Pagination information for cursor-based pagination
     */
    public void setPagination(CursorPaginationInfo value) {
        this.pagination = value;
    }

    /**
     * Pagination information for cursor-based pagination
     */
    public PaymentsReportResponse withPagination(CursorPaginationInfo value) {
        this.pagination = value;
        return this;
    }

    /**
     * List of payment summaries
     */
    public List<PaymentSummary> getPayments() {
        return payments;
    }

    /**
     * List of payment summaries
     */
    public void setPayments(List<PaymentSummary> value) {
        this.payments = value;
    }

    /**
     * List of payment summaries
     */
    public PaymentsReportResponse withPayments(List<PaymentSummary> value) {
        this.payments = value;
        return this;
    }
}
