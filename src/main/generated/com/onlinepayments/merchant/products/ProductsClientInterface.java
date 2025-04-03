/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.products;

import com.onlinepayments.ApiException;
import com.onlinepayments.AuthorizationException;
import com.onlinepayments.CallContext;
import com.onlinepayments.IdempotenceException;
import com.onlinepayments.PlatformException;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.ValidationException;
import com.onlinepayments.domain.GetPaymentProductsResponse;
import com.onlinepayments.domain.PaymentProduct;
import com.onlinepayments.domain.PaymentProductNetworksResponse;
import com.onlinepayments.domain.ProductDirectory;

/**
 * Products client. Thread-safe.
 */
public interface ProductsClientInterface {

    /**
     * Resource /v2/{merchantId}/products - Get payment products
     *
     * @param query GetPaymentProductsParams
     * @return GetPaymentProductsResponse
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    GetPaymentProductsResponse getPaymentProducts(GetPaymentProductsParams query);

    /**
     * Resource /v2/{merchantId}/products - Get payment products
     *
     * @param query GetPaymentProductsParams
     * @param context CallContext
     * @return GetPaymentProductsResponse
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
    GetPaymentProductsResponse getPaymentProducts(GetPaymentProductsParams query, CallContext context);

    /**
     * Resource /v2/{merchantId}/products/{paymentProductId} - Get payment product
     *
     * @param paymentProductId Integer
     * @param query GetPaymentProductParams
     * @return PaymentProduct
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    PaymentProduct getPaymentProduct(Integer paymentProductId, GetPaymentProductParams query);

    /**
     * Resource /v2/{merchantId}/products/{paymentProductId} - Get payment product
     *
     * @param paymentProductId Integer
     * @param query GetPaymentProductParams
     * @param context CallContext
     * @return PaymentProduct
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
    PaymentProduct getPaymentProduct(Integer paymentProductId, GetPaymentProductParams query, CallContext context);

    /**
     * Resource /v2/{merchantId}/products/{paymentProductId}/networks - Get payment product networks
     *
     * @param paymentProductId Integer
     * @param query GetPaymentProductNetworksParams
     * @return PaymentProductNetworksResponse
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    PaymentProductNetworksResponse getPaymentProductNetworks(Integer paymentProductId, GetPaymentProductNetworksParams query);

    /**
     * Resource /v2/{merchantId}/products/{paymentProductId}/networks - Get payment product networks
     *
     * @param paymentProductId Integer
     * @param query GetPaymentProductNetworksParams
     * @param context CallContext
     * @return PaymentProductNetworksResponse
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
    PaymentProductNetworksResponse getPaymentProductNetworks(Integer paymentProductId, GetPaymentProductNetworksParams query, CallContext context);

    /**
     * Resource /v2/{merchantId}/products/{paymentProductId}/directory - Get payment product directory
     *
     * @param paymentProductId Integer
     * @param query GetProductDirectoryParams
     * @return ProductDirectory
     * @throws ValidationException if the request was not correct and couldn't be processed (HTTP status code 400)
     * @throws AuthorizationException if the request was not allowed (HTTP status code 403)
     * @throws ReferenceException if an object was attempted to be referenced that doesn't exist or has been removed,
     *            or there was a conflict (HTTP status code 404, 409 or 410)
     * @throws PlatformException if something went wrong at the payment platform,
     *            the payment platform was unable to process a message from a downstream partner/acquirer,
     *            or the service that you're trying to reach is temporary unavailable (HTTP status code 500, 502 or 503)
     * @throws ApiException if the payment platform returned any other error
     */
    ProductDirectory getProductDirectory(Integer paymentProductId, GetProductDirectoryParams query);

    /**
     * Resource /v2/{merchantId}/products/{paymentProductId}/directory - Get payment product directory
     *
     * @param paymentProductId Integer
     * @param query GetProductDirectoryParams
     * @param context CallContext
     * @return ProductDirectory
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
    ProductDirectory getProductDirectory(Integer paymentProductId, GetProductDirectoryParams query, CallContext context);
}
