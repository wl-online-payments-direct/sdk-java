package com.onlinepayments.communication;

import java.io.InputStream;
import java.util.List;

/**
 * An interface for handling responses from the Online Payments platform.
 */
public interface ResponseHandler<R> {

    /**
     * @param statusCode The HTTP status code that was returned by the Online Payments platform.
     * @param bodyStream The raw response body that was returned by the Online Payments platform. Note that it will be closed outside of this method.
     * @param headers The headers that were returned by the Online Payments platform. Never {@code null}.
     */
    R handleResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers);
}
