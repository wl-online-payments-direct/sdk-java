package com.ingenico.direct;

import com.ingenico.direct.domain.RefundErrorResponse;
import com.ingenico.direct.domain.RefundResponse;

/**
 * Represents an error response from a refund call.
 */
@SuppressWarnings("serial")
public class DeclinedRefundException extends DeclinedTransactionException {

	private final RefundErrorResponse errors;

	public DeclinedRefundException(int statusCode, String responseBody, RefundErrorResponse errors) {
		super(buildMessage(errors), statusCode, responseBody, errors != null ? errors.getErrorId() : null, errors != null ? errors.getErrors() : null);
		this.errors = errors;
	}

	private static String buildMessage(RefundErrorResponse errors) {
		RefundResponse refund = errors != null ? errors.getRefundResult() : null;
		if (refund != null) {
			return "declined refund '" + refund.getId() + "' with status '" + refund.getStatus() + "'";
		} else {
			return "the Ingenico ePayments platform returned a declined refund response";
		}
	}

	/**
	 * @return The result of creating a refund if available, otherwise returns {@code null}.
	 */
	public RefundResponse getRefundResult() {
		return errors == null ? null : errors.getRefundResult();
	}
}
