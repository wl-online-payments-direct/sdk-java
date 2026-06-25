package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.ApiException;
import com.onlinepayments.PlatformException;
import com.onlinepayments.domain.APIError;

class PlatformExceptionTest {

    @Nested
    class WhenCreatedWithDefaultMessage {

        @Test
        void shouldSetDefaultMessageAndProperties() {
            List<APIError> errors = Collections.emptyList();

            PlatformException exception = new PlatformException(
                    500,
                    "{\"error\":\"platform error\"}",
                    "error-id",
                    errors
            );

            assertInstanceOf(ApiException.class, exception);
            assertEquals(500, exception.getStatusCode());
            assertEquals("{\"error\":\"platform error\"}", exception.getResponseBody());
            assertEquals("error-id", exception.getErrorId());
            assertSame(errors, exception.getErrors());
            assertEquals(
                    "the payment platform returned an error response",
                    exception.getMessage()
            );
        }

        @Test
        void shouldNormalizeNullErrorsToEmptyList() {
            PlatformException exception = new PlatformException(
                    500,
                    "{\"error\":\"platform error\"}",
                    "error-id",
                    null
            );

            assertNotNull(exception.getErrors());
            assertEquals(0, exception.getErrors().size());
        }

        @Test
        void shouldPreserveNonEmptyErrors() {
            List<APIError> errors = new ArrayList<>();
            errors.add(new APIError().withMessage("payment failed"));

            PlatformException exception = new PlatformException(
                    500,
                    "{\"error\":\"platform error\"}",
                    "error-id",
                    errors
            );

            assertSame(errors, exception.getErrors());
            assertEquals(1, exception.getErrors().size());
            assertEquals("payment failed", exception.getErrors().get(0).getMessage());
        }
    }

    @Nested
    class WhenCreatedWithCustomMessage {

        @Test
        void shouldSetCustomMessageAndProperties() {
            List<APIError> errors = Collections.emptyList();

            PlatformException exception = new PlatformException(
                    "custom message",
                    500,
                    "{\"error\":\"platform error\"}",
                    "error-id",
                    errors
            );

            assertInstanceOf(ApiException.class, exception);
            assertEquals(500, exception.getStatusCode());
            assertEquals("{\"error\":\"platform error\"}", exception.getResponseBody());
            assertEquals("error-id", exception.getErrorId());
            assertSame(errors, exception.getErrors());
            assertEquals("custom message", exception.getMessage());
        }

        @Test
        void shouldNormalizeNullErrorsToEmptyList() {
            PlatformException exception = new PlatformException(
                    "custom message",
                    500,
                    "{\"error\":\"platform error\"}",
                    "error-id",
                    null
            );

            assertNotNull(exception.getErrors());
            assertEquals(0, exception.getErrors().size());
        }

        @Test
        void shouldPreserveNonEmptyErrors() {
            List<APIError> errors = new ArrayList<>();
            errors.add(new APIError().withMessage("payment failed"));

            PlatformException exception = new PlatformException(
                    "custom message",
                    500,
                    "{\"error\":\"platform error\"}",
                    "error-id",
                    errors
            );

            assertSame(errors, exception.getErrors());
            assertEquals(1, exception.getErrors().size());
            assertEquals("payment failed", exception.getErrors().get(0).getMessage());
        }
    }
}
