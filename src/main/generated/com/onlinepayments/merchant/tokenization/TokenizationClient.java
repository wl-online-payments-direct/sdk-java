/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.tokenization;

import java.util.Map;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.CreateCertificateResponse;
import com.onlinepayments.domain.CsrRequest;
import com.onlinepayments.domain.DetokenizationResponse;
import com.onlinepayments.domain.ErrorResponse;

/**
 * Tokenization client. Thread-safe.
 */
public class TokenizationClient extends ApiResource implements TokenizationClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public TokenizationClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public CreateCertificateResponse createCertificate(CsrRequest body) {
        return createCertificate(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public CreateCertificateResponse createCertificate(CsrRequest body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/detokenize/csr", null);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    CreateCertificateResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public DetokenizationResponse getCardDataByTokens(GetCardDataByTokensParams query) {
        return getCardDataByTokens(query, null);
    }

    /** {@inheritDoc} */
    @Override
    public DetokenizationResponse getCardDataByTokens(GetCardDataByTokensParams query, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/detokenize/tokens", null);
        try {
            return communicator.get(
                    uri,
                    getClientHeaders(),
                    query,
                    DetokenizationResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public DetokenizationResponse getCardDataByPayments(GetCardDataByPaymentsParams query) {
        return getCardDataByPayments(query, null);
    }

    /** {@inheritDoc} */
    @Override
    public DetokenizationResponse getCardDataByPayments(GetCardDataByPaymentsParams query, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/detokenize/payments", null);
        try {
            return communicator.get(
                    uri,
                    getClientHeaders(),
                    query,
                    DetokenizationResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
