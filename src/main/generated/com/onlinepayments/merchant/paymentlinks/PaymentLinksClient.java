/*
 * This class was auto-generated.
 */
package com.onlinepayments.merchant.paymentlinks;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ResponseException;
import com.onlinepayments.domain.CreatePaymentLinkRequest;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.PaymentLinkResponse;

/**
 * PaymentLinks client. Thread-safe.
 */
public class PaymentLinksClient extends ApiResource implements PaymentLinksClientInterface {

	public PaymentLinksClient(ApiResource parent, Map<String, String> pathContext) {
		super(parent, pathContext);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentLinkResponse createPaymentLink(CreatePaymentLinkRequest body) {
		return createPaymentLink(body, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentLinkResponse createPaymentLink(CreatePaymentLinkRequest body, CallContext context) {
		String uri = instantiateUri("/v2/{merchantId}/paymentlinks", null);
		try {
			return communicator.post(
					uri,
					getClientHeaders(),
					null,
					body,
					PaymentLinkResponse.class,
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
	public PaymentLinkResponse getPaymentLinkById(String paymentLinkId) {
		return getPaymentLinkById(paymentLinkId, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentLinkResponse getPaymentLinkById(String paymentLinkId, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentLinkId", paymentLinkId);
		String uri = instantiateUri("/v2/{merchantId}/paymentlinks/{paymentLinkId}", pathContext);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					null,
					PaymentLinkResponse.class,
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
	public void cancelPaymentLinkById(String paymentLinkId) {
		cancelPaymentLinkById(paymentLinkId, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cancelPaymentLinkById(String paymentLinkId, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentLinkId", paymentLinkId);
		String uri = instantiateUri("/v2/{merchantId}/paymentlinks/{paymentLinkId}/cancel", pathContext);
		try {
			communicator.post(
					uri,
					getClientHeaders(),
					null,
					null,
					void.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}
}
