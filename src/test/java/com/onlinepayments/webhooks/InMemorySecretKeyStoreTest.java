package com.onlinepayments.webhooks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InMemorySecretKeyStoreTest {

    @AfterEach
    void tearDown() {
        // Clear the singleton store after each test to avoid state leakage
        InMemorySecretKeyStore.INSTANCE.clear();
    }

    @Nested
    class WhenAccessingSingleton {

        @Test
        void shouldReturnNonNullInstance() {
            assertNotNull(InMemorySecretKeyStore.INSTANCE);
        }

        @Test
        void shouldReturnSameInstanceOnMultipleAccess() {
            InMemorySecretKeyStore instance1 = InMemorySecretKeyStore.INSTANCE;
            InMemorySecretKeyStore instance2 = InMemorySecretKeyStore.INSTANCE;

            assertEquals(instance1, instance2);
        }
    }

    @Nested
    class WhenStoringSecretKey {

        @Test
        void shouldStoreValidKeyAndValue() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;

            store.storeSecretKey("key-id-1", "secret-value-1");

            assertEquals("secret-value-1", store.getSecretKey("key-id-1"));
        }

        @Test
        void shouldThrowExceptionWhenKeyIdIsNull() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;

            assertThrows(IllegalArgumentException.class, () -> store.storeSecretKey(null, "secret-value"));
        }

        @Test
        void shouldThrowExceptionWhenKeyIdIsEmpty() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;

            assertThrows(IllegalArgumentException.class, () -> store.storeSecretKey("", "secret-value"));
        }

        @Test
        void shouldThrowExceptionWhenKeyIdIsWhitespace() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;

            assertThrows(IllegalArgumentException.class, () -> store.storeSecretKey("   ", "secret-value"));
        }

        @Test
        void shouldThrowExceptionWhenSecretKeyIsNull() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;

            assertThrows(IllegalArgumentException.class, () -> store.storeSecretKey("key-id", null));
        }

        @Test
        void shouldThrowExceptionWhenSecretKeyIsEmpty() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;

            assertThrows(IllegalArgumentException.class, () -> store.storeSecretKey("key-id", ""));
        }

        @Test
        void shouldThrowExceptionWhenSecretKeyIsWhitespace() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;

            assertThrows(IllegalArgumentException.class, () -> store.storeSecretKey("key-id", "   "));
        }

        @Test
        void shouldUpdateExistingKey() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;

            store.storeSecretKey("key-id", "secret-1");
            store.storeSecretKey("key-id", "secret-2");

            assertEquals("secret-2", store.getSecretKey("key-id"));
        }
    }

    @Nested
    class WhenGettingSecretKey {

        @Test
        void shouldReturnExistingKey() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;
            store.storeSecretKey("test-key", "test-secret");

            String secretKey = store.getSecretKey("test-key");

            assertEquals("test-secret", secretKey);
        }

        @Test
        void shouldThrowExceptionWhenKeyNotFound() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;

            assertThrows(SecretKeyNotAvailableException.class, () -> store.getSecretKey("non-existent-key"));
        }

        @Test
        void shouldThrowExceptionWithCorrectKeyId() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;
            String missingKeyId = "missing-key";

            SecretKeyNotAvailableException exception = assertThrows(
                    SecretKeyNotAvailableException.class,
                    () -> store.getSecretKey(missingKeyId));

            assertEquals(missingKeyId, exception.getKeyId());
        }

        @Test
        void shouldThrowExceptionWithCorrectMessage() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;
            String missingKeyId = "missing-key";

            SecretKeyNotAvailableException exception = assertThrows(
                    SecretKeyNotAvailableException.class,
                    () -> store.getSecretKey(missingKeyId));

            assertTrue(exception.getMessage().contains("missing-key"));
        }
    }

    @Nested
    class WhenRemovingSecretKey {

        @Test
        void shouldRemoveExistingKey() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;
            store.storeSecretKey("key-to-remove", "secret");

            store.removeSecretKey("key-to-remove");

            assertThrows(SecretKeyNotAvailableException.class, () -> store.getSecretKey("key-to-remove"));
        }

        @Test
        void shouldNotThrowWhenRemovingNonExistentKey() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;

            // Should not throw exception
            store.removeSecretKey("non-existent-key");
        }

        @Test
        void shouldNotAffectOtherKeys() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;
            store.storeSecretKey("key-1", "secret-1");
            store.storeSecretKey("key-2", "secret-2");

            store.removeSecretKey("key-1");

            assertFalse(store.getSecretKey("key-2").isEmpty());
            assertEquals("secret-2", store.getSecretKey("key-2"));
        }
    }

    @Nested
    class WhenClearingStore {

        @Test
        void shouldRemoveAllKeys() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;
            store.storeSecretKey("key-1", "secret-1");
            store.storeSecretKey("key-2", "secret-2");
            store.storeSecretKey("key-3", "secret-3");

            store.clear();

            assertThrows(SecretKeyNotAvailableException.class, () -> store.getSecretKey("key-1"));
            assertThrows(SecretKeyNotAvailableException.class, () -> store.getSecretKey("key-2"));
            assertThrows(SecretKeyNotAvailableException.class, () -> store.getSecretKey("key-3"));
        }

        @Test
        void shouldAllowStoringNewKeysAfterClear() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;
            store.storeSecretKey("old-key", "old-secret");

            store.clear();
            store.storeSecretKey("new-key", "new-secret");

            assertEquals("new-secret", store.getSecretKey("new-key"));
        }
    }

    @Nested
    class WhenWorkingWithMultipleKeys {

        @Test
        void shouldStoreAndRetrieveMultipleKeys() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;

            store.storeSecretKey("key-1", "secret-1");
            store.storeSecretKey("key-2", "secret-2");
            store.storeSecretKey("key-3", "secret-3");

            assertEquals("secret-1", store.getSecretKey("key-1"));
            assertEquals("secret-2", store.getSecretKey("key-2"));
            assertEquals("secret-3", store.getSecretKey("key-3"));
        }

        @Test
        void shouldMaintainSeparateKeysIndependently() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;

            store.storeSecretKey("api-key-1", "api-secret-1");
            store.storeSecretKey("api-key-2", "api-secret-2");

            store.removeSecretKey("api-key-1");

            assertEquals("api-secret-2", store.getSecretKey("api-key-2"));
            assertThrows(SecretKeyNotAvailableException.class, () -> store.getSecretKey("api-key-1"));
        }

        @Test
        void shouldHandleSpecialCharactersInValues() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;
            String specialSecret = "secret!@#$%^&*()_+-=[]{}|;':\",./<>?";

            store.storeSecretKey("special-key", specialSecret);

            assertEquals(specialSecret, store.getSecretKey("special-key"));
        }

        @Test
        void shouldHandleLongSecretValues() {
            InMemorySecretKeyStore store = InMemorySecretKeyStore.INSTANCE;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10000; i++) {
                sb.append("a");
            }
            String longSecret = sb.toString();

            store.storeSecretKey("long-key", longSecret);

            assertEquals(longSecret, store.getSecretKey("long-key"));
        }
    }
}
