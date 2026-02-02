/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class OmnichannelSubsequentSpecificInput {

    private String operatorId;

    /**
     * Merchants may optionally include a user identifier to indicate which person within their organization initiated this request, enabling detailed audit trails and transaction accountability.
     * If not provided, the field defaults to the merchant ID.
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * Merchants may optionally include a user identifier to indicate which person within their organization initiated this request, enabling detailed audit trails and transaction accountability.
     * If not provided, the field defaults to the merchant ID.
     */
    public void setOperatorId(String value) {
        this.operatorId = value;
    }

    /**
     * Merchants may optionally include a user identifier to indicate which person within their organization initiated this request, enabling detailed audit trails and transaction accountability.
     * If not provided, the field defaults to the merchant ID.
     */
    public OmnichannelSubsequentSpecificInput withOperatorId(String value) {
        this.operatorId = value;
        return this;
    }
}
