package com.ingenico.direct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.ingenico.direct.domain.APIError;
import com.ingenico.direct.domain.ErrorResponse;
import com.ingenico.direct.domain.PaymentErrorResponse;
import com.ingenico.direct.domain.RefundErrorResponse;

/**
 * Base class of all Ingenico ePayments platform API resources.
 */
public abstract class ApiResource {

	private final ApiResource parent;
	protected final Communicator communicator;
	private final Map<String, String> pathContext;
	protected final String clientMetaInfo;

	protected ApiResource(ApiResource parent, Map<String, String> pathContext) {
		if (parent == null) {
			throw new IllegalArgumentException("parent is required");
		}
		this.parent = parent;
		this.communicator = parent.communicator;
		this.pathContext = pathContext;
		this.clientMetaInfo = parent.clientMetaInfo;
	}

	protected ApiResource(Communicator communicator, String clientMetaInfo, Map<String, String> pathContext) {
		if (communicator == null) {
			throw new IllegalArgumentException("communicator is required");
		}
		this.parent = null;
		this.communicator = communicator;
		this.pathContext = pathContext;
		this.clientMetaInfo = clientMetaInfo;
	}

	protected List<RequestHeader> getClientHeaders() {
		if (clientMetaInfo == null) {
			return null;
		}

		List<RequestHeader> clientHeaders = new ArrayList<RequestHeader>();
		clientHeaders.add(new RequestHeader("X-GCS-ClientMetaInfo", clientMetaInfo));
		return clientHeaders;
	}

	protected String instantiateUri(String uri, Map<String, String> pathContext) {
		uri = replaceAll(uri, pathContext);
		return instantiateUri(uri);
	}

	private String instantiateUri(String uri) {
		uri = replaceAll(uri, pathContext);
		return parent == null
				? uri
				: parent.instantiateUri(uri);
	}

	private String replaceAll(String uri, Map<String, String> pathContext) {
		if (pathContext != null) {
			for (Map.Entry<String, String> entry : pathContext.entrySet()) {
				uri = uri.replace(String.format("{%s}", entry.getKey()), entry.getValue());
			}
		}
		return uri;
	}

	protected RuntimeException createException(int statusCode, String responseBody, Object errorObject, CallContext context) {
		if (errorObject instanceof PaymentErrorResponse && ((PaymentErrorResponse) errorObject).getPaymentResult() != null) {
			return new DeclinedPaymentException(statusCode, responseBody, (PaymentErrorResponse) errorObject);
		} else if (errorObject instanceof RefundErrorResponse && ((RefundErrorResponse) errorObject).getRefundResult() != null) {
			return new DeclinedRefundException(statusCode, responseBody, (RefundErrorResponse) errorObject);
		}

		String errorId;
		List<APIError> errors;
		if (errorObject instanceof PaymentErrorResponse) {
			PaymentErrorResponse paymentErrorResponse = (PaymentErrorResponse) errorObject;
			errorId = paymentErrorResponse.getErrorId();
			errors = paymentErrorResponse.getErrors();
		} else if (errorObject instanceof RefundErrorResponse) {
			RefundErrorResponse refundErrorResponse = (RefundErrorResponse) errorObject;
			errorId = refundErrorResponse.getErrorId();
			errors = refundErrorResponse.getErrors();
		} else if (errorObject instanceof ErrorResponse) {
			ErrorResponse errorResponse = (ErrorResponse) errorObject;
			errorId = errorResponse.getErrorId();
			errors = errorResponse.getErrors();
		} else if (errorObject == null) {
			errorId = null;
			errors = Collections.emptyList();
		} else {
			throw new IllegalArgumentException("unsupported error object type: " + errorObject.getClass().getName());
		}

		switch (statusCode) {
			case 400:
				return new ValidationException(statusCode, responseBody, errorId, errors);
			case 403:
				return new AuthorizationException(statusCode, responseBody, errorId, errors);
			case 404:
				return new ReferenceException(statusCode, responseBody, errorId, errors);
			case 409:
				if (isIdempotenceError(errors, context)) {
					String idempotenceKey = context.getIdempotenceKey();
					Long idempotenceRequestTimestamp = context.getIdempotenceRequestTimestamp();
					return new IdempotenceException(idempotenceKey, idempotenceRequestTimestamp, statusCode, responseBody, errorId, errors);
				} else {
					return new ReferenceException(statusCode, responseBody, errorId, errors);
				}
			case 410:
				return new ReferenceException(statusCode, responseBody, errorId, errors);
			case 500:
				return new DirectException(statusCode, responseBody, errorId, errors);
			case 502:
				return new DirectException(statusCode, responseBody, errorId, errors);
			case 503:
				return new DirectException(statusCode, responseBody, errorId, errors);
			default:
				return new ApiException(statusCode, responseBody, errorId, errors);
		}
	}

	private boolean isIdempotenceError(List<APIError> errors, CallContext context) {
		return context != null
				&& context.getIdempotenceKey() != null
				&& errors.size() == 1
				&& "1409".equals(errors.get(0).getCode());
	}
}
