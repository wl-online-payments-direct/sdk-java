/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class SubsequentPaymentProduct5001SpecificInput {

    private String authorizationMode;

    private String subsequentType;

    /**
     * Determines the type of the authorization that will be used. Allowed values:
     * <ul>
     *   <li>FINAL_AUTHORIZATION - The payment creation results in an authorization that is ready for capture. Final authorizations can't be reversed and need to be captured for the full amount within 7 days.</li>
     *   <li>SALE - The payment creation results in an authorization that is already captured at the moment of approval</li>
     * </ul>
     */
    public String getAuthorizationMode() {
        return authorizationMode;
    }

    /**
     * Determines the type of the authorization that will be used. Allowed values:
     * <ul>
     *   <li>FINAL_AUTHORIZATION - The payment creation results in an authorization that is ready for capture. Final authorizations can't be reversed and need to be captured for the full amount within 7 days.</li>
     *   <li>SALE - The payment creation results in an authorization that is already captured at the moment of approval</li>
     * </ul>
     */
    public void setAuthorizationMode(String value) {
        this.authorizationMode = value;
    }

    /**
     * Determines the type of the authorization that will be used. Allowed values:
     * <ul>
     *   <li>FINAL_AUTHORIZATION - The payment creation results in an authorization that is ready for capture. Final authorizations can't be reversed and need to be captured for the full amount within 7 days.</li>
     *   <li>SALE - The payment creation results in an authorization that is already captured at the moment of approval</li>
     * </ul>
     */
    public SubsequentPaymentProduct5001SpecificInput withAuthorizationMode(String value) {
        this.authorizationMode = value;
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
    public SubsequentPaymentProduct5001SpecificInput withSubsequentType(String value) {
        this.subsequentType = value;
        return this;
    }
}
