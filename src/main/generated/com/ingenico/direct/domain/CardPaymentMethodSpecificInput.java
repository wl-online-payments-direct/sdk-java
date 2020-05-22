/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing the specific input details for card payments
 */
public class CardPaymentMethodSpecificInput {

	private String authorizationMode = null;

	private Card card = null;

	private String initialSchemeTransactionId = null;

	private Boolean isRecurring = null;

	private Integer paymentProductId = null;

	private CardRecurrenceDetails recurring = null;

	private String returnUrl = null;

	private Boolean skipAuthentication = null;

	private ThreeDSecure threeDSecure = null;

	private String token = null;

	private Boolean tokenize = null;

	private String transactionChannel = null;

	private String unscheduledCardOnFileRequestor = null;

	private String unscheduledCardOnFileSequenceIndicator = null;

	/**
	 * Determines the type of the authorization that will be used. Allowed values: 
	 *   * FINAL_AUTHORIZATION - The payment creation results in an authorization that is ready for capture. Final authorizations can't be reversed and need to be captured for the full amount within 7 days. 
	 *   * PRE_AUTHORIZATION - The payment creation results in a pre-authorization that is ready for capture. Pre-authortizations can be reversed and can be captured within 30 days. The capture amount can be lower than the authorized amount. 
	 *   * SALE - The payment creation results in an authorization that is already captured at the moment of approval. 
	 * 
	 *   Only used with some acquirers, ignored for acquirers that don't support this. In case the acquirer doesn't allow this to be specified the authorizationMode is 'unspecified', which behaves similar to a final authorization.
	 */
	public String getAuthorizationMode() {
		return authorizationMode;
	}

	/**
	 * Determines the type of the authorization that will be used. Allowed values: 
	 *   * FINAL_AUTHORIZATION - The payment creation results in an authorization that is ready for capture. Final authorizations can't be reversed and need to be captured for the full amount within 7 days. 
	 *   * PRE_AUTHORIZATION - The payment creation results in a pre-authorization that is ready for capture. Pre-authortizations can be reversed and can be captured within 30 days. The capture amount can be lower than the authorized amount. 
	 *   * SALE - The payment creation results in an authorization that is already captured at the moment of approval. 
	 * 
	 *   Only used with some acquirers, ignored for acquirers that don't support this. In case the acquirer doesn't allow this to be specified the authorizationMode is 'unspecified', which behaves similar to a final authorization.
	 */
	public void setAuthorizationMode(String value) {
		this.authorizationMode = value;
	}

	/**
	 * Object containing card details
	 */
	public Card getCard() {
		return card;
	}

