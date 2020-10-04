/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

/**
 * Object containing specific data regarding 3-D Secure
 */
public class ThreeDSecure {

	private String challengeCanvasSize = null;

	private String challengeIndicator = null;

	private Boolean decoupledIndicator = null;

	private String decoupledMaxTime = null;

	private String exemptionRequest = null;

	private ExternalCardholderAuthenticationData externalCardholderAuthenticationData = null;

	private Integer merchantFraudRate = null;

	private String paymentTokenSource = null;

	private ThreeDSecureData priorThreeDSecureData = null;

	private RedirectionData redirectionData = null;

	private Boolean secureCorporatePayment = null;

	private Boolean skipAuthentication = null;

	private String threeRIIndicator = null;

	private ThreeDSWhitelist whitelist = null;

	/**
	 * Dimensions of the challenge window that potentially will be displayed to the customer. The challenge content is formatted to appropriately render in this window to provide the best possible user experience. Preconfigured sizes are width x height in pixels of the window displayed in the customer browser window. Possible values are
	 *    * 250x400 (default)
	 *    * 390x400
	 *    * 500x600
	 *    * 600x400
	 *    * full-screen
	 */
	public String getChallengeCanvasSize() {
		return challengeCanvasSize;
	}

	/**
	 * Dimensions of the challenge window that potentially will be displayed to the customer. The challenge content is formatted to appropriately render in this window to provide the best possible user experience. Preconfigured sizes are width x height in pixels of the window displayed in the customer browser window. Possible values are
	 *    * 250x400 (default)
	 *    * 390x400
	 *    * 500x600
	 *    * 600x400
	 *    * full-screen
	 */
	public void setChallengeCanvasSize(String value) {
		this.challengeCanvasSize = value;
	}

	/**
	 * Allows you to indicate if you want the customer to be challenged for extra security on this transaction. Possible values:
	 *  * no-preference - You have no preference whether or not to challenge the customer (default)
	 *  * no-challenge-requested - you prefer the cardholder not to be challenged
	 *  * challenge-requested - you prefer the customer to be challenged
	 *  * challenge-required - you require the customer to be challenged
	 *  * no-challenge-requested-risk-analysis-performed – letting the issuer know that you have already assessed the transaction with fraud prevention tool 
	 *  * no-challenge-requested-data-share-only – sharing data only with the DS
	 *  * no-challenge-requested-consumer-authentication-performed – authentication already happened at your side – when login in to your website
	 *  * no-challenge-requested-use-whitelist-exemption – cardholder has whitelisted you at with the issuer
	 *  * challenge-requested-whitelist-prompt-requested – cardholder is trying to whitelist you
	 *  * request-scoring-without-connecting-to-acs – sending information to CB DS for a fraud scoring
	 */
	public String getChallengeIndicator() {
		return challengeIndicator;
	}

	/**
	 * Allows you to indicate if you want the customer to be challenged for extra security on this transaction. Possible values:
	 *  * no-preference - You have no preference whether or not to challenge the customer (default)
	 *  * no-challenge-requested - you prefer the cardholder not to be challenged
	 *  * challenge-requested - you prefer the customer to be challenged
	 *  * challenge-required - you require the customer to be challenged
	 *  * no-challenge-requested-risk-analysis-performed – letting the issuer know that you have already assessed the transaction with fraud prevention tool 
	 *  * no-challenge-requested-data-share-only – sharing data only with the DS
	 *  * no-challenge-requested-consumer-authentication-performed – authentication already happened at your side – when login in to your website
	 *  * no-challenge-requested-use-whitelist-exemption – cardholder has whitelisted you at with the issuer
	 *  * challenge-requested-whitelist-prompt-requested – cardholder is trying to whitelist you
	 *  * request-scoring-without-connecting-to-acs – sending information to CB DS for a fraud scoring
	 */
	public void setChallengeIndicator(String value) {
		this.challengeIndicator = value;
	}

	/**
	 * 3DS Requestor Decoupled Request Indicator. Indicates whether the 3DS Requestor requests the ACS to utilise Decoupled Authentication and agrees to utilise Decoupled Authentication if the ACS confirms its use.
	 * Possible values:
	 * * true
	 * * false
	 */
	public Boolean getDecoupledIndicator() {
		return decoupledIndicator;
	}

	/**
	 * 3DS Requestor Decoupled Request Indicator. Indicates whether the 3DS Requestor requests the ACS to utilise Decoupled Authentication and agrees to utilise Decoupled Authentication if the ACS confirms its use.
	 * Possible values:
	 * * true
	 * * false
	 */
	public void setDecoupledIndicator(Boolean value) {
		this.decoupledIndicator = value;
	}

