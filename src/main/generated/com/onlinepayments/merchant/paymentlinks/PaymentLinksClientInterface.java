/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.paymentlinks;

import com.onlinepayments.ApiException;
import com.onlinepayments.AuthorizationException;
import com.onlinepayments.CallContext;
import com.onlinepayments.IdempotenceException;
import com.onlinepayments.PlatformException;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.CreatePaymentLinkRequest;
import com.onlinepayments.domain.PaymentLinkResponse;
import com.onlinepayments.domain.PaymentLinksResponse;

/**
 * PaymentLinks client. Thread-safe.
 */
public interface PaymentLinksClientInterface {

    /**
     * Resource /v2/{merchantId}/paymentlinks - Get payment links
     *
     * @param query GetPaymentLinksInBulkParams
     * @return PaymentLinksResponse
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    PaymentLinksResponse getPaymentLinksInBulk(GetPaymentLinksInBulkParams query);

    /**
     * Resource /v2/{merchantId}/paymentlinks - Get payment links
     *
     * @param query GetPaymentLinksInBulkParams
     * @param context CallContext
     * @return PaymentLinksResponse
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
    PaymentLinksResponse getPaymentLinksInBulk(GetPaymentLinksInBulkParams query, CallContext context);

    /**
     * Resource /v2/{merchantId}/paymentlinks - Create payment link
     *
     * @param body CreatePaymentLinkRequest
     * @return PaymentLinkResponse
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    PaymentLinkResponse createPaymentLink(CreatePaymentLinkRequest body);

    /**
     * Resource /v2/{merchantId}/paymentlinks - Create payment link
     *
     * @param body CreatePaymentLinkRequest
     * @param context CallContext
     * @return PaymentLinkResponse
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
    PaymentLinkResponse createPaymentLink(CreatePaymentLinkRequest body, CallContext context);

    /**
     * Resource /v2/{merchantId}/paymentlinks/{paymentLinkId} - Get payment link by ID
     *
     * @param paymentLinkId String
     * @return PaymentLinkResponse
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    PaymentLinkResponse getPaymentLinkById(String paymentLinkId);

    /**
     * Resource /v2/{merchantId}/paymentlinks/{paymentLinkId} - Get payment link by ID
     *
     * @param paymentLinkId String
     * @param context CallContext
     * @return PaymentLinkResponse
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
    PaymentLinkResponse getPaymentLinkById(String paymentLinkId, CallContext context);

    /**
     * Resource /v2/{merchantId}/paymentlinks/{paymentLinkId}/cancel - Cancel PaymentLink by ID
     *
     * @param paymentLinkId String
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    void cancelPaymentLinkById(String paymentLinkId);

    /**
     * Resource /v2/{merchantId}/paymentlinks/{paymentLinkId}/cancel - Cancel PaymentLink by ID
     *
     * @param paymentLinkId String
     * @param context CallContext
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
    void cancelPaymentLinkById(String paymentLinkId, CallContext context);
}
