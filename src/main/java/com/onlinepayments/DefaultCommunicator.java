package com.onlinepayments;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpStatus;
import org.apache.http.client.utils.URIBuilder;

import com.onlinepayments.authentication.Authenticator;
import com.onlinepayments.communication.CommunicationException;
import com.onlinepayments.communication.Connection;
import com.onlinepayments.communication.MetadataProvider;
import com.onlinepayments.communication.MultipartFormDataObject;
import com.onlinepayments.communication.MultipartFormDataRequest;
import com.onlinepayments.communication.NotFoundException;
import com.onlinepayments.communication.ParamRequest;
import com.onlinepayments.communication.PooledConnection;
import com.onlinepayments.communication.RequestHeader;
import com.onlinepayments.communication.RequestParam;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.communication.ResponseHeader;
import com.onlinepayments.json.Marshaller;
import com.onlinepayments.logging.BodyObfuscator;
import com.onlinepayments.logging.CommunicatorLogger;
import com.onlinepayments.logging.HeaderObfuscator;

/**
 * Used to communicate with the Online Payments platform web services.
 * <p>
 * It contains all the logic to transform a request object to a HTTP request and
 * a HTTP response to a response object.
 * <p>
 * Thread-safe.
 */
public class DefaultCommunicator implements Communicator {

    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CONTENT_TYPE_PROBLEM_JSON = "application/problem+json";

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    private final URI apiEndpoint;

    private final Connection connection;

    private final Authenticator authenticator;

    private final MetadataProvider metadataProvider;

    private final Marshaller marshaller;

    public DefaultCommunicator(URI apiEndpoint,
                               Connection connection,
                               Authenticator authenticator,
                               MetadataProvider metadataProvider,
                               Marshaller marshaller) {

        if (apiEndpoint == null) {
            throw new IllegalArgumentException("apiEndpoint is required");
        }
        if (apiEndpoint.getPath() != null && !apiEndpoint.getPath().isEmpty()) {
            throw new IllegalArgumentException("apiEndpoint should not contain a path");
        }
        if (apiEndpoint.getUserInfo() != null
                || apiEndpoint.getQuery() != null
                || apiEndpoint.getFragment() != null) {

            throw new IllegalArgumentException("apiEndpoint should not contain user info, query or fragment");
        }

        if (connection == null) {
            throw new IllegalArgumentException("connection is required");
        }
        if (authenticator == null) {
            throw new IllegalArgumentException("authenticator is required");
        }
        if (metadataProvider == null) {
            throw new IllegalArgumentException("metadataProvider is required");
        }
        if (marshaller == null) {
            throw new IllegalArgumentException("marshaller is required");
        }

        this.apiEndpoint = apiEndpoint;
        this.connection = connection;
        this.authenticator = authenticator;
        this.metadataProvider = metadataProvider;
        this.marshaller = marshaller;
    }

    /**
     * Releases any system resources associated with this object.
     */
    @Override
    public void close() throws IOException {
        connection.close();
    }


    /** {@inheritDoc} */
    @Override
    public <O> O get(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
            Class<O> responseType, CallContext context) {

        URI uri = toAbsoluteURI(relativePath, requestParameters);

        if (requestHeaders == null) {
            requestHeaders = new ArrayList<>();
        }

        addGenericHeaders("GET", uri, requestHeaders, context);

        return connection.get(uri, requestHeaders,
                (statusCode, bodyStream, headers) -> processResponse(statusCode, bodyStream, headers, responseType, relativePath, context));
    }

    /** {@inheritDoc} */
    @Override
    public void get(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
            BodyHandler bodyHandler, CallContext context) {

        URI uri = toAbsoluteURI(relativePath, requestParameters);

        if (requestHeaders == null) {
            requestHeaders = new ArrayList<>();
        }

        addGenericHeaders("GET", uri, requestHeaders, context);

        connection.get(uri, requestHeaders, (statusCode, bodyStream, headers) -> {
            processResponse(statusCode, bodyStream, headers, bodyHandler, relativePath, context);
            return null;
        });
    }

