/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing the specific input details for payments that involve redirects to 3rd parties to complete, like iDeal and PayPal
 */
public class RedirectPaymentMethodSpecificInput {

	private String paymentOption = null;

	private RedirectPaymentProduct3306SpecificInput paymentProduct3306SpecificInput = null;

	private RedirectPaymentProduct5001SpecificInput paymentProduct5001SpecificInput = null;

	private RedirectPaymentProduct5406SpecificInput paymentProduct5406SpecificInput = null;

	private RedirectPaymentProduct5408SpecificInput paymentProduct5408SpecificInput = null;

	private RedirectPaymentProduct809SpecificInput paymentProduct809SpecificInput = null;

	private RedirectPaymentProduct840SpecificInput paymentProduct840SpecificInput = null;

	private Integer paymentProductId = null;

	private RedirectionData redirectionData = null;

	private Boolean requiresApproval = null;

	private String token = null;

	private Boolean tokenize = null;

	/**
	 * The specific payment option for the payment. To be used as a complement of the more generic paymentProductId (oney, banquecasino, cofidis), which allows to define a variation of the selected paymentProductId (ex: facilypay3x, banquecasino4x, cofidis3x-sansfrais, ...). List of modalities included in the payment product page.
	 */
	public String getPaymentOption() {
		return paymentOption;
	}

	/**
	 * The specific payment option for the payment. To be used as a complement of the more generic paymentProductId (oney, banquecasino, cofidis), which allows to define a variation of the selected paymentProductId (ex: facilypay3x, banquecasino4x, cofidis3x-sansfrais, ...). List of modalities included in the payment product page.
	 */
	public void setPaymentOption(String value) {
		this.paymentOption = value;
	}

	/**
	 * The specific payment option for the payment. To be used as a complement of the more generic paymentProductId (oney, banquecasino, cofidis), which allows to define a variation of the selected paymentProductId (ex: facilypay3x, banquecasino4x, cofidis3x-sansfrais, ...). List of modalities included in the payment product page.
	 */
	public RedirectPaymentMethodSpecificInput withPaymentOption(String value) {
		this.paymentOption = value;
		return this;
	}

	/**
	 * Object containing specific input required for Klarna payments (Payment product ID 3306)
	 */
	public RedirectPaymentProduct3306SpecificInput getPaymentProduct3306SpecificInput() {
		return paymentProduct3306SpecificInput;
	}

	/**
	 * Object containing specific input required for Klarna payments (Payment product ID 3306)
	 */
	public void setPaymentProduct3306SpecificInput(RedirectPaymentProduct3306SpecificInput value) {
		this.paymentProduct3306SpecificInput = value;
	}

	/**
	 * Object containing specific input required for Klarna payments (Payment product ID 3306)
	 */
	public RedirectPaymentMethodSpecificInput withPaymentProduct3306SpecificInput(RedirectPaymentProduct3306SpecificInput value) {
		this.paymentProduct3306SpecificInput = value;
		return this;
	}

	/**
	 * Object containing specific input required for Bizum payments
	 */
	public RedirectPaymentProduct5001SpecificInput getPaymentProduct5001SpecificInput() {
		return paymentProduct5001SpecificInput;
	}

	/**
	 * Object containing specific input required for Bizum payments
	 */
	public void setPaymentProduct5001SpecificInput(RedirectPaymentProduct5001SpecificInput value) {
		this.paymentProduct5001SpecificInput = value;
	}

	/**
	 * Object containing specific input required for Bizum payments
	 */
	public RedirectPaymentMethodSpecificInput withPaymentProduct5001SpecificInput(RedirectPaymentProduct5001SpecificInput value) {
		this.paymentProduct5001SpecificInput = value;
		return this;
	}

	/**
	 * Object containing specific input for EPS payments (Payment product ID 5406)
	 */
	public RedirectPaymentProduct5406SpecificInput getPaymentProduct5406SpecificInput() {
		return paymentProduct5406SpecificInput;
	}

	/**
	 * Object containing specific input for EPS payments (Payment product ID 5406)
	 */
	public void setPaymentProduct5406SpecificInput(RedirectPaymentProduct5406SpecificInput value) {
		this.paymentProduct5406SpecificInput = value;
	}

	/**
	 * Object containing specific input for EPS payments (Payment product ID 5406)
	 */
	public RedirectPaymentMethodSpecificInput withPaymentProduct5406SpecificInput(RedirectPaymentProduct5406SpecificInput value) {
		this.paymentProduct5406SpecificInput = value;
		return this;
	}

	/**
	 * Object containing specific input for Account to Account payments (Payment product ID 5408)
	 */
	public RedirectPaymentProduct5408SpecificInput getPaymentProduct5408SpecificInput() {
		return paymentProduct5408SpecificInput;
	}

