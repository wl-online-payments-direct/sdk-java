package com.onlinepayments.it;

import static org.junit.jupiter.api.Assumptions.assumeFalse;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.onlinepayments.ClientInterface;
import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.Factory;
import com.onlinepayments.ProxyConfiguration;

abstract class ItTest {

    private static final String PROPERTIES_URL = "/itconfiguration.properties";
    private static final String API_KEY_ID;
    private static final String SECRET_API_KEY;
    private static final String MERCHANT_ID;

    static {
        API_KEY_ID = System.getProperty("onlinePayments.api.apiKeyId");
        SECRET_API_KEY = System.getProperty("onlinePayments.api.secretApiKey");
        if (API_KEY_ID == null || SECRET_API_KEY == null) {
            throw new IllegalStateException("System properties 'onlinePayments.api.apiKeyId' and 'onlinePayments.api.secretApiKey' must be set.");
        }
        MERCHANT_ID = System.getProperty("onlinePayments.api.merchantId");
        if (MERCHANT_ID == null) {
            throw new IllegalStateException("System properties 'onlinePayments.api.merchantId' must be set.");
        }
    }

    private CommunicatorConfiguration getCommunicatorConfiguration(URL propertiesUrl) throws URISyntaxException {
        CommunicatorConfiguration configuration = Factory.createConfiguration(propertiesUrl.toURI(), API_KEY_ID, SECRET_API_KEY);

        String host = System.getProperty("onlinePayments.api.endpoint.host");
        if (host != null) {
            String scheme = System.getProperty("onlinePayments.api.endpoint.scheme", "https");
            int port = Integer.parseInt(System.getProperty("onlinePayments.api.endpoint.port", "-1"));
            URI apiEndpoint = new URI(scheme, null, host, port, null, null, null);
            configuration = configuration.withApiEndpoint(apiEndpoint);
        }

        String httpsProtocols = System.getProperty("onlinePayments.api.https.protocols");
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
        String proxyURI = System.getProperty("onlinePayments.api.proxy.uri");
        String proxyUsername = System.getProperty("onlinePayments.api.proxy.username");
        String proxyPassword = System.getProperty("onlinePayments.api.proxy.password");
        assumeFalse(proxyURI == null, "System property 'onlinePayments.api.proxy.uri' must be set");

        return getCommunicatorConfiguration()
                .withProxyConfiguration(new ProxyConfiguration(new URI(proxyURI), proxyUsername, proxyPassword));
    }

    @SuppressWarnings("resource")
    protected ClientInterface getClient() throws URISyntaxException {
        URL propertiesUrl = getClass().getResource(PROPERTIES_URL);
        CommunicatorConfiguration configuration = getCommunicatorConfiguration(propertiesUrl);
        return Factory
                .createClient(configuration)
                .withClientMetaInfo("{\"test\":\"test\"}");
    }

    @SuppressWarnings("resource")
    protected ClientInterface getClientWithProxy() throws URISyntaxException {
        CommunicatorConfiguration configuration = getCommunicatorConfigurationWithProxy();
        return Factory
                .createClient(configuration)
                .withClientMetaInfo("{\"test\":\"test\"}");
    }

    @SuppressWarnings("resource")
    protected ClientInterface getClientWithoutConnectionReuse() throws URISyntaxException {
        URL propertiesUrl = getClass().getResource(PROPERTIES_URL);
        CommunicatorConfiguration configuration = getCommunicatorConfiguration(propertiesUrl);
        configuration.setConnectionReuse(false);
        return Factory
                .createClient(configuration)
                .withClientMetaInfo("{\"test\":\"test\"}");
    }

    protected static String getMerchantId() {
        return MERCHANT_ID;
    }
}