    /** {@inheritDoc} */
    @Override
    public <O> O delete(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
            Class<O> responseType, CallContext context) {

        URI uri = toAbsoluteURI(relativePath, requestParameters);

        if (requestHeaders == null) {
            requestHeaders = new ArrayList<>();
        }

        addGenericHeaders("DELETE", uri, requestHeaders, context);

        return connection.delete(uri, requestHeaders,
                (statusCode, bodyStream, headers) -> processResponse(statusCode, bodyStream, headers, responseType, relativePath, context));
    }

    /** {@inheritDoc} */
    @Override
    public void delete(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters,
            BodyHandler bodyHandler, CallContext context) {

        URI uri = toAbsoluteURI(relativePath, requestParameters);

        if (requestHeaders == null) {
            requestHeaders = new ArrayList<>();
        }

        addGenericHeaders("DELETE", uri, requestHeaders, context);

        connection.delete(uri, requestHeaders, (statusCode, bodyStream, headers) -> {
            processResponse(statusCode, bodyStream, headers, bodyHandler, relativePath, context);
            return null;
        });
    }

    /** {@inheritDoc} */
    @Override
    public <O> O post(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
            Class<O> responseType, CallContext context) {

        if (requestBody instanceof MultipartFormDataObject) {
            return post(relativePath, requestHeaders, requestParameters, (MultipartFormDataObject) requestBody, responseType, context);
        }
        if (requestBody instanceof MultipartFormDataRequest) {
            MultipartFormDataObject multipart = ((MultipartFormDataRequest) requestBody).toMultipartFormDataObject();
            return post(relativePath, requestHeaders, requestParameters, multipart, responseType, context);
        }

        URI uri = toAbsoluteURI(relativePath, requestParameters);

        if (requestHeaders == null) {
            requestHeaders = new ArrayList<>();
        }

        String requestJson = null;
        if (requestBody != null) {
            requestHeaders.add(new RequestHeader(CONTENT_TYPE_HEADER, CONTENT_TYPE_JSON));
            requestJson = marshaller.marshal(requestBody);
        }

        addGenericHeaders("POST", uri, requestHeaders, context);

        return connection.post(uri, requestHeaders, requestJson,
                (statusCode, bodyStream, headers) -> processResponse(statusCode, bodyStream, headers, responseType, relativePath, context));
    }

    private <O> O post(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, MultipartFormDataObject multipart,
            Class<O> responseType, CallContext context) {

        URI uri = toAbsoluteURI(relativePath, requestParameters);

        if (requestHeaders == null) {
            requestHeaders = new ArrayList<>();
        }

        requestHeaders.add(new RequestHeader(CONTENT_TYPE_HEADER, multipart.getContentType()));

        addGenericHeaders("POST", uri, requestHeaders, context);

        return connection.post(uri, requestHeaders, multipart,
                (statusCode, bodyStream, headers) -> processResponse(statusCode, bodyStream, headers, responseType, relativePath, context));
    }

    /** {@inheritDoc} */
    @Override
    public void post(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
            BodyHandler bodyHandler, CallContext context) {

        if (requestBody instanceof MultipartFormDataObject) {
            post(relativePath, requestHeaders, requestParameters, (MultipartFormDataObject) requestBody, bodyHandler, context);
            return;
        }
        if (requestBody instanceof MultipartFormDataRequest) {
            MultipartFormDataObject multipart = ((MultipartFormDataRequest) requestBody).toMultipartFormDataObject();
            post(relativePath, requestHeaders, requestParameters, multipart, bodyHandler, context);
            return;
        }

        URI uri = toAbsoluteURI(relativePath, requestParameters);

        if (requestHeaders == null) {
            requestHeaders = new ArrayList<>();
        }

        String requestJson = null;
        if (requestBody != null) {
            requestHeaders.add(new RequestHeader(CONTENT_TYPE_HEADER, CONTENT_TYPE_JSON));
            requestJson = marshaller.marshal(requestBody);
        }

        addGenericHeaders("POST", uri, requestHeaders, context);

        connection.post(uri, requestHeaders, requestJson, (statusCode, bodyStream, headers) -> {
            processResponse(statusCode, bodyStream, headers, bodyHandler, relativePath, context);
            return null;
        });
    }

