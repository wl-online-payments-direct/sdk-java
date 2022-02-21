/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

public class CapturePaymentRequest {

	private Long amount = null;

	private Boolean isFinal = null;

	private PaymentReferences references = null;

	/**
	 * Here you can specify the amount that you want to capture (specified in cents, where single digit currencies are presumed to have 2 digits). The amount can be lower than the amount that was authorized, but not higher. 
	 *  If left empty, the full amount will be captured and the request will be final. 
	 *  If the full amount is captured, the request will also be final.
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * Here you can specify the amount that you want to capture (specified in cents, where single digit currencies are presumed to have 2 digits). The amount can be lower than the amount that was authorized, but not higher. 
	 *  If left empty, the full amount will be captured and the request will be final. 
	 *  If the full amount is captured, the request will also be final.
	 */
	public void setAmount(Long value) {
		this.amount = value;
	}

	/**
	 * Here you can specify the amount that you want to capture (specified in cents, where single digit currencies are presumed to have 2 digits). The amount can be lower than the amount that was authorized, but not higher. 
	 *  If left empty, the full amount will be captured and the request will be final. 
	 *  If the full amount is captured, the request will also be final.
	 */
	public CapturePaymentRequest withAmount(Long value) {
		this.amount = value;
		return this;
	}

	/**
	 * This property indicates whether this will be the final capture of this transaction. The default value for this property is false.
	 */
	public Boolean getIsFinal() {
		return isFinal;
	}

	/**
	 * This property indicates whether this will be the final capture of this transaction. The default value for this property is false.
	 */
	public void setIsFinal(Boolean value) {
		this.isFinal = value;
	}

	/**
	 * This property indicates whether this will be the final capture of this transaction. The default value for this property is false.
	 */
	public CapturePaymentRequest withIsFinal(Boolean value) {
		this.isFinal = value;
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
	public CapturePaymentRequest withReferences(PaymentReferences value) {
		this.references = value;
		return this;
	}
}
