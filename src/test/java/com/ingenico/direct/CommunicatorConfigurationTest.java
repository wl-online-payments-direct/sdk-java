package com.ingenico.direct;

import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

import com.ingenico.direct.defaultimpl.AuthorizationType;

public class CommunicatorConfigurationTest {

	private static final String TEST_ENDPOINT_HOST = "payment.preprod.direct.ingenico.com";
	private static final String TEST_ENDPOINT = "https://" + TEST_ENDPOINT_HOST;

	@Test
	public void testConstructFromPropertiesWithoutProxy() {

		Properties properties = new Properties();
		properties.setProperty("direct.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("direct.api.authorizationType", "V1HMAC");
		properties.setProperty("direct.api.connectTimeout", "20000");
		properties.setProperty("direct.api.socketTimeout", "10000");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create(TEST_ENDPOINT), configuration.getApiEndpoint());
		Assert.assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
		Assert.assertEquals(20000, configuration.getConnectTimeout());
		Assert.assertEquals(10000, configuration.getSocketTimeout());
		Assert.assertEquals(CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, configuration.getMaxConnections());
		Assert.assertNull(configuration.getApiKeyId());
		Assert.assertNull(configuration.getSecretApiKey());
		Assert.assertNull(configuration.getProxyConfiguration());
		Assert.assertEquals(CommunicatorConfiguration.DEFAULT_HTTPS_PROTOCOLS, configuration.getHttpsProtocols());
		Assert.assertNull(configuration.getIntegrator());
		Assert.assertNull(configuration.getShoppingCartExtension());
	}

	@Test
	public void testConstructFromPropertiesWithProxyWithoutAuthentication() {

		Properties properties = new Properties();
		properties.setProperty("direct.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("direct.api.authorizationType", "V1HMAC");
		properties.setProperty("direct.api.connectTimeout", "20000");
		properties.setProperty("direct.api.socketTimeout", "10000");
		properties.setProperty("direct.api.proxy.uri", "http://proxy.example.org:3128");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create(TEST_ENDPOINT), configuration.getApiEndpoint());
		Assert.assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
		Assert.assertEquals(20000, configuration.getConnectTimeout());
		Assert.assertEquals(10000, configuration.getSocketTimeout());
		Assert.assertEquals(CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, configuration.getMaxConnections());
		Assert.assertNull(configuration.getApiKeyId());
		Assert.assertNull(configuration.getSecretApiKey());

		Assert.assertNotNull(configuration.getProxyConfiguration());
		ProxyConfiguration proxyConfiguration = configuration.getProxyConfiguration();
		Assert.assertEquals("http", proxyConfiguration.getScheme());
		Assert.assertEquals("proxy.example.org", proxyConfiguration.getHost());
		Assert.assertEquals(3128, proxyConfiguration.getPort());
		Assert.assertNull(proxyConfiguration.getUsername());
		Assert.assertNull(proxyConfiguration.getPassword());
	}

	@Test
	public void testConstructFromPropertiesWithProxyWithAuthentication() {

		Properties properties = new Properties();
		properties.setProperty("direct.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("direct.api.authorizationType", "V1HMAC");
		properties.setProperty("direct.api.connectTimeout", "20000");
		properties.setProperty("direct.api.socketTimeout", "10000");
		properties.setProperty("direct.api.proxy.uri", "http://proxy.example.org:3128");
		properties.setProperty("direct.api.proxy.username", "direct-username");
		properties.setProperty("direct.api.proxy.password", "direct-password");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create(TEST_ENDPOINT), configuration.getApiEndpoint());
		Assert.assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
		Assert.assertEquals(20000, configuration.getConnectTimeout());
		Assert.assertEquals(10000, configuration.getSocketTimeout());
		Assert.assertEquals(CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, configuration.getMaxConnections());
		Assert.assertNull(configuration.getApiKeyId());
		Assert.assertNull(configuration.getSecretApiKey());

		Assert.assertNotNull(configuration.getProxyConfiguration());
		ProxyConfiguration proxyConfiguration = configuration.getProxyConfiguration();
		Assert.assertEquals("http", proxyConfiguration.getScheme());
		Assert.assertEquals("proxy.example.org", proxyConfiguration.getHost());
		Assert.assertEquals(3128, proxyConfiguration.getPort());
		Assert.assertEquals("direct-username", proxyConfiguration.getUsername());
		Assert.assertEquals("direct-password", proxyConfiguration.getPassword());
	}

	@Test
	public void testConstructFromPropertiesWithMaxConnections() {

		Properties properties = new Properties();
		properties.setProperty("direct.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("direct.api.authorizationType", "V1HMAC");
		properties.setProperty("direct.api.connectTimeout", "20000");
		properties.setProperty("direct.api.socketTimeout", "10000");
		properties.setProperty("direct.api.maxConnections", "100");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create(TEST_ENDPOINT), configuration.getApiEndpoint());
		Assert.assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
		Assert.assertEquals(20000, configuration.getConnectTimeout());
		Assert.assertEquals(10000, configuration.getSocketTimeout());
		Assert.assertEquals(100, configuration.getMaxConnections());
		Assert.assertNull(configuration.getApiKeyId());
		Assert.assertNull(configuration.getSecretApiKey());
		Assert.assertNull(configuration.getProxyConfiguration());
	}

