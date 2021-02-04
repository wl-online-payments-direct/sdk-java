/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference
 */
package com.ingenico.direct.merchant.products;

import java.util.Map;
import java.util.TreeMap;

import com.ingenico.direct.ApiException;
import com.ingenico.direct.ApiResource;
import com.ingenico.direct.AuthorizationException;
import com.ingenico.direct.CallContext;
import com.ingenico.direct.DirectException;
import com.ingenico.direct.IdempotenceException;
import com.ingenico.direct.ReferenceException;
import com.ingenico.direct.ResponseException;
import com.ingenico.direct.ValidationException;
import com.ingenico.direct.domain.ErrorResponse;
import com.ingenico.direct.domain.GetPaymentProductsResponse;
import com.ingenico.direct.domain.PaymentProduct;
import com.ingenico.direct.domain.PaymentProductNetworksResponse;
import com.ingenico.direct.domain.ProductDirectory;

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
