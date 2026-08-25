package com.onlinepayments.it.util.merchantBatch;

import com.onlinepayments.merchant.merchantbatch.GetPaymentsReportParams;

public class GetPaymentsReportParamsBuilder {
    private String cursor = null;
    private Integer limit = null;

    public GetPaymentsReportParamsBuilder withCursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    public GetPaymentsReportParamsBuilder withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    public GetPaymentsReportParams build() {
        GetPaymentsReportParams params = new GetPaymentsReportParams();

        if (cursor != null) {
            params.withCursor(cursor);
        }

        if (limit != null) {
            params.withLimit(limit);
        }

        return params;
    }
}
