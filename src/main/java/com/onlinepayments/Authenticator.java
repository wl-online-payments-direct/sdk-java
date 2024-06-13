package com.onlinepayments;

import java.net.URI;
import java.util.List;

/**
 * Used to sign requests to the Online Payments platform. Thread-safe.
 */
public interface Authenticator {

	/**
	 * Creates a signature for the simple security model.
	 *
	 * @param httpMethod The HTTP method.
	 * @param resourceUri The {@link URI} of the resource.
	 * @param requestHeaders
	 *            A list of {@link RequestHeader}s. This list may not be
	 *            modified and may not contain headers with the same name.
	 * @return The authentication signature that can be used as Authentication header
	 */
	String createSimpleAuthenticationSignature(String httpMethod, URI resourceUri, List<RequestHeader> requestHeaders);
}
