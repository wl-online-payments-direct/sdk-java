/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SubsequentPaymentRequest {

    private Order order;

    private SubsequentPaymentProduct5001SpecificInput subsequentPaymentProduct5001SpecificInput;

    private SubsequentCardPaymentMethodSpecificInput subsequentcardPaymentMethodSpecificInput;

    /**
     * Order object containing order related data
     * Please note that this object is required to be able to submit the amount.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Order object containing order related data
     * Please note that this object is required to be able to submit the amount.
     */
    public void setOrder(Order value) {
        this.order = value;
    }

    /**
     * Order object containing order related data
     * Please note that this object is required to be able to submit the amount.
     */
    public SubsequentPaymentRequest withOrder(Order value) {
        this.order = value;
        return this;
    }

    /**
     * specific data required for Bizum subsequent payment
     */
    public SubsequentPaymentProduct5001SpecificInput getSubsequentPaymentProduct5001SpecificInput() {
        return subsequentPaymentProduct5001SpecificInput;
    }

    /**
     * specific data required for Bizum subsequent payment
     */
    public void setSubsequentPaymentProduct5001SpecificInput(SubsequentPaymentProduct5001SpecificInput value) {
        this.subsequentPaymentProduct5001SpecificInput = value;
    }

    /**
     * specific data required for Bizum subsequent payment
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
