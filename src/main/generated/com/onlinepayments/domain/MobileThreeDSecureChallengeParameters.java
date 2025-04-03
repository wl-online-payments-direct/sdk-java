/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class MobileThreeDSecureChallengeParameters {

    private String acsReferenceNumber;

    private String acsSignedContent;

    private String acsTransactionId;

    private String threeDServerTransactionId;

    /**
     * The unique identifier assigned by the EMVCo Secretariat upon testing and approval.
     */
    public String getAcsReferenceNumber() {
        return acsReferenceNumber;
    }

    /**
     * The unique identifier assigned by the EMVCo Secretariat upon testing and approval.
     */
    public void setAcsReferenceNumber(String value) {
        this.acsReferenceNumber = value;
    }

    /**
     * The unique identifier assigned by the EMVCo Secretariat upon testing and approval.
     */
    public MobileThreeDSecureChallengeParameters withAcsReferenceNumber(String value) {
        this.acsReferenceNumber = value;
        return this;
    }

    /**
     * Contains the JWS object created by the ACS for the challenge (ARes).
     */
    public String getAcsSignedContent() {
        return acsSignedContent;
    }

    /**
     * Contains the JWS object created by the ACS for the challenge (ARes).
     */
    public void setAcsSignedContent(String value) {
        this.acsSignedContent = value;
    }

    /**
     * Contains the JWS object created by the ACS for the challenge (ARes).
     */
    public MobileThreeDSecureChallengeParameters withAcsSignedContent(String value) {
        this.acsSignedContent = value;
        return this;
    }

    /**
     * The ACS Transaction ID for a prior 3-D Secure authenticated transaction (for example, the first recurring transaction that was authenticated with the customer).
     */
    public String getAcsTransactionId() {
        return acsTransactionId;
    }

    /**
     * The ACS Transaction ID for a prior 3-D Secure authenticated transaction (for example, the first recurring transaction that was authenticated with the customer).
     */
    public void setAcsTransactionId(String value) {
        this.acsTransactionId = value;
    }

    /**
     * The ACS Transaction ID for a prior 3-D Secure authenticated transaction (for example, the first recurring transaction that was authenticated with the customer).
     */
    public MobileThreeDSecureChallengeParameters withAcsTransactionId(String value) {
        this.acsTransactionId = value;
        return this;
    }

    /**
     * The 3-D Secure version 2 transaction ID that is used for the 3D Authentication
     */
    public String getThreeDServerTransactionId() {
        return threeDServerTransactionId;
    }

    /**
     * The 3-D Secure version 2 transaction ID that is used for the 3D Authentication
     */
    public void setThreeDServerTransactionId(String value) {
        this.threeDServerTransactionId = value;
    }

    /**
     * The 3-D Secure version 2 transaction ID that is used for the 3D Authentication
     */
    public MobileThreeDSecureChallengeParameters withThreeDServerTransactionId(String value) {
        this.threeDServerTransactionId = value;
        return this;
    }
}
