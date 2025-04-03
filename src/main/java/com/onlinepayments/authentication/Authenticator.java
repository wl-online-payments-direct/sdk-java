package com.onlinepayments.authentication;

import java.net.URI;
import java.util.List;

import com.onlinepayments.communication.RequestHeader;

/**
 * Used to authenticate requests to the Online Payments platform. Thread-safe.
 */
public interface Authenticator {

    /**
     * Returns a value that can be used for the "Authorization" header.
     *
     * @param httpMethod The HTTP method.
     * @param resourceUri The {@link URI} of the resource.
     * @param requestHeaders
     *            A list of {@link RequestHeader}s. This list may not be
     *            modified and may not contain headers with the same name.
     */
    String getAuthorization(String httpMethod, URI resourceUri, List<RequestHeader> requestHeaders);
}
