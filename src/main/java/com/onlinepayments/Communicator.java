package com.onlinepayments;

import java.io.Closeable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.onlinepayments.communication.CommunicationException;
import com.onlinepayments.communication.ParamRequest;
import com.onlinepayments.communication.PooledConnection;
import com.onlinepayments.communication.RequestHeader;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.json.Marshaller;
import com.onlinepayments.logging.LoggingCapable;
import com.onlinepayments.logging.ObfuscationCapable;

/**
 * Used to communicate with the Online Payments platform web services.
 * <p>
 * It contains all the logic to transform a request object to a HTTP request and
 * a HTTP response to a response object.
 * <p>
 * Thread-safe.
 */
public interface Communicator extends Closeable, LoggingCapable, ObfuscationCapable {

    /**
     * Corresponds to the HTTP GET method.
     *
     * @param relativePath The path to call, relative to the base URI.
     * @param requestHeaders An optional list of request headers.
     * @param requestParameters An optional set of request parameters.
     * @param responseType The type of response to return.
     * @param context The optional call context to use.
     * @throws CommunicationException when an exception occurred communicating with the Online Payments platform
     * @throws ResponseException when an error response was received from the Online Payments platform
     */
    <O> O get(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
            Class<O> responseType, CallContext context);

    /**
     * Corresponds to the HTTP GET method.
     *
     * @param relativePath The path to call, relative to the base URI.
     * @param requestHeaders An optional list of request headers.
     * @param requestParameters An optional set of request parameters.
     * @param bodyHandler The handler for the response body.
     * @param context The optional call context to use.
     * @throws CommunicationException when an exception occurred communicating with the Online Payments platform
     * @throws ResponseException when an error response was received from the Online Payments platform
     */
    void get(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
            BodyHandler bodyHandler, CallContext context);

    /**
     * Corresponds to the HTTP DELETE method.
     *
     * @param relativePath The path to call, relative to the base URI.
     * @param requestHeaders An optional list of request headers.
     * @param requestParameters An optional set of request parameters.
     * @param responseType The type of response to return.
     * @param context The optional call context to use.
     * @throws CommunicationException when an exception occurred communicating with the Online Payments platform
     * @throws ResponseException when an error response was received from the Online Payments platform
     */
    <O> O delete(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
            Class<O> responseType, CallContext context);

    /**
     * Corresponds to the HTTP DELETE method.
     *
     * @param relativePath The path to call, relative to the base URI.
     * @param requestHeaders An optional list of request headers.
     * @param requestParameters An optional set of request parameters.
     * @param bodyHandler The handler for the response body.
     * @param context The optional call context to use.
     * @throws CommunicationException when an exception occurred communicating with the Online Payments platform
     * @throws ResponseException when an error response was received from the Online Payments platform
     */
    void delete(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
            BodyHandler bodyHandler, CallContext context);

    /**
     * Corresponds to the HTTP POST method.
     *
     * @param relativePath The path to call, relative to the base URI.
     * @param requestHeaders An optional list of request headers.
     * @param requestParameters An optional set of request parameters.
     * @param requestBody The optional request body to send.
     * @param responseType The type of response to return.
     * @param context The optional call context to use.
     * @throws CommunicationException when an exception occurred communicating with the Online Payments platform
     * @throws ResponseException when an error response was received from the Online Payments platform
     */
    <O> O post(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
            Class<O> responseType, CallContext context);


    /**
     * Corresponds to the HTTP POST method.
     *
     * @param relativePath The path to call, relative to the base URI.
     * @param requestHeaders An optional list of request headers.
     * @param requestParameters An optional set of request parameters.
     * @param requestBody The optional request body to send.
     * @param bodyHandler The handler for the response body.
     * @param context The optional call context to use.
     * @throws CommunicationException when an exception occurred communicating with the Online Payments platform
     * @throws ResponseException when an error response was received from the Online Payments platform
     */
    void post(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
            BodyHandler bodyHandler, CallContext context);

    /**
     * Corresponds to the HTTP PUT method.
     *
     * @param relativePath The path to call, relative to the base URI.
     * @param requestHeaders An optional list of request headers.
     * @param requestParameters An optional set of request parameters.
     * @param requestBody The optional request body to send.
     * @param responseType The type of response to return.
     * @param context The optional call context to use.
     * @throws CommunicationException when an exception occurred communicating with the Online Payments platform
     * @throws ResponseException when an error response was received from the Online Payments platform
     */
    <O> O put(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
            Class<O> responseType, CallContext context);

    /**
     * Corresponds to the HTTP PUT method.
     *
     * @param relativePath The path to call, relative to the base URI.
     * @param requestHeaders An optional list of request headers.
     * @param requestParameters An optional set of request parameters.
     * @param requestBody The optional request body to send.
     * @param bodyHandler The handler for the response body.
     * @param context The optional call context to use.
     * @throws CommunicationException when an exception occurred communicating with the Online Payments platform
     * @throws ResponseException when an error response was received from the Online Payments platform
     */
    void put(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
            BodyHandler bodyHandler, CallContext context);

    /**
     * @return The {@link Marshaller} object associated with this communicator. Never {@code null}.
     */
    Marshaller getMarshaller();

    /**
     * Utility method that delegates the call to this communicator's connection if that's an instance of
     * {@link PooledConnection}. If not this method does nothing.
     *
     * @see PooledConnection#closeIdleConnections(long, TimeUnit)
     */
    void closeIdleConnections(long idleTime, TimeUnit timeUnit);

    /**
     * Utility method that delegates the call to this communicator's connection if that's an instance of
     * {@link PooledConnection}. If not this method does nothing.
     *
     * @see PooledConnection#closeExpiredConnections()
     */
    void closeExpiredConnections();
}
