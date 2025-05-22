/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RedirectPaymentProduct5001SpecificInput {

    private String exemptionRequest;

    private String subsequentType;

    /**
     * In PSD2, the ExemptionRequest field is used by merchants requesting an exemption when not using authentication on a transaction, in order to keep the conversion up. This field indicates the reason for the authentication exemption request. Allowed values:
     * <ul>
     *   <li>low-value - The transaction amount is below the 30€, with a maximum of 5 transactions or €100 accumulated per customer.</li>
     *   <li>transaction-risk-analysis - The transaction has been assessed as low risk by the merchant's fraud prevention system.</li>
     * </ul>
     */
    public String getExemptionRequest() {
        return exemptionRequest;
    }

    /**
     * In PSD2, the ExemptionRequest field is used by merchants requesting an exemption when not using authentication on a transaction, in order to keep the conversion up. This field indicates the reason for the authentication exemption request. Allowed values:
     * <ul>
     *   <li>low-value - The transaction amount is below the 30€, with a maximum of 5 transactions or €100 accumulated per customer.</li>
     *   <li>transaction-risk-analysis - The transaction has been assessed as low risk by the merchant's fraud prevention system.</li>
     * </ul>
     */
    public void setExemptionRequest(String value) {
        this.exemptionRequest = value;
    }

    /**
     * In PSD2, the ExemptionRequest field is used by merchants requesting an exemption when not using authentication on a transaction, in order to keep the conversion up. This field indicates the reason for the authentication exemption request. Allowed values:
     * <ul>
     *   <li>low-value - The transaction amount is below the 30€, with a maximum of 5 transactions or €100 accumulated per customer.</li>
     *   <li>transaction-risk-analysis - The transaction has been assessed as low risk by the merchant's fraud prevention system.</li>
     * </ul>
     */
    public RedirectPaymentProduct5001SpecificInput withExemptionRequest(String value) {
        this.exemptionRequest = value;
        return this;
    }

    /**
     * Determines the type of the subsequent that will be used. Allowed values:
     * <ul>
     *   <li>recurring - Transactions processed at fixed, regular intervals not to exceed one year between Transactions, representing an agreement between a consumer and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account.</li>
     *   <li>installment - Installment payments describe a single purchase of goods or services billed to a consumer in multiple transactions over a period of time agreed by the consumer and merchant.</li>
     *   <li>other - other cases</li>
     * </ul>
     */
    public String getSubsequentType() {
        return subsequentType;
    }

    /**
     * Determines the type of the subsequent that will be used. Allowed values:
     * <ul>
     *   <li>recurring - Transactions processed at fixed, regular intervals not to exceed one year between Transactions, representing an agreement between a consumer and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account.</li>
     *   <li>installment - Installment payments describe a single purchase of goods or services billed to a consumer in multiple transactions over a period of time agreed by the consumer and merchant.</li>
     *   <li>other - other cases</li>
     * </ul>
     */
    public void setSubsequentType(String value) {
        this.subsequentType = value;
    }

    /**
     * Determines the type of the subsequent that will be used. Allowed values:
     * <ul>
     *   <li>recurring - Transactions processed at fixed, regular intervals not to exceed one year between Transactions, representing an agreement between a consumer and a merchant to purchase goods or services provided over a period of time. Note that a recurring MIT transaction is initiated by the merchant (payee) not the customer (payer) and so is out of scope of PSD2. Recurring transactions that are in scope of PSD2 (and therefore may benefit from the recurring transaction exemption) are those that are customer (payer) initiates, e.g. standing orders set up from a bank account.</li>
     *   <li>installment - Installment payments describe a single purchase of goods or services billed to a consumer in multiple transactions over a period of time agreed by the consumer and merchant.</li>
     *   <li>other - other cases</li>
     * </ul>
     */
    public RedirectPaymentProduct5001SpecificInput withSubsequentType(String value) {
        this.subsequentType = value;
        return this;
    }
}
