/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.merchant.payments;

import java.util.Map;
import java.util.TreeMap;

import com.ingenico.direct.ApiException;
import com.ingenico.direct.ApiResource;
import com.ingenico.direct.AuthorizationException;
import com.ingenico.direct.CallContext;
import com.ingenico.direct.DeclinedPaymentException;
import com.ingenico.direct.DeclinedRefundException;
import com.ingenico.direct.DirectException;
import com.ingenico.direct.IdempotenceException;
import com.ingenico.direct.ReferenceException;
import com.ingenico.direct.ResponseException;
import com.ingenico.direct.ValidationException;
import com.ingenico.direct.domain.CancelPaymentResponse;
import com.ingenico.direct.domain.CapturePaymentRequest;
import com.ingenico.direct.domain.CaptureResponse;
import com.ingenico.direct.domain.CapturesResponse;
import com.ingenico.direct.domain.CompletePaymentRequest;
import com.ingenico.direct.domain.CompletePaymentResponse;
import com.ingenico.direct.domain.CreatePaymentRequest;
import com.ingenico.direct.domain.CreatePaymentResponse;
import com.ingenico.direct.domain.ErrorResponse;
import com.ingenico.direct.domain.PaymentErrorResponse;
import com.ingenico.direct.domain.PaymentResponse;
import com.ingenico.direct.domain.RefundErrorResponse;
import com.ingenico.direct.domain.RefundRequest;
import com.ingenico.direct.domain.RefundResponse;
import com.ingenico.direct.domain.RefundsResponse;

/**
 * Payments client. Thread-safe.
 */
public class PaymentsClient extends ApiResource implements PaymentsClientInterface {

	public PaymentsClient(ApiResource parent, Map<String, String> pathContext) {
		super(parent, pathContext);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CreatePaymentResponse createPayment(CreatePaymentRequest body) {
		return createPayment(body, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CreatePaymentResponse createPayment(CreatePaymentRequest body, CallContext context) {
		String uri = instantiateUri("/v2/{merchantId}/payments", null);
		try {
			return communicator.post(
					uri,
					getClientHeaders(),
					null,
					body,
					CreatePaymentResponse.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = PaymentErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentResponse getPayment(String paymentId) {
		return getPayment(paymentId, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentResponse getPayment(String paymentId, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentId", paymentId);
		String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}", pathContext);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					null,
					PaymentResponse.class,
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
	public CompletePaymentResponse completePayment(String paymentId, CompletePaymentRequest body) {
		return completePayment(paymentId, body, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CompletePaymentResponse completePayment(String paymentId, CompletePaymentRequest body, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentId", paymentId);
		String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}/complete", pathContext);
		try {
			return communicator.post(
					uri,
					getClientHeaders(),
					null,
					body,
					CompletePaymentResponse.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = PaymentErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CancelPaymentResponse cancelPayment(String paymentId) {
		return cancelPayment(paymentId, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CancelPaymentResponse cancelPayment(String paymentId, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentId", paymentId);
		String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}/cancel", pathContext);
		try {
			return communicator.post(
					uri,
					getClientHeaders(),
					null,
					null,
					CancelPaymentResponse.class,
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
	public RefundResponse refundPayment(String paymentId, RefundRequest body) {
		return refundPayment(paymentId, body, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefundResponse refundPayment(String paymentId, RefundRequest body, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentId", paymentId);
		String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}/refund", pathContext);
		try {
			return communicator.post(
					uri,
					getClientHeaders(),
					null,
					body,
					RefundResponse.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = RefundErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaptureResponse capturePayment(String paymentId, CapturePaymentRequest body) {
		return capturePayment(paymentId, body, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaptureResponse capturePayment(String paymentId, CapturePaymentRequest body, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentId", paymentId);
		String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}/capture", pathContext);
		try {
			return communicator.post(
					uri,
					getClientHeaders(),
					null,
					body,
					CaptureResponse.class,
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
	public CapturesResponse getCaptures(String paymentId) {
		return getCaptures(paymentId, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CapturesResponse getCaptures(String paymentId, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentId", paymentId);
		String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}/captures", pathContext);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					null,
					CapturesResponse.class,
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
	public RefundsResponse getRefunds(String paymentId) {
		return getRefunds(paymentId, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefundsResponse getRefunds(String paymentId, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentId", paymentId);
		String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}/refunds", pathContext);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					null,
					RefundsResponse.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}
}
