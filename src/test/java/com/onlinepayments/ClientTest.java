package com.onlinepayments;

import static com.onlinepayments.FactoryTest.AUTH_ID;
import static com.onlinepayments.FactoryTest.AUTH_SECRET;
import static com.onlinepayments.FactoryTest.PROPERTIES_URI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
import com.onlinepayments.util.RequestHeaderMatcher;

class ClientTest {

    private PooledConnection pooledConnection;
    private Connection connection;

    @BeforeEach
    void initMocks() {
        pooledConnection = mock(PooledConnection.class);
        connection = mock(Connection.class);
    }

    @Test
    @SuppressWarnings("resource")
    void testWithClientMetaInfo() {
        ClientInterface client1 = Factory.createClient(PROPERTIES_URI, AUTH_ID, AUTH_SECRET);
        assertNoClientHeaders(client1);

        ClientInterface client2 = client1.withClientMetaInfo(null);
        assertSame(client1, client2);

        String clientMetaInfo = DefaultMarshaller.INSTANCE.marshal(Collections.singletonMap("test", "test"));
        ClientInterface client3 = client1.withClientMetaInfo(clientMetaInfo);
        assertNotSame(client1, client3);
        assertClientHeaders(client3, clientMetaInfo);

        ClientInterface client4 = client3.withClientMetaInfo(clientMetaInfo);
        assertSame(client3, client4);

        ClientInterface client5 = client3.withClientMetaInfo(null);
        assertNotSame(client3, client5);
        assertNoClientHeaders(client5);

        // nothing can be said about client1 and client5 being the same or not
    }

    private void assertNoClientHeaders(ClientInterface client) {
        List<RequestHeader> headers = getHeaders(client);
        assertEquals(Collections.emptyList(), headers);
    }

    private void assertClientHeaders(ClientInterface client, String clientMetaInfo) {
        List<RequestHeader> headers = getHeaders(client);

        String headerValue = Base64.getEncoder().encodeToString(clientMetaInfo.getBytes(StandardCharsets.UTF_8));

        List<Matcher<? super RequestHeader>> matchers = new ArrayList<>();
        matchers.add(new RequestHeaderMatcher("X-GCS-ClientMetaInfo", headerValue));

        assertThat(headers, containsInAnyOrder(matchers));
    }

    @SuppressWarnings("unchecked")
    private List<RequestHeader> getHeaders(ClientInterface client) {
        // ApiResource.getClientHeaders() is protected, so this test class has no access to it; use reflection to get it
        return assertDoesNotThrow(() -> {
            Method method = ApiResource.class.getDeclaredMethod("getClientHeaders");
            method.setAccessible(true);
            return (List<RequestHeader>) method.invoke(client);
        });
    }

    @Nested
    class CloseIdleConnections {

        @Test
        @SuppressWarnings("resource")
        void testNotPooled() {
            CommunicatorBuilder builder = Factory.createCommunicatorBuilder(PROPERTIES_URI, AUTH_ID, AUTH_SECRET);
            Communicator communicator = builder.withConnection(connection).build();
            ClientInterface client = Factory.createClient(communicator);
            // with a connection that isn't a PooledConnection, this doesn't throw any exceptions
            assertDoesNotThrow(() -> client.closeIdleConnections(5, TimeUnit.SECONDS));
        }

        @Test
        @SuppressWarnings("resource")
        void testPooled() {
            CommunicatorBuilder builder = Factory.createCommunicatorBuilder(PROPERTIES_URI, AUTH_ID, AUTH_SECRET);
            Communicator communicator = builder.withConnection(pooledConnection).build();
            ClientInterface client = Factory.createClient(communicator);
            // with a connection that is a PooledConnection, this gets delegated to pooledConnection
            client.closeIdleConnections(5, TimeUnit.SECONDS);

            verify(pooledConnection).closeIdleConnections(5, TimeUnit.SECONDS);
        }
    }

    @Nested
    class CloseExpiredConnections {

        @Test
        @SuppressWarnings("resource")
        void testNotPooled() {
            CommunicatorBuilder builder = Factory.createCommunicatorBuilder(PROPERTIES_URI, AUTH_ID, AUTH_SECRET);
            Communicator communicator = builder.withConnection(connection).build();
            ClientInterface client = Factory.createClient(communicator);
            // with a connection that isn't a PooledConnection, this doesn't throw any exceptions
            assertDoesNotThrow(client::closeExpiredConnections);
        }

        @Test
        @SuppressWarnings("resource")
        void testPooled() {
            CommunicatorBuilder builder = Factory.createCommunicatorBuilder(PROPERTIES_URI, AUTH_ID, AUTH_SECRET);
            Communicator communicator = builder.withConnection(pooledConnection).build();
            ClientInterface client = Factory.createClient(communicator);
            // with a connection that is a PooledConnection, this gets delegated to pooledConnection
            client.closeExpiredConnections();

            verify(pooledConnection).closeExpiredConnections();
        }
    }
}
