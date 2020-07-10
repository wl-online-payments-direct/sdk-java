/*
 * This class was auto-generated from the API references found at
 * https://support.direct.ingenico.com/documentation/api/reference/index.html
 */
package com.ingenico.direct.merchant.productgroups;

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
import com.ingenico.direct.domain.GetPaymentProductGroupsResponse;
import com.ingenico.direct.domain.PaymentProductGroup;

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
