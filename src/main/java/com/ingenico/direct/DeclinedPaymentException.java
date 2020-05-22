package com.ingenico.direct;

import com.ingenico.direct.domain.CreatePaymentResponse;
import com.ingenico.direct.domain.PaymentErrorResponse;
import com.ingenico.direct.domain.PaymentResponse;

/**
 * Represents an error response from a create payment call.
 */
@SuppressWarnings("serial")
public class DeclinedPaymentException extends DeclinedTransactionException {

	private final PaymentErrorResponse errors;

	public DeclinedPaymentException(int statusCode, String responseBody, PaymentErrorResponse errors) {
		super(buildMessage(errors), statusCode, responseBody, errors != null ? errors.getErrorId() : null, errors != null ? errors.getErrors() : null);
		this.errors = errors;
	}

	private static String buildMessage(PaymentErrorResponse errors) {
		PaymentResponse payment = errors != null && errors.getPaymentResult() != null ? errors.getPaymentResult().getPayment() : null;
		if (payment != null) {
			return "declined payment '" + payment.getId() + "' with status '" + payment.getStatus() + "'";
		} else {
			return "the Ingenico ePayments platform returned a declined payment response";
		}
	}

	/**
	 * @return The result of creating a payment if available, otherwise returns {@code null}.
	 */
	public CreatePaymentResponse getCreatePaymentResult() {
		return errors == null ? null : errors.getPaymentResult();
	}
}
