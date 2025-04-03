/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ApplePayRecurringPaymentRequest {

    private String billingAgreement;

    private String managementUrl;

    private String paymentDescription;

    private ApplePayLineItem regularBilling;

    private ApplePayLineItem trialBilling;

    /**
     * A localized billing agreement that the payment sheet displays to the user before the user authorizes the payment.
     */
    public String getBillingAgreement() {
        return billingAgreement;
    }

    /**
     * A localized billing agreement that the payment sheet displays to the user before the user authorizes the payment.
     */
    public void setBillingAgreement(String value) {
        this.billingAgreement = value;
    }

    /**
     * A localized billing agreement that the payment sheet displays to the user before the user authorizes the payment.
     */
    public ApplePayRecurringPaymentRequest withBillingAgreement(String value) {
        this.billingAgreement = value;
        return this;
    }

    /**
     * A URL to a web page where the user can update or delete the payment method for the recurring payment.
     */
    public String getManagementUrl() {
        return managementUrl;
    }

    /**
     * A URL to a web page where the user can update or delete the payment method for the recurring payment.
     */
    public void setManagementUrl(String value) {
        this.managementUrl = value;
    }

    /**
     * A URL to a web page where the user can update or delete the payment method for the recurring payment.
     */
    public ApplePayRecurringPaymentRequest withManagementUrl(String value) {
        this.managementUrl = value;
        return this;
    }

    /**
     * A description of the recurring payment that Apple Pay displays to the user in the payment sheet.
     */
    public String getPaymentDescription() {
        return paymentDescription;
    }

    /**
     * A description of the recurring payment that Apple Pay displays to the user in the payment sheet.
     */
    public void setPaymentDescription(String value) {
        this.paymentDescription = value;
    }

    /**
     * A description of the recurring payment that Apple Pay displays to the user in the payment sheet.
     */
    public ApplePayRecurringPaymentRequest withPaymentDescription(String value) {
        this.paymentDescription = value;
        return this;
    }

    /**
     * Object containing specific data regarding Apple Pay recurring payment.
     */
    public ApplePayLineItem getRegularBilling() {
        return regularBilling;
    }

    /**
     * Object containing specific data regarding Apple Pay recurring payment.
     */
    public void setRegularBilling(ApplePayLineItem value) {
        this.regularBilling = value;
    }

    /**
     * Object containing specific data regarding Apple Pay recurring payment.
     */
    public ApplePayRecurringPaymentRequest withRegularBilling(ApplePayLineItem value) {
        this.regularBilling = value;
        return this;
    }

    /**
     * Object containing specific data regarding Apple Pay recurring payment.
     */
    public ApplePayLineItem getTrialBilling() {
        return trialBilling;
    }

    /**
     * Object containing specific data regarding Apple Pay recurring payment.
     */
    public void setTrialBilling(ApplePayLineItem value) {
        this.trialBilling = value;
    }

    /**
     * Object containing specific data regarding Apple Pay recurring payment.
     */
    public ApplePayRecurringPaymentRequest withTrialBilling(ApplePayLineItem value) {
        this.trialBilling = value;
        return this;
    }
}
