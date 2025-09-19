/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class OmnichannelRefundSpecificInput {

    private String operatorId;

    /**
     * While calling Direct, the merchant can, for the sake of reporting and auditing, indicate which human user of his enterprise requested the action.
     * Note that it is up to the merchant to make up a code to identify the employee, for instance, the userid of the employee logged on to the cash register. When not used, the field defaults to the merchant id.
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * While calling Direct, the merchant can, for the sake of reporting and auditing, indicate which human user of his enterprise requested the action.
     * Note that it is up to the merchant to make up a code to identify the employee, for instance, the userid of the employee logged on to the cash register. When not used, the field defaults to the merchant id.
     */
    public void setOperatorId(String value) {
        this.operatorId = value;
    }

    /**
     * While calling Direct, the merchant can, for the sake of reporting and auditing, indicate which human user of his enterprise requested the action.
     * Note that it is up to the merchant to make up a code to identify the employee, for instance, the userid of the employee logged on to the cash register. When not used, the field defaults to the merchant id.
     */
    public OmnichannelRefundSpecificInput withOperatorId(String value) {
        this.operatorId = value;
        return this;
    }
}
