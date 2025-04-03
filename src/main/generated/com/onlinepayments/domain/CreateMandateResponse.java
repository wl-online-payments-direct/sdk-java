/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CreateMandateResponse {

    private MandateResponse mandate;

    private MandateMerchantAction merchantAction;

    /**
     * Object containing the created mandate.
     */
    public MandateResponse getMandate() {
        return mandate;
    }

    /**
     * Object containing the created mandate.
     */
    public void setMandate(MandateResponse value) {
        this.mandate = value;
    }

    /**
     * Object containing the created mandate.
     */
    public CreateMandateResponse withMandate(MandateResponse value) {
        this.mandate = value;
        return this;
    }

    /**
     * Object that contains the action, including the needed data, that you should perform next, showing the redirect to a third party to complete the payment or like showing instructions.
     */
    public MandateMerchantAction getMerchantAction() {
        return merchantAction;
    }

    /**
     * Object that contains the action, including the needed data, that you should perform next, showing the redirect to a third party to complete the payment or like showing instructions.
     */
    public void setMerchantAction(MandateMerchantAction value) {
        this.merchantAction = value;
    }

    /**
     * Object that contains the action, including the needed data, that you should perform next, showing the redirect to a third party to complete the payment or like showing instructions.
     */
    public CreateMandateResponse withMerchantAction(MandateMerchantAction value) {
        this.merchantAction = value;
        return this;
    }
}
