/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing refund details
 */
public class RefundOutput {

	private AmountOfMoney amountOfMoney = null;

	private Long amountPaid = null;

	private RefundCardMethodSpecificOutput cardRefundMethodSpecificOutput = null;

	private RefundEWalletMethodSpecificOutput eWalletRefundMethodSpecificOutput = null;

	private String merchantParameters = null;

	private RefundMobileMethodSpecificOutput mobileRefundMethodSpecificOutput = null;

	private String paymentMethod = null;

	private RefundRedirectMethodSpecificOutput redirectRefundMethodSpecificOutput = null;

	private PaymentReferences references = null;

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
	public RefundOutput withAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
		return this;
	}

	public Long getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Long value) {
		this.amountPaid = value;
	}

	public RefundOutput withAmountPaid(Long value) {
		this.amountPaid = value;
		return this;
	}

	public RefundCardMethodSpecificOutput getCardRefundMethodSpecificOutput() {
		return cardRefundMethodSpecificOutput;
	}

	public void setCardRefundMethodSpecificOutput(RefundCardMethodSpecificOutput value) {
		this.cardRefundMethodSpecificOutput = value;
	}

	public RefundOutput withCardRefundMethodSpecificOutput(RefundCardMethodSpecificOutput value) {
		this.cardRefundMethodSpecificOutput = value;
		return this;
	}

	public RefundEWalletMethodSpecificOutput getEWalletRefundMethodSpecificOutput() {
		return eWalletRefundMethodSpecificOutput;
	}

	public void setEWalletRefundMethodSpecificOutput(RefundEWalletMethodSpecificOutput value) {
		this.eWalletRefundMethodSpecificOutput = value;
	}

	public RefundOutput withEWalletRefundMethodSpecificOutput(RefundEWalletMethodSpecificOutput value) {
		this.eWalletRefundMethodSpecificOutput = value;
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
	public RefundOutput withMerchantParameters(String value) {
		this.merchantParameters = value;
		return this;
	}

	public RefundMobileMethodSpecificOutput getMobileRefundMethodSpecificOutput() {
		return mobileRefundMethodSpecificOutput;
	}

	public void setMobileRefundMethodSpecificOutput(RefundMobileMethodSpecificOutput value) {
		this.mobileRefundMethodSpecificOutput = value;
	}

	public RefundOutput withMobileRefundMethodSpecificOutput(RefundMobileMethodSpecificOutput value) {
		this.mobileRefundMethodSpecificOutput = value;
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
	public RefundOutput withPaymentMethod(String value) {
		this.paymentMethod = value;
		return this;
	}

	public RefundRedirectMethodSpecificOutput getRedirectRefundMethodSpecificOutput() {
		return redirectRefundMethodSpecificOutput;
	}

	public void setRedirectRefundMethodSpecificOutput(RefundRedirectMethodSpecificOutput value) {
		this.redirectRefundMethodSpecificOutput = value;
	}

	public RefundOutput withRedirectRefundMethodSpecificOutput(RefundRedirectMethodSpecificOutput value) {
		this.redirectRefundMethodSpecificOutput = value;
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
	public RefundOutput withReferences(PaymentReferences value) {
		this.references = value;
		return this;
	}
}
