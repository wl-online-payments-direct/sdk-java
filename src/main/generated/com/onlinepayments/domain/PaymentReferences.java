/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentReferences {

    private String merchantComment;

    private String merchantParameters;

    private String merchantReconciliationReference;

    private String merchantReference;

    private String operationGroupReference;

    private String softDescriptor;

    private String structuredCreditorReference;

    /**
     * It allows you to store additional information for the transaction. This is typically used in case you need additional data field on top of the other ones, such as merchantAdditionalReference. This data is not sent to the acquirer, and is used for reporting purpose.
     */
    public String getMerchantComment() {
        return merchantComment;
    }

    /**
     * It allows you to store additional information for the transaction. This is typically used in case you need additional data field on top of the other ones, such as merchantAdditionalReference. This data is not sent to the acquirer, and is used for reporting purpose.
     */
    public void setMerchantComment(String value) {
        this.merchantComment = value;
    }

    /**
     * It allows you to store additional information for the transaction. This is typically used in case you need additional data field on top of the other ones, such as merchantAdditionalReference. This data is not sent to the acquirer, and is used for reporting purpose.
     */
    public PaymentReferences withMerchantComment(String value) {
        this.merchantComment = value;
        return this;
    }

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
     * It allows you to store additional information for the transaction. This is sent to the acquirer (if it accepts it), and is typically to be used for reconciliation purpose . As this information appears in reporting, please do not encode any sensitive data.
     */
    public String getMerchantReconciliationReference() {
        return merchantReconciliationReference;
    }

    /**
     * It allows you to store additional information for the transaction. This is sent to the acquirer (if it accepts it), and is typically to be used for reconciliation purpose . As this information appears in reporting, please do not encode any sensitive data.
     */
    public void setMerchantReconciliationReference(String value) {
        this.merchantReconciliationReference = value;
    }

    /**
     * It allows you to store additional information for the transaction. This is sent to the acquirer (if it accepts it), and is typically to be used for reconciliation purpose . As this information appears in reporting, please do not encode any sensitive data.
     */
    public PaymentReferences withMerchantReconciliationReference(String value) {
        this.merchantReconciliationReference = value;
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
     * Descriptive text that is used towards to customer, either during an online checkout at a third party and/or on the statement of the customer. For card transactions this is usually referred to as a Soft Descriptor. The maximum allowed length varies per card acquirer:
     * <ul>
     *   <li>AIB - 22 characters</li>
     *   <li>American Express - 25 characters</li>
     *   <li>Atos Origin BNP - 15 characters</li>
     *   <li>Barclays - 25 characters</li>
     *   <li>Catella - 22 characters</li>
     *   <li>CBA - 20 characters</li>
     *   <li>Elavon - 25 characters</li>
     *   <li>First Data - 25 characters</li>
     *   <li>INICIS (INIPAY) - 22-30 characters</li>
     *   <li>JCB - 25 characters</li>
     *   <li>Merchant Solutions - 22-25 characters</li>
     *   <li>Payvision (EU &amp; HK) - 25 characters</li>
     *   <li>SEB Euroline - 22 characters</li>
     *   <li>Sub1 Argentina - 15 characters</li>
     *   <li>Wells Fargo - 25 characters
     * Note that we advise you to use 22 characters as the max length as beyond this our experience is that issuers will start to truncate. We currently also only allow per API call overrides for AIB and Barclays
     * For alternative payment products the maximum allowed length varies per payment product:</li>
     *   <li>402 e-Przelewy - 30 characters</li>
     *   <li>404 INICIS - 80 characters</li>
     *   <li>802 Nordea ePayment Finland - 234 characters</li>
     *   <li>809 iDeal - 32 characters</li>
     *   <li>836 SOFORT - 42 characters</li>
     *   <li>840 PayPal - 127 characters</li>
     *   <li>841 WebMoney - 175 characters</li>
     *   <li>849 Yandex - 64 characters</li>
     *   <li>861 Alipay - 256 characters</li>
     *   <li>863 WeChat Pay - 32 characters</li>
     *   <li>880 BOKU - 20 characters</li>
     *   <li>8580 Qiwi - 255 characters</li>
     *   <li>1504 Konbini - 80 characters
     * All other payment products do not support a descriptor.</li>
     * </ul>
     */
    public String getSoftDescriptor() {
        return softDescriptor;
    }

    /**
     * Descriptive text that is used towards to customer, either during an online checkout at a third party and/or on the statement of the customer. For card transactions this is usually referred to as a Soft Descriptor. The maximum allowed length varies per card acquirer:
     * <ul>
     *   <li>AIB - 22 characters</li>
     *   <li>American Express - 25 characters</li>
     *   <li>Atos Origin BNP - 15 characters</li>
     *   <li>Barclays - 25 characters</li>
     *   <li>Catella - 22 characters</li>
     *   <li>CBA - 20 characters</li>
     *   <li>Elavon - 25 characters</li>
     *   <li>First Data - 25 characters</li>
     *   <li>INICIS (INIPAY) - 22-30 characters</li>
     *   <li>JCB - 25 characters</li>
     *   <li>Merchant Solutions - 22-25 characters</li>
     *   <li>Payvision (EU &amp; HK) - 25 characters</li>
     *   <li>SEB Euroline - 22 characters</li>
     *   <li>Sub1 Argentina - 15 characters</li>
     *   <li>Wells Fargo - 25 characters
     * Note that we advise you to use 22 characters as the max length as beyond this our experience is that issuers will start to truncate. We currently also only allow per API call overrides for AIB and Barclays
     * For alternative payment products the maximum allowed length varies per payment product:</li>
     *   <li>402 e-Przelewy - 30 characters</li>
     *   <li>404 INICIS - 80 characters</li>
     *   <li>802 Nordea ePayment Finland - 234 characters</li>
     *   <li>809 iDeal - 32 characters</li>
     *   <li>836 SOFORT - 42 characters</li>
     *   <li>840 PayPal - 127 characters</li>
     *   <li>841 WebMoney - 175 characters</li>
     *   <li>849 Yandex - 64 characters</li>
     *   <li>861 Alipay - 256 characters</li>
     *   <li>863 WeChat Pay - 32 characters</li>
     *   <li>880 BOKU - 20 characters</li>
     *   <li>8580 Qiwi - 255 characters</li>
     *   <li>1504 Konbini - 80 characters
     * All other payment products do not support a descriptor.</li>
     * </ul>
     */
    public void setSoftDescriptor(String value) {
        this.softDescriptor = value;
    }

    /**
     * Descriptive text that is used towards to customer, either during an online checkout at a third party and/or on the statement of the customer. For card transactions this is usually referred to as a Soft Descriptor. The maximum allowed length varies per card acquirer:
     * <ul>
     *   <li>AIB - 22 characters</li>
     *   <li>American Express - 25 characters</li>
     *   <li>Atos Origin BNP - 15 characters</li>
     *   <li>Barclays - 25 characters</li>
     *   <li>Catella - 22 characters</li>
     *   <li>CBA - 20 characters</li>
     *   <li>Elavon - 25 characters</li>
     *   <li>First Data - 25 characters</li>
     *   <li>INICIS (INIPAY) - 22-30 characters</li>
     *   <li>JCB - 25 characters</li>
     *   <li>Merchant Solutions - 22-25 characters</li>
     *   <li>Payvision (EU &amp; HK) - 25 characters</li>
     *   <li>SEB Euroline - 22 characters</li>
     *   <li>Sub1 Argentina - 15 characters</li>
     *   <li>Wells Fargo - 25 characters
     * Note that we advise you to use 22 characters as the max length as beyond this our experience is that issuers will start to truncate. We currently also only allow per API call overrides for AIB and Barclays
     * For alternative payment products the maximum allowed length varies per payment product:</li>
     *   <li>402 e-Przelewy - 30 characters</li>
     *   <li>404 INICIS - 80 characters</li>
     *   <li>802 Nordea ePayment Finland - 234 characters</li>
     *   <li>809 iDeal - 32 characters</li>
     *   <li>836 SOFORT - 42 characters</li>
     *   <li>840 PayPal - 127 characters</li>
     *   <li>841 WebMoney - 175 characters</li>
     *   <li>849 Yandex - 64 characters</li>
     *   <li>861 Alipay - 256 characters</li>
     *   <li>863 WeChat Pay - 32 characters</li>
     *   <li>880 BOKU - 20 characters</li>
     *   <li>8580 Qiwi - 255 characters</li>
     *   <li>1504 Konbini - 80 characters
     * All other payment products do not support a descriptor.</li>
     * </ul>
     */
    public PaymentReferences withSoftDescriptor(String value) {
        this.softDescriptor = value;
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
