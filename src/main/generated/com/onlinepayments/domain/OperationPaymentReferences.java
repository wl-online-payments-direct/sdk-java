/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class OperationPaymentReferences {

    private String merchantReference;

    private String operationGroupReference;

    /**
     * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
     * It is highly recommended to provide a single MerchantReference per unique order on your side
     */
    public String getMerchantReference() {
        return merchantReference;
    }

    /**
     * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
     * It is highly recommended to provide a single MerchantReference per unique order on your side
     */
    public void setMerchantReference(String value) {
        this.merchantReference = value;
    }

    /**
     * Your unique reference of the transaction that is also returned in our report files. This is almost always used for your reconciliation of our report files.
     * It is highly recommended to provide a single MerchantReference per unique order on your side
     */
    public OperationPaymentReferences withMerchantReference(String value) {
        this.merchantReference = value;
        return this;
    }

    /**
     * An identifier for a group of transactions. This reference helps to link multiple related transactions together, facilitating easier reconciliation and tracking.
     */
    public String getOperationGroupReference() {
        return operationGroupReference;
    }

    /**
     * An identifier for a group of transactions. This reference helps to link multiple related transactions together, facilitating easier reconciliation and tracking.
     */
    public void setOperationGroupReference(String value) {
        this.operationGroupReference = value;
    }

    /**
     * An identifier for a group of transactions. This reference helps to link multiple related transactions together, facilitating easier reconciliation and tracking.
     */
    public OperationPaymentReferences withOperationGroupReference(String value) {
        this.operationGroupReference = value;
        return this;
    }
}
