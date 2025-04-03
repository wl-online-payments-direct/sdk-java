/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.services;

import java.util.Map;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.CalculateSurchargeRequest;
import com.onlinepayments.domain.CalculateSurchargeResponse;
import com.onlinepayments.domain.CurrencyConversionRequest;
import com.onlinepayments.domain.CurrencyConversionResponse;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.GetIINDetailsRequest;
import com.onlinepayments.domain.GetIINDetailsResponse;
import com.onlinepayments.domain.TestConnection;

/**
 * Services client. Thread-safe.
 */
public class ServicesClient extends ApiResource implements ServicesClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public ServicesClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public TestConnection testConnection() {
        return testConnection(null);
    }

    /** {@inheritDoc} */
    @Override
    public TestConnection testConnection(CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/services/testconnection", null);
        try {
            return communicator.get(
                    uri,
                    getClientHeaders(),
                    null,
                    TestConnection.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public GetIINDetailsResponse getIINDetails(GetIINDetailsRequest body) {
        return getIINDetails(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public GetIINDetailsResponse getIINDetails(GetIINDetailsRequest body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/services/getIINdetails", null);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    GetIINDetailsResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public CurrencyConversionResponse getDccRateInquiry(CurrencyConversionRequest body) {
        return getDccRateInquiry(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public CurrencyConversionResponse getDccRateInquiry(CurrencyConversionRequest body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/services/dccrate", null);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    CurrencyConversionResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }

    /** {@inheritDoc} */
    @Override
    public CalculateSurchargeResponse surchargeCalculation(CalculateSurchargeRequest body) {
        return surchargeCalculation(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public CalculateSurchargeResponse surchargeCalculation(CalculateSurchargeRequest body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/services/surchargecalculation", null);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    CalculateSurchargeResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
