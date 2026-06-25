package com.onlinepayments.it.util.tokenization;

import com.onlinepayments.domain.CsrRequest;

public class CsrRequestBuilder {

    private static final String VALID_CSR =
            "-----BEGIN CERTIFICATE REQUEST-----\n"
            + "MIICljCCAX4CAQAwDQYJKoZIhvcNAQEBBQAwDTELMAkGA1UEAwwCQ0EwggEiMA0G\n"
            + "CSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCQfbsVzv0L8pKH2l8q6EJf0fzxnDlW\n"
            + "-----END CERTIFICATE REQUEST-----";

    private String csr = VALID_CSR;

    public CsrRequestBuilder withCsr(String csr) {
        this.csr = csr;
        return this;
    }

    public CsrRequest build() {
        return new CsrRequest()
            .withCsr(csr);
    }
}
