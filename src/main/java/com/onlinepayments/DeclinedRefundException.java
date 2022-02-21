package com.onlinepayments;

import com.onlinepayments.domain.RefundErrorResponse;
import com.onlinepayments.domain.RefundResponse;

/**
 * Represents an error response from a refund call.
 */
@SuppressWarnings("serial")
public class DeclinedRefundException extends DeclinedTransactionException {

	private final RefundErrorResponse errorResponse;

	public DeclinedRefundException(int statusCode, String responseBody, RefundErrorResponse errorResponse) {
		super(buildMessage(errorResponse), statusCode, responseBody, errorResponse != null ? errorResponse.getErrorId() : null, errorResponse != null ? errorResponse.getErrors() : null);
		this.errorResponse = errorResponse;
	}

	private static String buildMessage(RefundErrorResponse errors) {
		RefundResponse refund = errors != null ? errors.getRefundResult() : null;
		if (refund != null) {
			return "declined refund '" + refund.getId() + "' with status '" + refund.getStatus() + "'";
		} else {
			return "the Online Payments platform returned a declined refund response";
		}
	}

	/**
	 * @return The result of creating a refund if available, otherwise returns {@code null}.
	 */
	public RefundResponse getRefundResult() {
		return errorResponse == null ? null : errorResponse.getRefundResult();
	}
}
