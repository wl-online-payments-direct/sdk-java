/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.merchant.hostedcheckout;

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
import com.ingenico.direct.domain.CreateHostedCheckoutRequest;
import com.ingenico.direct.domain.CreateHostedCheckoutResponse;
import com.ingenico.direct.domain.ErrorResponse;
import com.ingenico.direct.domain.GetHostedCheckoutResponse;

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
