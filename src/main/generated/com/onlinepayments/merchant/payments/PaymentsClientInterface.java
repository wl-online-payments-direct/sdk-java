/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.payments;

import com.onlinepayments.ApiException;
import com.onlinepayments.AuthorizationException;
import com.onlinepayments.CallContext;
import com.onlinepayments.DeclinedPaymentException;
import com.onlinepayments.DeclinedRefundException;
import com.onlinepayments.IdempotenceException;
import com.onlinepayments.PlatformException;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.CancelPaymentRequest;
import com.onlinepayments.domain.CancelPaymentResponse;
import com.onlinepayments.domain.CapturePaymentRequest;
import com.onlinepayments.domain.CaptureResponse;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.CreatePaymentResponse;
import com.onlinepayments.domain.PaymentDetailsResponse;
import com.onlinepayments.domain.PaymentResponse;
import com.onlinepayments.domain.RefundRequest;
import com.onlinepayments.domain.RefundResponse;

/**
 * Payments client. Thread-safe.
 */
public interface PaymentsClientInterface {

    /**
     * Resource /v2/{merchantId}/payments - Create payment
     *
     * @param body CreatePaymentRequest
     * @return CreatePaymentResponse
     * @throws DeclinedPaymentException if the payment platform declined / rejected the payment. The payment result will be available from the exception.
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    CreatePaymentResponse createPayment(CreatePaymentRequest body);

    /**
     * Resource /v2/{merchantId}/payments - Create payment
     *
     * @param body CreatePaymentRequest
     * @param context CallContext
     * @return CreatePaymentResponse
     * @throws DeclinedPaymentException if the payment platform declined / rejected the payment. The payment result will be available from the exception.
     * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    CreatePaymentResponse createPayment(CreatePaymentRequest body, CallContext context);

    /**
     * Resource /v2/{merchantId}/payments/{paymentId} - Get payment
     *
     * @param paymentId String
     * @return PaymentResponse
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    PaymentResponse getPayment(String paymentId);

    /**
     * Resource /v2/{merchantId}/payments/{paymentId} - Get payment
     *
     * @param paymentId String
     * @param context CallContext
     * @return PaymentResponse
     * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    PaymentResponse getPayment(String paymentId, CallContext context);

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/details - Get payment details
     *
     * @param paymentId String
     * @return PaymentDetailsResponse
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    PaymentDetailsResponse getPaymentDetails(String paymentId);

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/details - Get payment details
     *
     * @param paymentId String
     * @param context CallContext
     * @return PaymentDetailsResponse
     * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    PaymentDetailsResponse getPaymentDetails(String paymentId, CallContext context);

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/cancel - Cancel payment
     *
     * @param paymentId String
     * @param body CancelPaymentRequest
     * @return CancelPaymentResponse
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    CancelPaymentResponse cancelPayment(String paymentId, CancelPaymentRequest body);

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/cancel - Cancel payment
     *
     * @param paymentId String
     * @param body CancelPaymentRequest
     * @param context CallContext
     * @return CancelPaymentResponse
     * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    CancelPaymentResponse cancelPayment(String paymentId, CancelPaymentRequest body, CallContext context);

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/capture - Capture payment
     *
     * @param paymentId String
     * @param body CapturePaymentRequest
     * @return CaptureResponse
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    CaptureResponse capturePayment(String paymentId, CapturePaymentRequest body);

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/capture - Capture payment
     *
     * @param paymentId String
     * @param body CapturePaymentRequest
     * @param context CallContext
     * @return CaptureResponse
     * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    CaptureResponse capturePayment(String paymentId, CapturePaymentRequest body, CallContext context);

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/refund - Refund payment
     *
     * @param paymentId String
     * @param body RefundRequest
     * @return RefundResponse
     * @throws DeclinedRefundException if the payment platform declined / rejected the refund. The refund result will be available from the exception.
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    RefundResponse refundPayment(String paymentId, RefundRequest body);

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/refund - Refund payment
     *
     * @param paymentId String
     * @param body RefundRequest
     * @param context CallContext
     * @return RefundResponse
     * @throws DeclinedRefundException if the payment platform declined / rejected the refund. The refund result will be available from the exception.
     * @throws IdempotenceException if an idempotent request caused a conflict (HTTP status code 409)
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    RefundResponse refundPayment(String paymentId, RefundRequest body, CallContext context);
}
