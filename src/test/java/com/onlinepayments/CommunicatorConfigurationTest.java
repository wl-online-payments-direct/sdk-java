package com.onlinepayments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.authentication.AuthorizationType;
import com.onlinepayments.domain.ShoppingCartExtension;

class CommunicatorConfigurationTest {

    @Nested
    class WhenConstructedFromProperties {

        @Test
        void shouldSetExpectedConfigurationWithoutProxy() {
            Properties properties = createRequiredProperties();

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
    }

    @Nested
    class WhenConstructedWithProxyWithoutAuthentication {

        @Test
        void shouldSetExpectedProxyConfiguration() {
            Properties properties = createRequiredProperties();
            properties.setProperty("onlinePayments.api.proxy.uri", "http://proxy.example.org:3128");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertNotNull(configuration.getProxyConfiguration());
            ProxyConfiguration proxyConfiguration = configuration.getProxyConfiguration();
            assertEquals("http", proxyConfiguration.getScheme());
            assertEquals("proxy.example.org", proxyConfiguration.getHost());
            assertEquals(3128, proxyConfiguration.getPort());
            assertNull(proxyConfiguration.getUsername());
            assertNull(proxyConfiguration.getPassword());
        }
    }

    @Nested
    class WhenConstructedWithHttpsProxy {

        @Test
        void shouldSetExpectedProxyConfiguration() {
            Properties properties = createRequiredProperties();
            properties.setProperty("onlinePayments.api.proxy.uri", "https://proxy.example.org:443");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertNotNull(configuration.getProxyConfiguration());
            ProxyConfiguration proxyConfiguration = configuration.getProxyConfiguration();
            assertEquals("https", proxyConfiguration.getScheme());
            assertEquals("proxy.example.org", proxyConfiguration.getHost());
            assertEquals(443, proxyConfiguration.getPort());
            assertNull(proxyConfiguration.getUsername());
            assertNull(proxyConfiguration.getPassword());
        }
    }

    @Nested
    class WhenConstructedWithProxyWithAuthentication {

        @Test
        void shouldSetExpectedProxyConfiguration() {
            Properties properties = createRequiredProperties();
            properties.setProperty("onlinePayments.api.proxy.uri", "http://proxy.example.org:3128");
            properties.setProperty("onlinePayments.api.proxy.username", "proxy-username");
            properties.setProperty("onlinePayments.api.proxy.password", "proxy-password");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertNotNull(configuration.getProxyConfiguration());
            ProxyConfiguration proxyConfiguration = configuration.getProxyConfiguration();
            assertEquals("http", proxyConfiguration.getScheme());
            assertEquals("proxy.example.org", proxyConfiguration.getHost());
            assertEquals(3128, proxyConfiguration.getPort());
            assertEquals("proxy-username", proxyConfiguration.getUsername());
            assertEquals("proxy-password", proxyConfiguration.getPassword());
        }
    }

    @Nested
    class WhenConstructedWithMaxConnections {

        @Test
        void shouldSetConfiguredMaxConnections() {
            Properties properties = createRequiredProperties();
            properties.setProperty("onlinePayments.api.maxConnections", "100");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(100, configuration.getMaxConnections());
        }
    }

    @Nested
    class WhenConstructedWithConnectionReuseDisabled {

        @Test
        void shouldSetConnectionReuseToFalse() {
            Properties properties = createRequiredProperties();
            properties.setProperty("onlinePayments.api.connectionReuse", "false");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertFalse(configuration.isConnectionReuse());
        }
    }

    @Nested
    class WhenConstructedWithHostOnly {

        @Test
        void shouldSetHttpsEndpoint() {
            Properties properties = createRequiredProperties();

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("https://payment.preprod.online-payments.com"), configuration.getApiEndpoint());
        }
    }

    @Nested
    class WhenConstructedWithHostAndScheme {

