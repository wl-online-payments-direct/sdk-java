package com.onlinepayments;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import com.onlinepayments.authentication.AuthorizationType;
import com.onlinepayments.domain.ShoppingCartExtension;

/**
 * Configuration for the communicator.
 */
public class CommunicatorConfiguration {

    /** The default number of maximum connections. */
    public static final int DEFAULT_MAX_CONNECTIONS = 10;

    public static final int DEFAULT_CONNECTION_REQUEST_TIMEOUT = 5000;

    /** The default HTTPS protocols. */
    public static final Set<String> DEFAULT_HTTPS_PROTOCOLS = Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList("TLSv1.1", "TLSv1.2")));

    private static final Pattern COMMA_SEPARATOR_PATTERN = Pattern.compile("\\s*,\\s*");

    private URI apiEndpoint;

    private int connectionRequestTimeout;

    private int connectTimeout;

    private int socketTimeout;

    private int maxConnections = DEFAULT_MAX_CONNECTIONS;

    private boolean connectionReuse = true;

    private AuthorizationType authorizationType;

    private String apiKeyId;

    private String secretApiKey;

    private ProxyConfiguration proxyConfiguration;

    private Set<String> httpsProtocols = new LinkedHashSet<>(DEFAULT_HTTPS_PROTOCOLS);

    private String integrator;

    private ShoppingCartExtension shoppingCartExtension;

    public CommunicatorConfiguration() {
    }

    public CommunicatorConfiguration(Properties properties) {
        if (properties != null) {
            apiEndpoint       = getApiEndpoint(properties);
            authorizationType = AuthorizationType.valueOf(properties.getProperty("onlinePayments.api.authorizationType"));
            connectionRequestTimeout = getProperty(properties, "onlinePayments.api.connectionRequestTimeout", DEFAULT_CONNECTION_REQUEST_TIMEOUT);
            connectTimeout    = Integer.parseInt(properties.getProperty("onlinePayments.api.connectTimeout"));
            socketTimeout     = Integer.parseInt(properties.getProperty("onlinePayments.api.socketTimeout"));
            maxConnections    = getProperty(properties, "onlinePayments.api.maxConnections", DEFAULT_MAX_CONNECTIONS);

            String proxyURI  = properties.getProperty("onlinePayments.api.proxy.uri");
            String proxyUser = properties.getProperty("onlinePayments.api.proxy.username");
            String proxyPass = properties.getProperty("onlinePayments.api.proxy.password");
            if (proxyURI != null) {
                proxyConfiguration = new ProxyConfiguration(URI.create(proxyURI), proxyUser, proxyPass);
            }

            String httpsProtocolString = properties.getProperty("onlinePayments.api.https.protocols");
            if (httpsProtocolString != null) {
                httpsProtocols.clear();
                httpsProtocols.addAll(Arrays.asList(COMMA_SEPARATOR_PATTERN.split(httpsProtocolString.trim())));
            }

            connectionReuse = Boolean.parseBoolean(properties.getProperty("onlinePayments.api.connectionReuse", "true"));

            integrator            = properties.getProperty("onlinePayments.api.integrator");
            shoppingCartExtension = getShoppingCartExtension(properties);
        }
    }

    private static int getProperty(Properties properties, String key, int defaultValue) {
        String propertyValue = properties.getProperty(key, null);
        return propertyValue != null ? Integer.parseInt(propertyValue) : defaultValue;
    }

    private static URI getApiEndpoint(Properties properties) {
        String host   = properties.getProperty("onlinePayments.api.endpoint.host");
        String scheme = properties.getProperty("onlinePayments.api.endpoint.scheme");
        String port   = properties.getProperty("onlinePayments.api.endpoint.port");

        return createURI(scheme != null ? scheme : "https", host, port != null ? Integer.parseInt(port) : -1);
    }

    private static URI createURI(String scheme, String host, int port) {
        try {
            return new URI(scheme, null, host, port, null, null, null);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Unable to construct API endpoint URI", e);
        }
    }

    private static ShoppingCartExtension getShoppingCartExtension(Properties properties) {
        String creator     = properties.getProperty("onlinePayments.api.shoppingCartExtension.creator");
        String name        = properties.getProperty("onlinePayments.api.shoppingCartExtension.name");
        String version     = properties.getProperty("onlinePayments.api.shoppingCartExtension.version");
        String extensionId = properties.getProperty("onlinePayments.api.shoppingCartExtension.extensionId");

        if (creator == null && name == null && version == null && extensionId == null) {
            return null;
        } else if (extensionId == null) {
            return new ShoppingCartExtension(creator, name, version);
        } else {
            return new ShoppingCartExtension(creator, name, version, extensionId);
        }
    }

    /**
     * Returns the Online Payments platform API endpoint URI.
     */
    public URI getApiEndpoint() {
        return apiEndpoint;
    }

    public void setApiEndpoint(URI apiEndpoint) {
        if (apiEndpoint != null && apiEndpoint.getPath() != null && !apiEndpoint.getPath().isEmpty()) {
            throw new IllegalArgumentException("apiEndpoint should not contain a path");
        }
        if (apiEndpoint != null && (
                   apiEndpoint.getUserInfo() != null
                || apiEndpoint.getQuery() != null
                || apiEndpoint.getFragment() != null
                )) {
            throw new IllegalArgumentException("apiEndpoint should not contain user info, query or fragment");
        }
        this.apiEndpoint = apiEndpoint;
    }

    public CommunicatorConfiguration withApiEndpoint(URI apiEndpoint) {
        setApiEndpoint(apiEndpoint);
        return this;
    }

    /**
     * Returns an id used for authorization. The meaning of this id is different for each authorization type.
     */
    public String getApiKeyId() {
        return apiKeyId;
    }

    public void setApiKeyId(String apiKeyId) {
        this.apiKeyId = apiKeyId;
    }

    public CommunicatorConfiguration withApiKeyId(String apiKeyId) {
        setApiKeyId(apiKeyId);
        return this;
    }

    /**
     * Returns a secret used for authorization. The meaning of this secret is different for each authorization type.
     */
    public String getSecretApiKey() {
        return secretApiKey;
    }

    public void setSecretApiKey(String secretApiKey) {
        this.secretApiKey = secretApiKey;
    }

    public CommunicatorConfiguration withSecretApiKey(String secretApiKey) {
        setSecretApiKey(secretApiKey);
        return this;
    }

    public AuthorizationType getAuthorizationType() {
        return authorizationType;
    }

    public void setAuthorizationType(AuthorizationType authorizationType) {
        this.authorizationType = authorizationType;
    }

    public CommunicatorConfiguration withAuthorizationType(AuthorizationType authorizationType) {
        setAuthorizationType(authorizationType);
        return this;
    }

    public int getConnectionRequestTimeout() {
        return connectionRequestTimeout;
    }

    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public CommunicatorConfiguration withConnectionRequestTimeout(int connectionRequestTimeout) {
        setConnectionRequestTimeout(connectionRequestTimeout);
        return this;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public CommunicatorConfiguration withConnectTimeout(int connectTimeout) {
        setConnectTimeout(connectTimeout);
        return this;
    }

    public int getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public CommunicatorConfiguration withSocketTimeout(int socketTimeout) {
        setSocketTimeout(socketTimeout);
        return this;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public CommunicatorConfiguration withMaxConnections(int maxConnections) {
        setMaxConnections(maxConnections);
        return this;
    }

    public boolean isConnectionReuse() {
        return connectionReuse;
    }

    public void setConnectionReuse(boolean connectionReuse) {
        this.connectionReuse = connectionReuse;
    }

    public CommunicatorConfiguration withConnectionReuse(boolean connectionReuse) {
        this.connectionReuse = connectionReuse;
        return this;
    }

    public ProxyConfiguration getProxyConfiguration() {
        return proxyConfiguration;
    }

    public void setProxyConfiguration(ProxyConfiguration proxyConfiguration) {
        this.proxyConfiguration = proxyConfiguration;
    }

    public CommunicatorConfiguration withProxyConfiguration(ProxyConfiguration proxyConfiguration) {
        setProxyConfiguration(proxyConfiguration);
        return this;
    }

    public Set<String> getHttpsProtocols() {
        if (httpsProtocols == null) {
            httpsProtocols = new LinkedHashSet<>();
        }
        return httpsProtocols;
    }

    public void setHttpsProtocols(Set<String> httpsProtocols) {
        this.httpsProtocols = httpsProtocols;
    }

    public CommunicatorConfiguration withHttpsProtocols(Collection<String> httpsProtocols) {
        getHttpsProtocols().clear();
        getHttpsProtocols().addAll(httpsProtocols);
        return this;
    }

    public CommunicatorConfiguration withHttpsProtocols(String... httpsProtocols) {
        return withHttpsProtocols(Arrays.asList(httpsProtocols));
    }

    public String getIntegrator() {
        return integrator;
    }

    public void setIntegrator(String integrator) {
        this.integrator = integrator;
    }

    public CommunicatorConfiguration withIntegrator(String integrator) {
        setIntegrator(integrator);
        return this;
    }

    public ShoppingCartExtension getShoppingCartExtension() {
        return shoppingCartExtension;
    }

    public void setShoppingCartExtension(ShoppingCartExtension shoppingCartExtension) {
        this.shoppingCartExtension = shoppingCartExtension;
    }

    public CommunicatorConfiguration withShoppingCartExtension(ShoppingCartExtension shoppingCartExtension) {
        setShoppingCartExtension(shoppingCartExtension);
        return this;
    }
}
