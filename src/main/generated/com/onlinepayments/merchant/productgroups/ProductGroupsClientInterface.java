/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.productgroups;

import com.onlinepayments.ApiException;
import com.onlinepayments.AuthorizationException;
import com.onlinepayments.CallContext;
import com.onlinepayments.IdempotenceException;
import com.onlinepayments.PlatformException;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.GetPaymentProductGroupsResponse;
import com.onlinepayments.domain.PaymentProductGroup;

/**
 * ProductGroups client. Thread-safe.
 */
public interface ProductGroupsClientInterface {

    /**
     * Resource /v2/{merchantId}/productgroups - Get product groups
     *
     * @param query GetProductGroupsParams
     * @return GetPaymentProductGroupsResponse
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    GetPaymentProductGroupsResponse getProductGroups(GetProductGroupsParams query);

    /**
     * Resource /v2/{merchantId}/productgroups - Get product groups
     *
     * @param query GetProductGroupsParams
     * @param context CallContext
     * @return GetPaymentProductGroupsResponse
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
    GetPaymentProductGroupsResponse getProductGroups(GetProductGroupsParams query, CallContext context);

    /**
     * Resource /v2/{merchantId}/productgroups/{paymentProductGroupId} - Get product group
     *
     * @param paymentProductGroupId String
     * @param query GetProductGroupParams
     * @return PaymentProductGroup
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    PaymentProductGroup getProductGroup(String paymentProductGroupId, GetProductGroupParams query);

    /**
     * Resource /v2/{merchantId}/productgroups/{paymentProductGroupId} - Get product group
     *
     * @param paymentProductGroupId String
     * @param query GetProductGroupParams
     * @param context CallContext
     * @return PaymentProductGroup
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
    PaymentProductGroup getProductGroup(String paymentProductGroupId, GetProductGroupParams query, CallContext context);
}
