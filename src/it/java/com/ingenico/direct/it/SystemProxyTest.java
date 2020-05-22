package com.ingenico.direct.it;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ingenico.direct.ClientInterface;
import com.ingenico.direct.CommunicatorConfiguration;
import com.ingenico.direct.Factory;
import com.ingenico.direct.domain.TestConnection;

public class SystemProxyTest extends ItTest {

	private boolean setHttpProxyHost;
	private boolean setHttpProxyPort;
	private boolean setHttpsProxyHost;
	private boolean setHttpsProxyPort;
	private boolean setHttpProxyUser;
	private boolean setHttpProxyPass;

	@Before
	public void setup() throws URISyntaxException {
		if (setupProxyHost("http")) {
			setHttpProxyHost = true;
			setHttpProxyPort = true;
		}
		if (setupProxyHost("https")) {
			setHttpsProxyHost = true;
			setHttpsProxyPort = true;
		}

		if (getProperty("http.proxyUser") == null) {
			String proxyUsername = getProperty("direct.api.proxy.username");
			if (proxyUsername != null) {
				System.setProperty("http.proxyUser", proxyUsername);
				setHttpProxyUser = true;
			}
		}
		if (getProperty("http.proxyPass") == null) {
			String proxyPassword = getProperty("direct.api.proxy.password");
			if (proxyPassword != null) {
				System.setProperty("http.proxyPass", proxyPassword);
				setHttpProxyPass = true;
			}
		}
	}

	private boolean setupProxyHost(String prefix) throws URISyntaxException {
		String proxyHostProperty = prefix + ".proxyHost";
		String proxyPortProperty = prefix + ".proxyPort";

		String proxyHost = getProperty(proxyPortProperty);
		String proxyPort = getProperty(proxyPortProperty);

		if (proxyHost == null && proxyPort == null) {
			String proxyURIString = getProperty("direct.api.proxy.uri");
			if (proxyURIString == null) {
				throw new IllegalStateException("Either system properties '" + proxyHostProperty + "' and '" + proxyPortProperty + "' must be set,"
						+ " or system property direct.api.proxy.uri must be set");
			}
			URI proxyURI = new URI(proxyURIString);
			System.setProperty(proxyHostProperty, proxyURI.getHost());
			System.setProperty(proxyPortProperty, Integer.toString(proxyURI.getPort()));

			return true;
		}
		if (proxyHost == null || proxyPort == null) {
			throw new IllegalStateException("Either system properties '" + proxyHostProperty + "' and '" + proxyPortProperty + "' must both be set,"
					+ " or neither must be set");
		}

		// did not setup the proxy host
		return false;
	}

	@After
	public void cleanup() {
		if (setHttpProxyHost) {
			System.clearProperty("http.proxyHost");
		}
		if (setHttpProxyPort) {
			System.clearProperty("http.proxyPort");
		}
		if (setHttpsProxyHost) {
			System.clearProperty("https.proxyHost");
		}
		if (setHttpsProxyPort) {
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

		final boolean[] authenticationCalled = { false };

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
