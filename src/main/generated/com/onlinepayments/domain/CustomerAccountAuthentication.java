/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CustomerAccountAuthentication {

    private String data;

    private String method;

    private String utcTimestamp;

    /**
     * Data about the authentication procedure of the customer to their account with you
     */
    public String getData() {
        return data;
    }

    /**
     * Data about the authentication procedure of the customer to their account with you
     */
    public void setData(String value) {
        this.data = value;
    }

    /**
     * Data about the authentication procedure of the customer to their account with you
     */
    public CustomerAccountAuthentication withData(String value) {
        this.data = value;
        return this;
    }

    /**
     * Authentication used by the customer on your website
     * Possible values are
     * <ul>
     *   <li>guest = no login occurred, customer is logged in as guest</li>
     *   <li>merchant-credentials = the customer logged in using credentials that are specific to you</li>
     *   <li>federated-id = the customer logged in using a federated ID</li>
     *   <li>issuer-credentials = the customer logged in using credentials from the card issuer (of the card used in this transaction)</li>
     *   <li>third-party-authentication = the customer logged in using third-party authentication</li>
     *   <li>fido-authentication = the customer logged in using a FIDO authenticator</li>
     *   <li>cico-b-connect-token = the customer logged in using Check-in/Check-out b.connect</li>
     * </ul>
     */
    public String getMethod() {
        return method;
    }

    /**
     * Authentication used by the customer on your website
     * Possible values are
     * <ul>
     *   <li>guest = no login occurred, customer is logged in as guest</li>
     *   <li>merchant-credentials = the customer logged in using credentials that are specific to you</li>
     *   <li>federated-id = the customer logged in using a federated ID</li>
     *   <li>issuer-credentials = the customer logged in using credentials from the card issuer (of the card used in this transaction)</li>
     *   <li>third-party-authentication = the customer logged in using third-party authentication</li>
     *   <li>fido-authentication = the customer logged in using a FIDO authenticator</li>
     *   <li>cico-b-connect-token = the customer logged in using Check-in/Check-out b.connect</li>
     * </ul>
     */
    public void setMethod(String value) {
        this.method = value;
    }

    /**
     * Authentication used by the customer on your website
     * Possible values are
     * <ul>
     *   <li>guest = no login occurred, customer is logged in as guest</li>
     *   <li>merchant-credentials = the customer logged in using credentials that are specific to you</li>
     *   <li>federated-id = the customer logged in using a federated ID</li>
     *   <li>issuer-credentials = the customer logged in using credentials from the card issuer (of the card used in this transaction)</li>
     *   <li>third-party-authentication = the customer logged in using third-party authentication</li>
     *   <li>fido-authentication = the customer logged in using a FIDO authenticator</li>
     *   <li>cico-b-connect-token = the customer logged in using Check-in/Check-out b.connect</li>
     * </ul>
     */
    public CustomerAccountAuthentication withMethod(String value) {
        this.method = value;
        return this;
    }

    /**
     * Timestamp (YYYYMMDDHHmm) of the authentication of the customer to their account with you
     */
    public String getUtcTimestamp() {
        return utcTimestamp;
    }

    /**
     * Timestamp (YYYYMMDDHHmm) of the authentication of the customer to their account with you
     */
    public void setUtcTimestamp(String value) {
        this.utcTimestamp = value;
    }

    /**
     * Timestamp (YYYYMMDDHHmm) of the authentication of the customer to their account with you
     */
    public CustomerAccountAuthentication withUtcTimestamp(String value) {
        this.utcTimestamp = value;
        return this;
    }
}
