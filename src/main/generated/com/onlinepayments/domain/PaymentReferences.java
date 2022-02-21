/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object that holds all reference properties that are linked to this transaction
 */
public class PaymentReferences {

	private String merchantParameters = null;

	private String merchantReference = null;

	/**
	 * It allows you to store additional parameters for the transaction in the format you prefer (e.g.-&gt; key-value query string, JSON, etc.) These parameters are then echoed back to you in API GET calls and Webhook notifications. This field must not contain any personal data.
	 */
	public String getMerchantParameters() {
		return merchantParameters;
	}

	/**
	 * It allows you to store additional parameters for the transaction in the format you prefer (e.g.-&gt; key-value query string, JSON, etc.) These parameters are then echoed back to you in API GET calls and Webhook notifications. This field must not contain any personal data.
	 */
	public void setMerchantParameters(String value) {
		this.merchantParameters = value;
	}

	/**
	 * It allows you to store additional parameters for the transaction in the format you prefer (e.g.-&gt; key-value query string, JSON, etc.) These parameters are then echoed back to you in API GET calls and Webhook notifications. This field must not contain any personal data.
	 */
	public PaymentReferences withMerchantParameters(String value) {
		this.merchantParameters = value;
		return this;
	}

	/**
	 * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
	 */
	public String getMerchantReference() {
		return merchantReference;
	}

	/**
	 * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
	 */
	public void setMerchantReference(String value) {
		this.merchantReference = value;
	}

	/**
	 * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
	 */
	public PaymentReferences withMerchantReference(String value) {
		this.merchantReference = value;
		return this;
	}
}
