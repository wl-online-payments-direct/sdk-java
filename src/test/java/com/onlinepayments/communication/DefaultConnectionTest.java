package com.onlinepayments.communication;

import static com.onlinepayments.util.DefaultConnectionAssertions.assertMaxConnections;
import static com.onlinepayments.util.DefaultConnectionAssertions.assertNoProxy;
import static com.onlinepayments.util.DefaultConnectionAssertions.assertProxy;
import static com.onlinepayments.util.DefaultConnectionAssertions.assertRequestConfig;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.DefaultHttpClientConnectionOperator;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.execchain.ClientExecChain;
import org.apache.http.impl.execchain.MainClientExec;
import org.apache.http.localserver.LocalServerTestBase;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpRequestHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import com.onlinepayments.BodyHandler;
import com.onlinepayments.Communicator;
import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.Factory;
import com.onlinepayments.ProxyConfiguration;
import com.onlinepayments.authentication.Authenticator;
import com.onlinepayments.domain.UploadableFile;
import com.onlinepayments.logging.CommunicatorLogger;
import com.onlinepayments.util.ReflectionUtil;
import com.onlinepayments.util.ResponseHeaderMatcher;

class DefaultConnectionTest {

    private static final int CONNECTION_REQUEST_TIMEOUT = 10000;
    private static final int CONNECT_TIMEOUT = 10000;
    private static final int SOCKET_TIMEOUT  = 20000;
    private static final int MAX_CONNECTIONS = 100;

    @Nested
    class WhenConstructingDefaultConnection {

        @Nested
        class WhenConstructedWithoutBuilder {

            @Test
            @SuppressWarnings("resource")
            void shouldUseDefaultConfiguration() {
                DefaultConnection connection = new DefaultConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
                assertRequestConfig(connection, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
                assertMaxConnections(connection, CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, null);
                assertConnectionReuseStrategy(connection, true);
                assertNoProxy(connection);
                assertSupportedHttpsProtocols(connection, CommunicatorConfiguration.DEFAULT_HTTPS_PROTOCOLS);
            }
        }

        @Nested
        class WhenBuiltWithProxy {

            @Nested
            class WithoutAuthentication {

                @Test
                @SuppressWarnings("resource")
                void shouldUseConfiguredProxy() {
                    ProxyConfiguration proxyConfiguration = new ProxyConfiguration(URI.create("http://test-proxy"));

                    DefaultConnection connection = new DefaultConnectionBuilder(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT)
                            .withProxyConfiguration(proxyConfiguration)
                            .build();
                    assertRequestConfig(connection, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
                    assertMaxConnections(connection, CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, proxyConfiguration);
                    assertConnectionReuseStrategy(connection, true);
                    assertProxy(connection, proxyConfiguration);
                    assertSupportedHttpsProtocols(connection, CommunicatorConfiguration.DEFAULT_HTTPS_PROTOCOLS);
                }
            }

            @Nested
            class WithAuthentication {

                @Test
                @SuppressWarnings("resource")
                void shouldUseConfiguredAuthenticatedProxy() {
                    ProxyConfiguration proxyConfiguration = new ProxyConfiguration(URI.create("http://test-proxy"), "test-username", "test-password");

                    DefaultConnection connection = new DefaultConnectionBuilder(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT)
                            .withProxyConfiguration(proxyConfiguration)
                            .build();
                    assertRequestConfig(connection, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
                    assertMaxConnections(connection, CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, proxyConfiguration);
                    assertConnectionReuseStrategy(connection, true);
                    assertProxy(connection, proxyConfiguration);
                    assertSupportedHttpsProtocols(connection, CommunicatorConfiguration.DEFAULT_HTTPS_PROTOCOLS);
                }
            }
        }

        @Nested
        class WhenBuiltWithMaxConnections {

            @Nested
            class WithoutProxy {

                @Test
                @SuppressWarnings("resource")
                void shouldUseConfiguredMaxConnections() {
                    DefaultConnection connection = new DefaultConnectionBuilder(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT)
                            .withMaxConnections(MAX_CONNECTIONS)
                            .build();
                    assertRequestConfig(connection, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
                    assertMaxConnections(connection, MAX_CONNECTIONS, null);
                    assertConnectionReuseStrategy(connection, true);
                    assertNoProxy(connection);
                    assertSupportedHttpsProtocols(connection, CommunicatorConfiguration.DEFAULT_HTTPS_PROTOCOLS);
                }
            }

            @Nested
            class WithProxy {

                @Test
                @SuppressWarnings("resource")
                void shouldUseConfiguredMaxConnectionsPerProxyRoute() {
                    ProxyConfiguration proxyConfiguration = new ProxyConfiguration(URI.create("http://test-proxy"));

                    DefaultConnection connection = new DefaultConnectionBuilder(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT)
                            .withMaxConnections(MAX_CONNECTIONS)
                            .withProxyConfiguration(proxyConfiguration)
                            .build();
                    assertRequestConfig(connection, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
                    assertMaxConnections(connection, MAX_CONNECTIONS, proxyConfiguration);
                    assertConnectionReuseStrategy(connection, true);
                    assertProxy(connection, proxyConfiguration);
                    assertSupportedHttpsProtocols(connection, CommunicatorConfiguration.DEFAULT_HTTPS_PROTOCOLS);
                }
            }
        }

        @Nested
        class WhenBuiltWithConnectionReuseDisabled {

