/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object that holds all reference properties that are linked to this transaction
 */
public class OrderReferences {

	private String descriptor = null;

	private String merchantParameters = null;

	private String merchantReference = null;

	/**
	 * Descriptive text that is used towards to customer, either during an online checkout at a third party and/or on the statement of the customer. For card transactions this is usually referred to as a Soft Descriptor. The maximum allowed length varies per card acquirer:
	 *  * AIB - 22 characters
	 *  * American Express - 25 characters
	 *  * Atos Origin BNP - 15 characters
	 *  * Barclays - 25 characters
	 *  * Catella - 22 characters
	 *  * CBA - 20 characters
	 *  * Elavon - 25 characters
	 *  * First Data - 25 characters
	 *  * INICIS (INIPAY) - 22-30 characters
	 *  * JCB - 25 characters
	 *  * Merchant Solutions - 22-25 characters
	 *  * Payvision (EU &amp; HK) - 25 characters
	 *  * SEB Euroline - 22 characters
	 *  * Sub1 Argentina - 15 characters
	 *  * Wells Fargo - 25 characters
	 * 
	 * Note that we advise you to use 22 characters as the max length as beyond this our experience is that issuers will start to truncate. We currently also only allow per API call overrides for AIB and Barclays
	 * For alternative payment products the maximum allowed length varies per payment product:
	 *  * 402 e-Przelewy - 30 characters
	 *  * 404 INICIS - 80 characters
	 *  * 802 Nordea ePayment Finland - 234 characters
	 *  * 809 iDeal - 32 characters
	 *  * 836 SOFORT - 42 characters
	 *  * 840 PayPal - 127 characters
	 *  * 841 WebMoney - 175 characters
	 *  * 849 Yandex - 64 characters
	 *  * 861 Alipay - 256 characters
	 *  * 863 WeChat Pay - 32 characters
	 *  * 880 BOKU - 20 characters
	 *  * 8580 Qiwi - 255 characters
	 *  * 1504 Konbini - 80 characters
	 * 
	 * All other payment products don't support a descriptor.
	 */
	public String getDescriptor() {
		return descriptor;
	}

	/**
	 * Descriptive text that is used towards to customer, either during an online checkout at a third party and/or on the statement of the customer. For card transactions this is usually referred to as a Soft Descriptor. The maximum allowed length varies per card acquirer:
	 *  * AIB - 22 characters
	 *  * American Express - 25 characters
	 *  * Atos Origin BNP - 15 characters
	 *  * Barclays - 25 characters
	 *  * Catella - 22 characters
	 *  * CBA - 20 characters
	 *  * Elavon - 25 characters
	 *  * First Data - 25 characters
	 *  * INICIS (INIPAY) - 22-30 characters
	 *  * JCB - 25 characters
	 *  * Merchant Solutions - 22-25 characters
	 *  * Payvision (EU &amp; HK) - 25 characters
	 *  * SEB Euroline - 22 characters
	 *  * Sub1 Argentina - 15 characters
	 *  * Wells Fargo - 25 characters
	 * 
	 * Note that we advise you to use 22 characters as the max length as beyond this our experience is that issuers will start to truncate. We currently also only allow per API call overrides for AIB and Barclays
	 * For alternative payment products the maximum allowed length varies per payment product:
	 *  * 402 e-Przelewy - 30 characters
	 *  * 404 INICIS - 80 characters
	 *  * 802 Nordea ePayment Finland - 234 characters
	 *  * 809 iDeal - 32 characters
	 *  * 836 SOFORT - 42 characters
	 *  * 840 PayPal - 127 characters
	 *  * 841 WebMoney - 175 characters
	 *  * 849 Yandex - 64 characters
	 *  * 861 Alipay - 256 characters
	 *  * 863 WeChat Pay - 32 characters
	 *  * 880 BOKU - 20 characters
	 *  * 8580 Qiwi - 255 characters
	 *  * 1504 Konbini - 80 characters
	 * 
	 * All other payment products don't support a descriptor.
	 */
	public void setDescriptor(String value) {
		this.descriptor = value;
	}

	/**
	 * Descriptive text that is used towards to customer, either during an online checkout at a third party and/or on the statement of the customer. For card transactions this is usually referred to as a Soft Descriptor. The maximum allowed length varies per card acquirer:
	 *  * AIB - 22 characters
	 *  * American Express - 25 characters
	 *  * Atos Origin BNP - 15 characters
	 *  * Barclays - 25 characters
	 *  * Catella - 22 characters
	 *  * CBA - 20 characters
	 *  * Elavon - 25 characters
	 *  * First Data - 25 characters
	 *  * INICIS (INIPAY) - 22-30 characters
	 *  * JCB - 25 characters
	 *  * Merchant Solutions - 22-25 characters
	 *  * Payvision (EU &amp; HK) - 25 characters
	 *  * SEB Euroline - 22 characters
	 *  * Sub1 Argentina - 15 characters
	 *  * Wells Fargo - 25 characters
	 * 
	 * Note that we advise you to use 22 characters as the max length as beyond this our experience is that issuers will start to truncate. We currently also only allow per API call overrides for AIB and Barclays
	 * For alternative payment products the maximum allowed length varies per payment product:
	 *  * 402 e-Przelewy - 30 characters
	 *  * 404 INICIS - 80 characters
	 *  * 802 Nordea ePayment Finland - 234 characters
	 *  * 809 iDeal - 32 characters
	 *  * 836 SOFORT - 42 characters
	 *  * 840 PayPal - 127 characters
	 *  * 841 WebMoney - 175 characters
	 *  * 849 Yandex - 64 characters
	 *  * 861 Alipay - 256 characters
	 *  * 863 WeChat Pay - 32 characters
	 *  * 880 BOKU - 20 characters
	 *  * 8580 Qiwi - 255 characters
	 *  * 1504 Konbini - 80 characters
	 * 
	 * All other payment products don't support a descriptor.
	 */
	public OrderReferences withDescriptor(String value) {
		this.descriptor = value;
		return this;
	}

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
	public OrderReferences withMerchantParameters(String value) {
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
	public OrderReferences withMerchantReference(String value) {
		this.merchantReference = value;
		return this;
	}
}
