/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.complete;

import com.onlinepayments.ApiException;
import com.onlinepayments.AuthorizationException;
import com.onlinepayments.CallContext;
import com.onlinepayments.DeclinedPaymentException;
import com.onlinepayments.IdempotenceException;
import com.onlinepayments.PlatformException;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.CompletePaymentRequest;
import com.onlinepayments.domain.CompletePaymentResponse;

/**
 * Complete client. Thread-safe.
 */
public interface CompleteClientInterface {

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/complete - Complete payment
     *
     * @param paymentId String
     * @param body CompletePaymentRequest
     * @return CompletePaymentResponse
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
    CompletePaymentResponse completePayment(String paymentId, CompletePaymentRequest body);

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/complete - Complete payment
     *
     * @param paymentId String
     * @param body CompletePaymentRequest
     * @param context CallContext
     * @return CompletePaymentResponse
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
    CompletePaymentResponse completePayment(String paymentId, CompletePaymentRequest body, CallContext context);
}
