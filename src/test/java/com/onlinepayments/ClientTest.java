package com.onlinepayments;

import static com.onlinepayments.TestConstants.AUTH_ID;
import static com.onlinepayments.TestConstants.AUTH_SECRET;
import static com.onlinepayments.TestConstants.PROPERTIES_URI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.communication.Connection;
import com.onlinepayments.communication.PooledConnection;
import com.onlinepayments.communication.RequestHeader;
import com.onlinepayments.json.DefaultMarshaller;
import com.onlinepayments.logging.CommunicatorLogger;
import com.onlinepayments.merchant.MerchantClientInterface;
import com.onlinepayments.util.RequestHeaderMatcher;

class ClientTest {

    private PooledConnection pooledConnection;
    private Connection connection;

    @BeforeEach
    void setUp() {
        pooledConnection = mock(PooledConnection.class);
        connection = mock(Connection.class);
    }

    @Nested
    class WhenClientMetaInfoIsAddedUpdatedAndRemoved {

        @Test
        @SuppressWarnings("resource")
        void shouldReturnExpectedClientInstances() {
            ClientInterface firstClient = Factory.createClient(PROPERTIES_URI, AUTH_ID, AUTH_SECRET);
            assertNoClientHeaders(firstClient);

            ClientInterface secondClient = firstClient.withClientMetaInfo(null);
            assertSame(firstClient, secondClient);

            ClientInterface thirdClient = firstClient.withClientMetaInfo("");
            assertNotSame(firstClient, thirdClient);
            assertClientHeaders(thirdClient, "");

            String clientMetaInfo = DefaultMarshaller.INSTANCE.marshal(Collections.singletonMap("test", "test"));
            ClientInterface fourthClient = firstClient.withClientMetaInfo(clientMetaInfo);
            assertNotSame(firstClient, fourthClient);
            assertClientHeaders(fourthClient, clientMetaInfo);

            ClientInterface fifthClient = fourthClient.withClientMetaInfo(clientMetaInfo);
            assertSame(fourthClient, fifthClient);

            ClientInterface sixthClient = fourthClient.withClientMetaInfo(null);
            assertNotSame(fourthClient, sixthClient);
            assertNoClientHeaders(sixthClient);
        }
    }

    @Nested
    class WhenClosingIdleConnections {

        @Nested
        class WithNonPooledConnection {

            @Test
            @SuppressWarnings("resource")
            void shouldNotThrow() {
                CommunicatorBuilder builder = Factory.createCommunicatorBuilder(PROPERTIES_URI, AUTH_ID, AUTH_SECRET);
                Communicator communicator = builder.withConnection(connection).build();
                ClientInterface client = Factory.createClient(communicator);

                assertDoesNotThrow(() -> client.closeIdleConnections(5, TimeUnit.SECONDS));
            }
        }

        @Nested
        class WithPooledConnection {

            @Test
            @SuppressWarnings("resource")
            void shouldDelegateToPooledConnection() {
                CommunicatorBuilder builder = Factory.createCommunicatorBuilder(PROPERTIES_URI, AUTH_ID, AUTH_SECRET);
                Communicator communicator = builder.withConnection(pooledConnection).build();
                ClientInterface client = Factory.createClient(communicator);

                client.closeIdleConnections(5, TimeUnit.SECONDS);

                verify(pooledConnection).closeIdleConnections(5, TimeUnit.SECONDS);
            }
        }
    }

    @Nested
    class WhenClosingExpiredConnections {

        @Nested
        class WithNonPooledConnection {

            @Test
            @SuppressWarnings("resource")
            void shouldNotThrow() {
                CommunicatorBuilder builder = Factory.createCommunicatorBuilder(PROPERTIES_URI, AUTH_ID, AUTH_SECRET);
                Communicator communicator = builder.withConnection(connection).build();
                ClientInterface client = Factory.createClient(communicator);

                assertDoesNotThrow(client::closeExpiredConnections);
            }
        }

