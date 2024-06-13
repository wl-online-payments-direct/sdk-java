package com.onlinepayments;

import java.io.Closeable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.onlinepayments.logging.LoggingCapable;

/**
 * Used to communicate with the Online Payments platform web services.
 * <p>
 * It contains all the logic to transform a request object to a HTTP request and
 * a HTTP response to a response object.
 * <p>
 * Thread-safe.
 */
public interface Communicator extends Closeable, LoggingCapable {

	/**
	 * Corresponds to the HTTP GET method.
	 *
	 * @param relativePath The path to call, relative to the base URI.
	 * @param requestHeaders An optional list of request headers.
	 * @param requestParameters An optional set of request parameters.
	 * @param responseType The type of response to return.
	 * @param context The optional call context to use.
	 * @return an object of type O that corresponds to the response from the HTTP GET request
	 * @param <O> The type that corresponds to the response from the HTTP GET request
	 * @throws CommunicationException when an exception occurred communicating with the Online Payments platform
	 * @throws ResponseException when an error response was received from the Online Payments platform
	 * @throws ApiException when an error response was received from the Online Payments platform which contained a list of errors
	 */
	@SuppressWarnings("resource")
	<O> O get(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
			Class<O> responseType, CallContext context);

	/**
	 * Corresponds to the HTTP DELETE method.
	 *
	 * @param relativePath The path to call, relative to the base URI.
	 * @param requestHeaders An optional list of request headers.
	 * @param requestParameters An optional set of request parameters.
	 * @param responseType The type of response to return.
	 * @param context The optional call context to use.
	 * @return an object of type O that corresponds to the response from the HTTP DELETE request
	 * @param <O> The type that corresponds to the response from the HTTP DELETE request
	 * @throws CommunicationException when an exception occurred communicating with the Online Payments platform
	 * @throws ResponseException when an error response was received from the Online Payments platform
	 * @throws ApiException when an error response was received from the Online Payments platform which contained a list of errors
	 */
	@SuppressWarnings("resource")
	<O> O delete(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
			Class<O> responseType, CallContext context);

	/**
	 * Corresponds to the HTTP POST method.
	 *
	 * @param relativePath The path to call, relative to the base URI.
	 * @param requestHeaders An optional list of request headers.
	 * @param requestParameters An optional set of request parameters.
	 * @param requestBody The optional request body to send.
	 * @param responseType The type of response to return.
	 * @param context The optional call context to use.
	 * @return an object of type O that corresponds to the response from the HTTP POST request
	 * @param <O> The type that corresponds to the response from the HTTP POST request
	 * @throws CommunicationException when an exception occurred communicating with the Online Payments platform
	 * @throws ResponseException when an error response was received from the Online Payments platform
	 * @throws ApiException when an error response was received from the Online Payments platform which contained a list of errors
	 */
	@SuppressWarnings("resource")
	<O> O post(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
			Class<O> responseType, CallContext context);

	/**
	 * Corresponds to the HTTP PUT method.
	 *
	 * @param relativePath The path to call, relative to the base URI.
	 * @param requestHeaders An optional list of request headers.
	 * @param requestParameters An optional set of request parameters.
	 * @param requestBody The optional request body to send.
	 * @param responseType The type of response to return.
	 * @param context The optional call context to use.
	 * @return an object of type O that corresponds to the response from the HTTP PUT request
	 * @param <O> The type that corresponds to the response from the HTTP PUT request
	 * @throws CommunicationException when an exception occurred communicating with the Online Payments platform
	 * @throws ResponseException when an error response was received from the Online Payments platform
	 * @throws ApiException when an error response was received from the Online Payments platform which contained a list of errors
	 */
	@SuppressWarnings("resource")
	<O> O put(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
			Class<O> responseType, CallContext context);

	Connection getConnection();

	Authenticator getAuthenticator();

	MetaDataProvider getMetaDataProvider();

	Marshaller getMarshaller();

	void closeIdleConnections(long idleTime, TimeUnit timeUnit);

	void closeExpiredConnections();
}