    private void post(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, MultipartFormDataObject multipart,
            BodyHandler bodyHandler, CallContext context) {

        URI uri = toAbsoluteURI(relativePath, requestParameters);

        if (requestHeaders == null) {
            requestHeaders = new ArrayList<>();
        }

        requestHeaders.add(new RequestHeader(CONTENT_TYPE_HEADER, multipart.getContentType()));

        addGenericHeaders("POST", uri, requestHeaders, context);

        connection.post(uri, requestHeaders, multipart, (statusCode, bodyStream, headers) -> {
            processResponse(statusCode, bodyStream, headers, bodyHandler, relativePath, context);
            return null;
        });
    }

    /** {@inheritDoc} */
    @Override
    public <O> O put(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
            Class<O> responseType, CallContext context) {

        if (requestBody instanceof MultipartFormDataObject) {
            return put(relativePath, requestHeaders, requestParameters, (MultipartFormDataObject) requestBody, responseType, context);
        }
        if (requestBody instanceof MultipartFormDataRequest) {
            MultipartFormDataObject multipart = ((MultipartFormDataRequest) requestBody).toMultipartFormDataObject();
            return put(relativePath, requestHeaders, requestParameters, multipart, responseType, context);
        }

        URI uri = toAbsoluteURI(relativePath, requestParameters);

        if (requestHeaders == null) {
            requestHeaders = new ArrayList<>();
        }

        String requestJson = null;
        if (requestBody != null) {
            requestHeaders.add(new RequestHeader(CONTENT_TYPE_HEADER, CONTENT_TYPE_JSON));
            requestJson = marshaller.marshal(requestBody);
        }

        addGenericHeaders("PUT", uri, requestHeaders, context);

        return connection.put(uri, requestHeaders, requestJson,
                (statusCode, bodyStream, headers) -> processResponse(statusCode, bodyStream, headers, responseType, relativePath, context));
    }

    private <O> O put(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, MultipartFormDataObject multipart,
            Class<O> responseType, CallContext context) {

        URI uri = toAbsoluteURI(relativePath, requestParameters);

        if (requestHeaders == null) {
            requestHeaders = new ArrayList<>();
        }

        requestHeaders.add(new RequestHeader(CONTENT_TYPE_HEADER, multipart.getContentType()));

        addGenericHeaders("PUT", uri, requestHeaders, context);

        return connection.put(uri, requestHeaders, multipart,
                (statusCode, bodyStream, headers) -> processResponse(statusCode, bodyStream, headers, responseType, relativePath, context));
    }

    /** {@inheritDoc} */
    @Override
    public void put(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, Object requestBody,
            BodyHandler bodyHandler, CallContext context) {

        if (requestBody instanceof MultipartFormDataObject) {
            put(relativePath, requestHeaders, requestParameters, (MultipartFormDataObject) requestBody, bodyHandler, context);
            return;
        }
        if (requestBody instanceof MultipartFormDataRequest) {
            MultipartFormDataObject multipart = ((MultipartFormDataRequest) requestBody).toMultipartFormDataObject();
            put(relativePath, requestHeaders, requestParameters, multipart, bodyHandler, context);
            return;
        }

        URI uri = toAbsoluteURI(relativePath, requestParameters);

        if (requestHeaders == null) {
            requestHeaders = new ArrayList<>();
        }

        String requestJson = null;
        if (requestBody != null) {
            requestHeaders.add(new RequestHeader(CONTENT_TYPE_HEADER, CONTENT_TYPE_JSON));
            requestJson = marshaller.marshal(requestBody);
        }

        addGenericHeaders("PUT", uri, requestHeaders, context);

        connection.put(uri, requestHeaders, requestJson, (statusCode, bodyStream, headers) -> {
            processResponse(statusCode, bodyStream, headers, bodyHandler, relativePath, context);
            return null;
        });
    }

