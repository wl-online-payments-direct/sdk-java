/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class CompletePaymentRequest {

	private CompletePaymentCardPaymentMethodSpecificInput cardPaymentMethodSpecificInput = null;

	private Order order = null;

	public CompletePaymentCardPaymentMethodSpecificInput getCardPaymentMethodSpecificInput() {
		return cardPaymentMethodSpecificInput;
	}

	public void setCardPaymentMethodSpecificInput(CompletePaymentCardPaymentMethodSpecificInput value) {
		this.cardPaymentMethodSpecificInput = value;
	}

	public CompletePaymentRequest withCardPaymentMethodSpecificInput(CompletePaymentCardPaymentMethodSpecificInput value) {
		this.cardPaymentMethodSpecificInput = value;
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
	public CompletePaymentRequest withOrder(Order value) {
		this.order = value;
		return this;
	}
}
