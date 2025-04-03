/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class FraudResults {

    private String fraudServiceResult;

    /**
     * Resulting advice of the fraud prevention checks. Possible values are:
     * <ul>
     *   <li>accepted - Based on the checks performed the transaction can be accepted</li>
     *   <li>challenged - Based on the checks performed the transaction should be manually reviewed</li>
     *   <li>denied - Based on the checks performed the transaction should be rejected</li>
     *   <li>no-advice - No fraud check was requested/performed</li>
     *   <li>error - The fraud check resulted an error. Note that the fraud check was thus not performed.</li>
     * </ul>
     */
    public String getFraudServiceResult() {
        return fraudServiceResult;
    }

    /**
     * Resulting advice of the fraud prevention checks. Possible values are:
     * <ul>
     *   <li>accepted - Based on the checks performed the transaction can be accepted</li>
     *   <li>challenged - Based on the checks performed the transaction should be manually reviewed</li>
     *   <li>denied - Based on the checks performed the transaction should be rejected</li>
     *   <li>no-advice - No fraud check was requested/performed</li>
     *   <li>error - The fraud check resulted an error. Note that the fraud check was thus not performed.</li>
     * </ul>
     */
    public void setFraudServiceResult(String value) {
        this.fraudServiceResult = value;
    }

    /**
     * Resulting advice of the fraud prevention checks. Possible values are:
     * <ul>
     *   <li>accepted - Based on the checks performed the transaction can be accepted</li>
     *   <li>challenged - Based on the checks performed the transaction should be manually reviewed</li>
     *   <li>denied - Based on the checks performed the transaction should be rejected</li>
     *   <li>no-advice - No fraud check was requested/performed</li>
     *   <li>error - The fraud check resulted an error. Note that the fraud check was thus not performed.</li>
     * </ul>
     */
    public FraudResults withFraudServiceResult(String value) {
        this.fraudServiceResult = value;
        return this;
    }
}
