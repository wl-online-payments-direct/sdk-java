package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.webhooks.SecretKeyNotAvailableException;

class SecretKeyNotAvailableExceptionTest {

    @Nested
    class WhenConstructingWithMessageAndKeyId {

        @Test
        void shouldCreateInstanceWithMessageAndKeyId() {
            String message = "Secret key not found";
            String keyId = "api-key-123";

            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException(message, keyId);

            assertNotNull(exception);
        }

        @Test
        void shouldStoreMessageFromConstructor() {
            String message = "Secret key not found for key: api-key-123";
            String keyId = "api-key-123";

            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException(message, keyId);

            assertEquals(message, exception.getMessage());
        }

        @Test
        void shouldStoreKeyIdFromConstructor() {
            String message = "Secret key not found";
            String keyId = "api-key-123";

            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException(message, keyId);

            assertEquals(keyId, exception.getKeyId());
        }

        @Test
        void shouldBeRuntimeException() {
            String message = "Secret key not found";
            String keyId = "api-key-123";

            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException(message, keyId);

            assertInstanceOf(RuntimeException.class, exception);
        }
    }

    @Nested
    class WhenConstructingWithKeyIdAndCause {

        @Test
        void shouldCreateInstanceWithKeyIdAndCause() {
            String keyId = "api-key-456";
            Throwable cause = new Exception("Database connection failed");

            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException(keyId, cause);

            assertNotNull(exception);
        }

        @Test
        void shouldStoreCauseFromConstructor() {
            String keyId = "api-key-456";
            Exception cause = new Exception("Database connection failed");

            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException(keyId, cause);

            assertSame(cause, exception.getCause());
        }

        @Test
        void shouldStoreKeyIdFromConstructor() {
            String keyId = "api-key-456";
            Throwable cause = new Exception("Database error");

            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException(keyId, cause);

            assertEquals(keyId, exception.getKeyId());
        }

        @Test
        void shouldHaveCauseMessage() {
            String keyId = "api-key-456";
            String causeMessage = "Database error occurred";
            Throwable cause = new Exception(causeMessage);

            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException(keyId, cause);

            assertEquals(causeMessage, exception.getCause().getMessage());
        }
    }

    @Nested
    class WhenConstructingWithMessageKeyIdAndCause {

        @Test
        void shouldCreateInstanceWithAllParameters() {
            String message = "Could not retrieve secret key";
            String keyId = "api-key-789";
            Throwable cause = new RuntimeException("Connection timeout");

            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException(message, keyId, cause);

            assertNotNull(exception);
        }

        @Test
        void shouldStoreMessageFromConstructor() {
            String message = "Could not retrieve secret key for api-key-789";
            String keyId = "api-key-789";
            Throwable cause = new RuntimeException("Connection timeout");

            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException(message, keyId, cause);

            assertEquals(message, exception.getMessage());
        }

        @Test
        void shouldStoreKeyIdFromConstructor() {
            String message = "Could not retrieve secret key";
            String keyId = "api-key-789";
            Throwable cause = new RuntimeException("Connection timeout");

            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException(message, keyId, cause);

            assertEquals(keyId, exception.getKeyId());
        }

        @Test
        void shouldStoreCauseFromConstructor() {
            String message = "Could not retrieve secret key";
            String keyId = "api-key-789";
            RuntimeException cause = new RuntimeException("Connection timeout");

            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException(message, keyId, cause);

            assertSame(cause, exception.getCause());
        }

        @Test
        void shouldHaveCompleteExceptionChain() {
            String message = "Secret key unavailable";
            String keyId = "test-key";
            Exception rootCause = new Exception("Root error");

            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException(message, keyId, rootCause);

            assertEquals(message, exception.getMessage());
            assertEquals(keyId, exception.getKeyId());
            assertEquals("Root error", exception.getCause().getMessage());
        }
    }

    @Nested
    class WhenGettingKeyId {

        @Test
        void shouldReturnCorrectKeyId() {
            String keyId = "production-key-001";
            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException("Error", keyId);

            assertEquals(keyId, exception.getKeyId());
        }

        @Test
        void shouldReturnSameKeyIdStoredInConstructor() {
            String originalKeyId = "webhook-secret-xyz";
            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException("Message", originalKeyId);

            String retrievedKeyId = exception.getKeyId();

            assertEquals(originalKeyId, retrievedKeyId);
        }

        @Test
        void shouldReturnDifferentKeyIdForDifferentInstances() {
            SecretKeyNotAvailableException exception1 = new SecretKeyNotAvailableException("Error", "key-1");
            SecretKeyNotAvailableException exception2 = new SecretKeyNotAvailableException("Error", "key-2");

            assertEquals("key-1", exception1.getKeyId());
            assertEquals("key-2", exception2.getKeyId());
        }

        @Test
        void shouldReturnNullWhenKeyIdIsNull() {
            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException("Error", (String) null);

            assertNull(exception.getKeyId());
        }
    }

    @Nested
    class WhenThrowingException {

        @Test
        void shouldBeThrowableAsRuntimeException() {
            String keyId = "test-key";

            SecretKeyNotAvailableException exception = assertThrows(
                    SecretKeyNotAvailableException.class,
                    () -> {
                        throw new SecretKeyNotAvailableException("Key not found", keyId);
                    });

            assertEquals(keyId, exception.getKeyId());
        }

        @Test
        void shouldBeCatchableAsSignatureValidationException() {
            String keyId = "test-key";

            Exception exception = assertThrows(
                    Exception.class,
                    () -> {
                        throw new SecretKeyNotAvailableException("Key not found", keyId);
                    });

            assertInstanceOf(SecretKeyNotAvailableException.class, exception);
        }

        @Test
        void shouldBeCatchableAsRuntimeException() {
            String keyId = "test-key";

            RuntimeException exception = assertThrows(
                    RuntimeException.class,
                    () -> {
                        throw new SecretKeyNotAvailableException("Key not found", keyId);
                    });

            assertInstanceOf(SecretKeyNotAvailableException.class, exception);
        }
    }

    @Nested
    class WhenUsingDifferentKeyIdFormats {

        @Test
        void shouldHandleSimpleKeyIds() {
            String keyId = "key1";
            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException("Error", keyId);

            assertEquals(keyId, exception.getKeyId());
        }

        @Test
        void shouldHandleKeyIdsWithHyphens() {
            String keyId = "api-key-prod-001";
            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException("Error", keyId);

            assertEquals(keyId, exception.getKeyId());
        }

        @Test
        void shouldHandleKeyIdsWithUnderscores() {
            String keyId = "api_key_prod_001";
            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException("Error", keyId);

            assertEquals(keyId, exception.getKeyId());
        }

        @Test
        void shouldHandleKeyIdsWithNumbers() {
            String keyId = "key123456789";
            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException("Error", keyId);

            assertEquals(keyId, exception.getKeyId());
        }

        @Test
        void shouldHandleUUIDStyleKeyIds() {
            String keyId = "550e8400-e29b-41d4-a716-446655440000";
            SecretKeyNotAvailableException exception = new SecretKeyNotAvailableException("Error", keyId);

            assertEquals(keyId, exception.getKeyId());
        }
    }
}
