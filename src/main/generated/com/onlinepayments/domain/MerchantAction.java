/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object that contains the action, including the needed data, that you should perform next, like showing instructions, showing the transaction results or redirect to a third party to complete the payment
 */
public class MerchantAction {

	private String actionType = null;

	private RedirectData redirectData = null;

	private ShowFormData showFormData = null;

	/**
	 * Action merchants needs to take in the online payment process. Possible values are: 
	 *  * REDIRECT - The customer needs to be redirected using the details found in redirectData 
	 *  * SHOW_FORM - The customer needs to be shown a form with the fields found in formFields. You can submit the data entered by the user in a Complete payment request. 
	 *  * SHOW_INSTRUCTIONS - The customer needs to be shown payment instruction using the details found in showData. Alternatively the instructions can be rendered by us using the instructionsRenderingData 
	 *  * SHOW_TRANSACTION_RESULTS - The customer needs to be shown the transaction results using the details found in showData. Alternatively the instructions can be rendered by us using the instructionsRenderingData 
	 *  * MOBILE_THREEDS_CHALLENGE - The customer needs to complete a challenge as part of the 3D Secure authentication inside your mobile app. The details contained in mobileThreeDSecureChallengeParameters need to be provided to the EMVco certified Mobile SDK as a challengeParameters object. 
	 *  * CALL_THIRD_PARTY - The merchant needs to call a third party using the data found in thirdPartyData
	 */
	public String getActionType() {
		return actionType;
	}

	/**
	 * Action merchants needs to take in the online payment process. Possible values are: 
	 *  * REDIRECT - The customer needs to be redirected using the details found in redirectData 
	 *  * SHOW_FORM - The customer needs to be shown a form with the fields found in formFields. You can submit the data entered by the user in a Complete payment request. 
	 *  * SHOW_INSTRUCTIONS - The customer needs to be shown payment instruction using the details found in showData. Alternatively the instructions can be rendered by us using the instructionsRenderingData 
	 *  * SHOW_TRANSACTION_RESULTS - The customer needs to be shown the transaction results using the details found in showData. Alternatively the instructions can be rendered by us using the instructionsRenderingData 
	 *  * MOBILE_THREEDS_CHALLENGE - The customer needs to complete a challenge as part of the 3D Secure authentication inside your mobile app. The details contained in mobileThreeDSecureChallengeParameters need to be provided to the EMVco certified Mobile SDK as a challengeParameters object. 
	 *  * CALL_THIRD_PARTY - The merchant needs to call a third party using the data found in thirdPartyData
	 */
	public void setActionType(String value) {
		this.actionType = value;
	}

	/**
	 * Action merchants needs to take in the online payment process. Possible values are: 
	 *  * REDIRECT - The customer needs to be redirected using the details found in redirectData 
	 *  * SHOW_FORM - The customer needs to be shown a form with the fields found in formFields. You can submit the data entered by the user in a Complete payment request. 
	 *  * SHOW_INSTRUCTIONS - The customer needs to be shown payment instruction using the details found in showData. Alternatively the instructions can be rendered by us using the instructionsRenderingData 
	 *  * SHOW_TRANSACTION_RESULTS - The customer needs to be shown the transaction results using the details found in showData. Alternatively the instructions can be rendered by us using the instructionsRenderingData 
	 *  * MOBILE_THREEDS_CHALLENGE - The customer needs to complete a challenge as part of the 3D Secure authentication inside your mobile app. The details contained in mobileThreeDSecureChallengeParameters need to be provided to the EMVco certified Mobile SDK as a challengeParameters object. 
	 *  * CALL_THIRD_PARTY - The merchant needs to call a third party using the data found in thirdPartyData
	 */
	public MerchantAction withActionType(String value) {
		this.actionType = value;
		return this;
	}

	/**
	 * Object containing all data needed to redirect the customer
	 */
	public RedirectData getRedirectData() {
		return redirectData;
	}

	/**
	 * Object containing all data needed to redirect the customer
	 */
	public void setRedirectData(RedirectData value) {
		this.redirectData = value;
	}

	/**
	 * Object containing all data needed to redirect the customer
	 */
	public MerchantAction withRedirectData(RedirectData value) {
		this.redirectData = value;
		return this;
	}

	/**
	 * Object returned for the SHOW_FORM actionType.
	 */
	public ShowFormData getShowFormData() {
		return showFormData;
	}

	/**
	 * Object returned for the SHOW_FORM actionType.
	 */
	public void setShowFormData(ShowFormData value) {
		this.showFormData = value;
	}

	/**
	 * Object returned for the SHOW_FORM actionType.
	 */
	public MerchantAction withShowFormData(ShowFormData value) {
		this.showFormData = value;
		return this;
	}
}
