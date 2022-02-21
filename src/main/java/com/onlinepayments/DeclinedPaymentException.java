package com.onlinepayments;

import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.PaymentErrorResponse;
import com.onlinepayments.domain.PaymentResponse;

/**
 * Represents an error response from a create payment call.
 */
@SuppressWarnings("serial")
public class DeclinedPaymentException extends DeclinedTransactionException {

	private final PaymentErrorResponse errorResponse;

	public DeclinedPaymentException(int statusCode, String responseBody, PaymentErrorResponse errorResponse) {
		super(buildMessage(errorResponse), statusCode, responseBody, errorResponse != null ? errorResponse.getErrorId() : null, errorResponse != null ? errorResponse.getErrors() : null);
		this.errorResponse = errorResponse;
	}

	private static String buildMessage(PaymentErrorResponse errors) {
		PaymentResponse payment = errors != null && errors.getPaymentResult() != null ? errors.getPaymentResult().getPayment() : null;
		if (payment != null) {
			return "declined payment '" + payment.getId() + "' with status '" + payment.getStatus() + "'";
		} else {
			return "the Online Payments platform returned a declined payment response";
		}
	}

	/**
	 * @return The result of creating a payment if available, otherwise returns {@code null}.
	 */
	public CreatePaymentResponse getCreatePaymentResult() {
		return errorResponse == null ? null : errorResponse.getPaymentResult();
	}
}
