/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing operation details
 */
public class OperationOutput {

	private AmountOfMoney amountOfMoney = null;

	private String id = null;

	private String paymentMethod = null;

	private PaymentReferences references = null;

	private String status = null;

	private PaymentStatusOutput statusOutput = null;

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
	public OperationOutput withAmountOfMoney(AmountOfMoney value) {
		this.amountOfMoney = value;
		return this;
	}

	/**
	 * Our unique payment transaction identifier
	 */
	public String getId() {
		return id;
	}

	/**
	 * Our unique payment transaction identifier
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Our unique payment transaction identifier
	 */
	public OperationOutput withId(String value) {
		this.id = value;
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
	public OperationOutput withPaymentMethod(String value) {
		this.paymentMethod = value;
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
	public OperationOutput withReferences(PaymentReferences value) {
		this.references = value;
		return this;
	}

	/**
	 * Current high-level status of the payment in a human-readable form.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Current high-level status of the payment in a human-readable form.
	 */
	public void setStatus(String value) {
		this.status = value;
	}

	/**
	 * Current high-level status of the payment in a human-readable form.
	 */
	public OperationOutput withStatus(String value) {
		this.status = value;
		return this;
	}

	/**
	 * This object has the numeric representation of the current payment status, timestamp of last status change and performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
	 */
	public PaymentStatusOutput getStatusOutput() {
		return statusOutput;
	}

	/**
	 * This object has the numeric representation of the current payment status, timestamp of last status change and performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
	 */
	public void setStatusOutput(PaymentStatusOutput value) {
		this.statusOutput = value;
	}

	/**
	 * This object has the numeric representation of the current payment status, timestamp of last status change and performable action on the current payment resource. In case of failed payments and negative scenarios, detailed error information is listed.
	 */
	public OperationOutput withStatusOutput(PaymentStatusOutput value) {
		this.statusOutput = value;
		return this;
	}
}
