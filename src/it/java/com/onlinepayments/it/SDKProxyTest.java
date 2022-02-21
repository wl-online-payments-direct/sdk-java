package com.onlinepayments.it;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.junit.Assert;
import org.junit.Test;

import com.onlinepayments.ApiResource;
import com.onlinepayments.Client;
import com.onlinepayments.Communicator;
import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.ProxyConfiguration;
import com.onlinepayments.defaultimpl.DefaultCommunicator;
import com.onlinepayments.defaultimpl.DefaultConnection;
import com.onlinepayments.domain.TestConnection;
import com.onlinepayments.merchant.services.ServicesClient;

public class SDKProxyTest extends ItTest {

	/**
	 * Smoke test for using a proxy configured through SDK properties.
	 */
	@Test
	public void test() throws URISyntaxException, IOException {

		Client client = getClientWithProxy();
		try {
			ServicesClient services = client.merchant(MERCHANT_ID).services();

			CommunicatorConfiguration configuration = getCommunicatorConfigurationWithProxy();
			Assert.assertNotNull(configuration.getProxyConfiguration());
			assertProxySet(services, configuration.getProxyConfiguration());

			TestConnection response = services.testConnection();

			Assert.assertNotNull(response.getResult());

		} finally {
			client.close();
		}
	}

	@SuppressWarnings("resource")
	private void assertProxySet(ApiResource resource, ProxyConfiguration proxyConfiguration) {
		Communicator communicator = getField(resource, "communicator", DefaultCommunicator.class);
		DefaultConnection connection = getField(communicator, "connection", DefaultConnection.class);
		CloseableHttpClient httpClient = getField(connection, "httpClient", CloseableHttpClient.class);
		DefaultProxyRoutePlanner routePlanner = getField(httpClient, "routePlanner", DefaultProxyRoutePlanner.class);
		HttpHost proxy = getField(routePlanner, "proxy", HttpHost.class);
		Assert.assertEquals(proxyConfiguration.getScheme(), proxy.getSchemeName());
		Assert.assertEquals(proxyConfiguration.getPort(), proxy.getPort());

		BasicCredentialsProvider credentialsProvider = getField(httpClient, "credentialsProvider", BasicCredentialsProvider.class);
		AuthScope authScope = new AuthScope(proxy);
		Credentials credentials = credentialsProvider.getCredentials(authScope);
		Assert.assertTrue(credentials instanceof UsernamePasswordCredentials);
		UsernamePasswordCredentials usernamePasswordCredentials = (UsernamePasswordCredentials) credentials;
		Assert.assertEquals(proxyConfiguration.getUsername(), usernamePasswordCredentials.getUserName());
		Assert.assertEquals(proxyConfiguration.getPassword(), usernamePasswordCredentials.getPassword());
	}

	private <T> T getField(Object object, String fieldName, Class<T> fieldType) {
		Class<?> clazz = object.getClass();
		while (clazz != Object.class) {
			try {
				Field field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				Object fieldValue = field.get(object);
				Assert.assertTrue(fieldType.isInstance(fieldValue));
				return fieldType.cast(fieldValue);
			} catch (@SuppressWarnings("unused") NoSuchFieldException e) {
				// try next class
			} catch (IllegalAccessException e) {
				// should no longer occur
				throw new RuntimeException(e);
			}

			clazz = clazz.getSuperclass();
		}

		return null;
	}
}
