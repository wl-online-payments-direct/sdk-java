/*
 * This class was auto-generated.
 */
package com.onlinepayments.merchant.productgroups;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ResponseException;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.GetPaymentProductGroupsResponse;
import com.onlinepayments.domain.PaymentProductGroup;

/**
 * ProductGroups client. Thread-safe.
 */
public class ProductGroupsClient extends ApiResource implements ProductGroupsClientInterface {

	public ProductGroupsClient(ApiResource parent, Map<String, String> pathContext) {
		super(parent, pathContext);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetPaymentProductGroupsResponse getProductGroups(GetProductGroupsParams query) {
		return getProductGroups(query, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetPaymentProductGroupsResponse getProductGroups(GetProductGroupsParams query, CallContext context) {
		String uri = instantiateUri("/v2/{merchantId}/productgroups", null);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					query,
					GetPaymentProductGroupsResponse.class,
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
	public PaymentProductGroup getProductGroup(String paymentProductGroupId, GetProductGroupParams query) {
		return getProductGroup(paymentProductGroupId, query, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaymentProductGroup getProductGroup(String paymentProductGroupId, GetProductGroupParams query, CallContext context) {
		Map<String, String> pathContext = new TreeMap<String, String>();
		pathContext.put("paymentProductGroupId", paymentProductGroupId);
		String uri = instantiateUri("/v2/{merchantId}/productgroups/{paymentProductGroupId}", pathContext);
		try {
			return communicator.get(
					uri,
					getClientHeaders(),
					query,
					PaymentProductGroup.class,
					context);
		} catch (ResponseException e) {
			final Class<?> errorType = ErrorResponse.class;
			final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
			throw createException(e.getStatusCode(), e.getBody(), errorObject, context);
		}
	}
}
