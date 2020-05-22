package com.ingenico.direct;

import java.io.Closeable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.ingenico.direct.logging.LoggingCapable;

/**
 * Used to communicate with the Ingenico ePayments platform web services.
 * <p>
 * It contains all the logic to transform a request object to a HTTP request and
 * a HTTP response to a response object.
 * <p>
 * Thread-safe.
 */
public interface Communicator extends Closeable, LoggingCapable {
	@SuppressWarnings("resource")
	<O> O get(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
			Class<O> responseType, CallContext context);

	@SuppressWarnings("resource")
	void get(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
			BodyHandler bodyHandler, CallContext context);

	@SuppressWarnings("resource")
	<O> O delete(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
			Class<O> responseType, CallContext context);

	@SuppressWarnings("resource")
	void delete(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
			BodyHandler bodyHandler, CallContext context);

	@SuppressWarnings("resource")
	<O> O post(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
			Class<O> responseType, CallContext context);

	@SuppressWarnings("resource")
	void post(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
			BodyHandler bodyHandler, CallContext context);

	@SuppressWarnings("resource")
	<O> O put(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
			Class<O> responseType, CallContext context);

	@SuppressWarnings("resource")
	void put(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
			BodyHandler bodyHandler, CallContext context);

	Connection getConnection();

	Authenticator getAuthenticator();

	MetaDataProvider getMetaDataProvider();

	Marshaller getMarshaller();

	void closeIdleConnections(long idleTime, TimeUnit timeUnit);

	void closeExpiredConnections();
}
