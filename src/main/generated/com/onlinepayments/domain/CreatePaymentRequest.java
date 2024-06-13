/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class CreatePaymentRequest {

	private CardPaymentMethodSpecificInput cardPaymentMethodSpecificInput = null;

	private String encryptedCustomerInput = null;

	private FraudFields fraudFields = null;

	private String hostedTokenizationId = null;

	private MobilePaymentMethodSpecificInput mobilePaymentMethodSpecificInput = null;

	private Order order = null;

	private PageCustomization pageCustomization = null;

	private RedirectPaymentMethodSpecificInput redirectPaymentMethodSpecificInput = null;

	private SepaDirectDebitPaymentMethodSpecificInput sepaDirectDebitPaymentMethodSpecificInput = null;

	private Integer sessionTimeout = null;

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
	 * Order object containing order related data 
	 *  Please note that this object is required to be able to submit the amount.
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * Order object containing order related data 
	 *  Please note that this object is required to be able to submit the amount.
	 */
	public void setOrder(Order value) {
		this.order = value;
	}

	/**
	 * Order object containing order related data 
	 *  Please note that this object is required to be able to submit the amount.
	 */
	public CreatePaymentRequest withOrder(Order value) {
		this.order = value;
		return this;
	}

	public PageCustomization getPageCustomization() {
		return pageCustomization;
	}

	public void setPageCustomization(PageCustomization value) {
		this.pageCustomization = value;
	}

	public CreatePaymentRequest withPageCustomization(PageCustomization value) {
		this.pageCustomization = value;
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

	/**
	 * Time (in minutes) after which the scheme or issuer shall refuse to finalize the transaction, if supported by said scheme/ issuer
	 */
	public Integer getSessionTimeout() {
		return sessionTimeout;
	}

	/**
	 * Time (in minutes) after which the scheme or issuer shall refuse to finalize the transaction, if supported by said scheme/ issuer
	 */
	public void setSessionTimeout(Integer value) {
		this.sessionTimeout = value;
	}

	/**
	 * Time (in minutes) after which the scheme or issuer shall refuse to finalize the transaction, if supported by said scheme/ issuer
	 */
	public CreatePaymentRequest withSessionTimeout(Integer value) {
		this.sessionTimeout = value;
		return this;
	}
}
