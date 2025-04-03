package com.onlinepayments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.authentication.AuthorizationType;

class CommunicatorConfigurationTest {

    @Nested
    class ConstructFromProperties {

        @Test
        void testWithoutProxy() {
            Properties properties = new Properties();
            properties.setProperty("onlinePayments.api.endpoint.host", "payment.preprod.online-payments.com");
            properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
            properties.setProperty("onlinePayments.api.connectTimeout", "20000");
            properties.setProperty("onlinePayments.api.socketTimeout", "10000");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("https://payment.preprod.online-payments.com"), configuration.getApiEndpoint());
            assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
            assertEquals(20000, configuration.getConnectTimeout());
            assertEquals(10000, configuration.getSocketTimeout());
            assertEquals(CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, configuration.getMaxConnections());
            assertTrue(configuration.isConnectionReuse());
            assertNull(configuration.getApiKeyId());
            assertNull(configuration.getSecretApiKey());
            assertNull(configuration.getProxyConfiguration());
            assertEquals(CommunicatorConfiguration.DEFAULT_HTTPS_PROTOCOLS, configuration.getHttpsProtocols());
            assertNull(configuration.getIntegrator());
            assertNull(configuration.getShoppingCartExtension());
        }

        @Test
        void testWithProxyWithoutAuthentication() {
            Properties properties = new Properties();
            properties.setProperty("onlinePayments.api.endpoint.host", "payment.preprod.online-payments.com");
            properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
            properties.setProperty("onlinePayments.api.connectTimeout", "20000");
            properties.setProperty("onlinePayments.api.socketTimeout", "10000");
            properties.setProperty("onlinePayments.api.proxy.uri", "http://proxy.example.org:3128");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("https://payment.preprod.online-payments.com"), configuration.getApiEndpoint());
            assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
            assertEquals(20000, configuration.getConnectTimeout());
            assertEquals(10000, configuration.getSocketTimeout());
            assertEquals(CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, configuration.getMaxConnections());
            assertTrue(configuration.isConnectionReuse());
            assertNull(configuration.getApiKeyId());
            assertNull(configuration.getSecretApiKey());

