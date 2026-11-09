/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CardInstallmentDetails {

    private String installmentPaymentSequenceIndicator;

    /**
     * <ul>
     *   <li>first = This transaction is the first of a series of installment transactions</li>
     *   <li>subsequent = This transaction is a subsequent transaction in a series of installment transactions
     * Note: For any first of an installment the system will automatically create a token as you will need to use a token for any subsequent installment transactions. In case a token already exists this is indicated in the response with a value of False for the isNewToken property in the response.</li>
     * </ul>
     */
    public String getInstallmentPaymentSequenceIndicator() {
        return installmentPaymentSequenceIndicator;
    }

    /**
     * <ul>
     *   <li>first = This transaction is the first of a series of installment transactions</li>
     *   <li>subsequent = This transaction is a subsequent transaction in a series of installment transactions
     * Note: For any first of an installment the system will automatically create a token as you will need to use a token for any subsequent installment transactions. In case a token already exists this is indicated in the response with a value of False for the isNewToken property in the response.</li>
     * </ul>
     */
    public void setInstallmentPaymentSequenceIndicator(String value) {
        this.installmentPaymentSequenceIndicator = value;
    }

    /**
     * <ul>
     *   <li>first = This transaction is the first of a series of installment transactions</li>
     *   <li>subsequent = This transaction is a subsequent transaction in a series of installment transactions
     * Note: For any first of an installment the system will automatically create a token as you will need to use a token for any subsequent installment transactions. In case a token already exists this is indicated in the response with a value of False for the isNewToken property in the response.</li>
     * </ul>
     */
    public CardInstallmentDetails withInstallmentPaymentSequenceIndicator(String value) {
        this.installmentPaymentSequenceIndicator = value;
        return this;
    }
}
