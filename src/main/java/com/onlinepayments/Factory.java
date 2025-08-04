package com.onlinepayments;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

import com.onlinepayments.authentication.Authenticator;
import com.onlinepayments.authentication.AuthorizationType;
import com.onlinepayments.authentication.V1HmacAuthenticator;
import com.onlinepayments.communication.Connection;
import com.onlinepayments.communication.DefaultConnectionBuilder;
import com.onlinepayments.communication.MetadataProvider;
import com.onlinepayments.communication.MetadataProviderBuilder;
import com.onlinepayments.json.DefaultMarshaller;

/**
 * Online Payments platform factory for several SDK components.
 */
public final class Factory {

    private Factory() {
    }

    /**
     * Creates a {@link CommunicatorConfiguration} based on the configuration
     * values in {@code configurationFileUri} and {@code apiKeyId} and
     * {@code authorizationSecret}.
     */
    public static CommunicatorConfiguration createConfiguration(URI configurationFileUri, String apiKeyId, String secretApiKey) {
        Properties properties = new Properties();
        try (InputStream configurationFileInputStream = configurationFileUri.toURL().openStream()) {
            properties.load(configurationFileInputStream);
            return new CommunicatorConfiguration(properties)
                    .withApiKeyId(apiKeyId)
                    .withSecretApiKey(secretApiKey);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load properties", e);
        }
    }

    /**
     * Creates a {@link CommunicatorBuilder} based on the configuration values in
     * {@code configurationFileUri}, {@code apiKeyId} and {@code secretApiKey}.
     */
    public static CommunicatorBuilder createCommunicatorBuilder(URI configurationFileUri, String apiKeyId, String secretApiKey) {
        CommunicatorConfiguration configuration = createConfiguration(configurationFileUri, apiKeyId, secretApiKey);
        return createCommunicatorBuilder(configuration);
    }

    /**
     * Creates a {@link CommunicatorBuilder} based on the passed configuration.
     */
    public static CommunicatorBuilder createCommunicatorBuilder(CommunicatorConfiguration configuration) {

        MetadataProvider metadataProvider = new MetadataProviderBuilder(configuration.getIntegrator())
                .withShoppingCartExtension(configuration.getShoppingCartExtension())
                .build();

        return new CommunicatorBuilder()
                .withAPIEndpoint(configuration.getApiEndpoint())
                .withConnection(new DefaultConnectionBuilder(configuration.getConnectionRequestTimeout(), configuration.getConnectTimeout(), configuration.getSocketTimeout())
                        .withMaxConnections(configuration.getMaxConnections())
                        .withConnectionReuse(configuration.isConnectionReuse())
                        .withProxyConfiguration(configuration.getProxyConfiguration())
                        .withHttpsProtocols(configuration.getHttpsProtocols())
                        .build()
                )
                .withMetadataProvider(metadataProvider)
                .withAuthenticator(getAuthenticator(configuration))
                .withMarshaller(DefaultMarshaller.INSTANCE);
    }

    /**
     * Creates an {@link Authenticator} based on the passed configuration.
     */
    private static Authenticator getAuthenticator(CommunicatorConfiguration configuration) {
        if (configuration.getAuthorizationType() == AuthorizationType.V1HMAC) {
            return new V1HmacAuthenticator(configuration);
        }
        throw new IllegalStateException("Unknown authorizationType " + configuration.getAuthorizationType());
    }

    /**
     * Creates a {@link Communicator} based on the configuration values in
     * {@code configurationFileUri}, {@code apiKeyId} and {@code secretApiKey}.
     */
    public static Communicator createCommunicator(URI configurationFileUri, String apiKeyId, String secretApiKey) {
        CommunicatorConfiguration configuration = createConfiguration(configurationFileUri, apiKeyId, secretApiKey);
        return createCommunicator(configuration);
    }

    /**
     * Creates a {@link Communicator} based on the passed configuration.
     */
    public static Communicator createCommunicator(CommunicatorConfiguration configuration) {
        CommunicatorBuilder communicatorBuilder = createCommunicatorBuilder(configuration);
        return communicatorBuilder.build();
    }

    /**
     * Creates a {@link Communicator} based on the passed parameters.
     */
    public static Communicator createCommunicator(URI apiEndpoint, Connection connection, Authenticator authenticator, MetadataProvider metadataProvider) {
        return new DefaultCommunicator(apiEndpoint, connection, authenticator, metadataProvider, DefaultMarshaller.INSTANCE);
    }

    /**
     * Creates a {@link Client} based on the configuration values in
     * {@code configurationFileUri}, {@code apiKeyId} and {@code secretApiKey}.
     */
    public static ClientInterface createClient(URI configurationFileUri, String apiKeyId, String secretApiKey) {
        Communicator communicator = createCommunicator(configurationFileUri, apiKeyId, secretApiKey);
        return createClient(communicator);
    }

    /**
     * Creates a {@link Client} based on the passed configuration.
     */
    public static ClientInterface createClient(CommunicatorConfiguration configuration) {
        Communicator communicator = createCommunicator(configuration);
        return createClient(communicator);
    }

    /**
     * Creates a {@link Client} based on the passed parameters.
     */
    public static ClientInterface createClient(URI apiEndpoint, Connection connection, Authenticator authenticator, MetadataProvider metadataProvider) {
        Communicator communicator = createCommunicator(apiEndpoint, connection, authenticator, metadataProvider);
        return createClient(communicator);
    }

    /**
     * Creates a {@link Client} based on the passed {@link Communicator}.
     */
    public static ClientInterface createClient(Communicator communicator) {
        return new Client(communicator);
    }
}
