package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.junit.jupiter.api.Test;

import com.onlinepayments.ApiResource;
import com.onlinepayments.ClientInterface;
import com.onlinepayments.Communicator;
import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.ProxyConfiguration;
import com.onlinepayments.communication.DefaultConnection;
import com.onlinepayments.domain.TestConnection;
import com.onlinepayments.merchant.services.ServicesClientInterface;

class SDKProxyTest extends ItTest {
    /**
     * Smoke test for using a proxy configured through SDK properties.
     */
    @Test
    void test() throws URISyntaxException, IOException {
        try (ClientInterface client = getClientWithProxy()) {
            ServicesClientInterface services = client.merchant(getMerchantId()).services();

            CommunicatorConfiguration configuration = getCommunicatorConfigurationWithProxy();
            assertNotNull(configuration.getProxyConfiguration());
            assertProxySet((ApiResource) services, configuration.getProxyConfiguration());

            TestConnection response = services.testConnection();

            assertNotNull(response.getResult());
        }
    }

    private void assertProxySet(ApiResource resource, ProxyConfiguration proxyConfiguration) {
        Communicator communicator = getField(resource, "communicator", Communicator.class);
        assert communicator != null;
        DefaultConnection connection = getField(communicator, "connection", DefaultConnection.class);
        assert connection != null;
        CloseableHttpClient httpClient = getField(connection, "httpClient", CloseableHttpClient.class);
        assert httpClient != null;
        DefaultProxyRoutePlanner routePlanner = getField(httpClient, "routePlanner", DefaultProxyRoutePlanner.class);
        assert routePlanner != null;
        HttpHost proxy = getField(routePlanner, "proxy", HttpHost.class);
        assert proxy != null;
        assertEquals(proxyConfiguration.getScheme(), proxy.getSchemeName());
        assertEquals(proxyConfiguration.getPort(), proxy.getPort());

        BasicCredentialsProvider credentialsProvider = getField(httpClient, "credentialsProvider", BasicCredentialsProvider.class);
        AuthScope authScope = new AuthScope(proxy);
        assert credentialsProvider != null;
        Credentials credentials = credentialsProvider.getCredentials(authScope);
        assertInstanceOf(UsernamePasswordCredentials.class, credentials);
        UsernamePasswordCredentials usernamePasswordCredentials = (UsernamePasswordCredentials) credentials;
        assertEquals(proxyConfiguration.getUsername(), usernamePasswordCredentials.getUserName());
        assertEquals(proxyConfiguration.getPassword(), usernamePasswordCredentials.getPassword());
    }

    private <T> T getField(Object object, String fieldName, Class<T> fieldType) {
        Class<?> clazz = object.getClass();
        while (clazz != Object.class) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                Object fieldValue = field.get(object);
                assertTrue(fieldType.isInstance(fieldValue));
                return fieldType.cast(fieldValue);
            } catch (@SuppressWarnings("unused") NoSuchFieldException e) {
                // try next class
            } catch (IllegalAccessException e) {
                // should no longer occur
                throw new RuntimeException(e);
            }

            clazz = clazz.getSuperclass();
        }

        return null;
    }
}
