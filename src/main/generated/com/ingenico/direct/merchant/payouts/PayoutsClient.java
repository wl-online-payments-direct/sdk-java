/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.merchant.payouts;

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
import com.ingenico.direct.domain.CreatePayoutRequest;
import com.ingenico.direct.domain.ErrorResponse;
import com.ingenico.direct.domain.PayoutResponse;

/**
 * Payouts client. Thread-safe.
 */
public class PayoutsClient extends ApiResource implements PayoutsClientInterface {

	public PayoutsClient(ApiResource parent, Map<String, String> pathContext) {
		super(parent, pathContext);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PayoutResponse createPayout(CreatePayoutRequest body) {
		return createPayout(body, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PayoutResponse createPayout(CreatePayoutRequest body, CallContext context) {
		String uri = instantiateUri("/v2/{merchantId}/payouts", null);
		try {
			return communicator.post(
					uri,
					getClientHeaders(),
					null,
					body,
					PayoutResponse.class,
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
	public PayoutResponse getPayout(String payoutId) {
		return getPayout(payoutId, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PayoutResponse getPayout(String payoutId, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("payoutId", payoutId);
		String uri = instantiateUri("/v2/{merchantId}/payouts/{payoutId}", pathContext);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					null,
					PayoutResponse.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}
}
