/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class IINDetail {

	private Boolean isAllowedInContext = null;

	private Integer paymentProductId = null;

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
	 * The payment product identifier associated with the card. If the card has multiple brands, then we select the most appropriate payment product based on your configuration and the payment context, if you submitted one.
	 */
	public Integer getPaymentProductId() {
		return paymentProductId;
	}

	/**
	 * The payment product identifier associated with the card. If the card has multiple brands, then we select the most appropriate payment product based on your configuration and the payment context, if you submitted one.
	 */
	public void setPaymentProductId(Integer value) {
		this.paymentProductId = value;
	}

	/**
	 * The payment product identifier associated with the card. If the card has multiple brands, then we select the most appropriate payment product based on your configuration and the payment context, if you submitted one.
	 */
	public IINDetail withPaymentProductId(Integer value) {
		this.paymentProductId = value;
		return this;
	}
}
