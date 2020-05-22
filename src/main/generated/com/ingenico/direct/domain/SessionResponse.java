/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.domain;

public class SessionResponse {

	private String assetUrl = null;

	private String clientApiUrl = null;

	private String clientSessionId = null;

	private String customerId = null;

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
}
