/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProduct130SpecificThreeDSecure {

    private Boolean acquirerExemption;

    private String merchantScore;

    private Integer numberOfItems;

    private String usecase;

    /**
     * Indicates the Acquirer TRA exemption
     */
    public Boolean getAcquirerExemption() {
        return acquirerExemption;
    }

    /**
     * Indicates the Acquirer TRA exemption
     */
    public void setAcquirerExemption(Boolean value) {
        this.acquirerExemption = value;
    }

    /**
     * Indicates the Acquirer TRA exemption
     */
    public PaymentProduct130SpecificThreeDSecure withAcquirerExemption(Boolean value) {
        this.acquirerExemption = value;
        return this;
    }

    /**
     * Score calculated by the 3DS Requestor and provided to CB Scoring service only.
     */
    public String getMerchantScore() {
        return merchantScore;
    }

    /**
     * Score calculated by the 3DS Requestor and provided to CB Scoring service only.
     */
    public void setMerchantScore(String value) {
        this.merchantScore = value;
    }

    /**
     * Score calculated by the 3DS Requestor and provided to CB Scoring service only.
     */
    public PaymentProduct130SpecificThreeDSecure withMerchantScore(String value) {
        this.merchantScore = value;
        return this;
    }

    /**
     * Number of purchased items or services. 99 if more than 99 items
     */
    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    /**
     * Number of purchased items or services. 99 if more than 99 items
     */
    public void setNumberOfItems(Integer value) {
        this.numberOfItems = value;
    }

    /**
     * Number of purchased items or services. 99 if more than 99 items
     */
    public PaymentProduct130SpecificThreeDSecure withNumberOfItems(Integer value) {
        this.numberOfItems = value;
        return this;
    }

    /**
     * Indicates the type of payment for which an authentication is requested
     */
    public String getUsecase() {
        return usecase;
    }

    /**
     * Indicates the type of payment for which an authentication is requested
     */
    public void setUsecase(String value) {
        this.usecase = value;
    }

    /**
     * Indicates the type of payment for which an authentication is requested
     */
    public PaymentProduct130SpecificThreeDSecure withUsecase(String value) {
        this.usecase = value;
        return this;
    }
}
