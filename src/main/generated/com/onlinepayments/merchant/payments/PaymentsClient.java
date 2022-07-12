/*
 * This class was auto-generated.
 */
package com.onlinepayments.merchant.payments;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.DeclinedPaymentException;
import com.onlinepayments.DeclinedRefundException;
import com.onlinepayments.ResponseException;
import com.onlinepayments.domain.CancelPaymentRequest;
import com.onlinepayments.domain.CancelPaymentResponse;
import com.onlinepayments.domain.CapturePaymentRequest;
import com.onlinepayments.domain.CaptureResponse;
import com.onlinepayments.domain.CapturesResponse;
import com.onlinepayments.domain.CompletePaymentRequest;
import com.onlinepayments.domain.CompletePaymentResponse;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.PaymentDetailsResponse;
import com.onlinepayments.domain.PaymentErrorResponse;
import com.onlinepayments.domain.PaymentResponse;
import com.onlinepayments.domain.RefundErrorResponse;
import com.onlinepayments.domain.RefundRequest;
import com.onlinepayments.domain.RefundResponse;
import com.onlinepayments.domain.RefundsResponse;

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
		CancelPaymentRequest body = null;
		return cancelPayment(paymentId, body, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CancelPaymentResponse cancelPayment(String paymentId, CallContext context) {
		CancelPaymentRequest body = null;
		return cancelPayment(paymentId, body, context);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CancelPaymentResponse cancelPayment(String paymentId, CancelPaymentRequest body) {
		return cancelPayment(paymentId, body, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CancelPaymentResponse cancelPayment(String paymentId, CancelPaymentRequest body, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentId", paymentId);
		String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}/cancel", pathContext);
		try {
			return communicator.post(
					uri,
					getClientHeaders(),
					null,
					body,
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
	public PaymentDetailsResponse getPaymentDetails(String paymentId) {
		return getPaymentDetails(paymentId, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentDetailsResponse getPaymentDetails(String paymentId, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentId", paymentId);
		String uri = instantiateUri("/v2/{merchantId}/payments/{paymentId}/details", pathContext);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					null,
					PaymentDetailsResponse.class,
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
