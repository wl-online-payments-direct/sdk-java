/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.merchant.payments;

import com.ingenico.direct.ApiException;
import com.ingenico.direct.AuthorizationException;
import com.ingenico.direct.CallContext;
import com.ingenico.direct.DeclinedPaymentException;
import com.ingenico.direct.DeclinedRefundException;
import com.ingenico.direct.DirectException;
import com.ingenico.direct.IdempotenceException;
import com.ingenico.direct.ReferenceException;
import com.ingenico.direct.ValidationException;
import com.ingenico.direct.domain.CancelPaymentResponse;
import com.ingenico.direct.domain.CapturePaymentRequest;
import com.ingenico.direct.domain.CaptureResponse;
import com.ingenico.direct.domain.CapturesResponse;
import com.ingenico.direct.domain.CompletePaymentRequest;
import com.ingenico.direct.domain.CompletePaymentResponse;
import com.ingenico.direct.domain.CreatePaymentRequest;
import com.ingenico.direct.domain.CreatePaymentResponse;
import com.ingenico.direct.domain.PaymentResponse;
import com.ingenico.direct.domain.RefundRequest;
import com.ingenico.direct.domain.RefundResponse;
import com.ingenico.direct.domain.RefundsResponse;

/**
 * Payments client. Thread-safe.
 */
public interface PaymentsClientInterface {

	/**
	 * Resource /v2/{merchantId}/payments
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/CreatePaymentApi">Create payment</a>
	 *
	 * @throws DeclinedPaymentException if the Ingenico ePayments platform declined / rejected the payment. The payment result will be available from the exception.
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	CreatePaymentResponse createPayment(CreatePaymentRequest body);

	/**
	 * Resource /v2/{merchantId}/payments
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/CreatePaymentApi">Create payment</a>
	 *
	 * @throws DeclinedPaymentException if the Ingenico ePayments platform declined / rejected the payment. The payment result will be available from the exception.
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	CreatePaymentResponse createPayment(CreatePaymentRequest body, CallContext context);

	/**
	 * Resource /v2/{merchantId}/payments/{paymentId}
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/GetPaymentApi">Get payment</a>
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	PaymentResponse getPayment(String paymentId);

	/**
	 * Resource /v2/{merchantId}/payments/{paymentId}
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/GetPaymentApi">Get payment</a>
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	PaymentResponse getPayment(String paymentId, CallContext context);

	/**
	 * Resource /v2/{merchantId}/payments/{paymentId}/complete
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/CompletePaymentApi">Complete payment</a>
	 *
	 * @throws DeclinedPaymentException if the Ingenico ePayments platform declined / rejected the payment. The payment result will be available from the exception.
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	CompletePaymentResponse completePayment(String paymentId, CompletePaymentRequest body);

	/**
	 * Resource /v2/{merchantId}/payments/{paymentId}/complete
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/CompletePaymentApi">Complete payment</a>
	 *
	 * @throws DeclinedPaymentException if the Ingenico ePayments platform declined / rejected the payment. The payment result will be available from the exception.
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	CompletePaymentResponse completePayment(String paymentId, CompletePaymentRequest body, CallContext context);

	/**
	 * Resource /v2/{merchantId}/payments/{paymentId}/cancel
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/CancelPaymentApi">Cancel payment</a>
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	CancelPaymentResponse cancelPayment(String paymentId);

	/**
	 * Resource /v2/{merchantId}/payments/{paymentId}/cancel
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/CancelPaymentApi">Cancel payment</a>
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	CancelPaymentResponse cancelPayment(String paymentId, CallContext context);

	/**
	 * Resource /v2/{merchantId}/payments/{paymentId}/refund
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/RefundPaymentApi">Refund payment</a>
	 *
	 * @throws DeclinedRefundException if the Ingenico ePayments platform declined / rejected the refund. The refund result will be available from the exception.
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	RefundResponse refundPayment(String paymentId, RefundRequest body);

	/**
	 * Resource /v2/{merchantId}/payments/{paymentId}/refund
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/RefundPaymentApi">Refund payment</a>
	 *
	 * @throws DeclinedRefundException if the Ingenico ePayments platform declined / rejected the refund. The refund result will be available from the exception.
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	RefundResponse refundPayment(String paymentId, RefundRequest body, CallContext context);

	/**
	 * Resource /v2/{merchantId}/payments/{paymentId}/capture
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/CapturePaymentApi">Capture payment</a>
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	CaptureResponse capturePayment(String paymentId, CapturePaymentRequest body);

	/**
	 * Resource /v2/{merchantId}/payments/{paymentId}/capture
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/CapturePaymentApi">Capture payment</a>
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	CaptureResponse capturePayment(String paymentId, CapturePaymentRequest body, CallContext context);

	/**
	 * Resource /v2/{merchantId}/payments/{paymentId}/captures
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/GetCapturesApi">Get Captures Api</a>
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	CapturesResponse getCaptures(String paymentId);

	/**
	 * Resource /v2/{merchantId}/payments/{paymentId}/captures
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/GetCapturesApi">Get Captures Api</a>
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	CapturesResponse getCaptures(String paymentId, CallContext context);

	/**
	 * Resource /v2/{merchantId}/payments/{paymentId}/refunds
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/GetRefundsApi">Get Refunds Api</a>
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	RefundsResponse getRefunds(String paymentId);

	/**
	 * Resource /v2/{merchantId}/payments/{paymentId}/refunds
	 * - <a href="https://support.direct.ingenico.com/documentation/api/reference/index.html#operation/GetRefundsApi">Get Refunds Api</a>
	 *
	 * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
	 * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
	 * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
	 * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
	 *            or there was a conflict (HTTP status code 404, 409 or 410)
	 * @throws DirectException if something went wrong at the Ingenico ePayments platform,
	 *            the Ingenico ePayments platform was unable to process a message from a downstream partner/acquirer,
	 *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
	 * @throws ApiException if the Ingenico ePayments platform returned any other error
	 */
	RefundsResponse getRefunds(String paymentId, CallContext context);
}
