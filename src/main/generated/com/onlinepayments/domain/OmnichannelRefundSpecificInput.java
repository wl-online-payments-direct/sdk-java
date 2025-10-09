/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class OmnichannelRefundSpecificInput {

    private String operatorId;

    /**
     * While calling Direct, the merchant can indicate which human user of their enterprise requested the action for reporting and auditing purposes.
     * Note that it is up to the merchant to make up a code to identify the employee, for instance, the user ID of the employee logged on to the cash register. When not used, the field defaults to the merchant ID.
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * While calling Direct, the merchant can indicate which human user of their enterprise requested the action for reporting and auditing purposes.
     * Note that it is up to the merchant to make up a code to identify the employee, for instance, the user ID of the employee logged on to the cash register. When not used, the field defaults to the merchant ID.
     */
    public void setOperatorId(String value) {
        this.operatorId = value;
    }

    /**
     * While calling Direct, the merchant can indicate which human user of their enterprise requested the action for reporting and auditing purposes.
     * Note that it is up to the merchant to make up a code to identify the employee, for instance, the user ID of the employee logged on to the cash register. When not used, the field defaults to the merchant ID.
     */
    public OmnichannelRefundSpecificInput withOperatorId(String value) {
        this.operatorId = value;
        return this;
    }
}
