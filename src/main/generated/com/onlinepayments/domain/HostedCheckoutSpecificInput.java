/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class HostedCheckoutSpecificInput {

    private Integer allowedNumberOfPaymentAttempts;

    private CardPaymentMethodSpecificInputForHostedCheckout cardPaymentMethodSpecificInput;

    private Boolean isRecurring;

    private String locale;

    private PaymentProductFiltersHostedCheckout paymentProductFilters;

    private String returnUrl;

    private Integer sessionTimeout;

    private Boolean showResultPage;

    private String tokens;

    private String variant;

    /**
     * The maximum number of times a customer can try to pay before the payment is definitely declined. The value must be between 1 and 10. By default, the value is set to 10 attempts.
     */
    public Integer getAllowedNumberOfPaymentAttempts() {
        return allowedNumberOfPaymentAttempts;
    }

    /**
     * The maximum number of times a customer can try to pay before the payment is definitely declined. The value must be between 1 and 10. By default, the value is set to 10 attempts.
     */
    public void setAllowedNumberOfPaymentAttempts(Integer value) {
        this.allowedNumberOfPaymentAttempts = value;
    }

    /**
     * The maximum number of times a customer can try to pay before the payment is definitely declined. The value must be between 1 and 10. By default, the value is set to 10 attempts.
     */
    public HostedCheckoutSpecificInput withAllowedNumberOfPaymentAttempts(Integer value) {
        this.allowedNumberOfPaymentAttempts = value;
        return this;
    }

    /**
     * Object containing card payment specific data for hosted checkout
     */
    public CardPaymentMethodSpecificInputForHostedCheckout getCardPaymentMethodSpecificInput() {
        return cardPaymentMethodSpecificInput;
    }

    /**
     * Object containing card payment specific data for hosted checkout
     */
    public void setCardPaymentMethodSpecificInput(CardPaymentMethodSpecificInputForHostedCheckout value) {
        this.cardPaymentMethodSpecificInput = value;
    }

    /**
     * Object containing card payment specific data for hosted checkout
     */
    public HostedCheckoutSpecificInput withCardPaymentMethodSpecificInput(CardPaymentMethodSpecificInputForHostedCheckout value) {
        this.cardPaymentMethodSpecificInput = value;
        return this;
    }

    /**
     * <ul>
     *   <li>true - Only payment products that support recurring payments will be shown. Any transactions created will also be tagged as being a first of a recurring sequence.</li>
     *   <li>false - Only payment products that support one-off payments will be shown.
     * The default value for this property is false.</li>
     * </ul>
     */
    public Boolean getIsRecurring() {
        return isRecurring;
    }

    /**
     * <ul>
     *   <li>true - Only payment products that support recurring payments will be shown. Any transactions created will also be tagged as being a first of a recurring sequence.</li>
     *   <li>false - Only payment products that support one-off payments will be shown.
     * The default value for this property is false.</li>
     * </ul>
     */
    public void setIsRecurring(Boolean value) {
        this.isRecurring = value;
    }

    /**
     * <ul>
     *   <li>true - Only payment products that support recurring payments will be shown. Any transactions created will also be tagged as being a first of a recurring sequence.</li>
     *   <li>false - Only payment products that support one-off payments will be shown.
     * The default value for this property is false.</li>
     * </ul>
     */
    public HostedCheckoutSpecificInput withIsRecurring(Boolean value) {
        this.isRecurring = value;
        return this;
    }

    /**
     * Locale used in the GUI towards the consumer.
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Locale used in the GUI towards the consumer.
     */
    public void setLocale(String value) {
        this.locale = value;
    }

    /**
     * Locale used in the GUI towards the consumer.
     */
    public HostedCheckoutSpecificInput withLocale(String value) {
        this.locale = value;
        return this;
    }

    /**
     * Contains the payment product ids and payment product groups that will be used for manipulating the payment products available for the payment to the customer.
     */
    public PaymentProductFiltersHostedCheckout getPaymentProductFilters() {
        return paymentProductFilters;
    }

    /**
     * Contains the payment product ids and payment product groups that will be used for manipulating the payment products available for the payment to the customer.
     */
    public void setPaymentProductFilters(PaymentProductFiltersHostedCheckout value) {
        this.paymentProductFilters = value;
    }

    /**
     * Contains the payment product ids and payment product groups that will be used for manipulating the payment products available for the payment to the customer.
     */
    public HostedCheckoutSpecificInput withPaymentProductFilters(PaymentProductFiltersHostedCheckout value) {
        this.paymentProductFilters = value;
        return this;
    }

    /**
     * The URL that the customer is redirect to after the payment flow has finished. You can add any number of key value pairs in the query string that, for instance help you to identify the customer when they return to your site. Please note that we will also append some additional key value pairs that will also help you with this identification process.
     * Note: The provided URL should be absolute and contain the protocol to use, e.g. http:// or https://. For use on mobile devices a custom protocol can be used in the form of protocol://. This protocol must be registered on the device first.
     * URLs without a protocol will be rejected.
     */
    public String getReturnUrl() {
        return returnUrl;
    }

    /**
     * The URL that the customer is redirect to after the payment flow has finished. You can add any number of key value pairs in the query string that, for instance help you to identify the customer when they return to your site. Please note that we will also append some additional key value pairs that will also help you with this identification process.
     * Note: The provided URL should be absolute and contain the protocol to use, e.g. http:// or https://. For use on mobile devices a custom protocol can be used in the form of protocol://. This protocol must be registered on the device first.
     * URLs without a protocol will be rejected.
     */
    public void setReturnUrl(String value) {
        this.returnUrl = value;
    }

    /**
     * The URL that the customer is redirect to after the payment flow has finished. You can add any number of key value pairs in the query string that, for instance help you to identify the customer when they return to your site. Please note that we will also append some additional key value pairs that will also help you with this identification process.
     * Note: The provided URL should be absolute and contain the protocol to use, e.g. http:// or https://. For use on mobile devices a custom protocol can be used in the form of protocol://. This protocol must be registered on the device first.
     * URLs without a protocol will be rejected.
     */
    public HostedCheckoutSpecificInput withReturnUrl(String value) {
        this.returnUrl = value;
        return this;
    }

    /**
     * The number of minutes after which the session will expire. By default, the value is set to 180 minutes.
     */
    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    /**
     * The number of minutes after which the session will expire. By default, the value is set to 180 minutes.
     */
    public void setSessionTimeout(Integer value) {
        this.sessionTimeout = value;
    }

    /**
     * The number of minutes after which the session will expire. By default, the value is set to 180 minutes.
     */
    public HostedCheckoutSpecificInput withSessionTimeout(Integer value) {
        this.sessionTimeout = value;
        return this;
    }

    /**
     * <ul>
     *   <li>true - Default - Hosted Checkout will show a result page to the customer when applicable.</li>
     *   <li>false - Hosted Checkout will redirect the customer back to the provided returnUrl when this is possible.</li>
     * </ul>
     */
    public Boolean getShowResultPage() {
        return showResultPage;
    }

    /**
     * <ul>
     *   <li>true - Default - Hosted Checkout will show a result page to the customer when applicable.</li>
     *   <li>false - Hosted Checkout will redirect the customer back to the provided returnUrl when this is possible.</li>
     * </ul>
     */
    public void setShowResultPage(Boolean value) {
        this.showResultPage = value;
    }

    /**
     * <ul>
     *   <li>true - Default - Hosted Checkout will show a result page to the customer when applicable.</li>
     *   <li>false - Hosted Checkout will redirect the customer back to the provided returnUrl when this is possible.</li>
     * </ul>
     */
    public HostedCheckoutSpecificInput withShowResultPage(Boolean value) {
        this.showResultPage = value;
        return this;
    }

    /**
     * String containing comma separated tokens (no spaces) associated with the customer of this hosted session. Valid tokens will be used to present the customer the option to re-use previously used payment details. This means the customer for instance does not have to re-enter their card details again, which a big plus when the customer is using their mobile phone to complete the operation.
     */
    public String getTokens() {
        return tokens;
    }

    /**
     * String containing comma separated tokens (no spaces) associated with the customer of this hosted session. Valid tokens will be used to present the customer the option to re-use previously used payment details. This means the customer for instance does not have to re-enter their card details again, which a big plus when the customer is using their mobile phone to complete the operation.
     */
    public void setTokens(String value) {
        this.tokens = value;
    }

    /**
     * String containing comma separated tokens (no spaces) associated with the customer of this hosted session. Valid tokens will be used to present the customer the option to re-use previously used payment details. This means the customer for instance does not have to re-enter their card details again, which a big plus when the customer is using their mobile phone to complete the operation.
     */
    public HostedCheckoutSpecificInput withTokens(String value) {
        this.tokens = value;
        return this;
    }

    /**
     * It is possible to upload multiple templates of your payment pages using the Merchant Portal. You can force the use of a custom template by specifying it in the variant field. This allows you to test out the effect of certain changes to your payment pages in a controlled manner. Please note that you need to specify the filename of the template or customization.
     */
    public String getVariant() {
        return variant;
    }

    /**
     * It is possible to upload multiple templates of your payment pages using the Merchant Portal. You can force the use of a custom template by specifying it in the variant field. This allows you to test out the effect of certain changes to your payment pages in a controlled manner. Please note that you need to specify the filename of the template or customization.
     */
    public void setVariant(String value) {
        this.variant = value;
    }

    /**
     * It is possible to upload multiple templates of your payment pages using the Merchant Portal. You can force the use of a custom template by specifying it in the variant field. This allows you to test out the effect of certain changes to your payment pages in a controlled manner. Please note that you need to specify the filename of the template or customization.
     */
    public HostedCheckoutSpecificInput withVariant(String value) {
        this.variant = value;
        return this;
    }
}
