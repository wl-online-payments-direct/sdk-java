/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class BatchMetadata {

    private Integer itemCount;

    private String merchantBatchReference;

    private String operationType;

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
    public BatchMetadata withItemCount(Integer value) {
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
    public BatchMetadata withMerchantBatchReference(String value) {
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
    public BatchMetadata withOperationType(String value) {
        this.operationType = value;
        return this;
    }
}
