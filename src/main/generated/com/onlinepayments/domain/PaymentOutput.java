/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing payment details
 */
public class PaymentOutput {

	private AmountOfMoney acquiredAmount = null;

	private AmountOfMoney amountOfMoney = null;

	private Long amountPaid = null;

	private CardPaymentMethodSpecificOutput cardPaymentMethodSpecificOutput = null;

	private CustomerOutput customer = null;

	private Discount discount = null;

	private String merchantParameters = null;

	private MobilePaymentMethodSpecificOutput mobilePaymentMethodSpecificOutput = null;

	private String paymentMethod = null;

	private RedirectPaymentMethodSpecificOutput redirectPaymentMethodSpecificOutput = null;

	private PaymentReferences references = null;

	private SepaDirectDebitPaymentMethodSpecificOutput sepaDirectDebitPaymentMethodSpecificOutput = null;

	private SurchargeSpecificOutput surchargeSpecificOutput = null;

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getAcquiredAmount() {
		return acquiredAmount;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setAcquiredAmount(AmountOfMoney value) {
		this.acquiredAmount = value;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public PaymentOutput withAcquiredAmount(AmountOfMoney value) {
		this.acquiredAmount = value;
		return this;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public AmountOfMoney getAmountOfMoney() {
		return amountOfMoney;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public void setAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
	}

	/**
	 * Object containing amount and ISO currency code attributes
	 */
	public PaymentOutput withAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
		return this;
	}

	/**
	 * Amount that has been paid. This is deprecated. Use acquiredAmount instead.
	 */
	public Long getAmountPaid() {
		return amountPaid;
	}

	/**
	 * Amount that has been paid. This is deprecated. Use acquiredAmount instead.
	 */
	public void setAmountPaid(Long value) {
		this.amountPaid = value;
	}

	/**
	 * Amount that has been paid. This is deprecated. Use acquiredAmount instead.
	 */
	public PaymentOutput withAmountPaid(Long value) {
		this.amountPaid = value;
		return this;
	}

	/**
	 * Object containing the card payment method details
	 */
	public CardPaymentMethodSpecificOutput getCardPaymentMethodSpecificOutput() {
		return cardPaymentMethodSpecificOutput;
	}

	/**
	 * Object containing the card payment method details
	 */
	public void setCardPaymentMethodSpecificOutput(CardPaymentMethodSpecificOutput value) {
		this.cardPaymentMethodSpecificOutput = value;
	}

	/**
	 * Object containing the card payment method details
	 */
	public PaymentOutput withCardPaymentMethodSpecificOutput(CardPaymentMethodSpecificOutput value) {
		this.cardPaymentMethodSpecificOutput = value;
		return this;
	}

	/**
	 * Object containing the details of the customer
	 */
	public CustomerOutput getCustomer() {
		return customer;
	}

	/**
	 * Object containing the details of the customer
	 */
	public void setCustomer(CustomerOutput value) {
		this.customer = value;
	}

	/**
	 * Object containing the details of the customer
	 */
	public PaymentOutput withCustomer(CustomerOutput value) {
		this.customer = value;
		return this;
	}

	/**
	 * Object to apply a discount to the total basket by adding a discount line.
	 */
	public Discount getDiscount() {
		return discount;
	}

	/**
	 * Object to apply a discount to the total basket by adding a discount line.
	 */
	public void setDiscount(Discount value) {
		this.discount = value;
	}

	/**
	 * Object to apply a discount to the total basket by adding a discount line.
	 */
	public PaymentOutput withDiscount(Discount value) {
		this.discount = value;
		return this;
	}

	/**
	 * It allows you to store additional parameters for the transaction in the format you prefer (e.g.-&gt; key-value query string, JSON, etc.) These parameters are then echoed back to you in API GET calls and Webhook notifications. This field must not contain any personal data.
	 */
	public String getMerchantParameters() {
		return merchantParameters;
	}

	/**
	 * It allows you to store additional parameters for the transaction in the format you prefer (e.g.-&gt; key-value query string, JSON, etc.) These parameters are then echoed back to you in API GET calls and Webhook notifications. This field must not contain any personal data.
	 */
	public void setMerchantParameters(String value) {
		this.merchantParameters = value;
	}

	/**
	 * It allows you to store additional parameters for the transaction in the format you prefer (e.g.-&gt; key-value query string, JSON, etc.) These parameters are then echoed back to you in API GET calls and Webhook notifications. This field must not contain any personal data.
	 */
	public PaymentOutput withMerchantParameters(String value) {
		this.merchantParameters = value;
		return this;
	}

	/**
	 * Object containing the mobile payment method details
	 */
	public MobilePaymentMethodSpecificOutput getMobilePaymentMethodSpecificOutput() {
		return mobilePaymentMethodSpecificOutput;
	}

	/**
	 * Object containing the mobile payment method details
	 */
	public void setMobilePaymentMethodSpecificOutput(MobilePaymentMethodSpecificOutput value) {
		this.mobilePaymentMethodSpecificOutput = value;
	}

	/**
	 * Object containing the mobile payment method details
	 */
	public PaymentOutput withMobilePaymentMethodSpecificOutput(MobilePaymentMethodSpecificOutput value) {
		this.mobilePaymentMethodSpecificOutput = value;
		return this;
	}

	/**
	 * Payment method identifier used by the our payment engine.
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Payment method identifier used by the our payment engine.
	 */
	public void setPaymentMethod(String value) {
		this.paymentMethod = value;
	}

	/**
	 * Payment method identifier used by the our payment engine.
	 */
	public PaymentOutput withPaymentMethod(String value) {
		this.paymentMethod = value;
		return this;
	}

	/**
	 * Object containing the redirect payment product details
	 */
	public RedirectPaymentMethodSpecificOutput getRedirectPaymentMethodSpecificOutput() {
		return redirectPaymentMethodSpecificOutput;
	}

	/**
	 * Object containing the redirect payment product details
	 */
	public void setRedirectPaymentMethodSpecificOutput(RedirectPaymentMethodSpecificOutput value) {
		this.redirectPaymentMethodSpecificOutput = value;
	}

	/**
	 * Object containing the redirect payment product details
	 */
	public PaymentOutput withRedirectPaymentMethodSpecificOutput(RedirectPaymentMethodSpecificOutput value) {
		this.redirectPaymentMethodSpecificOutput = value;
		return this;
	}

	/**
	 * Object that holds all reference properties that are linked to this transaction
	 */
	public PaymentReferences getReferences() {
		return references;
	}

	/**
	 * Object that holds all reference properties that are linked to this transaction
	 */
	public void setReferences(PaymentReferences value) {
		this.references = value;
	}

	/**
	 * Object that holds all reference properties that are linked to this transaction
	 */
	public PaymentOutput withReferences(PaymentReferences value) {
		this.references = value;
		return this;
	}

	/**
	 * Object containing the SEPA direct debit details
	 */
	public SepaDirectDebitPaymentMethodSpecificOutput getSepaDirectDebitPaymentMethodSpecificOutput() {
		return sepaDirectDebitPaymentMethodSpecificOutput;
	}

	/**
	 * Object containing the SEPA direct debit details
	 */
	public void setSepaDirectDebitPaymentMethodSpecificOutput(SepaDirectDebitPaymentMethodSpecificOutput value) {
		this.sepaDirectDebitPaymentMethodSpecificOutput = value;
	}

	/**
	 * Object containing the SEPA direct debit details
	 */
	public PaymentOutput withSepaDirectDebitPaymentMethodSpecificOutput(SepaDirectDebitPaymentMethodSpecificOutput value) {
		this.sepaDirectDebitPaymentMethodSpecificOutput = value;
		return this;
	}

	/**
	 * Object containing specific surcharging attributes applied to an order.
	 */
	public SurchargeSpecificOutput getSurchargeSpecificOutput() {
		return surchargeSpecificOutput;
	}

	/**
	 * Object containing specific surcharging attributes applied to an order.
	 */
	public void setSurchargeSpecificOutput(SurchargeSpecificOutput value) {
		this.surchargeSpecificOutput = value;
	}

	/**
	 * Object containing specific surcharging attributes applied to an order.
	 */
	public PaymentOutput withSurchargeSpecificOutput(SurchargeSpecificOutput value) {
		this.surchargeSpecificOutput = value;
		return this;
	}
}
