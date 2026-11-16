package examples;

import com.onlinepayments.json.DefaultMarshaller;
import com.onlinepayments.webhooks.InMemorySecretKeyStore;
import com.onlinepayments.webhooks.WebhooksHelper;

public final class WebhooksSetup {

    private WebhooksSetup() {
    }

    // [START webhooks-setup]
    // Create the helper once at startup. The key ID and secret come from the Merchant Portal
    // (Developer > Webhooks). Treat the secret like the API secret: configuration or a secret store, never code or
    // a committed file. Validate both at startup so that a missing value stops the application with a clear message.
    // In production, implement SecretKeyStore on top of your secret storage; storeSecretKey overwrites an existing key ID.
    public static WebhooksHelper createHelper() {
        InMemorySecretKeyStore.INSTANCE.storeSecretKey(
                requireEnv("ONLINEPAYMENTS_WEBHOOK_KEY_ID"),
                requireEnv("ONLINEPAYMENTS_WEBHOOK_SECRET"));
        return new WebhooksHelper(DefaultMarshaller.INSTANCE, InMemorySecretKeyStore.INSTANCE);
    }

    private static String requireEnv(String name) {
        String value = System.getenv(name);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalStateException("Missing setting " + name);
        }
        return value.trim();
    }
    // [END webhooks-setup]
}
