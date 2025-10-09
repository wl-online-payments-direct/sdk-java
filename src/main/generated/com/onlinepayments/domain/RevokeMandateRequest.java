/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class RevokeMandateRequest {

    private String revocationReason;

    /**
     * The reason for revoking the mandate.
     * Possible values are:
     * <ul>
     *   <li>receivedFinal</li>
     *   <li>userAction</li>
     *   <li>obsolescence</li>
     *   <li>refused</li>
     *   <li>revocationAskedByDebitor</li>
     *   <li>revocationAskedByCreditor</li>
     *   <li>deletionAskedByDebitor</li>
     *   <li>deletionAskedByCreditor</li>
     * </ul>
     * <p>
     * Refer to the support page to determine if the property is applicable.
     */
    public String getRevocationReason() {
        return revocationReason;
    }

    /**
     * The reason for revoking the mandate.
     * Possible values are:
     * <ul>
     *   <li>receivedFinal</li>
     *   <li>userAction</li>
     *   <li>obsolescence</li>
     *   <li>refused</li>
     *   <li>revocationAskedByDebitor</li>
     *   <li>revocationAskedByCreditor</li>
     *   <li>deletionAskedByDebitor</li>
     *   <li>deletionAskedByCreditor</li>
     * </ul>
     * <p>
     * Refer to the support page to determine if the property is applicable.
     */
    public void setRevocationReason(String value) {
        this.revocationReason = value;
    }

    /**
     * The reason for revoking the mandate.
     * Possible values are:
     * <ul>
     *   <li>receivedFinal</li>
     *   <li>userAction</li>
     *   <li>obsolescence</li>
     *   <li>refused</li>
     *   <li>revocationAskedByDebitor</li>
     *   <li>revocationAskedByCreditor</li>
     *   <li>deletionAskedByDebitor</li>
     *   <li>deletionAskedByCreditor</li>
     * </ul>
     * <p>
     * Refer to the support page to determine if the property is applicable.
     */
    public RevokeMandateRequest withRevocationReason(String value) {
        this.revocationReason = value;
        return this;
    }
}
