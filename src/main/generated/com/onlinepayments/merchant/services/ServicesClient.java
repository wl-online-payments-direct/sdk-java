/*
 * This class was auto-generated.
 */
package com.onlinepayments.merchant.services;

import java.util.Map;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ResponseException;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.GetIINDetailsRequest;
import com.onlinepayments.domain.GetIINDetailsResponse;
import com.onlinepayments.domain.TestConnection;

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetIINDetailsResponse getIINDetails(GetIINDetailsRequest body) {
		return getIINDetails(body, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetIINDetailsResponse getIINDetails(GetIINDetailsRequest body, CallContext context) {
		String uri = instantiateUri("/v2/{merchantId}/services/getIINdetails", null);
		try {
			return communicator.post(
					uri,
					getClientHeaders(),
					null,
					body,
					GetIINDetailsResponse.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}
}