    private void put(String relativePath, List<RequestHeader> requestHeaders, ParamRequest requestParameters, MultipartFormDataObject multipart,
            BodyHandler bodyHandler, CallContext context) {

        URI uri = toAbsoluteURI(relativePath, requestParameters);

        if (requestHeaders == null) {
            requestHeaders = new ArrayList<>();
        }

        requestHeaders.add(new RequestHeader(CONTENT_TYPE_HEADER, multipart.getContentType()));

        addGenericHeaders("PUT", uri, requestHeaders, context);

        connection.put(uri, requestHeaders, multipart, (statusCode, bodyStream, headers) -> {
            processResponse(statusCode, bodyStream, headers, bodyHandler, relativePath, context);
            return null;
        });
    }

    /** {@inheritDoc} */
    @Override
    public Marshaller getMarshaller() {
        return marshaller;
    }

    private URI toAbsoluteURI(String relativePath, ParamRequest requestParameters) {
        List<RequestParam> requestParameterList = requestParameters == null ? null : requestParameters.toRequestParameters();
        return toAbsoluteURI(relativePath, requestParameterList);
    }

    protected URI toAbsoluteURI(String relativePath, List<RequestParam> requestParameters) {
        String absolutePath;
        if (relativePath.startsWith("/")) {
            absolutePath = relativePath;
        } else {
            absolutePath = "/" + relativePath;
        }

        URIBuilder uriBuilder = new URIBuilder()
                .setScheme(apiEndpoint.getScheme())
                .setHost(apiEndpoint.getHost())
                .setPort(apiEndpoint.getPort())
                .setPath(absolutePath);

        if (requestParameters != null) {
            for (RequestParam nvp : requestParameters) {
                uriBuilder.addParameter(nvp.getName(), nvp.getValue());
            }
        }

        try {
            return uriBuilder.build();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Unable to construct URI", e);
        }
    }

    /**
     * Adds the necessary headers to the given list of headers. This includes the authorization header, which uses
     * other headers, so when you need to override this method, make sure to call {@code super.addGenericHeaders}
     * at the <i>end</i> of your overridden method.
     */
    protected void addGenericHeaders(String httpMethod, URI uri, List<RequestHeader> requestHeaders, CallContext context) {
        requestHeaders.addAll(metadataProvider.getServerMetadataHeaders());

        requestHeaders.add(new RequestHeader("Date", getHeaderDateString()));

        // add context specific headers
        if (context != null && context.getIdempotenceKey() != null) {
            requestHeaders.add(new RequestHeader("X-GCS-Idempotence-Key", context.getIdempotenceKey()));
        }

        String authorization = authenticator.getAuthorization(httpMethod, uri, requestHeaders);
        requestHeaders.add(new RequestHeader("Authorization", authorization));
    }

