/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CsrRequest {

    private String csr;

    /**
     * A Certificate Signing Request (CSR) string that contains the encoded information necessary for generating a digital certificate, including the public key and identity details of the requester.
     */
    public String getCsr() {
        return csr;
    }

    /**
     * A Certificate Signing Request (CSR) string that contains the encoded information necessary for generating a digital certificate, including the public key and identity details of the requester.
     */
    public void setCsr(String value) {
        this.csr = value;
    }

    /**
     * A Certificate Signing Request (CSR) string that contains the encoded information necessary for generating a digital certificate, including the public key and identity details of the requester.
     */
    public CsrRequest withCsr(String value) {
        this.csr = value;
        return this;
    }
}
