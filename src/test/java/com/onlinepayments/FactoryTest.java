package com.onlinepayments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import org.junit.jupiter.api.Test;

import com.onlinepayments.authentication.Authenticator;
import com.onlinepayments.authentication.AuthorizationType;
import com.onlinepayments.authentication.V1HmacAuthenticator;
import com.onlinepayments.communication.Connection;
import com.onlinepayments.communication.DefaultConnection;
import com.onlinepayments.communication.DefaultMetadataProvider;
import com.onlinepayments.communication.MetadataProvider;
import com.onlinepayments.communication.RequestHeader;
import com.onlinepayments.json.DefaultMarshaller;
import com.onlinepayments.util.DefaultConnectionAssertions;
import com.onlinepayments.util.ReflectionUtil;

class FactoryTest {

    static final URI PROPERTIES_URI;
    static final String AUTH_ID     = "apiKeyId";
    static final String AUTH_SECRET = "secretApiKey";

    static {
        try {
            PROPERTIES_URI = FactoryTest.class.getResource("configuration.v1hmac.properties").toURI();
        } catch (URISyntaxException e) {
            InstantiationError error = new InstantiationError(e.getMessage());
            error.initCause(e);
            throw error;
        }
    }

    @Test
    void testCreateConfiguration() {
        CommunicatorConfiguration configuration = Factory.createConfiguration(PROPERTIES_URI, AUTH_ID, AUTH_SECRET);
        assertEquals(URI.create("https://payment.preprod.online-payments.com"), configuration.getApiEndpoint());
        assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
        assertEquals(1000, configuration.getConnectTimeout());
        assertEquals(1000, configuration.getSocketTimeout());
        assertEquals(100, configuration.getMaxConnections());
        assertEquals(AUTH_ID, configuration.getApiKeyId());
        assertEquals(AUTH_SECRET, configuration.getSecretApiKey());
        assertNull(configuration.getProxyConfiguration());
    }

    @Test
    void testCreateCommunicator() {
        @SuppressWarnings("resource")
        Communicator communicator = Factory.createCommunicator(PROPERTIES_URI, AUTH_ID, AUTH_SECRET);

        assertSame(DefaultMarshaller.INSTANCE, communicator.getMarshaller());

        @SuppressWarnings("resource")
        Connection connection = ReflectionUtil.getField(communicator, "connection", Connection.class);
        @SuppressWarnings("resource")
        DefaultConnection defaultConnection = assertInstanceOf(DefaultConnection.class, connection);
        DefaultConnectionAssertions.assertConnection(defaultConnection, 1000, 1000, 100, null);

        Authenticator authenticator = ReflectionUtil.getField(communicator, "authenticator", Authenticator.class);
        assertInstanceOf(V1HmacAuthenticator.class, authenticator);
        assertEquals(AUTH_ID, ReflectionUtil.getField(authenticator, "apiKeyId", String.class));
        assertEquals(AUTH_SECRET, ReflectionUtil.getField(authenticator, "secretApiKey", String.class));

        MetadataProvider metadataProvider = ReflectionUtil.getField(communicator, "metadataProvider", MetadataProvider.class);
        assertEquals(DefaultMetadataProvider.class, metadataProvider.getClass());
        Collection<RequestHeader> requestHeaders = metadataProvider.getServerMetadataHeaders();
        assertEquals(1, requestHeaders.size());
        RequestHeader requestHeader = requestHeaders.iterator().next();
        assertEquals("X-GCS-ServerMetaInfo", requestHeader.getName());
    }
}
