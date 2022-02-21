/*
 * This class was auto-generated.
 */
package com.onlinepayments.merchant.products;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ResponseException;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.GetPaymentProductsResponse;
import com.onlinepayments.domain.PaymentProduct;
import com.onlinepayments.domain.PaymentProductNetworksResponse;
import com.onlinepayments.domain.ProductDirectory;

/**
 * Products client. Thread-safe.
 */
public class ProductsClient extends ApiResource implements ProductsClientInterface {

	public ProductsClient(ApiResource parent, Map<String, String> pathContext) {
		super(parent, pathContext);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetPaymentProductsResponse getPaymentProducts(GetPaymentProductsParams query) {
		return getPaymentProducts(query, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetPaymentProductsResponse getPaymentProducts(GetPaymentProductsParams query, CallContext context) {
		String uri = instantiateUri("/v2/{merchantId}/products", null);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					query,
					GetPaymentProductsResponse.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentProduct getPaymentProduct(Integer paymentProductId, GetPaymentProductParams query) {
		return getPaymentProduct(paymentProductId, query, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentProduct getPaymentProduct(Integer paymentProductId, GetPaymentProductParams query, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentProductId", paymentProductId.toString());
		String uri = instantiateUri("/v2/{merchantId}/products/{paymentProductId}", pathContext);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					query,
					PaymentProduct.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductDirectory getProductDirectory(Integer paymentProductId, GetProductDirectoryParams query) {
		return getProductDirectory(paymentProductId, query, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProductDirectory getProductDirectory(Integer paymentProductId, GetProductDirectoryParams query, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentProductId", paymentProductId.toString());
		String uri = instantiateUri("/v2/{merchantId}/products/{paymentProductId}/directory", pathContext);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					query,
					ProductDirectory.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentProductNetworksResponse getPaymentProductNetworks(Integer paymentProductId, GetPaymentProductNetworksParams query) {
		return getPaymentProductNetworks(paymentProductId, query, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentProductNetworksResponse getPaymentProductNetworks(Integer paymentProductId, GetPaymentProductNetworksParams query, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentProductId", paymentProductId.toString());
		String uri = instantiateUri("/v2/{merchantId}/products/{paymentProductId}/networks", pathContext);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					query,
					PaymentProductNetworksResponse.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}
}
