/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class IINDetail {

	private String cardType = null;

	private Boolean isAllowedInContext = null;

	private Integer paymentProductId = null;

	/**
	 * The card's type as categorised by the payment method. Possible values are:
	 *   * Credit
	 *   * Debit
	 *   * Prepaid
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * The card's type as categorised by the payment method. Possible values are:
	 *   * Credit
	 *   * Debit
	 *   * Prepaid
	 */
	public void setCardType(String value) {
		this.cardType = value;
	}

	/**
	 * The card's type as categorised by the payment method. Possible values are:
	 *   * Credit
	 *   * Debit
	 *   * Prepaid
	 */
	public IINDetail withCardType(String value) {
		this.cardType = value;
		return this;
	}

	/**
	 * Populated only if you submitted a payment context.
	 * * true - The payment product is allowed in the submitted context.
	 * * false - The payment product is not allowed in the submitted context. Note that in this case, none of the brands of the card will be allowed in the submitted context.
	 */
	public Boolean getIsAllowedInContext() {
		return isAllowedInContext;
	}

	/**
	 * Populated only if you submitted a payment context.
	 * * true - The payment product is allowed in the submitted context.
	 * * false - The payment product is not allowed in the submitted context. Note that in this case, none of the brands of the card will be allowed in the submitted context.
	 */
	public void setIsAllowedInContext(Boolean value) {
		this.isAllowedInContext = value;
	}

	/**
	 * Populated only if you submitted a payment context.
	 * * true - The payment product is allowed in the submitted context.
	 * * false - The payment product is not allowed in the submitted context. Note that in this case, none of the brands of the card will be allowed in the submitted context.
	 */
	public IINDetail withIsAllowedInContext(Boolean value) {
		this.isAllowedInContext = value;
		return this;
	}

	/**
	 * Payment product identifier - Please see Products documentation for a full overview of possible values.
	 */
	public Integer getPaymentProductId() {
		return paymentProductId;
	}

	/**
	 * Payment product identifier - Please see Products documentation for a full overview of possible values.
	 */
	public void setPaymentProductId(Integer value) {
		this.paymentProductId = value;
	}

	/**
	 * Payment product identifier - Please see Products documentation for a full overview of possible values.
	 */
	public IINDetail withPaymentProductId(Integer value) {
		this.paymentProductId = value;
		return this;
	}
}