        @Test
        void shouldSetEndpointWithConfiguredScheme() {
            Properties properties = createRequiredProperties();
            properties.setProperty("onlinePayments.api.endpoint.scheme", "http");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("http://payment.preprod.online-payments.com"), configuration.getApiEndpoint());
        }
    }

    @Nested
    class WhenConstructedWithHostAndPort {

        @Test
        void shouldSetEndpointWithConfiguredPort() {
            Properties properties = createRequiredProperties();
            properties.setProperty("onlinePayments.api.endpoint.port", "8443");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("https://payment.preprod.online-payments.com:8443"), configuration.getApiEndpoint());
        }
    }

    @Nested
    class WhenConstructedWithHostSchemeAndPort {

        @Test
        void shouldSetEndpointWithConfiguredSchemeAndPort() {
            Properties properties = createRequiredProperties();
            properties.setProperty("onlinePayments.api.endpoint.scheme", "http");
            properties.setProperty("onlinePayments.api.endpoint.port", "8080");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("http://payment.preprod.online-payments.com:8080"), configuration.getApiEndpoint());
        }
    }

    @Nested
    class WhenConstructedWithIpv6Host {

        @Test
        void shouldSetBracketedHttpsEndpoint() {
            Properties properties = createRequiredProperties();
            properties.setProperty("onlinePayments.api.endpoint.host", "::1");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(URI.create("https://[::1]"), configuration.getApiEndpoint());
        }
    }

    @Nested
    class WhenConstructedWithHttpsProtocols {

        @Test
        void shouldSetConfiguredProtocols() {
            Properties properties = createRequiredProperties();
            properties.setProperty("onlinePayments.api.https.protocols", "TLSv1, TLSv1.1, TLSv1.2");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals(new HashSet<>(Arrays.asList("TLSv1", "TLSv1.1", "TLSv1.2")), configuration.getHttpsProtocols());
        }
    }

    @Nested
    class WhenConstructedWithMetadata {

        @Test
        void shouldSetIntegratorAndShoppingCartExtension() {
            Properties properties = createRequiredProperties();
            properties.setProperty("onlinePayments.api.integrator", "OnlinePayments.Integrator");
            properties.setProperty("onlinePayments.api.shoppingCartExtension.creator", "OnlinePayments.Creator");
            properties.setProperty("onlinePayments.api.shoppingCartExtension.name", "OnlinePayments.ShoppingCarts");
            properties.setProperty("onlinePayments.api.shoppingCartExtension.version", "1.0");

            CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

            assertEquals("OnlinePayments.Integrator", configuration.getIntegrator());
            assertNotNull(configuration.getShoppingCartExtension());
            assertEquals("OnlinePayments.Creator", configuration.getShoppingCartExtension().getCreator());
            assertEquals("OnlinePayments.ShoppingCarts", configuration.getShoppingCartExtension().getName());
            assertEquals("1.0", configuration.getShoppingCartExtension().getVersion());
        }
    }

    @Nested
    class WhenSettingInvalidApiEndpoint {

        @Test
        void shouldThrowIllegalArgumentExceptionWhenApiEndpointContainsPath() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> configuration.setApiEndpoint(URI.create("https://payment.preprod.online-payments.com/v2"))
            );
        }

        @Test
        void shouldThrowIllegalArgumentExceptionWhenApiEndpointContainsQuery() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> configuration.setApiEndpoint(URI.create("https://payment.preprod.online-payments.com?param=value"))
            );
        }

        @Test
        void shouldThrowIllegalArgumentExceptionWhenApiEndpointContainsUserInfo() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> configuration.setApiEndpoint(URI.create("https://user:pass@payment.preprod.online-payments.com"))
            );
        }

        @Test
        void shouldThrowIllegalArgumentExceptionWhenApiEndpointContainsFragment() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> configuration.setApiEndpoint(URI.create("https://payment.preprod.online-payments.com#section"))
            );
        }
    }

    @Nested
    class WhenConstructingDefaultConfiguration {

        @Test
        void shouldCreateValidInstance() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            assertNotNull(configuration);
        }

        @Test
        void shouldHaveDefaultValues() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            assertNull(configuration.getApiEndpoint());
            assertNull(configuration.getApiKeyId());
            assertNull(configuration.getSecretApiKey());
            assertNull(configuration.getAuthorizationType());
            assertEquals(0, configuration.getConnectionRequestTimeout());
            assertEquals(0, configuration.getConnectTimeout());
            assertEquals(0, configuration.getSocketTimeout());
            assertEquals(CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, configuration.getMaxConnections());
            assertTrue(configuration.isConnectionReuse());
            assertNull(configuration.getProxyConfiguration());
            assertNull(configuration.getIntegrator());
            assertNull(configuration.getShoppingCartExtension());
        }
    }

    @Nested
    class WhenSettingAndGettingApiKeyId {

        @Test
        void shouldSetAndGetApiKeyId() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            String apiKeyId = "test-api-key-id";

            configuration.setApiKeyId(apiKeyId);

            assertEquals(apiKeyId, configuration.getApiKeyId());
        }

        @Test
        void shouldSetNullApiKeyId() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            configuration.setApiKeyId(null);

            assertNull(configuration.getApiKeyId());
        }

        @Test
        void shouldReturnSelfFromFluentBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            CommunicatorConfiguration result = configuration.withApiKeyId("api-key");

            assertSame(configuration, result);
        }

        @Test
        void shouldChainFluentApiKeyIdBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration()
                    .withApiKeyId("api-key-id")
                    .withSecretApiKey("secret-key");

            assertEquals("api-key-id", configuration.getApiKeyId());
            assertEquals("secret-key", configuration.getSecretApiKey());
        }
    }

    @Nested
    class WhenSettingAndGettingSecretApiKey {

        @Test
        void shouldSetAndGetSecretApiKey() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            String secretKey = "test-secret-key";

            configuration.setSecretApiKey(secretKey);

            assertEquals(secretKey, configuration.getSecretApiKey());
        }

        @Test
        void shouldSetNullSecretApiKey() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            configuration.setSecretApiKey(null);

            assertNull(configuration.getSecretApiKey());
        }

        @Test
        void shouldReturnSelfFromFluentBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            CommunicatorConfiguration result = configuration.withSecretApiKey("secret-key");

            assertSame(configuration, result);
        }
    }

    @Nested
    class WhenSettingAndGettingAuthorizationType {

        @Test
        void shouldSetAndGetAuthorizationType() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            AuthorizationType authType = AuthorizationType.V1HMAC;

            configuration.setAuthorizationType(authType);

            assertEquals(authType, configuration.getAuthorizationType());
        }

        @Test
        void shouldSetNullAuthorizationType() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            configuration.setAuthorizationType(null);

            assertNull(configuration.getAuthorizationType());
        }

        @Test
        void shouldReturnSelfFromFluentBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            CommunicatorConfiguration result = configuration.withAuthorizationType(AuthorizationType.V1HMAC);

            assertSame(configuration, result);
        }
    }

    @Nested
    class WhenSettingAndGettingConnectionRequestTimeout {

        @Test
        void shouldSetAndGetConnectionRequestTimeout() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            int timeout = 5000;

            configuration.setConnectionRequestTimeout(timeout);

            assertEquals(timeout, configuration.getConnectionRequestTimeout());
        }

        @Test
        void shouldSetZeroConnectionRequestTimeout() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            configuration.setConnectionRequestTimeout(0);

            assertEquals(0, configuration.getConnectionRequestTimeout());
        }

        @Test
        void shouldReturnSelfFromFluentBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            CommunicatorConfiguration result = configuration.withConnectionRequestTimeout(5000);

            assertSame(configuration, result);
        }
    }

    @Nested
    class WhenSettingAndGettingConnectTimeout {

        @Test
        void shouldSetAndGetConnectTimeout() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            int timeout = 20000;

            configuration.setConnectTimeout(timeout);

            assertEquals(timeout, configuration.getConnectTimeout());
        }

        @Test
        void shouldSetZeroConnectTimeout() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            configuration.setConnectTimeout(0);

            assertEquals(0, configuration.getConnectTimeout());
        }

        @Test
        void shouldReturnSelfFromFluentBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            CommunicatorConfiguration result = configuration.withConnectTimeout(20000);

            assertSame(configuration, result);
        }
    }

    @Nested
    class WhenSettingAndGettingSocketTimeout {

        @Test
        void shouldSetAndGetSocketTimeout() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            int timeout = 10000;

            configuration.setSocketTimeout(timeout);

            assertEquals(timeout, configuration.getSocketTimeout());
        }

        @Test
        void shouldSetZeroSocketTimeout() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            configuration.setSocketTimeout(0);

            assertEquals(0, configuration.getSocketTimeout());
        }

        @Test
        void shouldReturnSelfFromFluentBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            CommunicatorConfiguration result = configuration.withSocketTimeout(10000);

            assertSame(configuration, result);
        }
    }

    @Nested
    class WhenSettingAndGettingMaxConnections {

        @Test
        void shouldSetAndGetMaxConnections() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            int maxConnections = 50;

            configuration.setMaxConnections(maxConnections);

            assertEquals(maxConnections, configuration.getMaxConnections());
        }

        @Test
        void shouldSetCustomMaxConnections() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            configuration.setMaxConnections(100);

            assertEquals(100, configuration.getMaxConnections());
        }

        @Test
        void shouldReturnSelfFromFluentBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            CommunicatorConfiguration result = configuration.withMaxConnections(50);

            assertSame(configuration, result);
        }
    }

    @Nested
    class WhenSettingAndGettingConnectionReuse {

        @Test
        void shouldSetAndGetConnectionReuseTrue() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            configuration.setConnectionReuse(true);

            assertTrue(configuration.isConnectionReuse());
        }

        @Test
        void shouldSetAndGetConnectionReuseFalse() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            configuration.setConnectionReuse(false);

            assertFalse(configuration.isConnectionReuse());
        }

        @Test
        void shouldReturnSelfFromFluentBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            CommunicatorConfiguration result = configuration.withConnectionReuse(false);

            assertSame(configuration, result);
        }
    }

    @Nested
    class WhenSettingAndGettingProxyConfiguration {

        @Test
        void shouldSetAndGetProxyConfiguration() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            ProxyConfiguration proxyConfig = new ProxyConfiguration(
                    URI.create("http://proxy.example.com:3128"),
                    "user",
                    "pass"
            );

            configuration.setProxyConfiguration(proxyConfig);

            assertEquals(proxyConfig, configuration.getProxyConfiguration());
        }

        @Test
        void shouldSetNullProxyConfiguration() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            configuration.setProxyConfiguration(null);

            assertNull(configuration.getProxyConfiguration());
        }

        @Test
        void shouldReturnSelfFromFluentBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            ProxyConfiguration proxyConfig = new ProxyConfiguration(
                    URI.create("http://proxy.example.com:3128"),
                    null,
                    null
            );

            CommunicatorConfiguration result = configuration.withProxyConfiguration(proxyConfig);

            assertSame(configuration, result);
        }
    }

    @Nested
    class WhenSettingAndGettingHttpsProtocols {

        @Test
        void shouldSetAndGetHttpsProtocolsSet() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            Set<String> protocols = new HashSet<>(Arrays.asList("TLSv1.2", "TLSv1.3"));

            configuration.setHttpsProtocols(protocols);

            assertEquals(protocols, configuration.getHttpsProtocols());
        }

        @Test
        void shouldAddProtocolsViaFluentCollectionBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            CommunicatorConfiguration result = configuration.withHttpsProtocols(Arrays.asList("TLSv1.2", "TLSv1.3"));

            assertSame(configuration, result);
            assertTrue(configuration.getHttpsProtocols().contains("TLSv1.2"));
            assertTrue(configuration.getHttpsProtocols().contains("TLSv1.3"));
        }

        @Test
        void shouldAddProtocolsViaFluentVarargsBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            CommunicatorConfiguration result = configuration.withHttpsProtocols("TLSv1.2", "TLSv1.3");

            assertSame(configuration, result);
            assertTrue(configuration.getHttpsProtocols().contains("TLSv1.2"));
            assertTrue(configuration.getHttpsProtocols().contains("TLSv1.3"));
        }

        @Test
        void shouldInitializeEmptyHttpsProtocolsSet() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            configuration.setHttpsProtocols(null);

            Set<String> protocols = configuration.getHttpsProtocols();

            assertNotNull(protocols);
            assertTrue(protocols.isEmpty());
        }
    }

    @Nested
    class WhenSettingAndGettingIntegrator {

        @Test
        void shouldSetAndGetIntegrator() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            String integrator = "TestIntegrator";

            configuration.setIntegrator(integrator);

            assertEquals(integrator, configuration.getIntegrator());
        }

        @Test
        void shouldSetNullIntegrator() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            configuration.setIntegrator(null);

            assertNull(configuration.getIntegrator());
        }

        @Test
        void shouldReturnSelfFromFluentBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            CommunicatorConfiguration result = configuration.withIntegrator("TestIntegrator");

            assertSame(configuration, result);
        }
    }

    @Nested
    class WhenSettingAndGettingShoppingCartExtension {

        @Test
        void shouldSetAndGetShoppingCartExtension() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            ShoppingCartExtension extension = new ShoppingCartExtension("Creator", "Name", "1.0");

            configuration.setShoppingCartExtension(extension);

            assertEquals(extension, configuration.getShoppingCartExtension());
        }

        @Test
        void shouldSetNullShoppingCartExtension() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            configuration.setShoppingCartExtension(null);

            assertNull(configuration.getShoppingCartExtension());
        }

        @Test
        void shouldReturnSelfFromFluentBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            ShoppingCartExtension extension = new ShoppingCartExtension("Creator", "Name", "1.0");

            CommunicatorConfiguration result = configuration.withShoppingCartExtension(extension);

            assertSame(configuration, result);
        }
    }

    @Nested
    class WhenSettingApiEndpointFluent {

        @Test
        void shouldReturnSelfFromFluentBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();
            URI endpoint = URI.create("https://payment.example.com");

            CommunicatorConfiguration result = configuration.withApiEndpoint(endpoint);

            assertSame(configuration, result);
        }

        @Test
        void shouldValidateEndpointInFluentBuilder() {
            CommunicatorConfiguration configuration = new CommunicatorConfiguration();

            assertThrows(
                    IllegalArgumentException.class,
                    () -> configuration.withApiEndpoint(URI.create("https://payment.example.com/path"))
            );
        }
    }

    private Properties createRequiredProperties() {
        Properties properties = new Properties();

        properties.setProperty("onlinePayments.api.endpoint.host", "payment.preprod.online-payments.com");
        properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
        properties.setProperty("onlinePayments.api.connectTimeout", "20000");
        properties.setProperty("onlinePayments.api.socketTimeout", "10000");

        return properties;
    }
}