	/**
	 * 3DS Requestor Decoupled Max Time. Indicates the maximum amount of time that the 3DS Requestor will wait for an ACS to provide the results of a Decoupled Authentication transaction (in minutes).
	 */
	public String getDecoupledMaxTime() {
		return decoupledMaxTime;
	}

	/**
	 * 3DS Requestor Decoupled Max Time. Indicates the maximum amount of time that the 3DS Requestor will wait for an ACS to provide the results of a Decoupled Authentication transaction (in minutes).
	 */
	public void setDecoupledMaxTime(String value) {
		this.decoupledMaxTime = value;
	}

	/**
	 * In PSD2, the ExemptionRequest field is used by merchants requesting an exemption when not using authentication on a transaction, in order to keep the conversion up.
	 * * none = No exemption requested
	 * * transaction-risk-analysis = Fraud analysis has been done already by your own fraud module and transaction scored as low risk
	 * * low-value = Bellow 30 euros
	 * * whitelist = The cardholder has whitelisted you with their issuer
	 */
	public String getExemptionRequest() {
		return exemptionRequest;
	}

	/**
	 * In PSD2, the ExemptionRequest field is used by merchants requesting an exemption when not using authentication on a transaction, in order to keep the conversion up.
	 * * none = No exemption requested
	 * * transaction-risk-analysis = Fraud analysis has been done already by your own fraud module and transaction scored as low risk
	 * * low-value = Bellow 30 euros
	 * * whitelist = The cardholder has whitelisted you with their issuer
	 */
	public void setExemptionRequest(String value) {
		this.exemptionRequest = value;
	}

	/**
	 * Object containing 3D secure details.
	 */
	public ExternalCardholderAuthenticationData getExternalCardholderAuthenticationData() {
		return externalCardholderAuthenticationData;
	}

	/**
	 * Object containing 3D secure details.
	 */
	public void setExternalCardholderAuthenticationData(ExternalCardholderAuthenticationData value) {
		this.externalCardholderAuthenticationData = value;
	}

	/**
	 * Merchant fraud rate in the EEA (all EEA card fraud divided by all EEA card volumes) calculated as per PSD2 RTS Mastercard will not calculate or validate the merchant fraud score
	 */
	public Integer getMerchantFraudRate() {
		return merchantFraudRate;
	}

	/**
	 * Merchant fraud rate in the EEA (all EEA card fraud divided by all EEA card volumes) calculated as per PSD2 RTS Mastercard will not calculate or validate the merchant fraud score
	 */
	public void setMerchantFraudRate(Integer value) {
		this.merchantFraudRate = value;
	}

	/**
	 * EMV Payment Token Source. This data element will be populated by the system residing in the 3-D Secure domain where the tokenisation occurs.
	 */
	public String getPaymentTokenSource() {
		return paymentTokenSource;
	}

	/**
	 * EMV Payment Token Source. This data element will be populated by the system residing in the 3-D Secure domain where the tokenisation occurs.
	 */
	public void setPaymentTokenSource(String value) {
		this.paymentTokenSource = value;
	}

	/**
	 * Object containing data regarding the customer authentication that occurred prior to the current transaction
	 */
	public ThreeDSecureData getPriorThreeDSecureData() {
		return priorThreeDSecureData;
	}

	/**
	 * Object containing data regarding the customer authentication that occurred prior to the current transaction
	 */
	public void setPriorThreeDSecureData(ThreeDSecureData value) {
		this.priorThreeDSecureData = value;
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
	 * Indicates dedicated payment processes and procedures were used, potential secure corporate payment exemption applies Logically this field should only be set to yes if the 
	 * acquirer exemption field is blank. A merchant cannot claim both acquirer exemption and  secure payment. However, the DS will not validate 
	 * the conditions in the extension. DS will pass data as presented.
	 */
	public Boolean getSecureCorporatePayment() {
		return secureCorporatePayment;
	}

	/**
	 * Indicates dedicated payment processes and procedures were used, potential secure corporate payment exemption applies Logically this field should only be set to yes if the 
	 * acquirer exemption field is blank. A merchant cannot claim both acquirer exemption and  secure payment. However, the DS will not validate 
	 * the conditions in the extension. DS will pass data as presented.
	 */
	public void setSecureCorporatePayment(Boolean value) {
		this.secureCorporatePayment = value;
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
	 * Indicates the type of 3RI request. This data element provides additional information to the ACS to determine the best approach for handing a 3RI request.
	 */
	public String getThreeRIIndicator() {
		return threeRIIndicator;
	}

	/**
	 * Indicates the type of 3RI request. This data element provides additional information to the ACS to determine the best approach for handing a 3RI request.
	 */
	public void setThreeRIIndicator(String value) {
		this.threeRIIndicator = value;
	}

	public ThreeDSWhitelist getWhitelist() {
		return whitelist;
	}

	public void setWhitelist(ThreeDSWhitelist value) {
		this.whitelist = value;
	}
}
