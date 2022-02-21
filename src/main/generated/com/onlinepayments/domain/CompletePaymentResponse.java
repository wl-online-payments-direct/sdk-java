/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class CompletePaymentResponse {

	private PaymentCreationOutput creationOutput = null;

	private MerchantAction merchantAction = null;

	private PaymentResponse payment = null;

	/**
	 * Object containing the details of the created payment.
	 */
	public PaymentCreationOutput getCreationOutput() {
		return creationOutput;
	}

	/**
	 * Object containing the details of the created payment.
	 */
	public void setCreationOutput(PaymentCreationOutput value) {
		this.creationOutput = value;
	}

	/**
	 * Object containing the details of the created payment.
	 */
	public CompletePaymentResponse withCreationOutput(PaymentCreationOutput value) {
		this.creationOutput = value;
		return this;
	}

	/**
	 * Object that contains the action, including the needed data, that you should perform next, like showing instructions, showing the transaction results or redirect to a third party to complete the payment
	 */
	public MerchantAction getMerchantAction() {
		return merchantAction;
	}

	/**
	 * Object that contains the action, including the needed data, that you should perform next, like showing instructions, showing the transaction results or redirect to a third party to complete the payment
	 */
	public void setMerchantAction(MerchantAction value) {
		this.merchantAction = value;
	}

	/**
	 * Object that contains the action, including the needed data, that you should perform next, like showing instructions, showing the transaction results or redirect to a third party to complete the payment
	 */
	public CompletePaymentResponse withMerchantAction(MerchantAction value) {
		this.merchantAction = value;
		return this;
	}

	/**
	 * Object that holds the payment related properties
	 */
	public PaymentResponse getPayment() {
		return payment;
	}

	/**
	 * Object that holds the payment related properties
	 */
	public void setPayment(PaymentResponse value) {
		this.payment = value;
	}

	/**
	 * Object that holds the payment related properties
	 */
	public CompletePaymentResponse withPayment(PaymentResponse value) {
		this.payment = value;
		return this;
	}
}
