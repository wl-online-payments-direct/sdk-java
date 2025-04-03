package com.onlinepayments.webhooks;

/**
 * A store of secret keys. Implementations could store secret keys in a database, on disk, etc.
 * Thread-safe.
 */
public interface SecretKeyStore {

    /**
     * @return The secret key for the given key id. Never {@code null}.
     * @throws SecretKeyNotAvailableException If the secret key for the given key id is not available.
     */
    String getSecretKey(String keyId);
}
