package com.onlinepayments;

import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

import com.onlinepayments.defaultimpl.AuthorizationType;

public class CommunicatorConfigurationTest {

	private static final String TEST_ENDPOINT_HOST = "payment.preprod.online-payments.com";
	private static final String TEST_ENDPOINT = "https://" + TEST_ENDPOINT_HOST;

	@Test
	public void testConstructFromPropertiesWithoutProxy() {

		Properties properties = new Properties();
		properties.setProperty("onlinePayments.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
		properties.setProperty("onlinePayments.api.connectTimeout", "20000");
		properties.setProperty("onlinePayments.api.socketTimeout", "10000");

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
		properties.setProperty("onlinePayments.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
		properties.setProperty("onlinePayments.api.connectTimeout", "20000");
		properties.setProperty("onlinePayments.api.socketTimeout", "10000");
		properties.setProperty("onlinePayments.api.proxy.uri", "http://proxy.example.org:3128");

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
		properties.setProperty("onlinePayments.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
		properties.setProperty("onlinePayments.api.connectTimeout", "20000");
		properties.setProperty("onlinePayments.api.socketTimeout", "10000");
		properties.setProperty("onlinePayments.api.proxy.uri", "http://proxy.example.org:3128");
		properties.setProperty("onlinePayments.api.proxy.username", "username");
		properties.setProperty("onlinePayments.api.proxy.password", "password");

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
		Assert.assertEquals("username", proxyConfiguration.getUsername());
		Assert.assertEquals("password", proxyConfiguration.getPassword());
	}

	@Test
	public void testConstructFromPropertiesWithMaxConnections() {

		Properties properties = new Properties();
		properties.setProperty("onlinePayments.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
		properties.setProperty("onlinePayments.api.connectTimeout", "20000");
		properties.setProperty("onlinePayments.api.socketTimeout", "10000");
		properties.setProperty("onlinePayments.api.maxConnections", "100");

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
		properties.setProperty("onlinePayments.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
		properties.setProperty("onlinePayments.api.connectTimeout", "20000");
		properties.setProperty("onlinePayments.api.socketTimeout", "10000");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create(TEST_ENDPOINT), configuration.getApiEndpoint());
	}

	@Test
	public void testConstructFromPropertiesWithHostAndScheme() {

		Properties properties = new Properties();
		properties.setProperty("onlinePayments.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("onlinePayments.api.endpoint.scheme", "http");
		properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
		properties.setProperty("onlinePayments.api.connectTimeout", "20000");
		properties.setProperty("onlinePayments.api.socketTimeout", "10000");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create("http://" + TEST_ENDPOINT_HOST), configuration.getApiEndpoint());
	}

	@Test
	public void testConstructFromPropertiesWithHostAndPort() {

		Properties properties = new Properties();
		properties.setProperty("onlinePayments.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("onlinePayments.api.endpoint.port", "8443");
		properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
		properties.setProperty("onlinePayments.api.connectTimeout", "20000");
		properties.setProperty("onlinePayments.api.socketTimeout", "10000");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create(TEST_ENDPOINT + ":8443"), configuration.getApiEndpoint());
	}

	@Test
	public void testConstructFromPropertiesWithHostSchemeAndPort() {

		Properties properties = new Properties();
		properties.setProperty("onlinePayments.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("onlinePayments.api.endpoint.scheme", "http");
		properties.setProperty("onlinePayments.api.endpoint.port", "8080");
		properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
		properties.setProperty("onlinePayments.api.connectTimeout", "20000");
		properties.setProperty("onlinePayments.api.socketTimeout", "10000");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create("http://" + TEST_ENDPOINT_HOST + ":8080"), configuration.getApiEndpoint());
	}

	@Test
	public void testConstructFromPropertiesWithIPv6Host() {

		Properties properties = new Properties();
		properties.setProperty("onlinePayments.api.endpoint.host", "::1");
		properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
		properties.setProperty("onlinePayments.api.connectTimeout", "20000");
		properties.setProperty("onlinePayments.api.socketTimeout", "10000");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create("https://[::1]"), configuration.getApiEndpoint());
	}

	@Test
	public void testConstructFromPropertiesWithHttpsProtocols() {

		Properties properties = new Properties();
		properties.setProperty("onlinePayments.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
		properties.setProperty("onlinePayments.api.connectTimeout", "20000");
		properties.setProperty("onlinePayments.api.socketTimeout", "10000");
		properties.setProperty("onlinePayments.api.https.protocols", "TLSv1, TLSv1.1, TLSv1.2");

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
		properties.setProperty("onlinePayments.api.endpoint.host", TEST_ENDPOINT_HOST);
		properties.setProperty("onlinePayments.api.authorizationType", "V1HMAC");
		properties.setProperty("onlinePayments.api.connectTimeout", "20000");
		properties.setProperty("onlinePayments.api.socketTimeout", "10000");
		properties.setProperty("onlinePayments.api.integrator", "OnlinePayments.Integrator");
		properties.setProperty("onlinePayments.api.shoppingCartExtension.creator", "OnlinePayments.Creator");
		properties.setProperty("onlinePayments.api.shoppingCartExtension.name", "OnlinePayments.ShoppingCarts");
		properties.setProperty("onlinePayments.api.shoppingCartExtension.version", "1.0");

		CommunicatorConfiguration configuration = new CommunicatorConfiguration(properties);

		Assert.assertEquals(URI.create(TEST_ENDPOINT), configuration.getApiEndpoint());
		Assert.assertEquals(AuthorizationType.V1HMAC, configuration.getAuthorizationType());
		Assert.assertEquals(20000, configuration.getConnectTimeout());
		Assert.assertEquals(10000, configuration.getSocketTimeout());
		Assert.assertEquals(CommunicatorConfiguration.DEFAULT_MAX_CONNECTIONS, configuration.getMaxConnections());
		Assert.assertNull(configuration.getApiKeyId());
		Assert.assertNull(configuration.getSecretApiKey());
		Assert.assertNull(configuration.getProxyConfiguration());
		Assert.assertEquals("OnlinePayments.Integrator", configuration.getIntegrator());
		Assert.assertNotNull(configuration.getShoppingCartExtension());
		Assert.assertEquals("OnlinePayments.Creator", configuration.getShoppingCartExtension().getCreator());
		Assert.assertEquals("OnlinePayments.ShoppingCarts", configuration.getShoppingCartExtension().getName());
		Assert.assertEquals("1.0", configuration.getShoppingCartExtension().getVersion());
	}
}
