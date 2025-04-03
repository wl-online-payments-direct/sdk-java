/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class MandateMerchantAction {

    private String actionType;

    private MandateRedirectData redirectData;

    /**
     * Action merchants needs to take in the online mandate process. Possible values are:
     * <ul>
     *   <li>REDIRECT - The customer needs to be redirected using the details found in redirectData</li>
     * </ul>
     */
    public String getActionType() {
        return actionType;
    }

    /**
     * Action merchants needs to take in the online mandate process. Possible values are:
     * <ul>
     *   <li>REDIRECT - The customer needs to be redirected using the details found in redirectData</li>
     * </ul>
     */
    public void setActionType(String value) {
        this.actionType = value;
    }

    /**
     * Action merchants needs to take in the online mandate process. Possible values are:
     * <ul>
     *   <li>REDIRECT - The customer needs to be redirected using the details found in redirectData</li>
     * </ul>
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
