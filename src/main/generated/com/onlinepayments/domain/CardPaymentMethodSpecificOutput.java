/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing the card payment method details
 */
public class CardPaymentMethodSpecificOutput {

	private AcquirerInformation acquirerInformation = null;

	private Long authenticatedAmount = null;

	private String authorisationCode = null;

	private CardEssentials card = null;

	private CurrencyConversion currencyConversion = null;

	private ExternalTokenLinked externalTokenLinked = null;

	private CardFraudResults fraudResults = null;

	private String initialSchemeTransactionId = null;

	private NetworkTokenEssentials networkTokenData = null;

	private String paymentAccountReference = null;

	private String paymentOption = null;

	private PaymentProduct3208SpecificOutput paymentProduct3208SpecificOutput = null;

	private PaymentProduct3209SpecificOutput paymentProduct3209SpecificOutput = null;

	private Integer paymentProductId = null;

	private String schemeReferenceData = null;

	private ThreeDSecureResults threeDSecureResults = null;

	private String token = null;

	/**
	 * Information about the acquirer used to process the transaction
	 */
	public AcquirerInformation getAcquirerInformation() {
		return acquirerInformation;
	}

	/**
	 * Information about the acquirer used to process the transaction
	 */
	public void setAcquirerInformation(AcquirerInformation value) {
		this.acquirerInformation = value;
	}

	/**
	 * Information about the acquirer used to process the transaction
	 */
	public CardPaymentMethodSpecificOutput withAcquirerInformation(AcquirerInformation value) {
		this.acquirerInformation = value;
		return this;
	}

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

	public CurrencyConversion getCurrencyConversion() {
		return currencyConversion;
	}

	public void setCurrencyConversion(CurrencyConversion value) {
		this.currencyConversion = value;
	}

	public CardPaymentMethodSpecificOutput withCurrencyConversion(CurrencyConversion value) {
		this.currencyConversion = value;
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
	 * Object containing network token details
	 */
	public NetworkTokenEssentials getNetworkTokenData() {
		return networkTokenData;
	}

	/**
	 * Object containing network token details
	 */
	public void setNetworkTokenData(NetworkTokenEssentials value) {
		this.networkTokenData = value;
	}

	/**
	 * Object containing network token details
	 */
	public CardPaymentMethodSpecificOutput withNetworkTokenData(NetworkTokenEssentials value) {
		this.networkTokenData = value;
		return this;
	}

	/**
	 * The Payment Account Reference is a unique alphanumeric identifier that links a PAN with all subsequent PANs for the same payment account (e.g., following card replacement) and all EMV payment tokens associated with that account. On its own Payment Account Reference cannot be used to start financial transactions, but it does allow for complying with regulatory requirements, performing risk analysis &amp; supporting loyalty programs. Please note that the Payment Account Reference is a value returned after an authorization &amp; only if provided by the acquirer and/or the issuer.
	 */
	public String getPaymentAccountReference() {
		return paymentAccountReference;
	}

	/**
	 * The Payment Account Reference is a unique alphanumeric identifier that links a PAN with all subsequent PANs for the same payment account (e.g., following card replacement) and all EMV payment tokens associated with that account. On its own Payment Account Reference cannot be used to start financial transactions, but it does allow for complying with regulatory requirements, performing risk analysis &amp; supporting loyalty programs. Please note that the Payment Account Reference is a value returned after an authorization &amp; only if provided by the acquirer and/or the issuer.
	 */
	public void setPaymentAccountReference(String value) {
		this.paymentAccountReference = value;
	}

	/**
	 * The Payment Account Reference is a unique alphanumeric identifier that links a PAN with all subsequent PANs for the same payment account (e.g., following card replacement) and all EMV payment tokens associated with that account. On its own Payment Account Reference cannot be used to start financial transactions, but it does allow for complying with regulatory requirements, performing risk analysis &amp; supporting loyalty programs. Please note that the Payment Account Reference is a value returned after an authorization &amp; only if provided by the acquirer and/or the issuer.
	 */
	public CardPaymentMethodSpecificOutput withPaymentAccountReference(String value) {
		this.paymentAccountReference = value;
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
	 * OneyDuplo Leroy Merlin specific details
	 */
	public PaymentProduct3208SpecificOutput getPaymentProduct3208SpecificOutput() {
		return paymentProduct3208SpecificOutput;
	}

	/**
	 * OneyDuplo Leroy Merlin specific details
	 */
	public void setPaymentProduct3208SpecificOutput(PaymentProduct3208SpecificOutput value) {
		this.paymentProduct3208SpecificOutput = value;
	}

	/**
	 * OneyDuplo Leroy Merlin specific details
	 */
	public CardPaymentMethodSpecificOutput withPaymentProduct3208SpecificOutput(PaymentProduct3208SpecificOutput value) {
		this.paymentProduct3208SpecificOutput = value;
		return this;
	}

	/**
	 * OneyDuplo Alcampo specific details
	 */
	public PaymentProduct3209SpecificOutput getPaymentProduct3209SpecificOutput() {
		return paymentProduct3209SpecificOutput;
	}

	/**
	 * OneyDuplo Alcampo specific details
	 */
	public void setPaymentProduct3209SpecificOutput(PaymentProduct3209SpecificOutput value) {
		this.paymentProduct3209SpecificOutput = value;
	}

	/**
	 * OneyDuplo Alcampo specific details
	 */
	public CardPaymentMethodSpecificOutput withPaymentProduct3209SpecificOutput(PaymentProduct3209SpecificOutput value) {
		this.paymentProduct3209SpecificOutput = value;
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