            assertNotNull(configuration.getProxyConfiguration());
            ProxyConfiguration proxyConfiguration = configuration.getProxyConfiguration();
            assertEquals("http", proxyConfiguration.getScheme());
            assertEquals("proxy.example.org", proxyConfiguration.getHost());
            assertEquals(3128, proxyConfiguration.getPort());
            assertNull(proxyConfiguration.getUsername());
            assertNull(proxyConfiguration.getPassword());
        }

        @Test
        void testWithProxyWithAuthentication() {
            Properties properties = new Properties();
            properties.setProperty("onlinePayments.api.endpoint.host", "payment.preprod.online-payments.com");
            properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
            properties.setProperty("onlinePayments.api.connectTimeout", "20000");
            properties.setProperty("onlinePayments.api.socketTimeout", "10000");
            properties.setProperty("onlinePayments.api.proxy.uri", "http://proxy.example.org:3128");
            properties.setProperty("onlinePayments.api.proxy.username", "proxy-username");
            properties.setProperty("onlinePayments.api.proxy.password", "proxy-password");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("https://payment.preprod.online-payments.com"), configuration.getApiEndpoint());
            assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
            assertEquals(20000, configuration.getConnectTimeout());
            assertEquals(10000, configuration.getSocketTimeout());
            assertEquals(CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, configuration.getMaxConnections());
            assertTrue(configuration.isConnectionReuse());
            assertNull(configuration.getApiKeyId());
            assertNull(configuration.getSecretApiKey());

            assertNotNull(configuration.getProxyConfiguration());
            ProxyConfiguration proxyConfiguration = configuration.getProxyConfiguration();
            assertEquals("http", proxyConfiguration.getScheme());
            assertEquals("proxy.example.org", proxyConfiguration.getHost());
            assertEquals(3128, proxyConfiguration.getPort());
            assertEquals("proxy-username", proxyConfiguration.getUsername());
            assertEquals("proxy-password", proxyConfiguration.getPassword());
        }

        @Test
        void testWithMaxConnections() {
            Properties properties = new Properties();
            properties.setProperty("onlinePayments.api.endpoint.host", "payment.preprod.online-payments.com");
            properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
            properties.setProperty("onlinePayments.api.connectTimeout", "20000");
            properties.setProperty("onlinePayments.api.socketTimeout", "10000");
            properties.setProperty("onlinePayments.api.maxConnections", "100");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("https://payment.preprod.online-payments.com"), configuration.getApiEndpoint());
            assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
            assertEquals(20000, configuration.getConnectTimeout());
            assertEquals(10000, configuration.getSocketTimeout());
            assertEquals(100, configuration.getMaxConnections());
            assertTrue(configuration.isConnectionReuse());
            assertNull(configuration.getApiKeyId());
            assertNull(configuration.getSecretApiKey());
            assertNull(configuration.getProxyConfiguration());
        }

        @Test
        void testWithConnectionReuse() {
            Properties properties = new Properties();
            properties.setProperty("onlinePayments.api.endpoint.host", "payment.preprod.online-payments.com");
            properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
            properties.setProperty("onlinePayments.api.connectTimeout", "20000");
            properties.setProperty("onlinePayments.api.socketTimeout", "10000");
            properties.setProperty("onlinePayments.api.connectionReuse", "false");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("https://payment.preprod.online-payments.com"), configuration.getApiEndpoint());
            assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
            assertEquals(20000, configuration.getConnectTimeout());
            assertEquals(10000, configuration.getSocketTimeout());
            assertEquals(CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, configuration.getMaxConnections());
            assertFalse(configuration.isConnectionReuse());
            assertNull(configuration.getApiKeyId());
            assertNull(configuration.getSecretApiKey());
            assertNull(configuration.getProxyConfiguration());
        }

        @Test
        void testWithHost() {
            Properties properties = new Properties();
            properties.setProperty("onlinePayments.api.endpoint.host", "payment.preprod.online-payments.com");
            properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
            properties.setProperty("onlinePayments.api.connectTimeout", "20000");
            properties.setProperty("onlinePayments.api.socketTimeout", "10000");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("https://payment.preprod.online-payments.com"), configuration.getApiEndpoint());
        }

        @Test
        void testWithHostAndScheme() {
            Properties properties = new Properties();
            properties.setProperty("onlinePayments.api.endpoint.host", "payment.preprod.online-payments.com");
            properties.setProperty("onlinePayments.api.endpoint.scheme", "http");
            properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
            properties.setProperty("onlinePayments.api.connectTimeout", "20000");
            properties.setProperty("onlinePayments.api.socketTimeout", "10000");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("http://payment.preprod.online-payments.com"), configuration.getApiEndpoint());
        }

        @Test
        void testWithHostAndPort() {
            Properties properties = new Properties();
            properties.setProperty("onlinePayments.api.endpoint.host", "payment.preprod.online-payments.com");
            properties.setProperty("onlinePayments.api.endpoint.port", "8443");
            properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
            properties.setProperty("onlinePayments.api.connectTimeout", "20000");
            properties.setProperty("onlinePayments.api.socketTimeout", "10000");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("https://payment.preprod.online-payments.com:8443"), configuration.getApiEndpoint());
        }

        @Test
        void testWithHostSchemeAndPort() {
            Properties properties = new Properties();
            properties.setProperty("onlinePayments.api.endpoint.host", "payment.preprod.online-payments.com");
            properties.setProperty("onlinePayments.api.endpoint.scheme", "http");
            properties.setProperty("onlinePayments.api.endpoint.port", "8080");
            properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
            properties.setProperty("onlinePayments.api.connectTimeout", "20000");
            properties.setProperty("onlinePayments.api.socketTimeout", "10000");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("http://payment.preprod.online-payments.com:8080"), configuration.getApiEndpoint());
        }

        @Test
        void testWithIPv6Host() {
            Properties properties = new Properties();
            properties.setProperty("onlinePayments.api.endpoint.host", "::1");
            properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
            properties.setProperty("onlinePayments.api.connectTimeout", "20000");
            properties.setProperty("onlinePayments.api.socketTimeout", "10000");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("https://[::1]"), configuration.getApiEndpoint());
        }

        @Test
        void testWithHttpsProtocols() {
            Properties properties = new Properties();
            properties.setProperty("onlinePayments.api.endpoint.host", "payment.preprod.online-payments.com");
            properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
            properties.setProperty("onlinePayments.api.connectTimeout", "20000");
            properties.setProperty("onlinePayments.api.socketTimeout", "10000");
            properties.setProperty("onlinePayments.api.https.protocols", "TLSv1, TLSv1.1, TLSv1.2");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("https://payment.preprod.online-payments.com"), configuration.getApiEndpoint());
            assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
            assertEquals(20000, configuration.getConnectTimeout());
            assertEquals(10000, configuration.getSocketTimeout());
            assertEquals(CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, configuration.getMaxConnections());
            assertTrue(configuration.isConnectionReuse());
            assertNull(configuration.getApiKeyId());
            assertNull(configuration.getSecretApiKey());
            assertNull(configuration.getProxyConfiguration());
            assertEquals(new HashSet<>(Arrays.asList("TLSv1", "TLSv1.1", "TLSv1.2")), configuration.getHttpsProtocols());
            assertNull(configuration.getIntegrator());
            assertNull(configuration.getShoppingCartExtension());
        }

        @Test
        void testWithMetadata() {
            Properties properties = new Properties();
            properties.setProperty("onlinePayments.api.endpoint.host", "payment.preprod.online-payments.com");
            properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
            properties.setProperty("onlinePayments.api.connectTimeout", "20000");
            properties.setProperty("onlinePayments.api.socketTimeout", "10000");
            properties.setProperty("onlinePayments.api.integrator", "OnlinePayments.Integrator");
            properties.setProperty("onlinePayments.api.shoppingCartExtension.creator", "OnlinePayments.Creator");
            properties.setProperty("onlinePayments.api.shoppingCartExtension.name", "OnlinePayments.ShoppingCarts");
            properties.setProperty("onlinePayments.api.shoppingCartExtension.version", "1.0");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("https://payment.preprod.online-payments.com"), configuration.getApiEndpoint());
            assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
            assertEquals(20000, configuration.getConnectTimeout());
            assertEquals(10000, configuration.getSocketTimeout());
            assertEquals(CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, configuration.getMaxConnections());
            assertTrue(configuration.isConnectionReuse());
            assertNull(configuration.getApiKeyId());
            assertNull(configuration.getSecretApiKey());
            assertNull(configuration.getProxyConfiguration());
            assertEquals("OnlinePayments.Integrator", configuration.getIntegrator());
            assertNotNull(configuration.getShoppingCartExtension());
            assertEquals("OnlinePayments.Creator", configuration.getShoppingCartExtension().getCreator());
            assertEquals("OnlinePayments.ShoppingCarts", configuration.getShoppingCartExtension().getName());
            assertEquals("1.0", configuration.getShoppingCartExtension().getVersion());
        }
    }
}
