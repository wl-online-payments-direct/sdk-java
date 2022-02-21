/*
 * This class was auto-generated.
 */
package com.onlinepayments.merchant.hostedcheckout;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ResponseException;
import com.onlinepayments.domain.CreateHostedCheckoutRequest;
import com.onlinepayments.domain.CreateHostedCheckoutResponse;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.GetHostedCheckoutResponse;

/**
 * HostedCheckout client. Thread-safe.
 */
public class HostedCheckoutClient extends ApiResource implements HostedCheckoutClientInterface {

	public HostedCheckoutClient(ApiResource parent, Map<String, String> pathContext) {
		super(parent, pathContext);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CreateHostedCheckoutResponse createHostedCheckout(CreateHostedCheckoutRequest body) {
		return createHostedCheckout(body, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CreateHostedCheckoutResponse createHostedCheckout(CreateHostedCheckoutRequest body, CallContext context) {
		String uri = instantiateUri("/v2/{merchantId}/hostedcheckouts", null);
		try {
			return communicator.post(
					uri,
					getClientHeaders(),
					null,
					body,
					CreateHostedCheckoutResponse.class,
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
	public GetHostedCheckoutResponse getHostedCheckout(String hostedCheckoutId) {
		return getHostedCheckout(hostedCheckoutId, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetHostedCheckoutResponse getHostedCheckout(String hostedCheckoutId, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("hostedCheckoutId", hostedCheckoutId);
		String uri = instantiateUri("/v2/{merchantId}/hostedcheckouts/{hostedCheckoutId}", pathContext);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					null,
					GetHostedCheckoutResponse.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}
}
