/*
 * This class was auto-generated.
 */
package com.onlinepayments.merchant.sessions;

import java.util.Map;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ResponseException;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.SessionRequest;
import com.onlinepayments.domain.SessionResponse;

/**
 * Sessions client. Thread-safe.
 */
public class SessionsClient extends ApiResource implements SessionsClientInterface {

	public SessionsClient(ApiResource parent, Map<String, String> pathContext) {
		super(parent, pathContext);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SessionResponse createSession(SessionRequest body) {
		return createSession(body, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SessionResponse createSession(SessionRequest body, CallContext context) {
		String uri = instantiateUri("/v2/{merchantId}/sessions", null);
		try {
			return communicator.post(
					uri,
					getClientHeaders(),
					null,
					body,
					SessionResponse.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}
}