            @Test
            @SuppressWarnings("resource")
            void shouldUseDefaultConfigurationWithConnectionReuseDisabled() {
                DefaultConnection connection = new DefaultConnectionBuilder(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT)
                        .withConnectionReuse(false)
                        .build();
                assertRequestConfig(connection, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
                assertMaxConnections(connection, CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, null);
                assertConnectionReuseStrategy(connection, false);
                assertNoProxy(connection);
                assertSupportedHttpsProtocols(connection, CommunicatorConfiguration.DEFAULT_HTTPS_PROTOCOLS);
            }
        }

        @Nested
        class WhenBuiltWithHttpsProtocols {

            @Test
            @SuppressWarnings("resource")
            void shouldUseConfiguredHttpsProtocols() {
                Set<String> httpsProtocols = new HashSet<>(Arrays.asList("TLSv1", "TLSv1.1", "TLSv1.2"));

                DefaultConnection connection = new DefaultConnectionBuilder(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT)
                        .withMaxConnections(MAX_CONNECTIONS)
                        .withHttpsProtocols(httpsProtocols)
                        .build();
                assertRequestConfig(connection, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
                assertMaxConnections(connection, MAX_CONNECTIONS, null);
                assertConnectionReuseStrategy(connection, true);
                assertNoProxy(connection);
                assertSupportedHttpsProtocols(connection, httpsProtocols);
            }

            @Test
            @SuppressWarnings("resource")
            void shouldUseDefaultHttpsProtocolsWhenProtocolsAreEmpty() {
                Set<String> httpsProtocols = Collections.emptySet();

                DefaultConnection connection = new DefaultConnectionBuilder(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT)
                        .withMaxConnections(MAX_CONNECTIONS)
                        .withHttpsProtocols(httpsProtocols)
                        .build();
                assertRequestConfig(connection, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
                assertMaxConnections(connection, MAX_CONNECTIONS, null);
                assertConnectionReuseStrategy(connection, true);
                assertNoProxy(connection);
                assertSupportedHttpsProtocols(connection, CommunicatorConfiguration.DEFAULT_HTTPS_PROTOCOLS);
            }

            @Test
            @SuppressWarnings("resource")
            void shouldUseDefaultHttpsProtocolsWhenProtocolsAreNull() {
                Set<String> httpsProtocols = null;

                DefaultConnection connection = new DefaultConnectionBuilder(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT)
                        .withMaxConnections(MAX_CONNECTIONS)
                        .withHttpsProtocols(httpsProtocols)
                        .build();
                assertRequestConfig(connection, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
                assertMaxConnections(connection, MAX_CONNECTIONS, null);
                assertConnectionReuseStrategy(connection, true);
                assertNoProxy(connection);
                assertSupportedHttpsProtocols(connection, CommunicatorConfiguration.DEFAULT_HTTPS_PROTOCOLS);
            }
        }

        @Nested
        class WhenBuiltWithDefaultOptions {

            @Test
            @SuppressWarnings("resource")
            void shouldUseDefaultConfiguration() {
                DefaultConnection connection = new DefaultConnectionBuilder(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT)
                        .build();
                assertRequestConfig(connection, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
                assertMaxConnections(connection, CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, null);
                assertConnectionReuseStrategy(connection, true);
                assertNoProxy(connection);
                assertSupportedHttpsProtocols(connection, CommunicatorConfiguration.DEFAULT_HTTPS_PROTOCOLS);
            }
        }

        @Nested
        class WhenBuiltWithAllOptions {

            @Test
            @SuppressWarnings("resource")
            void shouldUseConfiguredConnection() {
                ProxyConfiguration proxyConfiguration = new ProxyConfiguration(URI.create("http://test-proxy"));
                Set<String> httpsProtocols = new HashSet<>(Arrays.asList("TLSv1", "TLSv1.1", "TLSv1.2"));

                DefaultConnection connection = new DefaultConnectionBuilder(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT)
                        .withMaxConnections(MAX_CONNECTIONS)
                        .withConnectionReuse(false)
                        .withProxyConfiguration(proxyConfiguration)
                        .withHttpsProtocols(httpsProtocols)
                        .build();
                assertRequestConfig(connection, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
                assertMaxConnections(connection, MAX_CONNECTIONS, proxyConfiguration);
                assertConnectionReuseStrategy(connection, false);
                assertProxy(connection, proxyConfiguration);
                assertSupportedHttpsProtocols(connection, httpsProtocols);
            }
        }

        @SuppressWarnings("resource")
        private void assertConnectionReuseStrategy(DefaultConnection connection, boolean connectionReuse) {
            CloseableHttpClient httpClient = ReflectionUtil.getField(connection, "httpClient", CloseableHttpClient.class);
            ClientExecChain execChain = ReflectionUtil.getField(httpClient, "execChain", ClientExecChain.class);
            while (execChain != null && !(execChain instanceof MainClientExec)) {
                execChain = ReflectionUtil.getField(execChain, "requestExecutor", ClientExecChain.class);
            }
            assertNotNull(execChain);
            ConnectionReuseStrategy reuseStrategy = ReflectionUtil.getField(execChain, "reuseStrategy", ConnectionReuseStrategy.class);

            if (connectionReuse) {
                assertNotNull(reuseStrategy);
                assertNotSame(NoConnectionReuseStrategy.INSTANCE, reuseStrategy);
            } else {
                assertSame(NoConnectionReuseStrategy.INSTANCE, reuseStrategy);
            }
        }

        @SuppressWarnings("resource")
        private void assertSupportedHttpsProtocols(DefaultConnection connection, Set<String> httpsProtocols) {
            CloseableHttpClient httpClient = ReflectionUtil.getField(connection, "httpClient", CloseableHttpClient.class);
            PoolingHttpClientConnectionManager connectionManager = ReflectionUtil.getField(httpClient, "connManager", PoolingHttpClientConnectionManager.class);
            DefaultHttpClientConnectionOperator connectionOperator = ReflectionUtil.getField(connectionManager, "connectionOperator", DefaultHttpClientConnectionOperator.class);
            Registry<?> socketFactoryRegistry = ReflectionUtil.getField(connectionOperator, "socketFactoryRegistry", Registry.class);
            SSLConnectionSocketFactory sslConnectionSocketFactory = (SSLConnectionSocketFactory) socketFactoryRegistry.lookup("https");
            String[] supportedProtocols = ReflectionUtil.getField(sslConnectionSocketFactory, "supportedProtocols", String[].class);
            assertNotNull(supportedProtocols);
            assertEquals(httpsProtocols, new HashSet<>(Arrays.asList(supportedProtocols)));
        }
    }

    @Nested
    class WhenSettingObfuscators {

        @Test
        @SuppressWarnings("resource")
        void shouldThrowIllegalArgumentExceptionWhenBodyObfuscatorIsNull() {
            DefaultConnection connection = new DefaultConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> connection.setBodyObfuscator(null)
            );
            assertEquals("bodyObfuscator is required", exception.getMessage());
        }

        @Test
        @SuppressWarnings("resource")
        void shouldThrowIllegalArgumentExceptionWhenHeaderObfuscatorIsNull() {
            DefaultConnection connection = new DefaultConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> connection.setHeaderObfuscator(null)
            );
            assertEquals("headerObfuscator is required", exception.getMessage());
        }
    }

    @Nested
    class WhenAddingHeaders {

        @Test
        @SuppressWarnings("resource")
        void shouldAddRequestHeadersToHttpRequest() {
            DefaultConnection connection = new DefaultConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
            HttpGet httpGet = new HttpGet("http://example.com");
            List<RequestHeader> requestHeaders = Arrays.asList(
                new RequestHeader("Authorization", "Bearer token123"),
                new RequestHeader("Content-Type", "application/json")
            );

            connection.addHeaders(httpGet, requestHeaders);

            Header[] headers = httpGet.getAllHeaders();
            assertEquals(2, headers.length);
            assertEquals("Authorization", headers[0].getName());
            assertEquals("Bearer token123", headers[0].getValue());
            assertEquals("Content-Type", headers[1].getName());
            assertEquals("application/json", headers[1].getValue());
        }

        @Test
        @SuppressWarnings("resource")
        void shouldHandleNullRequestHeaders() {
            DefaultConnection connection = new DefaultConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
            HttpGet httpGet = new HttpGet("http://example.com");

            assertDoesNotThrow(() -> connection.addHeaders(httpGet, null));

            assertEquals(0, httpGet.getAllHeaders().length);
        }

        @Test
        @SuppressWarnings("resource")
        void shouldHandleEmptyRequestHeaders() {
            DefaultConnection connection = new DefaultConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
            HttpGet httpGet = new HttpGet("http://example.com");

            assertDoesNotThrow(() -> connection.addHeaders(httpGet, Collections.emptyList()));

            assertEquals(0, httpGet.getAllHeaders().length);
        }
    }

    @Nested
    class WhenGettingHeaders {

        @Test
        @SuppressWarnings("resource")
        void shouldConvertHttpResponseHeadersToResponseHeaders() {
            DefaultConnection connection = new DefaultConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
            HttpResponse httpResponse = mock(HttpResponse.class);
            Header[] headers = new Header[] {
                    new BasicHeader("Content-Type", "application/json"),
                    new BasicHeader("Content-Length", "1234"),
            };
            when(httpResponse.getAllHeaders()).thenReturn(headers);

            List<ResponseHeader> result = connection.getHeaders(httpResponse);

            assertEquals(2, result.size());
            assertEquals("Content-Type", result.get(0).getName());
            assertEquals("application/json", result.get(0).getValue());
            assertEquals("Content-Length", result.get(1).getName());
            assertEquals("1234", result.get(1).getValue());
        }

        @Test
        @SuppressWarnings("resource")
        void shouldHandleResponseWithNoHeaders() {
            DefaultConnection connection = new DefaultConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
            HttpResponse httpResponse = mock(HttpResponse.class);
            when(httpResponse.getAllHeaders()).thenReturn(new Header[0]);

            List<ResponseHeader> result = connection.getHeaders(httpResponse);

            assertTrue(result.isEmpty());
        }
    }

    @Nested
    class WhenEnablingAndDisablingLogging {

        @Test
        @SuppressWarnings("resource")
        void shouldEnableLogging() {
            DefaultConnection connection = new DefaultConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
            CommunicatorLogger logger = mock(CommunicatorLogger.class);

            assertDoesNotThrow(() -> connection.enableLogging(logger));
        }

        @Test
        @SuppressWarnings("resource")
        void shouldThrowIllegalArgumentExceptionWhenCommunicatorLoggerIsNull() {
            DefaultConnection connection = new DefaultConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);

            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> connection.enableLogging(null)
            );
            assertEquals("communicatorLogger is required", exception.getMessage());
        }

