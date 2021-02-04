/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.domain;

public class CompletePaymentRequest {

	private CompletePaymentCardPaymentMethodSpecificInput cardPaymentMethodSpecificInput = null;

	private Order order = null;

	public CompletePaymentCardPaymentMethodSpecificInput getCardPaymentMethodSpecificInput() {
		return cardPaymentMethodSpecificInput;
	}

	public void setCardPaymentMethodSpecificInput(CompletePaymentCardPaymentMethodSpecificInput value) {
		this.cardPaymentMethodSpecificInput = value;
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
}
