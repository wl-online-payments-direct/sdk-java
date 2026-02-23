/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class SubmitBatchRequestBody {

    private List<CancelPaymentBatchRequest> cancelPayments;

    private List<CapturePaymentBatchRequest> capturePayments;

    private List<CreatePaymentLinkRequest> createPaymentLinks;

    private List<CreatePaymentRequest> createPayments;

    private List<CreatePayoutRequest> createPayouts;

    private BatchMetadata header;

    private List<RefundPaymentBatchRequest> refundPayments;

    private List<SubsequentPaymentBatchRequest> subsequentPayments;

    /**
     * Array of cancel payment requests to be submitted in batch.
     */
    public List<CancelPaymentBatchRequest> getCancelPayments() {
        return cancelPayments;
    }

    /**
     * Array of cancel payment requests to be submitted in batch.
     */
    public void setCancelPayments(List<CancelPaymentBatchRequest> value) {
        this.cancelPayments = value;
    }

    /**
     * Array of cancel payment requests to be submitted in batch.
     */
    public SubmitBatchRequestBody withCancelPayments(List<CancelPaymentBatchRequest> value) {
        this.cancelPayments = value;
        return this;
    }

    /**
     * Array of capture payment requests to be submitted in batch.
     */
    public List<CapturePaymentBatchRequest> getCapturePayments() {
        return capturePayments;
    }

    /**
     * Array of capture payment requests to be submitted in batch.
     */
    public void setCapturePayments(List<CapturePaymentBatchRequest> value) {
        this.capturePayments = value;
    }

    /**
     * Array of capture payment requests to be submitted in batch.
     */
    public SubmitBatchRequestBody withCapturePayments(List<CapturePaymentBatchRequest> value) {
        this.capturePayments = value;
        return this;
    }

    /**
     * An array containing multiple payment link generation requests that will be processed as a batch. Each item represents an individual payment link to be created.
     */
    public List<CreatePaymentLinkRequest> getCreatePaymentLinks() {
        return createPaymentLinks;
    }

    /**
     * An array containing multiple payment link generation requests that will be processed as a batch. Each item represents an individual payment link to be created.
     */
    public void setCreatePaymentLinks(List<CreatePaymentLinkRequest> value) {
        this.createPaymentLinks = value;
    }

    /**
     * An array containing multiple payment link generation requests that will be processed as a batch. Each item represents an individual payment link to be created.
     */
    public SubmitBatchRequestBody withCreatePaymentLinks(List<CreatePaymentLinkRequest> value) {
        this.createPaymentLinks = value;
        return this;
    }

    /**
     * Array of payment creation requests to be submitted in batch.
     */
    public List<CreatePaymentRequest> getCreatePayments() {
        return createPayments;
    }

    /**
     * Array of payment creation requests to be submitted in batch.
     */
    public void setCreatePayments(List<CreatePaymentRequest> value) {
        this.createPayments = value;
    }

    /**
     * Array of payment creation requests to be submitted in batch.
     */
    public SubmitBatchRequestBody withCreatePayments(List<CreatePaymentRequest> value) {
        this.createPayments = value;
        return this;
    }

    /**
     * Array of payout creation requests to be submitted in batch.
     */
    public List<CreatePayoutRequest> getCreatePayouts() {
        return createPayouts;
    }

    /**
     * Array of payout creation requests to be submitted in batch.
     */
    public void setCreatePayouts(List<CreatePayoutRequest> value) {
        this.createPayouts = value;
    }

    /**
     * Array of payout creation requests to be submitted in batch.
     */
    public SubmitBatchRequestBody withCreatePayouts(List<CreatePayoutRequest> value) {
        this.createPayouts = value;
        return this;
    }

    /**
     * Details about the batch, including the type of operation, the merchant batch reference, and the number of items in the batch.
     */
    public BatchMetadata getHeader() {
        return header;
    }

    /**
     * Details about the batch, including the type of operation, the merchant batch reference, and the number of items in the batch.
     */
    public void setHeader(BatchMetadata value) {
        this.header = value;
    }

    /**
     * Details about the batch, including the type of operation, the merchant batch reference, and the number of items in the batch.
     */
    public SubmitBatchRequestBody withHeader(BatchMetadata value) {
        this.header = value;
        return this;
    }

    /**
     * Array of refund payment requests to be submitted in batch.
     */
    public List<RefundPaymentBatchRequest> getRefundPayments() {
        return refundPayments;
    }

    /**
     * Array of refund payment requests to be submitted in batch.
     */
    public void setRefundPayments(List<RefundPaymentBatchRequest> value) {
        this.refundPayments = value;
    }

    /**
     * Array of refund payment requests to be submitted in batch.
     */
    public SubmitBatchRequestBody withRefundPayments(List<RefundPaymentBatchRequest> value) {
        this.refundPayments = value;
        return this;
    }

    /**
     * Array of subsequent payment requests to be submitted in batch.
     */
    public List<SubsequentPaymentBatchRequest> getSubsequentPayments() {
        return subsequentPayments;
    }

    /**
     * Array of subsequent payment requests to be submitted in batch.
     */
    public void setSubsequentPayments(List<SubsequentPaymentBatchRequest> value) {
        this.subsequentPayments = value;
    }

    /**
     * Array of subsequent payment requests to be submitted in batch.
     */
    public SubmitBatchRequestBody withSubsequentPayments(List<SubsequentPaymentBatchRequest> value) {
        this.subsequentPayments = value;
        return this;
    }
}
