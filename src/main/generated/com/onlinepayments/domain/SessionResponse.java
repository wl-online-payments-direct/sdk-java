/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class SessionResponse {

    private String assetUrl;

    private String clientApiUrl;

    private String clientSessionId;

    private String customerId;

    private List<String> invalidTokens;

    /**
     * The datacenter-specific base url for assets. This value needs to be passed to the Client SDK to make sure that the client software connects to the right datacenter.
     */
    public String getAssetUrl() {
        return assetUrl;
    }

    /**
     * The datacenter-specific base url for assets. This value needs to be passed to the Client SDK to make sure that the client software connects to the right datacenter.
     */
    public void setAssetUrl(String value) {
        this.assetUrl = value;
    }

    /**
     * The datacenter-specific base url for assets. This value needs to be passed to the Client SDK to make sure that the client software connects to the right datacenter.
     */
    public SessionResponse withAssetUrl(String value) {
        this.assetUrl = value;
        return this;
    }

    /**
     * The datacenter-specific base url for client requests. This value needs to be passed to the Client SDK to make sure that the client software connects to the right datacenter.
     */
    public String getClientApiUrl() {
        return clientApiUrl;
    }

    /**
     * The datacenter-specific base url for client requests. This value needs to be passed to the Client SDK to make sure that the client software connects to the right datacenter.
     */
    public void setClientApiUrl(String value) {
        this.clientApiUrl = value;
    }

    /**
     * The datacenter-specific base url for client requests. This value needs to be passed to the Client SDK to make sure that the client software connects to the right datacenter.
     */
    public SessionResponse withClientApiUrl(String value) {
        this.clientApiUrl = value;
        return this;
    }

    /**
     * The identifier of the session that has been created.
     */
    public String getClientSessionId() {
        return clientSessionId;
    }

    /**
     * The identifier of the session that has been created.
     */
    public void setClientSessionId(String value) {
        this.clientSessionId = value;
    }

    /**
     * The identifier of the session that has been created.
     */
    public SessionResponse withClientSessionId(String value) {
        this.clientSessionId = value;
        return this;
    }

    /**
     * The session is built up around the customer in the form of the customerId. All client APIs use this customerId in the URI to identify the customer.
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * The session is built up around the customer in the form of the customerId. All client APIs use this customerId in the URI to identify the customer.
     */
    public void setCustomerId(String value) {
        this.customerId = value;
    }

    /**
     * The session is built up around the customer in the form of the customerId. All client APIs use this customerId in the URI to identify the customer.
     */
    public SessionResponse withCustomerId(String value) {
        this.customerId = value;
        return this;
    }

    public List<String> getInvalidTokens() {
        return invalidTokens;
    }

    public void setInvalidTokens(List<String> value) {
        this.invalidTokens = value;
    }

    public SessionResponse withInvalidTokens(List<String> value) {
        this.invalidTokens = value;
        return this;
    }
}
