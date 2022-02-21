package com.onlinepayments;

import com.onlinepayments.domain.PayoutErrorResponse;
import com.onlinepayments.domain.PayoutResult;

/**
 * Represents an error response from a payout call.
 */
@SuppressWarnings("serial")
public class DeclinedPayoutException extends DeclinedTransactionException {

	private final PayoutErrorResponse errors;

	public DeclinedPayoutException(int statusCode, String responseBody, PayoutErrorResponse errors) {
		super(buildMessage(errors), statusCode, responseBody, errors != null ? errors.getErrorId() : null, errors != null ? errors.getErrors() : null);
		this.errors = errors;
	}

	private static String buildMessage(PayoutErrorResponse errors) {
		PayoutResult payout = errors != null ? errors.getPayoutResult() : null;
		if (payout != null) {
			return "declined payout '" + payout.getId() + "' with status '" + payout.getStatus() + "'";
		} else {
			return "the Online Payments platform returned a declined payout response";
		}
	}

	/**
	 * @return The result of creating a payout if available, otherwise returns {@code null}.
	 */
	public PayoutResult getPayoutResult() {
		return errors == null ? null : errors.getPayoutResult();
	}
}
