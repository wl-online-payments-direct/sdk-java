/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ApiParameters {

    private Amex amex;

    private PaymentProduct5002defaultBrandParameters cb;

    private PaymentProduct5002defaultBrandParameters eftpos;

    private Mastercard mastercard;

    private Visa visa;

    /**
     * The following fields need to be provided to the amex field within the configuration.
     */
    public Amex getAmex() {
        return amex;
    }

    /**
     * The following fields need to be provided to the amex field within the configuration.
     */
    public void setAmex(Amex value) {
        this.amex = value;
    }

    /**
     * The following fields need to be provided to the amex field within the configuration.
     */
    public ApiParameters withAmex(Amex value) {
        this.amex = value;
        return this;
    }

    /**
     * The following fields need to be provided to the cb field within the configuration.
     */
    public PaymentProduct5002defaultBrandParameters getCb() {
        return cb;
    }

    /**
     * The following fields need to be provided to the cb field within the configuration.
     */
    public void setCb(PaymentProduct5002defaultBrandParameters value) {
        this.cb = value;
    }

    /**
     * The following fields need to be provided to the cb field within the configuration.
     */
    public ApiParameters withCb(PaymentProduct5002defaultBrandParameters value) {
        this.cb = value;
        return this;
    }

    /**
     * The following fields need to be provided to the eftpos field within the configuration.
     */
    public PaymentProduct5002defaultBrandParameters getEftpos() {
        return eftpos;
    }

    /**
     * The following fields need to be provided to the eftpos field within the configuration.
     */
    public void setEftpos(PaymentProduct5002defaultBrandParameters value) {
        this.eftpos = value;
    }

    /**
     * The following fields need to be provided to the eftpos field within the configuration.
     */
    public ApiParameters withEftpos(PaymentProduct5002defaultBrandParameters value) {
        this.eftpos = value;
        return this;
    }

    /**
     * The following fields need to be provided to the mastercard field within the configuration.
     */
    public Mastercard getMastercard() {
        return mastercard;
    }

    /**
     * The following fields need to be provided to the mastercard field within the configuration.
     */
    public void setMastercard(Mastercard value) {
        this.mastercard = value;
    }

    /**
     * The following fields need to be provided to the mastercard field within the configuration.
     */
    public ApiParameters withMastercard(Mastercard value) {
        this.mastercard = value;
        return this;
    }

    /**
     * The following fields need to be provided to the visa field within the configuration.
     */
    public Visa getVisa() {
        return visa;
    }

    /**
     * The following fields need to be provided to the visa field within the configuration.
     */
    public void setVisa(Visa value) {
        this.visa = value;
    }

    /**
     * The following fields need to be provided to the visa field within the configuration.
     */
    public ApiParameters withVisa(Visa value) {
        this.visa = value;
        return this;
    }
}
