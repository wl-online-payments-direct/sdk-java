package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.ApiException;
import com.onlinepayments.IdempotenceException;
import com.onlinepayments.domain.APIError;

class IdempotenceExceptionTest {

    @Nested
    class WhenCreatedWithDefaultMessage {

        @Test
        void shouldSetDefaultMessageAndProperties() {
            List<APIError> errors = Collections.emptyList();

            IdempotenceException exception = new IdempotenceException(
                    "idempotence-key",
                    123456789L,
                    409,
                    "{\"error\":\"duplicate request\"}",
                    "error-id",
                    errors
            );

            assertInstanceOf(ApiException.class, exception);
            assertEquals(409, exception.getStatusCode());
            assertEquals("{\"error\":\"duplicate request\"}", exception.getResponseBody());
            assertEquals("error-id", exception.getErrorId());
            assertSame(errors, exception.getErrors());
            assertEquals("idempotence-key", exception.getIdempotenceKey());
            assertEquals(Long.valueOf(123456789L), exception.getIdempotenceRequestTimestamp());
            assertEquals(
                    "the payment platform returned a duplicate request error response",
                    exception.getMessage()
            );
        }

        @Test
        void shouldStoreNullIdempotenceKey() {
            IdempotenceException exception = new IdempotenceException(
                    null,
                    123456789L,
                    409,
                    "{\"error\":\"duplicate request\"}",
                    "error-id",
                    Collections.emptyList()
            );

            assertNull(exception.getIdempotenceKey());
        }

        @Test
        void shouldStoreNullIdempotenceRequestTimestamp() {
            IdempotenceException exception = new IdempotenceException(
                    "idempotence-key",
                    null,
                    409,
                    "{\"error\":\"duplicate request\"}",
                    "error-id",
                    Collections.emptyList()
            );

            assertNull(exception.getIdempotenceRequestTimestamp());
        }

        @Test
        void shouldNormalizeNullErrorsToEmptyList() {
            IdempotenceException exception = new IdempotenceException(
                    "idempotence-key",
                    123456789L,
                    409,
                    "{\"error\":\"duplicate request\"}",
                    "error-id",
                    null
            );

            assertNotNull(exception.getErrors());
            assertEquals(0, exception.getErrors().size());
        }

        @Test
        void shouldPreserveNonEmptyErrors() {
            List<APIError> errors = new ArrayList<>();
            errors.add(new APIError().withMessage("duplicate request detected"));

            IdempotenceException exception = new IdempotenceException(
                    "idempotence-key",
                    123456789L,
                    409,
                    "{\"error\":\"duplicate request\"}",
                    "error-id",
                    errors
            );

            assertSame(errors, exception.getErrors());
            assertEquals(1, exception.getErrors().size());
            assertEquals("duplicate request detected", exception.getErrors().get(0).getMessage());
        }
    }

    @Nested
    class WhenCreatedWithCustomMessage {

        @Test
        void shouldSetCustomMessageAndProperties() {
            List<APIError> errors = Collections.emptyList();

            IdempotenceException exception = new IdempotenceException(
                    "custom message",
                    "idempotence-key",
                    123456789L,
                    409,
                    "{\"error\":\"duplicate request\"}",
                    "error-id",
                    errors
            );

            assertInstanceOf(ApiException.class, exception);
            assertEquals(409, exception.getStatusCode());
            assertEquals("{\"error\":\"duplicate request\"}", exception.getResponseBody());
            assertEquals("error-id", exception.getErrorId());
            assertSame(errors, exception.getErrors());
            assertEquals("idempotence-key", exception.getIdempotenceKey());
            assertEquals(Long.valueOf(123456789L), exception.getIdempotenceRequestTimestamp());
            assertEquals("custom message", exception.getMessage());
        }

        @Test
        void shouldStoreNullIdempotenceKey() {
            IdempotenceException exception = new IdempotenceException(
                    "custom message",
                    null,
                    123456789L,
                    409,
                    "{\"error\":\"duplicate request\"}",
                    "error-id",
                    Collections.emptyList()
            );

            assertNull(exception.getIdempotenceKey());
        }

        @Test
        void shouldStoreNullIdempotenceRequestTimestamp() {
            IdempotenceException exception = new IdempotenceException(
                    "custom message",
                    "idempotence-key",
                    null,
                    409,
                    "{\"error\":\"duplicate request\"}",
                    "error-id",
                    Collections.emptyList()
            );

            assertNull(exception.getIdempotenceRequestTimestamp());
        }

        @Test
        void shouldNormalizeNullErrorsToEmptyList() {
            IdempotenceException exception = new IdempotenceException(
                    "custom message",
                    "idempotence-key",
                    123456789L,
                    409,
                    "{\"error\":\"duplicate request\"}",
                    "error-id",
                    null
            );

            assertNotNull(exception.getErrors());
            assertEquals(0, exception.getErrors().size());
        }
    }
}
