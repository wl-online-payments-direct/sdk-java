/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.tokens;

import java.util.Map;
import java.util.TreeMap;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.CreateTokenRequest;
import com.onlinepayments.domain.CreatedTokenResponse;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.TokenResponse;

/**
 * Tokens client. Thread-safe.
 */
public class TokensClient extends ApiResource implements TokensClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public TokensClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public CreatedTokenResponse createToken(CreateTokenRequest body) {
        return createToken(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public CreatedTokenResponse createToken(CreateTokenRequest body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/tokens", null);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    CreatedTokenResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public TokenResponse getToken(String tokenId) {
        return getToken(tokenId, null);
    }

    /** {@inheritDoc} */
    @Override
    public TokenResponse getToken(String tokenId, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("tokenId", tokenId);
        String uri = instantiateUri("/v2/{merchantId}/tokens/{tokenId}", pathContext);
        try {
            return communicator.get(
                    uri,
                    getClientHeaders(),
                    null,
                    TokenResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void deleteToken(String tokenId) {
        deleteToken(tokenId, null);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteToken(String tokenId, CallContext context) {
        Map<String, String> pathContext = new TreeMap<>();
        pathContext.put("tokenId", tokenId);
        String uri = instantiateUri("/v2/{merchantId}/tokens/{tokenId}", pathContext);
        try {
            communicator.delete(
                    uri,
                    getClientHeaders(),
                    null,
                    void.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
