package com.onlinepayments;

import java.net.URI;
import java.net.URISyntaxException;

final class TestConstants {

    public static final URI PROPERTIES_URI = toUri("configuration.v1hmac.properties");
    public static final URI INVALID_PROPERTIES_URI = toUri("configuration.invalid-endpoint.properties");
    public static final String AUTH_ID = "apiKeyId";
    public static final String AUTH_SECRET = "secretApiKey";

    private TestConstants() {
    }

    private static URI toUri(String resourceName) {
        try {
            return TestConstants.class.getResource(resourceName).toURI();
        } catch (URISyntaxException e) {
            InstantiationError error = new InstantiationError(e.getMessage());
            error.initCause(e);
            throw error;
        }
    }
}
