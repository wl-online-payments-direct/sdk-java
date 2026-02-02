/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SubsequentPaymentRequest {

    private OmnichannelSubsequentSpecificInput omnichannelSubsequentSpecificInput;

    private Order order;

    private SubsequentPaymentProduct5001SpecificInput subsequentPaymentProduct5001SpecificInput;

    private SubsequentCardPaymentMethodSpecificInput subsequentcardPaymentMethodSpecificInput;

    /**
     * This object contains additional subsequent details for omnichannel merchants.
     */
    public OmnichannelSubsequentSpecificInput getOmnichannelSubsequentSpecificInput() {
        return omnichannelSubsequentSpecificInput;
    }

    /**
     * This object contains additional subsequent details for omnichannel merchants.
     */
    public void setOmnichannelSubsequentSpecificInput(OmnichannelSubsequentSpecificInput value) {
        this.omnichannelSubsequentSpecificInput = value;
    }

    /**
     * This object contains additional subsequent details for omnichannel merchants.
     */
    public SubsequentPaymentRequest withOmnichannelSubsequentSpecificInput(OmnichannelSubsequentSpecificInput value) {
        this.omnichannelSubsequentSpecificInput = value;
        return this;
    }

    /**
     * The order object contains order-related data;
     * Please note that this object is required to submit the amount.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * The order object contains order-related data;
     * Please note that this object is required to submit the amount.
     */
    public void setOrder(Order value) {
        this.order = value;
    }

    /**
     * The order object contains order-related data;
     * Please note that this object is required to submit the amount.
     */
    public SubsequentPaymentRequest withOrder(Order value) {
        this.order = value;
        return this;
    }

    /**
     * Specific data is required for Bizum subsequent payment.
     */
    public SubsequentPaymentProduct5001SpecificInput getSubsequentPaymentProduct5001SpecificInput() {
        return subsequentPaymentProduct5001SpecificInput;
    }

    /**
     * Specific data is required for Bizum subsequent payment.
     */
    public void setSubsequentPaymentProduct5001SpecificInput(SubsequentPaymentProduct5001SpecificInput value) {
        this.subsequentPaymentProduct5001SpecificInput = value;
    }

    /**
     * Specific data is required for Bizum subsequent payment.
     */
    public SubsequentPaymentRequest withSubsequentPaymentProduct5001SpecificInput(SubsequentPaymentProduct5001SpecificInput value) {
        this.subsequentPaymentProduct5001SpecificInput = value;
        return this;
    }

    /**
     * Object containing the specific input details for subsequent card payments
     */
    public SubsequentCardPaymentMethodSpecificInput getSubsequentcardPaymentMethodSpecificInput() {
        return subsequentcardPaymentMethodSpecificInput;
    }

    /**
     * Object containing the specific input details for subsequent card payments
     */
    public void setSubsequentcardPaymentMethodSpecificInput(SubsequentCardPaymentMethodSpecificInput value) {
        this.subsequentcardPaymentMethodSpecificInput = value;
    }

    /**
     * Object containing the specific input details for subsequent card payments
     */
    public SubsequentPaymentRequest withSubsequentcardPaymentMethodSpecificInput(SubsequentCardPaymentMethodSpecificInput value) {
        this.subsequentcardPaymentMethodSpecificInput = value;
        return this;
    }
}
