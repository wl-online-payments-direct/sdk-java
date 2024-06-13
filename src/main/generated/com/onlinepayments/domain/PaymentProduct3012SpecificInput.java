/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing specific input required for bancontact.
 */
public class PaymentProduct3012SpecificInput {

	private Boolean forceAuthentication = null;

	private Boolean isDeferredPayment = null;

	private Boolean isWipTransaction = null;

	private String wipMerchantAuthenticationMethod = null;

	/**
	 * Indicate whether 3D Secure authentication should be forced.
	 */
	public Boolean getForceAuthentication() {
		return forceAuthentication;
	}

	/**
	 * Indicate whether 3D Secure authentication should be forced.
	 */
	public void setForceAuthentication(Boolean value) {
		this.forceAuthentication = value;
	}

	/**
	 * Indicate whether 3D Secure authentication should be forced.
	 */
	public PaymentProduct3012SpecificInput withForceAuthentication(Boolean value) {
		this.forceAuthentication = value;
		return this;
	}

	/**
	 * Indicate whether its a deferred payment.
	 */
	public Boolean getIsDeferredPayment() {
		return isDeferredPayment;
	}

	/**
	 * Indicate whether its a deferred payment.
	 */
	public void setIsDeferredPayment(Boolean value) {
		this.isDeferredPayment = value;
	}

	/**
	 * Indicate whether its a deferred payment.
	 */
	public PaymentProduct3012SpecificInput withIsDeferredPayment(Boolean value) {
		this.isDeferredPayment = value;
		return this;
	}

	/**
	 * Indicate whether its wallet initiated payment.
	 */
	public Boolean getIsWipTransaction() {
		return isWipTransaction;
	}

	/**
	 * Indicate whether its wallet initiated payment.
	 */
	public void setIsWipTransaction(Boolean value) {
		this.isWipTransaction = value;
	}

	/**
	 * Indicate whether its wallet initiated payment.
	 */
	public PaymentProduct3012SpecificInput withIsWipTransaction(Boolean value) {
		this.isWipTransaction = value;
		return this;
	}

	/**
	 * Indicates how the cardholder was authenticated to the Merchant Wallet in the context of the transaction to which the BEPAF is attached
	 * * 01 = Username/password or PIN login successfully performed by cardholder.
	 * * 02 = Authentication through Secret/Private Key in Secure Hardware Solution was successfully performed.
	 * * 04 = Authentication through Secret/Private Key in Secure Software Solution (for example, mobile App) was successfully performed.
	 * * 08 = Location-based Authentication was successfully performed.
	 * * 10 = Environmental Authentication in Secure Software Solution (mobile App) was successfully performed.
	 * * 20 = Behavioral Analysis was successfully performed.
	 * * 40 = Biometrics Authentication was successfully performed.
	 * * 80 = Out of band user authentication was successfully performed.
	 */
	public String getWipMerchantAuthenticationMethod() {
		return wipMerchantAuthenticationMethod;
	}

	/**
	 * Indicates how the cardholder was authenticated to the Merchant Wallet in the context of the transaction to which the BEPAF is attached
	 * * 01 = Username/password or PIN login successfully performed by cardholder.
	 * * 02 = Authentication through Secret/Private Key in Secure Hardware Solution was successfully performed.
	 * * 04 = Authentication through Secret/Private Key in Secure Software Solution (for example, mobile App) was successfully performed.
	 * * 08 = Location-based Authentication was successfully performed.
	 * * 10 = Environmental Authentication in Secure Software Solution (mobile App) was successfully performed.
	 * * 20 = Behavioral Analysis was successfully performed.
	 * * 40 = Biometrics Authentication was successfully performed.
	 * * 80 = Out of band user authentication was successfully performed.
	 */
	public void setWipMerchantAuthenticationMethod(String value) {
		this.wipMerchantAuthenticationMethod = value;
	}

	/**
	 * Indicates how the cardholder was authenticated to the Merchant Wallet in the context of the transaction to which the BEPAF is attached
	 * * 01 = Username/password or PIN login successfully performed by cardholder.
	 * * 02 = Authentication through Secret/Private Key in Secure Hardware Solution was successfully performed.
	 * * 04 = Authentication through Secret/Private Key in Secure Software Solution (for example, mobile App) was successfully performed.
	 * * 08 = Location-based Authentication was successfully performed.
	 * * 10 = Environmental Authentication in Secure Software Solution (mobile App) was successfully performed.
	 * * 20 = Behavioral Analysis was successfully performed.
	 * * 40 = Biometrics Authentication was successfully performed.
	 * * 80 = Out of band user authentication was successfully performed.
	 */
	public PaymentProduct3012SpecificInput withWipMerchantAuthenticationMethod(String value) {
		this.wipMerchantAuthenticationMethod = value;
		return this;
	}
}
