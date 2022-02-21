package com.onlinepayments;

import java.net.URI;

import com.onlinepayments.defaultimpl.DefaultCommunicator;

/**
 * Builder for a {@link Communicator} object.
 */
public class CommunicatorBuilder {

	private URI apiEndpoint;
	private Connection connection;
	private MetaDataProvider metaDataProvider;
	private Authenticator authenticator;
	private Marshaller marshaller;

	/**
	 * Sets the Online Payments platform API endpoint URI to use.
	 */
	public CommunicatorBuilder withAPIEndpoint(URI apiEndpoint) {
		this.apiEndpoint = apiEndpoint;
		return this;
	}

	/**
	 * Sets the {@link Connection} to use.
	 */
	public CommunicatorBuilder withConnection(Connection connection) {
		this.connection = connection;
		return this;
	}

	/**
	 * Sets the {@link Authenticator} to use.
	 */
	public CommunicatorBuilder withAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
		return this;
	}

	/**
	 * Sets the {@link MetaDataProvider} to use.
	 */
	public CommunicatorBuilder withMetaDataProvider(MetaDataProvider metaDataProvider) {
		this.metaDataProvider = metaDataProvider;
		return this;
	}

	/**
	 * Sets the {@link Marshaller} to use.
	 */
	public CommunicatorBuilder withMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
		return this;
	}

	/**
	 * Creates a fully initialized {@link Communicator} object.
	 *
	 * @throws IllegalArgumentException if not all required components are set
	 */
	public Communicator build() {
		return new DefaultCommunicator(
				apiEndpoint,
				connection,
				authenticator,
				metaDataProvider,
				marshaller
		);
	}
}
