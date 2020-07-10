/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.merchant.sessions;

import java.util.Map;

import com.ingenico.direct.ApiException;
import com.ingenico.direct.ApiResource;
import com.ingenico.direct.AuthorizationException;
import com.ingenico.direct.CallContext;
import com.ingenico.direct.DirectException;
import com.ingenico.direct.IdempotenceException;
import com.ingenico.direct.ReferenceException;
import com.ingenico.direct.ResponseException;
import com.ingenico.direct.ValidationException;
import com.ingenico.direct.domain.ErrorResponse;
import com.ingenico.direct.domain.SessionRequest;
import com.ingenico.direct.domain.SessionResponse;

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