    /**
     * Returns the date in the preferred format for the HTTP date header (RFC1123).
     */
    protected static String getHeaderDateString() {
        return ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.RFC_1123_DATE_TIME);
    }

    protected <O> O processResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers, Class<O> responseType,
            String requestPath, CallContext context) {

        if (context != null) {
            updateContext(headers, context);
        }
        throwExceptionIfNecessary(statusCode, bodyStream, headers, requestPath);

        return marshaller.unmarshal(bodyStream, responseType);
    }

    protected void processResponse(int statusCode, InputStream bodyStream, List<ResponseHeader> headers, BodyHandler bodyHandler,
            String requestPath, CallContext context) {

        if (context != null) {
            updateContext(headers, context);
        }
        throwExceptionIfNecessary(statusCode, bodyStream, headers, requestPath);

        try {
            bodyHandler.handleBody(bodyStream, headers);
        } catch (IOException e) {
            throw new BodyHandlerException(e);
        }
    }

    /**
     * Updates the given call context based on the contents of the given response.
     */
    protected static void updateContext(List<ResponseHeader> headers, CallContext context) {
        String idempotenceRequestTimestampValue = ResponseHeader.getHeaderValue(headers, "X-GCS-Idempotence-Request-Timestamp");
        if (idempotenceRequestTimestampValue != null) {
            Long idempotenceRequestTimestamp = Long.valueOf(idempotenceRequestTimestampValue);
            context.setIdempotenceRequestTimestamp(idempotenceRequestTimestamp);
        } else {
            context.setIdempotenceRequestTimestamp(null);
        }
        String idempotenceResponseDateTimeValue = ResponseHeader.getHeaderValue(headers, "IdempotencyResponseDatetime");
        if (idempotenceResponseDateTimeValue != null) {
            ZonedDateTime idempotenceResponseDateTime = ZonedDateTime.parse(idempotenceResponseDateTimeValue);
            context.setIdempotenceResponseDateTime(idempotenceResponseDateTime);
        } else {
            context.setIdempotenceResponseDateTime(null);
        }
    }

    /**
     * Checks the status code and headers for errors and throws an exception if necessary.
     */
    protected static void throwExceptionIfNecessary(int statusCode, InputStream bodyStream, List<ResponseHeader> headers, String requestPath) {
        // status codes in the 100 or 300 range are not expected
        if (statusCode < 200 || statusCode >= 300) {
            String body = toString(bodyStream);

            if (body != null && !body.isEmpty() && !isJson(headers)) {
                ResponseException cause = new ResponseException(statusCode, body, headers);
                if (statusCode == HttpStatus.SC_NOT_FOUND) {
                    throw new NotFoundException("The requested resource was not found; invalid path: " + requestPath, cause);
                }
                throw new CommunicationException(cause);
            }
            throw new ResponseException(statusCode, body, headers);
        }
    }

    private static String toString(InputStream bodyStream) {
        try (Reader reader = new InputStreamReader(bodyStream, CHARSET)) {
            StringBuilder body = new StringBuilder();
            char[] buffer = new char[4096];
            int len;
            while ((len = reader.read(buffer)) != -1) {
                body.append(buffer, 0, len);
            }
            return body.toString();
        } catch (IOException e) {
            throw new CommunicationException(e);
        }
    }

    private static boolean isJson(List<ResponseHeader> headers) {
        String contentType = ResponseHeader.getHeaderValue(headers, CONTENT_TYPE_HEADER);
        return contentType == null || isJson(contentType);
    }

    private static boolean isJson(String contentType) {
        if (CONTENT_TYPE_JSON.equalsIgnoreCase(contentType) || CONTENT_TYPE_PROBLEM_JSON.equalsIgnoreCase(contentType)) {
            return true;
        }
        String lowerCaseContentType = contentType.toLowerCase();
        return lowerCaseContentType.startsWith(CONTENT_TYPE_JSON) || lowerCaseContentType.startsWith(CONTENT_TYPE_PROBLEM_JSON);
    }

    /** {@inheritDoc} */
    @Override
    public void closeIdleConnections(long idleTime, TimeUnit timeUnit) {
        if (connection instanceof PooledConnection) {
            ((PooledConnection) connection).closeIdleConnections(idleTime, timeUnit);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void closeExpiredConnections() {
        if (connection instanceof PooledConnection) {
            ((PooledConnection) connection).closeExpiredConnections();
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setBodyObfuscator(BodyObfuscator bodyObfuscator) {
        connection.setBodyObfuscator(bodyObfuscator);
    }

    /** {@inheritDoc} */
    @Override
    public void setHeaderObfuscator(HeaderObfuscator headerObfuscator) {
        connection.setHeaderObfuscator(headerObfuscator);
    }

    /** {@inheritDoc} */
    @Override
    public void enableLogging(CommunicatorLogger communicatorLogger) {
        connection.enableLogging(communicatorLogger);
    }

    /** {@inheritDoc} */
    @Override
    public void disableLogging() {
        connection.disableLogging();
    }
}
