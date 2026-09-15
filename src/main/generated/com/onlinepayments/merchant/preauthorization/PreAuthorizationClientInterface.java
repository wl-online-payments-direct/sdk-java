/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.preauthorization;

import com.onlinepayments.ApiException;
import com.onlinepayments.AuthorizationException;
import com.onlinepayments.CallContext;
import com.onlinepayments.DeclinedPaymentException;
import com.onlinepayments.IdempotenceException;
import com.onlinepayments.PlatformException;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.AddAuthorizationDetailsResponse;
import com.onlinepayments.domain.IncrementAuthorizationRequest;
import com.onlinepayments.domain.IncrementAuthorizationResponse;
import com.onlinepayments.domain.UpdateAuthorizationAdditionalDataRequest;

/**
 * PreAuthorization client. Thread-safe.
 */
public interface PreAuthorizationClientInterface {

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/increment-authorization - Increment authorization
     *
     * @param paymentId String
     * @param body IncrementAuthorizationRequest
     * @return IncrementAuthorizationResponse
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
    IncrementAuthorizationResponse incrementAuthorization(String paymentId, IncrementAuthorizationRequest body);

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/increment-authorization - Increment authorization
     *
     * @param paymentId String
     * @param body IncrementAuthorizationRequest
     * @param context CallContext
     * @return IncrementAuthorizationResponse
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
    IncrementAuthorizationResponse incrementAuthorization(String paymentId, IncrementAuthorizationRequest body, CallContext context);

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/authorization-additional-data - Add market specific additional data to a payment prior to capture.
     *
     * @param paymentId String
     * @param body UpdateAuthorizationAdditionalDataRequest
     * @return AddAuthorizationDetailsResponse
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
    AddAuthorizationDetailsResponse addAuthorizationDetails(String paymentId, UpdateAuthorizationAdditionalDataRequest body);

    /**
     * Resource /v2/{merchantId}/payments/{paymentId}/authorization-additional-data - Add market specific additional data to a payment prior to capture.
     *
     * @param paymentId String
     * @param body UpdateAuthorizationAdditionalDataRequest
     * @param context CallContext
     * @return AddAuthorizationDetailsResponse
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
    AddAuthorizationDetailsResponse addAuthorizationDetails(String paymentId, UpdateAuthorizationAdditionalDataRequest body, CallContext context);
}
