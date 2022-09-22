/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing the card payment method details
 */
public class CardPaymentMethodSpecificOutput {

	private Long authenticatedAmount = null;

	private String authorisationCode = null;

	private CardEssentials card = null;

	private ExternalTokenLinked externalTokenLinked = null;

	private CardFraudResults fraudResults = null;

	private String initialSchemeTransactionId = null;

	private String paymentOption = null;

	private Integer paymentProductId = null;

	private String schemeReferenceData = null;

	private ThreeDSecureResults threeDSecureResults = null;

	private String token = null;

	/**
	 * Allows amount to be authenticated to be different from amount authorized. (Amount in cents and always having 2 decimals)
	 */
	public Long getAuthenticatedAmount() {
		return authenticatedAmount;
	}

	/**
	 * Allows amount to be authenticated to be different from amount authorized. (Amount in cents and always having 2 decimals)
	 */
	public void setAuthenticatedAmount(Long value) {
		this.authenticatedAmount = value;
	}

	/**
	 * Allows amount to be authenticated to be different from amount authorized. (Amount in cents and always having 2 decimals)
	 */
	public CardPaymentMethodSpecificOutput withAuthenticatedAmount(Long value) {
		this.authenticatedAmount = value;
		return this;
	}

	/**
	 * Card Authorization code as returned by the acquirer
	 */
	public String getAuthorisationCode() {
		return authorisationCode;
	}

	/**
	 * Card Authorization code as returned by the acquirer
	 */
	public void setAuthorisationCode(String value) {
		this.authorisationCode = value;
	}

	/**
	 * Card Authorization code as returned by the acquirer
	 */
	public CardPaymentMethodSpecificOutput withAuthorisationCode(String value) {
		this.authorisationCode = value;
		return this;
	}

	/**
	 * Object containing card details
	 */
	public CardEssentials getCard() {
		return card;
	}

	/**
	 * Object containing card details
	 */
	public void setCard(CardEssentials value) {
		this.card = value;
	}

	/**
	 * Object containing card details
	 */
	public CardPaymentMethodSpecificOutput withCard(CardEssentials value) {
		this.card = value;
		return this;
	}

	public ExternalTokenLinked getExternalTokenLinked() {
		return externalTokenLinked;
	}

	public void setExternalTokenLinked(ExternalTokenLinked value) {
		this.externalTokenLinked = value;
	}

	public CardPaymentMethodSpecificOutput withExternalTokenLinked(ExternalTokenLinked value) {
		this.externalTokenLinked = value;
		return this;
	}

	/**
	 * Fraud results contained in the CardFraudResults object
	 */
	public CardFraudResults getFraudResults() {
		return fraudResults;
	}

	/**
	 * Fraud results contained in the CardFraudResults object
	 */
	public void setFraudResults(CardFraudResults value) {
		this.fraudResults = value;
	}

	/**
	 * Fraud results contained in the CardFraudResults object
	 */
	public CardPaymentMethodSpecificOutput withFraudResults(CardFraudResults value) {
		this.fraudResults = value;
		return this;
	}

	/**
	 * The unique scheme transactionId of the initial transaction that was performed with SCA. In case this is unknown a scheme transactionId of an earlier transaction part of the same sequence can be used as a fall-back. Strongly advised to be submitted for any MerchantInitiated or recurring transaction (a subsequent one).
	 */
	public String getInitialSchemeTransactionId() {
		return initialSchemeTransactionId;
	}

	/**
	 * The unique scheme transactionId of the initial transaction that was performed with SCA. In case this is unknown a scheme transactionId of an earlier transaction part of the same sequence can be used as a fall-back. Strongly advised to be submitted for any MerchantInitiated or recurring transaction (a subsequent one).
	 */
	public void setInitialSchemeTransactionId(String value) {
		this.initialSchemeTransactionId = value;
	}

	/**
	 * The unique scheme transactionId of the initial transaction that was performed with SCA. In case this is unknown a scheme transactionId of an earlier transaction part of the same sequence can be used as a fall-back. Strongly advised to be submitted for any MerchantInitiated or recurring transaction (a subsequent one).
	 */
	public CardPaymentMethodSpecificOutput withInitialSchemeTransactionId(String value) {
		this.initialSchemeTransactionId = value;
		return this;
	}

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
	public CardPaymentMethodSpecificOutput withPaymentOption(String value) {
		this.paymentOption = value;
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
	public CardPaymentMethodSpecificOutput withPaymentProductId(Integer value) {
		this.paymentProductId = value;
		return this;
	}

	/**
	 * This is the unique Scheme Reference Data from the initial transaction that was performed with a Strong Customer Authentication. In case this value is unknown, a Scheme Reference of an earlier transaction that was part of the same sequence can be used as a fall-back. Still, it is strongly advised to submit this value for any Merchant Initiated Transaction or any recurring transaction (hereby defined as "Subsequent").
	 */
	public String getSchemeReferenceData() {
		return schemeReferenceData;
	}

	/**
	 * This is the unique Scheme Reference Data from the initial transaction that was performed with a Strong Customer Authentication. In case this value is unknown, a Scheme Reference of an earlier transaction that was part of the same sequence can be used as a fall-back. Still, it is strongly advised to submit this value for any Merchant Initiated Transaction or any recurring transaction (hereby defined as "Subsequent").
	 */
	public void setSchemeReferenceData(String value) {
		this.schemeReferenceData = value;
	}

	/**
	 * This is the unique Scheme Reference Data from the initial transaction that was performed with a Strong Customer Authentication. In case this value is unknown, a Scheme Reference of an earlier transaction that was part of the same sequence can be used as a fall-back. Still, it is strongly advised to submit this value for any Merchant Initiated Transaction or any recurring transaction (hereby defined as "Subsequent").
	 */
	public CardPaymentMethodSpecificOutput withSchemeReferenceData(String value) {
		this.schemeReferenceData = value;
		return this;
	}

	/**
	 * 3D Secure results object
	 */
	public ThreeDSecureResults getThreeDSecureResults() {
		return threeDSecureResults;
	}

	/**
	 * 3D Secure results object
	 */
	public void setThreeDSecureResults(ThreeDSecureResults value) {
		this.threeDSecureResults = value;
	}

	/**
	 * 3D Secure results object
	 */
	public CardPaymentMethodSpecificOutput withThreeDSecureResults(ThreeDSecureResults value) {
		this.threeDSecureResults = value;
		return this;
	}

	/**
	 * ID of the token. This property is populated when the payment was done with a token or when the payment was tokenized.
	 */
	public String getToken() {
		return token;
	}

	/**
	 * ID of the token. This property is populated when the payment was done with a token or when the payment was tokenized.
	 */
	public void setToken(String value) {
		this.token = value;
	}

	/**
	 * ID of the token. This property is populated when the payment was done with a token or when the payment was tokenized.
	 */
	public CardPaymentMethodSpecificOutput withToken(String value) {
		this.token = value;
		return this;
	}
}
