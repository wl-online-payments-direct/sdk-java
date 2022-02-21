/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object that contains the action, including the needed data, that you should perform next, showing the redirect to a third party to complete the payment or like showing instructions.
 */
public class MandateMerchantAction {

	private String actionType = null;

	private MandateRedirectData redirectData = null;

	/**
	 * Action merchants needs to take in the online mandate process. Possible values are:
	 * * REDIRECT - The customer needs to be redirected using the details found in redirectData
	 */
	public String getActionType() {
		return actionType;
	}

	/**
	 * Action merchants needs to take in the online mandate process. Possible values are:
	 * * REDIRECT - The customer needs to be redirected using the details found in redirectData
	 */
	public void setActionType(String value) {
		this.actionType = value;
	}

	/**
	 * Action merchants needs to take in the online mandate process. Possible values are:
	 * * REDIRECT - The customer needs to be redirected using the details found in redirectData
	 */
	public MandateMerchantAction withActionType(String value) {
		this.actionType = value;
		return this;
	}

	/**
	 * Object containing all data needed to redirect the customer
	 */
	public MandateRedirectData getRedirectData() {
		return redirectData;
	}

	/**
	 * Object containing all data needed to redirect the customer
	 */
	public void setRedirectData(MandateRedirectData value) {
		this.redirectData = value;
	}

	/**
	 * Object containing all data needed to redirect the customer
	 */
	public MandateMerchantAction withRedirectData(MandateRedirectData value) {
		this.redirectData = value;
		return this;
	}
}
