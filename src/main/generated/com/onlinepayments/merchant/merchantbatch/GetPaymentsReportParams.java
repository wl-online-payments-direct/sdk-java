/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.merchantbatch;

import java.util.ArrayList;
import java.util.List;

import com.onlinepayments.communication.ParamRequest;
import com.onlinepayments.communication.RequestParam;

/**
 * Query parameters for
 * Get payments report (/v2/{merchantId}/merchant-batches/{merchantBatchReference}/reports/payments)
 */
public class GetPaymentsReportParams implements ParamRequest {

    private String cursor;

    private Integer limit;

    /**
     * Opaque cursor for pagination. Omit for the first page, use value from previous response for subsequent pages.
     */
    public String getCursor() {
        return cursor;
    }

    /**
     * Opaque cursor for pagination. Omit for the first page, use value from previous response for subsequent pages.
     */
    public void setCursor(String value) {
        this.cursor = value;
    }

    /**
     * Opaque cursor for pagination. Omit for the first page, use value from previous response for subsequent pages.
     */
    public GetPaymentsReportParams withCursor(String value) {
        this.cursor = value;
        return this;
    }

    /**
     * Maximum number of items to return per page.
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Maximum number of items to return per page.
     */
    public void setLimit(Integer value) {
        this.limit = value;
    }

    /**
     * Maximum number of items to return per page.
     */
    public GetPaymentsReportParams withLimit(Integer value) {
        this.limit = value;
        return this;
    }

    @Override
    public List<RequestParam> toRequestParameters() {
        List<RequestParam> result = new ArrayList<>();
        if (cursor != null) {
            result.add(new RequestParam("cursor", cursor));
        }
        if (limit != null) {
            result.add(new RequestParam("limit", limit.toString()));
        }
        return result;
    }
}
