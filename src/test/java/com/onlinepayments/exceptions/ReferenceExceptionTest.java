package com.onlinepayments.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.onlinepayments.ApiException;
import com.onlinepayments.ReferenceException;
import com.onlinepayments.domain.APIError;

class ReferenceExceptionTest {

    @Nested
    class WhenCreatedWithDefaultMessage {

        @Test
        void shouldSetDefaultMessageAndProperties() {
            List<APIError> errors = Collections.emptyList();

            ReferenceException exception = new ReferenceException(
                    404,
                    "{\"error\":\"not found\"}",
                    "error-id",
                    errors
            );

            assertInstanceOf(ApiException.class, exception);
            assertEquals(404, exception.getStatusCode());
            assertEquals("{\"error\":\"not found\"}", exception.getResponseBody());
            assertEquals("error-id", exception.getErrorId());
            assertSame(errors, exception.getErrors());
            assertEquals(
                    "the payment platform returned a reference error response",
                    exception.getMessage()
            );
        }
    }

    @Nested
    class WhenCreatedWithCustomMessage {

        @Test
        void shouldSetCustomMessageAndProperties() {
            List<APIError> errors = Collections.emptyList();

            ReferenceException exception = new ReferenceException(
                    "custom message",
                    404,
                    "{\"error\":\"not found\"}",
                    "error-id",
                    errors
            );

            assertInstanceOf(ApiException.class, exception);
            assertEquals(404, exception.getStatusCode());
            assertEquals("{\"error\":\"not found\"}", exception.getResponseBody());
            assertEquals("error-id", exception.getErrorId());
            assertSame(errors, exception.getErrors());
            assertEquals("custom message", exception.getMessage());
        }
    }
}
