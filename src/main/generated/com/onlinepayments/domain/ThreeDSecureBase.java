/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing specific data regarding 3-D Secure
 */
public class ThreeDSecureBase {

	private String challengeCanvasSize = null;

	private String challengeIndicator = null;

	private String exemptionRequest = null;

	private Integer merchantFraudRate = null;

	private ThreeDSecureData priorThreeDSecureData = null;

	private Boolean secureCorporatePayment = null;

	private Boolean skipAuthentication = null;

	private Boolean skipSoftDecline = null;

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
	 * Dimensions of the challenge window that potentially will be displayed to the customer. The challenge content is formatted to appropriately render in this window to provide the best possible user experience. Preconfigured sizes are width x height in pixels of the window displayed in the customer browser window. Possible values are
	 *    * 250x400 (default)
	 *    * 390x400
	 *    * 500x600
	 *    * 600x400
	 *    * full-screen
	 */
	public ThreeDSecureBase withChallengeCanvasSize(String value) {
		this.challengeCanvasSize = value;
		return this;
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
	public ThreeDSecureBase withChallengeIndicator(String value) {
		this.challengeIndicator = value;
		return this;
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
	 * In PSD2, the ExemptionRequest field is used by merchants requesting an exemption when not using authentication on a transaction, in order to keep the conversion up.
	 * * none = No exemption requested
	 * * transaction-risk-analysis = Fraud analysis has been done already by your own fraud module and transaction scored as low risk
	 * * low-value = Bellow 30 euros
	 * * whitelist = The cardholder has whitelisted you with their issuer
	 */
	public ThreeDSecureBase withExemptionRequest(String value) {
		this.exemptionRequest = value;
		return this;
	}

	/**
	 * Merchant fraud rate in the EEA (all EEA card fraud divided by all EEA card volumes) calculated as per PSD2 RTS. Mastercard will not calculate or validate the merchant fraud score
	 * Values accepted :
	 * * 1 - represents fraud rate less than or equal to 1 basis point [bp], which is 0.01%
	 * * 2 - represents fraud rate between 1 bp + - and 6 bps
	 * * 3 - represents fraud rate between 6 bps + - and 13 bps
	 * * 4 - represents fraud rate between 13 bps + - and 25 bps
	 * * 5 - represents fraud rate greater than 25 bps
	 */
	public Integer getMerchantFraudRate() {
		return merchantFraudRate;
	}

	/**
	 * Merchant fraud rate in the EEA (all EEA card fraud divided by all EEA card volumes) calculated as per PSD2 RTS. Mastercard will not calculate or validate the merchant fraud score
	 * Values accepted :
	 * * 1 - represents fraud rate less than or equal to 1 basis point [bp], which is 0.01%
	 * * 2 - represents fraud rate between 1 bp + - and 6 bps
	 * * 3 - represents fraud rate between 6 bps + - and 13 bps
	 * * 4 - represents fraud rate between 13 bps + - and 25 bps
	 * * 5 - represents fraud rate greater than 25 bps
	 */
	public void setMerchantFraudRate(Integer value) {
		this.merchantFraudRate = value;
	}

	/**
	 * Merchant fraud rate in the EEA (all EEA card fraud divided by all EEA card volumes) calculated as per PSD2 RTS. Mastercard will not calculate or validate the merchant fraud score
	 * Values accepted :
	 * * 1 - represents fraud rate less than or equal to 1 basis point [bp], which is 0.01%
	 * * 2 - represents fraud rate between 1 bp + - and 6 bps
	 * * 3 - represents fraud rate between 6 bps + - and 13 bps
	 * * 4 - represents fraud rate between 13 bps + - and 25 bps
	 * * 5 - represents fraud rate greater than 25 bps
	 */
	public ThreeDSecureBase withMerchantFraudRate(Integer value) {
		this.merchantFraudRate = value;
		return this;
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
	 * Object containing data regarding the customer authentication that occurred prior to the current transaction
	 */
	public ThreeDSecureBase withPriorThreeDSecureData(ThreeDSecureData value) {
		this.priorThreeDSecureData = value;
		return this;
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
	 * Indicates dedicated payment processes and procedures were used, potential secure corporate payment exemption applies Logically this field should only be set to yes if the 
	 * acquirer exemption field is blank. A merchant cannot claim both acquirer exemption and  secure payment. However, the DS will not validate 
	 * the conditions in the extension. DS will pass data as presented.
	 */
	public ThreeDSecureBase withSecureCorporatePayment(Boolean value) {
		this.secureCorporatePayment = value;
		return this;
	}

	/**
	 * * true = 3D Secure authentication will be skipped for this transaction. This setting should be used when isRecurring is set to true and recurringPaymentSequenceIndicator is set to "recurring"
	 * * false = 3D Secure authentication will not be skipped for this transaction
	 * 
	 * Note: This is only possible if your account in our system is setup for 3D Secure authentication and if your configuration in our system allows you to override it per transaction
	 */
	public Boolean getSkipAuthentication() {
		return skipAuthentication;
	}

	/**
	 * * true = 3D Secure authentication will be skipped for this transaction. This setting should be used when isRecurring is set to true and recurringPaymentSequenceIndicator is set to "recurring"
	 * * false = 3D Secure authentication will not be skipped for this transaction
	 * 
	 * Note: This is only possible if your account in our system is setup for 3D Secure authentication and if your configuration in our system allows you to override it per transaction
	 */
	public void setSkipAuthentication(Boolean value) {
		this.skipAuthentication = value;
	}

	/**
	 * * true = 3D Secure authentication will be skipped for this transaction. This setting should be used when isRecurring is set to true and recurringPaymentSequenceIndicator is set to "recurring"
	 * * false = 3D Secure authentication will not be skipped for this transaction
	 * 
	 * Note: This is only possible if your account in our system is setup for 3D Secure authentication and if your configuration in our system allows you to override it per transaction
	 */
	public ThreeDSecureBase withSkipAuthentication(Boolean value) {
		this.skipAuthentication = value;
		return this;
	}

	/**
	 * * true = Soft Decline retry mechanism will be skipped for this transaction. The transaction will result in "Authorization Declined" status. This setting should be used when skipAuthentication is set to true and the merchant does not want to use Soft Decline retry mechanism.
	 * * false = Soft Decline retry mechanism will not be skipped for this transaction.
	 * 
	 * Note: skipSoftDecline defaults to false if empty. This is only possible if your account in our system is setup for 3D Secure authentication and if your configuration in our system allows you to override it per transaction.
	 */
	public Boolean getSkipSoftDecline() {
		return skipSoftDecline;
	}

	/**
	 * * true = Soft Decline retry mechanism will be skipped for this transaction. The transaction will result in "Authorization Declined" status. This setting should be used when skipAuthentication is set to true and the merchant does not want to use Soft Decline retry mechanism.
	 * * false = Soft Decline retry mechanism will not be skipped for this transaction.
	 * 
	 * Note: skipSoftDecline defaults to false if empty. This is only possible if your account in our system is setup for 3D Secure authentication and if your configuration in our system allows you to override it per transaction.
	 */
	public void setSkipSoftDecline(Boolean value) {
		this.skipSoftDecline = value;
	}

	/**
	 * * true = Soft Decline retry mechanism will be skipped for this transaction. The transaction will result in "Authorization Declined" status. This setting should be used when skipAuthentication is set to true and the merchant does not want to use Soft Decline retry mechanism.
	 * * false = Soft Decline retry mechanism will not be skipped for this transaction.
	 * 
	 * Note: skipSoftDecline defaults to false if empty. This is only possible if your account in our system is setup for 3D Secure authentication and if your configuration in our system allows you to override it per transaction.
	 */
	public ThreeDSecureBase withSkipSoftDecline(Boolean value) {
		this.skipSoftDecline = value;
		return this;
	}
}
