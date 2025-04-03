/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class OrderTypeInformation {

    private String purchaseType;

    private String transactionType;

    /**
     * Possible values are:
     * <ul>
     *   <li>physical (tangible goods shipped to the customers)</li>
     *   <li>digital (digital services like ebooks, streaming...)</li>
     * </ul>
     */
    public String getPurchaseType() {
        return purchaseType;
    }

    /**
     * Possible values are:
     * <ul>
     *   <li>physical (tangible goods shipped to the customers)</li>
     *   <li>digital (digital services like ebooks, streaming...)</li>
     * </ul>
     */
    public void setPurchaseType(String value) {
        this.purchaseType = value;
    }

    /**
     * Possible values are:
     * <ul>
     *   <li>physical (tangible goods shipped to the customers)</li>
     *   <li>digital (digital services like ebooks, streaming...)</li>
     * </ul>
     */
    public OrderTypeInformation withPurchaseType(String value) {
        this.purchaseType = value;
        return this;
    }

    /**
     * Identifies the type of transaction being authenticated. Possible values are:
     * <ul>
     *   <li>purchase = The purpose of the transaction is to purchase goods or services (Default)</li>
     *   <li>check-acceptance = The purpose of the transaction is to accept a 'check'/'cheque'</li>
     *   <li>account-funding = The purpose of the transaction is to fund an account</li>
     *   <li>quasi-cash = The purpose of the transaction is to buy a quasi cash type product that is representative of actual cash such as money orders, traveler's checks, foreign currency, lottery tickets or casino gaming chips</li>
     *   <li>prepaid-activation-or-load = The purpose of the transaction is to activate or load a prepaid card</li>
     * </ul>
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Identifies the type of transaction being authenticated. Possible values are:
     * <ul>
     *   <li>purchase = The purpose of the transaction is to purchase goods or services (Default)</li>
     *   <li>check-acceptance = The purpose of the transaction is to accept a 'check'/'cheque'</li>
     *   <li>account-funding = The purpose of the transaction is to fund an account</li>
     *   <li>quasi-cash = The purpose of the transaction is to buy a quasi cash type product that is representative of actual cash such as money orders, traveler's checks, foreign currency, lottery tickets or casino gaming chips</li>
     *   <li>prepaid-activation-or-load = The purpose of the transaction is to activate or load a prepaid card</li>
     * </ul>
     */
    public void setTransactionType(String value) {
        this.transactionType = value;
    }

    /**
     * Identifies the type of transaction being authenticated. Possible values are:
     * <ul>
     *   <li>purchase = The purpose of the transaction is to purchase goods or services (Default)</li>
     *   <li>check-acceptance = The purpose of the transaction is to accept a 'check'/'cheque'</li>
     *   <li>account-funding = The purpose of the transaction is to fund an account</li>
     *   <li>quasi-cash = The purpose of the transaction is to buy a quasi cash type product that is representative of actual cash such as money orders, traveler's checks, foreign currency, lottery tickets or casino gaming chips</li>
     *   <li>prepaid-activation-or-load = The purpose of the transaction is to activate or load a prepaid card</li>
     * </ul>
     */
    public OrderTypeInformation withTransactionType(String value) {
        this.transactionType = value;
        return this;
    }
}
