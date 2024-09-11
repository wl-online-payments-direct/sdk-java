/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * An object containing the Create PaymentLink request.
 */
public class CreatePaymentLinkRequest {

	private CardPaymentMethodSpecificInputBase cardPaymentMethodSpecificInput = null;

	private String description = null;

	private String expirationDate = null;

	private FraudFields fraudFields = null;

	private HostedCheckoutSpecificInput hostedCheckoutSpecificInput = null;

	private MobilePaymentMethodHostedCheckoutSpecificInput mobilePaymentMethodSpecificInput = null;

	private Order order = null;

	private PaymentLinkOrderInput paymentLinkOrder = null;

	private PaymentLinkSpecificInput paymentLinkSpecificInput = null;

	private String recipientName = null;

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
	public CreatePaymentLinkRequest withCardPaymentMethodSpecificInput(CardPaymentMethodSpecificInputBase value) {
		this.cardPaymentMethodSpecificInput = value;
		return this;
	}

	/**
	 * A note related to the created payment link.
	 * 
	 * Deprecated: Use `paymentLinkSpecificInput/description` instead.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * A note related to the created payment link.
	 * 
	 * Deprecated: Use `paymentLinkSpecificInput/description` instead.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * A note related to the created payment link.
	 * 
	 * Deprecated: Use `paymentLinkSpecificInput/description` instead.
	 */
	public CreatePaymentLinkRequest withDescription(String value) {
		this.description = value;
		return this;
	}

	/**
	 * The date after which the payment link will not be usable to complete the payment. The date sent cannot be more than 6 months in the future or a past date. It must also contain the UTC offset.
	 * 
	 * Deprecated: Use `paymentLinkSpecificInput/expirationDate` instead.
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * The date after which the payment link will not be usable to complete the payment. The date sent cannot be more than 6 months in the future or a past date. It must also contain the UTC offset.
	 * 
	 * Deprecated: Use `paymentLinkSpecificInput/expirationDate` instead.
	 */
	public void setExpirationDate(String value) {
		this.expirationDate = value;
	}

	/**
	 * The date after which the payment link will not be usable to complete the payment. The date sent cannot be more than 6 months in the future or a past date. It must also contain the UTC offset.
	 * 
	 * Deprecated: Use `paymentLinkSpecificInput/expirationDate` instead.
	 */
	public CreatePaymentLinkRequest withExpirationDate(String value) {
		this.expirationDate = value;
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
	public CreatePaymentLinkRequest withFraudFields(FraudFields value) {
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
	public CreatePaymentLinkRequest withHostedCheckoutSpecificInput(HostedCheckoutSpecificInput value) {
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
	public CreatePaymentLinkRequest withMobilePaymentMethodSpecificInput(MobilePaymentMethodHostedCheckoutSpecificInput value) {
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
	public CreatePaymentLinkRequest withOrder(Order value) {
		this.order = value;
		return this;
	}

	/**
	 * An object containing the details of the related payment input.
	 * 
	 * Deprecated: All properties in `paymentLinkOrder` are deprecated.  
	 * Use corresponding values as noted below:  
	 * | Property | Replacement |
	 * | - | - |
	 * | merchantReference | `order/references/merchantReference` |  
	 * | amount | `order/amountOfMoney` |  
	 * | surchargeSpecificInput | `order/surchargeSpecificInput` |
	 */
	public PaymentLinkOrderInput getPaymentLinkOrder() {
		return paymentLinkOrder;
	}

	/**
	 * An object containing the details of the related payment input.
	 * 
	 * Deprecated: All properties in `paymentLinkOrder` are deprecated.  
	 * Use corresponding values as noted below:  
	 * | Property | Replacement |
	 * | - | - |
	 * | merchantReference | `order/references/merchantReference` |  
	 * | amount | `order/amountOfMoney` |  
	 * | surchargeSpecificInput | `order/surchargeSpecificInput` |
	 */
	public void setPaymentLinkOrder(PaymentLinkOrderInput value) {
		this.paymentLinkOrder = value;
	}

	/**
	 * An object containing the details of the related payment input.
	 * 
	 * Deprecated: All properties in `paymentLinkOrder` are deprecated.  
	 * Use corresponding values as noted below:  
	 * | Property | Replacement |
	 * | - | - |
	 * | merchantReference | `order/references/merchantReference` |  
	 * | amount | `order/amountOfMoney` |  
	 * | surchargeSpecificInput | `order/surchargeSpecificInput` |
	 */
	public CreatePaymentLinkRequest withPaymentLinkOrder(PaymentLinkOrderInput value) {
		this.paymentLinkOrder = value;
		return this;
	}

	/**
	 * An object containing details specific to payment link creation
	 */
	public PaymentLinkSpecificInput getPaymentLinkSpecificInput() {
		return paymentLinkSpecificInput;
	}

	/**
	 * An object containing details specific to payment link creation
	 */
	public void setPaymentLinkSpecificInput(PaymentLinkSpecificInput value) {
		this.paymentLinkSpecificInput = value;
	}

	/**
	 * An object containing details specific to payment link creation
	 */
	public CreatePaymentLinkRequest withPaymentLinkSpecificInput(PaymentLinkSpecificInput value) {
		this.paymentLinkSpecificInput = value;
		return this;
	}

	/**
	 * The payment link recipient name.
	 * 
	 * Deprecated: Use `paymentLinkSpecificInput/recipientName` instead.
	 */
	public String getRecipientName() {
		return recipientName;
	}

	/**
	 * The payment link recipient name.
	 * 
	 * Deprecated: Use `paymentLinkSpecificInput/recipientName` instead.
	 */
	public void setRecipientName(String value) {
		this.recipientName = value;
	}

	/**
	 * The payment link recipient name.
	 * 
	 * Deprecated: Use `paymentLinkSpecificInput/recipientName` instead.
	 */
	public CreatePaymentLinkRequest withRecipientName(String value) {
		this.recipientName = value;
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
	public CreatePaymentLinkRequest withRedirectPaymentMethodSpecificInput(RedirectPaymentMethodSpecificInput value) {
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
	public CreatePaymentLinkRequest withSepaDirectDebitPaymentMethodSpecificInput(SepaDirectDebitPaymentMethodSpecificInputBase value) {
		this.sepaDirectDebitPaymentMethodSpecificInput = value;
		return this;
	}
}
