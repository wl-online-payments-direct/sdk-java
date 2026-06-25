package com.onlinepayments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.onlinepayments.authentication.Authenticator;
import com.onlinepayments.communication.CommunicationException;
import com.onlinepayments.communication.Connection;
import com.onlinepayments.communication.MetadataProvider;
import com.onlinepayments.communication.NotFoundException;
import com.onlinepayments.communication.RequestHeader;
import com.onlinepayments.communication.RequestParam;
import com.onlinepayments.communication.ResponseException;
import com.onlinepayments.communication.ResponseHandler;
import com.onlinepayments.communication.ResponseHeader;
import com.onlinepayments.json.Marshaller;

class DefaultCommunicatorTest {

    private static final URI BASE_URI = URI.create("https://payment.preprod.online-payments.com");
    private static final String RELATIVE_PATH = "v1/merchant/20000/convertamount";
    private static final URI ABSOLUTE_URI = URI.create("https://payment.preprod.online-payments.com/v1/merchant/20000/convertamount");

    private Connection connection;
    private Authenticator authenticator;
    private MetadataProvider metadataProvider;
    private Marshaller marshaller;

    @BeforeEach
    void setUp() {
        connection = mock(Connection.class);
        authenticator = mock(Authenticator.class);
        metadataProvider = mock(MetadataProvider.class);
        marshaller = mock(Marshaller.class);

        when(metadataProvider.getServerMetadataHeaders())
                .thenReturn(Collections.singletonList(new RequestHeader("X-GCS-ServerMetaInfo", "server-meta")));
        when(authenticator.getAuthorization(anyString(), any(URI.class), anyList()))
                .thenReturn("dummy-authorization");
    }

    @Nested
    class WhenConvertingToAbsoluteUri {

        @Nested
        class WithoutRequestParams {

            @Test
            void shouldReturnExpectedAbsoluteUri() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                URI uri = communicator.toAbsoluteURI("v1/merchant/20000/convertamount", Collections.emptyList());
                assertEquals(
                        URI.create("https://payment.preprod.online-payments.com/v1/merchant/20000/convertamount"),
                        uri
                );

                uri = communicator.toAbsoluteURI("/v1/merchant/20000/convertamount", Collections.emptyList());
                assertEquals(
                        URI.create("https://payment.preprod.online-payments.com/v1/merchant/20000/convertamount"),
                        uri
                );
            }
        }

        @Nested
        class WithRequestParams {

