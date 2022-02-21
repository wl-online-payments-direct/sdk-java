package com.onlinepayments.it;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import com.onlinepayments.ClientInterface;
import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.Factory;
import com.onlinepayments.domain.TestConnection;

public class SystemProxyTest extends ItTest {

	private boolean setHttpProxy;
	private boolean setHttpsProxy;
	private boolean setHttpsProxyPort;
	private boolean setHttpProxyUser;
	private boolean setHttpProxyPass;

	@Before
	public void setup() throws URISyntaxException {
		setHttpProxy = setupProxyHost("http");
		setHttpsProxy = setupProxyHost("https");

		if (getProperty("http.proxyUser") == null) {
			String proxyUsername = getProperty("onlinePayments.api.proxy.username");
			if (proxyUsername != null) {
				System.setProperty("http.proxyUser", proxyUsername);
				setHttpProxyUser = true;
			}
		}
		if (getProperty("http.proxyPass") == null) {
			String proxyPassword = getProperty("onlinePayments.api.proxy.password");
			if (proxyPassword != null) {
				System.setProperty("http.proxyPass", proxyPassword);
				setHttpProxyPass = true;
			}
		}
	}

	private boolean setupProxyHost(String prefix) throws URISyntaxException {
		String proxyHostProperty = prefix + ".proxyHost";
		String proxyPortProperty = prefix + ".proxyPort";

		String proxyHost = getProperty(proxyHostProperty);
		String proxyPort = getProperty(proxyPortProperty);

		if (proxyHost != null && proxyPort != null) {
			// did not setup the proxy host
			return false;
		}
		String proxyUriProperty = "onlinePayments.api.proxy.uri";
		String proxyURIString = getProperty(proxyUriProperty);
		Assume.assumeTrue("System properties '" + proxyHostProperty + "' and '" + proxyPortProperty + "' or system property '" + proxyUriProperty + "' must be set for this test to run.",
		                  proxyURIString != null);
		URI proxyURI = new URI(proxyURIString);
		System.setProperty(proxyHostProperty, proxyURI.getHost());
		System.setProperty(proxyPortProperty, Integer.toString(proxyURI.getPort()));

		return true;
	}

	@After
	public void cleanup() {
		if (setHttpProxy) {
			System.clearProperty("http.proxyHost");
			System.clearProperty("http.proxyPort");
		}
		if (setHttpsProxy) {
			System.clearProperty("https.proxyHost");
			System.clearProperty("https.proxyPort");
		}
		if (setHttpProxyUser) {
			System.clearProperty("http.proxyUser");
		}
		if (setHttpProxyPass) {
			System.clearProperty("http.proxyPass");
		}
	}

	/**
	 * Smoke test for using a proxy configured through system properties.
	 */
	@Test
	public void test() throws URISyntaxException, IOException {

		final boolean[] authenticationCalled = {false};

		final String username = getProperty("http.proxyUser");
		final String password = getProperty("http.proxyPass");

		Authenticator.setDefault(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				authenticationCalled[0] = true;

				return new PasswordAuthentication(username, password.toCharArray());
			}
		});

		CommunicatorConfiguration configuration = getCommunicatorConfiguration()
				.withProxyConfiguration(null);

		ClientInterface client = Factory.createClient(configuration);
		try {
			TestConnection response = client.merchant(MERCHANT_ID).services().testConnection();

			Assert.assertNotNull(response.getResult());

		} finally {
			client.close();
		}

		// for https, authentication may not be required
		if ("http".equalsIgnoreCase(configuration.getApiEndpoint().getScheme())) {
			Assert.assertTrue("getPasswordAuthentication() should have been called", authenticationCalled[0]);
		}
	}
}
