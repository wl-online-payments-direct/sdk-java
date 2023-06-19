/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * An object containing the Create PaymentLink request.
 */
public class CreatePaymentLinkRequest {

	private String description = null;

	private String expirationDate = null;

	private PaymentLinkOrder paymentLinkOrder = null;

	private String recipientName = null;

	/**
	 * A note related to the created payment link.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * A note related to the created payment link.
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * A note related to the created payment link.
	 */
	public CreatePaymentLinkRequest withDescription(String value) {
		this.description = value;
		return this;
	}

	/**
	 * The date after which the payment link will not be usable to complete the payment. The date sent cannot be more than 30 days in the future or a past date. It must also contain the UTC offset.
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * The date after which the payment link will not be usable to complete the payment. The date sent cannot be more than 30 days in the future or a past date. It must also contain the UTC offset.
	 */
	public void setExpirationDate(String value) {
		this.expirationDate = value;
	}

	/**
	 * The date after which the payment link will not be usable to complete the payment. The date sent cannot be more than 30 days in the future or a past date. It must also contain the UTC offset.
	 */
	public CreatePaymentLinkRequest withExpirationDate(String value) {
		this.expirationDate = value;
		return this;
	}

	/**
	 * An object containing the details of the related payment.
	 */
	public PaymentLinkOrder getPaymentLinkOrder() {
		return paymentLinkOrder;
	}

	/**
	 * An object containing the details of the related payment.
	 */
	public void setPaymentLinkOrder(PaymentLinkOrder value) {
		this.paymentLinkOrder = value;
	}

	/**
	 * An object containing the details of the related payment.
	 */
	public CreatePaymentLinkRequest withPaymentLinkOrder(PaymentLinkOrder value) {
		this.paymentLinkOrder = value;
		return this;
	}

	/**
	 * The payment link recipient name.
	 */
	public String getRecipientName() {
		return recipientName;
	}

	/**
	 * The payment link recipient name.
	 */
	public void setRecipientName(String value) {
		this.recipientName = value;
	}

	/**
	 * The payment link recipient name.
	 */
	public CreatePaymentLinkRequest withRecipientName(String value) {
		this.recipientName = value;
		return this;
	}
}
