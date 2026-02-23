/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SubmitBatchResponse {

    private String merchantBatchReference;

    private Integer totalCount;

    /**
     * Unique batch reference submitted by the merchant.
     */
    public String getMerchantBatchReference() {
        return merchantBatchReference;
    }

    /**
     * Unique batch reference submitted by the merchant.
     */
    public void setMerchantBatchReference(String value) {
        this.merchantBatchReference = value;
    }

    /**
     * Unique batch reference submitted by the merchant.
     */
    public SubmitBatchResponse withMerchantBatchReference(String value) {
        this.merchantBatchReference = value;
        return this;
    }

    /**
     * The total number of batch items that were included in the submitted batch.
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * The total number of batch items that were included in the submitted batch.
     */
    public void setTotalCount(Integer value) {
        this.totalCount = value;
    }

    /**
     * The total number of batch items that were included in the submitted batch.
     */
    public SubmitBatchResponse withTotalCount(Integer value) {
        this.totalCount = value;
        return this;
    }
}
