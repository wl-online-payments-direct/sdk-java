/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class PaymentLinkOverviewSorting {

    private String sortDirection;

    private String sortProperty;

    /**
     * The direction to sort the results. Possible values are:
     * <ul>
     *   <li>ascending - Sort in ascending order.</li>
     *   <li>descending - Sort in descending order.</li>
     * </ul>
     */
    public String getSortDirection() {
        return sortDirection;
    }

    /**
     * The direction to sort the results. Possible values are:
     * <ul>
     *   <li>ascending - Sort in ascending order.</li>
     *   <li>descending - Sort in descending order.</li>
     * </ul>
     */
    public void setSortDirection(String value) {
        this.sortDirection = value;
    }

    /**
     * The direction to sort the results. Possible values are:
     * <ul>
     *   <li>ascending - Sort in ascending order.</li>
     *   <li>descending - Sort in descending order.</li>
     * </ul>
     */
    public PaymentLinkOverviewSorting withSortDirection(String value) {
        this.sortDirection = value;
        return this;
    }

    /**
     * The property to sort the results by. Possible values are:
     * <ul>
     *   <li>creationDate - Sort by the date the payment link was created.</li>
     *   <li>expirationDate - Sort by the expiration date of the payment link.</li>
     *   <li>merchantId - Sort by the merchant ID of the payment link.</li>
     *   <li>status - Sort by the status of the payment link.</li>
     * </ul>
     */
    public String getSortProperty() {
        return sortProperty;
    }

    /**
     * The property to sort the results by. Possible values are:
     * <ul>
     *   <li>creationDate - Sort by the date the payment link was created.</li>
     *   <li>expirationDate - Sort by the expiration date of the payment link.</li>
     *   <li>merchantId - Sort by the merchant ID of the payment link.</li>
     *   <li>status - Sort by the status of the payment link.</li>
     * </ul>
     */
    public void setSortProperty(String value) {
        this.sortProperty = value;
    }

    /**
     * The property to sort the results by. Possible values are:
     * <ul>
     *   <li>creationDate - Sort by the date the payment link was created.</li>
     *   <li>expirationDate - Sort by the expiration date of the payment link.</li>
     *   <li>merchantId - Sort by the merchant ID of the payment link.</li>
     *   <li>status - Sort by the status of the payment link.</li>
     * </ul>
     */
    public PaymentLinkOverviewSorting withSortProperty(String value) {
        this.sortProperty = value;
        return this;
    }
}