	/**
	 * Object containing specific input for Account to Account payments (Payment product ID 5408)
	 */
	public void setPaymentProduct5408SpecificInput(RedirectPaymentProduct5408SpecificInput value) {
		this.paymentProduct5408SpecificInput = value;
	}

	/**
	 * Object containing specific input for Account to Account payments (Payment product ID 5408)
	 */
	public RedirectPaymentMethodSpecificInput withPaymentProduct5408SpecificInput(RedirectPaymentProduct5408SpecificInput value) {
		this.paymentProduct5408SpecificInput = value;
		return this;
	}

	/**
	 * Object containing specific input required for iDeal payments (Payment product ID 809)
	 */
	public RedirectPaymentProduct809SpecificInput getPaymentProduct809SpecificInput() {
		return paymentProduct809SpecificInput;
	}

	/**
	 * Object containing specific input required for iDeal payments (Payment product ID 809)
	 */
	public void setPaymentProduct809SpecificInput(RedirectPaymentProduct809SpecificInput value) {
		this.paymentProduct809SpecificInput = value;
	}

	/**
	 * Object containing specific input required for iDeal payments (Payment product ID 809)
	 */
	public RedirectPaymentMethodSpecificInput withPaymentProduct809SpecificInput(RedirectPaymentProduct809SpecificInput value) {
		this.paymentProduct809SpecificInput = value;
		return this;
	}

	/**
	 * Object containing specific input required for PayPal payments (Payment product ID 840)
	 */
	public RedirectPaymentProduct840SpecificInput getPaymentProduct840SpecificInput() {
		return paymentProduct840SpecificInput;
	}

	/**
	 * Object containing specific input required for PayPal payments (Payment product ID 840)
	 */
	public void setPaymentProduct840SpecificInput(RedirectPaymentProduct840SpecificInput value) {
		this.paymentProduct840SpecificInput = value;
	}

	/**
	 * Object containing specific input required for PayPal payments (Payment product ID 840)
	 */
	public RedirectPaymentMethodSpecificInput withPaymentProduct840SpecificInput(RedirectPaymentProduct840SpecificInput value) {
		this.paymentProduct840SpecificInput = value;
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
	public RedirectPaymentMethodSpecificInput withPaymentProductId(Integer value) {
		this.paymentProductId = value;
		return this;
	}

	/**
	 * Object containing browser specific redirection related data
	 */
	public RedirectionData getRedirectionData() {
		return redirectionData;
	}

	/**
	 * Object containing browser specific redirection related data
	 */
	public void setRedirectionData(RedirectionData value) {
		this.redirectionData = value;
	}

	/**
	 * Object containing browser specific redirection related data
	 */
	public RedirectPaymentMethodSpecificInput withRedirectionData(RedirectionData value) {
		this.redirectionData = value;
		return this;
	}

	/**
	 * * true = the payment requires approval before the funds will be captured using the Approve payment or Capture payment API
	 * * false = the payment does not require approval, and the funds will be captured automatically
	 */
	public Boolean getRequiresApproval() {
		return requiresApproval;
	}

	/**
	 * * true = the payment requires approval before the funds will be captured using the Approve payment or Capture payment API
	 * * false = the payment does not require approval, and the funds will be captured automatically
	 */
	public void setRequiresApproval(Boolean value) {
		this.requiresApproval = value;
	}

	/**
	 * * true = the payment requires approval before the funds will be captured using the Approve payment or Capture payment API
	 * * false = the payment does not require approval, and the funds will be captured automatically
	 */
	public RedirectPaymentMethodSpecificInput withRequiresApproval(Boolean value) {
		this.requiresApproval = value;
		return this;
	}

	/**
	 * ID of the token to use to create the payment.
	 */
	public String getToken() {
		return token;
	}

	/**
	 * ID of the token to use to create the payment.
	 */
	public void setToken(String value) {
		this.token = value;
	}

	/**
	 * ID of the token to use to create the payment.
	 */
	public RedirectPaymentMethodSpecificInput withToken(String value) {
		this.token = value;
		return this;
	}

	/**
	 * Indicates if this transaction should be tokenized
	 *   * true - Tokenize the transaction.
	 *   * false - Do not tokenize the transaction, unless it would be tokenized by other means such as auto-tokenization of recurring payments.
	 */
	public Boolean getTokenize() {
		return tokenize;
	}

	/**
	 * Indicates if this transaction should be tokenized
	 *   * true - Tokenize the transaction.
	 *   * false - Do not tokenize the transaction, unless it would be tokenized by other means such as auto-tokenization of recurring payments.
	 */
	public void setTokenize(Boolean value) {
		this.tokenize = value;
	}

	/**
	 * Indicates if this transaction should be tokenized
	 *   * true - Tokenize the transaction.
	 *   * false - Do not tokenize the transaction, unless it would be tokenized by other means such as auto-tokenization of recurring payments.
	 */
	public RedirectPaymentMethodSpecificInput withTokenize(Boolean value) {
		this.tokenize = value;
		return this;
	}
}
