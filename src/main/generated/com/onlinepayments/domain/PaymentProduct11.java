/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentProduct11 {

    private String paymentBIC;

    private String paymentBeneficiary;

    private String paymentIBAN;

    private String paymentReference;

    private String qrCode;

    /**
     * The BIC is the Bank Identifier Code, also known as SWIFT code, used to identify banks internationally.
     */
    public String getPaymentBIC() {
        return paymentBIC;
    }

    /**
     * The BIC is the Bank Identifier Code, also known as SWIFT code, used to identify banks internationally.
     */
    public void setPaymentBIC(String value) {
        this.paymentBIC = value;
    }

    /**
     * The BIC is the Bank Identifier Code, also known as SWIFT code, used to identify banks internationally.
     */
    public PaymentProduct11 withPaymentBIC(String value) {
        this.paymentBIC = value;
        return this;
    }

    /**
     * The beneficiary of the payment
     */
    public String getPaymentBeneficiary() {
        return paymentBeneficiary;
    }

    /**
     * The beneficiary of the payment
     */
    public void setPaymentBeneficiary(String value) {
        this.paymentBeneficiary = value;
    }

    /**
     * The beneficiary of the payment
     */
    public PaymentProduct11 withPaymentBeneficiary(String value) {
        this.paymentBeneficiary = value;
        return this;
    }

    /**
     * The IBAN is the International Bank Account Number. It is an internationally agreed format for the BBAN and includes the ISO country code and two check digits.
     */
    public String getPaymentIBAN() {
        return paymentIBAN;
    }

    /**
     * The IBAN is the International Bank Account Number. It is an internationally agreed format for the BBAN and includes the ISO country code and two check digits.
     */
    public void setPaymentIBAN(String value) {
        this.paymentIBAN = value;
    }

    /**
     * The IBAN is the International Bank Account Number. It is an internationally agreed format for the BBAN and includes the ISO country code and two check digits.
     */
    public PaymentProduct11 withPaymentIBAN(String value) {
        this.paymentIBAN = value;
        return this;
    }

    /**
     * The reference for the payment
     */
    public String getPaymentReference() {
        return paymentReference;
    }

    /**
     * The reference for the payment
     */
    public void setPaymentReference(String value) {
        this.paymentReference = value;
    }

    /**
     * The reference for the payment
     */
    public PaymentProduct11 withPaymentReference(String value) {
        this.paymentReference = value;
        return this;
    }

    /**
     * This field provides a Base64-encoded string representing a standardized payment QR code. The payload contains the complete transaction initiation data, including Service Tag, Version, Character Set, Identification, BIC, Beneficiary Name, IBAN, Amount, and Communication reference.
     */
    public String getQrCode() {
        return qrCode;
    }

    /**
     * This field provides a Base64-encoded string representing a standardized payment QR code. The payload contains the complete transaction initiation data, including Service Tag, Version, Character Set, Identification, BIC, Beneficiary Name, IBAN, Amount, and Communication reference.
     */
    public void setQrCode(String value) {
        this.qrCode = value;
    }

    /**
     * This field provides a Base64-encoded string representing a standardized payment QR code. The payload contains the complete transaction initiation data, including Service Tag, Version, Character Set, Identification, BIC, Beneficiary Name, IBAN, Amount, and Communication reference.
     */
    public PaymentProduct11 withQrCode(String value) {
        this.qrCode = value;
        return this;
    }
}
