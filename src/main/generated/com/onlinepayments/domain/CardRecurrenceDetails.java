/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CardRecurrenceDetails {

    private String recurringPaymentSequenceIndicator;

    /**
     * <ul>
     *   <li>first = This transaction is the first of a series of recurring transactions</li>
     *   <li>recurring = This transaction is a subsequent transaction in a series of recurring transactions</li>
     * </ul>
     * <p>
     * Note: For any first of a recurring the system will automatically create a token as you will need to use a token for any subsequent recurring transactions. In case a token already exists this is indicated in the response with a value of False for the isNewToken property in the response.
     */
    public String getRecurringPaymentSequenceIndicator() {
        return recurringPaymentSequenceIndicator;
    }

    /**
     * <ul>
     *   <li>first = This transaction is the first of a series of recurring transactions</li>
     *   <li>recurring = This transaction is a subsequent transaction in a series of recurring transactions</li>
     * </ul>
     * <p>
     * Note: For any first of a recurring the system will automatically create a token as you will need to use a token for any subsequent recurring transactions. In case a token already exists this is indicated in the response with a value of False for the isNewToken property in the response.
     */
    public void setRecurringPaymentSequenceIndicator(String value) {
        this.recurringPaymentSequenceIndicator = value;
    }

    /**
     * <ul>
     *   <li>first = This transaction is the first of a series of recurring transactions</li>
     *   <li>recurring = This transaction is a subsequent transaction in a series of recurring transactions</li>
     * </ul>
     * <p>
     * Note: For any first of a recurring the system will automatically create a token as you will need to use a token for any subsequent recurring transactions. In case a token already exists this is indicated in the response with a value of False for the isNewToken property in the response.
     */
    public CardRecurrenceDetails withRecurringPaymentSequenceIndicator(String value) {
        this.recurringPaymentSequenceIndicator = value;
        return this;
    }
}
