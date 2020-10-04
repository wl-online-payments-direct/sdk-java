package com.ingenico.direct.it;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Assume;

import com.ingenico.direct.Client;
import com.ingenico.direct.CommunicatorConfiguration;
import com.ingenico.direct.Factory;
import com.ingenico.direct.ProxyConfiguration;

abstract class ItTest {

	private static final String PROPERTIES_URL = "/itconfiguration.properties";
	private static final String API_KEY_ID;
	private static final String SECRET_API_KEY;
	public final static String MERCHANT_ID;

	static {
		API_KEY_ID = getProperty("direct.api.apiKeyId");
		SECRET_API_KEY = getProperty("direct.api.secretApiKey");
		if (API_KEY_ID == null || SECRET_API_KEY == null) {
			throw new IllegalStateException("System properties 'direct.api.apiKeyId' and 'direct.api.secretApiKey' must be set.");
		}
		MERCHANT_ID = getProperty("direct.api.merchantId");
		if (MERCHANT_ID == null) {
			throw new IllegalStateException("System properties 'direct.api.merchantId' must be set.");
		}
	}

	private CommunicatorConfiguration getCommunicatorConfiguration(URL propertiesUrl) throws URISyntaxException {
		CommunicatorConfiguration configuration = Factory.createConfiguration(propertiesUrl.toURI(), API_KEY_ID, SECRET_API_KEY);

		String host = getProperty("direct.api.endpoint.host");
		if (host != null) {
			String scheme = getProperty("direct.api.endpoint.scheme", "https");
			int port = Integer.parseInt(getProperty("direct.api.endpoint.port", "443"));
			URI apiEndpoint = new URI(scheme, null, host, port, null, null, null);
			configuration = configuration.withApiEndpoint(apiEndpoint);
		}

		String httpsProtocols = getProperty("direct.api.https.protocols");
		if (httpsProtocols != null) {
			configuration = configuration.withHttpsProtocols(httpsProtocols.split("\\s*,\\s*"));
		}

		return configuration;
	}

	protected CommunicatorConfiguration getCommunicatorConfiguration() throws URISyntaxException {
		URL propertiesUrl = getClass().getResource(PROPERTIES_URL);
		return getCommunicatorConfiguration(propertiesUrl);
	}

	protected CommunicatorConfiguration getCommunicatorConfigurationWithProxy() throws URISyntaxException {
		String proxyURI = getProperty("direct.api.proxy.uri");
		String proxyUsername = getProperty("direct.api.proxy.username");
		String proxyPassword = getProperty("direct.api.proxy.password");
		Assume.assumeTrue("System property 'direct.api.proxy.uri' must be set for this test to run.",
				proxyURI != null);

		return getCommunicatorConfiguration()
				.withProxyConfiguration(new ProxyConfiguration(new URI(proxyURI), proxyUsername, proxyPassword));
	}

	protected Client getClient() throws URISyntaxException {
		URL propertiesUrl = getClass().getResource(PROPERTIES_URL);
		CommunicatorConfiguration configuration = getCommunicatorConfiguration(propertiesUrl);
		return Factory
				.createClient(configuration)
				.withClientMetaInfo("{\"test\":\"test\"}");
	}

	protected Client getClientWithProxy() throws URISyntaxException {
		CommunicatorConfiguration configuration = getCommunicatorConfigurationWithProxy();
		return Factory
				.createClient(configuration)
				.withClientMetaInfo("{\"test\":\"test\"}");
	}

	protected static String getProperty(String propertyKey) {
		return getProperty(propertyKey, null);
	}
	protected static String getProperty(String propertyKey, String defaultValue) {
		String property = System.getProperty(propertyKey);
		if (property == null) {
			property = System.getenv(propertyKey);
		}
		return property != null
				? property
				: defaultValue;
	}
}
