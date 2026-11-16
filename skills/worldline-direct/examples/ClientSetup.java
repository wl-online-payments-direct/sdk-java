package examples;

import java.net.URI;
import java.net.URISyntaxException;

import com.onlinepayments.ClientInterface;
import com.onlinepayments.CommunicatorConfiguration;
import com.onlinepayments.Factory;
import com.onlinepayments.authentication.AuthorizationType;
import com.onlinepayments.merchant.MerchantClientInterface;

public final class ClientSetup {

    private ClientSetup() {
    }

    // [START client-setup]
    // Read and validate every setting once at startup: a missing value then stops the application with a clear
    // message instead of failing on the first payment. Take the values from your configuration or secret store.
    // Environment variables are fine for local development when they are set outside the repository; never put
    // the API secret in code or in a file that is committed.
    //
    // Create one client when the application starts (e.g. a Spring @Bean) and reuse it for every request.
    // The client is thread-safe and holds the HTTP connection pool. Close it when the application stops.
    public static ClientInterface createClient() {
        CommunicatorConfiguration configuration = new CommunicatorConfiguration()
                // Test or live endpoint, e.g. https://payment.direct.ecom.preprod.worldline-solutions.com
                .withApiEndpoint(URI.create(requireAbsoluteUrl("ONLINEPAYMENTS_API_ENDPOINT")))
                .withApiKeyId(requireEnv("ONLINEPAYMENTS_API_KEY_ID"))
                .withSecretApiKey(requireEnv("ONLINEPAYMENTS_API_SECRET"))
                // Required: without it Factory.createClient fails with "Unknown authorizationType".
                .withAuthorizationType(AuthorizationType.V1HMAC)
                // Timeouts in milliseconds; the defaults are 0, which means no timeout.
                .withConnectTimeout(5000)
                .withSocketTimeout(300000)
                // Your company or application name; it identifies your requests in the platform logs.
                // Mandatory: Factory.createClient throws IllegalArgumentException when it is null or blank.
                .withIntegrator(requireEnv("ONLINEPAYMENTS_INTEGRATOR"));
        return Factory.createClient(configuration);
    }

    // The merchant ID is your PSPID. Every API call goes through the merchant client.
    public static MerchantClientInterface createMerchantClient(ClientInterface client) {
        return client.merchant(requireEnv("ONLINEPAYMENTS_MERCHANT_ID"));
    }

    // The absolute public base URL of your shop, e.g. https://shop.example. The return URL is built from it,
    // never from the Host header of a request, which the sender controls.
    public static String createPublicBaseUrl() {
        return requireAbsoluteUrl("SHOP_PUBLIC_BASE_URL");
    }

    static String requireEnv(String name) {
        String value = System.getenv(name);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalStateException("Missing setting " + name);
        }
        return value.trim();
    }

    static String requireAbsoluteUrl(String name) {
        String value = requireEnv(name);
        URI uri;
        try {
            uri = new URI(value);
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Setting " + name + " is not a valid URL");
        }
        boolean httpUrl = "https".equals(uri.getScheme()) || "http".equals(uri.getScheme());
        if (!httpUrl || uri.getHost() == null) {
            throw new IllegalStateException("Setting " + name + " must be an absolute http(s) URL, e.g. https://shop.example");
        }
        return value;
    }
    // [END client-setup]
}
