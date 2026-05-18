/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentReferences {

    private String merchantParameters;

    private String merchantReference;

    private String operationGroupReference;

    private String structuredCreditorReference;

    /**
     * It allows you to store additional parameters for the transaction in the format you prefer (e.g.-&gt; key-value query string, JSON, etc.) These parameters are then echoed back to you in API GET calls and Webhook notifications. This field must not contain any personal data.
     */
    public String getMerchantParameters() {
        return merchantParameters;
    }

    /**
     * It allows you to store additional parameters for the transaction in the format you prefer (e.g.-&gt; key-value query string, JSON, etc.) These parameters are then echoed back to you in API GET calls and Webhook notifications. This field must not contain any personal data.
     */
    public void setMerchantParameters(String value) {
        this.merchantParameters = value;
    }

    /**
     * It allows you to store additional parameters for the transaction in the format you prefer (e.g.-&gt; key-value query string, JSON, etc.) These parameters are then echoed back to you in API GET calls and Webhook notifications. This field must not contain any personal data.
     */
    public PaymentReferences withMerchantParameters(String value) {
        this.merchantParameters = value;
        return this;
    }

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
    public PaymentReferences withMerchantReference(String value) {
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
    public PaymentReferences withOperationGroupReference(String value) {
        this.operationGroupReference = value;
        return this;
    }

    /**
     * Creditor Reference to use where applicable for invoicing related to the transaction, in accordance with ISO 11649. Might require merchant specific setup to enable and is subject to agreement with the acquirer.
     */
    public String getStructuredCreditorReference() {
        return structuredCreditorReference;
    }

    /**
     * Creditor Reference to use where applicable for invoicing related to the transaction, in accordance with ISO 11649. Might require merchant specific setup to enable and is subject to agreement with the acquirer.
     */
    public void setStructuredCreditorReference(String value) {
        this.structuredCreditorReference = value;
    }

    /**
     * Creditor Reference to use where applicable for invoicing related to the transaction, in accordance with ISO 11649. Might require merchant specific setup to enable and is subject to agreement with the acquirer.
     */
    public PaymentReferences withStructuredCreditorReference(String value) {
        this.structuredCreditorReference = value;
        return this;
    }
}
