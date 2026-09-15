/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class GetIINDetailsRequest {

    private String bin;

    private PaymentContext paymentContext;

    /**
     * The first digits of the credit card number from left to right with a minimum of 6 digits. Providing additional digits (up to 19) can result in more co-brands being returned.
     */
    public String getBin() {
        return bin;
    }

    /**
     * The first digits of the credit card number from left to right with a minimum of 6 digits. Providing additional digits (up to 19) can result in more co-brands being returned.
     */
    public void setBin(String value) {
        this.bin = value;
    }

    /**
     * The first digits of the credit card number from left to right with a minimum of 6 digits. Providing additional digits (up to 19) can result in more co-brands being returned.
     */
    public GetIINDetailsRequest withBin(String value) {
        this.bin = value;
        return this;
    }

    /**
     * Optional payment context to refine the IIN lookup to filter out payment products not applicable to your payment.
     */
    public PaymentContext getPaymentContext() {
        return paymentContext;
    }

    /**
     * Optional payment context to refine the IIN lookup to filter out payment products not applicable to your payment.
     */
    public void setPaymentContext(PaymentContext value) {
        this.paymentContext = value;
    }

    /**
     * Optional payment context to refine the IIN lookup to filter out payment products not applicable to your payment.
     */
    public GetIINDetailsRequest withPaymentContext(PaymentContext value) {
        this.paymentContext = value;
        return this;
    }
}
