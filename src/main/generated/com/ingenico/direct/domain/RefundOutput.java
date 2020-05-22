/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing refund details
 */
public class RefundOutput {

	private AmountOfMoney amountOfMoney = null;

	private Long amountPaid = null;

	private RefundCardMethodSpecificOutput cardRefundMethodSpecificOutput = null;

	private RefundEWalletMethodSpecificOutput eWalletRefundMethodSpecificOutput = null;

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

	public Long getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Long value) {
		this.amountPaid = value;
	}

	public RefundCardMethodSpecificOutput getCardRefundMethodSpecificOutput() {
		return cardRefundMethodSpecificOutput;
	}

	public void setCardRefundMethodSpecificOutput(RefundCardMethodSpecificOutput value) {
		this.cardRefundMethodSpecificOutput = value;
	}

	public RefundEWalletMethodSpecificOutput getEWalletRefundMethodSpecificOutput() {
		return eWalletRefundMethodSpecificOutput;
	}

	public void setEWalletRefundMethodSpecificOutput(RefundEWalletMethodSpecificOutput value) {
		this.eWalletRefundMethodSpecificOutput = value;
	}

	public RefundMobileMethodSpecificOutput getMobileRefundMethodSpecificOutput() {
		return mobileRefundMethodSpecificOutput;
	}

	public void setMobileRefundMethodSpecificOutput(RefundMobileMethodSpecificOutput value) {
		this.mobileRefundMethodSpecificOutput = value;
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

	public RefundRedirectMethodSpecificOutput getRedirectRefundMethodSpecificOutput() {
		return redirectRefundMethodSpecificOutput;
	}

	public void setRedirectRefundMethodSpecificOutput(RefundRedirectMethodSpecificOutput value) {
		this.redirectRefundMethodSpecificOutput = value;
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
}