        @Test
        @SuppressWarnings("resource")
        void shouldDisableLogging() {
            DefaultConnection connection = new DefaultConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);

            assertDoesNotThrow(connection::disableLogging);
        }
    }

    @Nested
    class WhenClosingIdleConnections {

        @Test
        @SuppressWarnings("resource")
        void shouldNotThrow() {
            DefaultConnection connection = new DefaultConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);

            assertDoesNotThrow(() -> connection.closeIdleConnections(5, TimeUnit.SECONDS));
        }
    }

    @Nested
    class WhenClosingExpiredConnections {

        @Test
        @SuppressWarnings("resource")
        void shouldNotThrow() {
            DefaultConnection connection = new DefaultConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);

            assertDoesNotThrow(connection::closeExpiredConnections);
        }
    }

    @Nested
    class WhenClosingConnection {

        @Test
        @SuppressWarnings("resource")
        void shouldCloseHttpClient() throws IOException {
            DefaultConnection connection = new DefaultConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);

            assertDoesNotThrow(connection::close);
        }
    }

    @Nested
    class WhenLoggingIsEnabled extends LocalServerTestBase {

        private HttpRequestHandler requestHandler;

        @BeforeEach
        void setUpServer() throws Exception {
            setUp();

            requestHandler = mock(HttpRequestHandler.class);
        }

