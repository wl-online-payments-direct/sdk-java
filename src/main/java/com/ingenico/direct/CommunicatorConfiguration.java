package com.ingenico.direct;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import com.ingenico.direct.defaultimpl.AuthorizationType;
import com.ingenico.direct.domain.ShoppingCartExtension;

/**
 * Configuration for the communicator.
 */
public class CommunicatorConfiguration {

	/** The default number of maximum connections. */
	public static final int DEFAULT_MAX_CONNECTIONS = 10;
	public static final int DEFAULT_CONNECT_TIMEOUT = 10000;
	public static final int DEFAULT_SOCKET_TIMEOUT = 10000;

	/** The default HTTPS protocols. */
	public static final Set<String> DEFAULT_HTTPS_PROTOCOLS = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList("TLSv1.2")));

	private static final Pattern COMMA_SEPARATOR_PATTERN = Pattern.compile("\\s*,\\s*");

	private URI apiEndpoint;

	private int connectTimeout;

	private int socketTimeout;

	private int maxConnections = DEFAULT_MAX_CONNECTIONS;

	private AuthorizationType authorizationType;

	private String apiKeyId;

	private String secretApiKey;

	private ProxyConfiguration proxyConfiguration;

	private Set<String> httpsProtocols = new LinkedHashSet<String>(DEFAULT_HTTPS_PROTOCOLS);

	private String integrator;

	private ShoppingCartExtension shoppingCartExtension;

	public CommunicatorConfiguration() {}

	public CommunicatorConfiguration(Properties properties) {
		if (properties != null) {
			apiEndpoint       = getApiEndpoint(properties);
			authorizationType = AuthorizationType.valueOf(properties.getProperty("direct.api.authorizationType", AuthorizationType.V1HMAC.name()));
			connectTimeout    = getProperty(properties, "direct.api.connectTimeout", DEFAULT_CONNECT_TIMEOUT);
			socketTimeout     = getProperty(properties, "direct.api.socketTimeout", DEFAULT_SOCKET_TIMEOUT);
			maxConnections    = getProperty(properties, "direct.api.maxConnections", DEFAULT_MAX_CONNECTIONS);

			String proxyURI	  = properties.getProperty("direct.api.proxy.uri");
			if (proxyURI != null) {
				String proxyUser   = properties.getProperty("direct.api.proxy.username");
				String proxyPass   = properties.getProperty("direct.api.proxy.password");
				proxyConfiguration = new ProxyConfiguration(URI.create(proxyURI), proxyUser, proxyPass);
			}

			String httpsProtocolString = properties.getProperty("direct.api.https.protocols");
			if (httpsProtocolString != null) {
				httpsProtocols.clear();
				httpsProtocols.addAll(Arrays.asList(COMMA_SEPARATOR_PATTERN.split(httpsProtocolString.trim())));
			}

			integrator            = properties.getProperty("direct.api.integrator");
			shoppingCartExtension = getShoppingCartExtension(properties);
		}
	}

	private URI getApiEndpoint(Properties properties) {
		String host   = properties.getProperty("direct.api.endpoint.host");
		String scheme = properties.getProperty("direct.api.endpoint.scheme");
		String port   = properties.getProperty("direct.api.endpoint.port");

		return createURI(scheme != null ? scheme : "https", host, port != null ? Integer.parseInt(port) : -1);
	}

	private URI createURI(String scheme, String host, int port) {
		try {
			return new URI(scheme, null, host, port, null, null, null);
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException("Unable to construct API endpoint URI", e);
		}
	}

	private int getProperty(Properties properties, String key, int defaultValue) {
		String propertyValue = properties.getProperty(key);
		return propertyValue != null ? Integer.parseInt(propertyValue) : defaultValue;
	}

	private ShoppingCartExtension getShoppingCartExtension(Properties properties) {
		String creator     = properties.getProperty("direct.api.shoppingCartExtension.creator");
		String name        = properties.getProperty("direct.api.shoppingCartExtension.name");
		String version     = properties.getProperty("direct.api.shoppingCartExtension.version");
		String extensionId = properties.getProperty("direct.api.shoppingCartExtension.extensionId");

		if (creator == null && name == null && version == null && extensionId == null) {
			return null;
		} else if (extensionId == null) {
			return new ShoppingCartExtension(creator, name, version);
		} else {
			return new ShoppingCartExtension(creator, name, version, extensionId);
		}
	}

	/**
	 * Returns the Ingenico ePayments platform API endpoint URI.
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
	 * An identifier for the secret API key. The {@code apiKeyId} can be
	 * retrieved from the Configuration Center. This identifier is visible in
	 * the HTTP request and is also used to identify the correct account.
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
	 * A shared secret. The shared secret can be retrieved from the
	 * Configuration Center. An {@code apiKeyId} and {@code secretApiKey} always
	 * go hand-in-hand, the difference is that {@code secretApiKey} is never
	 * visible in the HTTP request. This secret is used as input for the HMAC
	 * algorithm.
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
			httpsProtocols = new LinkedHashSet<String>();
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
