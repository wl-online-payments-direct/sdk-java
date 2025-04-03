package com.onlinepayments;

import java.net.URI;

import com.onlinepayments.authentication.Authenticator;
import com.onlinepayments.communication.Connection;
import com.onlinepayments.communication.MetadataProvider;
import com.onlinepayments.json.Marshaller;

/**
 * Builder for a {@link Communicator} object.
 */
public class CommunicatorBuilder {

    private URI apiEndpoint;

    private Connection connection;

    private MetadataProvider metadataProvider;

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
     * Sets the {@link MetadataProvider} to use.
     */
    public CommunicatorBuilder withMetadataProvider(MetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
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
                metadataProvider,
                marshaller
        );
    }
}