	/**
	 * Object containing card details
	 */
	public void setCard(Card value) {
		this.card = value;
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
	 * * true - Only payment products that support recurring payments will be shown. Any transactions created will also be tagged as being a first of a recurring sequence.
	 * * false - Only payment products that support one-off payments will be shown.
	 * The default value for this property is false.
	 */
	public Boolean getIsRecurring() {
		return isRecurring;
	}

	/**
	 * * true - Only payment products that support recurring payments will be shown. Any transactions created will also be tagged as being a first of a recurring sequence.
	 * * false - Only payment products that support one-off payments will be shown.
	 * The default value for this property is false.
	 */
	public void setIsRecurring(Boolean value) {
		this.isRecurring = value;
	}

	/**
	 * Payment product identifier - Please see [payment products](https://support.direct.ingenico.com/documentation/api/reference/index.html#tag/Products) for a full overview of possible values.
	 */
	public Integer getPaymentProductId() {
		return paymentProductId;
	}

	/**
	 * Payment product identifier - Please see [payment products](https://support.direct.ingenico.com/documentation/api/reference/index.html#tag/Products) for a full overview of possible values.
	 */
	public void setPaymentProductId(Integer value) {
		this.paymentProductId = value;
	}

	/**
	 * Object containing data related to recurring
	 */
	public CardRecurrenceDetails getRecurring() {
		return recurring;
	}

	/**
	 * Object containing data related to recurring
	 */
	public void setRecurring(CardRecurrenceDetails value) {
		this.recurring = value;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String value) {
		this.returnUrl = value;
	}

	/**
	 * * true = 3D Secure authentication will be skipped for this transaction. This setting should be used when isRecurring is set to true and recurringPaymentSequenceIndicator is set to recurring.
	 * * false = 3D Secure authentication will not be skipped for this transaction.
	 * 
	 *  Note: This is only possible if your account in our system is setup for 3D Secure authentication and if your configuration in our system allows you to override it per transaction.
	 */
	public Boolean getSkipAuthentication() {
		return skipAuthentication;
	}

	/**
	 * * true = 3D Secure authentication will be skipped for this transaction. This setting should be used when isRecurring is set to true and recurringPaymentSequenceIndicator is set to recurring.
	 * * false = 3D Secure authentication will not be skipped for this transaction.
	 * 
	 *  Note: This is only possible if your account in our system is setup for 3D Secure authentication and if your configuration in our system allows you to override it per transaction.
	 */
	public void setSkipAuthentication(Boolean value) {
		this.skipAuthentication = value;
	}

	/**
	 * Object containing specific data regarding 3-D Secure
	 */
	public ThreeDSecure getThreeDSecure() {
		return threeDSecure;
	}

	/**
	 * Object containing specific data regarding 3-D Secure
	 */
	public void setThreeDSecure(ThreeDSecure value) {
		this.threeDSecure = value;
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
	 * Indicates if this transaction should be tokenized
	 *  * true - Tokenize the transaction. Note that a payment on the Ogone platform that results in a status REDIRECTED cannot be tokenized in this way.
	 *  * false - Do not tokenize the transaction, unless it would be tokenized by other means such as auto-tokenization of recurring payments.
	 */
	public Boolean getTokenize() {
		return tokenize;
	}

	/**
	 * Indicates if this transaction should be tokenized
	 *  * true - Tokenize the transaction. Note that a payment on the Ogone platform that results in a status REDIRECTED cannot be tokenized in this way.
	 *  * false - Do not tokenize the transaction, unless it would be tokenized by other means such as auto-tokenization of recurring payments.
	 */
	public void setTokenize(Boolean value) {
		this.tokenize = value;
	}

	/**
	 * Indicates the channel via which the payment is created. Allowed values:
	 *   * ECOMMERCE - The transaction is a regular E-Commerce transaction.
	 *   * MOTO - The transaction is a Mail Order/Telephone Order.
	 * 
	 *   Defaults to ECOMMERCE.
	 */
	public String getTransactionChannel() {
		return transactionChannel;
	}

	/**
	 * Indicates the channel via which the payment is created. Allowed values:
	 *   * ECOMMERCE - The transaction is a regular E-Commerce transaction.
	 *   * MOTO - The transaction is a Mail Order/Telephone Order.
	 * 
	 *   Defaults to ECOMMERCE.
	 */
	public void setTransactionChannel(String value) {
		this.transactionChannel = value;
	}

	/**
	 * Indicates which party initiated the unscheduled recurring transaction. Allowed values:
	 *   * merchantInitiated - Merchant Initiated Transaction.
	 *   * cardholderInitiated - Cardholder Initiated Transaction.
	 * Note:
	 *   * This property is not allowed if isRecurring is true.
	 *   * When a customer has chosen to use a token on a hosted checkout this property is set to "cardholderInitiated".
	 */
	public String getUnscheduledCardOnFileRequestor() {
		return unscheduledCardOnFileRequestor;
	}

	/**
	 * Indicates which party initiated the unscheduled recurring transaction. Allowed values:
	 *   * merchantInitiated - Merchant Initiated Transaction.
	 *   * cardholderInitiated - Cardholder Initiated Transaction.
	 * Note:
	 *   * This property is not allowed if isRecurring is true.
	 *   * When a customer has chosen to use a token on a hosted checkout this property is set to "cardholderInitiated".
	 */
	public void setUnscheduledCardOnFileRequestor(String value) {
		this.unscheduledCardOnFileRequestor = value;
	}

	/**
	 * * first = This transaction is the first of a series of unscheduled recurring transactions
	 * * subsequent = This transaction is a subsequent transaction in a series of unscheduled recurring transactions
	 * Note: this property is not allowed if isRecurring is true.
	 */
	public String getUnscheduledCardOnFileSequenceIndicator() {
		return unscheduledCardOnFileSequenceIndicator;
	}

	/**
	 * * first = This transaction is the first of a series of unscheduled recurring transactions
	 * * subsequent = This transaction is a subsequent transaction in a series of unscheduled recurring transactions
	 * Note: this property is not allowed if isRecurring is true.
	 */
	public void setUnscheduledCardOnFileSequenceIndicator(String value) {
		this.unscheduledCardOnFileSequenceIndicator = value;
	}
}
