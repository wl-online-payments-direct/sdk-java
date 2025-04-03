/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.privacypolicy;

import java.util.Map;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.GetPrivacyPolicyResponse;

/**
 * PrivacyPolicy client. Thread-safe.
 */
public class PrivacyPolicyClient extends ApiResource implements PrivacyPolicyClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public PrivacyPolicyClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public GetPrivacyPolicyResponse getPrivacyPolicy(GetPrivacyPolicyParams query) {
        return getPrivacyPolicy(query, null);
    }

    /** {@inheritDoc} */
    @Override
    public GetPrivacyPolicyResponse getPrivacyPolicy(GetPrivacyPolicyParams query, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/services/privacypolicy", null);
        try {
            return communicator.get(
                    uri,
                    getClientHeaders(),
                    query,
                    GetPrivacyPolicyResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