        @Nested
        class WithPooledConnection {

            @Test
            @SuppressWarnings("resource")
            void shouldDelegateToPooledConnection() {
                CommunicatorBuilder builder = Factory.createCommunicatorBuilder(PROPERTIES_URI, AUTH_ID, AUTH_SECRET);
                Communicator communicator = builder.withConnection(pooledConnection).build();
                ClientInterface client = Factory.createClient(communicator);

                client.closeExpiredConnections();

                verify(pooledConnection).closeExpiredConnections();
            }
        }
    }

    @Nested
    class WhenEnablingLogging {

        @Test
        @SuppressWarnings("resource")
        void shouldDelegateToCommunicatorWithValidLogger() {
            Communicator communicator = mock(Communicator.class);
            ClientInterface client = Factory.createClient(communicator);
            CommunicatorLogger communicatorLogger = mock(CommunicatorLogger.class);

            client.enableLogging(communicatorLogger);

            verify(communicator).enableLogging(communicatorLogger);
        }
    }

    @Nested
    class WhenDisablingLogging {

        @Test
        @SuppressWarnings("resource")
        void shouldDelegateToCommunicator() {
            Communicator communicator = mock(Communicator.class);
            ClientInterface client = Factory.createClient(communicator);

            client.disableLogging();

            verify(communicator).disableLogging();
        }
    }

    @Nested
    class WhenEnablingAndDisablingLoggingMultipleTimes {

        @Test
        @SuppressWarnings("resource")
        void shouldDelegateEachCallToCommunicator() {
            Communicator communicator = mock(Communicator.class);
            ClientInterface client = Factory.createClient(communicator);
            CommunicatorLogger firstCommunicatorLogger = mock(CommunicatorLogger.class);
            CommunicatorLogger secondCommunicatorLoger = mock(CommunicatorLogger.class);

            client.enableLogging(firstCommunicatorLogger);
            client.disableLogging();
            client.enableLogging(secondCommunicatorLoger);
            client.disableLogging();

            verify(communicator).enableLogging(firstCommunicatorLogger);
            verify(communicator).enableLogging(secondCommunicatorLoger);
            verify(communicator, times(2)).disableLogging();
        }
    }

    @Nested
    class WhenConstructingClient {

        @Test
        @SuppressWarnings("resource")
        void shouldCreateValidInstanceWithCommunicator() {
            Communicator mockCommunicator = mock(Communicator.class);

            ClientInterface client = Factory.createClient(mockCommunicator);

            assertNotNull(client);
        }

        @Test
        @SuppressWarnings("resource")
        void shouldInheritCommunicatorFromConstructor() {
            Communicator mockCommunicator = mock(Communicator.class);

            ClientInterface client = Factory.createClient(mockCommunicator);

            assertNotNull(client);
        }

    }

    @Nested
    class WhenSettingBodyObfuscator {

        @Test
        @SuppressWarnings("resource")
        void shouldDelegateToCommunicator() {
            Communicator mockCommunicator = mock(Communicator.class);
            ClientInterface client = Factory.createClient(mockCommunicator);

            client.setBodyObfuscator(null);

            verify(mockCommunicator).setBodyObfuscator(null);
        }

        @Test
        @SuppressWarnings("resource")
        void shouldDelegateNullBodyObfuscator() {
            Communicator mockCommunicator = mock(Communicator.class);
            ClientInterface client = Factory.createClient(mockCommunicator);

            client.setBodyObfuscator(null);

            verify(mockCommunicator).setBodyObfuscator(null);
        }

    }

    @Nested
    class WhenSettingHeaderObfuscator {

        @Test
        @SuppressWarnings("resource")
        void shouldDelegateToCommunicator() {
            Communicator mockCommunicator = mock(Communicator.class);
            ClientInterface client = Factory.createClient(mockCommunicator);

            client.setHeaderObfuscator(null);

            verify(mockCommunicator).setHeaderObfuscator(null);
        }

