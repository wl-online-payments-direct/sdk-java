/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class CreateHostedCheckoutRequest {

	private CardPaymentMethodSpecificInputBase cardPaymentMethodSpecificInput = null;

	private FraudFields fraudFields = null;

	private HostedCheckoutSpecificInput hostedCheckoutSpecificInput = null;

	private MobilePaymentMethodHostedCheckoutSpecificInput mobilePaymentMethodSpecificInput = null;

	private Order order = null;

	private PageCustomization pageCustomization = null;

	private RedirectPaymentMethodSpecificInput redirectPaymentMethodSpecificInput = null;

	private SepaDirectDebitPaymentMethodSpecificInputBase sepaDirectDebitPaymentMethodSpecificInput = null;

	/**
	 * Object containing the specific input details for card payments
	 */
	public CardPaymentMethodSpecificInputBase getCardPaymentMethodSpecificInput() {
		return cardPaymentMethodSpecificInput;
	}

	/**
	 * Object containing the specific input details for card payments
	 */
	public void setCardPaymentMethodSpecificInput(CardPaymentMethodSpecificInputBase value) {
		this.cardPaymentMethodSpecificInput = value;
	}

	/**
	 * Object containing the specific input details for card payments
	 */
	public CreateHostedCheckoutRequest withCardPaymentMethodSpecificInput(CardPaymentMethodSpecificInputBase value) {
		this.cardPaymentMethodSpecificInput = value;
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
	public CreateHostedCheckoutRequest withFraudFields(FraudFields value) {
		this.fraudFields = value;
		return this;
	}

	/**
	 * Object containing hosted checkout specific data
	 */
	public HostedCheckoutSpecificInput getHostedCheckoutSpecificInput() {
		return hostedCheckoutSpecificInput;
	}

	/**
	 * Object containing hosted checkout specific data
	 */
	public void setHostedCheckoutSpecificInput(HostedCheckoutSpecificInput value) {
		this.hostedCheckoutSpecificInput = value;
	}

	/**
	 * Object containing hosted checkout specific data
	 */
	public CreateHostedCheckoutRequest withHostedCheckoutSpecificInput(HostedCheckoutSpecificInput value) {
		this.hostedCheckoutSpecificInput = value;
		return this;
	}

	/**
	 * Object containing the specific input details for mobile payments
	 */
	public MobilePaymentMethodHostedCheckoutSpecificInput getMobilePaymentMethodSpecificInput() {
		return mobilePaymentMethodSpecificInput;
	}

	/**
	 * Object containing the specific input details for mobile payments
	 */
	public void setMobilePaymentMethodSpecificInput(MobilePaymentMethodHostedCheckoutSpecificInput value) {
		this.mobilePaymentMethodSpecificInput = value;
	}

	/**
	 * Object containing the specific input details for mobile payments
	 */
	public CreateHostedCheckoutRequest withMobilePaymentMethodSpecificInput(MobilePaymentMethodHostedCheckoutSpecificInput value) {
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
	public CreateHostedCheckoutRequest withOrder(Order value) {
		this.order = value;
		return this;
	}

	public PageCustomization getPageCustomization() {
		return pageCustomization;
	}

	public void setPageCustomization(PageCustomization value) {
		this.pageCustomization = value;
	}

	public CreateHostedCheckoutRequest withPageCustomization(PageCustomization value) {
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
	public CreateHostedCheckoutRequest withRedirectPaymentMethodSpecificInput(RedirectPaymentMethodSpecificInput value) {
		this.redirectPaymentMethodSpecificInput = value;
		return this;
	}

	/**
	 * Object containing the specific input details for SEPA direct debit payments
	 */
	public SepaDirectDebitPaymentMethodSpecificInputBase getSepaDirectDebitPaymentMethodSpecificInput() {
		return sepaDirectDebitPaymentMethodSpecificInput;
	}

	/**
	 * Object containing the specific input details for SEPA direct debit payments
	 */
	public void setSepaDirectDebitPaymentMethodSpecificInput(SepaDirectDebitPaymentMethodSpecificInputBase value) {
		this.sepaDirectDebitPaymentMethodSpecificInput = value;
	}

	/**
	 * Object containing the specific input details for SEPA direct debit payments
	 */
	public CreateHostedCheckoutRequest withSepaDirectDebitPaymentMethodSpecificInput(SepaDirectDebitPaymentMethodSpecificInputBase value) {
		this.sepaDirectDebitPaymentMethodSpecificInput = value;
		return this;
	}
}
