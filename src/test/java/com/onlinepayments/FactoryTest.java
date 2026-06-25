package com.onlinepayments;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.authentication.Authenticator;
import com.onlinepayments.authentication.AuthorizationType;
import com.onlinepayments.authentication.V1HmacAuthenticator;
import com.onlinepayments.communication.Connection;
import com.onlinepayments.communication.DefaultConnection;
import com.onlinepayments.communication.DefaultConnectionBuilder;
import com.onlinepayments.communication.DefaultMetadataProvider;
import com.onlinepayments.communication.MetadataProvider;
import com.onlinepayments.communication.RequestHeader;
import com.onlinepayments.json.DefaultMarshaller;
import com.onlinepayments.json.Marshaller;
import com.onlinepayments.util.DefaultConnectionAssertions;
import com.onlinepayments.util.ReflectionUtil;

class FactoryTest {

    final URI propertiesUri;
    final URI invalidPropertiesUri;
    final String authId = "apiKeyId";
    final String authSecret = "secretApiKey";

    FactoryTest() {
        try {
            propertiesUri = FactoryTest.class.getResource("configuration.v1hmac.properties").toURI();
            invalidPropertiesUri = FactoryTest.class.getResource("configuration.invalid-endpoint.properties").toURI();
        } catch (URISyntaxException e) {
            InstantiationError error = new InstantiationError(e.getMessage());
            error.initCause(e);
            throw error;
        }
    }

    @Nested
    class WhenCreateConfigurationIsCalled {

        @Nested
        class WithValidPropertiesUri {

            @Test
            void shouldReturnExpectedConfiguration() {
                CommunicatorConfiguration configuration = Factory.createConfiguration(
                        propertiesUri,
                        authId,
                        authSecret
                );

                assertEquals(URI.create("https://payment.preprod.online-payments.com"), configuration.getApiEndpoint());
                assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
                assertEquals(1000, configuration.getConnectTimeout());
                assertEquals(1000, configuration.getSocketTimeout());
                assertEquals(100, configuration.getMaxConnections());
                assertEquals(authId, configuration.getApiKeyId());
                assertEquals(authSecret, configuration.getSecretApiKey());
                assertNull(configuration.getProxyConfiguration());
            }
        }

        @Nested
        class WithInvalidPropertiesUri {

            @Test
            void shouldThrowRuntimeException() {
                assertThrows(
                        RuntimeException.class,
                        () -> Factory.createConfiguration(invalidPropertiesUri, authId, authSecret)
                );
            }
        }
    }

    @Nested
    class WhenCreateCommunicatorBuilderIsCalled {

        @Nested
        class WithValidPropertiesUri {

            @Test
            @SuppressWarnings("resource")
            void shouldReturnBuilderWithExpectedConfiguration() {
                CommunicatorBuilder builder = Factory.createCommunicatorBuilder(
                        propertiesUri,
                        authId,
                        authSecret
                );

                URI apiEndpoint = ReflectionUtil.getField(builder, "apiEndpoint", URI.class);
                assertEquals(URI.create("https://payment.preprod.online-payments.com"), apiEndpoint);

                @SuppressWarnings("resource")
                Connection connection = ReflectionUtil.getField(builder, "connection", Connection.class);
                DefaultConnection defaultConnection = assertInstanceOf(DefaultConnection.class, connection);
                DefaultConnectionAssertions.assertConnection(defaultConnection, 1000, 1000, 100, null);

                MetadataProvider metadataProvider = ReflectionUtil.getField(
                        builder,
                        "metadataProvider",
                        MetadataProvider.class
                );
                assertEquals(DefaultMetadataProvider.class, metadataProvider.getClass());

                Authenticator authenticator = ReflectionUtil.getField(
                        builder,
                        "authenticator",
                        Authenticator.class
                );
                assertInstanceOf(V1HmacAuthenticator.class, authenticator);

                Marshaller marshaller = ReflectionUtil.getField(builder, "marshaller", Marshaller.class);
                assertSame(DefaultMarshaller.INSTANCE, marshaller);
            }
        }

        @Nested
        class WithInvalidPropertiesUri {

            @Test
            void shouldThrowRuntimeException() {
                assertThrows(
                        RuntimeException.class,
                        () -> Factory.createCommunicatorBuilder(invalidPropertiesUri, authId, authSecret)
                );
            }
        }

        @Nested
        class WithUnsupportedAuthorizationType {

            @Test
            void shouldThrowIllegalStateException() {
                CommunicatorConfiguration configuration = new CommunicatorConfiguration()
                        .withApiEndpoint(URI.create("https://example-payments.com"))
                        .withAuthorizationType(null)
                        .withConnectTimeout(1000)
                        .withSocketTimeout(1000)
                        .withConnectionRequestTimeout(1000)
                        .withMaxConnections(100)
                        .withApiKeyId(authId)
                        .withSecretApiKey(authSecret)
                        .withIntegrator("test-integrator");

                assertThrows(
                        IllegalStateException.class,
                        () -> Factory.createCommunicatorBuilder(configuration)
                );
            }
        }
    }

    @Nested
    class WhenCreateCommunicatorIsCalled {