        @Test
        @SuppressWarnings("resource")
        void shouldDelegateNullHeaderObfuscator() {
            Communicator mockCommunicator = mock(Communicator.class);
            ClientInterface client = Factory.createClient(mockCommunicator);

            client.setHeaderObfuscator(null);

            verify(mockCommunicator).setHeaderObfuscator(null);
        }

    }

    @Nested
    class WhenClosingClient {

        @Test
        @SuppressWarnings("resource")
        void shouldDelegateToCommunicator() throws IOException {
            Communicator mockCommunicator = mock(Communicator.class);
            ClientInterface client = Factory.createClient(mockCommunicator);

            client.close();

            verify(mockCommunicator).close();
        }

        @Test
        @SuppressWarnings("resource")
        void shouldHandleIOException() throws IOException {
            IOException ioException = new IOException("Connection error");
            Exception cause = assertThrows(IOException.class, () -> {
                throw ioException;
            });
            assertEquals("Connection error", cause.getMessage());
        }

        @Test
        @SuppressWarnings("resource")
        void shouldBeCloseable() {
            Communicator mockCommunicator = mock(Communicator.class);
            ClientInterface client = Factory.createClient(mockCommunicator);

            assertDoesNotThrow(client::close);
        }

    }

    @Nested
    class WhenCreatingMerchantClient {

        @Test
        @SuppressWarnings("resource")
        void shouldReturnMerchantClientInstance() {
            Communicator mockCommunicator = mock(Communicator.class);
            ClientInterface client = Factory.createClient(mockCommunicator);
            String merchantId = "merchant-001";

            MerchantClientInterface merchantClient = client.merchant(merchantId);

            assertNotNull(merchantClient);
        }

        @Test
        @SuppressWarnings("resource")
        void shouldCreateMerchantClientWithValidMerchantId() {
            Communicator mockCommunicator = mock(Communicator.class);
            ClientInterface client = Factory.createClient(mockCommunicator);
            String merchantId = "test-merchant-123";

            MerchantClientInterface merchantClient = client.merchant(merchantId);

            assertNotNull(merchantClient);
        }

        @Test
        @SuppressWarnings("resource")
        void shouldCreateDifferentInstancesForDifferentMerchantIds() {
            Communicator mockCommunicator = mock(Communicator.class);
            ClientInterface client = Factory.createClient(mockCommunicator);

            MerchantClientInterface merchantClient1 = client.merchant("merchant-1");
            MerchantClientInterface merchantClient2 = client.merchant("merchant-2");

            assertNotSame(merchantClient1, merchantClient2);
        }

        @Test
        @SuppressWarnings("resource")
        void shouldHandleEmptyMerchantId() {
            Communicator mockCommunicator = mock(Communicator.class);
            ClientInterface client = Factory.createClient(mockCommunicator);

            MerchantClientInterface merchantClient = client.merchant("");

            assertNotNull(merchantClient);
        }

    }

    private void assertNoClientHeaders(ClientInterface client) {
        List<RequestHeader> headers = getClientHeaders(client);
        assertEquals(Collections.emptyList(), headers);
    }

    private void assertClientHeaders(ClientInterface client, String clientMetaInfo) {
        List<RequestHeader> headers = getClientHeaders(client);

        String headerValue = Base64.getEncoder().encodeToString(clientMetaInfo.getBytes(StandardCharsets.UTF_8));

        List<Matcher<? super RequestHeader>> matchers = new ArrayList<>();
        matchers.add(new RequestHeaderMatcher("X-GCS-ClientMetaInfo", headerValue));

        assertThat(headers, containsInAnyOrder(matchers));
    }

    @SuppressWarnings("unchecked")
    private List<RequestHeader> getClientHeaders(ClientInterface client) {
        return assertDoesNotThrow(() -> {
            Method method = ApiResource.class.getDeclaredMethod("getClientHeaders");
            method.setAccessible(true);
            return (List<RequestHeader>) method.invoke(client);
        });
    }
}
