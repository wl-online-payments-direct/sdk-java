/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CreateCertificateResponse {

    private String certificateId;

    private String signedCertificate;

    /**
     * A unique identifier for the certificate generated on the GoPay platform, facilitating effective tracking and management of detokenization actions.
     */
    public String getCertificateId() {
        return certificateId;
    }

    /**
     * A unique identifier for the certificate generated on the GoPay platform, facilitating effective tracking and management of detokenization actions.
     */
    public void setCertificateId(String value) {
        this.certificateId = value;
    }

    /**
     * A unique identifier for the certificate generated on the GoPay platform, facilitating effective tracking and management of detokenization actions.
     */
    public CreateCertificateResponse withCertificateId(String value) {
        this.certificateId = value;
        return this;
    }

    /**
     * The signed certificate in base64 encoded string format, used for secure communication and authentication in API transactions.
     */
    public String getSignedCertificate() {
        return signedCertificate;
    }

    /**
     * The signed certificate in base64 encoded string format, used for secure communication and authentication in API transactions.
     */
    public void setSignedCertificate(String value) {
        this.signedCertificate = value;
    }

    /**
     * The signed certificate in base64 encoded string format, used for secure communication and authentication in API transactions.
     */
    public CreateCertificateResponse withSignedCertificate(String value) {
        this.signedCertificate = value;
        return this;
    }
}