        @Nested
        class WithValidPropertiesUri {

            @Test
            void shouldReturnExpectedCommunicator() {
                @SuppressWarnings("resource")
                Communicator communicator = Factory.createCommunicator(
                        propertiesUri,
                        authId,
                        authSecret
                );

                assertSame(DefaultMarshaller.INSTANCE, communicator.getMarshaller());

                @SuppressWarnings("resource")
                Connection connection = ReflectionUtil.getField(communicator, "connection", Connection.class);

                @SuppressWarnings("resource")
                DefaultConnection defaultConnection = assertInstanceOf(DefaultConnection.class, connection);
                DefaultConnectionAssertions.assertConnection(defaultConnection, 1000, 1000, 100, null);

                Authenticator authenticator = ReflectionUtil.getField(
                        communicator,
                        "authenticator",
                        Authenticator.class
                );
                assertInstanceOf(V1HmacAuthenticator.class, authenticator);
                assertEquals(authId, ReflectionUtil.getField(authenticator, "apiKeyId", String.class));
                assertEquals(authSecret, ReflectionUtil.getField(authenticator, "secretApiKey", String.class));

                MetadataProvider metadataProvider = ReflectionUtil.getField(
                        communicator,
                        "metadataProvider",
                        MetadataProvider.class
                );
                assertEquals(DefaultMetadataProvider.class, metadataProvider.getClass());

                Collection<RequestHeader> requestHeaders = metadataProvider.getServerMetadataHeaders();
                assertEquals(1, requestHeaders.size());

                RequestHeader requestHeader = requestHeaders.iterator().next();
                assertEquals("X-GCS-ServerMetaInfo", requestHeader.getName());
            }
        }

        @Nested
        class WithInvalidPropertiesUri {

            @Test
            void shouldThrowRuntimeException() {
                assertThrows(
                        RuntimeException.class,
                        () -> Factory.createCommunicator(invalidPropertiesUri, authId, authSecret)
                );
            }
        }
    }

    @Nested
    class WhenCreateClientIsCalled {

        @Nested
        class WithValidPropertiesUri {

            @Test
            @SuppressWarnings("resource")
            void shouldReturnNonNullClient() {
                ClientInterface client = Factory.createClient(
                        propertiesUri,
                        authId,
                        authSecret
                );

                assertNotNull(client);
            }
        }

        @Nested
        class WithInvalidPropertiesUri {

            @Test
            void shouldThrowRuntimeException() {
                assertThrows(
                        RuntimeException.class,
                        () -> Factory.createClient(invalidPropertiesUri, authId, authSecret)
                );
            }
        }

        @Nested
        class WithCommunicatorConfiguration {

            @Test
            @SuppressWarnings("resource")
            void shouldReturnClientFromConfiguration() {
                CommunicatorConfiguration configuration = Factory.createConfiguration(
                        propertiesUri,
                        authId,
                        authSecret
                );

                ClientInterface client = Factory.createClient(configuration);

                assertNotNull(client);
                assertInstanceOf(Client.class, client);
            }
        }

        @Nested
        class WithDirectParameters {

            @Test
            @SuppressWarnings("resource")
            void shouldReturnClientFromDirectParameters() {
                URI apiEndpoint = URI.create("https://payment.example.com");
                Connection connection = new DefaultConnectionBuilder(1000, 1000, 1000)
                        .withMaxConnections(10)
                        .build();
                Authenticator authenticator = new V1HmacAuthenticator(authId, authSecret, AuthorizationType.V1HMAC);
                MetadataProvider metadataProvider = new DefaultMetadataProvider("test-integrator");

                ClientInterface client = Factory.createClient(apiEndpoint, connection, authenticator, metadataProvider);

                assertNotNull(client);
                assertInstanceOf(Client.class, client);
            }
        }
    }

    @Nested
    class WhenCreateCommunicatorWithDirectParametersIsCalled {

        @Test
        @SuppressWarnings("resource")
        void shouldReturnCommunicatorFromDirectParameters() {
            URI apiEndpoint = URI.create("https://payment.example.com");
            Connection connection = new DefaultConnectionBuilder(1000, 1000, 1000)
                    .withMaxConnections(10)
                    .build();
            Authenticator authenticator = new V1HmacAuthenticator(authId, authSecret, AuthorizationType.V1HMAC);
            MetadataProvider metadataProvider = new DefaultMetadataProvider("test-integrator");

            Communicator communicator = Factory.createCommunicator(apiEndpoint, connection, authenticator, metadataProvider);

            assertNotNull(communicator);
            assertSame(DefaultMarshaller.INSTANCE, communicator.getMarshaller());

            Connection retrievedConnection = ReflectionUtil.getField(communicator, "connection", Connection.class);
            assertSame(connection, retrievedConnection);

            Authenticator retrievedAuthenticator = ReflectionUtil.getField(communicator, "authenticator", Authenticator.class);
            assertSame(authenticator, retrievedAuthenticator);

            MetadataProvider retrievedMetadataProvider = ReflectionUtil.getField(communicator, "metadataProvider", MetadataProvider.class);
            assertSame(metadataProvider, retrievedMetadataProvider);
        }
    }
}
