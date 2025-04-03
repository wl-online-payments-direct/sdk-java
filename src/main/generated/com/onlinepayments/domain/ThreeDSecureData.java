/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class ThreeDSecureData {

    private String acsTransactionId;

    private String method;

    private String utcTimestamp;

    /**
     * The ACS Transaction ID for a prior 3-D Secure authenticated transaction (for example, the first recurring transaction that was authenticated with the customer)
     */
    public String getAcsTransactionId() {
        return acsTransactionId;
    }

    /**
     * The ACS Transaction ID for a prior 3-D Secure authenticated transaction (for example, the first recurring transaction that was authenticated with the customer)
     */
    public void setAcsTransactionId(String value) {
        this.acsTransactionId = value;
    }

    /**
     * The ACS Transaction ID for a prior 3-D Secure authenticated transaction (for example, the first recurring transaction that was authenticated with the customer)
     */
    public ThreeDSecureData withAcsTransactionId(String value) {
        this.acsTransactionId = value;
        return this;
    }

    /**
     * Method of authentication used for this transaction. Possible values:
     * <ul>
     *   <li>frictionless = The authentication went without a challenge</li>
     *   <li>challenged = Cardholder was challenged</li>
     *   <li>avs-verified = The authentication was verified by AVS</li>
     *   <li>other = Another issuer method was used to authenticate this transaction</li>
     * </ul>
     */
    public String getMethod() {
        return method;
    }

    /**
     * Method of authentication used for this transaction. Possible values:
     * <ul>
     *   <li>frictionless = The authentication went without a challenge</li>
     *   <li>challenged = Cardholder was challenged</li>
     *   <li>avs-verified = The authentication was verified by AVS</li>
     *   <li>other = Another issuer method was used to authenticate this transaction</li>
     * </ul>
     */
    public void setMethod(String value) {
        this.method = value;
    }

    /**
     * Method of authentication used for this transaction. Possible values:
     * <ul>
     *   <li>frictionless = The authentication went without a challenge</li>
     *   <li>challenged = Cardholder was challenged</li>
     *   <li>avs-verified = The authentication was verified by AVS</li>
     *   <li>other = Another issuer method was used to authenticate this transaction</li>
     * </ul>
     */
    public ThreeDSecureData withMethod(String value) {
        this.method = value;
        return this;
    }

    /**
     * Timestamp in UTC (YYYYMMDDHHmm) of the 3-D Secure authentication of this transaction
     */
    public String getUtcTimestamp() {
        return utcTimestamp;
    }

    /**
     * Timestamp in UTC (YYYYMMDDHHmm) of the 3-D Secure authentication of this transaction
     */
    public void setUtcTimestamp(String value) {
        this.utcTimestamp = value;
    }

    /**
     * Timestamp in UTC (YYYYMMDDHHmm) of the 3-D Secure authentication of this transaction
     */
    public ThreeDSecureData withUtcTimestamp(String value) {
        this.utcTimestamp = value;
        return this;
    }
}