        @AfterEach
        void tearDownServer() throws Exception {
            shutDown();
        }

        @Nested
        class WhenGetting {

            @Test
            void shouldLogExpectedRequestAndResponseWithoutQueryParams() throws Exception {
                serverBootstrap.registerHandler("/v1/get", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                setUpRequestHandler(setOKJsonResponse("getWithoutQueryParams.json"));

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);

                    Map<?, ?> response = communicator.get("v1/get", null, null, Map.class, null);

                    assertNotNull(response);
                    assertEquals("OK", response.get("result"));
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);

                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry responseEntry = logger.entries.get(1);

                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertRequestAndResponse(requestEntry.message, responseEntry.message, "getWithoutQueryParams");
            }

            @Test
            void shouldLogExpectedRequestAndResponseWithQueryParams() throws Exception {
                serverBootstrap.registerHandler("/v1/get", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                setUpRequestHandler(setOKJsonResponse("getWithQueryParams.json"));

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);

                    ParamRequest params = () -> Arrays.asList(
                        new RequestParam("source", "EUR"),
                        new RequestParam("target", "USD"),
                        new RequestParam("amount", "1000"));

                    Map<?, ?> response = communicator.get("v1/get", null, params, Map.class, null);

                    assertNotNull(response);
                    assertEquals(4547504D, response.get("convertedAmount"));
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);

                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry responseEntry = logger.entries.get(1);

                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertRequestAndResponse(requestEntry.message, responseEntry.message, "getWithQueryParams");
            }

            @Test
            @SuppressWarnings("resource")
            void shouldLogExpectedRequestAndResponseWithUtf8Response() throws Exception {
                serverBootstrap.registerHandler("/v1/get-utf8", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                setUpRequestHandler(setOKJsonResponse("getWithUtf8Response.json"));

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);

                    Map<?, ?> response = communicator.get("v1/get-utf8", null, null, Map.class, null);

                    assertNotNull(response);
                    assertEquals("café 日本語", response.get("message"));
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);
                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry responseEntry = logger.entries.get(1);
                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertRequestAndResponse(requestEntry.message, responseEntry.message, "getWithUtf8Response");
            }
        }

        @Nested
        class WhenPosting {

            @Test
            void shouldLogExpectedRequestAndResponseWithSuccessResponse() throws Exception {
                serverBootstrap.registerHandler("/v1/created", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                setUpRequestHandler(setCreatedJsonResponse("postWithCreatedResponse.json", "http://localhost/v1/created/000000123410000595980000100001"));

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);

                    Map<String, Object> card = new LinkedHashMap<>();
                    card.put("cvv", "123");
                    card.put("cardNumber", "1234567890123456");
                    card.put("expiryDate", "1220");

                    Map<String, Object> request = new LinkedHashMap<>();
                    request.put("card", card);

                    Map<?, ?> response = communicator.post("/v1/created", null, null, request, Map.class, null);

                    assertNotNull(response);
                    Map<?, ?> payment = assertInstanceOf(Map.class, response.get("payment"));
                    assertEquals("000000123410000595980000100001", payment.get("id"));
                    assertEquals("PENDING_APPROVAL", payment.get("status"));
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);

                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry responseEntry = logger.entries.get(1);

                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertRequestAndResponse(requestEntry.message, responseEntry.message, "postWithCreatedResponse");
            }

