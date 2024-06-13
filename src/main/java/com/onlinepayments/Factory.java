package com.onlinepayments;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

import com.onlinepayments.defaultimpl.DefaultAuthenticator;
import com.onlinepayments.defaultimpl.DefaultCommunicator;
import com.onlinepayments.defaultimpl.DefaultConnection;
import com.onlinepayments.defaultimpl.DefaultMarshaller;

/**
 * Online Payments platform factory for several SDK components.
 */
public final class Factory {

	private Factory() {}

	/**
	 * Creates a {@link CommunicatorConfiguration} based on the configuration
	 * values in {@code configurationFileUri} and {@code apiKeyId} and
	 * {@code secretApiKey}.
	 *
	 * @param configurationFileUri The Uri of the configuration file
	 * @param apiKeyId The API Key ID
	 * @param secretApiKey The API Secret Key
	 * @return A new instance of {@link CommunicatorConfiguration}
	 */
	public static CommunicatorConfiguration createConfiguration(URI configurationFileUri, String apiKeyId, String secretApiKey) {
		try {
			Properties properties = new Properties();
			InputStream configurationFileInputStream = configurationFileUri.toURL().openStream();
			try {
				properties.load(configurationFileInputStream);
			} finally {
				configurationFileInputStream.close();
			}
			return new CommunicatorConfiguration(properties)
					.withApiKeyId(apiKeyId)
					.withSecretApiKey(secretApiKey);
		} catch (IOException e) {
			throw new RuntimeException("Unable to load properties", e);
		}
	}

	/**
	 * Creates a {@link CommunicatorBuilder} based on the configuration values in
	 * {@code configurationFileUri}, {@code apiKeyId} and {@code secretApiKey}.
	 *
	 * @param configurationFileUri The Uri of the configuration file
	 * @param apiKeyId The API Key ID
	 * @param secretApiKey The API Secret Key
	 * @return An instance of {@link CommunicatorBuilder}
	 */
	public static CommunicatorBuilder createCommunicatorBuilder(URI configurationFileUri, String apiKeyId, String secretApiKey) {
		CommunicatorConfiguration configuration = createConfiguration(configurationFileUri, apiKeyId, secretApiKey);
		return createCommunicatorBuilder(configuration);
	}

	/**
	 * Creates a {@link CommunicatorBuilder} based on the passed configuration.
	 *
	 * @param configuration The configuration used for the creation of the CommunicatorBuilder
	 * @return An instancr of {@link CommunicatorBuilder}
	 */
	@SuppressWarnings("resource")
	public static CommunicatorBuilder createCommunicatorBuilder(CommunicatorConfiguration configuration) {

		MetaDataProvider metaDataProvider = new MetaDataProviderBuilder(configuration.getIntegrator())
				.withShoppingCartExtension(configuration.getShoppingCartExtension())
				.build();

		return new CommunicatorBuilder()
				.withAPIEndpoint(configuration.getApiEndpoint())
				.withConnection(new DefaultConnection(
						configuration.getConnectionRequestTimeout(),
						configuration.getConnectTimeout(),
						configuration.getSocketTimeout(),
						configuration.getMaxConnections(),
						configuration.getProxyConfiguration(),
						configuration.getHttpsProtocols()
				))
				.withMetaDataProvider(metaDataProvider)
				.withAuthenticator(new DefaultAuthenticator(
						configuration.getApiKeyId(),
						configuration.getSecretApiKey(),
						configuration.getAuthorizationType()
				))
				.withMarshaller(DefaultMarshaller.INSTANCE);
	}

	/**
	 * Creates a {@link DefaultCommunicator} based on the configuration values in
	 * {@code configurationFileUri}, {@code apiKeyId} and {@code secretApiKey}.
	 *
	 * @param configurationFileUri The Uri of the configuration file
	 * @param apiKeyId The API Key ID
	 * @param secretApiKey The API Secret Key
	 * @return An instance of {@link Communicator}
	 */
	public static Communicator createCommunicator(URI configurationFileUri, String apiKeyId, String secretApiKey) {
		CommunicatorConfiguration configuration = createConfiguration(configurationFileUri, apiKeyId, secretApiKey);
		return createCommunicator(configuration);
	}

	/**
	 * Creates a {@link DefaultCommunicator} based on the passed configuration.
	 *
	 * @param configuration The configuration used for creation of the communicator
	 * @return An instance of {@link Communicator}
	 */
	public static Communicator createCommunicator(CommunicatorConfiguration configuration) {
		return createCommunicatorBuilder(configuration).build();
	}

	/**
	 * Creates a {@link DefaultCommunicator} based on the passed parameters.
	 *
	 * @param apiEndpoint The API Endpoint URI
	 * @param connection The connection used for the creation
	 * @param authenticator The authenticator used for the creation
	 * @param metaDataProvider The metadata provider used for the creation
	 * @return An instance of {@link Communicator}
	 */
	public static Communicator createCommunicator(URI apiEndpoint, Connection connection, Authenticator authenticator, MetaDataProvider metaDataProvider) {
		return new DefaultCommunicator(apiEndpoint, connection, authenticator, metaDataProvider, DefaultMarshaller.INSTANCE);
	}

	/**
	 * Creates a {@link Client} based on the configuration values in
	 * {@code configurationFileUri}, {@code apiKeyId} and {@code secretApiKey}.
	 *
	 * @param configurationFileUri The URI of the configuration file
	 * @param apiKeyId The API Key ID
	 * @param secretApiKey The API Secret Key
	 * @return An instance of the Client
	 */
	public static ClientInterface createClient(URI configurationFileUri, String apiKeyId, String secretApiKey) {
		return createClient(createCommunicator(configurationFileUri, apiKeyId, secretApiKey));
	}

	/**
	 * Creates a {@link Client} based on the passed configuration.
	 *
	 * @param configuration The configuration used for the creation
	 * @return An instance of the Client
	 */
	public static ClientInterface createClient(CommunicatorConfiguration configuration) {
		return createClient(createCommunicator(configuration));
	}

	/**
	 * Creates a {@link Client} based on the passed parameters.
	 *
	 * @param apiEndpoint The API Endpoint URI
	 * @param connection The connection used for the creation
	 * @param authenticator The authenticator used for the creation
	 * @param metaDataProvider The metadata provider used for the creation
	 * @return An instance of the Client
	 */
	public static ClientInterface createClient(URI apiEndpoint, Connection connection, Authenticator authenticator, MetaDataProvider metaDataProvider) {
		return createClient(createCommunicator(apiEndpoint, connection, authenticator, metaDataProvider));
	}

	/**
	 * Creates a {@link Client} based on the passed {@link Communicator}.
	 *
	 * @param communicator The communicator used for the creation
	 * @return An instance of the Client
	 */
	public static ClientInterface createClient(Communicator communicator) {
		return new Client(communicator);
	}
}
