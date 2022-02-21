package com.onlinepayments.it;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Assume;

import com.onlinepayments.Client;
import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.Factory;
import com.onlinepayments.ProxyConfiguration;

abstract class ItTest {

	private static final String PROPERTIES_URL = "/itconfiguration.properties";
	private static final String API_KEY_ID;
	private static final String SECRET_API_KEY;
	protected static final String MERCHANT_ID;

	static {
		API_KEY_ID = getProperty("onlinePayments.api.apiKeyId");
		SECRET_API_KEY = getProperty("onlinePayments.api.secretApiKey");
		if (API_KEY_ID == null || SECRET_API_KEY == null) {
			throw new IllegalStateException("System properties 'onlinePayments.api.apiKeyId' and 'onlinePayments.api.secretApiKey' must be set.");
		}
		MERCHANT_ID = getProperty("onlinePayments.api.merchantId");
		if (MERCHANT_ID == null) {
			throw new IllegalStateException("System properties 'onlinePayments.api.merchantId' must be set.");
		}
	}

	private CommunicatorConfiguration getCommunicatorConfiguration(URL propertiesUrl) throws URISyntaxException {
		CommunicatorConfiguration configuration = Factory.createConfiguration(propertiesUrl.toURI(), API_KEY_ID, SECRET_API_KEY);

		String host = getProperty("onlinePayments.api.endpoint.host");
		if (host != null) {
			String scheme = getProperty("onlinePayments.api.endpoint.scheme", "https");
			int port = Integer.parseInt(getProperty("onlinePayments.api.endpoint.port", "443"));
			URI apiEndpoint = new URI(scheme, null, host, port, null, null, null);
			configuration = configuration.withApiEndpoint(apiEndpoint);
		}

		String httpsProtocols = getProperty("onlinePayments.api.https.protocols");
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
		String proxyURI = getProperty("onlinePayments.api.proxy.uri");
		String proxyUsername = getProperty("onlinePayments.api.proxy.username");
		String proxyPassword = getProperty("onlinePayments.api.proxy.password");
		Assume.assumeTrue("System property 'onlinePayments.api.proxy.uri' must be set for this test to run.",
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
