/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.merchant.hostedtokenization;

import java.util.Map;
import java.util.TreeMap;

import com.ingenico.direct.ApiException;
import com.ingenico.direct.ApiResource;
import com.ingenico.direct.AuthorizationException;
import com.ingenico.direct.CallContext;
import com.ingenico.direct.DirectException;
import com.ingenico.direct.IdempotenceException;
import com.ingenico.direct.ReferenceException;
import com.ingenico.direct.ResponseException;
import com.ingenico.direct.ValidationException;
import com.ingenico.direct.domain.CreateHostedTokenizationRequest;
import com.ingenico.direct.domain.CreateHostedTokenizationResponse;
import com.ingenico.direct.domain.ErrorResponse;
import com.ingenico.direct.domain.GetHostedTokenizationResponse;

/**
 * HostedTokenization client. Thread-safe.
 */
public class HostedTokenizationClient extends ApiResource implements HostedTokenizationClientInterface {

	public HostedTokenizationClient(ApiResource parent, Map<String, String> pathContext) {
		super(parent, pathContext);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CreateHostedTokenizationResponse createHostedTokenization(CreateHostedTokenizationRequest body) {
		return createHostedTokenization(body, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CreateHostedTokenizationResponse createHostedTokenization(CreateHostedTokenizationRequest body, CallContext context) {
		String uri = instantiateUri("/v2/{merchantId}/hostedtokenizations", null);
		try {
			return communicator.post(
					uri,
					getClientHeaders(),
					null,
					body,
					CreateHostedTokenizationResponse.class,
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
	public GetHostedTokenizationResponse getHostedTokenization(String hostedTokenizationId) {
		return getHostedTokenization(hostedTokenizationId, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetHostedTokenizationResponse getHostedTokenization(String hostedTokenizationId, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("hostedTokenizationId", hostedTokenizationId);
		String uri = instantiateUri("/v2/{merchantId}/hostedtokenizations/{hostedTokenizationId}", pathContext);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					null,
					GetHostedTokenizationResponse.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}
}
