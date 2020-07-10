/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.merchant.services;

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
import com.ingenico.direct.domain.TestConnection;

/**
 * Services client. Thread-safe.
 */
public class ServicesClient extends ApiResource implements ServicesClientInterface {

	public ServicesClient(ApiResource parent, Map<String, String> pathContext) {
		super(parent, pathContext);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TestConnection testConnection() {
		return testConnection(null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TestConnection testConnection(CallContext context) {
		String uri = instantiateUri("/v2/{merchantId}/services/testconnection", null);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					null,
					TestConnection.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}
}