	@Test
	public void testConstructFromPropertiesWithHost() {

		Properties properties = new Properties();
		properties.setProperty("direct.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("direct.api.authorizationType", "V1HMAC");
		properties.setProperty("direct.api.connectTimeout", "20000");
		properties.setProperty("direct.api.socketTimeout", "10000");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create(TEST_ENDPOINT), configuration.getApiEndpoint());
	}

	@Test
	public void testConstructFromPropertiesWithHostAndScheme() {

		Properties properties = new Properties();
		properties.setProperty("direct.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("direct.api.endpoint.scheme", "http");
		properties.setProperty("direct.api.authorizationType", "V1HMAC");
		properties.setProperty("direct.api.connectTimeout", "20000");
		properties.setProperty("direct.api.socketTimeout", "10000");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create("http://" + TEST_ENDPOINT_HOST), configuration.getApiEndpoint());
	}

	@Test
	public void testConstructFromPropertiesWithHostAndPort() {

		Properties properties = new Properties();
		properties.setProperty("direct.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("direct.api.endpoint.port", "8443");
		properties.setProperty("direct.api.authorizationType", "V1HMAC");
		properties.setProperty("direct.api.connectTimeout", "20000");
		properties.setProperty("direct.api.socketTimeout", "10000");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create(TEST_ENDPOINT + ":8443"), configuration.getApiEndpoint());
	}

	@Test
	public void testConstructFromPropertiesWithHostSchemeAndPort() {

		Properties properties = new Properties();
		properties.setProperty("direct.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("direct.api.endpoint.scheme", "http");
		properties.setProperty("direct.api.endpoint.port", "8080");
		properties.setProperty("direct.api.authorizationType", "V1HMAC");
		properties.setProperty("direct.api.connectTimeout", "20000");
		properties.setProperty("direct.api.socketTimeout", "10000");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create("http://" + TEST_ENDPOINT_HOST + ":8080"), configuration.getApiEndpoint());
	}

	@Test
	public void testConstructFromPropertiesWithIPv6Host() {

		Properties properties = new Properties();
		properties.setProperty("direct.api.endpoint.host", "::1");
		properties.setProperty("direct.api.authorizationType", "V1HMAC");
		properties.setProperty("direct.api.connectTimeout", "20000");
		properties.setProperty("direct.api.socketTimeout", "10000");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create("https://[::1]"), configuration.getApiEndpoint());
	}

	@Test
	public void testConstructFromPropertiesWithHttpsProtocols() {

		Properties properties = new Properties();
		properties.setProperty("direct.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("direct.api.authorizationType", "V1HMAC");
		properties.setProperty("direct.api.connectTimeout", "20000");
		properties.setProperty("direct.api.socketTimeout", "10000");
		properties.setProperty("direct.api.https.protocols", "TLSv1, TLSv1.1, TLSv1.2");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create(TEST_ENDPOINT), configuration.getApiEndpoint());
		Assert.assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
		Assert.assertEquals(20000, configuration.getConnectTimeout());
		Assert.assertEquals(10000, configuration.getSocketTimeout());
		Assert.assertEquals(CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, configuration.getMaxConnections());
		Assert.assertNull(configuration.getApiKeyId());
		Assert.assertNull(configuration.getSecretApiKey());
		Assert.assertNull(configuration.getProxyConfiguration());
		Assert.assertEquals(new HashSet<String>(Arrays.asList("TLSv1", "TLSv1.1", "TLSv1.2")), configuration.getHttpsProtocols());
		Assert.assertNull(configuration.getIntegrator());
		Assert.assertNull(configuration.getShoppingCartExtension());
	}

	@Test
	public void testConstructFromPropertiesWithMetaData() {

		Properties properties = new Properties();
		properties.setProperty("direct.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("direct.api.authorizationType", "V1HMAC");
		properties.setProperty("direct.api.connectTimeout", "20000");
		properties.setProperty("direct.api.socketTimeout", "10000");
		properties.setProperty("direct.api.integrator", "Ingenico.Integrator");
		properties.setProperty("direct.api.shoppingCartExtension.creator", "Ingenico.Creator");
		properties.setProperty("direct.api.shoppingCartExtension.name", "Ingenico.ShoppingCarts");
		properties.setProperty("direct.api.shoppingCartExtension.version", "1.0");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create(TEST_ENDPOINT), configuration.getApiEndpoint());
		Assert.assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
		Assert.assertEquals(20000, configuration.getConnectTimeout());
		Assert.assertEquals(10000, configuration.getSocketTimeout());
		Assert.assertEquals(CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, configuration.getMaxConnections());
		Assert.assertNull(configuration.getApiKeyId());
		Assert.assertNull(configuration.getSecretApiKey());
		Assert.assertNull(configuration.getProxyConfiguration());
		Assert.assertEquals("Ingenico.Integrator", configuration.getIntegrator());
		Assert.assertNotNull(configuration.getShoppingCartExtension());
		Assert.assertEquals("Ingenico.Creator", configuration.getShoppingCartExtension().getCreator());
		Assert.assertEquals("Ingenico.ShoppingCarts", configuration.getShoppingCartExtension().getName());
		Assert.assertEquals("1.0", configuration.getShoppingCartExtension().getVersion());
	}
}
