package com.onlinepayments.it;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.onlinepayments.ClientInterface;
import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.Factory;
import com.onlinepayments.domain.TestConnection;

class SystemProxyTest extends ItTest {

    private boolean setHttpProxyHost;
    private boolean setHttpProxyPort;
    private boolean setHttpsProxyHost;
    private boolean setHttpsProxyPort;
    private boolean setHttpProxyUser;
    private boolean setHttpProxyPass;

    @BeforeEach
    void setup() throws URISyntaxException {
        if (setupProxyHost("http")) {
            setHttpProxyHost = true;
            setHttpProxyPort = true;
        }
        if (setupProxyHost("https")) {
            setHttpsProxyHost = true;
            setHttpsProxyPort = true;
        }

        if (System.getProperty("http.proxyUser") == null) {
            String proxyUsername = System.getProperty("onlinePayments.api.proxy.username");
            if (proxyUsername != null) {
                System.setProperty("http.proxyUser", proxyUsername);
                setHttpProxyUser = true;
            }
        }
        if (System.getProperty("http.proxyPass") == null) {
            String proxyPassword = System.getProperty("onlinePayments.api.proxy.password");
            if (proxyPassword != null) {
                System.setProperty("http.proxyPass", proxyPassword);
                setHttpProxyPass = true;
            }
        }
    }

    private boolean setupProxyHost(String prefix) throws URISyntaxException {
        String proxyHostProperty = prefix + ".proxyHost";
        String proxyPortProperty = prefix + ".proxyPort";

        String proxyHost = System.getProperty(proxyPortProperty);
        String proxyPort = System.getProperty(proxyPortProperty);

        if (proxyHost == null && proxyPort == null) {
            String proxyURIString = System.getProperty("onlinePayments.api.proxy.uri");
            assumeFalse(proxyURIString == null, "Either system properties '" + proxyHostProperty + "' and '" + proxyPortProperty + "' must be set," + " or system property onlinePayments.api.proxy.uri must be set");

            URI proxyURI = new URI(proxyURIString);
            System.setProperty(proxyHostProperty, proxyURI.getHost());
            System.setProperty(proxyPortProperty, Integer.toString(proxyURI.getPort()));

            return true;
        }
        if (proxyHost == null || proxyPort == null) {
            throw new IllegalStateException("Either system properties '" + proxyHostProperty + "' and '" + proxyPortProperty + "' must both be set," + " or neither must be set");
        }

        return false;
    }

    @AfterEach
    void cleanup() {
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
    void test() throws URISyntaxException, IOException {

        final boolean[] authenticationCalled = {false};

        final String username = System.getProperty("http.proxyUser");
        final String password = System.getProperty("http.proxyPass");

        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                authenticationCalled[0] = true;

                return new PasswordAuthentication(username, password.toCharArray());
            }
        });

        CommunicatorConfiguration configuration = getCommunicatorConfiguration().withProxyConfiguration(null);

        try (ClientInterface client = Factory.createClient(configuration)) {
            TestConnection response = client.merchant(getMerchantId()).services().testConnection();

            assertNotNull(response.getResult());
        }

        // for https, authentication may not be required
        if ("http".equalsIgnoreCase(configuration.getApiEndpoint().getScheme())) {
            assertTrue(authenticationCalled[0], "getPasswordAuthentication() should have been called");
        }
    }
}
