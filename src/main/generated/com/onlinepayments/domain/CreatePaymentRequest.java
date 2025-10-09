/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CreatePaymentRequest {

    private CardPaymentMethodSpecificInput cardPaymentMethodSpecificInput;

    private String encryptedCustomerInput;

    private Feedbacks feedbacks;

    private FraudFields fraudFields;

    private String hostedTokenizationId;

    private MobilePaymentMethodSpecificInput mobilePaymentMethodSpecificInput;

    private Order order;

    private RedirectPaymentMethodSpecificInput redirectPaymentMethodSpecificInput;

    private SepaDirectDebitPaymentMethodSpecificInput sepaDirectDebitPaymentMethodSpecificInput;

    /**
     * Object containing the specific input details for card payments
     */
    public CardPaymentMethodSpecificInput getCardPaymentMethodSpecificInput() {
        return cardPaymentMethodSpecificInput;
    }

    /**
     * Object containing the specific input details for card payments
     */
    public void setCardPaymentMethodSpecificInput(CardPaymentMethodSpecificInput value) {
        this.cardPaymentMethodSpecificInput = value;
    }

    /**
     * Object containing the specific input details for card payments
     */
    public CreatePaymentRequest withCardPaymentMethodSpecificInput(CardPaymentMethodSpecificInput value) {
        this.cardPaymentMethodSpecificInput = value;
        return this;
    }

    /**
     * Data that was encrypted client side containing all customer entered data elements like card data.
     * Note: Because this data can only be submitted once to our system and contains encrypted card data you should not store it. As the data was captured within the context of a client session you also need to submit it to us before the session has expired.
     */
    public String getEncryptedCustomerInput() {
        return encryptedCustomerInput;
    }

    /**
     * Data that was encrypted client side containing all customer entered data elements like card data.
     * Note: Because this data can only be submitted once to our system and contains encrypted card data you should not store it. As the data was captured within the context of a client session you also need to submit it to us before the session has expired.
     */
    public void setEncryptedCustomerInput(String value) {
        this.encryptedCustomerInput = value;
    }

    /**
     * Data that was encrypted client side containing all customer entered data elements like card data.
     * Note: Because this data can only be submitted once to our system and contains encrypted card data you should not store it. As the data was captured within the context of a client session you also need to submit it to us before the session has expired.
     */
    public CreatePaymentRequest withEncryptedCustomerInput(String value) {
        this.encryptedCustomerInput = value;
        return this;
    }

    /**
     * This section will contain feedback Urls to provide feedback on the payment.
     */
    public Feedbacks getFeedbacks() {
        return feedbacks;
    }

    /**
     * This section will contain feedback Urls to provide feedback on the payment.
     */
    public void setFeedbacks(Feedbacks value) {
        this.feedbacks = value;
    }

    /**
     * This section will contain feedback Urls to provide feedback on the payment.
     */
    public CreatePaymentRequest withFeedbacks(Feedbacks value) {
        this.feedbacks = value;
        return this;
    }

    /**
     * Object containing additional data that will be used to assess the risk of fraud
     */
    public FraudFields getFraudFields() {
        return fraudFields;
    }

    /**
     * Object containing additional data that will be used to assess the risk of fraud
     */
    public void setFraudFields(FraudFields value) {
        this.fraudFields = value;
    }

    /**
     * Object containing additional data that will be used to assess the risk of fraud
     */
    public CreatePaymentRequest withFraudFields(FraudFields value) {
        this.fraudFields = value;
        return this;
    }

    /**
     * Use this field after a successful Hosted Tokenization session to create a payment with the tokenized payment method details.
     */
    public String getHostedTokenizationId() {
        return hostedTokenizationId;
    }

    /**
     * Use this field after a successful Hosted Tokenization session to create a payment with the tokenized payment method details.
     */
    public void setHostedTokenizationId(String value) {
        this.hostedTokenizationId = value;
    }

    /**
     * Use this field after a successful Hosted Tokenization session to create a payment with the tokenized payment method details.
     */
    public CreatePaymentRequest withHostedTokenizationId(String value) {
        this.hostedTokenizationId = value;
        return this;
    }

    /**
     * Object containing the specific input details for mobile payments
     */
    public MobilePaymentMethodSpecificInput getMobilePaymentMethodSpecificInput() {
        return mobilePaymentMethodSpecificInput;
    }

    /**
     * Object containing the specific input details for mobile payments
     */
    public void setMobilePaymentMethodSpecificInput(MobilePaymentMethodSpecificInput value) {
        this.mobilePaymentMethodSpecificInput = value;
    }

    /**
     * Object containing the specific input details for mobile payments
     */
    public CreatePaymentRequest withMobilePaymentMethodSpecificInput(MobilePaymentMethodSpecificInput value) {
        this.mobilePaymentMethodSpecificInput = value;
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
    public CreatePaymentRequest withOrder(Order value) {
        this.order = value;
        return this;
    }

    /**
     * Object containing the specific input details for payments that involve redirects to 3rd parties to complete, like iDeal and PayPal
     */
    public RedirectPaymentMethodSpecificInput getRedirectPaymentMethodSpecificInput() {
        return redirectPaymentMethodSpecificInput;
    }

    /**
     * Object containing the specific input details for payments that involve redirects to 3rd parties to complete, like iDeal and PayPal
     */
    public void setRedirectPaymentMethodSpecificInput(RedirectPaymentMethodSpecificInput value) {
        this.redirectPaymentMethodSpecificInput = value;
    }

    /**
     * Object containing the specific input details for payments that involve redirects to 3rd parties to complete, like iDeal and PayPal
     */
    public CreatePaymentRequest withRedirectPaymentMethodSpecificInput(RedirectPaymentMethodSpecificInput value) {
        this.redirectPaymentMethodSpecificInput = value;
        return this;
    }

    /**
     * Object containing the specific input details for SEPA direct debit payments
     */
    public SepaDirectDebitPaymentMethodSpecificInput getSepaDirectDebitPaymentMethodSpecificInput() {
        return sepaDirectDebitPaymentMethodSpecificInput;
    }

    /**
     * Object containing the specific input details for SEPA direct debit payments
     */
    public void setSepaDirectDebitPaymentMethodSpecificInput(SepaDirectDebitPaymentMethodSpecificInput value) {
        this.sepaDirectDebitPaymentMethodSpecificInput = value;
    }

    /**
     * Object containing the specific input details for SEPA direct debit payments
     */
    public CreatePaymentRequest withSepaDirectDebitPaymentMethodSpecificInput(SepaDirectDebitPaymentMethodSpecificInput value) {
        this.sepaDirectDebitPaymentMethodSpecificInput = value;
        return this;
    }
}
