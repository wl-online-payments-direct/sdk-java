/*
 * This file was automatically generated.
 */

package com.onlinepayments.merchant.cofseries;

import java.util.Map;

import com.onlinepayments.ApiResource;
import com.onlinepayments.CallContext;
import com.onlinepayments.ExceptionFactory;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.domain.ErrorResponse;
import com.onlinepayments.domain.ImportCofSeriesRequest;
import com.onlinepayments.domain.ImportCofSeriesResponse;

/**
 * CofSeries client. Thread-safe.
 */
public class CofSeriesClient extends ApiResource implements CofSeriesClientInterface {

    private static final ExceptionFactory EXCEPTION_FACTORY = new ExceptionFactory();

    public CofSeriesClient(ApiResource parent, Map<String, String> pathContext) {
        super(parent, pathContext);
    }

    /** {@inheritDoc} */
    @Override
    public ImportCofSeriesResponse importCofSeries(ImportCofSeriesRequest body) {
        return importCofSeries(body, null);
    }

    /** {@inheritDoc} */
    @Override
    public ImportCofSeriesResponse importCofSeries(ImportCofSeriesRequest body, CallContext context) {
        String uri = instantiateUri("/v2/{merchantId}/tokens/importCofSeries", null);
        try {
            return communicator.post(
                    uri,
                    getClientHeaders(),
                    null,
                    body,
                    ImportCofSeriesResponse.class,
                    context);
        } catch (ResponseException e) {
            final Class<?> errorType = ErrorResponse.class;
            final Object errorObject = communicator.getMarshaller().unmarshal(e.getBody(), errorType);
            throw EXCEPTION_FACTORY.createException(e.getStatusCode(), e.getBody(), errorObject, context);
        }
    }
}
