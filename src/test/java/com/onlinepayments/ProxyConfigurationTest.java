package com.onlinepayments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ProxyConfigurationTest {

    @Nested
    class WhenConstructingWith2Parameters {

        @Test
        void shouldCreateInstanceWithHostAndPort() {
            ProxyConfiguration config = new ProxyConfiguration("proxy.example.com", 3128);

            assertEquals("http", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(3128, config.getPort());
            assertNull(config.getUsername());
            assertNull(config.getPassword());
        }

        @Test
        void shouldDefaultToHttpScheme() {
            ProxyConfiguration config = new ProxyConfiguration("localhost", 8080);

            assertEquals("http", config.getScheme());
        }

        @Test
        void shouldDelegateToFullConstructor() {
            ProxyConfiguration config = new ProxyConfiguration("proxy.example.com", 3128);

            assertEquals("http", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(3128, config.getPort());
        }

    }

    @Nested
    class WhenConstructingWith4Parameters {

        @Test
        void shouldCreateInstanceWithCredentials() {
            ProxyConfiguration config = new ProxyConfiguration("proxy.example.com", 3128, "user", "pass");

            assertEquals("http", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(3128, config.getPort());
            assertEquals("user", config.getUsername());
            assertEquals("pass", config.getPassword());
        }

        @Test
        void shouldHandleNullCredentials() {
            ProxyConfiguration config = new ProxyConfiguration("proxy.example.com", 3128, null, null);

            assertNull(config.getUsername());
            assertNull(config.getPassword());
        }

        @Test
        void shouldDelegateToFullConstructor() {
            ProxyConfiguration config = new ProxyConfiguration("proxy.example.com", 3128, "user", "pass");

            assertEquals("http", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(3128, config.getPort());
            assertEquals("user", config.getUsername());
            assertEquals("pass", config.getPassword());
        }

    }

    @Nested
    class WhenConstructingWith3Parameters {

        @Test
        void shouldCreateInstanceWithCustomScheme() {
            ProxyConfiguration config = new ProxyConfiguration("socks5", "proxy.example.com", 1080);

            assertEquals("socks5", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(1080, config.getPort());
            assertNull(config.getUsername());
            assertNull(config.getPassword());
        }

        @Test
        void shouldAcceptHttpScheme() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 80);

            assertEquals("http", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(80, config.getPort());
        }

        @Test
        void shouldAcceptHttpsScheme() {
            ProxyConfiguration config = new ProxyConfiguration("https", "proxy.example.com", 443);

            assertEquals("https", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(443, config.getPort());
        }

        @Test
        void shouldDelegateToFullConstructor() {
            ProxyConfiguration config = new ProxyConfiguration("https", "proxy.example.com", 443);

            assertEquals("https", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(443, config.getPort());
            assertNull(config.getUsername());
            assertNull(config.getPassword());
        }

    }

    @Nested
    class WhenConstructingWith5Parameters {

        @Test
        void shouldCreateFullConfigurationInstance() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128, "user", "pass");

            assertEquals("http", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(3128, config.getPort());
            assertEquals("user", config.getUsername());
            assertEquals("pass", config.getPassword());
        }

        @Test
        void shouldThrowExceptionWhenSchemeIsNull() {
            assertThrows(IllegalArgumentException.class, () ->
                    new ProxyConfiguration(null, "proxy.example.com", 3128, "user", "pass")
            );
        }

        @Test
        void shouldThrowExceptionWhenSchemeIsEmpty() {
            assertThrows(IllegalArgumentException.class, () ->
                    new ProxyConfiguration("", "proxy.example.com", 3128, "user", "pass")
            );
        }

        @Test
        void shouldThrowExceptionWhenSchemeIsWhitespace() {
            assertThrows(IllegalArgumentException.class, () ->
                    new ProxyConfiguration("   ", "proxy.example.com", 3128, "user", "pass")
            );
        }

        @Test
        void shouldThrowExceptionWhenHostIsNull() {
            assertThrows(IllegalArgumentException.class, () ->
                    new ProxyConfiguration("http", null, 3128, "user", "pass")
            );
        }

        @Test
        void shouldThrowExceptionWhenHostIsEmpty() {
            assertThrows(IllegalArgumentException.class, () ->
                    new ProxyConfiguration("http", "", 3128, "user", "pass")
            );
        }

        @Test
        void shouldThrowExceptionWhenHostIsWhitespace() {
            assertThrows(IllegalArgumentException.class, () ->
                    new ProxyConfiguration("http", "   ", 3128, "user", "pass")
            );
        }

        @Test
        void shouldThrowExceptionWhenPortIsZero() {
            assertThrows(IllegalArgumentException.class, () ->
                    new ProxyConfiguration("http", "proxy.example.com", 0, "user", "pass")
            );
        }

        @Test
        void shouldThrowExceptionWhenPortIsNegative() {
            assertThrows(IllegalArgumentException.class, () ->
                    new ProxyConfiguration("http", "proxy.example.com", -1, "user", "pass")
            );
        }

        @Test
        void shouldThrowExceptionWhenPortIsGreaterThan65535() {
            assertThrows(IllegalArgumentException.class, () ->
                    new ProxyConfiguration("http", "proxy.example.com", 65536, "user", "pass")
            );
        }

        @Test
        void shouldAcceptValidPort1() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 1, null, null);

            assertEquals(1, config.getPort());
        }

        @Test
        void shouldAcceptValidPort65535() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 65535, null, null);

            assertEquals(65535, config.getPort());
        }

        @Test
        void shouldAcceptNullCredentials() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128, null, null);

            assertNull(config.getUsername());
            assertNull(config.getPassword());
        }

    }

    @Nested
    class WhenConstructingFromURI {

        @Test
        void shouldCreateFromHttpURI() {
            URI uri = URI.create("http://proxy.example.com:3128");
            ProxyConfiguration config = new ProxyConfiguration(uri);

            assertEquals("http", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(3128, config.getPort());
            assertNull(config.getUsername());
            assertNull(config.getPassword());
        }

        @Test
        void shouldCreateFromHttpsURI() {
            URI uri = URI.create("https://proxy.example.com:443");
            ProxyConfiguration config = new ProxyConfiguration(uri);

            assertEquals("https", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(443, config.getPort());
        }

        @Test
        void shouldDelegateToURIWithCredentialsConstructor() {
            URI uri = URI.create("http://proxy.example.com:3128");
            ProxyConfiguration config = new ProxyConfiguration(uri);

            assertEquals("http", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(3128, config.getPort());
        }

    }

    @Nested
    class WhenConstructingFromURIWithCredentials {

        @Test
        void shouldCreateFromURIWithCredentials() {
            URI uri = URI.create("http://proxy.example.com:3128");
            ProxyConfiguration config = new ProxyConfiguration(uri, "user", "pass");

            assertEquals("http", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(3128, config.getPort());
            assertEquals("user", config.getUsername());
            assertEquals("pass", config.getPassword());
        }

        @Test
        void shouldCreateFromURIWithNullCredentials() {
            URI uri = URI.create("https://proxy.example.com:443");
            ProxyConfiguration config = new ProxyConfiguration(uri, null, null);

            assertNull(config.getUsername());
            assertNull(config.getPassword());
        }

        @Test
        void shouldHandleURIWithoutExplicitPort() {
            URI uri = URI.create("http://proxy.example.com");
            ProxyConfiguration config = new ProxyConfiguration(uri);

            assertEquals("http", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(80, config.getPort());
        }

    }

    @Nested
    class WhenResolvingDefaultPorts {

        @Test
        void shouldDefaultHttpPortTo80() {
            URI uri = URI.create("http://proxy.example.com");
            ProxyConfiguration config = new ProxyConfiguration(uri);

            assertEquals(80, config.getPort());
        }

        @Test
        void shouldDefaultHttpsPortTo443() {
            URI uri = URI.create("https://proxy.example.com");
            ProxyConfiguration config = new ProxyConfiguration(uri);

            assertEquals(443, config.getPort());
        }

        @Test
        void shouldOverrideDefaultWithExplicitPort() {
            URI uri = URI.create("http://proxy.example.com:8080");
            ProxyConfiguration config = new ProxyConfiguration(uri);

            assertEquals(8080, config.getPort());
        }

    }

    @Nested
    class WhenHandlingInvalidURISchemes {

        @Test
        void shouldThrowExceptionForUnsupportedScheme() {
            URI uri = URI.create("ftp://proxy.example.com");

            assertThrows(IllegalArgumentException.class, () ->
                    new ProxyConfiguration(uri)
            );
        }

    }

    @Nested
    class WhenSettingAndGettingScheme {

        @Test
        void shouldSetAndGetScheme() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);

            config.setScheme("https");

            assertEquals("https", config.getScheme());
        }

        @Test
        void shouldReturnSelfFromFluentSchemeBuilder() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);

            ProxyConfiguration result = config.withScheme("socks5");

            assertSame(config, result);
            assertEquals("socks5", config.getScheme());
        }

        @Test
        void shouldHandleNullSchemeInSetter() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);

            config.setScheme(null);

            assertNull(config.getScheme());
        }

    }

    @Nested
    class WhenSettingAndGettingHost {

        @Test
        void shouldSetAndGetHost() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);

            config.setHost("newproxy.example.com");

            assertEquals("newproxy.example.com", config.getHost());
        }

        @Test
        void shouldReturnSelfFromFluentHostBuilder() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);

            ProxyConfiguration result = config.withHost("newproxy.example.com");

            assertSame(config, result);
            assertEquals("newproxy.example.com", config.getHost());
        }

        @Test
        void shouldHandleNullHostInSetter() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);

            config.setHost(null);

            assertNull(config.getHost());
        }

    }

    @Nested
    class WhenSettingAndGettingPort {

        @Test
        void shouldSetAndGetPort() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);

            config.setPort(8080);

            assertEquals(8080, config.getPort());
        }

        @Test
        void shouldReturnSelfFromFluentPortBuilder() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);

            ProxyConfiguration result = config.withPort(8080);

            assertSame(config, result);
            assertEquals(8080, config.getPort());
        }

        @Test
        void shouldSetMinimumValidPort() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);

            config.setPort(1);

            assertEquals(1, config.getPort());
        }

        @Test
        void shouldSetMaximumValidPort() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);

            config.setPort(65535);

            assertEquals(65535, config.getPort());
        }

    }

    @Nested
    class WhenSettingAndGettingUsername {

        @Test
        void shouldSetAndGetUsername() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);

            config.setUsername("proxyuser");

            assertEquals("proxyuser", config.getUsername());
        }

        @Test
        void shouldReturnSelfFromFluentUsernameBuilder() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);

            ProxyConfiguration result = config.withUsername("proxyuser");

            assertSame(config, result);
            assertEquals("proxyuser", config.getUsername());
        }

        @Test
        void shouldHandleNullUsername() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128, "user", "pass");

            config.setUsername(null);

            assertNull(config.getUsername());
        }

    }

    @Nested
    class WhenSettingAndGettingPassword {

        @Test
        void shouldSetAndGetPassword() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);

            config.setPassword("secret");

            assertEquals("secret", config.getPassword());
        }

        @Test
        void shouldReturnSelfFromFluentPasswordBuilder() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);

            ProxyConfiguration result = config.withPassword("secret");

            assertSame(config, result);
            assertEquals("secret", config.getPassword());
        }

        @Test
        void shouldHandleNullPassword() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128, "user", "pass");

            config.setPassword(null);

            assertNull(config.getPassword());
        }

    }

    @Nested
    class WhenChainingFluentMethods {

        @Test
        void shouldChainMultipleFluentCalls() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128)
                    .withScheme("https")
                    .withPort(443)
                    .withUsername("user")
                    .withPassword("pass");

            assertEquals("https", config.getScheme());
            assertEquals("proxy.example.com", config.getHost());
            assertEquals(443, config.getPort());
            assertEquals("user", config.getUsername());
            assertEquals("pass", config.getPassword());
        }

        @Test
        void shouldChainInDifferentOrder() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128)
                    .withPassword("pass")
                    .withUsername("user")
                    .withScheme("https");

            assertEquals("https", config.getScheme());
            assertEquals("user", config.getUsername());
            assertEquals("pass", config.getPassword());
        }

        @Test
        void shouldReturnSelfForEachFluentMethod() {
            ProxyConfiguration config = new ProxyConfiguration("http", "proxy.example.com", 3128);
            ProxyConfiguration withScheme = config.withScheme("https");
            ProxyConfiguration withPort = withScheme.withPort(443);
            ProxyConfiguration withUser = withPort.withUsername("user");

            assertSame(config, withScheme);
            assertSame(config, withPort);
            assertSame(config, withUser);
        }
    }
}
