/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.tokenization;

import com.onlinepayments.ApiException;
import com.onlinepayments.AuthorizationException;
import com.onlinepayments.CallContext;
import com.onlinepayments.IdempotenceException;
import com.onlinepayments.PlatformException;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.CreateCertificateResponse;
import com.onlinepayments.domain.CsrRequest;
import com.onlinepayments.domain.DetokenizationResponse;

/**
 * Tokenization client. Thread-safe.
 */
public interface TokenizationClientInterface {

    /**
     * Resource /v2/{merchantId}/detokenize/csr - Sign certificate
     *
     * @param body CsrRequest
     * @return CreateCertificateResponse
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    CreateCertificateResponse createCertificate(CsrRequest body);

    /**
     * Resource /v2/{merchantId}/detokenize/csr - Sign certificate
     *
     * @param body CsrRequest
     * @param context CallContext
     * @return CreateCertificateResponse
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
    CreateCertificateResponse createCertificate(CsrRequest body, CallContext context);

    /**
     * Resource /v2/{merchantId}/detokenize/tokens - Get sensitive card details by card alias tokens
     *
     * @param query GetCardDataByTokensParams
     * @return DetokenizationResponse
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    DetokenizationResponse getCardDataByTokens(GetCardDataByTokensParams query);

    /**
     * Resource /v2/{merchantId}/detokenize/tokens - Get sensitive card details by card alias tokens
     *
     * @param query GetCardDataByTokensParams
     * @param context CallContext
     * @return DetokenizationResponse
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
    DetokenizationResponse getCardDataByTokens(GetCardDataByTokensParams query, CallContext context);

    /**
     * Resource /v2/{merchantId}/detokenize/payments - Get sensitive card details by card payment identifiers
     *
     * @param query GetCardDataByPaymentsParams
     * @return DetokenizationResponse
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    DetokenizationResponse getCardDataByPayments(GetCardDataByPaymentsParams query);

    /**
     * Resource /v2/{merchantId}/detokenize/payments - Get sensitive card details by card payment identifiers
     *
     * @param query GetCardDataByPaymentsParams
     * @param context CallContext
     * @return DetokenizationResponse
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
    DetokenizationResponse getCardDataByPayments(GetCardDataByPaymentsParams query, CallContext context);
}
