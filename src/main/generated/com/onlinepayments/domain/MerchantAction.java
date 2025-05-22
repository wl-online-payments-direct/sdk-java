/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class MerchantAction {

    private String actionType;

    private MobileThreeDSecureChallengeParameters mobileThreeDSecureChallengeParameters;

    private RedirectData redirectData;

    private ShowFormData showFormData;

    private ShowInstructionsData showInstructionsData;

    /**
     * Action merchants needs to take in the online payment process. Possible values are:
     * <ul>
     *   <li>REDIRECT - The customer needs to be redirected using the details found in redirectData</li>
     *   <li>SHOW_FORM - The customer needs to be shown a form with the fields found in formFields. You can submit the data entered by the user in a Complete payment request.</li>
     *   <li>SHOW_INSTRUCTIONS - The customer needs to be shown payment instruction using the details found in showData. Alternatively the instructions can be rendered by us using the instructionsRenderingData</li>
     *   <li>SHOW_TRANSACTION_RESULTS - The customer needs to be shown the transaction results using the details found in showData. Alternatively the instructions can be rendered by us using the instructionsRenderingData</li>
     *   <li>MOBILE_THREEDS_CHALLENGE - The customer needs to complete a challenge as part of the 3D Secure authentication inside your mobile app. The details contained in mobileThreeDSecureChallengeParameters need to be provided to the EMVco certified Mobile SDK as a challengeParameters object.</li>
     *   <li>CALL_THIRD_PARTY - The merchant needs to call a third party using the data found in thirdPartyData</li>
     * </ul>
     */
    public String getActionType() {
        return actionType;
    }

    /**
     * Action merchants needs to take in the online payment process. Possible values are:
     * <ul>
     *   <li>REDIRECT - The customer needs to be redirected using the details found in redirectData</li>
     *   <li>SHOW_FORM - The customer needs to be shown a form with the fields found in formFields. You can submit the data entered by the user in a Complete payment request.</li>
     *   <li>SHOW_INSTRUCTIONS - The customer needs to be shown payment instruction using the details found in showData. Alternatively the instructions can be rendered by us using the instructionsRenderingData</li>
     *   <li>SHOW_TRANSACTION_RESULTS - The customer needs to be shown the transaction results using the details found in showData. Alternatively the instructions can be rendered by us using the instructionsRenderingData</li>
     *   <li>MOBILE_THREEDS_CHALLENGE - The customer needs to complete a challenge as part of the 3D Secure authentication inside your mobile app. The details contained in mobileThreeDSecureChallengeParameters need to be provided to the EMVco certified Mobile SDK as a challengeParameters object.</li>
     *   <li>CALL_THIRD_PARTY - The merchant needs to call a third party using the data found in thirdPartyData</li>
     * </ul>
     */
    public void setActionType(String value) {
        this.actionType = value;
    }

    /**
     * Action merchants needs to take in the online payment process. Possible values are:
     * <ul>
     *   <li>REDIRECT - The customer needs to be redirected using the details found in redirectData</li>
     *   <li>SHOW_FORM - The customer needs to be shown a form with the fields found in formFields. You can submit the data entered by the user in a Complete payment request.</li>
     *   <li>SHOW_INSTRUCTIONS - The customer needs to be shown payment instruction using the details found in showData. Alternatively the instructions can be rendered by us using the instructionsRenderingData</li>
     *   <li>SHOW_TRANSACTION_RESULTS - The customer needs to be shown the transaction results using the details found in showData. Alternatively the instructions can be rendered by us using the instructionsRenderingData</li>
     *   <li>MOBILE_THREEDS_CHALLENGE - The customer needs to complete a challenge as part of the 3D Secure authentication inside your mobile app. The details contained in mobileThreeDSecureChallengeParameters need to be provided to the EMVco certified Mobile SDK as a challengeParameters object.</li>
     *   <li>CALL_THIRD_PARTY - The merchant needs to call a third party using the data found in thirdPartyData</li>
     * </ul>
     */
    public MerchantAction withActionType(String value) {
        this.actionType = value;
        return this;
    }

    /**
     * Mobile 3D Secure Challenge Parameters
     */
    public MobileThreeDSecureChallengeParameters getMobileThreeDSecureChallengeParameters() {
        return mobileThreeDSecureChallengeParameters;
    }

    /**
     * Mobile 3D Secure Challenge Parameters
     */
    public void setMobileThreeDSecureChallengeParameters(MobileThreeDSecureChallengeParameters value) {
        this.mobileThreeDSecureChallengeParameters = value;
    }

    /**
     * Mobile 3D Secure Challenge Parameters
     */
    public MerchantAction withMobileThreeDSecureChallengeParameters(MobileThreeDSecureChallengeParameters value) {
        this.mobileThreeDSecureChallengeParameters = value;
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

    /**
     * Object returned for the SHOW_INSTRUCTIONS actionType.
     */
    public ShowInstructionsData getShowInstructionsData() {
        return showInstructionsData;
    }

    /**
     * Object returned for the SHOW_INSTRUCTIONS actionType.
     */
    public void setShowInstructionsData(ShowInstructionsData value) {
        this.showInstructionsData = value;
    }

    /**
     * Object returned for the SHOW_INSTRUCTIONS actionType.
     */
    public MerchantAction withShowInstructionsData(ShowInstructionsData value) {
        this.showInstructionsData = value;
        return this;
    }
}
