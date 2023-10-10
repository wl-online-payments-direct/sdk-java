/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing the specific input details for mobile payments
 */
public class MobilePaymentMethodSpecificInput {

	private String authorizationMode = null;

	private DecryptedPaymentData decryptedPaymentData = null;

	private String encryptedPaymentData = null;

	private String ephemeralKey = null;

	private MobilePaymentProduct320SpecificInput paymentProduct320SpecificInput = null;

	private Integer paymentProductId = null;

	private String publicKeyHash = null;

	private Boolean requiresApproval = null;

	/**
	 * Determines the type of the authorization that will be used. Allowed values: 
	 *   * FINAL_AUTHORIZATION - The payment creation results in an authorization that is ready for capture. Final authorizations can't be reversed and need to be captured for the full amount within 7 days. 
	 *   * PRE_AUTHORIZATION - The payment creation results in a pre-authorization that is ready for capture. Pre-authortizations can be reversed and can be captured within 30 days. The capture amount can be lower than the authorized amount. 
	 *   * SALE - The payment creation results in an authorization that is already captured at the moment of approval. 
	 * 
	 *   Only used with some acquirers, ignored for acquirers that do not support this. In case the acquirer does not allow this to be specified the authorizationMode is 'unspecified', which behaves similar to a final authorization.
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
	 *   Only used with some acquirers, ignored for acquirers that do not support this. In case the acquirer does not allow this to be specified the authorizationMode is 'unspecified', which behaves similar to a final authorization.
	 */
	public void setAuthorizationMode(String value) {
		this.authorizationMode = value;
	}

	/**
	 * Determines the type of the authorization that will be used. Allowed values: 
	 *   * FINAL_AUTHORIZATION - The payment creation results in an authorization that is ready for capture. Final authorizations can't be reversed and need to be captured for the full amount within 7 days. 
	 *   * PRE_AUTHORIZATION - The payment creation results in a pre-authorization that is ready for capture. Pre-authortizations can be reversed and can be captured within 30 days. The capture amount can be lower than the authorized amount. 
	 *   * SALE - The payment creation results in an authorization that is already captured at the moment of approval. 
	 * 
	 *   Only used with some acquirers, ignored for acquirers that do not support this. In case the acquirer does not allow this to be specified the authorizationMode is 'unspecified', which behaves similar to a final authorization.
	 */
	public MobilePaymentMethodSpecificInput withAuthorizationMode(String value) {
		this.authorizationMode = value;
		return this;
	}

	/**
	 * The payment data if you do the decryption of the encrypted payment data yourself.
	 */
	public DecryptedPaymentData getDecryptedPaymentData() {
		return decryptedPaymentData;
	}

	/**
	 * The payment data if you do the decryption of the encrypted payment data yourself.
	 */
	public void setDecryptedPaymentData(DecryptedPaymentData value) {
		this.decryptedPaymentData = value;
	}

	/**
	 * The payment data if you do the decryption of the encrypted payment data yourself.
	 */
	public MobilePaymentMethodSpecificInput withDecryptedPaymentData(DecryptedPaymentData value) {
		this.decryptedPaymentData = value;
		return this;
	}

	/**
	 * The payment data if we will do the decryption of the encrypted payment data. Typically you'd use encryptedCustomerInput in the root of the create payment request to provide the encrypted payment data instead.
	 * * For Apple Pay, the encrypted payment data can be found in property data of the PKPayment.token.paymentData property.
	 */
	public String getEncryptedPaymentData() {
		return encryptedPaymentData;
	}

	/**
	 * The payment data if we will do the decryption of the encrypted payment data. Typically you'd use encryptedCustomerInput in the root of the create payment request to provide the encrypted payment data instead.
	 * * For Apple Pay, the encrypted payment data can be found in property data of the PKPayment.token.paymentData property.
	 */
	public void setEncryptedPaymentData(String value) {
		this.encryptedPaymentData = value;
	}

	/**
	 * The payment data if we will do the decryption of the encrypted payment data. Typically you'd use encryptedCustomerInput in the root of the create payment request to provide the encrypted payment data instead.
	 * * For Apple Pay, the encrypted payment data can be found in property data of the PKPayment.token.paymentData property.
	 */
	public MobilePaymentMethodSpecificInput withEncryptedPaymentData(String value) {
		this.encryptedPaymentData = value;
		return this;
	}

	/**
	 * Ephemeral Key
	 * A unique generated key used by Apple to encrypt data.
	 */
	public String getEphemeralKey() {
		return ephemeralKey;
	}

	/**
	 * Ephemeral Key
	 * A unique generated key used by Apple to encrypt data.
	 */
	public void setEphemeralKey(String value) {
		this.ephemeralKey = value;
	}

	/**
	 * Ephemeral Key
	 * A unique generated key used by Apple to encrypt data.
	 */
	public MobilePaymentMethodSpecificInput withEphemeralKey(String value) {
		this.ephemeralKey = value;
		return this;
	}

	/**
	 * Object containing information specific to Google Pay. Required for payments with product 320.
	 */
	public MobilePaymentProduct320SpecificInput getPaymentProduct320SpecificInput() {
		return paymentProduct320SpecificInput;
	}

	/**
	 * Object containing information specific to Google Pay. Required for payments with product 320.
	 */
	public void setPaymentProduct320SpecificInput(MobilePaymentProduct320SpecificInput value) {
		this.paymentProduct320SpecificInput = value;
	}

	/**
	 * Object containing information specific to Google Pay. Required for payments with product 320.
	 */
	public MobilePaymentMethodSpecificInput withPaymentProduct320SpecificInput(MobilePaymentProduct320SpecificInput value) {
		this.paymentProduct320SpecificInput = value;
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
	public MobilePaymentMethodSpecificInput withPaymentProductId(Integer value) {
		this.paymentProductId = value;
		return this;
	}

	/**
	 * Public Key Hash
	 * A unique identifier to retrieve key used by Apple to encrypt information.
	 */
	public String getPublicKeyHash() {
		return publicKeyHash;
	}

	/**
	 * Public Key Hash
	 * A unique identifier to retrieve key used by Apple to encrypt information.
	 */
	public void setPublicKeyHash(String value) {
		this.publicKeyHash = value;
	}

	/**
	 * Public Key Hash
	 * A unique identifier to retrieve key used by Apple to encrypt information.
	 */
	public MobilePaymentMethodSpecificInput withPublicKeyHash(String value) {
		this.publicKeyHash = value;
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
	public MobilePaymentMethodSpecificInput withRequiresApproval(Boolean value) {
		this.requiresApproval = value;
		return this;
	}
}
