/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class SubsequentPaymentRequest {

	private Order order = null;

	private SubsequentCardPaymentMethodSpecificInput subsequentcardPaymentMethodSpecificInput = null;

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
	public SubsequentPaymentRequest withOrder(Order value) {
		this.order = value;
		return this;
	}

	/**
	 * Object containing the specific input details for subsequent card payments
	 */
	public SubsequentCardPaymentMethodSpecificInput getSubsequentcardPaymentMethodSpecificInput() {
		return subsequentcardPaymentMethodSpecificInput;
	}

	/**
	 * Object containing the specific input details for subsequent card payments
	 */
	public void setSubsequentcardPaymentMethodSpecificInput(SubsequentCardPaymentMethodSpecificInput value) {
		this.subsequentcardPaymentMethodSpecificInput = value;
	}

	/**
	 * Object containing the specific input details for subsequent card payments
	 */
	public SubsequentPaymentRequest withSubsequentcardPaymentMethodSpecificInput(SubsequentCardPaymentMethodSpecificInput value) {
		this.subsequentcardPaymentMethodSpecificInput = value;
		return this;
	}
}
