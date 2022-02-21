/*
 * This class was auto-generated.
 */
package com.onlinepayments.merchant.hostedtokenization;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ResponseException;
import com.onlinepayments.domain.CreateHostedTokenizationRequest;
import com.onlinepayments.domain.CreateHostedTokenizationResponse;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.GetHostedTokenizationResponse;

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
