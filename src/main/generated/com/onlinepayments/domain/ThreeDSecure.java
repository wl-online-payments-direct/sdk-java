/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ThreeDSecure {

    private Long authenticationAmount;

    private String challengeCanvasSize;

    private String challengeIndicator;

    private String deviceChannel;

    private String exemptionRequest;

    private ExternalCardholderAuthenticationData externalCardholderAuthenticationData;

    private Integer merchantFraudRate;

    private ThreeDSecureData priorThreeDSecureData;

    private RedirectionData redirectionData;

    private Boolean secureCorporatePayment;

    private Boolean skipAuthentication;

    private Boolean skipSoftDecline;

    /**
     * The amount to be authenticated. This field should be populated if the amount to be authenticated differs from the amount to be authorized (by default they are considered equal). Amount in cents and always having 2 decimals.
     */
    public Long getAuthenticationAmount() {
        return authenticationAmount;
    }

    /**
     * The amount to be authenticated. This field should be populated if the amount to be authenticated differs from the amount to be authorized (by default they are considered equal). Amount in cents and always having 2 decimals.
     */
    public void setAuthenticationAmount(Long value) {
        this.authenticationAmount = value;
    }

    /**
     * The amount to be authenticated. This field should be populated if the amount to be authenticated differs from the amount to be authorized (by default they are considered equal). Amount in cents and always having 2 decimals.
     */
    public ThreeDSecure withAuthenticationAmount(Long value) {
        this.authenticationAmount = value;
        return this;
    }

    /**
     * Dimensions of the challenge window that potentially will be displayed to the customer. The challenge content is formatted to appropriately render in this window to provide the best possible user experience. Preconfigured sizes are width x height in pixels of the window displayed in the customer browser window. Possible values are
     * <ul>
     *   <li>250x400 (default)</li>
     *   <li>390x400</li>
     *   <li>500x600</li>
     *   <li>600x400</li>
     *   <li>full-screen</li>
     * </ul>
     */
    public String getChallengeCanvasSize() {
        return challengeCanvasSize;
    }

    /**
     * Dimensions of the challenge window that potentially will be displayed to the customer. The challenge content is formatted to appropriately render in this window to provide the best possible user experience. Preconfigured sizes are width x height in pixels of the window displayed in the customer browser window. Possible values are
     * <ul>
     *   <li>250x400 (default)</li>
     *   <li>390x400</li>
     *   <li>500x600</li>
     *   <li>600x400</li>
     *   <li>full-screen</li>
     * </ul>
     */
    public void setChallengeCanvasSize(String value) {
        this.challengeCanvasSize = value;
    }

    /**
     * Dimensions of the challenge window that potentially will be displayed to the customer. The challenge content is formatted to appropriately render in this window to provide the best possible user experience. Preconfigured sizes are width x height in pixels of the window displayed in the customer browser window. Possible values are
     * <ul>
     *   <li>250x400 (default)</li>
     *   <li>390x400</li>
     *   <li>500x600</li>
     *   <li>600x400</li>
     *   <li>full-screen</li>
     * </ul>
     */
    public ThreeDSecure withChallengeCanvasSize(String value) {
        this.challengeCanvasSize = value;
        return this;
    }

    /**
     * Allows you to indicate if you want the customer to be challenged for extra security on this transaction. Possible values:
     * <ul>
     *   <li>no-preference - You have no preference whether or not to challenge the customer (default)</li>
     *   <li>no-challenge-requested - you prefer the cardholder not to be challenged</li>
     *   <li>challenge-requested - you prefer the customer to be challenged</li>
     *   <li>challenge-required - you require the customer to be challenged</li>
     *   <li>no-challenge-requested-risk-analysis-performed – letting the issuer know that you have already assessed the transaction with fraud prevention tool</li>
     *   <li>no-challenge-requested-data-share-only – sharing data only with the DS</li>
     *   <li>no-challenge-requested-consumer-authentication-performed – authentication already happened at your side – when login in to your website</li>
     *   <li>no-challenge-requested-use-whitelist-exemption – cardholder has whitelisted you at with the issuer</li>
     *   <li>challenge-requested-whitelist-prompt-requested – cardholder is trying to whitelist you</li>
     *   <li>request-scoring-without-connecting-to-acs – sending information to CB DS for a fraud scoring</li>
     * </ul>
     */
    public String getChallengeIndicator() {
        return challengeIndicator;
    }

    /**
     * Allows you to indicate if you want the customer to be challenged for extra security on this transaction. Possible values:
     * <ul>
     *   <li>no-preference - You have no preference whether or not to challenge the customer (default)</li>
     *   <li>no-challenge-requested - you prefer the cardholder not to be challenged</li>
     *   <li>challenge-requested - you prefer the customer to be challenged</li>
     *   <li>challenge-required - you require the customer to be challenged</li>
     *   <li>no-challenge-requested-risk-analysis-performed – letting the issuer know that you have already assessed the transaction with fraud prevention tool</li>
     *   <li>no-challenge-requested-data-share-only – sharing data only with the DS</li>
     *   <li>no-challenge-requested-consumer-authentication-performed – authentication already happened at your side – when login in to your website</li>
     *   <li>no-challenge-requested-use-whitelist-exemption – cardholder has whitelisted you at with the issuer</li>
     *   <li>challenge-requested-whitelist-prompt-requested – cardholder is trying to whitelist you</li>
     *   <li>request-scoring-without-connecting-to-acs – sending information to CB DS for a fraud scoring</li>
     * </ul>
     */
    public void setChallengeIndicator(String value) {
        this.challengeIndicator = value;
    }

    /**
     * Allows you to indicate if you want the customer to be challenged for extra security on this transaction. Possible values:
     * <ul>
     *   <li>no-preference - You have no preference whether or not to challenge the customer (default)</li>
     *   <li>no-challenge-requested - you prefer the cardholder not to be challenged</li>
     *   <li>challenge-requested - you prefer the customer to be challenged</li>
     *   <li>challenge-required - you require the customer to be challenged</li>
     *   <li>no-challenge-requested-risk-analysis-performed – letting the issuer know that you have already assessed the transaction with fraud prevention tool</li>
     *   <li>no-challenge-requested-data-share-only – sharing data only with the DS</li>
     *   <li>no-challenge-requested-consumer-authentication-performed – authentication already happened at your side – when login in to your website</li>
     *   <li>no-challenge-requested-use-whitelist-exemption – cardholder has whitelisted you at with the issuer</li>
     *   <li>challenge-requested-whitelist-prompt-requested – cardholder is trying to whitelist you</li>
     *   <li>request-scoring-without-connecting-to-acs – sending information to CB DS for a fraud scoring</li>
     * </ul>
     */
    public ThreeDSecure withChallengeIndicator(String value) {
        this.challengeIndicator = value;
        return this;
    }

    /**
     * Determines whether the call is coming from an application or from a browser * AppBased - Call is coming from an application. * Browser - Call is coming from a browser
     */
    public String getDeviceChannel() {
        return deviceChannel;
    }

    /**
     * Determines whether the call is coming from an application or from a browser * AppBased - Call is coming from an application. * Browser - Call is coming from a browser
     */
    public void setDeviceChannel(String value) {
        this.deviceChannel = value;
    }

    /**
     * Determines whether the call is coming from an application or from a browser * AppBased - Call is coming from an application. * Browser - Call is coming from a browser
     */
    public ThreeDSecure withDeviceChannel(String value) {
        this.deviceChannel = value;
        return this;
    }

    /**
     * In PSD2, the ExemptionRequest field is used by merchants requesting an exemption when not using authentication on a transaction, in order to keep the conversion up.
     * <ul>
     *   <li>none = No exemption requested</li>
     *   <li>transaction-risk-analysis = Fraud analysis has been done already by your own fraud module and transaction scored as low risk</li>
     *   <li>low-value = Bellow 30 euros</li>
     *   <li>whitelist = The cardholder has whitelisted you with their issuer</li>
     * </ul>
     */
    public String getExemptionRequest() {
        return exemptionRequest;
    }

    /**
     * In PSD2, the ExemptionRequest field is used by merchants requesting an exemption when not using authentication on a transaction, in order to keep the conversion up.
     * <ul>
     *   <li>none = No exemption requested</li>
     *   <li>transaction-risk-analysis = Fraud analysis has been done already by your own fraud module and transaction scored as low risk</li>
     *   <li>low-value = Bellow 30 euros</li>
     *   <li>whitelist = The cardholder has whitelisted you with their issuer</li>
     * </ul>
     */
    public void setExemptionRequest(String value) {
        this.exemptionRequest = value;
    }

    /**
     * In PSD2, the ExemptionRequest field is used by merchants requesting an exemption when not using authentication on a transaction, in order to keep the conversion up.
     * <ul>
     *   <li>none = No exemption requested</li>
     *   <li>transaction-risk-analysis = Fraud analysis has been done already by your own fraud module and transaction scored as low risk</li>
     *   <li>low-value = Bellow 30 euros</li>
     *   <li>whitelist = The cardholder has whitelisted you with their issuer</li>
     * </ul>
     */
    public ThreeDSecure withExemptionRequest(String value) {
        this.exemptionRequest = value;
        return this;
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
     * Object containing 3D secure details.
     */
    public ThreeDSecure withExternalCardholderAuthenticationData(ExternalCardholderAuthenticationData value) {
        this.externalCardholderAuthenticationData = value;
        return this;
    }

    /**
     * Merchant fraud rate in the EEA (all EEA card fraud divided by all EEA card volumes) calculated as per PSD2 RTS. Mastercard will not calculate or validate the merchant fraud score
     * Values accepted :
     * <ul>
     *   <li>1 - represents fraud rate less than or equal to 1 basis point [bp], which is 0.01%</li>
     *   <li>2 - represents fraud rate between 1 bp + - and 6 bps</li>
     *   <li>3 - represents fraud rate between 6 bps + - and 13 bps</li>
     *   <li>4 - represents fraud rate between 13 bps + - and 25 bps</li>
     *   <li>5 - represents fraud rate greater than 25 bps</li>
     * </ul>
     */
    public Integer getMerchantFraudRate() {
        return merchantFraudRate;
    }

    /**
     * Merchant fraud rate in the EEA (all EEA card fraud divided by all EEA card volumes) calculated as per PSD2 RTS. Mastercard will not calculate or validate the merchant fraud score
     * Values accepted :
     * <ul>
     *   <li>1 - represents fraud rate less than or equal to 1 basis point [bp], which is 0.01%</li>
     *   <li>2 - represents fraud rate between 1 bp + - and 6 bps</li>
     *   <li>3 - represents fraud rate between 6 bps + - and 13 bps</li>
     *   <li>4 - represents fraud rate between 13 bps + - and 25 bps</li>
     *   <li>5 - represents fraud rate greater than 25 bps</li>
     * </ul>
     */
    public void setMerchantFraudRate(Integer value) {
        this.merchantFraudRate = value;
    }

    /**
     * Merchant fraud rate in the EEA (all EEA card fraud divided by all EEA card volumes) calculated as per PSD2 RTS. Mastercard will not calculate or validate the merchant fraud score
     * Values accepted :
     * <ul>
     *   <li>1 - represents fraud rate less than or equal to 1 basis point [bp], which is 0.01%</li>
     *   <li>2 - represents fraud rate between 1 bp + - and 6 bps</li>
     *   <li>3 - represents fraud rate between 6 bps + - and 13 bps</li>
     *   <li>4 - represents fraud rate between 13 bps + - and 25 bps</li>
     *   <li>5 - represents fraud rate greater than 25 bps</li>
     * </ul>
     */
    public ThreeDSecure withMerchantFraudRate(Integer value) {
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
    public ThreeDSecure withPriorThreeDSecureData(ThreeDSecureData value) {
        this.priorThreeDSecureData = value;
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
    public ThreeDSecure withRedirectionData(RedirectionData value) {
        this.redirectionData = value;
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
    public ThreeDSecure withSecureCorporatePayment(Boolean value) {
        this.secureCorporatePayment = value;
        return this;
    }

    /**
     * <ul>
     *   <li>true = 3D Secure authentication will be skipped for this transaction. This setting should be used when isRecurring is set to true and recurringPaymentSequenceIndicator is set to &quot;recurring&quot;</li>
     *   <li>false = 3D Secure authentication will not be skipped for this transaction</li>
     * </ul>
     * <p>
     * Note: This is only possible if your account in our system is setup for 3D Secure authentication and if your configuration in our system allows you to override it per transaction
     */
    public Boolean getSkipAuthentication() {
        return skipAuthentication;
    }

    /**
     * <ul>
     *   <li>true = 3D Secure authentication will be skipped for this transaction. This setting should be used when isRecurring is set to true and recurringPaymentSequenceIndicator is set to &quot;recurring&quot;</li>
     *   <li>false = 3D Secure authentication will not be skipped for this transaction</li>
     * </ul>
     * <p>
     * Note: This is only possible if your account in our system is setup for 3D Secure authentication and if your configuration in our system allows you to override it per transaction
     */
    public void setSkipAuthentication(Boolean value) {
        this.skipAuthentication = value;
    }

    /**
     * <ul>
     *   <li>true = 3D Secure authentication will be skipped for this transaction. This setting should be used when isRecurring is set to true and recurringPaymentSequenceIndicator is set to &quot;recurring&quot;</li>
     *   <li>false = 3D Secure authentication will not be skipped for this transaction</li>
     * </ul>
     * <p>
     * Note: This is only possible if your account in our system is setup for 3D Secure authentication and if your configuration in our system allows you to override it per transaction
     */
    public ThreeDSecure withSkipAuthentication(Boolean value) {
        this.skipAuthentication = value;
        return this;
    }

    /**
     * <ul>
     *   <li>true = Soft Decline retry mechanism will be skipped for this transaction. The transaction will result in &quot;Authorization Declined&quot; status. This setting should be used when skipAuthentication is set to true and the merchant does not want to use Soft Decline retry mechanism.</li>
     *   <li>false = Soft Decline retry mechanism will not be skipped for this transaction.</li>
     * </ul>
     * <p>
     * Note: skipSoftDecline defaults to false if empty. This is only possible if your account in our system is setup for 3D Secure authentication and if your configuration in our system allows you to override it per transaction.
     */
    public Boolean getSkipSoftDecline() {
        return skipSoftDecline;
    }

    /**
     * <ul>
     *   <li>true = Soft Decline retry mechanism will be skipped for this transaction. The transaction will result in &quot;Authorization Declined&quot; status. This setting should be used when skipAuthentication is set to true and the merchant does not want to use Soft Decline retry mechanism.</li>
     *   <li>false = Soft Decline retry mechanism will not be skipped for this transaction.</li>
     * </ul>
     * <p>
     * Note: skipSoftDecline defaults to false if empty. This is only possible if your account in our system is setup for 3D Secure authentication and if your configuration in our system allows you to override it per transaction.
     */
    public void setSkipSoftDecline(Boolean value) {
        this.skipSoftDecline = value;
    }

    /**
     * <ul>
     *   <li>true = Soft Decline retry mechanism will be skipped for this transaction. The transaction will result in &quot;Authorization Declined&quot; status. This setting should be used when skipAuthentication is set to true and the merchant does not want to use Soft Decline retry mechanism.</li>
     *   <li>false = Soft Decline retry mechanism will not be skipped for this transaction.</li>
     * </ul>
     * <p>
     * Note: skipSoftDecline defaults to false if empty. This is only possible if your account in our system is setup for 3D Secure authentication and if your configuration in our system allows you to override it per transaction.
     */
    public ThreeDSecure withSkipSoftDecline(Boolean value) {
        this.skipSoftDecline = value;
        return this;
    }
}
