/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ShowFormData {

    private PaymentProduct3012 paymentProduct3012;

    private PaymentProduct350 paymentProduct350;

    @SuppressWarnings("deprecation")
    private PaymentProduct5001 paymentProduct5001;

    private PaymentProduct5404 paymentProduct5404;

    private PaymentProduct5407 paymentProduct5407;

    private PendingAuthentication pendingAuthentication;

    /**
     * Contains the third party data for payment product 3012 (Bancontact)
     */
    public PaymentProduct3012 getPaymentProduct3012() {
        return paymentProduct3012;
    }

    /**
     * Contains the third party data for payment product 3012 (Bancontact)
     */
    public void setPaymentProduct3012(PaymentProduct3012 value) {
        this.paymentProduct3012 = value;
    }

    /**
     * Contains the third party data for payment product 3012 (Bancontact)
     */
    public ShowFormData withPaymentProduct3012(PaymentProduct3012 value) {
        this.paymentProduct3012 = value;
        return this;
    }

    /**
     * Contains the third party data for payment product 350 (Swish)
     */
    public PaymentProduct350 getPaymentProduct350() {
        return paymentProduct350;
    }

    /**
     * Contains the third party data for payment product 350 (Swish)
     */
    public void setPaymentProduct350(PaymentProduct350 value) {
        this.paymentProduct350 = value;
    }

    /**
     * Contains the third party data for payment product 350 (Swish)
     */
    public ShowFormData withPaymentProduct350(PaymentProduct350 value) {
        this.paymentProduct350 = value;
        return this;
    }

    /**
     * Deprecated by pendingAuthentication. Contains the third party data for payment product 5001 (Bizum)
     */
    public PaymentProduct5001 getPaymentProduct5001() {
        return paymentProduct5001;
    }

    /**
     * Deprecated by pendingAuthentication. Contains the third party data for payment product 5001 (Bizum)
     */
    public void setPaymentProduct5001(PaymentProduct5001 value) {
        this.paymentProduct5001 = value;
    }

    /**
     * Deprecated by pendingAuthentication. Contains the third party data for payment product 5001 (Bizum)
     */
    public ShowFormData withPaymentProduct5001(PaymentProduct5001 value) {
        this.paymentProduct5001 = value;
        return this;
    }

    /**
     * Contains the third party data for payment product 5404 (WeChat Pay)
     */
    public PaymentProduct5404 getPaymentProduct5404() {
        return paymentProduct5404;
    }

    /**
     * Contains the third party data for payment product 5404 (WeChat Pay)
     */
    public void setPaymentProduct5404(PaymentProduct5404 value) {
        this.paymentProduct5404 = value;
    }

    /**
     * Contains the third party data for payment product 5404 (WeChat Pay)
     */
    public ShowFormData withPaymentProduct5404(PaymentProduct5404 value) {
        this.paymentProduct5404 = value;
        return this;
    }

    /**
     * Contains the third party data for payment product 5407 (Twint)
     */
    public PaymentProduct5407 getPaymentProduct5407() {
        return paymentProduct5407;
    }

    /**
     * Contains the third party data for payment product 5407 (Twint)
     */
    public void setPaymentProduct5407(PaymentProduct5407 value) {
        this.paymentProduct5407 = value;
    }

    /**
     * Contains the third party data for payment product 5407 (Twint)
     */
    public ShowFormData withPaymentProduct5407(PaymentProduct5407 value) {
        this.paymentProduct5407 = value;
        return this;
    }

    /**
     * Contains the third party data for payment product requiring an external authentication (e.g., Bizum, CV Connect)
     */
    public PendingAuthentication getPendingAuthentication() {
        return pendingAuthentication;
    }

    /**
     * Contains the third party data for payment product requiring an external authentication (e.g., Bizum, CV Connect)
     */
    public void setPendingAuthentication(PendingAuthentication value) {
        this.pendingAuthentication = value;
    }

    /**
     * Contains the third party data for payment product requiring an external authentication (e.g., Bizum, CV Connect)
     */
    public ShowFormData withPendingAuthentication(PendingAuthentication value) {
        this.pendingAuthentication = value;
        return this;
    }
}