            @Test
            void shouldReturnExpectedAbsoluteUriWithEncodedQuery() {
                List<RequestParam> requestParams = Arrays.asList(
                    new RequestParam("amount", "123"),
                    new RequestParam("source", "USD"),
                    new RequestParam("target", "EUR"),
                    new RequestParam("dummy", "é&%=")
                );

                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                URI uri = communicator.toAbsoluteURI("v1/merchant/20000/convertamount", requestParams);
                assertEquals(
                        URI.create("https://payment.preprod.online-payments.com/v1/merchant/20000/convertamount?amount=123&source=USD&target=EUR&dummy=%C3%A9%26%25%3D"),
                        uri
                );

                uri = communicator.toAbsoluteURI("/v1/merchant/20000/convertamount", requestParams);
                assertEquals(
                        URI.create("https://payment.preprod.online-payments.com/v1/merchant/20000/convertamount?amount=123&source=USD&target=EUR&dummy=%C3%A9%26%25%3D"),
                        uri
                );
            }
        }
    }

    @Nested
    class WhenExecutingApiRequests {

        @Nested
        class WhenGetting {

            @Test
            void shouldReturnUnmarshalledResponseWhenJsonResponseIsValid() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object expectedResponse = new Object();

                when(connection.get(any(URI.class), anyList(), any())).thenAnswer(invocation -> {
                    URI uri = invocation.getArgument(0);
                    assertEquals(ABSOLUTE_URI, uri);

                    ResponseHandler<Object> responseHandler = invocation.getArgument(2);
                    return responseHandler.handleResponse(200, jsonBodyStream("{\"result\":\"OK\"}"), jsonHeaders());
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(expectedResponse);

                Object response = communicator.get(RELATIVE_PATH, null, null, Object.class, null);

                assertSame(expectedResponse, response);
            }

            @Test
            void shouldPassResponseBodyToHandlerWhenBinaryResponseHandlerIsUsed() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                AtomicReference<String> responseBody = new AtomicReference<>();

                when(connection.get(any(URI.class), anyList(), any())).thenAnswer(invocation -> {
                    URI uri = invocation.getArgument(0);
                    assertEquals(ABSOLUTE_URI, uri);

                    ResponseHandler<Object> responseHandler = invocation.getArgument(2);
                    return responseHandler.handleResponse(200, jsonBodyStream("{\"result\":\"OK\"}"), jsonHeaders());
                });

                communicator.get(RELATIVE_PATH, null, null, (bodyStream, headers) -> responseBody.set(readBody(bodyStream)), null);

                assertNotNull(responseBody.get());
                assertFalse(responseBody.get().isEmpty());
            }

            @Test
            void shouldThrowNotFoundExceptionWithInvalidPathMessageWhenPathIsInvalid() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                when(connection.get(any(URI.class), anyList(), any())).thenAnswer(invocation -> {
                    URI uri = invocation.getArgument(0);
                    ResponseHandler<Object> responseHandler = invocation.getArgument(2);

                    assertEquals(URI.create("https://payment.preprod.online-payments.com/does/not/exist"), uri);

                    return responseHandler.handleResponse(
                        404,
                        jsonBodyStream("Not found"),
                        htmlHeaders()
                    );
                });

                NotFoundException exception = assertThrows(
                        NotFoundException.class,
                        () -> communicator.get("does/not/exist", null, null, Object.class, null)
                );

                assertTrue(exception.getMessage().contains("invalid path: does/not/exist"));
            }

            @Test
            void shouldThrowCommunicationExceptionWhenGetReturnsNonJsonErrorResponse() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                when(connection.get(any(URI.class), anyList(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(2);

                    return responseHandler.handleResponse(
                        500,
                        jsonBodyStream("server error"),
                        htmlHeaders()
                    );
                });

                assertThrows(
                        CommunicationException.class,
                        () -> communicator.get("some/path", null, null, Object.class, null)
                );
            }
        }

        @Nested
        class WhenPosting {

            @Test
            void shouldReturnUnmarshalledResponseWhenJsonRequestAndResponseAreValid() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object requestBody = new Object();
                Object expectedResponse = new Object();

                when(marshaller.marshal(requestBody)).thenReturn("{\"request\":\"body\"}");

                when(connection.post(any(URI.class), anyList(), anyString(), any())).thenAnswer(invocation -> {
                    URI uri = invocation.getArgument(0);
                    String body = invocation.getArgument(2);

                    assertEquals(ABSOLUTE_URI, uri);
                    assertEquals("{\"request\":\"body\"}", body);

                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);
                    return responseHandler.handleResponse(200, jsonBodyStream("{\"result\":\"OK\"}"), jsonHeaders());
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(expectedResponse);

                Object response = communicator.post(RELATIVE_PATH, null, null, requestBody, Object.class, null);

                assertSame(expectedResponse, response);
            }

            @Test
            void shouldPassResponseBodyToHandlerWhenBinaryResponseHandlerIsUsed() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object requestBody = new Object();
                AtomicReference<String> responseBody = new AtomicReference<>();

                when(marshaller.marshal(requestBody)).thenReturn("{\"request\":\"body\"}");

                when(connection.post(any(URI.class), anyList(), anyString(), any())).thenAnswer(invocation -> {
                    URI uri = invocation.getArgument(0);
                    String body = invocation.getArgument(2);

                    assertEquals(ABSOLUTE_URI, uri);
                    assertEquals("{\"request\":\"body\"}", body);

                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);
                    return responseHandler.handleResponse(200, jsonBodyStream("{\"result\":\"OK\"}"), jsonHeaders());
                });

                communicator.post(RELATIVE_PATH, null, null, requestBody, (bodyStream, headers) -> responseBody.set(readBody(bodyStream)), null);

                assertNotNull(responseBody.get());
                assertFalse(responseBody.get().isEmpty());
            }

            @Test
            void shouldSendNullBodyWhenRequestBodyIsNull() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object expectedResponse = new Object();

                when(connection.post(any(URI.class), anyList(), nullable(String.class), any())).thenAnswer(invocation -> {
                    URI uri = invocation.getArgument(0);
                    String body = invocation.getArgument(2);

                    assertEquals(ABSOLUTE_URI, uri);
                    assertNull(body);

                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);
                    return responseHandler.handleResponse(
                        200,
                        jsonBodyStream("{\"result\":\"OK\"}"),
                        jsonHeaders()
                    );
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(expectedResponse);

                Object response = communicator.post(RELATIVE_PATH, null, null, null, Object.class, null);

                assertSame(expectedResponse, response);
                verify(marshaller, never()).marshal(any());
            }

            @Test
            void shouldThrowResponseExceptionWhenPostReturnsJsonErrorResponse() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object requestBody = new Object();

                when(marshaller.marshal(requestBody)).thenReturn("{\"request\":\"body\"}");

                when(connection.post(any(URI.class), anyList(), anyString(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);

                    return responseHandler.handleResponse(
                        400,
                        jsonBodyStream("{\"error\":\"bad request\"}"),
                        jsonHeaders()
                    );
                });

                ResponseException exception = assertThrows(
                        ResponseException.class,
                        () -> communicator.post(RELATIVE_PATH, null, null, requestBody, Object.class, null)
                );

                assertEquals(400, exception.getStatusCode());
            }

            @Test
            void shouldThrowCommunicationExceptionWhenPostReturnsNonJsonErrorResponse() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object requestBody = new Object();

                when(marshaller.marshal(requestBody)).thenReturn("{\"request\":\"body\"}");

                when(connection.post(any(URI.class), anyList(), anyString(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);

                    return responseHandler.handleResponse(
                        500,
                        jsonBodyStream("server error"),
                        htmlHeaders()
                    );
                });

                assertThrows(
                        CommunicationException.class,
                        () -> communicator.post(RELATIVE_PATH, null, null, requestBody, Object.class, null)
                );
            }
        }

        @Nested
        class WhenPutting {

            @Test
            void shouldReturnUnmarshalledResponseWhenJsonRequestAndResponseAreValid() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object requestBody = new Object();
                Object expectedResponse = new Object();

                when(marshaller.marshal(requestBody)).thenReturn("{\"request\":\"body\"}");

                when(connection.put(any(URI.class), anyList(), anyString(), any())).thenAnswer(invocation -> {
                    URI uri = invocation.getArgument(0);
                    String body = invocation.getArgument(2);

                    assertEquals(ABSOLUTE_URI, uri);
                    assertEquals("{\"request\":\"body\"}", body);

                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);
                    return responseHandler.handleResponse(200, jsonBodyStream("{\"result\":\"OK\"}"), jsonHeaders());
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(expectedResponse);

                Object response = communicator.put(RELATIVE_PATH, null, null, requestBody, Object.class, null);

                assertSame(expectedResponse, response);
            }

            @Test
            void shouldPassResponseBodyToHandlerWhenBinaryResponseHandlerIsUsed() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object requestBody = new Object();
                AtomicReference<String> responseBody = new AtomicReference<>();

                when(marshaller.marshal(requestBody)).thenReturn("{\"request\":\"body\"}");

                when(connection.put(any(URI.class), anyList(), anyString(), any())).thenAnswer(invocation -> {
                    URI uri = invocation.getArgument(0);
                    String body = invocation.getArgument(2);

                    assertEquals(ABSOLUTE_URI, uri);
                    assertEquals("{\"request\":\"body\"}", body);

                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);
                    return responseHandler.handleResponse(200, jsonBodyStream("{\"result\":\"OK\"}"), jsonHeaders());
                });

                communicator.put(RELATIVE_PATH, null, null, requestBody, (bodyStream, headers) -> responseBody.set(readBody(bodyStream)), null);

                assertNotNull(responseBody.get());
                assertFalse(responseBody.get().isEmpty());
            }

            @Test
            void shouldSendNullBodyWhenRequestBodyIsNull() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object expectedResponse = new Object();

                when(connection.put(any(URI.class), anyList(), nullable(String.class), any())).thenAnswer(invocation -> {
                    URI uri = invocation.getArgument(0);
                    String body = invocation.getArgument(2);

                    assertEquals(ABSOLUTE_URI, uri);
                    assertNull(body);

                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);
                    return responseHandler.handleResponse(
                        200,
                        jsonBodyStream("{\"result\":\"OK\"}"),
                        jsonHeaders()
                    );
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(expectedResponse);

                Object response = communicator.put(RELATIVE_PATH, null, null, null, Object.class, null);

                assertSame(expectedResponse, response);
                verify(marshaller, never()).marshal(any());
            }

            @Test
            void shouldThrowResponseExceptionWhenPutReturnsJsonErrorResponse() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object requestBody = new Object();

                when(marshaller.marshal(requestBody)).thenReturn("{\"request\":\"body\"}");

                when(connection.put(any(URI.class), anyList(), anyString(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);

                    return responseHandler.handleResponse(
                        400,
                        jsonBodyStream("{\"error\":\"bad request\"}"),
                        jsonHeaders()
                    );
                });

                ResponseException exception = assertThrows(
                        ResponseException.class,
                        () -> communicator.put(RELATIVE_PATH, null, null, requestBody, Object.class, null)
                );

                assertEquals(400, exception.getStatusCode());
            }

            @Test
            void shouldThrowCommunicationExceptionWhenPutReturnsNonJsonErrorResponse() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object requestBody = new Object();

                when(marshaller.marshal(requestBody)).thenReturn("{\"request\":\"body\"}");

                when(connection.put(any(URI.class), anyList(), anyString(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);

                    return responseHandler.handleResponse(
                        500,
                        jsonBodyStream("server error"),
                        htmlHeaders()
                    );
                });

                assertThrows(
                        CommunicationException.class,
                        () -> communicator.put(RELATIVE_PATH, null, null, requestBody, Object.class, null)
                );
            }
        }

        @Nested
        class WhenDeleting {

            @Test
            void shouldReturnUnmarshalledResponseWhenJsonResponseIsValid() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object expectedResponse = new Object();

                when(connection.delete(any(URI.class), anyList(), any())).thenAnswer(invocation -> {
                    URI uri = invocation.getArgument(0);
                    assertEquals(ABSOLUTE_URI, uri);

                    ResponseHandler<Object> responseHandler = invocation.getArgument(2);
                    return responseHandler.handleResponse(200, jsonBodyStream("{\"result\":\"OK\"}"), jsonHeaders());
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(expectedResponse);

                Object response = communicator.delete(RELATIVE_PATH, null, null, Object.class, null);

                assertSame(expectedResponse, response);
            }

            @Test
            void shouldPassResponseBodyToHandlerWhenBinaryResponseHandlerIsUsed() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                AtomicReference<String> responseBody = new AtomicReference<>();

                when(connection.delete(any(URI.class), anyList(), any())).thenAnswer(invocation -> {
                    URI uri = invocation.getArgument(0);
                    assertEquals(ABSOLUTE_URI, uri);

                    ResponseHandler<Object> responseHandler = invocation.getArgument(2);
                    return responseHandler.handleResponse(200, jsonBodyStream("{\"result\":\"OK\"}"), jsonHeaders());
                });

                communicator.delete(RELATIVE_PATH, null, null, (bodyStream, headers) -> responseBody.set(readBody(bodyStream)), null);

                assertNotNull(responseBody.get());
                assertFalse(responseBody.get().isEmpty());
            }

            @Test
            void shouldThrowResponseExceptionWhenDeleteReturnsJsonErrorResponse() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                when(connection.delete(any(URI.class), anyList(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(2);

                    return responseHandler.handleResponse(
                        400,
                        jsonBodyStream("{\"error\":\"bad request\"}"),
                        jsonHeaders()
                    );
                });

                ResponseException exception = assertThrows(
                        ResponseException.class,
                        () -> communicator.delete(RELATIVE_PATH, null, null, Object.class, null)
                );

                assertEquals(400, exception.getStatusCode());
            }

            @Test
            void shouldThrowCommunicationExceptionWhenDeleteReturnsNonJsonErrorResponse() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                when(connection.delete(any(URI.class), anyList(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(2);

                    return responseHandler.handleResponse(
                        500,
                        jsonBodyStream("server error"),
                        htmlHeaders()
                    );
                });

                assertThrows(
                        CommunicationException.class,
                        () -> communicator.delete(RELATIVE_PATH, null, null, Object.class, null)
                );
            }
        }
    }

    @Nested
    class WhenUsingIdempotence {

        @Nested
        class WhenGetting {

            @Test
            void shouldAddIdempotenceHeaderAndOmitItWithoutContextWhenGettingWithIdempotenceKey() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                CallContext contextWithKey = new CallContext();
                contextWithKey.withIdempotenceKey("test-idempotence-key");

                when(connection.get(any(URI.class), anyList(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(2);
                    return responseHandler.handleResponse(
                        200,
                        jsonBodyStream("{\"result\":\"OK\"}"),
                        jsonHeaders()
                    );
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(new Object());

                communicator.get(RELATIVE_PATH, null, null, Object.class, contextWithKey);

                @SuppressWarnings("unchecked")
                ArgumentCaptor<List<RequestHeader>> headersCaptor = ArgumentCaptor.forClass(List.class);

                verify(connection).get(any(URI.class), headersCaptor.capture(), any());

                List<RequestHeader> headersWithKey = headersCaptor.getValue();

                assertTrue(headersWithKey.stream().anyMatch(header ->
                        "X-GCS-Idempotence-Key".equals(header.getName())
                            && "test-idempotence-key".equals(header.getValue())));

                reset(connection);

                when(connection.get(any(URI.class), anyList(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(2);
                    return responseHandler.handleResponse(
                        200,
                        jsonBodyStream("{\"result\":\"OK\"}"),
                        jsonHeaders()
                    );
                });

                communicator.get(RELATIVE_PATH, null, null, Object.class, null);

                verify(connection).get(any(URI.class), headersCaptor.capture(), any());

                List<RequestHeader> headersWithoutKey = headersCaptor.getValue();

                assertFalse(headersWithoutKey.stream().anyMatch(header ->
                        "X-GCS-Idempotence-Key".equals(header.getName())));
            }

            @Test
            void shouldPopulateIdempotenceFieldsFromResponseHeadersWhenGettingWithCallContext() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                CallContext context = new CallContext();
                context.withIdempotenceKey("test-idempotence-key");

                ZonedDateTime responseDateTime = ZonedDateTime.parse("2026-04-02T10:15:30Z");

                List<ResponseHeader> responseHeaders = idempotenceResponseHeaders(responseDateTime);

                when(connection.get(any(URI.class), anyList(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(2);
                    return responseHandler.handleResponse(
                        200,
                        jsonBodyStream("{\"result\":\"OK\"}"),
                        responseHeaders
                    );
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(new Object());

                Object response = communicator.get(RELATIVE_PATH, null, null, Object.class, context);

                assertNotNull(response);
                assertEquals("test-idempotence-key", context.getIdempotenceKey());
                assertEquals(Long.valueOf(123456789L), context.getIdempotenceRequestTimestamp());
                assertEquals(responseDateTime, context.getIdempotenceResponseDateTime());
            }
        }

        @Nested
        class WhenPosting {

            @Test
            void shouldAddIdempotenceHeaderAndOmitItWithoutContextWhenPostingWithIdempotenceKey() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object requestBody = new Object();

                CallContext contextWithKey = new CallContext();
                contextWithKey.withIdempotenceKey("test-idempotence-key");

                when(marshaller.marshal(requestBody)).thenReturn("{\"request\":\"body\"}");

                when(connection.post(any(URI.class), anyList(), anyString(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);
                    return responseHandler.handleResponse(
                        200,
                        jsonBodyStream("{\"result\":\"OK\"}"),
                        jsonHeaders()
                    );
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(new Object());

                communicator.post(RELATIVE_PATH, null, null, requestBody, Object.class, contextWithKey);

                @SuppressWarnings("unchecked")
                ArgumentCaptor<List<RequestHeader>> headersCaptor = ArgumentCaptor.forClass(List.class);

                verify(connection).post(any(URI.class), headersCaptor.capture(), anyString(), any());

                List<RequestHeader> headersWithKey = headersCaptor.getValue();

                assertTrue(headersWithKey.stream().anyMatch(header ->
                        "X-GCS-Idempotence-Key".equals(header.getName())
                            && "test-idempotence-key".equals(header.getValue())));

                reset(connection);

                when(marshaller.marshal(requestBody)).thenReturn("{\"request\":\"body\"}");

                when(connection.post(any(URI.class), anyList(), anyString(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);
                    return responseHandler.handleResponse(
                        200,
                        jsonBodyStream("{\"result\":\"OK\"}"),
                        jsonHeaders()
                    );
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(new Object());

                communicator.post(RELATIVE_PATH, null, null, requestBody, Object.class, null);

                verify(connection).post(any(URI.class), headersCaptor.capture(), anyString(), any());

                List<RequestHeader> headersWithoutKey = headersCaptor.getValue();

                assertFalse(headersWithoutKey.stream().anyMatch(header ->
                        "X-GCS-Idempotence-Key".equals(header.getName())));
            }

            @Test
            void shouldPopulateIdempotenceFieldsFromResponseHeadersWhenPostingWithCallContext() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object requestBody = new Object();

                CallContext context = new CallContext();
                context.withIdempotenceKey("test-idempotence-key");

                ZonedDateTime responseDateTime = ZonedDateTime.parse("2026-04-02T10:15:30Z");

                List<ResponseHeader> responseHeaders = idempotenceResponseHeaders(responseDateTime);

                when(marshaller.marshal(requestBody)).thenReturn("{\"request\":\"body\"}");

                when(connection.post(any(URI.class), anyList(), anyString(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);
                    return responseHandler.handleResponse(
                        200,
                        jsonBodyStream("{\"result\":\"OK\"}"),
                        responseHeaders
                    );
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(new Object());

                Object response = communicator.post(RELATIVE_PATH, null, null, requestBody, Object.class, context);

                assertNotNull(response);
                assertEquals("test-idempotence-key", context.getIdempotenceKey());
                assertEquals(Long.valueOf(123456789L), context.getIdempotenceRequestTimestamp());
                assertEquals(responseDateTime, context.getIdempotenceResponseDateTime());
            }
        }

        @Nested
        class WhenPutting {

            @Test
            void shouldAddIdempotenceHeaderAndOmitItWithoutContextWhenPuttingWithIdempotenceKey() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object requestBody = new Object();

                CallContext contextWithKey = new CallContext();
                contextWithKey.withIdempotenceKey("test-idempotence-key");

                when(marshaller.marshal(requestBody)).thenReturn("{\"request\":\"body\"}");

                when(connection.put(any(URI.class), anyList(), anyString(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);
                    return responseHandler.handleResponse(
                        200,
                        jsonBodyStream("{\"result\":\"OK\"}"),
                        jsonHeaders()
                    );
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(new Object());

                communicator.put(RELATIVE_PATH, null, null, requestBody, Object.class, contextWithKey);

                @SuppressWarnings("unchecked")
                ArgumentCaptor<List<RequestHeader>> headersCaptor = ArgumentCaptor.forClass(List.class);

                verify(connection).put(any(URI.class), headersCaptor.capture(), anyString(), any());

                List<RequestHeader> headersWithKey = headersCaptor.getValue();

                assertTrue(headersWithKey.stream().anyMatch(header ->
                        "X-GCS-Idempotence-Key".equals(header.getName())
                            && "test-idempotence-key".equals(header.getValue())));

                reset(connection);

                when(marshaller.marshal(requestBody)).thenReturn("{\"request\":\"body\"}");

                when(connection.put(any(URI.class), anyList(), anyString(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);
                    return responseHandler.handleResponse(
                        200,
                        jsonBodyStream("{\"result\":\"OK\"}"),
                        jsonHeaders()
                    );
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(new Object());

                communicator.put(RELATIVE_PATH, null, null, requestBody, Object.class, null);

                verify(connection).put(any(URI.class), headersCaptor.capture(), anyString(), any());

                List<RequestHeader> headersWithoutKey = headersCaptor.getValue();

                assertFalse(headersWithoutKey.stream().anyMatch(header ->
                        "X-GCS-Idempotence-Key".equals(header.getName())));
            }

            @Test
            void shouldPopulateIdempotenceFieldsFromResponseHeadersWhenPuttingWithCallContext() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                Object requestBody = new Object();

                CallContext context = new CallContext();
                context.withIdempotenceKey("test-idempotence-key");

                ZonedDateTime responseDateTime = ZonedDateTime.parse("2026-04-02T10:15:30Z");

                List<ResponseHeader> responseHeaders = idempotenceResponseHeaders(responseDateTime);

                when(marshaller.marshal(requestBody)).thenReturn("{\"request\":\"body\"}");

                when(connection.put(any(URI.class), anyList(), anyString(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(3);
                    return responseHandler.handleResponse(
                        200,
                        jsonBodyStream("{\"result\":\"OK\"}"),
                        responseHeaders
                    );
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(new Object());

                Object response = communicator.put(RELATIVE_PATH, null, null, requestBody, Object.class, context);

                assertNotNull(response);
                assertEquals("test-idempotence-key", context.getIdempotenceKey());
                assertEquals(Long.valueOf(123456789L), context.getIdempotenceRequestTimestamp());
                assertEquals(responseDateTime, context.getIdempotenceResponseDateTime());
            }

        }

        @Nested
        class WhenDeleting {

            @Test
            void shouldAddIdempotenceHeaderAndOmitItWithoutContextWhenDeletingWithIdempotenceKey() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                CallContext contextWithKey = new CallContext();
                contextWithKey.withIdempotenceKey("test-idempotence-key");

                when(connection.delete(any(URI.class), anyList(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(2);
                    return responseHandler.handleResponse(
                        200,
                        jsonBodyStream("{\"result\":\"OK\"}"),
                        jsonHeaders()
                    );
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(new Object());

                communicator.delete(RELATIVE_PATH, null, null, Object.class, contextWithKey);

                @SuppressWarnings("unchecked")
                ArgumentCaptor<List<RequestHeader>> headersCaptor = ArgumentCaptor.forClass(List.class);

                verify(connection).delete(any(URI.class), headersCaptor.capture(), any());

                List<RequestHeader> headersWithKey = headersCaptor.getValue();

                assertTrue(headersWithKey.stream().anyMatch(header ->
                        "X-GCS-Idempotence-Key".equals(header.getName())
                            && "test-idempotence-key".equals(header.getValue())));

                reset(connection);

                when(connection.delete(any(URI.class), anyList(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(2);
                    return responseHandler.handleResponse(
                        200,
                        jsonBodyStream("{\"result\":\"OK\"}"),
                        jsonHeaders()
                    );
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(new Object());

                communicator.delete(RELATIVE_PATH, null, null, Object.class, null);

                verify(connection).delete(any(URI.class), headersCaptor.capture(), any());

                List<RequestHeader> headersWithoutKey = headersCaptor.getValue();

                assertFalse(headersWithoutKey.stream().anyMatch(header ->
                        "X-GCS-Idempotence-Key".equals(header.getName())));
            }

            @Test
            void shouldPopulateIdempotenceFieldsFromResponseHeadersWhenDeletingWithCallContext() {
                @SuppressWarnings("resource")
                DefaultCommunicator communicator = createCommunicator();

                CallContext context = new CallContext();
                context.withIdempotenceKey("test-idempotence-key");

                ZonedDateTime responseDateTime = ZonedDateTime.parse("2026-04-02T10:15:30Z");

                List<ResponseHeader> responseHeaders = idempotenceResponseHeaders(responseDateTime);

                when(connection.delete(any(URI.class), anyList(), any())).thenAnswer(invocation -> {
                    ResponseHandler<Object> responseHandler = invocation.getArgument(2);
                    return responseHandler.handleResponse(
                        200,
                        jsonBodyStream("{\"result\":\"OK\"}"),
                        responseHeaders
                    );
                });

                when(marshaller.unmarshal(any(InputStream.class), eq(Object.class))).thenReturn(new Object());

                Object response = communicator.delete(RELATIVE_PATH, null, null, Object.class, context);

                assertNotNull(response);
                assertEquals("test-idempotence-key", context.getIdempotenceKey());
                assertEquals(Long.valueOf(123456789L), context.getIdempotenceRequestTimestamp());
                assertEquals(responseDateTime, context.getIdempotenceResponseDateTime());
            }
        }
    }

    private List<ResponseHeader> jsonHeaders() {
        return Collections.singletonList(new ResponseHeader("Content-Type", "application/json"));
    }

    private List<ResponseHeader> htmlHeaders() {
        return Collections.singletonList(new ResponseHeader("Content-Type", "text/html"));
    }

    private InputStream jsonBodyStream(String body) {
        return new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8));
    }

    private String readBody(InputStream bodyStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = bodyStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        return outputStream.toString("UTF-8");
    }

    private DefaultCommunicator createCommunicator() {
        return new DefaultCommunicator(
                BASE_URI,
                connection,
                authenticator,
                metadataProvider,
                marshaller
        );
    }

    private List<ResponseHeader> idempotenceResponseHeaders(ZonedDateTime responseDateTime) {
        return Arrays.asList(
            new ResponseHeader("Content-Type", "application/json"),
            new ResponseHeader("X-GCS-Idempotence-Request-Timestamp", "123456789"),
            new ResponseHeader("IdempotencyResponseDatetime", responseDateTime.toString())
        );
    }

    @Nested
    class WhenConstructingCommunicator {

        @Test
        void shouldCreateInstanceWithValidParameters() {
            DefaultCommunicator communicator = new DefaultCommunicator(
                    BASE_URI,
                    connection,
                    authenticator,
                    metadataProvider,
                    marshaller
            );

            assertNotNull(communicator);
        }

        @Test
        void shouldThrowExceptionWhenApiEndpointIsNull() {
            assertThrows(IllegalArgumentException.class, () ->
                    new DefaultCommunicator(
                            null,
                            connection,
                            authenticator,
                            metadataProvider,
                            marshaller
                    ));
        }

        @Test
        void shouldThrowExceptionWhenApiEndpointHasPath() {
            URI invalidEndpoint = URI.create("https://payment.preprod.online-payments.com/v1");

            assertThrows(IllegalArgumentException.class, () ->
                    new DefaultCommunicator(
                            invalidEndpoint,
                            connection,
                            authenticator,
                            metadataProvider,
                            marshaller
                    ));
        }

        @Test
        void shouldThrowExceptionWhenApiEndpointHasUserInfo() {
            URI invalidEndpoint = URI.create("https://user:pass@payment.preprod.online-payments.com");

            assertThrows(IllegalArgumentException.class, () ->
                    new DefaultCommunicator(
                            invalidEndpoint,
                            connection,
                            authenticator,
                            metadataProvider,
                            marshaller
                    ));
        }

        @Test
        void shouldThrowExceptionWhenApiEndpointHasQuery() {
            URI invalidEndpoint = URI.create("https://payment.preprod.online-payments.com?key=value");

            assertThrows(IllegalArgumentException.class, () ->
                    new DefaultCommunicator(
                            invalidEndpoint,
                            connection,
                            authenticator,
                            metadataProvider,
                            marshaller
                    ));
        }

        @Test
        void shouldThrowExceptionWhenApiEndpointHasFragment() {
            URI invalidEndpoint = URI.create("https://payment.preprod.online-payments.com#section");

            assertThrows(IllegalArgumentException.class, () ->
                    new DefaultCommunicator(
                            invalidEndpoint,
                            connection,
                            authenticator,
                            metadataProvider,
                            marshaller
                    ));
        }

        @Test
        void shouldThrowExceptionWhenConnectionIsNull() {
            assertThrows(IllegalArgumentException.class, () ->
                    new DefaultCommunicator(
                            BASE_URI,
                            null,
                            authenticator,
                            metadataProvider,
                            marshaller
                    ));
        }

        @Test
        void shouldThrowExceptionWhenAuthenticatorIsNull() {
            assertThrows(IllegalArgumentException.class, () ->
                    new DefaultCommunicator(
                            BASE_URI,
                            connection,
                            null,
                            metadataProvider,
                            marshaller
                    ));
        }

        @Test
        void shouldThrowExceptionWhenMetadataProviderIsNull() {
            assertThrows(IllegalArgumentException.class, () ->
                    new DefaultCommunicator(
                            BASE_URI,
                            connection,
                            authenticator,
                            null,
                            marshaller
                    ));
        }

        @Test
        void shouldThrowExceptionWhenMarshallerIsNull() {
            assertThrows(IllegalArgumentException.class, () ->
                    new DefaultCommunicator(
                            BASE_URI,
                            connection,
                            authenticator,
                            metadataProvider,
                            null
                    ));
        }
    }

    @Nested
    class WhenGettingMarshaller {

        @Test
        void shouldReturnNonNullMarshaller() {
            @SuppressWarnings("resource")
            DefaultCommunicator communicator = createCommunicator();

            Marshaller result = communicator.getMarshaller();

            assertNotNull(result);
        }

        @Test
        void shouldReturnSameMarshallerInstance() {
            @SuppressWarnings("resource")
            DefaultCommunicator communicator = createCommunicator();

            Marshaller result1 = communicator.getMarshaller();
            Marshaller result2 = communicator.getMarshaller();

            assertSame(result1, result2);
        }

        @Test
        void shouldReturnConfiguredMarshaller() {
            @SuppressWarnings("resource")
            DefaultCommunicator communicator = createCommunicator();

            Marshaller result = communicator.getMarshaller();

            assertSame(marshaller, result);
        }
    }

    @Nested
    class WhenClosingCommunicator {

        @Test
        void shouldDelegateToConnection() throws IOException {
            @SuppressWarnings("resource")
            DefaultCommunicator communicator = createCommunicator();

            communicator.close();

            verify(connection).close();
        }

        @Test
        void shouldThrowIOExceptionWhenConnectionThrows() throws IOException {
            reset(connection);
            @SuppressWarnings("resource")
            DefaultCommunicator communicator = createCommunicator();

            doThrow(new IOException("Connection error")).when(connection).close();

            assertThrows(IOException.class, communicator::close);
        }

        @Test
        void shouldBeCloseable() throws IOException {
            try (DefaultCommunicator communicator = createCommunicator()) {
                assertNotNull(communicator);
            }
        }
    }
}