            @Test
            void shouldLogExpectedRequestAndResponseBeforeThrowingWithClientErrorResponse() throws Exception {
                // an exception is thrown after logging the response

                serverBootstrap.registerHandler("/v1/bad-request", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                setUpRequestHandler(setJsonResponse("postWithBadRequestResponse.json", 400));

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);

                    Map<String, Object> card = new LinkedHashMap<>();
                    card.put("cvv", "123");
                    card.put("cardNumber", "1234567890123456");
                    card.put("expiryDate", "1220");

                    Map<String, Object> request = new LinkedHashMap<>();
                    request.put("card", card);

                    assertThrows(ResponseException.class, () -> communicator.post("/v1/bad-request", null, null, request, Map.class, null));
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);

                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry responseEntry = logger.entries.get(1);

                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertRequestAndResponse(requestEntry.message, responseEntry.message, "postWithBadRequestResponse");
            }
        }

        @Nested
        class WhenPutting {

            @Test
            @SuppressWarnings("resource")
            void shouldLogExpectedRequestAndResponseWithSuccessResponse() throws Exception {
                serverBootstrap.registerHandler("/v1/put", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                setUpRequestHandler(setJsonResponse("putWithSuccessResponse.json", 200));

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);

                    Map<String, Object> request = new LinkedHashMap<>();
                    request.put("key", "value");

                    Map<?, ?> response = communicator.put("v1/put", null, null, request, Map.class, null);

                    assertNotNull(response);
                    assertEquals("OK", response.get("result"));
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);
                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry responseEntry = logger.entries.get(1);
                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertRequestAndResponse(requestEntry.message, responseEntry.message, "putWithSuccessResponse");
            }

            @Test
            @SuppressWarnings("resource")
            void shouldLogExpectedRequestAndResponseBeforeThrowingWithBadRequestResponse() throws Exception {
                serverBootstrap.registerHandler("/v1/put-bad-request", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                setUpRequestHandler(setJsonResponse("putWithBadRequestResponse.json", 400));

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);

                    Map<String, Object> request = new LinkedHashMap<>();
                    request.put("key", "value");

                    assertThrows(ResponseException.class,
                            () -> communicator.put("v1/put-bad-request", null, null, request, Map.class, null));
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);
                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry responseEntry = logger.entries.get(1);
                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertRequestAndResponse(requestEntry.message, responseEntry.message, "putWithBadRequestResponse");
            }
        }

        @Nested
        class WhenDeleting {

            @Test
            void shouldLogExpectedRequestAndResponseWithVoidResponse() throws Exception {
                serverBootstrap.registerHandler("/v1/void", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                setUpRequestHandler(setVoidResponse());

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);

                    communicator.delete("/v1/void", null, null, Void.class, null);
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);

                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry responseEntry = logger.entries.get(1);

                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertRequestAndResponse(requestEntry.message, responseEntry.message, "deleteWithVoidResponse");
            }

            @Test
            void shouldLogExpectedRequestAndResponseAndPassEmptyBodyToHandlerVoidContent() throws Exception {
                serverBootstrap.registerHandler("/v1/void", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                setUpRequestHandler(setVoidResponse());

                // also test that the body handler is called correctly
                BodyHandler bodyHandler = (bodyStream, headers) -> assertEquals(-1, bodyStream.read());

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);

                    communicator.delete("/v1/void", null, null, bodyHandler, null);
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);

                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry responseEntry = logger.entries.get(1);

                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertRequestAndResponse(requestEntry.message, responseEntry.message, "deleteWithVoidResponse");
            }
        }

        @Nested
        class WhenHandlingBinaryRequests {

            @Test
            void shouldLogContentLengthWithoutChunkedTransferEncodingWithKnownLength() throws Exception {
                serverBootstrap.registerHandler("/binaryRequest", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                byte[] data = new byte[1024];
                new Random().nextBytes(data);

                UploadableFile file = new UploadableFile("dummyFile", new ByteArrayInputStream(data), "application/octetstream", data.length);

                MultipartFormDataObject multipart = new MultipartFormDataObject();
                multipart.addFile("file", file);

                setUpRequestHandler(setVoidResponse());

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);

                    communicator.post("/binaryRequest", new ArrayList<>(), null, multipart, Void.class, null);
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);

                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry responseEntry = logger.entries.get(1);

                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertRequestAndResponse(requestEntry.message, responseEntry.message, "binaryRequest");

                assertThat(requestEntry.message, containsString("Content-Length="));
                assertThat(requestEntry.message, not(containsString("Transfer-Encoding=\"chunked\"")));
            }

            @Test
            void shouldLogChunkedTransferEncodingWithoutContentLengthWithUnknownLength() throws Exception {
                serverBootstrap.registerHandler("/binaryRequest", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                byte[] data = new byte[1024];
                new Random().nextBytes(data);

                UploadableFile file = new UploadableFile("dummyFile", new ByteArrayInputStream(data), "application/octetstream");

                MultipartFormDataObject multipart = new MultipartFormDataObject();
                multipart.addFile("file", file);

                setUpRequestHandler(setVoidResponse());

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);

                    communicator.post("/binaryRequest", new ArrayList<>(), null, multipart, Void.class, null);
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);

                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry responseEntry = logger.entries.get(1);

                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertRequestAndResponse(requestEntry.message, responseEntry.message, "binaryRequest");

                assertThat(requestEntry.message, not(containsString("Content-Length=")));
                assertThat(requestEntry.message, containsString("Transfer-Encoding=\"chunked\""));
            }
        }

        @Nested
        class WhenHandlingBinaryResponses {

            @Test
            void shouldLogExpectedRequestAndResponseAndPassBodyToResponseHandler() throws Exception {
                serverBootstrap.registerHandler("/binaryContent", requestHandler);
                HttpHost host = start();

                URI uri = toURI(host, "/binaryContent");

                TestLogger logger = new TestLogger();

                byte[] data = new byte[1024];
                new Random().nextBytes(data);

                setUpRequestHandler(setBinaryResponse(data, 200));

                // also test that the response handler is called correctly
                ResponseHandler<?> responseHandler = (statusCode, bodyStream, headers) -> {
                    ByteArrayOutputStream output = new ByteArrayOutputStream(data.length);
                    try {
                        byte[] buffer = new byte[data.length];
                        int len;
                        while ((len = bodyStream.read(buffer)) != -1) {
                            output.write(buffer, 0, len);
                        }
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    }

                    assertEquals(200, statusCode);
                    assertArrayEquals(data, output.toByteArray());
                    assertThat(headers, hasItems(
                        new ResponseHeaderMatcher("Dummy", ""),
                        new ResponseHeaderMatcher("Content-Type", "application/octet-stream"),
                        new ResponseHeaderMatcher("Content-Length", "1024")
                    ));

                    return null;
                };

                try (Connection connection = createConnection()) {
                    connection.enableLogging(logger);

                    connection.get(uri, new ArrayList<>(), responseHandler);
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);

                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry responseEntry = logger.entries.get(1);

                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertRequestAndResponse(requestEntry.message, responseEntry.message, "binaryResponse");
            }
        }

        @Nested
        class WhenHandlingErrors {

            @Test
            void shouldLogExpectedRequestAndErrorResponseWithUnknownServerError() throws Exception {
                // reuse the request from getWithoutQueryParams
                serverBootstrap.registerHandler("/v1/get", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                setUpRequestHandler(setJsonResponse("unknownServerError.json", 500));

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);

                    assertThrows(ResponseException.class, () -> communicator.get("v1/get", null, null, Map.class, null));
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);

                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry responseEntry = logger.entries.get(1);

                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertRequestAndResponse(requestEntry.message, responseEntry.message, "getWithoutQueryParams", "unknownServerError");
            }

            @Test
            void shouldLogExpectedRequestAndResponseBeforeThrowingWithInvalidHtmlResponse() throws Exception {
                // reuse the request from getWithoutQueryParams
                serverBootstrap.registerHandler("/v1/get", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                setUpRequestHandler(setHtmlResponse("notFound.html", 404));

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);

                    assertThrows(NotFoundException.class, () -> communicator.get("v1/get", null, null, Map.class, null));
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);

                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry responseEntry = logger.entries.get(1);

                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertRequestAndResponse(requestEntry.message, responseEntry.message, "getWithoutQueryParams", "notFound");
            }

            @Test
            void shouldLogRequestAndErrorWithCommunicationException() throws Exception {
                // an exception is thrown before logging the response

                // reuse the request from getWithoutQueryParams
                serverBootstrap.registerHandler("/v1/get", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                setUpRequestHandler(delayedAnswer(setHtmlResponse("notFound.html", 404), 100));

                try (Communicator communicator = createCommunicator(host, 1000, 1000, 10)) {
                    communicator.enableLogging(logger);

                    assertThrows(CommunicationException.class, () -> communicator.get("v1/get", null, null, Map.class, null));
                }

                assertEquals(2, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);

                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                TestLoggerEntry errorEntry = logger.entries.get(1);

                assertNotNull(errorEntry.message);
                assertNotNull(errorEntry.thrown);

                assertRequestAndError(requestEntry.message, errorEntry.message, "getWithoutQueryParams");

                assertEquals(SocketTimeoutException.class, errorEntry.thrown.getClass());
            }
        }

        @Nested
        class WhenDisablingLogging {

            @Test
            void shouldNotLogSubsequentRequestsAfterLoggingIsDisabled() throws Exception {
                serverBootstrap.registerHandler("/v1/get", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                setUpRequestHandler(setOKJsonResponse("getWithoutQueryParams.json"));

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);
                    communicator.disableLogging();

                    Map<?, ?> response = communicator.get("v1/get", null, null, Map.class, null);

                    assertNotNull(response);
                    assertEquals("OK", response.get("result"));
                }

                assertEquals(0, logger.entries.size());
            }
        }

        @Nested
        class WhenLoggingStateChangesDuringRequestLifecycle {

            @Test
            void shouldLogRequestOnlyWhenLoggingIsDisabledBeforeResponse() throws Exception {
                // logging is disabled after the request is logged but before the response is logged

                // reuse the request and response from getWithoutQueryParams
                serverBootstrap.registerHandler("/v1/get", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                try (Communicator communicator = createCommunicator(host)) {
                    communicator.enableLogging(logger);

                    setUpRequestHandler(disableLogging(setOKJsonResponse("getWithoutQueryParams.json"), communicator));

                    Map<?, ?> response = communicator.get("v1/get", null, null, Map.class, null);

                    assertNotNull(response);
                    assertEquals("OK", response.get("result"));
                }

                assertEquals(1, logger.entries.size());

                TestLoggerEntry requestEntry = logger.entries.get(0);

                assertNotNull(requestEntry.message);
                assertNull(requestEntry.thrown);

                assertRequest(requestEntry.message, "getWithoutQueryParams");
            }

            @Test
            void shouldLogResponseOnlyWhenLoggingIsEnabledAfterRequest() throws Exception {
                // logging is enabled after the request is logged but before the response is logged

                // reuse the request and response from getWithoutQueryParams
                serverBootstrap.registerHandler("/v1/get", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                try (Communicator communicator = createCommunicator(host)) {
                    setUpRequestHandler(enableLogging(setOKJsonResponse("getWithoutQueryParams.json"), communicator, logger));

                    Map<?, ?> response = communicator.get("v1/get", null, null, Map.class, null);

                    assertNotNull(response);
                    assertEquals("OK", response.get("result"));
                }

                assertEquals(1, logger.entries.size());

                TestLoggerEntry responseEntry = logger.entries.get(0);

                assertNotNull(responseEntry.message);
                assertNull(responseEntry.thrown);

                assertResponse(responseEntry.message, "getWithoutQueryParams");
            }

            @Test
            void shouldLogErrorOnlyWhenLoggingIsEnabledAfterRequestFailure() throws Exception {
                // logging is enabled after the request is logged but before the error is logged

                // reuse the request from getWithoutQueryParams
                serverBootstrap.registerHandler("/v1/get", requestHandler);
                HttpHost host = start();

                TestLogger logger = new TestLogger();

                try (Communicator communicator = createCommunicator(host, 1000, 1000, 100)) {
                    setUpRequestHandler(enableLogging(delayedAnswer(setHtmlResponse("notFound.html", 404), 200), communicator, logger));

                    assertThrows(CommunicationException.class, () -> communicator.get("v1/get", null, null, Map.class, null));
                }

                assertEquals(1, logger.entries.size());

                TestLoggerEntry errorEntry = logger.entries.get(0);

                assertNotNull(errorEntry.message);
                assertNotNull(errorEntry.thrown);

                assertError(errorEntry.message);

                assertEquals(SocketTimeoutException.class, errorEntry.thrown.getClass());
            }
        }

        private String assertRequestAndResponse(String requestMessage, String responseMessage, String resourcePrefix) throws IOException {
            return assertRequestAndResponse(requestMessage, responseMessage, resourcePrefix, resourcePrefix);
        }

        private String assertRequestAndResponse(String requestMessage, String responseMessage, String requestResourcePrefix, String responseResourcePrefix) throws IOException {
            String requestId = assertRequest(requestMessage, requestResourcePrefix);
            requestId = assertResponse(responseMessage, responseResourcePrefix, requestId);
            return requestId;
        }

        private String assertRequestAndError(String requestMessage, String errorMessage, String resourcePrefix) throws IOException {
            String requestId = assertRequest(requestMessage, resourcePrefix);
            requestId = assertError(errorMessage, requestId);
            return requestId;
        }

        private String assertRequest(String requestMessage, String resourcePrefix) throws IOException {
            String requestResource = resourcePrefix + ".request";

            Pattern requestPattern = Pattern.compile(normalizeLineBreaks(readResource(requestResource)), Pattern.DOTALL);

            Matcher requestMatcher = requestPattern.matcher(normalizeLineBreaks(requestMessage));
            assertTrue(requestMatcher.matches(), "request message '" + requestMessage + "' does not match pattern " + requestPattern);

            String requestId = requestMatcher.group(1);

            return requestId;
        }

        private String assertResponse(String responseMessage, String resourcePrefix) throws IOException {
            return assertResponse(responseMessage, resourcePrefix, null);
        }

        private String assertResponse(String responseMessage, String resourcePrefix, String requestId) throws IOException {
            String responseResource = resourcePrefix + ".response";
            Pattern responsePattern = Pattern.compile(normalizeLineBreaks(readResource(responseResource)), Pattern.DOTALL);

            Matcher responseMatcher = responsePattern.matcher(normalizeLineBreaks(responseMessage));
            assertTrue(responseMatcher.matches(), "response message '" + responseMessage + "' does not match pattern " + responsePattern);

            String responseRequestId = responseMatcher.group(1);
            if (requestId != null) {
                assertEquals(requestId, responseRequestId,
                        "response requestId '" + responseRequestId + "' does not match request requestId '" + requestId + "'");
            } else {
                requestId = responseRequestId;
            }

            return requestId;
        }

        private String assertError(String errorMessage) throws IOException {
            return assertError(errorMessage, null);
        }

        private String assertError(String errorMessage, String requestId) throws IOException {
            String errorResource = "generic.error";
            Pattern errorPattern = Pattern.compile(normalizeLineBreaks(readResource(errorResource)), Pattern.DOTALL);

            Matcher errorMatcher = errorPattern.matcher(normalizeLineBreaks(errorMessage));
            assertTrue(errorMatcher.matches(), "error message '" + errorMessage + "' does not match pattern " + errorPattern);

            String errorRequestId = errorMatcher.group(1);
            if (requestId != null) {
                assertEquals(requestId, errorRequestId,
                        "error requestId '" + errorRequestId + "' does not match earlier requestId '" + requestId + "'");
            } else {
                requestId = errorRequestId;
            }

            return requestId;
        }

        // Mockito answer utility methods

        private void setUpRequestHandler(Answer<Void> answer) throws IOException, HttpException {
            doAnswer(answer).when(requestHandler).handle(any(), any(), any());
        }

        private Answer<Void> setVoidResponse() {
            return setVoidResponse(Collections.emptyMap());
        }

        private Answer<Void> setVoidResponse(Map<String, String> additionalHeaders) {
            return i -> {
                HttpResponse response = i.getArgument(1, HttpResponse.class);

                response.setStatusCode(204);

                response.setHeader("Dummy", null);

                for (Map.Entry<String, String> entry : additionalHeaders.entrySet()) {
                    response.setHeader(entry.getKey(), entry.getValue());
                }

                return null;
            };
        }

        private Answer<Void> setOKJsonResponse(String resource) {
            return setJsonResponse(resource, 200, Collections.emptyMap());
        }

        private Answer<Void> setCreatedJsonResponse(String resource, String location) {
            return setJsonResponse(resource, 201, Collections.singletonMap("Location", location));
        }

        private Answer<Void> setJsonResponse(String resource, int statusCode) {
            return setJsonResponse(resource, statusCode, Collections.emptyMap());
        }

        private Answer<Void> setJsonResponse(String resource, int statusCode, Map<String, String> additionalHeaders) {
            return i -> {
                HttpResponse response = i.getArgument(1, HttpResponse.class);

                response.setStatusCode(statusCode);
                response.setHeader("Content-Type", "application/json");

                response.setHeader("Dummy", null);

                for (Map.Entry<String, String> entry : additionalHeaders.entrySet()) {
                    response.setHeader(entry.getKey(), entry.getValue());
                }

                response.setEntity(createEntity(resource));

                return null;
            };
        }

        private Answer<Void> setHtmlResponse(String resource, int statusCode) {
            return setHtmlResponse(resource, statusCode, Collections.emptyMap());
        }

        private Answer<Void> setHtmlResponse(String resource, int statusCode, Map<String, String> additionalHeaders) {
            return i -> {
                HttpResponse response = i.getArgument(1, HttpResponse.class);

                response.setStatusCode(statusCode);
                response.setHeader("Content-Type", "text/html");

                response.setHeader("Dummy", null);

                for (Map.Entry<String, String> entry : additionalHeaders.entrySet()) {
                    response.setHeader(entry.getKey(), entry.getValue());
                }

                response.setEntity(createEntity(resource));

                return null;
            };
        }

        private Answer<Void> setBinaryResponse(byte[] data, int statusCode) {
            return setBinaryResponse(data, statusCode, Collections.emptyMap());
        }

        private Answer<Void> setBinaryResponse(byte[] data, int statusCode, Map<String, String> additionalHeaders) {
            return i -> {
                HttpResponse response = i.getArgument(1, HttpResponse.class);

                response.setStatusCode(statusCode);
                response.setHeader("Content-Type", "application/octet-stream");

                response.setHeader("Dummy", null);

                for (Map.Entry<String, String> entry : additionalHeaders.entrySet()) {
                    response.setHeader(entry.getKey(), entry.getValue());
                }

                response.setEntity(new ByteArrayEntity(data, ContentType.APPLICATION_OCTET_STREAM));

                return null;
            };
        }

        private <T> Answer<T> delayedAnswer(Answer<? extends T> answer, int delay) {
            return i -> {
                Thread.sleep(delay);
                return answer.answer(i);
            };
        }

        private <T> Answer<T> enableLogging(Answer<? extends T> answer, Communicator communicator, CommunicatorLogger communicatorLogger) {
            return i -> {
                communicator.enableLogging(communicatorLogger);
                return answer.answer(i);
            };
        }

        private <T> Answer<T> disableLogging(Answer<? extends T> answer, Communicator communicator) {
            return i -> {
                communicator.disableLogging();
                return answer.answer(i);
            };
        }

        @SuppressWarnings("resource")
        private InputStreamEntity createEntity(String resource) {
            return new InputStreamEntity(getClass().getResourceAsStream(resource));
        }

        // general utility methods

        private URI toURI(HttpHost host, String path) throws URISyntaxException {
            return new URI(host.getSchemeName(), null, host.getHostName(), host.getPort(), path, null, null);
        }

        private Connection createConnection() {
            return createConnection(CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
        }

        private Connection createConnection(int connectionRequestTimeout, int connectTimeout, int socketTimeout) {
            return new DefaultConnection(connectionRequestTimeout, connectTimeout, socketTimeout);
        }

        private Communicator createCommunicator(HttpHost host) throws URISyntaxException {
            return createCommunicator(host, CONNECTION_REQUEST_TIMEOUT, CONNECT_TIMEOUT, SOCKET_TIMEOUT);
        }

        @SuppressWarnings("resource")
        private Communicator createCommunicator(HttpHost host, int connectionRequestTimeout, int connectTimeout, int socketTimeout) throws URISyntaxException {
            URI uri = toURI(host, null);

            Connection connection = new DefaultConnection(connectionRequestTimeout, connectTimeout, socketTimeout);
            Authenticator authenticator = (httpMethod, resourceUri, requestHeaders) -> "ignored";
            MetadataProvider metadataProvider = new DefaultMetadataProvider("OnlinePayments");
            return Factory.createCommunicator(uri, connection, authenticator, metadataProvider);
        }

        private String readResource(String resource) throws IOException {
            StringBuilder result = new StringBuilder();
            try (Reader reader = new InputStreamReader(getClass().getResourceAsStream(resource), StandardCharsets.UTF_8)) {
                char[] buffer = new char[4096];
                int len;
                while ((len = reader.read(buffer)) != -1) {
                    result.append(buffer, 0, len);
                }
            }
            return result.toString();
        }

        private String normalizeLineBreaks(String value) {
            // Normalize line breaks to always use the same, regardless of the operating system
            return value.replace("\r", "");
        }
    }

    private static final class TestLogger implements CommunicatorLogger {

        private List<TestLoggerEntry> entries = new ArrayList<>();

        @Override
        public void log(String message) {
            log(message, null);
        }

        @Override
        public void log(String message, Throwable thrown) {
            entries.add(new TestLoggerEntry(message, thrown));
        }
    }

    private static final class TestLoggerEntry {

        private final String message;
        private final Throwable thrown;

        TestLoggerEntry(String message, Throwable thrown) {
            this.message = message;
            this.thrown = thrown;
        }
    }
}
