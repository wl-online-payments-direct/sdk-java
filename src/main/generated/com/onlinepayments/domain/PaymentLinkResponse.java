/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

import java.util.List;

/**
 * An object representing a payment link.
 */
public class PaymentLinkResponse {

	private String expirationDate = null;

	private String paymentId = null;

	private List<PaymentLinkEvent> paymentLinkEvents = null;

	private String paymentLinkId = null;

	private PaymentLinkOrderOutput paymentLinkOrder = null;

	private String recipientName = null;

	private String redirectionUrl = null;

	private String status = null;

	/**
	 * The date after which the payment link will not be usable to complete the payment. The date will contain the UTC offset.
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * The date after which the payment link will not be usable to complete the payment. The date will contain the UTC offset.
	 */
	public void setExpirationDate(String value) {
		this.expirationDate = value;
	}

	/**
	 * The date after which the payment link will not be usable to complete the payment. The date will contain the UTC offset.
	 */
	public PaymentLinkResponse withExpirationDate(String value) {
		this.expirationDate = value;
		return this;
	}

	/**
	 * The unique payment transaction identifier. This id is only set when a payment was processed with this payment link.
	 */
	public String getPaymentId() {
		return paymentId;
	}

	/**
	 * The unique payment transaction identifier. This id is only set when a payment was processed with this payment link.
	 */
	public void setPaymentId(String value) {
		this.paymentId = value;
	}

	/**
	 * The unique payment transaction identifier. This id is only set when a payment was processed with this payment link.
	 */
	public PaymentLinkResponse withPaymentId(String value) {
		this.paymentId = value;
		return this;
	}

	public List<PaymentLinkEvent> getPaymentLinkEvents() {
		return paymentLinkEvents;
	}

	public void setPaymentLinkEvents(List<PaymentLinkEvent> value) {
		this.paymentLinkEvents = value;
	}

	public PaymentLinkResponse withPaymentLinkEvents(List<PaymentLinkEvent> value) {
		this.paymentLinkEvents = value;
		return this;
	}

	/**
	 * The unique link identifier.
	 */
	public String getPaymentLinkId() {
		return paymentLinkId;
	}

	/**
	 * The unique link identifier.
	 */
	public void setPaymentLinkId(String value) {
		this.paymentLinkId = value;
	}

	/**
	 * The unique link identifier.
	 */
	public PaymentLinkResponse withPaymentLinkId(String value) {
		this.paymentLinkId = value;
		return this;
	}

	/**
	 * An object containing the details of the related payment output.
	 */
	public PaymentLinkOrderOutput getPaymentLinkOrder() {
		return paymentLinkOrder;
	}

	/**
	 * An object containing the details of the related payment output.
	 */
	public void setPaymentLinkOrder(PaymentLinkOrderOutput value) {
		this.paymentLinkOrder = value;
	}

	/**
	 * An object containing the details of the related payment output.
	 */
	public PaymentLinkResponse withPaymentLinkOrder(PaymentLinkOrderOutput value) {
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
	public PaymentLinkResponse withRecipientName(String value) {
		this.recipientName = value;
		return this;
	}

	/**
	 * The URL that will redirect the customer to the Hosted Checkout page to process the payment.
	 */
	public String getRedirectionUrl() {
		return redirectionUrl;
	}

	/**
	 * The URL that will redirect the customer to the Hosted Checkout page to process the payment.
	 */
	public void setRedirectionUrl(String value) {
		this.redirectionUrl = value;
	}

	/**
	 * The URL that will redirect the customer to the Hosted Checkout page to process the payment.
	 */
	public PaymentLinkResponse withRedirectionUrl(String value) {
		this.redirectionUrl = value;
		return this;
	}

	/**
	 * The state of the payment link:
	 *   * ACTIVE: The payment link is ready to be used.
	 *   * PAID: The payment has been completed.
	 *   * CANCELLED: The payment link has been manually cancelled.
	 *   * EXPIRED: The payment link is not usable anymore.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * The state of the payment link:
	 *   * ACTIVE: The payment link is ready to be used.
	 *   * PAID: The payment has been completed.
	 *   * CANCELLED: The payment link has been manually cancelled.
	 *   * EXPIRED: The payment link is not usable anymore.
	 */
	public void setStatus(String value) {
		this.status = value;
	}

	/**
	 * The state of the payment link:
	 *   * ACTIVE: The payment link is ready to be used.
	 *   * PAID: The payment has been completed.
	 *   * CANCELLED: The payment link has been manually cancelled.
	 *   * EXPIRED: The payment link is not usable anymore.
	 */
	public PaymentLinkResponse withStatus(String value) {
		this.status = value;
		return this;
	}
}
