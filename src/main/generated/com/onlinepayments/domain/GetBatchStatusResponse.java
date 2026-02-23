/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class GetBatchStatusResponse {

    private Integer itemCount;

    private String merchantBatchReference;

    private String operationType;

    private String status;

    /**
     * The total number of items included in the batch submission.
     */
    public Integer getItemCount() {
        return itemCount;
    }

    /**
     * The total number of items included in the batch submission.
     */
    public void setItemCount(Integer value) {
        this.itemCount = value;
    }

    /**
     * The total number of items included in the batch submission.
     */
    public GetBatchStatusResponse withItemCount(Integer value) {
        this.itemCount = value;
        return this;
    }

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
    public GetBatchStatusResponse withMerchantBatchReference(String value) {
        this.merchantBatchReference = value;
        return this;
    }

    /**
     * The specific operation type being requested for the batch.
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * The specific operation type being requested for the batch.
     */
    public void setOperationType(String value) {
        this.operationType = value;
    }

    /**
     * The specific operation type being requested for the batch.
     */
    public GetBatchStatusResponse withOperationType(String value) {
        this.operationType = value;
        return this;
    }

    /**
     * The status of the batch.
     */
    public String getStatus() {
        return status;
    }

    /**
     * The status of the batch.
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * The status of the batch.
     */
    public GetBatchStatusResponse withStatus(String value) {
        this.status = value;
        return this;
    }
}
