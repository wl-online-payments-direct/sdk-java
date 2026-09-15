/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ThreeDsInputData {

    private String acquirerId;

    private String acquirerMid;

    private String requestorId;

    /**
     * Merchant’s Acquirer ID.
     */
    public String getAcquirerId() {
        return acquirerId;
    }

    /**
     * Merchant’s Acquirer ID.
     */
    public void setAcquirerId(String value) {
        this.acquirerId = value;
    }

    /**
     * Merchant’s Acquirer ID.
     */
    public ThreeDsInputData withAcquirerId(String value) {
        this.acquirerId = value;
        return this;
    }

    /**
     * Acquirer’s Merchant ID.
     */
    public String getAcquirerMid() {
        return acquirerMid;
    }

    /**
     * Acquirer’s Merchant ID.
     */
    public void setAcquirerMid(String value) {
        this.acquirerMid = value;
    }

    /**
     * Acquirer’s Merchant ID.
     */
    public ThreeDsInputData withAcquirerMid(String value) {
        this.acquirerMid = value;
        return this;
    }

    /**
     * The ID assigned to the merchant for authentication request to initiate 3DS with MPI.
     */
    public String getRequestorId() {
        return requestorId;
    }

    /**
     * The ID assigned to the merchant for authentication request to initiate 3DS with MPI.
     */
    public void setRequestorId(String value) {
        this.requestorId = value;
    }

    /**
     * The ID assigned to the merchant for authentication request to initiate 3DS with MPI.
     */
    public ThreeDsInputData withRequestorId(String value) {
        this.requestorId = value;
        return this;
    }
}
